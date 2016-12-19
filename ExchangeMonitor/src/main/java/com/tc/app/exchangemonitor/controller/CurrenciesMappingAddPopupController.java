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
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCurrenciesViewModel;

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
public class CurrenciesMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String CURRENCY_MAPPING_TYPE = "U";

	@Inject
	private ExternalMappingCurrenciesViewModel externalMappingCurrenciesViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCurrencyTextField;
	@FXML
	private ComboBox<Commodity> ictsCurrencyComboBox;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

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
		ApplicationHelper.controllersMap.putInstance(CurrenciesMappingAddPopupController.class, this);
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
		this.saveButton.disableProperty().bind(this.externalSourceCurrencyTextField.textProperty().isEmpty().or(this.ictsCurrencyComboBox.valueProperty().isNull()));
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
		//this.observableIctsCurrencyList.addAll(CayenneReferenceDataCache.loadAllActiveCommodities().values());
		//this.observableIctsCurrencyList.addAll(this.filter(CayenneReferenceDataCache.loadAllActiveCommodities().values(), (aCommodity) -> aCommodity.getCommodityType().getCommodityTypeCode().equals("C")));
		this.observableIctsCurrencyList.addAll(CayenneReferenceDataCache.loadAllActiveCurrencies().values());
		LOGGER.debug("Currencies Count {}", this.observableIctsCurrencyList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveCurrencyMapping();
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

	private void saveCurrencyMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceCurrency = this.externalSourceCurrencyTextField.getText().isEmpty() ? null : this.externalSourceCurrencyTextField.getText().trim();
		final String ictsCurrency = this.ictsCurrencyComboBox.getSelectionModel().getSelectedItem().getCmdtyCode();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", CayenneReferenceDataFetchUtil.generateNewNum());
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", CURRENCY_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceCurrency);
				insertMappingQuery.param("externalValue2Param", null);
				insertMappingQuery.param("externalValue3Param", null);
				insertMappingQuery.param("externalValue4Param", null);
				insertMappingQuery.param("aliasValueParam", ictsCurrency);
				insertMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingCurrenciesTableView();
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

	private void refreshExternalMappingCurrenciesTableView()
	{
		LOGGER.debug("ExternalMappingCurrenciesViewModel Instance {}", this.externalMappingCurrenciesViewModel);
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().clear();
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}