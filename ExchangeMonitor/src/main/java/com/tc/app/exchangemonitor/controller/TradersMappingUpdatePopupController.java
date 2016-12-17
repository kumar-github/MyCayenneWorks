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

import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradersViewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class TradersMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingTradersViewModel externalMappingTradersViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceTraderTextField;
	@FXML
	private ComboBox<IctsUser> ictsTraderComboBox;
	@FXML
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

	private final ObservableList<IctsUser> observableIctsTradersList = FXCollections.observableArrayList();

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
		ApplicationHelper.controllersMap.putInstance(TradersMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceTraderTextField != null : "fx:id=\"externalSourceTraderTextField\" was not injected. Check your FXML file TradersMappingUpdatePopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		//this.test.managedProperty().bind(this.test.visibleProperty());

		this.externalSourceTraderTextField.setText(this.externalMappingTradersViewModel.selectedRecordProperty().get().getExternalValue1());
		this.ictsTraderComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveIctsUsers().get(this.externalMappingTradersViewModel.selectedRecordProperty().get().getAliasValue()));

		this.ictsTraderComboBox.setItems(this.observableIctsTradersList);
		this.updateButton.disableProperty().bind(this.externalSourceTraderTextField.textProperty().isEmpty().or(this.ictsTraderComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsTraders();
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		/* Actually, the focus should be set on the first input field so that user can start typing the data. But, we set the "Prompt Text" on the text fields and
		 * if the focus is set then the prompt text won't be visible and user should move to some other field and come back to know what text field is this.
		 */
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

	private void fetchIctsTraders()
	{
		this.observableIctsTradersList.clear();
		this.observableIctsTradersList.addAll(this.filter(CayenneReferenceDataCache.loadAllActiveIctsUsers().values(), (final IctsUser anIctsUser) -> anIctsUser.getUserJobTitle().getUserJobTitle().trim().equals("TRADER")));
		LOGGER.debug("Traders Count : {}", this.observableIctsTradersList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateTraderMapping();
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

	private void updateTraderMapping()
	{
		final String oldValue = this.externalMappingTradersViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsTrader = this.ictsTraderComboBox.getSelectionModel().getSelectedItem().getUserInit();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsTrader);
		}

		if(oldValue.equals(ictsTrader))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingTradersViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesTraderMappingExistsAlready = false;

		try
		{
			if(!doesTraderMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsTrader);
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
		LOGGER.debug("ExternalMappingTradersViewModel Instance {}", this.externalMappingTradersViewModel);
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().clear();
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}