package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.control.CheckListView;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus;
import com.tc.app.exchangemonitor.model.predicates.ExternalMappingPredicates;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.DatePickerConverter;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainApplicationPositionsTabController implements IMainApplicationMonitorTabController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through FXML starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private ToolBar applicationMainWindowCurrentFilterToolBar;

	@FXML
	private Button startMonitorButton;

	@FXML
	private ImageView startMonitorButtonImageView;

	@FXML
	private Button pauseMonitorButton;

	@FXML
	private Button stopMonitorButton;

	@FXML
	private Text exchangesFilterKeyText;
	@FXML
	private Text exchangesFilterValueText;

	@FXML
	private Text statesFilterKeyText;
	@FXML
	private Text statesFilterValueText;

	@FXML
	private Text typesFilterKeyText;
	@FXML
	private Text typesFilterValueText;

	@FXML
	private Text accountsFilterKeyText;
	@FXML
	private Text accountsFilterValueText;

	@FXML
	private Text startDateFilterKeyText;
	@FXML
	private Text startDateFilterValueText;

	@FXML
	private Text endDateFilterKeyText;
	@FXML
	private Text endDateFilterValueText;

	@FXML
	private TitledPane actionTitledPane;

	@FXML
	private Accordion queryFilterAccordion;

	@FXML
	private CheckListView<ExternalTradeSource> externalTradeSourcesListView;

	@FXML
	private CheckListView<ExternalTradeState> externalTradeStatesListView;

	@FXML
	private CheckListView<ExternalTradeStatus> externalTradeStatusesListView;

	@FXML
	private CheckListView<ExternalMapping> externalTradeAccountsListView;

	@FXML
	private TextField externalTradeAccountsFilterTextField;

	@FXML
	private TitledPane externalTradeSourcesTitledPane;

	@FXML
	private TitledPane externalTradeStatesTitledPane;

	@FXML
	private TitledPane externalTradeStatusesTitledPane;

	@FXML
	private TitledPane externalTradeAccountsTitledPane;

	@FXML
	private DatePicker startDateDatePicker;

	@FXML
	private DatePicker endDateDatePicker;

	@FXML
	private TableView<DummyPosition> dummyPositionsTableView;

	/**
	 * ============================================================================================================================================================================
	 * All FXML Variables ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through @Inject starts here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through @Inject ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All other variable declaration starts here
	 * ============================================================================================================================================================================
	 */

	private ChangeListener<Toggle> externalTradeSourcesRadioButtonClickListener = null;
	private ListChangeListener<ExternalTradeState> externalTradeStatesCheckBoxClickListener = null;
	private ListChangeListener<ExternalTradeStatus> externalTradeStatusesCheckBoxClickListener = null;
	private ListChangeListener<ExternalMapping> externalTradeAccountsCheckBoxClickListener = null;
	private ChangeListener<String> externalTradeAccountsFilterTextFieldKeyListener = null;

	private final List<ExternalMapping> externalTradeAccounts = new ArrayList<>();

	private final List<ExternalMapping> checkedExternalTradeAccounts = new ArrayList<>();

	private final ObservableList<ExternalTradeSource> externalTradeSourceObservableList = FXCollections.observableArrayList();

	private final ObservableList<ExternalTradeState> externalTradeStateObservableList = FXCollections.observableArrayList();

	private final ObservableList<ExternalTradeStatus> externalTradeStatusObservableList = FXCollections.observableArrayList();

	private final ObservableList<ExternalMapping> externalTradeAccountObservableList = FXCollections.observableArrayList();

	// private ObservableList<DummyPosition> dummyPositionsObservableList = FXCollections.observableArrayList();
	private final ObservableList<DummyPosition> dummyPositionsObservableList = FXCollections.observableArrayList(aPosition -> new Observable[] {aPosition.totalProperty()});

	private final FetchPositionsScheduledService fetchPositionsScheduledService = new FetchPositionsScheduledService();

	/**
	 * ============================================================================================================================================================================
	 * All other variable declaration ends here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		/* add the instantiated controller object to map, so that we can use in the future. */
		this.addThisControllerToControllersMap();

		/* so that we can track if any fxml variables are not injected. */
		this.doAssertion();

		/*
		 * This is to bind the observable variables to the actual UI control. Once bound, the data in the observable variable will automatically displayed on the UI control.
		 * Note: Initially the variables value may be null, so nothing appears on the UI control but whenever the value gets changed on the variable either directly or indirectly
		 * that will reflect on the UI control automatically.
		 */
		this.doInitialDataBinding();

		/* This will initialize the user interface ensuring all UI controls are loaded with the proper data. We need to fetch data from DB and construct checkboxes, buttons etc... and display on the UI. */
		this.initializeGUI();

		this.setAnyUIComponentStateIfNeeded();

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
		ApplicationHelper.controllersMap.putInstance(MainApplicationPositionsTabController.class, this);
	}

	@Override
	public void doAssertion()
	{
	}

	@Override
	public void doInitialDataBinding()
	{
		/*
		Callback<ExternalTrade, List<MenuItem>> rowMenuItemFactory = new Callback<ExternalTrade, List<MenuItem>>() {
			@Override
			public List<MenuItem> call(ExternalTrade param) {
				final MenuItem addMenuItem = new MenuItem("Add");
				final MenuItem updateMenuItem = new MenuItem("Update");
				final MenuItem deleteMenuItem = new MenuItem("Delete");

				//return Collections.singletonList(addMenuItem);
				return Arrays.asList(addMenuItem, updateMenuItem, deleteMenuItem);
			}
		};
		 */

		//externalTradesTableView.setRowFactory(new CustomRowFactory<ExternalTrade>(null));
		//externalTradesTableView.setRowFactory(new CustomRowFactory<ExternalTrade>(rowMenuItemFactory));

		/*
		 * Since startDate and endDate are set as NULL initially, "null" is appearing in the startDateFilterText and endDateFilterText and bcoz of that the
		 * Text control is appearing in the UI. To get rid of that we are hiding the Text control if it contains text equals to "null"
		 */
		this.startDateFilterValueText.visibleProperty().bind(this.startDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.endDateFilterValueText.visibleProperty().bind(this.endDateFilterValueText.textProperty().isNotEqualTo("null"));

		this.exchangesFilterKeyText.visibleProperty().bind(this.exchangesFilterValueText.textProperty().isNotEmpty());
		this.exchangesFilterKeyText.managedProperty().bind(this.exchangesFilterKeyText.visibleProperty());
		this.exchangesFilterValueText.managedProperty().bind(this.exchangesFilterValueText.visibleProperty());

		this.statesFilterKeyText.visibleProperty().bind(this.statesFilterValueText.textProperty().isNotEmpty());
		this.statesFilterKeyText.managedProperty().bind(this.statesFilterKeyText.visibleProperty());
		this.statesFilterValueText.managedProperty().bind(this.statesFilterValueText.visibleProperty());

		this.typesFilterKeyText.visibleProperty().bind(this.typesFilterValueText.textProperty().isNotEmpty());
		this.typesFilterKeyText.managedProperty().bind(this.typesFilterKeyText.visibleProperty());
		this.typesFilterValueText.managedProperty().bind(this.typesFilterValueText.visibleProperty());

		this.accountsFilterKeyText.visibleProperty().bind(this.accountsFilterValueText.textProperty().isNotEmpty());
		this.accountsFilterKeyText.managedProperty().bind(this.accountsFilterKeyText.visibleProperty());
		this.accountsFilterValueText.managedProperty().bind(this.accountsFilterValueText.visibleProperty());

		this.startDateFilterKeyText.visibleProperty().bind(this.startDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.startDateFilterKeyText.managedProperty().bind(this.startDateFilterKeyText.visibleProperty());
		this.startDateFilterValueText.managedProperty().bind(this.startDateFilterValueText.visibleProperty());

		this.endDateFilterKeyText.visibleProperty().bind(this.endDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.endDateFilterKeyText.managedProperty().bind(this.endDateFilterKeyText.visibleProperty());
		this.endDateFilterValueText.managedProperty().bind(this.endDateFilterValueText.visibleProperty());

		//dummyPositionsTableView.setItems(dummyPositionsSortedList);
		this.dummyPositionsTableView.setItems(new LineItemListWithTotal(this.dummyPositionsObservableList));

		this.startDateFilterValueText.textProperty().bind(this.startDateDatePicker.valueProperty().asString());
		this.endDateFilterValueText.textProperty().bind(this.endDateDatePicker.valueProperty().asString());

		this.startMonitorButton.disableProperty().bind(this.fetchPositionsScheduledService.runningProperty());
		this.pauseMonitorButton.disableProperty().bind(this.fetchPositionsScheduledService.runningProperty().not());
		this.stopMonitorButton.disableProperty().bind(this.fetchPositionsScheduledService.runningProperty().not());

		//actionTitledPane.disableProperty().bind(fetchExternalTradesScheduledService.runningProperty());
		//queryFilterAccordion.disableProperty().bind(fetchExternalTradesScheduledService.runningProperty());
		//externalTradeTableViewDataFilterTextField.disableProperty().bind(fetchExternalTradesScheduledService.runningProperty());

		//applicationMainWindowCurrentFilterToolBar.visibleProperty().bind(exchangesFilterText.textProperty().isNotEmpty().or(statesFilterText.textProperty().isNotEmpty()).or(typesFilterText.textProperty().isNotEmpty()).or(accountsFilterText.textProperty().isNotEmpty()).or(startDateFilterText.textProperty().isNotEqualTo("null")).or(endDateFilterText.textProperty().isNotEqualTo("null")));
		/* We are hiding the entire toolbar if no text in any of the Text control. */
		this.applicationMainWindowCurrentFilterToolBar.visibleProperty().bind(
		this.exchangesFilterKeyText.visibleProperty()
		.or(this.statesFilterKeyText.visibleProperty())
		.or(this.typesFilterKeyText.visibleProperty())
		.or(this.accountsFilterKeyText.visibleProperty())
		.or(this.startDateFilterKeyText.visibleProperty())
		.or(this.endDateFilterKeyText.visibleProperty()));

		this.externalTradeSourcesListView.setItems(this.externalTradeSourceObservableList);
		this.externalTradeStatesListView.setItems(this.externalTradeStateObservableList);
		this.externalTradeStatusesListView.setItems(this.externalTradeStatusObservableList);
		this.externalTradeAccountsListView.setItems(this.externalTradeAccountObservableList);
	}

	@Override
	public void initializeGUI()
	{
		/**
		 * fetch exchanges from external_trade_source table and construct checkbox for each exchange and set it on the UI
		 */
		this.fetchExternalTradeSources();

		/**
		 * fetch external trades states from external_trade_state table and construct checkbox for each trade state and set it on the UI
		 */
		this.fetchExternalTradeStates();

		/**
		 * fetch external trades statuses from external_trade_status table and construct checkbox for each trade status and set it on the UI
		 */
		this.fetchExternalTradeStatuses();

		/**
		 * fetch trade accounts from external_mapping table and with mapping_type 'K' and construct checkbox for trade account and set it on the UI
		 */
		this.fetchExternalTradeAccounts();

		/**
		 * set yesterday's date as default start date
		 */
		//startDateDatePicker.setValue(LocalDate.now().minusDays(1));
		this.startDateDatePicker.setValue(null);
		this.startDateDatePicker.setConverter(new DatePickerConverter("dd-MMM-yyyy"));
		//startDateDatePicker.setPromptText("dd-MMM-yyyy");

		/**
		 * set today's date as default end date
		 */
		//endDateDatePicker.setValue(LocalDate.now());
		this.endDateDatePicker.setValue(null);
		this.endDateDatePicker.setConverter(new DatePickerConverter("dd-MMM-yyyy"));

		/**
		 * fetch external trade types from external_trade_type table so that we can use when we display data in the TableView, since we need to display the trade_type_name in the UI
		 */
	}

	private void fetchExternalTradeSources()
	{
		this.externalTradeSourceObservableList.addAll(CayenneReferenceDataCache.loadExternalTradeSources().values());
	}

	private void fetchExternalTradeStates()
	{
		this.externalTradeStateObservableList.addAll(CayenneReferenceDataCache.loadExternalTradeStates().values());
	}

	private void fetchExternalTradeStatuses()
	{
		this.externalTradeStatusObservableList.addAll(CayenneReferenceDataCache.loadExternalTradeStatuses().values());
	}

	private void fetchExternalTradeAccounts()
	{
		this.externalTradeAccounts.addAll(CayenneReferenceDataCache.loadExternalTradeAccounts().values());
		// the below line is creating a dummy external mapping record with name "Any". not a better way.
		final ExternalMapping anyExternalMapping = CayenneHelper.getCayenneServerRuntime().newContext().newObject(ExternalMapping.class);
		anyExternalMapping.setExternalValue1("Any");
		this.externalTradeAccounts.add(0, anyExternalMapping);
		this.externalTradeAccountObservableList.addAll(this.externalTradeAccounts);
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		//externalTradeSourcesListView.setCellFactory(new ExternalTradeSourceRadioButtonCellFactory());
		//externalTradeSourcesListView.setCellFactory((param) -> new ExternalTradeSourceRadioCell());
		//this.externalTradeSourcesListView.setCellFactory((param) -> new RadioCell());
		this.externalTradeSourcesListView.setCellFactory((param) -> new ExternalTradeSourceRadioCellForPositionsTab());
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener creation starts here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void createListeners()
	{
		//externalTradeSourcesCheckBoxClickListener = (change) -> { handleExternalTradeSourcesCheckBoxClick(change); };
		this.externalTradeSourcesRadioButtonClickListener = (observavleValue, oldValue, newValue) -> { this.handleExternalTradeSourcesRadioButtonClick(oldValue, newValue); };
		this.externalTradeStatesCheckBoxClickListener = (change) -> { this.handleExternalTradeStatesCheckBoxClick(change); };
		this.externalTradeStatusesCheckBoxClickListener = (change) -> { this.handleExternalTradeStatusesCheckBoxClick(change); };
		this.externalTradeAccountsCheckBoxClickListener = (change) -> { this.handleExternalTradeAccountsCheckBoxClick(change); };
		this.externalTradeAccountsFilterTextFieldKeyListener = (observavleValue, oldValue, newValue) -> { this.handleExternalTradeAccountsFilterByKey(oldValue, newValue); };
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
		//externalTradeSourcesListView.getCheckModel().getCheckedItems().addListener((Change<? extends ExternalTradeSource> change) -> { handleExternalTradeSourcesCheckBoxClick(change); });
		//the above code is commented and implemented as below.
		//externalTradeSourcesListView.getCheckModel().getCheckedItems().addListener(externalTradeSourcesCheckBoxClickListener);
		//toggleGroup.selectedToggleProperty().addListener(this.externalTradeSourcesRadioButtonClickListener);
		ExternalTradeSourceRadioCellForPositionsTab.toggleGroup.selectedToggleProperty().addListener(this.externalTradeSourcesRadioButtonClickListener);
		this.externalTradeStatesListView.getCheckModel().getCheckedItems().addListener(this.externalTradeStatesCheckBoxClickListener);
		this.externalTradeStatusesListView.getCheckModel().getCheckedItems().addListener(this.externalTradeStatusesCheckBoxClickListener);
		this.externalTradeAccountsListView.getCheckModel().getCheckedItems().addListener(this.externalTradeAccountsCheckBoxClickListener);
		this.externalTradeAccountsFilterTextField.textProperty().addListener(this.externalTradeAccountsFilterTextFieldKeyListener);
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

	private void handleExternalTradeAccountsFilterByKey(final String oldValue, String newValue)
	{
		// If the number of characters in the text box is less than last time it must be because the user pressed delete
		if((oldValue != null) && (newValue.length() < oldValue.length()))
		{
			// Restore the lists original set of entries and start from the beginning
			this.externalTradeAccountsListView.setItems(FXCollections.observableArrayList(this.externalTradeAccounts));
		}

		// Change to upper case so that case is not an issue
		newValue = newValue.toUpperCase();

		// Filter out the entries that don't contain the entered text
		final ObservableList<ExternalMapping> subentries = FXCollections.observableArrayList();

		for(final ExternalMapping entry : this.externalTradeAccountsListView.getItems())
		{
			if(entry.getExternalValue1().toUpperCase().contains(newValue))
			{
				subentries.add(entry);
			}
		}
		this.externalTradeAccountsListView.setItems(subentries);

		for(final ExternalMapping string : this.checkedExternalTradeAccounts)
		{
			if(subentries.contains(string))
			{
				this.externalTradeAccountsListView.getCheckModel().check(string);
			}
		}
		this.externalTradeAccountsListView.getCheckModel().getCheckedItems().addListener(this.externalTradeAccountsCheckBoxClickListener);
	};

	private void handleExternalTradeSourcesRadioButtonClick(final Toggle oldValue, final Toggle newValue)
	{
		if(newValue == null)
		{
			this.externalTradeSourcesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_SOURCES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeSourcesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_SOURCES_TITLEDPANE_TEXT + "(" + 1 + ")");
		}

		this.exchangesFilterValueText.setText(((RadioButton) newValue).getText());
	}

	private void handleExternalTradeStatesCheckBoxClick(final Change<? extends ExternalTradeState> change)
	{
		if(this.externalTradeStatesListView.getCheckModel().getCheckedItems().size() == 0)
		{
			this.externalTradeStatesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeStatesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATES_TITLEDPANE_TEXT + "(" + this.externalTradeStatesListView.getCheckModel().getCheckedItems().size() + ")");
		}

		if(this.externalTradeStatesListView.getCheckModel().getCheckedItems().size() > 0)
		{
			this.statesFilterValueText.setText(this.externalTradeStatesListView.getCheckModel().getCheckedItems().toString());
		}
		else
		{
			this.statesFilterValueText.setText(null);
		}
	};

	private void handleExternalTradeStatusesCheckBoxClick(final Change<? extends ExternalTradeStatus> change)
	{
		if(this.externalTradeStatusesListView.getCheckModel().getCheckedItems().size() == 0)
		{
			this.externalTradeStatusesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATUSES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeStatusesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATUSES_TITLEDPANE_TEXT + "(" + this.externalTradeStatusesListView.getCheckModel().getCheckedItems().size() + ")");
		}

		if(this.externalTradeStatusesListView.getCheckModel().getCheckedItems().size() > 0)
		{
			this.typesFilterValueText.setText(this.externalTradeStatusesListView.getCheckModel().getCheckedItems().toString());
		}
		else
		{
			this.typesFilterValueText.setText(null);
		}
	};

	private void handleExternalTradeAccountsCheckBoxClick(final Change<? extends ExternalMapping> change)
	{
		change.next();
		if(change.wasAdded())
		{
			this.checkedExternalTradeAccounts.add(change.getAddedSubList().get(0));
		}
		else if(change.wasRemoved())
		{
			this.checkedExternalTradeAccounts.remove(change.getRemoved().get(0));
		}
		if(this.checkedExternalTradeAccounts.size() == 0)
		{
			this.externalTradeAccountsTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_ACCOUNTS_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeAccountsTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_ACCOUNTS_TITLEDPANE_TEXT + "(" + this.checkedExternalTradeAccounts.size() + ")");
		}

		if(this.checkedExternalTradeAccounts.size() > 0)
		{
			this.accountsFilterValueText.setText(this.checkedExternalTradeAccounts.toString());
		}
		else
		{
			this.accountsFilterValueText.setText(null);
		}
	};

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods ends here
	 * ============================================================================================================================================================================
	 */

	private void initializeTableViews()
	{
		this.initializeDummyPositionsTableView();
	}

	private void initializeDummyPositionsTableView()
	{
		//externalTradesTableView.getSelectionModel().setCellSelectionEnabled(true);
		//externalTradesTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	/**
	 * ============================================================================================================================================================================
	 * All Event Handling logic starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private void handleStartMonitorButtonClick()
	{
		this.startMonitoringPositions();
	}

	@FXML
	private void handlePauseMonitorButtonClick()
	{
		this.pauseMonitoringPositions();
	}

	@FXML
	private void handleStopMonitorButtonClick()
	{
		this.stopMonitoringPositions();
	}

	private void startMonitoringPositions()
	{
		//acc.setExpandedPane(externalTradeSourcesTitledPane);
		this.fetchPositionsFromDBForTableView();
	}

	private void pauseMonitoringPositions()
	{
		if(this.fetchPositionsScheduledService != null)
		{
			if(this.fetchPositionsScheduledService.isRunning())
			{
				this.fetchPositionsScheduledService.cancel();
				//statusMessagesProperty().set("Task Stopped.");
				//progressStatusesProperty().set(0.0);
			}
		}
	}

	private void stopMonitoringPositions()
	{
		this.pauseMonitoringPositions();
		this.dummyPositionsObservableList.clear();

	}

	private void fetchPositionsFromDBForTableView()
	{
		MappedSelect<DataRow> mappedSelectQueryToFetchPositions = null;
		final Map parametersMap = new HashMap<>();
		String selectedStartDate = null;
		String selectedEndDate = null;

		final String selectedExternalTradeSourceName = this.getExternalTradeSourcesSelectedByUserFromUI().getText();
		final List<ExternalTradeState> externalTradeStateObjectsSelectedByUserFromUI = this.getExternalTradeStatesSelectedByUserFromUI();
		final List<ExternalTradeStatus> externalTradeStatusObjectsSelectedByUserFromUI = this.getExternalTradeStatusesSelectedByUserFromUI();
		final List<ExternalMapping> externalTradeAccountObjectsSelectedByUserFromUI = this.getExternalTradeAccountsSelectedByUserFromUI();

		/*
		final List<String> selectedExternalTradeSourceNames = new ArrayList<>();
		externalTradeSourceObjectsSelectedByUserFromUI.forEach((anExternalTradeSourceEntity) -> selectedExternalTradeSourceNames.add(anExternalTradeSourceEntity.getExternalTradeSourceOid().toString()));
		*/
		// The above 2 lines are commented and implemented as below.
		//final List<String> selectedExternalTradeSourceNames = externalTradeSourceObjectsSelectedByUserFromUI.stream().map(ExternalTradeSource::getExternalTradeSrcName).map(String::trim).collect(Collectors.toList());
		final Integer selectedExternalTradeSourceOid = CayenneReferenceDataCache.loadExternalTradeSources().get(selectedExternalTradeSourceName).getExternalTradeSourceOid();
		final List<Integer> selectedExternalTradeStates = externalTradeStateObjectsSelectedByUserFromUI.stream().map(ExternalTradeState::getExternalTradeStateOid).collect(Collectors.toList());
		final List<Integer> selectedExternalTradeStatuses = externalTradeStatusObjectsSelectedByUserFromUI.stream().map(ExternalTradeStatus::getExternalTradeStatusOid).collect(Collectors.toList());
		final List<String> selectedExternalTradeAccounts = externalTradeAccountObjectsSelectedByUserFromUI.stream().map(ExternalMapping::getExternalValue1).map(String::trim).collect(Collectors.toList());
		selectedStartDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.startDateDatePicker.getValue() != null ? this.startDateDatePicker.getValue() : LocalDate.now());
		selectedEndDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.endDateDatePicker.getValue() != null ? this.endDateDatePicker.getValue() : LocalDate.now());

		//if(this.externalTradeAccountsListView.getCheckModel().getCheckedItems().size() == 0)
		if((selectedExternalTradeAccounts.size() == 0) || selectedExternalTradeAccounts.contains("Any"))
		{
			/* We are here bcoz, user didn't select any account or selected "Any" as account. So we should not care about the buyer account in the qulaifier. */
			mappedSelectQueryToFetchPositions = CayenneReferenceDataFetchUtil.getSelectQueryForName("PositionWithoutBuyerAccount");
		}
		else
		{
			mappedSelectQueryToFetchPositions = CayenneReferenceDataFetchUtil.getSelectQueryForName("PositionWithBuyerAccount");
			parametersMap.put("buyerAccountsParam", selectedExternalTradeAccounts);
		}
		parametersMap.put("externalTradeSourcesParam", selectedExternalTradeSourceOid);
		parametersMap.put("externalTradeStatusesParam", selectedExternalTradeStatuses);
		parametersMap.put("externalTradeStatesParam", selectedExternalTradeStates);
		parametersMap.put("startDateParam", selectedStartDate);
		parametersMap.put("endDateParam", selectedEndDate);
		mappedSelectQueryToFetchPositions.params(parametersMap);

		/* This will fetch the data in a background thread, so UI will not be freezed and user can interact with the UI. Here we use a scheduled service which will invoke the task recurringly. */
		this.fetchPositionsScheduledService.setMappedSelect(mappedSelectQueryToFetchPositions);
		this.fetchPositionsScheduledService.setDelay(Duration.seconds(1));
		this.fetchPositionsScheduledService.setPeriod(Duration.seconds(10));

		/*
		 *  modified the above 2 lines as below. previously statusMessagesProperty and progressStatusesProperty are available in the same class but now moved to a different controller.
		 *  Eventually the below code has to be modified to access those properties from the respective controller class.
		 *  Currently accessing the statusMessagesProperty and progressStatusesProperty through the controller whose reference is injected while loading. this may not be the perfect approach,
		 *  need to find out a better way.
		 */
		// commenting the below lines temporarily. if enabled this will update the progress property and message property of the status bar but that is already getting updated by the external trades monitoring.
		/*
		 * fetchPositionsScheduledService.messageProperty().addListener((ObservableValue<? extends String> observableValue, String oldValue, String newValue) -> { ApplicationHelper.controllersMap.getInstance(MainWindowController.class).statusMessagesProperty().set(newValue); });
		 * fetchPositionsScheduledService.progressProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) -> { ApplicationHelper.controllersMap.getInstance(MainWindowController.class).progressStatusesProperty().set(newValue.doubleValue()); });
		 */

		this.fetchPositionsScheduledService.restart();

		this.fetchPositionsScheduledService.setOnSucceeded((final WorkerStateEvent workerStateEvent) -> { this.doThisIfFetchSucceeded(); });
	}

	public RadioButton getExternalTradeSourcesSelectedByUserFromUI()
	{
		return (RadioButton) ExternalTradeSourceRadioCellForPositionsTab.toggleGroup.getSelectedToggle();
	}

	public List<ExternalTradeState> getExternalTradeStatesSelectedByUserFromUI()
	{
		return this.externalTradeStatesListView.getCheckModel().getCheckedItems();
	}

	public List<ExternalTradeStatus> getExternalTradeStatusesSelectedByUserFromUI()
	{
		return this.externalTradeStatusesListView.getCheckModel().getCheckedItems();
	}

	public List<ExternalMapping> getExternalTradeAccountsSelectedByUserFromUI()
	{
		return this.externalTradeAccountsListView.getCheckModel().getCheckedItems();
	}

	private void doThisIfFetchSucceeded()
	{
		String selectedSource = null;
		//List<DummyPosition> listOfUniquePositions = fetchPositionsScheduledService.getValue().stream().distinct().collect(Collectors.toList());
		//final List<DummyPosition> listOfUniquePositions = this.fetchPositionsScheduledService.getValue().stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

		final List<DummyPosition> allPositions = this.createDummyPositionObjectsForPositionDataRows(this.fetchPositionsScheduledService.getValue());
		final List<DummyPosition> listOfUniquePositions = allPositions.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

		/*
		 * NEVER EVER DO THIS. Logging the entire collection leads to enormous amount of toString() calls and that leads to Out of memory, N+1 select problem, thread starvation (logging is
		 * synchronous), lazy initialization exception, logs storage filled completely. It is always better to log only
		 * the collection size or the id's of the collection objects. But we do here bcoz the collection size is limited here.
		 */
		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("listOfUniquePositions : {}", listOfUniquePositions);
		}

		if(ExternalTradeSourceRadioCellForPositionsTab.toggleGroup.getSelectedToggle() == null)
			return;

		selectedSource = ((RadioButton) ExternalTradeSourceRadioCellForPositionsTab.toggleGroup.getSelectedToggle()).getText();
		final List<String> homeCompanyNames = this.getHomeCompaniesForSource(selectedSource);
		LOGGER.info("HomeCompanies Count : {} HomeCompanies : {}", homeCompanyNames.size(), homeCompanyNames);


		listOfUniquePositions.stream().forEach((aPosition) -> {
			if(homeCompanyNames.contains(aPosition.getInputCompany()))
			{
				aPosition.setBuySell(aPosition.getInputAction());
			}
			else if(homeCompanyNames.contains(aPosition.getAcceptedCompany()))
			{
				aPosition.setBuySell(aPosition.getAcceptedAction());
			}
			else
			{
				LOGGER.info("Home companies not matching ");
			}
		});

		/*
		 * Map<String, List<DummyPosition>> positionByCommodityMap = aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity)); Map<String, Collection<List<DummyPosition>>> positionByCommodityAndTradingPeriodMap =
		 * aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.collectingAndThen(Collectors.groupingBy(DummyPosition::getTradingPeriod), Map::values))); Map<String, List<List<DummyPosition>>> positionByCommodityAndTradingPeriodList =
		 * aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.collectingAndThen(Collectors.groupingBy(DummyPosition::getTradingPeriod), m -> new ArrayList<>(m.values())))); Map<String, Collection<List<DummyPosition>>>
		 * positionByCommodityAndTradingPeriodCollection = aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.collectingAndThen(Collectors.groupingBy(DummyPosition::getTradingPeriod), m -> new ArrayList<>(m.values())))); Map<String, Map<String,
		 * List<DummyPosition>>> map1 = aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.groupingBy(DummyPosition::getTradingPeriod))); Map<String, Map<String, Map<String, List<DummyPosition>>>> map2 =
		 * aDummyPositionList.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.groupingBy(DummyPosition::getTradingPeriod, Collectors.groupingBy(DummyPosition::getCallPut)))); List<Collector<DummyPosition, ?, ?>> collectors =
		 * Arrays.asList(Collectors.groupingBy(DummyPosition::getCommodity), Collectors.groupingBy(DummyPosition::getTradingPeriod));
		 */
		// map3.values().forEach(a -> a.values().forEach(b -> b.values().forEach(c -> c.values().forEach(d -> System.out.println(d)))));

		this.dummyPositionsObservableList.clear();
		// addTradePosition(listOfUniquePositions);
		final Map<String, Map<String, Map<String, Map<Double, List<DummyPosition>>>>> mapOfGroupedPostions = listOfUniquePositions.stream().collect(Collectors.groupingBy(DummyPosition::getCommodity, Collectors.groupingBy(DummyPosition::getTradingPeriod, Collectors.groupingBy(DummyPosition::getCallPut, Collectors.groupingBy(DummyPosition::getStrikePrice)))));
		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("mapOfGroupedPostions : {}", mapOfGroupedPostions);
		}

		/*
		 * mapOfGroupedPostions.values().forEach(a -> a.values().forEach(b -> b.values().forEach(theMap -> { System.out.println("theMap : " + theMap); dummyPositionsObservableList.add(doThis(theMap)); })));
		 */

		mapOfGroupedPostions.values().forEach(a -> a.values().forEach(b -> b.values().forEach(theMap -> theMap.values().forEach(listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice -> {
			if(IS_DEBUG_ENABLED)
			{
				LOGGER.debug("listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice {}", listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice);
			}
			this.dummyPositionsObservableList.add(this.doThis(listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice));
		}))));
	}

	private DummyPosition doThis(final List<DummyPosition> listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice)
	{
		final DummyPosition aTempPosition = new DummyPosition();
		// something.forEach(aPositionList -> {
		for(final DummyPosition aPosition : listOfPositionGroupedByCommodityTradingPeriodCallputStrikePrice)
		{
			/* This will set again and again but seems no other way */
			aTempPosition.setCommodity(aPosition.getCommodity());
			aTempPosition.setTradingPeriod(aPosition.getTradingPeriod());
			aTempPosition.setCallPut(aPosition.getCallPut());
			// aTempPosition.setStrikePrice(aPosition.getStrikePrice());
			aTempPosition.setStrikePrice(aPosition.getStrikePrice());

			if(aPosition.getBuySell().equals("BUY"))
			{
				aTempPosition.setLastPrice(aPosition.getPrice());
				aTempPosition.setBuyPositionPrice(0.0);
				//aTempPosition.setSellPosition(0.0);
				//aTempPosition.setSellPositionPrice(0.0);
				//aTempPosition.setSellPositionValue(0.0);

				if(aPosition.getExternalTradeStateName().equals("Add") || aPosition.getExternalTradeStateName().equals("Update"))
				{
					aTempPosition.setBuyPosition(aTempPosition.getBuyPosition() + aPosition.getQuantity());
					aTempPosition.setBuyPositionValue(aTempPosition.getBuyPositionValue() + (aPosition.getQuantity() * aPosition.getPrice()));
				}
				else if(aPosition.getExternalTradeStateName().equals("Delete"))
				{
					aTempPosition.setBuyPosition(aTempPosition.getBuyPosition() - aPosition.getQuantity());
					aTempPosition.setBuyPositionValue(aTempPosition.getBuyPositionValue() - (aPosition.getQuantity() * aPosition.getPrice()));
				}
				// aTempPosition.setBuyPosition(aTempPosition.getBuyPosition() + aPosition.getQuantity());
				// aTempPosition.setBuyPositionValue(aTempPosition.getBuyPositionValue() + (aPosition.getQuantity() * aPosition.getPrice()));

			}
			else if(aPosition.getBuySell().equals("SELL"))
			{
				aTempPosition.setLastPrice(aPosition.getPrice());
				aTempPosition.setSellPositionPrice(0.0);
				// aTempPosition.setBuyPosition(0.0);
				// aTempPosition.setBuyPositionPrice(0.0);
				// aTempPosition.setBuyPositionValue(0.0);

				if(aPosition.getExternalTradeStateName().equals("Add") || aPosition.getExternalTradeStateName().equals("Update"))
				{
					aTempPosition.setSellPosition(aTempPosition.getSellPosition() + aPosition.getQuantity());
					aTempPosition.setSellPositionValue(aTempPosition.getSellPositionValue() + (aPosition.getQuantity() * aPosition.getPrice()));
				}
				else if(aPosition.getExternalTradeStateName().equals("Delete"))
				{
					aTempPosition.setSellPosition(aTempPosition.getSellPosition() - aPosition.getQuantity());
					aTempPosition.setSellPositionValue(aTempPosition.getSellPositionValue() - (aPosition.getQuantity() * aPosition.getPrice()));
				}
			}
		}
		// });
		aTempPosition.setAverageBuyPrice(aTempPosition.getBuyPositionValue() / aTempPosition.getBuyPosition());
		aTempPosition.setAverageSellPrice(aTempPosition.getSellPositionValue() / aTempPosition.getSellPosition());
		aTempPosition.setNetQuantity(aTempPosition.getBuyPosition() - aTempPosition.getSellPosition());
		// aTempPosition.setPL(aTempPosition.getSellPositionValue() - aTempPosition.getBuyPositionValue() + (aTempPosition.getLastPrice() * aTempPosition.getBuyPosition()) - (aTempPosition.getLastPrice() * aTempPosition.getSellPosition()));
		aTempPosition.setTotal((((aTempPosition.getSellPositionValue() - aTempPosition.getBuyPositionValue()) + (aTempPosition.getLastPrice() * aTempPosition.getBuyPosition())) - (aTempPosition.getLastPrice() * aTempPosition.getSellPosition())) * 1000);
		aTempPosition.setTotal(Double.parseDouble(new DecimalFormat("##.##").format(aTempPosition.getTotal())));

		/*
		System.out.println(Double.parseDouble(new DecimalFormat("##.##").format(aTempPosition.getSellPositionValue() - aTempPosition.getBuyPositionValue() + (aTempPosition.getLastPrice() * aTempPosition.getBuyPosition()) - (aTempPosition.getLastPrice() * aTempPosition.getSellPosition()))));
		System.out.println((aTempPosition.getSellPositionValue() - aTempPosition.getBuyPositionValue() + (aTempPosition.getLastPrice() * aTempPosition.getBuyPosition()) - (aTempPosition.getLastPrice() * aTempPosition.getSellPosition()) * 100)/100);
		LOGGER.info(aTempPosition.getTotal());
		LOGGER.info(Math.round(aTempPosition.getTotal() * 100.0) / 100.0);
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.##").format(aTempPosition.getTotal())));
		LOGGER.info(new BigDecimal(aTempPosition.getTotal()).round(new MathContext(2)).doubleValue());

		LOGGER.info(aTempPosition.getStrikePrice());
		LOGGER.info(Math.round(aTempPosition.getStrikePrice() * 100.0) / 100.0);
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.##").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("#.#").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.########").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.####").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.0000").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.00##").format(aTempPosition.getStrikePrice())));
		LOGGER.info(Double.parseDouble(new DecimalFormat("##.00").format(aTempPosition.getStrikePrice())));
		LOGGER.info(new DecimalFormat("##.####").format(aTempPosition.getStrikePrice()));
		LOGGER.info(new DecimalFormat("##.######").format(aTempPosition.getStrikePrice()));
		LOGGER.info(new DecimalFormat("##.##").format(aTempPosition.getStrikePrice()));
		LOGGER.info(new DecimalFormat("##.00").format(aTempPosition.getStrikePrice()));
		LOGGER.info(new DecimalFormat("##.0000").format(aTempPosition.getStrikePrice()));
		 */
		LOGGER.info(aTempPosition.getCommodity() + " <--> " + aTempPosition.getTradingPeriod() + " <--> " + aTempPosition.getCallPut() + " <--> " + aTempPosition.getStrikePrice() + " <--> " + aTempPosition.getBuyPosition() + " <--> " + aTempPosition.getAverageBuyPrice() + " <--> " + aTempPosition.getSellPosition() + " <--> " + aTempPosition.getAverageSellPrice() + " <--> " + aTempPosition.getNetQuantity() + " <--> " + aTempPosition.getLastPrice() + " <--> " + aTempPosition.getTotal());
		return aTempPosition;
	}

	private List<String> getHomeCompaniesForSource(final String selectedSource)
	{
		final Predicate<ExternalMapping> homeCompanyPredicate;
		switch(selectedSource)
		{
			case "NYMEX":
				homeCompanyPredicate = ExternalMappingPredicates.isNymexBookingCompanyPredicate;
				break;

			case "IPE":
				homeCompanyPredicate = ExternalMappingPredicates.isIpeBookingCompanyPredicate;
				break;

			case "ICE":
				homeCompanyPredicate = ExternalMappingPredicates.isIceBookingCompanyPredicate;
				break;

			case "ExchangeTools":
				homeCompanyPredicate = ExternalMappingPredicates.isExchangeToolsBookingCompanyPredicate;
				break;

			case "Dashboard":
				homeCompanyPredicate = ExternalMappingPredicates.isDashBoardBookingCompanyPredicate;
				break;

			case "Excel":
				homeCompanyPredicate = ExternalMappingPredicates.isExcelBookingCompanyPredicate;
				break;

			case "DME":
				homeCompanyPredicate = ExternalMappingPredicates.isDMEBookingCompanyPredicate;
				break;

			case "ECONFIRM":
				homeCompanyPredicate = ExternalMappingPredicates.isECONFIRMBookingCompanyPredicate;
				break;

			case "CEE":
				homeCompanyPredicate = ExternalMappingPredicates.isCEEBookingCompanyPredicate;
				break;

			case "Olympus":
				homeCompanyPredicate = ExternalMappingPredicates.isOlympusBookingCompanyPredicate;
				break;

			case "CBT":
				homeCompanyPredicate = ExternalMappingPredicates.isCBTBookingCompanyPredicate;
				break;

			default:
				homeCompanyPredicate = null;
				break;
		}
		final List<ExternalMapping> homeCompanyObjects = ExternalMappingPredicates.filterExternalMappings(CayenneReferenceDataCache.loadExternalMappings(), homeCompanyPredicate);
		final List<String> homeCompanyNames = homeCompanyObjects.stream().map(ExternalMapping::getExternalValue1).collect(Collectors.toList());
		return homeCompanyNames;
	}

	private List<DummyPosition> createDummyPositionObjectsForPositionDataRows(final ObservableList<DataRow> positionDataRows)
	{
		if(positionDataRows == null)
			return null;
		return positionDataRows.stream().map(DummyPosition::new).collect(Collectors.toList());
	}
}

/**
 * ============================================================================================================================================================================
 * All Event Handling logic ends here
 * ============================================================================================================================================================================
 */