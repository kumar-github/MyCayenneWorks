/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 17, 2016
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.cayenne.query.MappedExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTemplateTradesViewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class TemplateTradesMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String TEMPLATE_TRADE_MAPPING_TYPE = "S";

	@Inject
	private ExternalMappingTemplateTradesViewModel externalMappingTemplateTradesViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCommodityTextField;
	@FXML
	private ComboBox<Trade> ictsTemplateTradeComboBox;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<Trade> observableIctsTemplateTradesList = FXCollections.observableArrayList();

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.setAnyUIComponentStateIfNeeded();
		this.createListeners();
		this.attachListeners();
	}

	@Override
	public void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(TemplateTradesMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file TemplateTradesMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.ictsTemplateTradeComboBox.setItems(this.observableIctsTemplateTradesList);
		this.saveButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.ictsTemplateTradeComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsTemplateTrades();
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	@Override
	public void createListeners()
	{
	}

	@Override
	public void attachListeners()
	{
		this.externalSourceCommodityTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceCommodityTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void fetchIctsTemplateTrades()
	{
		this.observableIctsTemplateTradesList.clear();
		//this.observableIctsTemplateTradesList.addAll(CayenneReferenceDataCache.fetchAllTemplateTrades().values());
		this.observableIctsTemplateTradesList.addAll(this.filter(CayenneReferenceDataCache.loadAllTemplateTrades().values(), (final Trade aTrade) -> !aTrade.getTradeStatus().getTradeStatusCode().trim().equals("DELETE")));
		LOGGER.debug("Template Trades Count {}", this.observableIctsTemplateTradesList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveTemplateTradeMapping();
	}

	@FXML
	private void handleCancelButtonClick()
	{
		this.closePopup();
	}

	private void closePopup()
	{
		((Stage) this.cancelButton.getScene().getWindow()).close();
	}

	private void saveTemplateTradeMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceCommodity = this.externalSourceCommodityTextField.getText().isEmpty() ? null : this.externalSourceCommodityTextField.getText().trim().toUpperCase();
		final String ictsTemplateTrade = this.ictsTemplateTradeComboBox.getSelectionModel().getSelectedItem().getTradeNum().toString();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction();
				final Integer newNum = CayenneReferenceDataFetchUtil.generateNewNum();
				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", newNum);
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", TEMPLATE_TRADE_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceCommodity);
				insertMappingQuery.param("externalValue2Param", null);
				insertMappingQuery.param("externalValue3Param", null);
				insertMappingQuery.param("externalValue4Param", null);
				insertMappingQuery.param("aliasValueParam", ictsTemplateTrade);
				insertMappingQuery.param("transIdParam", transid);
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingTemplateTradesTableView();
			}
			else
			{
				LOGGER.error("Mapping Already Exists!");
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Save Failed.", exception);
			throw new RuntimeException("Save Failed.", exception);
		}
		finally
		{
		}
	}

	private Integer getOidForExternalSourceName(final String externalTradeSourceName)
	{
		return ReferenceDataCache.fetchExternalTradeSources().get(externalTradeSourceName).getOid();
	}

	private void refreshExternalMappingTemplateTradesTableView()
	{
		LOGGER.debug("ExternalMappingTemplateTradesViewModel Instance {}", this.externalMappingTemplateTradesViewModel);
		this.externalMappingTemplateTradesViewModel.getExternalMappingTemplateTradesObservableList().clear();
		this.externalMappingTemplateTradesViewModel.getExternalMappingTemplateTradesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}