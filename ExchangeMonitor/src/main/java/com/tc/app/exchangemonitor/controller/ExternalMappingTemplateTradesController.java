package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.predicates.ExternalMappingPredicates;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.view.java.TemplateTradesMappingAddPopupView;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ExternalMappingTemplateTradesController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger(ExternalMappingTemplateTradesController.class);

	@FXML
	private TableView<ExternalMapping> externalMappingTradesTableView;

	@FXML
	private TableColumn<ExternalMapping, String> externalSourceCommodityTableColumn;

	@FXML
	private TableColumn<ExternalMapping, String> ictsTemplateTradeTableColumn;
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	@FXML
	private Button refreshMappingButton;

	private final ObservableList<ExternalMapping> externalMappingTradesObservableList = FXCollections.observableArrayList();
	private final FilteredList<ExternalMapping> externalMappingTradesFilteredList = new FilteredList<>(this.externalMappingTradesObservableList, null);
	private final SortedList<ExternalMapping> externalMappingTradesSortedList = new SortedList<>(this.externalMappingTradesFilteredList);

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.initializeTableView();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(ExternalMappingTemplateTradesController.class, this);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingTradesSortedList.comparatorProperty().bind(this.externalMappingTradesTableView.comparatorProperty());
		this.externalMappingTradesTableView.setItems(this.externalMappingTradesSortedList);
	}

	private void initializeGUI()
	{
		//this.fetchTradesExternalMapping();
		this.fetchExternalMapping();
	}

	private void initializeTableView()
	{
		this.initializeExternalMappingTradesTableView();
	}

	private void initializeExternalMappingTradesTableView()
	{
		this.externalSourceCommodityTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalValue1()));
		this.ictsTemplateTradeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAliasValue()));
	}

	/*
	private void fetchTradesExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<IExternalMappingEntity> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);
		this.externalMappingTradesObservableList.addAll(ExternalMappingPredicates.filterExternalMappings(ReferenceDataCache.fetchExternalMappings(), predicate.and(ExternalMappingPredicates.isTemplateTradePredicate)));
		LOGGER.info("Fetched Mappings Count : " + this.externalMappingTradesObservableList.size());
	}
	 */

	private void fetchExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<ExternalMapping> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);
		this.externalMappingTradesObservableList.addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingTradesFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isTemplateTradePredicate));
	}

	@FXML
	private void handleAddMapingButtonClick()
	{
		this.showAddTemplateTradesMappingView();
	}

	private void showAddTemplateTradesMappingView()
	{
		final Stage tempStage = new Stage(StageStyle.TRANSPARENT);
		/* To make this stage appears on top of the application window. Else, if the application is displayed in the secondary monitor the child stage will still visible on the primary monitor. */
		tempStage.initOwner(this.addMappingButton.getScene().getWindow());
		tempStage.initModality(Modality.APPLICATION_MODAL);
		tempStage.setScene(new Scene(new TemplateTradesMappingAddPopupView().getView()));
		tempStage.showAndWait();

		/* We will come back here once the user pressed cancel or login. Do we need to do anything here?. */
		System.out.println("Stage Operation Completed.");
	}
}