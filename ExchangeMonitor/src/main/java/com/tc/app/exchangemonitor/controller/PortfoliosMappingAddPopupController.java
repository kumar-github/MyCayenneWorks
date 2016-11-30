/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 17, 2016
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Portfolio;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;

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
public class PortfoliosMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger(PortfoliosMappingAddPopupController.class);
	private static final String PORTFOLIO_MAPPING_TYPE = "P";

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
	private Label titleLabel;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<Portfolio> observablePortfoliosList = FXCollections.observableArrayList();

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
		System.out.println(PORTFOLIO_MAPPING_TYPE);
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
	}

	private void fetchIctsPortfolios()
	{
		this.observablePortfoliosList.clear();
		this.observablePortfoliosList.addAll(this.filter(CayenneReferenceDataCache.fetchAllPortfolios().values(), (final Portfolio aPortfolio) -> aPortfolio.getPortType().trim().equals("R") && (aPortfolio.getPortLocked() == 0)));
		LOGGER.debug(this.observablePortfoliosList.size());
	}

	@FXML
	private void handleSaveButtonClick()
	{
	}

	@FXML
	private void handleCancelButtonClick()
	{
		((Stage) this.cancelButton.getScene().getWindow()).close();
	}

	/* ========================================================================================================================================================= */
	/* ========================================================== SOME UTILITY METHODS ========================================================================= */
	/* ========================================================================================================================================================= */
}