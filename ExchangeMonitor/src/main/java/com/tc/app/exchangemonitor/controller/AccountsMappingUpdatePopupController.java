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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class AccountsMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingAccountsViewModel externalMappingAccountsViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceAccountTextField;
	@FXML
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

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
		ApplicationHelper.controllersMap.putInstance(AccountsMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceAccountTextField != null : "fx:id=\"externalSourceAccountTextField\" was not injected. Check your FXML file AccountsMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.externalSourceAccountTextField.setText(this.externalMappingAccountsViewModel.selectedRecordProperty().get().getExternalValue1());

		this.updateButton.disableProperty().bind(this.externalSourceAccountTextField.textProperty().isEmpty());
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
	private void handleUpdateButtonClick()
	{
		this.updateAccountMapping();
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

	private void updateAccountMapping()
	{
		final String oldValue = this.externalMappingAccountsViewModel.selectedRecordProperty().get().getExternalValue1();
		final String externalSourceAccount = this.externalSourceAccountTextField.getText().isEmpty() ? null : this.externalSourceAccountTextField.getText().trim();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, externalSourceAccount);
		}

		if(oldValue.equals(externalSourceAccount))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingAccountsViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("UpdateAccountMapping");
				updateMappingQuery.param("externalValue1Param", externalSourceAccount);
				updateMappingQuery.param("aliasValueParam", "NONE");
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
		LOGGER.debug("ExternalMappingAccountsViewModel Instance {}", this.externalMappingAccountsViewModel);
		this.externalMappingAccountsViewModel.getExternalMappingAccountsObservableList().clear();
		this.externalMappingAccountsViewModel.getExternalMappingAccountsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}