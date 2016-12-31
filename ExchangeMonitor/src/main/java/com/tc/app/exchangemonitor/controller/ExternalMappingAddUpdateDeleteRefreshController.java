package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.util.ApplicationHelper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ExternalMappingAddUpdateDeleteRefreshController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();
	@FXML
	Button deleteMappingButton;
	@FXML
	Button updateMappingButton;
	@FXML
	Button refreshMappingButton;
	@FXML
	Button addMappingButton;

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doSomeGlobalVariableInitialization();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.createListeners();
		this.attachListeners();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(ExternalMappingAddUpdateDeleteRefreshController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
	}

	private void initializeGUI()
	{
	}

	private void createListeners()
	{
	}

	private void attachListeners()
	{
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		System.out.println("handleAddMappingButtonClick");
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		System.out.println("handleAddMappingButtonClick");
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
	}

	private void showAddAccountsMappingView()
	{
	}

	private void showUpdateAccountsMappingView()
	{
	}

	private void deleteSelectedMapping()
	{
	}

	private void refreshExternalMappingAccountsTableView()
	{
	}
}