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
import com.tc.app.exchangemonitor.view.java.CurrenciesMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.CurrenciesMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCurrenciesViewModel;

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

public class ExternalMappingCurrenciesController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingCurrenciesObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the CurrenciesMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingCurrenciesObservableList.
	 */
	@Inject
	private ExternalMappingCurrenciesViewModel externalMappingCurrenciesViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingCurrenciesTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceCurrencyTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> ictsCurrencyTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingCurrenciesFilteredList = null;
	private SortedList<ExternalMapping> externalMappingCurrenciesSortedList = null;

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
		ApplicationHelper.controllersMap.putInstance(ExternalMappingCurrenciesController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingCurrenciesViewModel Instance {}", this.externalMappingCurrenciesViewModel);
		this.externalMappingCurrenciesFilteredList = new FilteredList<>(this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList(), null);
		this.externalMappingCurrenciesSortedList = new SortedList<>(this.externalMappingCurrenciesFilteredList);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingCurrenciesViewModel.selectedRecordProperty().bind(this.externalMappingCurrenciesTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingCurrenciesSortedList.comparatorProperty().bind(this.externalMappingCurrenciesTableView.comparatorProperty());
		this.externalMappingCurrenciesTableView.setItems(this.externalMappingCurrenciesSortedList);

		this.deleteMappingButton.disableProperty().bind(this.externalMappingCurrenciesTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingCurrenciesTableView.getSelectionModel().selectedItemProperty().isNull());
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
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().clear();
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingCurrenciesFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isCurrencyPredicate));
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		this.showAddCurrenciesMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateCurrenciesMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingCurrenciesTableView();
	}

	private void showAddCurrenciesMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new CurrenciesMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateCurrenciesMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new CurrenciesMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final ExternalMapping selectedMappingToDelete = this.externalMappingCurrenciesTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingCurrenciesTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingCurrenciesTableView()
	{
		LOGGER.debug("ExternalMappingCurrenciesViewModel Instance {}", this.externalMappingCurrenciesViewModel);
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().clear();
		this.externalMappingCurrenciesViewModel.getExternalMappingCurrenciesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}