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

import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingAccountsViewModel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class AccountsMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String ACCOUNT_MAPPING_TYPE = "K";

	@Inject
	private ExternalMappingAccountsViewModel externalMappingAccountsViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceAccountTextField;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

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
		ApplicationHelper.controllersMap.putInstance(AccountsMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceAccountTextField != null : "fx:id=\"externalSourceAccountTextField\" was not injected. Check your FXML file AccountsMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.saveButton.disableProperty().bind(this.externalSourceAccountTextField.textProperty().isEmpty());
	}

	@Override
	public void initializeGUI()
	{
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
		this.externalSourceAccountTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceAccountTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.saveAccountMapping();
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

	private void saveAccountMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceAccount = this.externalSourceAccountTextField.getText().isEmpty() ? null : this.externalSourceAccountTextField.getText().trim().toUpperCase();

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
				insertMappingQuery.param("mappingTypeParam", ACCOUNT_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceAccount);
				insertMappingQuery.param("externalValue2Param", null);
				insertMappingQuery.param("externalValue3Param", null);
				insertMappingQuery.param("externalValue4Param", null);
				insertMappingQuery.param("aliasValueParam", "NONE");
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

	private void refreshExternalMappingTradersTableView()
	{
		LOGGER.debug("ExternalMappingAccountsViewModel Instance {}", this.externalMappingAccountsViewModel);
		this.externalMappingAccountsViewModel.getExternalMappingAccountsObservableList().clear();
		this.externalMappingAccountsViewModel.getExternalMappingAccountsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}