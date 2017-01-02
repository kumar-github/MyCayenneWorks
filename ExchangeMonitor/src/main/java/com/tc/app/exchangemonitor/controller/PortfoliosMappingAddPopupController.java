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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class PortfoliosMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String PORTFOLIO_MAPPING_TYPE = "P";

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
	private Button saveButton;
	@FXML
	private Button cancelButton;

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
		ApplicationHelper.controllersMap.putInstance(PortfoliosMappingAddPopupController.class, this);
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
		this.saveButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.externalSourceTraderTextField.textProperty().isEmpty()).or(this.externalSourceTradingPeriodTextField.textProperty().isEmpty()).or(this.externalSourceAccountTextField.textProperty().isEmpty()).or(this.ictsPortfolioComboBox.valueProperty().isNull()));
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
		this.externalSourceCommodityTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceCommodityTextField, newValue));
		this.externalSourceTraderTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceTraderTextField, newValue));
		this.externalSourceTradingPeriodTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceTradingPeriodTextField, newValue));
		this.externalSourceAccountTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceAccountTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void fetchIctsPortfolios()
	{
		this.observablePortfoliosList.clear();
		this.observablePortfoliosList.addAll(this.filter(CayenneReferenceDataCache.loadAllPortfolios().values(), (final Portfolio aPortfolio) -> aPortfolio.getPortType().trim().equals("R") && (aPortfolio.getPortLocked() == 0)));
		LOGGER.debug("Portfolios Count {}", this.observablePortfoliosList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
		this.savePortfolioMapping();
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

	private void savePortfolioMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceCommodity = this.externalSourceCommodityTextField.getText().isEmpty() ? null : this.externalSourceCommodityTextField.getText().trim();
		final String externalSourceTrader = this.externalSourceTraderTextField.getText().isEmpty() ? null : this.externalSourceTraderTextField.getText().trim();
		final String externalSourceTradingPeriod = this.externalSourceTradingPeriodTextField.getText().isEmpty() ? null : this.externalSourceTradingPeriodTextField.getText().trim();
		final String externalSourceAccount = this.externalSourceAccountTextField.getText().isEmpty() ? null : this.externalSourceAccountTextField.getText().trim();
		final String ictsPortfolio = this.ictsPortfolioComboBox.getSelectionModel().getSelectedItem().getPortNum().toString();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", CayenneReferenceDataFetchUtil.generateNewNum("external_mapping_oid", 0));
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", PORTFOLIO_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceCommodity);
				insertMappingQuery.param("externalValue2Param", externalSourceTrader);
				insertMappingQuery.param("externalValue3Param", externalSourceTradingPeriod);
				insertMappingQuery.param("externalValue4Param", externalSourceAccount);
				insertMappingQuery.param("aliasValueParam", ictsPortfolio);
				insertMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U"));
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingPortfoliosTableView();
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

	private void refreshExternalMappingPortfoliosTableView()
	{
		LOGGER.debug("ExternalMappingPortfoliosViewModel Instance {}", this.externalMappingPortfoliosViewModel);
		this.externalMappingPortfoliosViewModel.getExternalMappingPortfoliosObservableList().clear();
		this.externalMappingPortfoliosViewModel.getExternalMappingPortfoliosObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}