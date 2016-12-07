/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 17, 2016
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.HibernateReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.HibernateUtil;
import com.tc.app.exchangemonitor.util.ReferenceDataCache;

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
public class BrokersMappingAddPopupController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger(BrokersMappingAddPopupController.class);
	private static final String BROKER_MAPPING_TYPE = "B";

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
		ApplicationHelper.controllersMap.putInstance(BrokersMappingAddPopupController.class, this);
	}

	private void doAssertion()
	{
		assert this.externalSourceBrokerTextField != null : "fx:id=\"externalSourceBrokerTextField\" was not injected. Check your FXML file BrokersMappingAddPopupView.fxml";
	}

	private void doInitialDataBinding()
	{
		this.ictsBrokerComboBox.setItems(this.sortedBrokersList);
		this.saveButton.disableProperty().bind(this.externalSourceBrokerTextField.textProperty().isEmpty().or(this.brokerTypeComboBox.valueProperty().isNull()).or(this.externalSourceTraderTextField.textProperty().isEmpty()).or(this.externalSourceAccountTextField.textProperty().isEmpty()).or(this.ictsBrokerComboBox.valueProperty().isNull()));
	}

	private void initializeGUI()
	{
		this.fetchIctsBrokers();
	}

	private void setAnyUIComponentStateIfNeeded()
	{
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	private void createListeners()
	{
		this.brokerTypeComboBoxChangeListener = (observableValue, oldValue, newValue) -> {
			this.handleBrokerTypeComboBoxSelectionChange(newValue);
		};
	}

	private void attachListeners()
	{
		this.brokerTypeComboBox.valueProperty().addListener(this.brokerTypeComboBoxChangeListener);
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
		//this.observableBrokersList.clear();
		//this.observableBrokersList.addAll(ReferenceDataCache.fetchAllActiveAccounts().values());

		this.observableBrokersList.clear();
		this.observableBrokersList.addAll(CayenneReferenceDataCache.loadAllActiveAccounts().values());
		LOGGER.debug("Brokers Count : " + this.observableBrokersList.size());
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

	private void saveBrokerMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceBroker = this.externalSourceBrokerTextField.getText().isEmpty() ? null : this.externalSourceBrokerTextField.getText().trim().toUpperCase();
		final String brokerType = this.brokerTypeComboBox.getSelectionModel().getSelectedItem();
		final String externalSourceTrader = this.externalSourceTraderTextField.getText().isEmpty() ? null : this.externalSourceTraderTextField.getText().trim().toUpperCase();
		final String externalSourceAccount = this.externalSourceAccountTextField.getText().isEmpty() ? null : this.externalSourceAccountTextField.getText().trim().toUpperCase();
		final String ictsBroker = this.ictsBrokerComboBox.getSelectionModel().getSelectedItem().getAcctShortName();
		Session session = null;

		//final boolean doesBrokerMappingExistsAlready = this.doesBrokerMappingExistsAlready(externalSourceBroker, brokerType, externalSourceTrader, externalSourceAccount);
		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				session = HibernateUtil.beginTransaction();
				final Integer transid = HibernateReferenceDataFetchUtil.generateNewTransaction();
				final Integer newNum = HibernateReferenceDataFetchUtil.generateNewNum();
				session.getNamedQuery("InsertNewMapping").setParameter("oidParam", newNum).setParameter("externalTradeSourceOidParam", externalTradeSourceOid).setParameter("mappingTypeParam", BROKER_MAPPING_TYPE).setParameter("externalValue1Param", externalSourceBroker).setParameter("externalValue2Param", brokerType).setParameter("externalValue3Param", externalSourceTrader).setParameter("externalValue4Param", externalSourceAccount).setParameter("aliasValueParam", ictsBroker).setParameter("transIdParam", transid).executeUpdate();
				session.getTransaction().commit();
				LOGGER.info("Mapping Saved Successfully.");
			}
			else
			{
				LOGGER.error("Mapping Already Exists!");
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Save Failed." + exception);
			session.getTransaction().rollback();
			throw new RuntimeException("Save Failed.", exception);
		}
		finally
		{
			if((session != null) && session.isOpen())
			{
				if((session.getTransaction() != null) && (session.getTransaction().getStatus() == TransactionStatus.ACTIVE))
				{
					session.getTransaction().commit();//This is mandatory - to avoid DB locking
					//session.close();
				}
			}
		}
	}

	/*
	private boolean doesBrokerMappingExistsAlready(final String externalSourceBroker, final String brokerType, final String externalSourceTrader, final String externalSourceAccount)
	{
		boolean doesExists = false;
		Session session = null;
		List aMapping = null;

		try
		{
			session = HibernateUtil.beginTransaction();
			aMapping = session.getNamedQuery("DoesMappingExists").setParameter("externalTradeSourceOidParam", 1).setParameter("mappingTypeParam", BROKER_MAPPING_TYPE).setParameter("externalValue1Param", externalSourceBroker).setParameter("externalValue2Param", brokerType).setParameter("externalValue3Param", externalSourceTrader).setParameter("externalValue4Param", externalSourceAccount).list();
			System.out.println(aMapping);
			doesExists = (aMapping == null) ? false : true;
		}
		catch(final Exception exception)
		{
		}
		finally
		{
			session.close();
		}

		return doesExists;
	}
	 */

	private Integer getOidForExternalSourceName(final String externalTradeSourceName)
	{
		return ReferenceDataCache.fetchExternalTradeSources().get(externalTradeSourceName).getOid();
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveBrokerMapping();
	}

	@FXML
	private void handleCancelButtonClick()
	{
		((Stage) this.cancelButton.getScene().getWindow()).close();
	}
}