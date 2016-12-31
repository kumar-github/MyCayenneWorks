package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.cayenne.query.MappedExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.view.java.BrokersMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.BrokersMappingUpdatePopupView;
import com.tc.app.exchangemonitor.view.java.TradersMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.TradersMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingBrokersViewModel;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradersViewModel;
import com.tc.app.exchangemonitor.viewmodel.MainApplicationMappingsTabViewModel;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExternalMappingAddUpdateDeleteRefreshController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();

	@Inject
	private MainApplicationMappingsTabViewModel mainApplicationMappingsTabViewModel;

	/*
	 * This is the ViewModel instance. Moved the externalMappingTradersObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the TradersMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingTradersObservableList.
	 */
	@Inject
	private ExternalMappingTradersViewModel externalMappingTradersViewModel;

	@Inject
	private ExternalMappingBrokersViewModel externalMappingBrokersViewModel;

	@FXML
	private Button addMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button refreshMappingButton;

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doSomeGlobalVariableInitialization();
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
		ApplicationHelper.controllersMap.putInstance(ExternalMappingAddUpdateDeleteRefreshController.class, this);
	}

	public void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("MainApplicationMappingsTabViewModel Instance {}", this.mainApplicationMappingsTabViewModel);
		LOGGER.debug("ExternalMappingTradersViewModel Instance {}", this.externalMappingTradersViewModel);
	}

	@Override
	public void doAssertion()
	{
	}

	@Override
	public void doInitialDataBinding()
	{
		//this.deleteMappingButton.disableProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty().isNull());
		//this.updateMappingButton.disableProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty().isNull());

		switch(this.mainApplicationMappingsTabViewModel.currentVisibleMappingViewProperty().get())
		{
			case "tradersMappingVBox":
				this.deleteMappingButton.disableProperty().bind(this.externalMappingTradersViewModel.selectedRecordProperty().isNull());
				this.updateMappingButton.disableProperty().bind(this.externalMappingTradersViewModel.selectedRecordProperty().isNull());
				break;

			case "brokersMappingVBox":
				this.deleteMappingButton.disableProperty().bind(this.externalMappingBrokersViewModel.selectedRecordProperty().isNull());
				this.updateMappingButton.disableProperty().bind(this.externalMappingBrokersViewModel.selectedRecordProperty().isNull());
				break;

			default:
				break;
		}
	}

	@Override
	public void initializeGUI()
	{
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
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
	private void handleAddMappingButtonClick()
	{
		this.showAddMappingView();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingTradersTableView();
	}

	private void showAddMappingView()
	{
		final String currentVisibleMappingView = this.mainApplicationMappingsTabViewModel.currentVisibleMappingViewProperty().get();
		switch(currentVisibleMappingView)
		{
			case "tradersMappingVBox":
				this.showAddTradersMappingView();
				break;

			case "brokersMappingVBox":
				this.showAddBrokersMappingView();
				break;

			case "companiesMappingVBox":
				break;

			case "currenciesMappingVBox":
				break;

			case "portfoliosMappingVBox":
				break;

			case "tradesMappingVBox":
				break;

			case "accountsMappingVBox":
				break;

			case "uomConversionsMappingVBox":
				break;

			case "tradingPeriodsMappingVBox":
				break;

			default:
				break;
		}
	}

	private void showUpdateMappingView()
	{
		final String currentVisibleMappingView = this.mainApplicationMappingsTabViewModel.currentVisibleMappingViewProperty().get();
		switch(currentVisibleMappingView)
		{
			case "tradersMappingVBox":
				this.showUpdateTradersMappingView();
				break;

			case "brokersMappingVBox":
				this.showUpdateBrokersMappingView();
				break;

			case "companiesMappingVBox":
				break;

			case "currenciesMappingVBox":
				break;

			case "portfoliosMappingVBox":
				break;

			case "tradesMappingVBox":
				break;

			case "accountsMappingVBox":
				break;

			case "uomConversionsMappingVBox":
				break;

			case "tradingPeriodsMappingVBox":
				break;

			default:
				break;
		}
	}

	private void showAddTradersMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new TradersMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showAddBrokersMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new BrokersMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateBrokersMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new BrokersMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateTradersMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new TradersMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final String currentVisibleMappingView = this.mainApplicationMappingsTabViewModel.currentVisibleMappingViewProperty().get();
		switch(currentVisibleMappingView)
		{
			case "tradersMappingVBox":
				this.deleteTraderMapping();
				break;

			case "brokersMappingVBox":
				this.showUpdateBrokersMappingView();
				break;

			case "companiesMappingVBox":
				break;

			case "currenciesMappingVBox":
				break;

			case "portfoliosMappingVBox":
				break;

			case "tradesMappingVBox":
				break;

			case "accountsMappingVBox":
				break;

			case "uomConversionsMappingVBox":
				break;

			case "tradingPeriodsMappingVBox":
				break;

			default:
				break;
		}
	}

	private void deleteTraderMapping()
	{
		//final ExternalMapping selectedMappingToDelete = this.externalMappingTradersTableView.getSelectionModel().getSelectedItem();
		final ExternalMapping selectedMappingToDelete = this.externalMappingTradersViewModel.selectedRecordProperty().get();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			/* Read the delete mapping query from datamap.xml file, set the paramters and keep it ready. */
			/*final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
			deleteMappingQuery.param("mappingTypeParam", TRADER_MAPPING_TYPE);
			deleteMappingQuery.param("externalValue1Param", selectedMappingToDelete.getExternalValue1());
			deleteMappingQuery.param("externalValue2Param", null);
			deleteMappingQuery.param("externalValue3Param", null);
			deleteMappingQuery.param("externalValue4Param", null);
			deleteMappingQuery.param("aliasValueParam", selectedMappingToDelete.getAliasValue());*/

			/* Fire the gen_new_transaction SP first and immediately the delete query. */
			/*CayenneReferenceDataFetchUtil.generateNewTransaction();
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());*/

			/* Commented the above logic, we don't need all these information to just delete a mapping. oid is enough. SHAME ON ME. WHY DID I WRITE THAT?  */
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingTradersTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingTradersTableView()
	{
		LOGGER.debug("ExternalMappingTradersViewModel Instance {}", this.externalMappingTradersViewModel);
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().clear();
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}