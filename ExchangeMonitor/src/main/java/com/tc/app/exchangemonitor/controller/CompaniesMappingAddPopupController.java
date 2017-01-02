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

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Country;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCompaniesViewModel;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
public class CompaniesMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String COMPANY_MAPPING_TYPE = "C";

	@Inject
	private ExternalMappingCompaniesViewModel externalMappingCompaniesViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCompanyTextField;
	@FXML
	private ComboBox<String> companyTypeComboBox;
	@FXML
	private ComboBox<Country> companyCountryComboBox;
	@FXML
	private ComboBox<Account> ictsCompanyComboBox;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<Country> observableCompanyCountriesList = FXCollections.observableArrayList();

	private final ObservableList<Account> observableIctsCompaniesList = FXCollections.observableArrayList();
	private final FilteredList<Account> filteredIctsCompaniesList = new FilteredList<>(this.observableIctsCompaniesList, null);
	private final SortedList<Account> sortedIctsCompaniesList = new SortedList<>(this.filteredIctsCompaniesList);

	/* Listener Variables */
	private ChangeListener<String> companyTypeComboBoxChangeListener = null;

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
		ApplicationHelper.controllersMap.putInstance(CompaniesMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCompanyTextField != null : "fx:id=\"externalSourceCompanyTextField\" was not injected. Check your FXML file CompaniesMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.companyCountryComboBox.setItems(this.observableCompanyCountriesList);
		this.ictsCompanyComboBox.setItems(this.sortedIctsCompaniesList);
		this.saveButton.disableProperty().bind(this.externalSourceCompanyTextField.textProperty().isEmpty().or(this.companyTypeComboBox.valueProperty().isNull()).or(this.companyCountryComboBox.valueProperty().isNull()).or(this.ictsCompanyComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchCountries();

		/* By companies we mean Accounts of type "'CUSTOMER" or "PEICOMP". */
		this.fetchCompanies();
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	@Override
	public void createListeners()
	{
		this.companyTypeComboBoxChangeListener = (observableValue, oldValue, newValue) -> {
			this.handleCompanyTypeComboBoxSelectionChange(newValue);
		};
	}

	@Override
	public void attachListeners()
	{
		this.companyTypeComboBox.valueProperty().addListener(this.companyTypeComboBoxChangeListener);
		this.externalSourceCompanyTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceCompanyTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void handleCompanyTypeComboBoxSelectionChange(final String newValue)
	{
		if(newValue.equals("CUSTOMER"))
		{
			LOGGER.debug("Before Applying any Predicate : " + this.filteredIctsCompaniesList.size());
			this.filteredIctsCompaniesList.setPredicate(null);
			LOGGER.debug("After Clearing Existing Predicate : " + this.filteredIctsCompaniesList.size());
			this.filteredIctsCompaniesList.setPredicate((anAccount) -> anAccount.getAccountType().getAccountTypeCode().trim().equals("CUSTOMER"));
			LOGGER.debug("After Applying new Predicate : " + this.filteredIctsCompaniesList.size());
		}
		else if(newValue.equals("BOOKING COMPANY"))
		{
			LOGGER.debug("Before Applying any Predicate : " + this.filteredIctsCompaniesList.size());
			this.filteredIctsCompaniesList.setPredicate(null);
			LOGGER.debug("After Clearing Existing Predicate : " + this.filteredIctsCompaniesList.size());
			this.filteredIctsCompaniesList.setPredicate((anAccount) -> anAccount.getAccountType().getAccountTypeCode().trim().equals("PEICOMP"));
			LOGGER.debug("After Applying new Predicate : " + this.filteredIctsCompaniesList.size());
		}
	}

	private void fetchCountries()
	{
		this.observableCompanyCountriesList.clear();
		this.observableCompanyCountriesList.addAll(CayenneReferenceDataCache.loadAllActiveCountries().values());
		LOGGER.debug("Countries Count : {}", this.observableCompanyCountriesList.size());
	}

	private void fetchCompanies()
	{
		this.observableIctsCompaniesList.clear();
		this.observableIctsCompaniesList.addAll(CayenneReferenceDataCache.loadAllActiveAccounts().values());
		LOGGER.debug("Companies Count : " + this.observableIctsCompaniesList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveCompanyMapping();
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

	private void saveCompanyMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceCompany = this.externalSourceCompanyTextField.getText().isEmpty() ? null : this.externalSourceCompanyTextField.getText().trim().toUpperCase();
		final String companyType = this.companyTypeComboBox.getSelectionModel().getSelectedItem();
		//final String companyCountryCode = this.companyCountryComboBox.getSelectionModel().getSelectedItem().getCountryCode();
		final String companyCountryCode = this.companyCountryComboBox.getSelectionModel().getSelectedItem().getIsoCountryCode();
		final String ictsCompany = this.ictsCompanyComboBox.getSelectionModel().getSelectedItem().getAccountNum().toString();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
				final Integer newNum = CayenneReferenceDataFetchUtil.generateNewNum("external_mapping_oid", 0);

				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", newNum);
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", COMPANY_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceCompany);
				insertMappingQuery.param("externalValue2Param", companyType);
				insertMappingQuery.param("externalValue3Param", null);
				insertMappingQuery.param("externalValue4Param", companyCountryCode);
				insertMappingQuery.param("aliasValueParam", ictsCompany);
				insertMappingQuery.param("transIdParam", transid);
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingCompaniesTableView();
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
		//return ReferenceDataCache.fetchExternalTradeSources().get(externalTradeSourceName).getOid();
		return CayenneReferenceDataCache.loadExternalTradeSources().get(externalTradeSourceName).getExternalTradeSourceOid();
	}

	private void refreshExternalMappingCompaniesTableView()
	{
		LOGGER.debug("ExternalMappingCompaniesViewModel Instance {}", this.externalMappingCompaniesViewModel);
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().clear();
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}