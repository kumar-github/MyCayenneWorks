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
import com.tc.app.exchangemonitor.view.java.CompaniesMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.CompaniesMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingCompaniesViewModel;

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

public class ExternalMappingCompaniesController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingCompaniesObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the CompaniesMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingCompaniesObservableList.
	 */
	@Inject
	private ExternalMappingCompaniesViewModel externalMappingCompaniesViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingCompaniesTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceCompanyTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> companyTypeTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> companyCountryTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> ictsCompanyTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingCompaniesFilteredList = null;
	private SortedList<ExternalMapping> externalMappingCompaniesSortedList = null;

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
		ApplicationHelper.controllersMap.putInstance(ExternalMappingCompaniesController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingCompaniesViewModel Instance {}", this.externalMappingCompaniesViewModel);
		this.externalMappingCompaniesFilteredList = new FilteredList<>(this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList(), null);
		this.externalMappingCompaniesSortedList = new SortedList<>(this.externalMappingCompaniesFilteredList);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingCompaniesViewModel.selectedRecordProperty().bind(this.externalMappingCompaniesTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingCompaniesSortedList.comparatorProperty().bind(this.externalMappingCompaniesTableView.comparatorProperty());
		this.externalMappingCompaniesTableView.setItems(this.externalMappingCompaniesSortedList);

		this.deleteMappingButton.disableProperty().bind(this.externalMappingCompaniesTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingCompaniesTableView.getSelectionModel().selectedItemProperty().isNull());
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

		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().clear();
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingCompaniesFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isCompanyPredicate));
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		this.showAddCompaniesMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateCompaniesMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingCompaniesTableView();
	}

	private void showAddCompaniesMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new CompaniesMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateCompaniesMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new CompaniesMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final ExternalMapping selectedMappingToDelete = this.externalMappingCompaniesTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction();
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingCompaniesTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingCompaniesTableView()
	{
		LOGGER.debug("ExternalMappingCompaniesViewModel Instance {}", this.externalMappingCompaniesViewModel);
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().clear();
		this.externalMappingCompaniesViewModel.getExternalMappingCompaniesObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}