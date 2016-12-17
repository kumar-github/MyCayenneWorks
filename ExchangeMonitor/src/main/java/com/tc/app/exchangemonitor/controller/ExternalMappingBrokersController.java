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
import com.tc.app.exchangemonitor.view.java.BrokersMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.BrokersMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingBrokersViewModel;

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

public class ExternalMappingBrokersController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingBrokersObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the BrokersMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingBrokersObservableList.
	 */
	@Inject
	private ExternalMappingBrokersViewModel externalMappingBrokersViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingBrokersTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceBrokerTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> brokerTypeTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceTraderTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceAccountTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> ictsBrokerTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingBrokersFilteredList = null;
	private SortedList<ExternalMapping> externalMappingBrokersSortedList = null;

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
		ApplicationHelper.controllersMap.putInstance(ExternalMappingBrokersController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingBrokersViewModel Instance {}", this.externalMappingBrokersViewModel);
		this.externalMappingBrokersFilteredList = new FilteredList<>(this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList(), null);
		this.externalMappingBrokersSortedList = new SortedList<>(this.externalMappingBrokersFilteredList);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingBrokersViewModel.selectedRecordProperty().bind(this.externalMappingBrokersTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingBrokersSortedList.comparatorProperty().bind(this.externalMappingBrokersTableView.comparatorProperty());
		this.externalMappingBrokersTableView.setItems(this.externalMappingBrokersSortedList);

		//this.externalMappingsViewModel.isAnyRowSelectedInBrokersViewProperty().bind(this.externalMappingBrokersTableView.getSelectionModel().selectedItemProperty().isNotNull());
		this.deleteMappingButton.disableProperty().bind(this.externalMappingBrokersTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingBrokersTableView.getSelectionModel().selectedItemProperty().isNull());
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
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().clear();
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingBrokersFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isBrokerPredicate));
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		this.showAddBrokersMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateBrokersMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingBrokersTableView();
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
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new BrokersMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final ExternalMapping selectedMappingToDelete = this.externalMappingBrokersTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction();
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingBrokersTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingBrokersTableView()
	{
		LOGGER.debug("ExternalMappingBrokersViewModel Instance {}", this.externalMappingBrokersViewModel);
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().clear();
		this.externalMappingBrokersViewModel.getExternalMappingBrokersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}