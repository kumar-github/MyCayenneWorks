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
import com.tc.app.exchangemonitor.view.java.UOMConversionsMappingAddPopupView;

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

public class ExternalMappingUOMConversionsController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger(ExternalMappingUOMConversionsController.class);

	private final ObservableList<ExternalMapping> externalMappingUOMConversionsObservableList = FXCollections.observableArrayList();
	private final FilteredList<ExternalMapping> externalMappingUOMConversionsFilteredList = new FilteredList<>(this.externalMappingUOMConversionsObservableList, null);
	private final SortedList<ExternalMapping> externalMappingUOMConversionsSortedList = new SortedList<>(this.externalMappingUOMConversionsFilteredList);

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

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.setAnyUIComponentStateIfNeeded();
		this.setComponentToolTipIfNeeded();
		this.initializeListeners();
		this.initializeTableView();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(ExternalMappingUOMConversionsController.class, this);
	}

	private void doAssertion()
	{
	}

	private void doInitialDataBinding()
	{
		this.externalMappingUOMConversionsSortedList.comparatorProperty().bind(this.externalMappingUOMConversionsTableView.comparatorProperty());
		this.externalMappingUOMConversionsTableView.setItems(this.externalMappingUOMConversionsSortedList);
	}

	private void initializeGUI()
	{
		//this.fetchUOMConversionsExternalMapping();
		this.fetchExternalMapping();
	}

	private void setAnyUIComponentStateIfNeeded()
	{
	}

	private void setComponentToolTipIfNeeded()
	{
	}

	private void initializeTableView()
	{
		this.initializeExternalMappingUOMConversionsTableView();
	}

	private void initializeExternalMappingUOMConversionsTableView()
	{
		this.externalSourceCommodityTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalValue1()));
		this.toUomCodeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalValue3()));
		this.toUomConvRateTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAliasValue()));
	}

	private void initializeListeners()
	{
	}

	/*
	private void fetchUOMConversionsExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<ExternalMapping> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);
		this.externalMappingUOMConversionsObservableList.addAll(ExternalMappingPredicates.filterExternalMappings(ReferenceDataCache.fetchExternalMappings(), predicate.and(ExternalMappingPredicates.isUomConversionPredicate)));
		LOGGER.info("Fetched Mappings Count : " + this.externalMappingUOMConversionsObservableList.size());
	}
	 */

	private void fetchExternalMapping()
	{
		final String selectedExternalTradeSource = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Predicate<ExternalMapping> predicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(selectedExternalTradeSource);

		this.externalMappingUOMConversionsObservableList.clear();
		this.externalMappingUOMConversionsObservableList.addAll(CayenneReferenceDataCache.loadExternalMappings());
		this.updateFilter(predicate);
	}

	public void updateFilter(final Predicate<ExternalMapping> predicate)
	{
		this.externalMappingUOMConversionsFilteredList.setPredicate(predicate.and(ExternalMappingPredicates.isUomConversionPredicate));
	}

	@FXML
	private void handleAddMapingButtonClick()
	{
		this.showAddUOMConversionsMappingView();
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
		System.out.println("Stage Operation Completed.");
	}
}