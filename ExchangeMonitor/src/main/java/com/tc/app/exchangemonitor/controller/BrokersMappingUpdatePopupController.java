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
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingBrokersViewModel;

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
public class BrokersMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

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
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

	private final ObservableList<Account> observableBrokersList = FXCollections.observableArrayList();
	private final FilteredList<Account> filteredBrokersList = new FilteredList<>(this.observableBrokersList, null);
	private final SortedList<Account> sortedBrokersList = new SortedList<>(this.filteredBrokersList);

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
		ApplicationHelper.controllersMap.putInstance(BrokersMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceBrokerTextField != null : "fx:id=\"externalSourceBrokerTextField\" was not injected. Check your FXML file BrokersMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.externalSourceBrokerTextField.setText(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalValue1());
		this.brokerTypeComboBox.getSelectionModel().select(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalValue2());
		this.externalSourceTraderTextField.setText(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalValue3());
		this.externalSourceAccountTextField.setText(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalValue4());
		this.ictsBrokerComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveAccounts().get(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getAliasValue()));

		this.ictsBrokerComboBox.setItems(this.sortedBrokersList);
		//this.updateButton.disableProperty().bind(this.externalSourceBrokerTextField.textProperty().isEmpty().or(this.brokerTypeComboBox.valueProperty().isNull()).or(this.externalSourceTraderTextField.textProperty().isEmpty()).or(this.externalSourceAccountTextField.textProperty().isEmpty()).or(this.ictsBrokerComboBox.valueProperty().isNull()));
		//modified the above line as below. We should not disable the update button if an optional field is left empty.
		this.updateButton.disableProperty().bind(this.externalSourceBrokerTextField.textProperty().isEmpty().or(this.brokerTypeComboBox.valueProperty().isNull()).or(this.ictsBrokerComboBox.valueProperty().isNull()));
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
	}

	@Override
	public void attachListeners()
	{
	}

	private void fetchIctsBrokers()
	{
		this.observableBrokersList.clear();
		this.observableBrokersList.addAll(CayenneReferenceDataCache.loadAllActiveAccounts().values());
		LOGGER.debug("Brokers Count : {}", this.observableBrokersList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateBrokerMapping();
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

	private void updateBrokerMapping()
	{
		final String oldValue = this.externalMappingBrokersViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsBroker = this.ictsBrokerComboBox.getSelectionModel().getSelectedItem().getAcctShortName();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsBroker);
		}

		if(oldValue.equals(ictsBroker))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsBroker);

				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingTradersTableView();
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

	private void refreshExternalMappingTradersTableView()
	{
		LOGGER.debug("ExternalMappingBrokersViewModel Instance {}", this.externalMappingBrokersViewModel);
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().clear();
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}