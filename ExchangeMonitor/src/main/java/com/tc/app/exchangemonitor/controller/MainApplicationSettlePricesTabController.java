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
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.MappedSelect;
import org.apache.cayenne.query.SQLExec;
import org.apache.cayenne.query.SQLSelect;
import org.apache.cayenne.query.SelectById;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Comment;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Constants;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Price;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemFill;
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

		final String selectedStartDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.startDateDatePicker.getValue() != null ? this.startDateDatePicker.getValue() : LocalDate.now());
		final String selectedEndDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.endDateDatePicker.getValue() != null ? this.endDateDatePicker.getValue() : LocalDate.now());

		final Map<String, String> parametersMap = new HashMap<>();
		parametersMap.put("startDateParam", selectedStartDate);
		parametersMap.put("endDateParam", selectedEndDate);

		mappedSelectQueryToFetchSettlePrices = CayenneReferenceDataFetchUtil.getSelectQueryForName("FetchTradeItemFills");
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
		return settlePriceDataRows.stream().map(DummySettlePrice::new).collect(Collectors.toList());
	}

	@FXML
	private void handleUpdateSettlePriceButtonClick()
	{
		this.updateSettlePrice();
	}

	private void updateSettlePrice()
	{
		final ObservableList<DummySettlePrice> tradeItemFills = this.settlePricesTableView.getSelectionModel().getSelectedItems();

		tradeItemFills.forEach((aTradeItemFill) -> this.update(aTradeItemFill));
	}

	private SQLExec updateTradeItemFillSQLExec = null;
	private SQLExec updateTradeItemFutSQLExec = null;
	private SQLExec updateTradeItemSQLExec = null;
	private SQLExec updateCommentSQLExec = null;
	private SQLExec updateCommentSQLExec2 = null;
	private SQLExec updateExchToolsTradeSQLExec = null;
	private SQLExec insertTradeCommentSQLExec = null;
	private SQLExec insertCommentSQLExec = null;
	private static boolean commentAlreadyExists = false;
	private void update(final DummySettlePrice theTradeItemFill)
	{
		final boolean shouldConsiderFASDifferentialSet = shouldConsiderFASDifferentialSet();
		String theFinalCommentToSet = "";

		// Find Settlement Price by looking into the price table
		final Map<String, Object> parametersMap = new HashMap<>();
		parametersMap.put(Price.COMMKT_KEY_PK_COLUMN, theTradeItemFill.getCommktKey());
		parametersMap.put(Price.PRICE_SOURCE_CODE_PK_COLUMN, theTradeItemFill.getPriceSourceCode());
		parametersMap.put(Price.TRADING_PRD_PK_COLUMN, theTradeItemFill.getTradingPrd());
		parametersMap.put(Price.PRICE_QUOTE_DATE_PK_COLUMN, theTradeItemFill.getFillDate());
		final SelectById<Price> settlementPrice = SelectById.query(Price.class, parametersMap);
		final Price thePrice = settlementPrice.selectOne(CayenneHelper.getCayenneServerRuntime().newContext());

		LOGGER.info("Price found. Average Closed Price : {}", thePrice.getAvgClosedPrice());

		if((thePrice == null) || (thePrice.getAvgClosedPrice() == null))
		{
			/* We cannot find a price. So just set the fail comment and continue with other records. */
			this.setFailComment(theTradeItemFill);
			return;
		}
		// Keep the old fill price, we need to update it in the comment text
		final Double theOldFillPrice = theTradeItemFill.getFillPrice();

		final Double avgClosedPrice = thePrice.getAvgClosedPrice();
		final Double theNewFillPrice = shouldConsiderFASDifferentialSet ? theTradeItemFill.getOrderPrice() + theOldFillPrice + avgClosedPrice : theOldFillPrice + avgClosedPrice;

		// Find the average fill price
		final SQLSelect<TradeItemFill> fillSQLSelect = SQLSelect.query(TradeItemFill.class, "SELECT * FROM trade_item_fill WHERE trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam)");
		fillSQLSelect.params("tradeNumParam", theTradeItemFill.getTradeNum());
		fillSQLSelect.params("orderNumParam", theTradeItemFill.getOrderNum());
		fillSQLSelect.params("itemNumParam", theTradeItemFill.getItemNum());
		final List<TradeItemFill> tradeItemFills = fillSQLSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());

		if((tradeItemFills == null) || (tradeItemFills.size() == 0))
		{
			this.setFailComment(theTradeItemFill);
			return;
		}

		/* We got some fills, let's calculate the average of them. */
		double avgFillPrice = 0.0;
		double fillPriceSum = 0.0;
		double fillQtySum = 0.0;
		for(final TradeItemFill aTradeItemFill : tradeItemFills)
		{
			final double fillPriceToUse = aTradeItemFill.getFillNum() == theTradeItemFill.getItemFillNum() ? theNewFillPrice : aTradeItemFill.getFillPrice();
			fillPriceSum = fillPriceSum + (aTradeItemFill.getFillQty() * fillPriceToUse);
			fillQtySum = fillQtySum + aTradeItemFill.getFillQty();
		}
		avgFillPrice = fillQtySum != 0.0 ? fillPriceSum / fillQtySum : 0.0;

		final Integer transId = CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
		Integer cmntNum = CayenneReferenceDataFetchUtil.generateNewNum("cmnt_num", 0);

		// We got avg closed price, avg of fill prices. So go ahead and update fill price, avg price, avg fill price, tiny cmnt
		//final SQLExec updateTradeItemFillSQLExec = new SQLExec("UPDATE trade_item_fill set fill_price = #bind($newFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam) and item_fill_num = #bind($itemFillNumParam)");
		this.updateTradeItemFillSQLExec = new SQLExec("UPDATE trade_item_fill set fill_price = #bind($newFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam) and item_fill_num = #bind($itemFillNumParam)");
		this.updateTradeItemFillSQLExec.params("newFillPriceParam", theNewFillPrice);
		this.updateTradeItemFillSQLExec.params("transIdParam", transId);
		this.updateTradeItemFillSQLExec.params("tradeNumParam", theTradeItemFill.getTradeNum());
		this.updateTradeItemFillSQLExec.params("orderNumParam", theTradeItemFill.getOrderNum());
		this.updateTradeItemFillSQLExec.params("itemNumParam", theTradeItemFill.getItemNum());
		this.updateTradeItemFillSQLExec.params("itemFillNumParam", theTradeItemFill.getItemFillNum());

		//final SQLExec updateTradeItemFutSQLExec = new SQLExec("UPDATE trade_item_fut set avg_fill_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num =  #bind($tradeNumParam) and order_num = o#bind($orderNumParam) and item_num = #bind($itemNumParam)");
		this.updateTradeItemFutSQLExec = new SQLExec("UPDATE trade_item_fut set avg_fill_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num =  #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam)");
		this.updateTradeItemFutSQLExec.params("avgFillPriceParam", avgFillPrice);
		this.updateTradeItemFutSQLExec.params("transIdParam", transId);
		this.updateTradeItemFutSQLExec.params("tradeNumParam", theTradeItemFill.getTradeNum());
		this.updateTradeItemFutSQLExec.params("orderNumParam", theTradeItemFill.getOrderNum());
		this.updateTradeItemFutSQLExec.params("itemNumParam", theTradeItemFill.getItemNum());

		//final SQLExec updateTradeItemSQLExec = new SQLExec("UPDATE trade_item set avg_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num = #bind($tradeNumParam) and order_num = o#bind($orderNumParam) and item_num = #bind($itemNumParam)");
		this.updateTradeItemSQLExec = new SQLExec("UPDATE trade_item set avg_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) WHERE trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam)");
		this.updateTradeItemSQLExec.params("avgFillPriceParam", avgFillPrice);
		this.updateTradeItemSQLExec.params("transIdParam", transId);
		this.updateTradeItemSQLExec.params("tradeNumParam", theTradeItemFill.getTradeNum());
		this.updateTradeItemSQLExec.params("orderNumParam", theTradeItemFill.getOrderNum());
		this.updateTradeItemSQLExec.params("itemNumParam", theTradeItemFill.getItemNum());

		//final SQLExec updateCommentSQLExec = new SQLExec("UPDATE comment set tiny_cmnt = 'Priced', trans_id = #bind($transIdParam) WHERE cmnt_num = #bind($cmntNumParam)");
		this.updateCommentSQLExec = new SQLExec("UPDATE comment set tiny_cmnt = 'Priced', trans_id = #bind($transIdParam) WHERE cmnt_num = #bind($cmntNumParam)");
		this.updateCommentSQLExec.params("transIdParam", transId);
		this.updateCommentSQLExec.params("cmntNumParam", theTradeItemFill.getCmntNum());

		//final SQLExec updateExchToolsTradeSQLExec = new SQLExec("UPDATE exch_tools_trade set price = #bind($priceParam), trans_id = #bind($transIdParam) WHERE exch_tools_trade_num = #bind($exchToolsTradeNumParam) and external_trade_oid in (select oid from external_trade where trade_num = #bind($tradeNumParam)");
		this.updateExchToolsTradeSQLExec = new SQLExec("UPDATE exch_tools_trade set price = #bind($priceParam), trans_id = #bind($transIdParam) WHERE exch_tools_trade_num = #bind($exchToolsTradeNumParam) and external_trade_oid in (select oid from external_trade where trade_num = #bind($tradeNumParam))");
		this.updateExchToolsTradeSQLExec.params("priceParam", theNewFillPrice);
		this.updateExchToolsTradeSQLExec.params("transIdParam", transId);
		this.updateExchToolsTradeSQLExec.params("exchToolsTradeNumParam", theTradeItemFill.getExternalTradeNum());
		this.updateExchToolsTradeSQLExec.params("tradeNumParam", theTradeItemFill.getTradeNum());

		String tinyCmnt = "";
		String shortCmnt = "";
		String cmntText = "";

		/* if comment exists update with old price else create a new comment and update */
		final String selectComment = "SELECT tradecommentalias.cmnt_num, commentalias.tiny_cmnt, commentalias.short_cmnt, SUBSTRING(CONVERT(varchar, commentalias.cmnt_text), 1, 4000) as cmntText FROM trade_comment AS tradecommentalias RIGHT OUTER JOIN comment AS commentalias ON tradecommentalias.cmnt_num = commentalias.cmnt_num WHERE tradecommentalias.trade_num = #bind($tradeNumParam) AND tradecommentalias.trade_cmnt_type = 'T'";
		final Comment theComment = SQLSelect.query(Comment.class, selectComment).params("tradeNumParam", theTradeItemFill.getTradeNum()).selectOne(CayenneHelper.getCayenneServerRuntime().newContext());
		if(theComment != null)
		{
			commentAlreadyExists = true;
			cmntNum = theComment.getCommentNum();
			// a trade comment is available so go ahead and update the necessary columns
			if((theComment.getTinyCmnt() != null) && !theComment.getTinyCmnt().isEmpty())
			{
				theFinalCommentToSet = theComment.getTinyCmnt();
			}
			else if((theComment.getShortCmnt() != null) && !theComment.getShortCmnt().isEmpty())
			{
				theFinalCommentToSet = theComment.getShortCmnt();
			}
			else if((theComment.getCmntText() != null) && !theComment.getCmntText().isEmpty())
			{
				theFinalCommentToSet = theComment.getCmntText();
			}
			//theFinalCommentToSet = theFinalCommentToSet + "\r\n****\r\n" + "Price Differential For Item Fill Number " + theTradeItemFill.getItemFillNum() + " was " + theOldFillPrice + "\r\n****\r\n";
			theFinalCommentToSet = theFinalCommentToSet + "***** " + "Price Differential For Item Fill Number " + theTradeItemFill.getItemFillNum() + " was " + theOldFillPrice + " *****";
			if(theFinalCommentToSet.length() <= 16)
			{
				tinyCmnt = theFinalCommentToSet;
				shortCmnt = null;
				cmntText = null;
			}
			else if(theFinalCommentToSet.length() <= 255)
			{
				tinyCmnt = null;
				shortCmnt = theFinalCommentToSet;
				cmntText = null;
			}
			else
			{
				tinyCmnt = null;
				shortCmnt = null;
				cmntText = theFinalCommentToSet;
			}
			this.updateCommentSQLExec2 = new SQLExec("UPDATE comment SET tiny_cmnt = #bind($tinyCmntParam), short_cmnt = #bind($shortCmntParam), cmnt_path = #bind($cmntPathParam), cmnt_text = #bind($cmntTextParam), trans_id = #bind($transIdParam) WHERE cmnt_num = #bind($cmntNumParam)");
			this.updateCommentSQLExec2.params("tinyCmntParam", tinyCmnt);
			this.updateCommentSQLExec2.params("shortCmntParam", shortCmnt);
			this.updateCommentSQLExec2.params("cmntPathParam", null);
			this.updateCommentSQLExec2.params("cmntTextParam", cmntText);
			this.updateCommentSQLExec2.params("transIdParam", transId);
			this.updateCommentSQLExec2.params("cmntNumParam", cmntNum);
		}
		else
		{
			//create a new trade comment and update the necessary columns
			this.insertTradeCommentSQLExec = new SQLExec("INSERT INTO trade_comment values(#bind($tradeNumParam), #bind($cmntNumParam), #bind($tradeCmntTypeParam), #bind($transIdParam))");
			this.insertTradeCommentSQLExec.params("tradeNumParam", theTradeItemFill.getTradeNum());
			this.insertTradeCommentSQLExec.params("cmntNumParam", cmntNum);
			this.insertTradeCommentSQLExec.params("tradeCmntTypeParam", "T");
			this.insertTradeCommentSQLExec.params("transIdParam", transId);

			theFinalCommentToSet = "";
			//theFinalCommentToSet = theFinalCommentToSet + "\r\n****\r\n" + "Price Differential For Item Fill Number " + theTradeItemFill.getItemFillNum() + " was " + theOldFillPrice + "\r\n****\r\n";
			theFinalCommentToSet = theFinalCommentToSet + "***** " + "Price Differential For Item Fill Number " + theTradeItemFill.getItemFillNum() + " was " + theOldFillPrice + " *****";
			if(theFinalCommentToSet.length() <= 16)
			{
				tinyCmnt = theFinalCommentToSet;
				shortCmnt = null;
				cmntText = null;
			}
			else if(theFinalCommentToSet.length() <= 255)
			{
				tinyCmnt = null;
				shortCmnt = theFinalCommentToSet;
				cmntText = null;
			}
			else
			{
				tinyCmnt = null;
				shortCmnt = null;
				cmntText = theFinalCommentToSet;
			}

			this.insertCommentSQLExec = new SQLExec("INSERT INTO comment values(#bind($cmntNumParam), #bind($tinyCmntParam), #bind($shortCmntParam), #bind($cmntPathParam), #bind($cmntTextParam), #bind($transIdParam))");
			this.insertCommentSQLExec.params("cmntNumParam", cmntNum);
			this.insertCommentSQLExec.params("tinyCmntParam", tinyCmnt);
			this.insertCommentSQLExec.params("shortCmntParam", shortCmnt);
			this.insertCommentSQLExec.params("cmntPathParam", null);
			this.insertCommentSQLExec.params("cmntTextParam", cmntText);
			this.insertCommentSQLExec.params("transIdParam", transId);
		}

		try
		{
			CayenneHelper.getCayenneServerRuntime().performInTransaction(() -> this.saveAll());
			this.setSuccessComment(theTradeItemFill);
		}
		catch(final Exception exception)
		{
			this.setFailComment(theTradeItemFill);
		}
	}

	private Integer saveAll()
	{
		final ObjectContext objectContext = CayenneHelper.getCayenneServerRuntime().newContext();
		this.updateTradeItemFillSQLExec.execute(objectContext);
		this.updateTradeItemFutSQLExec.execute(objectContext);
		this.updateTradeItemSQLExec.execute(objectContext);
		this.updateCommentSQLExec.execute(objectContext);
		this.updateExchToolsTradeSQLExec.execute(objectContext);

		if(commentAlreadyExists)
		{
			this.updateCommentSQLExec2.execute(objectContext);
		}
		else
		{
			this.insertTradeCommentSQLExec.execute(objectContext);
			this.insertCommentSQLExec.execute(objectContext);
		}
		return null;
	}

	private void setFailComment(final DummySettlePrice theTradeItemFill)
	{
		theTradeItemFill.setPriceUpdateStatus("Settlement Price Not Found");
	}

	private void setSuccessComment(final DummySettlePrice theTradeItemFill)
	{
		theTradeItemFill.setPriceUpdateStatus("Settlement Price Updated");
	}

	private static boolean firstTime = true;
	static boolean shouldConsiderFASDifferentialSet = false;
	private static boolean shouldConsiderFASDifferentialSet()
	{
		if(firstTime)
		{
			firstTime = false;
			final Constants theConstant = SelectById.query(Constants.class, "ConsiderFASDifferential").selectOne(CayenneHelper.getCayenneServerRuntime().newContext());
			if((theConstant == null) || theConstant.getAttributeValue().equals("N"))
			{
				shouldConsiderFASDifferentialSet = false;
			}
			else
			{
				shouldConsiderFASDifferentialSet = true;
			}
		}
		return shouldConsiderFASDifferentialSet;
	}
}

/*
 * ============================================================================================================================================================================
 *  All Event Handling logic ends here
 * ============================================================================================================================================================================
 */