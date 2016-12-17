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
import com.tc.app.exchangemonitor.view.java.TradersMappingAddPopupView;
import com.tc.app.exchangemonitor.view.java.TradersMappingUpdatePopupView;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradersViewModel;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExternalMappingTradersController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();

	/*
	 * This is the ViewModel instance. Moved the externalMappingTradersObservableList property to the view model, so that other controllers which need can access from there.
	 * This is done mainly bcoz, the TradersMappingAddPopupController need to call the refresh method after a new mapping is added which inturn repopulate the externalMappingTradersObservableList.
	 */
	@Inject
	private ExternalMappingTradersViewModel externalMappingTradersViewModel;

	@FXML
	private TableView<ExternalMapping> externalMappingTradersTableView;
	@FXML
	private TableColumn<ExternalMapping, String> externalSourceTraderTableColumn;
	@FXML
	private TableColumn<ExternalMapping, String> ictsTraderTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private FilteredList<ExternalMapping> externalMappingTradersFilteredList = null;
	private SortedList<ExternalMapping> externalMappingTradersSortedList = null;

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

	private void doSomeGlobalVariableInitialization()
	{
		LOGGER.debug("ExternalMappingTradersViewModel Instance {}", this.externalMappingTradersViewModel);
		this.externalMappingTradersFilteredList = new FilteredList<>(this.externalMappingTradersViewModel.getExternalMappingTradersObservableList(), null);
		this.externalMappingTradersSortedList = new SortedList<>(this.externalMappingTradersFilteredList);
	}

	@Override
	public void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(ExternalMappingTradersController.class, this);
	}

	@Override
	public void doAssertion()
	{
	}

	@Override
	public void doInitialDataBinding()
	{
		this.externalMappingTradersViewModel.selectedRecordProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty());

		this.externalMappingTradersSortedList.comparatorProperty().bind(this.externalMappingTradersTableView.comparatorProperty());
		this.externalMappingTradersTableView.setItems(this.externalMappingTradersSortedList);

		//this.externalMappingsViewModel.isAnyRowSelectedInTradersViewProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty().isNotNull());
		this.deleteMappingButton.disableProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty().isNull());
		this.updateMappingButton.disableProperty().bind(this.externalMappingTradersTableView.getSelectionModel().selectedItemProperty().isNull());
	}

	@Override
	public void initializeGUI()
	{
		this.fetchExternalMapping();
		//this.fetchTradersExternalMapping();
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

	/*
	private void fetchTradersExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton)ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<IExternalMappingEntity> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);
		this.externalMappingTradersObservableList.addAll(ExternalMappingPredicates.filterExternalMappings(ReferenceDataCache.fetchExternalMappings(), predicate.and(ExternalMappingPredicates.isTraderPredicate)));
		LOGGER.info("Fetched Mappings Count : " + this.externalMappingTradersObservableList.size());
	}
	 */

	private void fetchExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<ExternalMapping> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);

		/* We are loading all the external mappings and setting it to the tableview. After that we update the filter with required predicates. Is this better or load only respective mappings.? */
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().clear();
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingTradersFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isTraderPredicate));
	}

	@FXML
	private void handleAddMapingButtonClick()
	{
		/*
		final Dialog dialog = new Dialog<>();
		final ButtonType loginButtonType = new ButtonType("Test", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(loginButtonType);

		dialog.showAndWait();

		final Alert alert = new Alert(AlertType.NONE);
		alert.getDialogPane().getButtonTypes().add(loginButtonType);
		alert.getDialogPane().setContent(new VBox(new TextField("welcome")));
		alert.showAndWait();
		 */

		/* commented the below line since we are not using it presently. Currently we have separate views for Add and Update Mappings. */
		//this.externalMappingTradersViewModel.isAddProperty().set(true);
		this.showAddTradersMappingView();
	}

	@FXML
	private void handleDeleteMapingButtonClick()
	{
		this.deleteSelectedMapping();
	}

	@FXML
	private void handleUpdateMapingButtonClick()
	{
		/* commented the below line since we are not using it presently. Currently we have separate views for Add and Update Mappings. */
		//this.externalMappingTradersViewModel.isAddProperty().set(false);
		this.showUpdateTradersMappingView();
	}

	@FXML
	private void handleRefreshMappingButtonClick()
	{
		this.refreshExternalMappingTradersTableView();
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

		//final Optional<String> x = tradersMappingAddPopup.showAndWait();
		// Convert the result to a username-password-pair when the login button is clicked.
		/*
		tradersMappingAddPopup.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(username.getText(), password.getText());
		    }
		    return null;
		});
		 */

		/*x.ifPresent(data -> {
			System.out.println(data);
		});*/
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
		final ExternalMapping selectedMappingToDelete = this.externalMappingTradersTableView.getSelectionModel().getSelectedItem();
		final Integer externalMappingOid = selectedMappingToDelete.getExternalMappingOid();

		try
		{
			/* Read the delete mapping query from datamap.xml file, set the paramters and keep it ready. */
			/*final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("DeleteMapping");
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
			final MappedExec deleteMappingQuery = CayenneReferenceDataFetchUtil.getQueryForName("DeleteMapping");
			deleteMappingQuery.param("externalMappingOidParam", externalMappingOid);
			CayenneReferenceDataFetchUtil.generateNewTransaction();
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