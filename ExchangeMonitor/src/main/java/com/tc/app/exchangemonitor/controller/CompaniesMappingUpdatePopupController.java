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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
public class CompaniesMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

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
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

	private final ObservableList<Country> observableCompanyCountriesList = FXCollections.observableArrayList();

	private final ObservableList<Account> observableIctsCompaniesList = FXCollections.observableArrayList();
	private final FilteredList<Account> filteredIctsCompaniesList = new FilteredList<>(this.observableIctsCompaniesList, null);
	private final SortedList<Account> sortedIctsCompaniesList = new SortedList<>(this.filteredIctsCompaniesList);


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
		ApplicationHelper.controllersMap.putInstance(CompaniesMappingUpdatePopupController.class, this);
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

		this.externalSourceCompanyTextField.setText(this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getExternalValue1());
		this.companyTypeComboBox.getSelectionModel().select(this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getExternalValue2());

		//this.companyCountryComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveCountries().get(this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getExternalValue4()));
		this.companyCountryComboBox.getSelectionModel().select(CayenneReferenceDataCache.getCountryForISOCode(this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getExternalValue4()));

		this.ictsCompanyComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveAccounts().get(Integer.parseInt(this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getAliasValue())));

		//this.updateButton.disableProperty().bind(this.externalSourceCompanyTextField.textProperty().isEmpty().or(this.companyTypeComboBox.valueProperty().isNull()).or(this.companyCountryComboBox.valueProperty().isNull()).or(this.ictsCompanyComboBox.valueProperty().isNull()));
		this.updateButton.disableProperty().bind(this.externalSourceCompanyTextField.textProperty().isEmpty().or(this.companyTypeComboBox.valueProperty().isNull()).or(this.ictsCompanyComboBox.valueProperty().isNull()));
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
	}

	@Override
	public void attachListeners()
	{
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
	private void handleUpdateButtonClick()
	{
		this.updateCompanyMapping();
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

	private void updateCompanyMapping()
	{
		final String oldValue = this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsCompany = this.ictsCompanyComboBox.getSelectionModel().getSelectedItem().getAccountNum().toString();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsCompany);
		}

		if(oldValue.equals(ictsCompany))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingCompaniesViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesCompanyMappingExistsAlready = false;

		try
		{
			if(!doesCompanyMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsCompany);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingCompaniesTableView();
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

	private void refreshExternalMappingCompaniesTableView()
	{
		LOGGER.debug("ExternalMappingCompaniesViewModel Instance {}", this.externalMappingCompaniesViewModel);
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().clear();
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}