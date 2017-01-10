package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.controller.DummyLoadSchedule.LoadScheduleStatus;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;

public class MainApplicationLoadingScheduleTabController implements IMainApplicationMonitorTabController
{
	private static final Logger LOGGER = LogManager.getLogger();

	@FXML
	private TableView<DummyLoadSchedule> loadingScheduleTableView;
	@FXML
	private TableColumn<DummyLoadSchedule, LoadScheduleStatus> loadingStatusTableColumn;
	@FXML
	private TableColumn<DummyLoadSchedule, Date> tradeDateTableColumn;
	@FXML
	private TableColumn<DummyLoadSchedule, Date> startTimeTableColumn;
	@FXML
	private TableColumn<DummyLoadSchedule, Date> stopTimeTableColumn;
	@FXML
	private TableColumn<DummyLoadSchedule, String> timezoneTableColumn;
	@FXML
	private TableColumn<DummyLoadSchedule, Boolean> saveChangesTableColumn;

	private final ObservableList<DummyLoadSchedule> loadSchedulesObservableList = FXCollections.observableArrayList();
	private final Callback<TableColumn<DummyLoadSchedule, Date>, TableCell<DummyLoadSchedule, Date>> dateCellFactory = (final TableColumn<DummyLoadSchedule, Date> param) -> new DateEditingCell();
	private final Callback<TableColumn<DummyLoadSchedule, Date>, TableCell<DummyLoadSchedule, Date>> textCellFactory = (final TableColumn<DummyLoadSchedule, Date> param) -> new TextEditingCell();
	private final Callback<TableColumn<DummyLoadSchedule, Boolean>, TableCell<DummyLoadSchedule, Boolean>> buttonCellFactory = (final TableColumn<DummyLoadSchedule, Boolean> param) -> new ButtonCell();
	private final FetchLoadSchedulesService fetchLoadSchedulesService = new FetchLoadSchedulesService();

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		/* add the instantiated controller object to map, so that we can use in the future. */
		this.addThisControllerToControllersMap();

		/* so that we can track if any fxml variables are not injected. */
		this.doAssertion();

		/* This is to bind the observable variables to the actual UI control. Once bound, the data in the observable variable will automatically displayed on the UI control. Note: Initially the variables
		 * value may be null, so nothing appears on the UI control but whenever the value gets changed on the variable either directly or indirectly that will reflect on the UI control automatically.
		 */
		this.doInitialDataBinding();

		this.setAnyUIComponentStateIfNeeded();

		/* This will initialize the user interface ensuring all UI controls are loaded with the proper data. We need to fetch data from DB and construct checkboxes, buttons etc... and display on the UI. */
		this.initializeGUI();

		/* This will create the listeners but wont attach it to any components */
		this.createListeners();

		/* This will initialize bind the listeners to the respective UI controls so that when app is launched, everything is ready for user interaction. */
		this.attachListeners();

		/* This will initialize the tables with the columns and bind the cell value factories for the columns. */
		this.initializeTableViews();
	}

	@Override
	public void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(MainApplicationLoadingScheduleTabController.class, this);
	}

	@Override
	public void doAssertion()
	{
	}

	@Override
	public void doInitialDataBinding()
	{
		this.loadingScheduleTableView.setItems(this.loadSchedulesObservableList);
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
	}

	@Override
	public void initializeGUI()
	{
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener creation starts here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void createListeners()
	{
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener creation ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Listener registration starts here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void attachListeners()
	{
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener registration ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods starts here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods ends here
	 * ============================================================================================================================================================================
	 */

	private void initializeTableViews()
	{
		this.initializeExternalTradeTableView();
	}

	private void initializeExternalTradeTableView()
	{
		//this.loadingStatusTableColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Off", "Load All", "Load By Time", "Load By Trade Date", "Load By Time and TradeDate"));
		this.loadingStatusTableColumn.setCellFactory(ComboBoxTableCell.forTableColumn(LoadScheduleStatus.values()));
		/*
		this.loadingStatusTableColumn.setOnEditCommit((event) -> {
			System.out.println(event.getNewValue());
			final ObservableList<DummyLoadSchedule> items = event.getTableView().getItems();
			System.out.println(items);
			final TablePosition<DummyLoadSchedule, LoadScheduleStatus> tablePosition = event.getTablePosition();
			System.out.println(tablePosition);
			System.out.println(items.get(tablePosition.getRow()));
			System.out.println(tablePosition.getColumn());
			System.out.println(tablePosition.getTableColumn());
		});
		*/

		//this.startTimeTableColumn.setCellFactory(TextFieldTableCell.forTableColumn(null));
		this.startTimeTableColumn.setCellFactory(this.textCellFactory);
		this.stopTimeTableColumn.setCellFactory(this.textCellFactory);

		this.tradeDateTableColumn.setCellFactory(this.dateCellFactory);

		this.timezoneTableColumn.setCellFactory(ComboBoxTableCell.forTableColumn("GMT", "EST", "IST"));
	}

	@FXML
	public void handleShowButtonClick()
	{
		this.showLoadSchedules();
	}

	@FXML
	public void handleSaveButtonClick()
	{
		this.saveLoadSchedules();
	}

	private void showLoadSchedules()
	{
		this.fetchLoadSchedulesFromDBForTableView();
	}

	private void fetchLoadSchedulesFromDBForTableView()
	{
		MappedSelect<DataRow> mappedSelectQueryToFetchLoadSchedules = null;
		mappedSelectQueryToFetchLoadSchedules = CayenneReferenceDataFetchUtil.getSelectQueryForName("FetchLoadSchedules");
		this.fetchLoadSchedulesService.setMappedSelect(mappedSelectQueryToFetchLoadSchedules);

		this.fetchLoadSchedulesService.restart();

		this.fetchLoadSchedulesService.setOnSucceeded((final WorkerStateEvent workerStateEvent) -> {
			this.doThisIfFetchSucceeded();
		});
	}

	private void doThisIfFetchSucceeded()
	{
		final List<DummyLoadSchedule> allLoadSchedules = this.createDummyLoadSchedulesObjectsForLoadScheduleDataRows(this.fetchLoadSchedulesService.getValue());
		this.loadSchedulesObservableList.clear();
		this.loadSchedulesObservableList.addAll(allLoadSchedules);
	}

	private List<DummyLoadSchedule> createDummyLoadSchedulesObjectsForLoadScheduleDataRows(final List<DataRow> loadScheduleDataRows)
	{
		if(loadScheduleDataRows == null)
			return null;
		return loadScheduleDataRows.stream().map(DummyLoadSchedule::new).collect(Collectors.toList());
	}

	private void saveLoadSchedules()
	{
		this.loadingScheduleTableView.getItems().forEach(System.out::println);
	}
}