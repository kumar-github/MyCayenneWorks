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

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCurrenciesViewModel;

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
public class CurrenciesMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingCurrenciesViewModel externalMappingCurrenciesViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCurrencyTextField;
	@FXML
	private ComboBox<Commodity> ictsCurrencyComboBox;
	@FXML
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

	private final ObservableList<Commodity> observableIctsCurrencyList = FXCollections.observableArrayList();

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
		ApplicationHelper.controllersMap.putInstance(CurrenciesMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCurrencyTextField != null : "fx:id=\"externalSourceCurrencyTextField\" was not injected. Check your FXML file CurrenciesMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.ictsCurrencyComboBox.setItems(this.observableIctsCurrencyList);

		this.externalSourceCurrencyTextField.setText(this.externalMappingCurrenciesViewModel.selectedRecordProperty().get().getExternalValue1());
		this.ictsCurrencyComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveCurrencies().get(this.externalMappingCurrenciesViewModel.selectedRecordProperty().get().getAliasValue()));

		this.updateButton.disableProperty().bind(this.externalSourceCurrencyTextField.textProperty().isEmpty().or(this.ictsCurrencyComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsCurrencies();
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
		this.externalSourceCurrencyTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceCurrencyTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void fetchIctsCurrencies()
	{
		this.observableIctsCurrencyList.clear();
		this.observableIctsCurrencyList.addAll(CayenneReferenceDataCache.loadAllActiveCommodities().values());
		LOGGER.debug("Currencies Count {}", this.observableIctsCurrencyList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateCurrencyMapping();
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

	private void updateCurrencyMapping()
	{
		final String oldValue = this.externalMappingCurrenciesViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsCurrency = this.ictsCurrencyComboBox.getSelectionModel().getSelectedItem().getCmdtyCode();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsCurrency);
		}

		if(oldValue.equals(ictsCurrency))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingCurrenciesViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsCurrency);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingCurrenciesTableView();
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

	private void refreshExternalMappingCurrenciesTableView()
	{
		LOGGER.debug("ExternalMappingCurrenciesViewModel Instance {}", this.externalMappingCurrenciesViewModel);
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().clear();
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}