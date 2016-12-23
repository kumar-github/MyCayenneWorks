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

import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingUOMConversionsViewModel;

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
public class UOMConversionsMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String UOMCONVERSION_MAPPING_TYPE = "Q";

	@Inject
	private ExternalMappingUOMConversionsViewModel externalMappingUOMConversionsViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCommodityTextField;
	@FXML
	private ComboBox<Uom> toUOMCodeComboBox;
	@FXML
	private TextField toUOMConvRateTextField;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<Uom> observableUomsList = FXCollections.observableArrayList();

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
		ApplicationHelper.controllersMap.putInstance(UOMConversionsMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file UOMConversionsMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.toUOMCodeComboBox.setItems(this.observableUomsList);
		this.saveButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.toUOMCodeComboBox.valueProperty().isNull()).or(this.toUOMConvRateTextField.textProperty().isEmpty()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsUoms();
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

	private void fetchIctsUoms()
	{
		this.observableUomsList.clear();
		this.observableUomsList.addAll(CayenneReferenceDataCache.loadAllActiveUoms().values());
		LOGGER.debug("Uoms Count : {}", this.observableUomsList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveUOMConversionMapping();
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

	private void saveUOMConversionMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceCommodity = this.externalSourceCommodityTextField.getText().isEmpty() ? null : this.externalSourceCommodityTextField.getText().trim().toUpperCase();
		final String toUOMCode = this.toUOMCodeComboBox.getSelectionModel().getSelectedItem().getUomCode();
		final String toUOMConversionRate = this.toUOMConvRateTextField.getText().isEmpty() ? null : this.toUOMConvRateTextField.getText().trim().toUpperCase();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction();
				final Integer newNum = CayenneReferenceDataFetchUtil.generateNewNum();
				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", newNum);
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", UOMCONVERSION_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceCommodity);
				insertMappingQuery.param("externalValue2Param", null);
				insertMappingQuery.param("externalValue3Param", toUOMCode);
				insertMappingQuery.param("externalValue4Param", null);
				insertMappingQuery.param("aliasValueParam", toUOMConversionRate);
				insertMappingQuery.param("transIdParam", transid);
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingUOMConversionsTableView();
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

	private void refreshExternalMappingUOMConversionsTableView()
	{
		LOGGER.debug("ExternalMappingUOMConversionsViewModel Instance {}", this.externalMappingUOMConversionsViewModel);
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().clear();
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}