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
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCompaniesViewModel;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class CompaniesMappingAddPopupController implements Initializable
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

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
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

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(CompaniesMappingAddPopupController.class, this);
	}

	private void doAssertion()
	{
		assert this.externalSourceCompanyTextField != null : "fx:id=\"externalSourceCompanyTextField\" was not injected. Check your FXML file CompaniesMappingAddPopupView.fxml";
	}

	private void doInitialDataBinding()
	{
		this.companyCountryComboBox.setItems(this.observableCompanyCountriesList);
		this.ictsCompanyComboBox.setItems(this.sortedIctsCompaniesList);
		this.saveButton.disableProperty().bind(this.externalSourceCompanyTextField.textProperty().isEmpty().or(this.companyTypeComboBox.valueProperty().isNull()).or(this.companyCountryComboBox.valueProperty().isNull()).or(this.ictsCompanyComboBox.valueProperty().isNull()));
	}

	private void initializeGUI()
	{
		this.fetchCountries();

		/* By companies we mean Accounts of type "'CUSTOMER" or "PEICOMP". */
		this.fetchCompanies();
	}

	private void setAnyUIComponentStateIfNeeded()
	{
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	private void createListeners()
	{
		this.companyTypeComboBoxChangeListener = (observableValue, oldValue, newValue) -> {
			this.handleCompanyTypeComboBoxSelectionChange(newValue);
		};
	}

	private void attachListeners()
	{
		this.companyTypeComboBox.valueProperty().addListener(this.companyTypeComboBoxChangeListener);
		this.externalSourceCompanyTextField.textProperty().addListener((observable, oldValue, newValue) -> this.doThis(newValue));
	}

	private void doThis(final String newValue)
	{
		this.externalSourceCompanyTextField.setText(newValue.toUpperCase());
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

		/*
		final Session session = HibernateUtil.beginTransaction();
		final Criteria criteria = session.createCriteria(com.tc.app.exchangemonitor.model.Country.class);
		criteria.add(Restrictions.isNotNull("isoCountryCode"));
		criteria.setProjection(Projections.groupProperty("isoCountryCode"));
		criteria.setProjection(Projections.groupProperty("countryName"));
		this.observableCompanyCountriesList.clear();
		final long startTime = System.currentTimeMillis();
		this.observableCompanyCountriesList.addAll(criteria.list());
		final long endTime = System.currentTimeMillis();
		session.close();
		LOGGER.info("It took " + (endTime - startTime) + " millsecs to fetch " + this.observableCompanyCountriesList.size() + " Countries.");
		 */
	}

	private void fetchCompanies()
	{
		this.observableIctsCompaniesList.clear();
		this.observableIctsCompaniesList.addAll(CayenneReferenceDataCache.loadAllActiveAccounts().values());
		LOGGER.debug("Companies Count : " + this.observableIctsCompaniesList.size());

		/*
		final Session session = HibernateUtil.beginTransaction();
		final Criteria criteria = session.createCriteria(com.tc.app.exchangemonitor.model.Account.class);
		criteria.add(Restrictions.eq("acctStatus", 'A'));
		criteria.setFetchMode("acctTypeCode", FetchMode.JOIN);
		this.observableIctsCompaniesList.clear();
		final long startTime = System.currentTimeMillis();
		this.observableIctsCompaniesList.addAll(criteria.list());
		final long endTime = System.currentTimeMillis();
		session.close();
		LOGGER.info("It took " + (endTime - startTime) + " millsecs to fetch " + this.observableIctsCompaniesList.size() + " Companies.");
		 */
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
		final String companyCountry = this.companyCountryComboBox.getSelectionModel().getSelectedItem().getCountryName().trim().toUpperCase();
		final String ictsCompany = this.ictsCompanyComboBox.getSelectionModel().getSelectedItem().getAcctShortName().trim().toUpperCase();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction();
				final Integer newNum = CayenneReferenceDataFetchUtil.generateNewNum();
				//session.getNamedQuery("InsertNewMapping").setParameter("oidParam", newNum).setParameter("externalTradeSourceOidParam", externalTradeSourceOid).setParameter("mappingTypeParam", BROKER_MAPPING_TYPE).setParameter("externalValue1Param", externalSourceBroker).setParameter("externalValue2Param", brokerType).setParameter("externalValue3Param", externalSourceTrader).setParameter("externalValue4Param", externalSourceAccount).setParameter("aliasValueParam", ictsBroker).setParameter("transIdParam", transid).executeUpdate();
				MappedExec.query("InsertNewMapping").param("oidParam", newNum).param("externalTradeSourceOidParam", externalTradeSourceOid).param("mappingTypeParam", COMPANY_MAPPING_TYPE).param("externalValue1Param", externalSourceCompany).param("externalValue2Param", companyType).param("externalValue3Param", null).param("externalValue4Param", companyCountry).param("aliasValueParam", ictsCompany).param("transIdParam", transid).execute(CayenneHelper.getCayenneServerRuntime().newContext());

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
			LOGGER.error("Save Failed." + exception);
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

	private void refreshExternalMappingCompaniesTableView()
	{
		LOGGER.debug("ExternalMappingCompaniesViewModel Instance {}", this.externalMappingCompaniesViewModel);
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().clear();
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}