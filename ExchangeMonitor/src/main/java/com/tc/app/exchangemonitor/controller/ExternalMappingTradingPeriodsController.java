package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.inject.Inject;

import org.apache.cayenne.query.MappedExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.predicates.ExternalMappingPredicates;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.view.java.TradingPeriodsMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.TradingPeriodsMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradingPeriodsViewModel;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExternalMappingTradingPeriodsController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingTradingPeriodsObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the TradingPeriodsMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingTradingPeriodsObservableList.
	 */
	@Inject
	private ExternalMappingTradingPeriodsViewModel externalMappingTradingPeriodsViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingTradingPeriodsTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceCommodityTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> tradingPeriodOffsetMonthTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingTradingPeriodsFilteredList = null;
	private SortedList<ExternalMapping> externalMappingTradingPeriodsSortedList = null;

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doSomeGlobalVariableInitialization();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(ExternalMappingTradingPeriodsController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingTradingPeriodsViewModel Instance {}", this.externalMappingTradingPeriodsViewModel);
		this.externalMappingTradingPeriodsFilteredList = new FilteredList<>(this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList(), null);
		this.externalMappingTradingPeriodsSortedList = new SortedList<>(this.externalMappingTradingPeriodsFilteredList);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingTradingPeriodsViewModel.selectedRecordProperty().bind(this.externalMappingTradingPeriodsTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingTradingPeriodsSortedList.comparatorProperty().bind(this.externalMappingTradingPeriodsTableView.comparatorProperty());
		this.externalMappingTradingPeriodsTableView.setItems(this.externalMappingTradingPeriodsSortedList);

		this.deleteMappingButton.disableProperty().bind(this.externalMappingTradingPeriodsTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingTradingPeriodsTableView.getSelectionModel().selectedItemProperty().isNull());
	}

	private void initializeGUI()
	{
		this.fetchExternalMapping();
	}

	private void createListeners()
	{
	}

	private void attachListeners()
	{
	}

	private void fetchExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<ExternalMapping> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);

		/* We are loading all the external mappings and setting it to the tableview. After that we update the filter with required predicates. Is this better or load only respective mappings.? */
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().clear();
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingTradingPeriodsFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isTradingPeriodPredicate));
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		this.showAddTradingPeriodsMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateTradingPeriodsMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingTradingPeriodsTableView();
	}

	private void showAddTradingPeriodsMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new TradingPeriodsMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateTradingPeriodsMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new TradingPeriodsMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final ExternalMapping selectedMappingToDelete = this.externalMappingTradingPeriodsTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingTradingPeriodsTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingTradingPeriodsTableView()
	{
		LOGGER.debug("ExternalMappingTradingPeriodsViewModel Instance {}", this.externalMappingTradingPeriodsViewModel);
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().clear();
		this.externalMappingTradingPeriodsViewModel.getExternalMappingTradingPeriodsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}