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
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingUOMConversionsViewModel;

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
public class UOMConversionsMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

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
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

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
		ApplicationHelper.controllersMap.putInstance(UOMConversionsMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file UOMConversionsMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.externalSourceCommodityTextField.setText(this.externalMappingUOMConversionsViewModel.selectedRecordProperty().get().getExternalValue1());
		this.toUOMCodeComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveUoms().get(this.externalMappingUOMConversionsViewModel.selectedRecordProperty().get().getExternalValue3()));
		this.toUOMConvRateTextField.setText(this.externalMappingUOMConversionsViewModel.selectedRecordProperty().get().getAliasValue());

		this.toUOMCodeComboBox.setItems(this.observableUomsList);
		this.updateButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.toUOMCodeComboBox.valueProperty().isNull()).or(this.toUOMConvRateTextField.textProperty().isEmpty()));
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
	}

	private void fetchIctsUoms()
	{
		this.observableUomsList.clear();
		this.observableUomsList.addAll(CayenneReferenceDataCache.loadAllActiveUoms().values());
		LOGGER.debug("Uoms Count : {}", this.observableUomsList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateUOMConversionMapping();
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

	private void updateUOMConversionMapping()
	{
		final String oldValue = this.externalMappingUOMConversionsViewModel.selectedRecordProperty().get().getAliasValue();
		final String toUOMConversionRate = this.toUOMConvRateTextField.getText().isEmpty() ? null : this.toUOMConvRateTextField.getText().trim().toUpperCase();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, toUOMConversionRate);
		}

		if(oldValue.equals(toUOMConversionRate))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingUOMConversionsViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", toUOMConversionRate);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingUOMConversionsTableView();
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

	private void refreshExternalMappingUOMConversionsTableView()
	{
		LOGGER.debug("ExternalMappingUOMConversionsViewModel Instance {}", this.externalMappingUOMConversionsViewModel);
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().clear();
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}