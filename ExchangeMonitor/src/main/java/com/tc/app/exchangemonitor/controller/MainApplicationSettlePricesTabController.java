package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.cayenne.query.SQLSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Price;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.util.DatePickerConverter;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainApplicationSettlePricesTabController implements IMainApplicationMonitorTabController
{
	private static final Logger LOGGER = LogManager.getLogger();

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
	private DatePicker startDateDatePicker;

	@FXML
	private DatePicker endDateDatePicker;

	@FXML
	private TableView<DummySettlePrice> settlePricesTableView;

	@FXML
	private TextField settlePricesTableViewDataFilterTextField;

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

	private InvalidationListener settlePricesTableViewDataFilterTextFieldKeyListener = null;

	private final ObservableList<DummySettlePrice> settlePricesObservableList = FXCollections.observableArrayList();
	private final FilteredList<DummySettlePrice> settlePricesFilteredList = new FilteredList<>(this.settlePricesObservableList, null);
	private final SortedList<DummySettlePrice> settlePricesSortedList = new SortedList<>(this.settlePricesFilteredList);

	private final FetchSettlePricesScheduledService fetchSettlePricesScheduledService = new FetchSettlePricesScheduledService();

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
		ApplicationHelper.controllersMap.putInstance(MainApplicationSettlePricesTabController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.settlePricesTableViewDataFilterTextField != null : "fx:id=\"settlePricesTableViewDataFilterTextField\" was not injected. Check your FXML file MainWindowSettlePricesTabView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		/* Since startDate and endDate are set as NULL initially, "null" is appearing in the startDateFilterText and endDateFilterText and bcoz of that the Text control is appearing in the UI. To get rid
		 * of that we are hiding the Text control if it contains text equals to "null"
		 */
		this.startDateFilterValueText.visibleProperty().bind(this.startDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.endDateFilterValueText.visibleProperty().bind(this.endDateFilterValueText.textProperty().isNotEqualTo("null"));

		this.startDateFilterKeyText.visibleProperty().bind(this.startDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.startDateFilterKeyText.managedProperty().bind(this.startDateFilterKeyText.visibleProperty());
		this.startDateFilterValueText.managedProperty().bind(this.startDateFilterValueText.visibleProperty());

		this.endDateFilterKeyText.visibleProperty().bind(this.endDateFilterValueText.textProperty().isNotEqualTo("null"));
		this.endDateFilterKeyText.managedProperty().bind(this.endDateFilterKeyText.visibleProperty());
		this.endDateFilterValueText.managedProperty().bind(this.endDateFilterValueText.visibleProperty());

		this.settlePricesTableView.setItems(this.settlePricesSortedList);

		this.startDateFilterValueText.textProperty().bind(this.startDateDatePicker.valueProperty().asString());
		this.endDateFilterValueText.textProperty().bind(this.endDateDatePicker.valueProperty().asString());

		this.startMonitorButton.disableProperty().bind(this.fetchSettlePricesScheduledService.runningProperty());
		this.pauseMonitorButton.disableProperty().bind(this.fetchSettlePricesScheduledService.runningProperty().not());
		this.stopMonitorButton.disableProperty().bind(this.fetchSettlePricesScheduledService.runningProperty().not());

		//applicationMainWindowCurrentFilterToolBar.visibleProperty().bind(exchangesFilterText.textProperty().isNotEmpty().or(statesFilterText.textProperty().isNotEmpty()).or(typesFilterText.textProperty().isNotEmpty()).or(accountsFilterText.textProperty().isNotEmpty()).or(startDateFilterText.textProperty().isNotEqualTo("null")).or(endDateFilterText.textProperty().isNotEqualTo("null")));
		/* We are hiding the entire toolbar if no text in any of the Text control. */
		this.applicationMainWindowCurrentFilterToolBar.visibleProperty().bind((this.startDateFilterKeyText.visibleProperty()).or(this.endDateFilterKeyText.visibleProperty()));

		this.settlePricesSortedList.comparatorProperty().bind(this.settlePricesTableView.comparatorProperty());
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
	}

	@Override
	public void initializeGUI()
	{
		this.startDateDatePicker.setValue(null);
		this.startDateDatePicker.setConverter(new DatePickerConverter("dd-MMM-yyyy"));

		this.endDateDatePicker.setValue(null);
		this.endDateDatePicker.setConverter(new DatePickerConverter("dd-MMM-yyyy"));
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener creation starts here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void createListeners()
	{
		this.settlePricesTableViewDataFilterTextFieldKeyListener = (observable) -> {
			this.handleSettlePricesTableViewFilterByKey();
		};
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
		this.settlePricesTableViewDataFilterTextField.textProperty().addListener(this.settlePricesTableViewDataFilterTextFieldKeyListener);
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

	private void handleSettlePricesTableViewFilterByKey()
	{
		//settlePricesFilteredList.setPredicate(settlePricesTableViewFilterPredicate(settlePricesTableViewDataFilterTextField.getText().trim().toLowerCase()));

		Platform.runLater(() -> {
			// we don't want repeated selections
			MainApplicationSettlePricesTabController.this.settlePricesTableView.getSelectionModel().clearSelection();
			//get the focus
			MainApplicationSettlePricesTabController.this.settlePricesTableView.requestFocus();

			//select first item in TableView model
			MainApplicationSettlePricesTabController.this.settlePricesTableView.getSelectionModel().selectFirst();

			//set the focus on the first element
			MainApplicationSettlePricesTabController.this.settlePricesTableView.getFocusModel().focus(0);

			//render the selected item in the TableView
			//tableClickHandler(null);
		});

		Platform.runLater(() -> {
			MainApplicationSettlePricesTabController.this.settlePricesTableViewDataFilterTextField.requestFocus();
			MainApplicationSettlePricesTabController.this.settlePricesTableViewDataFilterTextField.end();
			//externalTradeTableViewDataFilterTextField.positionCaret(externalTradeTableViewDataFilterTextField.getLength()+1);
		});
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods ends here
	 * ============================================================================================================================================================================
	 */

	private void initializeTableViews()
	{
	}

	/**
	 * ============================================================================================================================================================================
	 * All Event Handling logic starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private void handleStartMonitorButtonClick()
	{
		this.startMonitoringSettlePrices();
	}

	@FXML
	private void handlePauseMonitorButtonClick()
	{
		this.pauseMonitoringSettlePrices();
	}

	@FXML
	private void handleStopMonitorButtonClick()
	{
		this.stopMonitoringSettlePrices();
	}

	private void startMonitoringSettlePrices()
	{
		this.fetchSettlePricesFromDBForTableView();
	}

	private void pauseMonitoringSettlePrices()
	{
		if(this.fetchSettlePricesScheduledService != null)
		{
			if(this.fetchSettlePricesScheduledService.isRunning())
			{
				this.fetchSettlePricesScheduledService.cancel();
			}
		}
	}

	private void stopMonitoringSettlePrices()
	{
		this.pauseMonitoringSettlePrices();
		this.settlePricesObservableList.clear();
	}

	private void fetchSettlePricesFromDBForTableView()
	{
		MappedSelect<DataRow> mappedSelectQueryToFetchSettlePrices = null;

		//@formatter:off
		final String selectedStartDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.startDateDatePicker.getValue() != null ? this.startDateDatePicker.getValue() : LocalDate.now());
		final String selectedEndDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.endDateDatePicker.getValue() != null ? this.endDateDatePicker.getValue() : LocalDate.now());
		//@formatter:on

		final Map<String, String> parametersMap = new HashMap<>();
		parametersMap.put("startDateParam", selectedStartDate);
		parametersMap.put("endDateParam", selectedEndDate);

		mappedSelectQueryToFetchSettlePrices = CayenneReferenceDataFetchUtil.getSelectQueryForName("FetchSettlePrices");
		mappedSelectQueryToFetchSettlePrices.params(parametersMap);

		/* This will fetch the data in a background thread, so UI will not be freezed and user can interact with the UI. Here we use a scheduled service which will invoke the task recurringly. */
		this.fetchSettlePricesScheduledService.setMappedSelect(mappedSelectQueryToFetchSettlePrices);
		this.fetchSettlePricesScheduledService.setDelay(Duration.seconds(1));
		this.fetchSettlePricesScheduledService.setPeriod(Duration.seconds(10));

		/*
		 *  modified the above 2 lines as below. previously statusMessagesProperty and progressStatusesProperty are available in the same class but now moved to a different controller.
		 *  Eventually the below code has to be modified to access those properties from the respective controller class.
		 *  Currently accessing the statusMessagesProperty and progressStatusesProperty through the controller whose reference is injected while loading. this may not be the perfect approach,
		 *  need to find out a better way.
		 */
		this.fetchSettlePricesScheduledService.messageProperty().addListener((final ObservableValue<? extends String> observableValue, final String oldValue, final String newValue) -> {
			ApplicationHelper.controllersMap.getInstance(MainWindowController.class).statusMessagesProperty().set(newValue);
		});
		this.fetchSettlePricesScheduledService.progressProperty().addListener((final ObservableValue<? extends Number> observableValue, final Number oldValue, final Number newValue) -> {
			ApplicationHelper.controllersMap.getInstance(MainWindowController.class).progressStatusesProperty().set(newValue.doubleValue());
		});

		this.fetchSettlePricesScheduledService.restart();

		this.fetchSettlePricesScheduledService.setOnSucceeded((final WorkerStateEvent workerStateEvent) -> {
			this.doThisIfFetchSucceeded();
		});
	}

	private void doThisIfFetchSucceeded()
	{
		final List<DummySettlePrice> allSettlePrices = this.createDummySettlePriceObjectsForSettlePriceDataRows(this.fetchSettlePricesScheduledService.getValue());
		this.settlePricesObservableList.clear();
		this.settlePricesObservableList.addAll(allSettlePrices);
	}

	private List<DummySettlePrice> createDummySettlePriceObjectsForSettlePriceDataRows(final ObservableList<DataRow> settlePriceDataRows)
	{
		if(settlePriceDataRows == null)
			return null;
		//@formatter:off
		return settlePriceDataRows.stream().map(DummySettlePrice::new).collect(Collectors.toList());
		//@formatter:on
	}

	@FXML
	private void handleUpdateSettlePriceButtonClick()
	{
		this.updateSettlePrice();
	}

	private void updateSettlePrice()
	{
		final boolean shouldConsiderFASDifferentialSet = true;
		//@formatter:off
		final ObservableList<DummySettlePrice> allRecords = this.settlePricesTableView.getSelectionModel().getSelectedItems();

		for(final DummySettlePrice aRecord : allRecords)
		{
			/* No need to update the settle price if it is already update. So check the comment, if it contains "Settlement Price Updated" then just continue. */


			/* Find the settlement price. */
			/* SELECT avg_closed_price FROM price WHERE commkt_key = 5 AND price_source_code = 'EXCHANGE' AND trading_prd = 201502 AND price_quote_date = '2015-01-01' */
			final String queryToFindSettlementPrice = "SELECT * FROM price WHERE commkt_key = #bind($commktParam) AND price_source_code = #bind($priceSourceCodeParam) AND trading_prd = #bind($tradingPrdParam) AND price_quote_date = #bind($priceQuoteDateParam)";
			final SQLSelect<Price> priceSQLSelect = SQLSelect.query(Price.class, queryToFindSettlementPrice);
			priceSQLSelect.params("commktParam", aRecord.getCommktKey());
			priceSQLSelect.params("priceSourceCodeParam", aRecord.getPriceSourceCode());
			priceSQLSelect.params("tradingPrdParam", aRecord.getTradingPrd());
			priceSQLSelect.params("priceQuoteDateParam", aRecord.getFillDate());
			final Price aPriceRecord = priceSQLSelect.selectFirst(CayenneHelper.getCayenneServerRuntime().newContext());

			if((aPriceRecord == null) || (aPriceRecord.getAvgClosedPrice() == null))
			{
				/* We cannot find a price. So just set the fail comment and continue with other records. */
				this.setFailComment();
				continue;
			}
			final Double rPrice = aPriceRecord.getAvgClosedPrice();
			final Double rOldPrice;
			final Double rNewPrice;
			if(shouldConsiderFASDifferentialSet)
			{
				rOldPrice = aRecord.getFillPrice();
				rNewPrice = aRecord.getFillPrice() + rPrice +  aRecord.getOrderPrice();
			}
			else
			{
				rOldPrice = aRecord.getFillPrice();
				rNewPrice = aRecord.getFillPrice() + rPrice;
			}
		}
		//@formatter:on
	}

	private void setFailComment()
	{
		final String commentString = "Settlement Price Not Found!";
	}
}

/*
 * ============================================================================================================================================================================
 *  All Event Handling logic ends here
 * ============================================================================================================================================================================
 */