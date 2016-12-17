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
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTemplateTradesViewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class TemplateTradesMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingTemplateTradesViewModel externalMappingTemplateTradesViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCommodityTextField;
	@FXML
	private ComboBox<Trade> ictsTemplateTradeComboBox;
	@FXML
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

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
		ApplicationHelper.controllersMap.putInstance(TemplateTradesMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file TemplateTradesMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.externalSourceCommodityTextField.setText(this.externalMappingTemplateTradesViewModel.selectedRecordProperty().get().getExternalValue1());
		this.ictsTemplateTradeComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllTemplateTrades().get(this.externalMappingTemplateTradesViewModel.selectedRecordProperty().get().getAliasValue()));

		this.ictsTemplateTradeComboBox.setItems(this.observableIctsTemplateTradesList);
		this.updateButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.ictsTemplateTradeComboBox.valueProperty().isNull()));
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
	}

	private void fetchIctsTemplateTrades()
	{
		this.observableIctsTemplateTradesList.clear();
		//this.observableIctsTemplateTradesList.addAll(CayenneReferenceDataCache.fetchAllTemplateTrades().values());
		this.observableIctsTemplateTradesList.addAll(this.filter(CayenneReferenceDataCache.loadAllTemplateTrades().values(), (final Trade aTrade) -> !aTrade.getTradeStatus().getTradeStatusCode().trim().equals("DELETE")));
		LOGGER.debug("Template Trades Count {}", this.observableIctsTemplateTradesList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateTemplateTradeMapping();
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

	private void updateTemplateTradeMapping()
	{
		final String oldValue = this.externalMappingTemplateTradesViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsTemplateTrade = this.ictsTemplateTradeComboBox.getSelectionModel().getSelectedItem().getTradeNum().toString();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsTemplateTrade);
		}

		if(oldValue.equals(ictsTemplateTrade))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingTemplateTradesViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsTemplateTrade);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingTemplateTradesTableView();
			}
			else
			{
				LOGGER.error("Mapping Update Failed!");
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Update Failed.", exception);
			throw new RuntimeException("Update Failed.", exception);
		}
		finally
		{
		}
	}

	private void refreshExternalMappingTemplateTradesTableView()
	{
		LOGGER.debug("ExternalMappingTemplateTradesViewModel Instance {}", this.externalMappingTemplateTradesViewModel);
		this.externalMappingTemplateTradesViewModel.getExternalMappingTemplateTradesObservableList().clear();
		this.externalMappingTemplateTradesViewModel.getExternalMappingTemplateTradesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}