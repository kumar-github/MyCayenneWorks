package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.controlsfx.control.CheckListView;
import org.controlsfx.control.StatusBar;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;

import com.tc.app.exchangemonitor.util.DatePickerConverter;
import com.tc.app.exchangemonitor.util.HibernateUtil;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class MainWindowControllerNew_BACKUP_ON_30_05_2016 implements Initializable
{

	/**
	 * ============================================================================================================================================================================
	 * Currently Unused Variables. Starts Here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private StatusBar statusBar;

	@FXML
	private BorderPane mainWindowBorderPane;

	@Inject
	private String prefix;

	@FXML
	private TabPane mainWindowTabPane;

	/**
	 * ============================================================================================================================================================================
	 * Currently Unused Variables. Ends Here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through FXML starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private CheckListView<String> externalTradeSourcesListView;

	@FXML
	private CheckListView<String> externalTradeStatesListView;

	@FXML
	private CheckListView<String> externalTradeStatusesListView;

	@FXML
	private TitledPane externalTradeSourcesTitledPane;

	@FXML
	private TitledPane externalTradeStatesTitledPane;

	@FXML
	private TitledPane externalTradeStatusesTitledPane;

	@FXML
	private TitledPane externalTradeAccountsTitledPane;

	@FXML
	private CheckListView<String> externalTradeAccountsListView;

	@FXML
	private DatePicker startDateDatePicker;

	@FXML
	private DatePicker endDateDatePicker;

	@FXML
	private TextField externalTradeAccountsSearchTextField;

	@FXML
	private Button startMonitorButton;

	@FXML
	private ImageView startMonitorButtonImageView;

	@FXML
	private TableView<DummyExternalTrade> exchangeTradesTableView;

	@FXML
	private TableColumn<DummyExternalTrade, Number> tradeOidTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, LocalDate> tradeCreationDateTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Date> tradeEntryDateTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> tradeStateTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> tradeStatusTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> exchangeTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> commodityTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> tradingPeriodTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> callPutTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Number> strikePriceTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Number> quantityTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Number> priceTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> buyingCompanyTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> buyingTraderTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> sellingCompanyTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> sellingTraderTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> exchangeTradeNumTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> accountTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Number> ictsTradeNumTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, Number> ictsPortNumTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> tradeTypeTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> inputBrokerTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> buyerClearingBrokerTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> sellerClearingBrokerTableColumn;

	@FXML
	private TableColumn<DummyExternalTrade, String> commentTableColumn;

	@FXML
	private TextField filterDummyExternalTradeTableViewDataTextField;

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

	@Inject
	private String sqlQueryToFetchExternalTradeSources;

	@Inject
	private String sqlQueryStringToFetchExternalTradeStates;

	@Inject
	private String sqlQueryStringToFetchExternalTradeStatuses;

	@Inject
	private String sqlQueryStringToFetchExternalTradeAccounts;

	@Inject
	private String sqlQueryStringToFetchExternalTradesWithBuyerAccountQualifier;

	@Inject
	private String sqlQueryStringToFetchExternalTradesWithoutBuyerAccountQualifier;

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

	private List<String> externalTradeAccounts;
	private final List<String> checkedExternalTradeAccounts = new ArrayList<>();
	private final ObservableList<DummyExternalTrade> dummyExternalTrades = FXCollections.observableArrayList();
	private final Map<String, String> externalTradeSourceTableMap = new HashMap<>();
	private final Map<String, String> externalTradeStateTableMap = new HashMap<>();
	private final Map<String, String> externalTradeStatusTableMap = new HashMap<>();

	/**
	 * ============================================================================================================================================================================
	 * All other variable declaration ends here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private void initialize()
	{
		System.out.println("...........");
	}

	public MainWindowControllerNew_BACKUP_ON_30_05_2016()
	{
		System.out.println("constructor");
	}

	/*
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		MainWindowMenuBarView mainWindowMenuBarView = new MainWindowMenuBarView();
		mainWindowBorderPane.setTop(mainWindowMenuBarView.getView());

		MainWindowStatusBarView mainWindowStatusBarView = new MainWindowStatusBarView();
		mainWindowBorderPane.setBottom(mainWindowStatusBarView.getView());

		MainWindowTabPaneView mainWindowTabPaneView = new MainWindowTabPaneView();
		mainWindowBorderPane.setCenter(mainWindowTabPaneView.getView());

		//fetched from dashboard.properties
	    if(rb != null)
	    {
	    	System.out.println("theEnd : " + rb.getString("theEnd") + "prefix :" + prefix);
	    	listView.setItems(data);

	        listView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(String item) {
	                BooleanProperty observable = new SimpleBooleanProperty();
	                observable.addListener((obs, wasSelected, isNowSelected) ->
	                    System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected)
	                );
	                return observable ;
	            }
	        }));
	    }
	}
	 */

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{

		//added temporarily. Need to think of a better place to do this.
		this.exchangeTradesTableView.setItems(this.dummyExternalTrades);

		//filterDummyExternalTradeTableViewDataTextField.setAccelerator(new KeyCodeCombination(KeyCode.X,KeyCombination.CONTROL_DOWN));
		//tradeAccountListView.getCheckModel().getCheckedItems().addListener(checkedItemListener);

		this.initializeGUIAndConfigureListenersAndInitializeAnimation();

		/*tradeOidTableColumn.setCellValueFactory(new PropertyValueFactory<>("oid"));*/
		/*tradeOidTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DummyExternalTrade, Number>, ObservableValue<Number>>()
		{
			@Override
			public ObservableValue<Number> call(CellDataFeatures<DummyExternalTrade, Number> param)
			{
				return new SimpleIntegerProperty(param.getValue().getOid().intValue());
			}});/*

		/* commenting the above code, bcoz the same can be implemented as below using java 8 Lambda*/
		this.tradeOidTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getExternalTradeOid().intValue()));
		//tradeCreationDateTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getCreationDate()));
		this.tradeCreationDateTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
		this.tradeEntryDateTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEntryDate()));
		this.tradeStateTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalTradeStateOid().toString()));
		this.tradeStatusTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalTradeStatusOid().toString()));
		this.exchangeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExternalTradeSourceOid().toString()));
		this.commodityTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCommodity()));
		this.tradingPeriodTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTradingPeriod()));
		//callPutTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCallPut()));
		this.strikePriceTableColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getStrikePrice() != null ? cellData.getValue().getStrikePrice().doubleValue() : 0.0));
		this.quantityTableColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getQuantity().doubleValue()));
		this.priceTableColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice().doubleValue()));
		this.buyingCompanyTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInputCompany()));
		this.buyingTraderTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInputTrader()));
		this.sellingCompanyTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAcceptedCompany()));
		this.sellingTraderTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAcceptedTrader()));
		this.exchangeTradeNumTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExchToolsTradeNum()));
		this.accountTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBuyerAccount()));
		this.ictsTradeNumTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getTradeNum() != null ? cellData.getValue().getTradeNum().intValue() : 0));
		this.ictsPortNumTableColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPortNum() != null ? cellData.getValue().getPortNum().intValue() : 0));
		this.tradeTypeTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTradeType()));
		this.inputBrokerTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInputBroker()));
		this.buyerClearingBrokerTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBuyerClearingBroker()));
		this.sellerClearingBrokerTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSellerClearingBroker()));
		//commentTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCommentText()));

		//List<DummyExternalTrade> dummyExternalTradesList = fetchExternalTradesForTableViewFromDB();
		//exchangeTradesTableView.setItems(FXCollections.observableArrayList(dummyExternalTradesList));
		//exchangeTradesTableView.setItems(FXCollections.observableArrayList(dummyExternalTrades));

		/**
		 * Here logic goes for filtering the table data
		 */
		/*filterTableDataTextField.textProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable o) {
				if(filterTableDataTextField.textProperty().get().isEmpty()) {
					exchangeTradesTableView.setItems(getDummyTableData());
					return;
				}
				ObservableList<DummyExternalTrade> tableItems = FXCollections.observableArrayList();
				ObservableList<TableColumn<DummyExternalTrade, ?>> cols = exchangeTradesTableView.getColumns();
				for(int i=0; i<getDummyTableData().size(); i++) {

					for(int j=0; j<cols.size(); j++) {
						TableColumn col = cols.get(j);
						String cellValue = col.getCellData(getDummyTableData().get(i)).toString();
						cellValue = cellValue.toLowerCase();
						if(cellValue.contains(filterTableDataTextField.textProperty().get().toLowerCase())) {
							tableItems.add(getDummyTableData().get(i));
							break;
						}
					}

				}
				exchangeTradesTableView.setItems(tableItems);
			}
		});*/
	}

	public List<String> fetchAllExternalTradeSourcesFromDB()
	{
		List<Object> aTable = Collections.emptyList();
		final List<String> externalTradeSourcesList = new ArrayList<>();

		/**
		 * Variables injected through properties files takes priority over the code. so if we found a variable in the properties file
		 * with value then use that value if not then proceed with the value in the code.
		 */
		if((this.sqlQueryToFetchExternalTradeSources == null) || this.sqlQueryToFetchExternalTradeSources.isEmpty())
		{
			this.sqlQueryToFetchExternalTradeSources = "select etsource.external_trade_src_name as externalTradeSrcName, etsource.oid as externalTradeSrcOid from external_trade_system etsystem join external_trade_source etsource on etsystem.oid = etsource.external_trade_system_oid and etsource.external_trade_src_name <> 'NonDefined' order by etsource.external_trade_src_name";
		}
		aTable = this.fetchDataFromDB(this.sqlQueryToFetchExternalTradeSources, "externalTradeSrcName", "externalTradeSrcOid");
		for(final Object aRecord : aTable)
		{
			final String externalTradeSrcName = ((Map) aRecord).get("externalTradeSrcName").toString();
			final String externalTradeSrcOid = ((Map) aRecord).get("externalTradeSrcOid").toString();
			this.externalTradeSourceTableMap.put(externalTradeSrcName, externalTradeSrcOid);
			externalTradeSourcesList.add(externalTradeSrcName);
		}
		return externalTradeSourcesList;
	}

	public List<String> fetchAllExternalTradeStatesFromDB()
	{
		List<Object> aTable = Collections.emptyList();
		final List<String> externalTradeStatesList = new ArrayList<>();
		/**
		 * Variables injected through properties files takes priority over the code. so if we found a variable in the properties file
		 * with value then use that value if not then proceed with the value in the code.
		 */

		if((this.sqlQueryStringToFetchExternalTradeStates == null) || this.sqlQueryStringToFetchExternalTradeStates.isEmpty())
		{
			this.sqlQueryStringToFetchExternalTradeStates = "select etstate.external_trade_state_name as externalTradeStateName, etstate.oid as externalTradeStateOid from external_trade_state etstate order by etstate.external_trade_state_name";
		}
		aTable = this.fetchDataFromDB(this.sqlQueryStringToFetchExternalTradeStates, "externalTradeStateName", "externalTradeStateOid");
		for(final Object aRecord : aTable)
		{
			final String externalTradeStateName = ((Map) aRecord).get("externalTradeStateName").toString();
			final String externalTradeStatecOid = ((Map) aRecord).get("externalTradeStateOid").toString();
			this.externalTradeStateTableMap.put(externalTradeStateName, externalTradeStatecOid);
			externalTradeStatesList.add(externalTradeStateName);
		}
		return externalTradeStatesList;
	}

	public List<String> fetchAllExternalTradeStatusesFromDB()
	{
		List<Object> aTable = Collections.emptyList();
		final List<String> externalTradeStatusesList = new ArrayList<>();

		/**
		 * Variables injected through properties files takes priority over the code. so if we found a variable in the properties file
		 * with value then use that value if not then proceed with the value in the code.
		 */
		if((this.sqlQueryStringToFetchExternalTradeStatuses == null) || this.sqlQueryStringToFetchExternalTradeStatuses.isEmpty())
		{
			this.sqlQueryStringToFetchExternalTradeStatuses = "select etstatus.external_trade_status_name as externalTradeStatusName, etstatus.oid as externalTradeStatusOid from external_trade_status etstatus order by etstatus.external_trade_status_name";
		}
		aTable = this.fetchDataFromDB(this.sqlQueryStringToFetchExternalTradeStatuses, "externalTradeStatusName", "externalTradeStatusOid");
		for(final Object aRecord : aTable)
		{
			final String externalTradeStatusName = ((Map) aRecord).get("externalTradeStatusName").toString();
			final String externalTradeStatusOid = ((Map) aRecord).get("externalTradeStatusOid").toString();
			this.externalTradeStatusTableMap.put(externalTradeStatusName, externalTradeStatusOid);
			externalTradeStatusesList.add(externalTradeStatusName);
		}
		return externalTradeStatusesList;
	}

	public List<String> fetchAllExternalTradeAccountsFromDB()
	{
		/**
		 * Variables injected through properties files takes priority over the code. so if we found a variable in the properties file
		 * with value then use that value if not then proceed with the value in the code.
		 */
		if((this.sqlQueryStringToFetchExternalTradeAccounts == null) || this.sqlQueryStringToFetchExternalTradeAccounts.isEmpty())
		{
			this.sqlQueryStringToFetchExternalTradeAccounts = "select distinct em.external_value1 as externalValue1 from external_mapping em where em.mapping_type = 'K' order by em.external_value1";
		}
		return this.fetchDataFromDB(this.sqlQueryStringToFetchExternalTradeAccounts, "externalValue1");
	}

	public List<DummyExternalTrade> fetchExternalTradesFromDBForTableView()
	{
		SQLQuery sqlQueryToFetchData = null;
		//dummyExternalTrades = new ArrayList<DummyExternalTrade>();

		final List<String> selectedExternalTradeSources = this.getExternalTradeSourcesSelectedByUserFromUI();
		final List<String> selectedExternalTradeStatuses = this.getExternalTradeStatusesSelectedByUserFromUI();
		final List<String> selectedExternalTradeStates = this.getExternalTradeStatesSelectedByUserFromUI();
		final List<String> selectedExternalTradeAccounts = this.getExternalTradeAccountsSelectedByUserFromUI();

		final String startDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.startDateDatePicker.getValue());
		final String endDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(this.endDateDatePicker.getValue());

		//SQLQuery sqlQueryStringToFetchExternalTrade = session.createSQLQuery("SELECT et.oid as oid, ett.creation_date as creationDate, et.entry_date as entryDate, et.external_trade_system_oid as externalTradeSystemOid, et.external_trade_status_oid as externalTradeStatusOid, et.external_trade_source_oid as externalTradeSourceOid, et.external_trade_state_oid as externalTradeStateOid, et.trade_num as tradeNum, et.port_num as portNum, ec.comment_text as commentText, ett.exch_tools_trade_num as exchToolsTradeNum, ett.commodity as commodity, ett.trading_period as tradingPeriod, ett.call_put as callPut, ett.strike_price as strikePrice, ett.quantity as quantity, ett.price as price, ett.input_action as inputAction, ett.input_company as inputCompany, ett.input_trader as inputTrader, ett.accepted_action as acceptedAction, ett.accepted_company as acceptedCompany, ett.accepted_trader as acceptedTrader, ett.buyer_account as buyerAccount, ett.trade_type as tradeType ,ett.input_broker as inputBroker, ett.seller_clrng_broker as sellerClearingBroker, ett.buyer_clrng_broker as buyerClearingBroker, ett.accepted_broker as acceptedBroker FROM  dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_system_oid IN(1,1)) AND (et.external_trade_source_oid IN (3,1,12)) AND (et.external_trade_status_oid IN (2,3,1,4)) AND(et.external_trade_state_oid IN (1,3,4,2) ) AND (ett.creation_date >= CONVERT(datetime, CONVERT(varchar, '01-Dec-2015 12:00 AM', 109))) AND (ett.creation_date <= CONVERT(datetime,convert(varchar,'06-Mar-2016 11:59 PM',109))) ORDER BY ett.creation_date DESC");

		/**
		 * Variables injected through properties files takes priority over the code. so if we found a variable in the properties file
		 * with value then use that value if not then proceed with the value in the code.
		 */
		if((this.sqlQueryStringToFetchExternalTradesWithBuyerAccountQualifier == null) || this.sqlQueryStringToFetchExternalTradesWithBuyerAccountQualifier.isEmpty())
		{
			this.sqlQueryStringToFetchExternalTradesWithBuyerAccountQualifier = "SELECT et.oid as oid, ett.creation_date as creationDate, et.entry_date as entryDate, et.external_trade_system_oid as externalTradeSystemOid, et.external_trade_status_oid as externalTradeStatusOid, et.external_trade_source_oid as externalTradeSourceOid, et.external_trade_state_oid as externalTradeStateOid, et.trade_num as tradeNum, et.port_num as portNum, ec.comment_text as commentText, ett.exch_tools_trade_num as exchToolsTradeNum, ett.commodity as commodity, ett.trading_period as tradingPeriod, ett.call_put as callPut, ett.strike_price as strikePrice, ett.quantity as quantity, ett.price as price, ett.input_action as inputAction, ett.input_company as inputCompany, ett.input_trader as inputTrader, ett.accepted_action as acceptedAction, ett.accepted_company as acceptedCompany, ett.accepted_trader as acceptedTrader, ett.buyer_account as buyerAccount, ett.trade_type as tradeType ,ett.input_broker as inputBroker, ett.seller_clrng_broker as sellerClearingBroker, ett.buyer_clrng_broker as buyerClearingBroker, ett.accepted_broker as acceptedBroker FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_source_oid IN (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND (et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND (ett.creation_date <= (:endDate)) ORDER BY ett.creation_date DESC";
		}
		if((this.sqlQueryStringToFetchExternalTradesWithoutBuyerAccountQualifier == null) || this.sqlQueryStringToFetchExternalTradesWithoutBuyerAccountQualifier.isEmpty())
		{
			this.sqlQueryStringToFetchExternalTradesWithoutBuyerAccountQualifier = "SELECT et.oid as oid, ett.creation_date as creationDate, et.entry_date as entryDate, et.external_trade_system_oid as externalTradeSystemOid, et.external_trade_status_oid as externalTradeStatusOid, et.external_trade_source_oid as externalTradeSourceOid, et.external_trade_state_oid as externalTradeStateOid, et.trade_num as tradeNum, et.port_num as portNum, ec.comment_text as commentText, ett.exch_tools_trade_num as exchToolsTradeNum, ett.commodity as commodity, ett.trading_period as tradingPeriod, ett.call_put as callPut, ett.strike_price as strikePrice, ett.quantity as quantity, ett.price as price, ett.input_action as inputAction, ett.input_company as inputCompany, ett.input_trader as inputTrader, ett.accepted_action as acceptedAction, ett.accepted_company as acceptedCompany, ett.accepted_trader as acceptedTrader, ett.buyer_account as buyerAccount, ett.trade_type as tradeType ,ett.input_broker as inputBroker, ett.seller_clrng_broker as sellerClearingBroker, ett.buyer_clrng_broker as buyerClearingBroker, ett.accepted_broker as acceptedBroker FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_source_oid IN (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND(et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account NOT IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND (ett.creation_date <= (:endDate)) ORDER BY ett.creation_date DESC";
		}

		//selectedExternalTradeSources.forEach(anExternalTradeSourceName -> externalTradeSources.add(externalTradeSourceTableMap.get(a)));
		final List<String> externalTradeSources = new ArrayList<>();
		for(final String anExternalTradeSourceName : selectedExternalTradeSources)
		{
			externalTradeSources.add(this.externalTradeSourceTableMap.get(anExternalTradeSourceName));
		}

		final List<String> externalTradeStatuses = new ArrayList<>();
		for(final String anExternalTradeStatusName : selectedExternalTradeStatuses)
		{
			externalTradeStatuses.add(this.externalTradeStatusTableMap.get(anExternalTradeStatusName));
		}

		final List<String> externalTradeStates = new ArrayList<>();
		for(final String anExternalTradeStateName : selectedExternalTradeStates)
		{
			externalTradeStates.add(this.externalTradeStateTableMap.get(anExternalTradeStateName));
		}

		final Session session = HibernateUtil.beginTransaction();
		if(selectedExternalTradeAccounts.contains("Any"))
		{
			sqlQueryToFetchData = session.createSQLQuery(this.sqlQueryStringToFetchExternalTradesWithoutBuyerAccountQualifier);
			sqlQueryToFetchData.setParameter("buyerAccountsParam", "");
		}
		else
		{
			sqlQueryToFetchData = session.createSQLQuery(this.sqlQueryStringToFetchExternalTradesWithBuyerAccountQualifier);
			sqlQueryToFetchData.setParameterList("buyerAccountsParam", selectedExternalTradeAccounts);
		}

		sqlQueryToFetchData.setParameterList("externalTradeSourcesParam", externalTradeSources);
		sqlQueryToFetchData.setParameterList("externalTradeStatusesParam", externalTradeStatuses);
		sqlQueryToFetchData.setParameterList("externalTradeStatesParam", externalTradeStates);
		sqlQueryToFetchData.setParameter("startDate", startDate);
		sqlQueryToFetchData.setParameter("endDate", endDate);

		sqlQueryToFetchData.setResultTransformer(Transformers.aliasToBean(com.tc.app.exchangemonitor.controller.DummyExternalTrade.class));

		//dummyExternalTrades = sqlQueryToFetchData.list();

		/*FetchExternalTradesTask fetchExternalTradesTask = new FetchExternalTradesTask(sqlQueryToFetchData);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(fetchExternalTradesTask);*/

		//FetchExternalTradesService fetchExternalTradesService = new FetchExternalTradesService(sqlQueryToFetchData);
		final FetchExternalTradesService fetchExternalTradesService = new FetchExternalTradesService(null);
		this.statusBar.progressProperty().bind(fetchExternalTradesService.progressProperty());
		this.statusBar.textProperty().bind(fetchExternalTradesService.messageProperty());

		fetchExternalTradesService.restart();

		/*fetchExternalTradesTask.setOnSucceeded(new EventHandler<WorkerStateEvent>()
		{
			@Override
			public void handle(WorkerStateEvent event)
			{
				//dummyExternalTrades = fetchExternalTradesTask.getValue();
				//exchangeTradesTableView.setItems(dummyExternalTrades);

				System.out.println("fetchExternalTradesTask.getProgress() : " + fetchExternalTradesTask.getProgress());
				System.out.println("fetchExternalTradesTask.getMessage() : " + fetchExternalTradesTask.getMessage());

				dummyExternalTrades.clear();
				dummyExternalTrades.addAll(fetchExternalTradesTask.getValue());
			}
		});*/

		fetchExternalTradesService.setOnSucceeded(event -> MainWindowControllerNew_BACKUP_ON_30_05_2016.this.dummyExternalTrades.clear());

		return this.dummyExternalTrades;
	}

	public List<String> fetchDataFromDB(final String sqlQueryString, final String scalarColumn)
	{
		final Session session = HibernateUtil.beginTransaction();

		final SQLQuery sqlQueryToFetchData = session.createSQLQuery(sqlQueryString);
		sqlQueryToFetchData.addScalar(scalarColumn, StringType.INSTANCE);
		return sqlQueryToFetchData.list();
	}

	public List<Object> fetchDataFromDB(final String sqlQueryString, final String scalarColumn1, final String scalarColumn2)
	{
		List<Object> aTable = Collections.emptyList();
		//List<String> externalExchangesList = new ArrayList<String>();
		final Session session = HibernateUtil.beginTransaction();

		final SQLQuery sqlQueryToFetchData = session.createSQLQuery(sqlQueryString);
		sqlQueryToFetchData.addScalar(scalarColumn1, StringType.INSTANCE);
		//sqlQueryToFetchData.addScalar(scalarColumn2, IntegerType.INSTANCE);
		sqlQueryToFetchData.addScalar(scalarColumn2, StringType.INSTANCE);

		sqlQueryToFetchData.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		aTable = sqlQueryToFetchData.list();

		return aTable;
	}

	public void setExternalTradeSourceCheckBoxesOnUI(final List<String> externalTradeSources)
	{
		this.externalTradeSourcesListView.setItems(FXCollections.observableArrayList(externalTradeSources));
	}

	public void setExternalTradeStateCheckBoxesOnUI(final List<String> externalTradeStates)
	{
		this.externalTradeStatesListView.setItems(FXCollections.observableArrayList(externalTradeStates));
	}

	public void setExternalTradeStatusCheckBoxesOnUI(final List<String> externalTradeStatuses)
	{
		this.externalTradeStatusesListView.setItems(FXCollections.observableArrayList(externalTradeStatuses));
	}

	public void setExternalTradeAccountCheckBoxesOnUI(final List<String> externalTradeAccounts)
	{
		externalTradeAccounts.add(0, "Any");
		this.externalTradeAccountsListView.setItems(FXCollections.observableArrayList(externalTradeAccounts));
	}

	/**
	 * ============================================================================================================================================================================
	 * All temporarily commented code starts here. We may need in future for reference
	 * ============================================================================================================================================================================
	 */

	/*tradeAccountListView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
	@Override
	public BooleanProperty call(String item) {
	//public ObservableValue<Boolean> call(String item) {
	    /*BooleanProperty observable = new SimpleBooleanProperty();
	    observable.addListener((obs, wasSelected, isNowSelected) -> System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected));
	    return observable ;
	}
	}));*/

	// set the cell factory
	/*Callback<String, ObservableValue<Boolean>> getProperty = new Callback<String, ObservableValue<Boolean>>() {
	@Override
	public BooleanProperty call(String item) {
	    // given a person, we return the property that represents
	    // whether or not they are invited. We can then bind to this
	    // bidirectionally.
	    //return item;
		System.out.println(item + " is clicked");
		return null;
	}};

	tradeAccountListView.setCellFactory(CheckBoxListCell.forListView(getProperty));*/

	/*
	public void handleSearchByKey2(String oldVal, String newVal)
	{
		// If the number of characters in the text box is less than last time it must be because the user pressed delete
		if(oldVal != null && (newVal.length() < oldVal.length()))
		{
			// Restore the lists original set of entries and start from the beginning
			tradeAccountListView.setItems(FXCollections.observableArrayList(externalTradeAccounts));
		}

		// Break out all of the parts of the search text by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();
		//for (Object entry: tradeAccountListView.getItems())
		for(String entry: tradeAccountListView.getItems())
		{
			boolean match = true;
			for(String part: parts)
			{
				// The entry needs to contain all portions of the search string *but* in any order
				if(!entry.toUpperCase().contains(part))
				{
					match = false;
					break;
				}
			}

			if (match)
			{
				subentries.add(entry);
			}
		}
		tradeAccountListView.setItems(subentries);
	}
	 */

	/*public ObservableList<DummyTableData> getDummyTableData()
	{
		ObservableList<DummyTableData> dummyTableData = FXCollections.observableArrayList();

		dummyTableData.add(new DummyTableData(101, "Ken", "Anderson", new Date()));
		dummyTableData.add(new DummyTableData(102, "Davinder", "Virk", new Date()));
		dummyTableData.add(new DummyTableData(103, "Betty", "Quay", new Date()));
		dummyTableData.add(new DummyTableData(104, "Gwen", "Woody", new Date()));
		dummyTableData.add(new DummyTableData(105, "Robert", "Brad", new Date()));
		dummyTableData.add(new DummyTableData(106, "Rama", "Pakala", new Date()));

		return dummyTableData;
	}*/

	/**
	 * ============================================================================================================================================================================
	 * All temporarily commented code ends here. We may need in future for reference
	 * ============================================================================================================================================================================
	 */

	private void initializeGUIAndConfigureListenersAndInitializeAnimation()
	{
		this.initializeGUI();
		this.configureListeners();
		//initializeAnimation();
	}

	private void initializeGUI()
	{
		/**
		 * fetch exchanges from external_trade_source table and construct checkbox for each exchange and set it on the UI
		 */
		final List<String> externalTradeSources = this.fetchAllExternalTradeSourcesFromDB();
		this.setExternalTradeSourceCheckBoxesOnUI(externalTradeSources);

		/**
		 * fetch external trades states from external_trade_state table and construct checkbox for each trade state and set it on the UI
		 */
		final List<String> externalTradeStates = this.fetchAllExternalTradeStatesFromDB();
		this.setExternalTradeStateCheckBoxesOnUI(externalTradeStates);

		/**
		 * fetch external trades statuses from external_trade_status table and construct checkbox for each trade status and set it on the UI
		 */
		final List<String> externalTradeStatuses = this.fetchAllExternalTradeStatusesFromDB();
		this.setExternalTradeStatusCheckBoxesOnUI(externalTradeStatuses);

		/**
		 * fetch trade accounts from external_mapping table and with mapping_type 'K' and construct checkbox for trade account and set it on the UI
		 */
		//List<String> externalTradeAccounts = fetchExternalTradeAccountsFromDB();
		this.externalTradeAccounts = this.fetchAllExternalTradeAccountsFromDB();
		this.setExternalTradeAccountCheckBoxesOnUI(this.externalTradeAccounts);

		/**
		 * set today's date as default start date
		 */
		this.startDateDatePicker.setValue(LocalDate.now().minusDays(1));
		final DatePickerConverter datePickerConverter = new DatePickerConverter("dd-MMM-yyyy");
		this.startDateDatePicker.setConverter(datePickerConverter);
		//startDateDatePicker.setPromptText("dd-MMM-yyyy");

		/**
		 * set today's date as default end date
		 */
		this.endDateDatePicker.setValue(LocalDate.now());
		this.endDateDatePicker.setConverter(datePickerConverter);

		//fetchExternalTradesForTableViewFromDB();
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listener registration starts here
	 * ============================================================================================================================================================================
	 */

	private void configureListeners()
	{
		this.externalTradeSourcesListView.getCheckModel().getCheckedItems().addListener((final Change<? extends String> change) -> {
			this.handleExternalTradeSourcesCheckBoxClick(change);
		});

		this.externalTradeStatesListView.getCheckModel().getCheckedItems().addListener((final Change<? extends String> change) -> {
			this.handleExternalTradeStatesCheckBoxClick(change);
		});

		this.externalTradeStatusesListView.getCheckModel().getCheckedItems().addListener((final Change<? extends String> change) -> {
			this.handleExternalTradeStatusesCheckBoxClick(change);
		});

		/*tradeAccountSearchTextField.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				//handleSearchByKey2(oldValue, newValue);
				handleSearchByKey(oldValue, newValue);
			}
		});*/
		/* above code is commented and implemented as below using java 8 lambda */
		this.externalTradeAccountsSearchTextField.textProperty().addListener((final ObservableValue<? extends String> observable, final String oldValue, final String newValue) -> {
			this.handleExternalTradeAccountsFilterByKey(oldValue, newValue);
		});

		//tradeAccountListView.getCheckModel().getCheckedItems().addListener(accountsCheckBoxCheckedItemListener);
		this.externalTradeAccountsListView.getCheckModel().getCheckedItems().addListener((final Change<? extends String> change) -> {
			this.handleExternalTradeAccountsCheckBoxClick(change);
		});

		//filterTableDataTextField.textProperty().addListener(someLisetner);
		this.filterDummyExternalTradeTableViewDataTextField.textProperty().addListener((final Observable observable) -> {
			this.handleDummyExternalTradeTableViewFilterByKey();
		});

		/*tradeAccountListView.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<String>()
		{
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c)
			{
				System.out.println(tradeAccountListView.getSelectionModel().getSelectedItems());
				//System.out.println("Item Checked : " + c.getAddedSubList().get(0));
			}
		});*/

		/*tradeAccountListView.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
			@Override
			public void onChanged(ListChangeListener.Change<? extends String> change)
			{
				//System.out.println(tradeAccountListView.getSelectionModel().getSelectedItems());
				//System.out.println(tradeAccountListView.getCheckModel().getCheckedItems());
				//System.out.println("Item Checked : " + change.getAddedSubList().get(0));
				change.next();
		        if(change.wasAdded()) {
		            System.out.println("Item Checked : " + change.getAddedSubList().get(0));
		        } else if (change.wasRemoved()) {
		            System.out.println("Item Unchecked : " + change.getRemoved().get(0));
		        }
				change.next();
				//System.out.println(change.getAddedSubList().get(0));
				if(change.wasAdded())
				{
					checkedExternalTradeAccounts.add(change.getAddedSubList().get(0));
				}
				else if(change.wasRemoved())
				{
					checkedExternalTradeAccounts.remove(change.getRemoved().get(0));
				}
			}
		});*/
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

	public void handleExternalTradeAccountsFilterByKey(final String oldValue, String newValue)
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
		final ObservableList<String> subentries = FXCollections.observableArrayList();
		//List<String> subentries = new ArrayList<>();

		//for ( Object entry: tradeAccountListView.getItems() ) {
		for(final String entry : this.externalTradeAccountsListView.getItems())
		{
			if(entry.toUpperCase().contains(newValue))
			{
				subentries.add(entry);
			}
		}
		this.externalTradeAccountsListView.setItems(subentries);

		for(final String string : this.checkedExternalTradeAccounts)
		{
			if(subentries.contains(string))
			{
				this.externalTradeAccountsListView.getCheckModel().check(string);
			}
		}
		//tradeAccountListView.getCheckModel().getCheckedItems().addListener(accountsCheckBoxCheckedItemListener);
		this.externalTradeAccountsListView.getCheckModel().getCheckedItems().addListener((final Change<? extends String> change) -> {
			this.handleExternalTradeAccountsCheckBoxClick(change);
		});
	}

	public void handleExternalTradeSourcesCheckBoxClick(final Change<? extends String> change)
	{
		if(this.externalTradeSourcesListView.getCheckModel().getCheckedItems().size() == 0)
		{
			this.externalTradeSourcesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_SOURCES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeSourcesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_SOURCES_TITLEDPANE_TEXT + "(" + this.externalTradeSourcesListView.getCheckModel().getCheckedItems().size() + ")");
		}
	}

	public void handleExternalTradeStatesCheckBoxClick(final Change<? extends String> change)
	{
		if(this.externalTradeStatesListView.getCheckModel().getCheckedItems().size() == 0)
		{
			this.externalTradeStatesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeStatesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATES_TITLEDPANE_TEXT + "(" + this.externalTradeStatesListView.getCheckModel().getCheckedItems().size() + ")");
		}
	}

	public void handleExternalTradeStatusesCheckBoxClick(final Change<? extends String> change)
	{
		if(this.externalTradeStatusesListView.getCheckModel().getCheckedItems().size() == 0)
		{
			this.externalTradeStatusesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATUSES_TITLEDPANE_TEXT);
		}
		else
		{
			this.externalTradeStatusesTitledPane.setText(ApplicationConstants.EXTERNAL_TRADE_STATUSES_TITLEDPANE_TEXT + "(" + this.externalTradeStatusesListView.getCheckModel().getCheckedItems().size() + ")");
		}
	}

	public void handleExternalTradeAccountsCheckBoxClick(final Change<? extends String> change)
	{
		change.next();
		//System.out.println(change.getAddedSubList().get(0));
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
	}

	public void handleDummyExternalTradeTableViewFilterByKey()
	{
		if(this.filterDummyExternalTradeTableViewDataTextField.textProperty().get().isEmpty())
		{
			this.exchangeTradesTableView.setItems(FXCollections.observableArrayList(this.dummyExternalTrades));
			return;
		}
		final ObservableList<DummyExternalTrade> tableItems = FXCollections.observableArrayList();
		final ObservableList<TableColumn<DummyExternalTrade, ?>> allCoulmns = this.exchangeTradesTableView.getColumns();
		//for(int i=0; i<FXCollections.observableArrayList(dummyExternalTrades).size(); i++)
		for(int i = 0; i < this.dummyExternalTrades.size(); i++)
		{
			for(int j = 0; j < allCoulmns.size(); j++)
			{
				final TableColumn<DummyExternalTrade, ?> col = allCoulmns.get(j);
				//String cellValue = col.getCellData(FXCollections.observableArrayList(dummyExternalTrades).get(i)).toString();
				String cellValue = col.getCellData(this.dummyExternalTrades.get(i)).toString();
				cellValue = cellValue.toLowerCase();
				if(cellValue.contains(this.filterDummyExternalTradeTableViewDataTextField.textProperty().get().toLowerCase()))
				{
					//tableItems.add(FXCollections.observableArrayList(dummyExternalTrades).get(i));
					tableItems.add(this.dummyExternalTrades.get(i));
					break;
				}
			}
		}
		this.exchangeTradesTableView.setItems(tableItems);
	}

	/*public ListChangeListener<String> accountsCheckBoxCheckedItemListener = new ListChangeListener<String>()
	{
		@Override
		public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> change)
		{
			change.next();
			//System.out.println(change.getAddedSubList().get(0));
			if(change.wasAdded())
			{
				checkedExternalTradeAccounts.add(change.getAddedSubList().get(0));
			}
			else if(change.wasRemoved())
			{
				checkedExternalTradeAccounts.remove(change.getRemoved().get(0));
			}
			String temp = "Trade Account";
			if(checkedExternalTradeAccounts.size() == 0)
				tradeAccountTitledPane.setText(temp);
			else
				tradeAccountTitledPane.setText(temp + "(" + checkedExternalTradeAccounts.size() + ")");
		}
	};*/

	/**
	 * Here logic goes for filtering the table data
	 */

	public InvalidationListener someLisetner = new InvalidationListener(){
		//ObservableList<DummyExternalTrade> initialData = exchangeTradesTableView.getItems();
		final ObservableList<DummyExternalTrade> initialData = MainWindowControllerNew_BACKUP_ON_30_05_2016.this.exchangeTradesTableView != null ? MainWindowControllerNew_BACKUP_ON_30_05_2016.this.exchangeTradesTableView.getItems() : null;

		@Override
		public void invalidated(final Observable observable)
		{
			if(MainWindowControllerNew_BACKUP_ON_30_05_2016.this.filterDummyExternalTradeTableViewDataTextField.textProperty().get().isEmpty())
			{
				MainWindowControllerNew_BACKUP_ON_30_05_2016.this.exchangeTradesTableView.setItems(this.initialData);
				return;
			}
			final ObservableList<DummyExternalTrade> tableItems = FXCollections.observableArrayList();
			final ObservableList<TableColumn<DummyExternalTrade, ?>> cols = MainWindowControllerNew_BACKUP_ON_30_05_2016.this.exchangeTradesTableView.getColumns();
			for(int i = 0; i < this.initialData.size(); i++)
			{

				for(int j = 0; j < cols.size(); j++)
				{
					final TableColumn<DummyExternalTrade, ?> col = cols.get(j);
					String cellValue = col.getCellData(this.initialData.get(i)).toString();
					cellValue = cellValue.toLowerCase();
					if(cellValue.contains(MainWindowControllerNew_BACKUP_ON_30_05_2016.this.filterDummyExternalTradeTableViewDataTextField.textProperty().get().toLowerCase()))
					{
						tableItems.add(this.initialData.get(i));
						break;
					}
				}
			}
			MainWindowControllerNew_BACKUP_ON_30_05_2016.this.exchangeTradesTableView.setItems(tableItems);
		}
	};

	/*filterTableDataTextField.textProperty().addListener(new InvalidationListener() {
		@Override
		public void invalidated(Observable o) {
			if(filterTableDataTextField.textProperty().get().isEmpty()) {
				exchangeTradesTableView.setItems(getDummyTableData());
				return;
			}
			ObservableList<DummyExternalTrade> tableItems = FXCollections.observableArrayList();
			ObservableList<TableColumn<DummyExternalTrade, ?>> cols = exchangeTradesTableView.getColumns();
			for(int i=0; i<getDummyTableData().size(); i++) {

				for(int j=0; j<cols.size(); j++) {
					TableColumn col = cols.get(j);
					String cellValue = col.getCellData(getDummyTableData().get(i)).toString();
					cellValue = cellValue.toLowerCase();
					if(cellValue.contains(filterTableDataTextField.textProperty().get().toLowerCase())) {
						tableItems.add(getDummyTableData().get(i));
						break;
					}
				}

			}
			exchangeTradesTableView.setItems(tableItems);
		}
	});*/

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Animation logic starts here
	 * ============================================================================================================================================================================
	 */

	private void initializeAnimation()
	{
		// give a glow effect to a button
		final Glow glow = new Glow();
		glow.setLevel(0.0);
		this.startMonitorButton.setEffect(glow);

		final Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		final KeyValue kv = new KeyValue(glow.levelProperty(), 0.3);
		final KeyFrame kf = new KeyFrame(Duration.millis(700), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();

		//to rotate a component
		final RotateTransition rotate = new RotateTransition(Duration.seconds(2), this.startMonitorButtonImageView);
		rotate.setFromAngle(0);
		rotate.setByAngle(360);
		rotate.setCycleCount(-1);
		/*rotate.setAutoReverse(true);
		rotate.setCycleCount(Animation.INDEFINITE);
		rotate.setInterpolator(Interpolator.LINEAR);*/
		rotate.play();
	}

	@FXML
	public void handleStartMonitorButtonClick(final ActionEvent event)
	{
		//rotate.play();
		//timeline.play();
		this.startMonitoringExternalTrades();
	}

	private void startMonitoringExternalTrades()
	{
		//acc.setExpandedPane(externalTradeSourcesTitledPane);

		//System.out.println("Checked Items : " + externalTradeAccountsListView.getCheckModel().getCheckedItems());
		this.fetchExternalTradesFromDBForTableView();
		//exchangeTradesTableView.setItems(FXCollections.observableArrayList(dummyExternalTrades));
		final RotateTransition r = new RotateTransition(Duration.seconds(2), this.exchangeTradesTableView);
		r.setFromAngle(0);
		r.setByAngle(360);
		//r.play();

		final FadeTransition ft = new FadeTransition(Duration.seconds(2), this.exchangeTradesTableView);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		//ft.play();
	}

	public List<String> getExternalTradeSourcesSelectedByUserFromUI()
	{
		return this.externalTradeSourcesListView.getCheckModel().getCheckedItems();
	}

	public List<String> getExternalTradeStatesSelectedByUserFromUI()
	{
		return this.externalTradeStatesListView.getCheckModel().getCheckedItems();
	}

	public List<String> getExternalTradeStatusesSelectedByUserFromUI()
	{
		return this.externalTradeStatusesListView.getCheckModel().getCheckedItems();
	}

	public List<String> getExternalTradeAccountsSelectedByUserFromUI()
	{
		return this.externalTradeAccountsListView.getCheckModel().getCheckedItems();
	}

	/**
	 * ============================================================================================================================================================================
	 * All Animation logic ends here
	 * ============================================================================================================================================================================
	 */
}