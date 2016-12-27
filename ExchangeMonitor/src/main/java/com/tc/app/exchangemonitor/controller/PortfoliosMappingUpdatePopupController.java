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

import com.tc.app.exchangemonitor.model.cayenne.persistent.Portfolio;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingPortfoliosViewModel;

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
public class PortfoliosMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingPortfoliosViewModel externalMappingPortfoliosViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCommodityTextField;
	@FXML
	private TextField externalSourceTraderTextField;
	@FXML
	private TextField externalSourceTradingPeriodTextField;
	@FXML
	private TextField externalSourceAccountTextField;
	@FXML
	private ComboBox<Portfolio> ictsPortfolioComboBox;
	@FXML
	private Button updateButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button statusButton;

	private final ObservableList<Portfolio> observablePortfoliosList = FXCollections.observableArrayList();

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
		ApplicationHelper.controllersMap.putInstance(PortfoliosMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file PortfoliosMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.ictsPortfolioComboBox.setItems(this.observablePortfoliosList);

		//this.externalSourceBrokerTextField.setText(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getExternalValue1());
		//this.ictsBrokerComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllActiveAccounts().get(this.externalMappingBrokersViewModel.selectedRecordProperty().get().getAliasValue()));
		this.externalSourceCommodityTextField.setText(this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getExternalValue1());
		this.externalSourceTraderTextField.setText(this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getExternalValue2());
		this.externalSourceTradingPeriodTextField.setText(this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getExternalValue3());
		this.externalSourceAccountTextField.setText(this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getExternalValue4());
		this.ictsPortfolioComboBox.getSelectionModel().select(CayenneReferenceDataCache.loadAllPortfolios().get(Integer.parseInt(this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getAliasValue())));

		//this.updateButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.externalSourceTraderTextField.textProperty().isEmpty()).or(this.externalSourceTradingPeriodTextField.textProperty().isEmpty()).or(this.externalSourceAccountTextField.textProperty().isEmpty()).or(this.ictsPortfolioComboBox.valueProperty().isNull()));
		this.updateButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.ictsPortfolioComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsPortfolios();
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

	private void fetchIctsPortfolios()
	{
		this.observablePortfoliosList.clear();
		this.observablePortfoliosList.addAll(this.filter(CayenneReferenceDataCache.loadAllPortfolios().values(), (final Portfolio aPortfolio) -> aPortfolio.getPortType().trim().equals("R") && (aPortfolio.getPortLocked() == 0)));
		LOGGER.debug("Portfolios Count {}", this.observablePortfoliosList.size());
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updatePortfolioMapping();
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

	private void updatePortfolioMapping()
	{
		final String oldValue = this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getAliasValue();
		final String ictsPortfolio = this.ictsPortfolioComboBox.getSelectionModel().getSelectedItem().getPortNum().toString();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, ictsPortfolio);
		}

		if(oldValue.equals(ictsPortfolio))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingPortfoliosViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", ictsPortfolio);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U"));
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingPortfoliosTableView();
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

	private void refreshExternalMappingPortfoliosTableView()
	{
		LOGGER.debug("ExternalMappingPortfoliosViewModel Instance {}", this.externalMappingPortfoliosViewModel);
		this.externalMappingPortfoliosViewModel.getExternalMappingPortfoliosObservableList().clear();
		this.externalMappingPortfoliosViewModel.getExternalMappingPortfoliosObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}