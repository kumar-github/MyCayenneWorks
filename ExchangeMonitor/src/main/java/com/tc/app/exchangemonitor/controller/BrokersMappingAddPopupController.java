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
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingBrokersViewModel;

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
public class BrokersMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String BROKER_MAPPING_TYPE = "B";

	@Inject
	private ExternalMappingBrokersViewModel externalMappingBrokersViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceBrokerTextField;
	@FXML
	private ComboBox<String> brokerTypeComboBox;
	@FXML
	private TextField externalSourceTraderTextField;
	@FXML
	private TextField externalSourceAccountTextField;
	@FXML
	private ComboBox<Account> ictsBrokerComboBox;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<Account> observableBrokersList = FXCollections.observableArrayList();
	private final FilteredList<Account> filteredBrokersList = new FilteredList<>(this.observableBrokersList, null);
	private final SortedList<Account> sortedBrokersList = new SortedList<>(this.filteredBrokersList);

	/* Listener Variables */
	private ChangeListener<String> brokerTypeComboBoxChangeListener = null;

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
		ApplicationHelper.controllersMap.putInstance(BrokersMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceBrokerTextField != null : "fx:id=\"externalSourceBrokerTextField\" was not injected. Check your FXML file BrokersMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.ictsBrokerComboBox.setItems(this.sortedBrokersList);
		this.saveButton.disableProperty().bind(this.externalSourceBrokerTextField.textProperty().isEmpty().or(this.brokerTypeComboBox.valueProperty().isNull()).or(this.externalSourceTraderTextField.textProperty().isEmpty()).or(this.externalSourceAccountTextField.textProperty().isEmpty()).or(this.ictsBrokerComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsBrokers();
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	@Override
	public void createListeners()
	{
		this.brokerTypeComboBoxChangeListener = (observableValue, oldValue, newValue) -> {
			this.handleBrokerTypeComboBoxSelectionChange(newValue);
		};
	}

	@Override
	public void attachListeners()
	{
		this.brokerTypeComboBox.valueProperty().addListener(this.brokerTypeComboBoxChangeListener);
		this.externalSourceBrokerTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceBrokerTextField, newValue));
		this.externalSourceTraderTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceTraderTextField, newValue));
		this.externalSourceAccountTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceAccountTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void handleBrokerTypeComboBoxSelectionChange(final String newValue)
	{
		/* We are here bcoz user change the broker type, so lets change the brokers respectively. */
		if(newValue.equals("EXCHANGE"))
		{
			LOGGER.debug("Before Applying any Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate(null);
			LOGGER.debug("After Clearing Existing Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate((anAccount) -> anAccount.getAccountType().getAccountTypeCode().trim().equals("EXCHBRKR") || anAccount.getAccountType().getAccountTypeCode().trim().equals("FLRBRKR"));
			LOGGER.debug("After Applying new Predicate : " + this.filteredBrokersList.size());
		}
		else if(newValue.equals("OTC"))
		{
			LOGGER.debug("Before Applying any Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate(null);
			LOGGER.debug("After Clearing Existing Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate((anAccount) -> anAccount.getAccountType().getAccountTypeCode().trim().equals("BROKER"));
			LOGGER.debug("After Applying new Predicate : " + this.filteredBrokersList.size());
		}
		else if(newValue.equals("CLEARING"))
		{
			LOGGER.debug("Before Applying any Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate(null);
			LOGGER.debug("After Clearing Existing Predicate : " + this.filteredBrokersList.size());
			this.filteredBrokersList.setPredicate((anAccount) -> anAccount.getAccountType().getAccountTypeCode().trim().equals("EXCHBRKR"));
			LOGGER.debug("After Applying new Predicate : " + this.filteredBrokersList.size());
		}
	}

	private void fetchIctsBrokers()
	{
		this.observableBrokersList.clear();
		this.observableBrokersList.addAll(CayenneReferenceDataCache.loadAllActiveAccounts().values());
		LOGGER.debug("Brokers Count : {}", this.observableBrokersList.size());
		/*
		final Session session = HibernateUtil.beginTransaction();
		final Criteria criteria = session.createCriteria(com.tc.app.exchangemonitor.model.Account.class);
		criteria.add(Restrictions.eq("acctStatus", 'A'));
		//criteria.setFetchMode("acctTypeCode", FetchMode.JOIN).createAlias("acctTypeCode", "acctTypeCodeAlias").add(Restrictions.in("acctTypeCodeAlias.acctTypeCode", "EXCHBRKR", "FLRBRKR"));
		criteria.setFetchMode("acctTypeCode", FetchMode.JOIN);
		final long startTime = System.currentTimeMillis();
		this.observableBrokersList.clear();
		//this.observableBrokersList.addAll(criteria.list());
		final List<Account> ictsBrokers = criteria.list();
		this.observableBrokersList.addAll(ictsBrokers);
		final long endTime = System.currentTimeMillis();
		session.close();
		LOGGER.info("It took " + (endTime - startTime) + " millsecs to fetch " + this.observableBrokersList.size() + " Brokers.");
		 */

		/* The below code added to solve "org.hibernate.LazyInitializationException: could not initialize proxy - no Session"
		 * 3 ways to solve the problem.
		 * solution1: add the below property and set the value to true
		 * solution2: change the fetch type from LAZY to EAGER for the particular property. In our case it is acctTypeCode from Account class.
		 * solution3: otherwise once the main object(Account) is fetched, loop through each object and call Hibernate.initialize(accountObject.getAcctTypeCode)
		 */
		//ictsBrokers.stream().forEach((aBroker) -> Hibernate.initialize(aBroker.getAcctTypeCode()));
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveBrokerMapping();
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

	private void saveBrokerMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceBroker = this.externalSourceBrokerTextField.getText().isEmpty() ? null : this.externalSourceBrokerTextField.getText().trim().toUpperCase();
		final String brokerType = this.brokerTypeComboBox.getSelectionModel().getSelectedItem();
		final String externalSourceTrader = this.externalSourceTraderTextField.getText().isEmpty() ? null : this.externalSourceTraderTextField.getText().trim().toUpperCase();
		final String externalSourceAccount = this.externalSourceAccountTextField.getText().isEmpty() ? null : this.externalSourceAccountTextField.getText().trim().toUpperCase();
		//final String ictsBroker = this.ictsBrokerComboBox.getSelectionModel().getSelectedItem().getAcctShortName();
		final String ictsBroker = this.ictsBrokerComboBox.getSelectionModel().getSelectedItem().getAccountNum().toString();

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
				insertMappingQuery.param("mappingTypeParam", BROKER_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceBroker);
				insertMappingQuery.param("externalValue2Param", brokerType);
				insertMappingQuery.param("externalValue3Param", externalSourceTrader);
				insertMappingQuery.param("externalValue4Param", externalSourceAccount);
				insertMappingQuery.param("aliasValueParam", ictsBroker);
				insertMappingQuery.param("transIdParam", transid);
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingTradersTableView();
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

	private void refreshExternalMappingTradersTableView()
	{
		LOGGER.debug("ExternalMappingBrokersViewModel Instance {}", this.externalMappingBrokersViewModel);
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().clear();
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}