package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.control.CheckListView;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;
import com.tc.app.exchangemonitor.model.predicates.ExternalMappingPredicates;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.view.java.ExternalMappingAccountsView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingBrokersView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingCompaniesView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingCurrenciesView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingPortfoliosView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingTemplateTradesView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingTradersView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingTradingPeriodsView;
import com.tc.app.exchangemonitor.view.java.ExternalMappingUOMConversionsView;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.layout.BorderPane;

public class MainApplicationMappingsTabController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger(MainApplicationMonitorTabController.class);

	@FXML
	private CheckListView<ExternalTradeSource> externalTradeSourcesListView;
	@FXML
	private BorderPane mappingsWindowBorderPane;
	@FXML
	private Button tradersMappingButton;
	@FXML
	private Button brokersMappingButton;
	@FXML
	private Button companiesMappingButton;
	@FXML
	private Button currenciesMappingButton;
	@FXML
	private Button portfoliosMappingButton;
	@FXML
	private Button templateTradesMappingButton;
	@FXML
	private Button accountsMappingButton;
	@FXML
	private Button uomConversionsMappingButton;
	@FXML
	private Button tradingPeriodsMappingButton;

	/*
	@FXML
	private Button addMappingButton;
	@FXML
	private Button deleteMappingButton;
	@FXML
	private Button updateMappingButton;
	 */

	/*
	 * This is a listener variable which is initialized to null. Later we will bind this listener variable to some property. For eg:(RadioButton's selection property and a TextField's text property etc...) so that when those properties change
	 * this will get fired. But we did not attach any handler method do this variable. We need to attach some kind of handler method which contains the logic to be executed when the corressponding property changes.
	 */
	private ChangeListener<Toggle> externalTradeSourcesRadioButtonClickListener = null;

	private final ObservableList<ExternalTradeSource> observableExternalTradeSourceList = FXCollections.observableArrayList();


	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.setAnyUIComponentStateIfNeeded();
		this.createListeners();
		this.attachListeners();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(MainApplicationMappingsTabController.class, this);
	}

	private void doAssertion()
	{
		assert this.externalTradeSourcesListView != null : "fx:id=\"externalTradeSourcesListView\" was not injected. Check your FXML file MainApplicationMappingsTabView.fxml";
	}

	private void doInitialDataBinding()
	{
		this.externalTradeSourcesListView.setItems(this.observableExternalTradeSourceList);

		/* Disable the mapping buttons if external trade source is not selected. */
		this.tradersMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.brokersMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.companiesMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.currenciesMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.portfoliosMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.templateTradesMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.accountsMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.uomConversionsMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());
		this.tradingPeriodsMappingButton.disableProperty().bind(ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().isNull());

		/* Enable the "Add" button only if any mapping table is visible. */
		//this.addMappingButton.disableProperty().bind(Bindings.createBooleanBinding(() -> this.mappingsWindowBorderPane.getCenter() == null, this.mappingsWindowBorderPane.centerProperty()));
		//this.deleteMappingButton.disableProperty().bind(this.externalMappingsViewModel.isAnyRowSelectedInTradersViewProperty().not());
		//this.deleteMappingButton.disableProperty().bind(this.externalMappingsViewModel.isAnyRowSelectedInTradersViewProperty().not().or(this.externalMappingsViewModel.isAnyRowSelectedInBrokersViewProperty().not()));
	}

	private void initializeGUI()
	{
		this.fetchExternalTradeSources();
	}

	private void setAnyUIComponentStateIfNeeded()
	{
		//exchangesListView.setCellFactory((param) -> new ExternalTradeSourceRadioButtonCellFactory());
		//externalTradeSourcesListView.setCellFactory(new ExternalTradeSourceRadioButtonCellFactory());
		this.externalTradeSourcesListView.setCellFactory((param) -> new ExternalTradeSourceRadioCellForMappingsTab());
	}

	private void fetchExternalTradeSources()
	{
		//this.observableExternalTradeSourceList.addAll(ReferenceDataCache.fetchExternalTradeSources().values());
		this.observableExternalTradeSourceList.addAll(CayenneReferenceDataCache.loadExternalTradeSources().values());
	}

	public void createListeners()
	{
		this.externalTradeSourcesRadioButtonClickListener = (observavleValue, oldValue, newValue) -> {
			this.handleExternalTradeSourcesRadioButtonClick(newValue);
		};
	}

	private void handleExternalTradeSourcesRadioButtonClick(final Toggle newValue)
	{
		if(this.mappingsWindowBorderPane.getCenter() != null)
		{
			//final Predicate<IExternalMappingEntity> anExternalSourcePredicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(((RadioButton) newValue).getText());
			final Predicate<ExternalMapping> anExternalSourcePredicate = ExternalMappingPredicates.getPredicateForExternalTradeSource(((RadioButton) newValue).getText());
			switch(this.mappingsWindowBorderPane.getCenter().getId())
			{
				case "tradersMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingTradersController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "brokersMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingBrokersController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "companiesMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingCompaniesController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "currenciesMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingCurrenciesController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "portfoliosMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingPortfoliosController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "tradesMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingTemplateTradesController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "accountsMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingAccountsController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "uomConversionsMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingUOMConversionsController.class).updateFilter(anExternalSourcePredicate);
					break;

				case "tradingPeriodsMappingVBox":
					ApplicationHelper.controllersMap.getInstance(ExternalMappingTradingPeriodsController.class).updateFilter(anExternalSourcePredicate);
					break;

				default:
					break;
			}
		}
	}

	public void attachListeners()
	{
		ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.selectedToggleProperty().addListener(this.externalTradeSourcesRadioButtonClickListener);
	}

	private static String CURRENT_VISIBLE_MAPPING_VIEW = null;
	@FXML
	private void handleTradersMappingButtonClick()
	{
		//this.mappingsWindowBorderPane.setCenter(null);
		//this.mappingsWindowBorderPane.setCenter(new ExternalMappingTradersView().getView());
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("tradersMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingTradersView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingTradersView Loaded.");
		}
		LOGGER.debug("ExternalMappingTradersView not loaded because it is already loaded.");
	}

	@FXML
	private void handleBrokersMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("brokersMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingBrokersView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingBrokersView Loaded.");
		}
		LOGGER.debug("ExternalMappingBrokersView not loaded because it is already loaded.");
	}

	@FXML
	private void handleCompaniesMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("companiesMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingCompaniesView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingCompaniesView Loaded.");
		}
		LOGGER.debug("ExternalMappingCompaniesView not loaded because it is already loaded.");
	}

	@FXML
	private void handleCurrenciesMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("currenciesMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingCurrenciesView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingCurrenciesView Loaded.");
		}
		LOGGER.debug("ExternalMappingCurrenciesView not loaded because it is already loaded.");
	}

	@FXML
	private void handlePortfoliosMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("portfoliosMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingPortfoliosView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingPortfoliosView Loaded.");
		}
		LOGGER.debug("ExternalMappingPortfoliosView not loaded because it is already loaded.");
	}

	@FXML
	private void handleTemplateTradesMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("templateTradesMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingTemplateTradesView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingTemplateTradesView Loaded.");
		}
		LOGGER.debug("ExternalMappingTemplateTradesView not loaded because it is already loaded.");
	}

	@FXML
	private void handleAccountsMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("accountsMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingAccountsView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingAccountsView Loaded.");
		}
		LOGGER.debug("ExternalMappingAccountsView not loaded because it is already loaded.");
	}

	@FXML
	private void handleUOMConversionsMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("uomConversionsMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingUOMConversionsView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingUOMConversionsView Loaded.");
		}
		LOGGER.debug("ExternalMappingUOMConversionsView not loaded because it is already loaded.");
	}

	@FXML
	private void handleTradingPeriodsMappingButtonClick()
	{
		if((CURRENT_VISIBLE_MAPPING_VIEW == null) || !CURRENT_VISIBLE_MAPPING_VIEW.equals("tradingPeriodsMappingVBox"))
		{
			this.mappingsWindowBorderPane.setCenter(new ExternalMappingTradingPeriodsView().getView());
			CURRENT_VISIBLE_MAPPING_VIEW = this.mappingsWindowBorderPane.getCenter().getId();
			LOGGER.debug("ExternalMappingTradingPeriodsView Loaded.");
		}
		LOGGER.debug("ExternalMappingTradingPeriodsView not loaded because it is already loaded.");
	}
}