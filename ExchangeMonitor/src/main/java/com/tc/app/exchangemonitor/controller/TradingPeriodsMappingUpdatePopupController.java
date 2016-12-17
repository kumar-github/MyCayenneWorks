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
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradingPeriodsViewModel;

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
public class TradingPeriodsMappingUpdatePopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	@Inject
	private ExternalMappingTradingPeriodsViewModel externalMappingTradingPeriodsViewModel;

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceCommodityTextField;
	@FXML
	private TextField tradingPeriodOffsetMonthTextField;
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
		ApplicationHelper.controllersMap.putInstance(TradingPeriodsMappingUpdatePopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceCommodityTextField != null : "fx:id=\"externalSourceCommodityTextField\" was not injected. Check your FXML file TradingPeriodsMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.updateButton.disableProperty().bind(this.externalSourceCommodityTextField.textProperty().isEmpty().or(this.tradingPeriodOffsetMonthTextField.textProperty().isEmpty()));
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
	}

	@FXML
	private void handleUpdateButtonClick()
	{
		this.updateTradingPeriodMapping();
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

	private void updateTradingPeriodMapping()
	{
		final String oldValue = this.externalMappingTradingPeriodsViewModel.selectedRecordProperty().get().getAliasValue();
		final String tradingPeriodOffsetMonth = this.tradingPeriodOffsetMonthTextField.getText().isEmpty() ? null : this.tradingPeriodOffsetMonthTextField.getText().trim().toUpperCase();

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Old Value : {} New Value : {}", oldValue, tradingPeriodOffsetMonth);
		}

		if(oldValue.equals(tradingPeriodOffsetMonth))
		{
			this.statusButton.setVisible(true);
			this.statusButton.setText("Nothing has changed.");
			LOGGER.info("Nothing has changed.");
			return;
		}

		final Integer externalMappingOid = this.externalMappingTradingPeriodsViewModel.selectedRecordProperty().get().getExternalMappingOid();

		final boolean doesBrokerMappingExistsAlready = false;

		try
		{
			if(!doesBrokerMappingExistsAlready)
			{
				final MappedExec updateMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("UpdateMapping");
				updateMappingQuery.param("aliasValueParam", tradingPeriodOffsetMonth);
				updateMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				updateMappingQuery.param("externalMappingOidParam", externalMappingOid);
				updateMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				LOGGER.info("Mapping Updated Successfully.");
				this.closePopup();
				this.refreshExternalMappingTradingPeriodsTableView();
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

	private void refreshExternalMappingTradingPeriodsTableView()
	{
		LOGGER.debug("ExternalMappingTradingPeriodsViewModel Instance {}", this.externalMappingTradingPeriodsViewModel);
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().clear();
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}