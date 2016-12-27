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
import com.tc.app.exchangemonitor.view.java.UOMConversionsMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.UOMConversionsMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingUOMConversionsViewModel;

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

public class ExternalMappingUOMConversionsController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingUOMConversionsObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the UOMConversionsMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingUOMConversionsObservableList.
	 */
	@Inject
	private ExternalMappingUOMConversionsViewModel externalMappingUOMConversionsViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingUOMConversionsTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceCommodityTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> toUomCodeTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> toUomConvRateTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingUOMConversionsFilteredList = null;
	private SortedList<ExternalMapping> externalMappingUOMConversionsSortedList = null;

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
		ApplicationHelper.controllersMap.putInstance(ExternalMappingUOMConversionsController.class, this);
	}

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingUOMConversionsViewModel Instance {}", this.externalMappingUOMConversionsViewModel);
		this.externalMappingUOMConversionsFilteredList = new FilteredList<>(this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList(), null);
		this.externalMappingUOMConversionsSortedList = new SortedList<>(this.externalMappingUOMConversionsFilteredList);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingUOMConversionsViewModel.selectedRecordProperty().bind(this.externalMappingUOMConversionsTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingUOMConversionsSortedList.comparatorProperty().bind(this.externalMappingUOMConversionsTableView.comparatorProperty());
		this.externalMappingUOMConversionsTableView.setItems(this.externalMappingUOMConversionsSortedList);

		this.deleteMappingButton.disableProperty().bind(this.externalMappingUOMConversionsTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingUOMConversionsTableView.getSelectionModel().selectedItemProperty().isNull());
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
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().clear();
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingUOMConversionsFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isUomConversionPredicate));
	}

	@FXML
	private void handleAddMappingButtonClick()
	{
		this.showAddUOMConversionsMappingView();
	}

	@FXML
	private void handleDeleteMappingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMappingButtonClick()
	{
		this.showUpdateUOMConversionsMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingUOMConversionsTableView();
	}

	private void showAddUOMConversionsMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new UOMConversionsMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void showUpdateUOMConversionsMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.updateMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new UOMConversionsMappingUpdatePopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		LOGGER.info("Stage Operation Completed.");
	}

	private void deleteSelectedMapping()
	{
		final ExternalMapping selectedMappingToDelete = this.externalMappingUOMConversionsTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
			deleteMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

			LOGGER.info("{} Mapping Deleted Successfully.", (externalMappingOid + "<-->" + selectedMappingToDelete));
			this.refreshExternalMappingUOMConversionsTableView();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Unable to delete the mapping {}.", externalMappingOid, exception);
		}
	}

	private void refreshExternalMappingUOMConversionsTableView()
	{
		LOGGER.debug("ExternalMappingUOMConversionsViewModel Instance {}", this.externalMappingUOMConversionsViewModel);
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().clear();
		this.externalMappingUOMConversionsViewModel.getExternalMappingUOMConversionsObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}