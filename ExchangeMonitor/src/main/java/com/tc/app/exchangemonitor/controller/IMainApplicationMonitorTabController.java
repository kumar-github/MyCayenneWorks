package com.tc.app.exchangemonitor.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

public interface IMainApplicationMonitorTabController extends IGenericController
{
	/* A function which returns the ExternalTradeSourceName for the given ExternalTrade  when called. */
	//public final Function<IExternalTradeEntity, String> externalTradeSourceFunction = (anExternalTrade) -> {
	public final Function<ExternalTrade, String> externalTradeSourceFunction = (anExternalTrade) -> {
		//return anExternalTrade.getExternalTradeSourceOid().getExternalTradeSrcName().toLowerCase();
		return anExternalTrade.getExternalTradeSourceO().getExternalTradeSrcName().toLowerCase();
	};

	/* A function which returns the ExternalTradeStateName for the given ExternalTrade  when called. */
	public final Function<ExternalTrade, String> externalTradeStateFunction = (anExternalTrade) -> {
		//return anExternalTrade.getExternalTradeStateOid().getExternalTradeStateName().toLowerCase();
		return anExternalTrade.getExternalTradeStateO().getExternalTradeStateName().toLowerCase();
	};

	public final Function<ExternalTrade, String> externalTradeStatusFunction = (anExternalTrade) -> {
		//return anExternalTrade.getExternalTradeStatusOid().getExternalTradeStatusName().toLowerCase();
		return anExternalTrade.getExternalTradeStatusO().getExternalTradeStatusName().toLowerCase();
	};

	public final Function<ExternalTrade, String> externalTradeCommodityFunction = (anExternalTrade) -> {
		//return anExternalTrade.getExchToolsTrade().getCommodity().toLowerCase();
		return anExternalTrade.getExternalTradeO1().getCommodity().toLowerCase();
	};

	public final List<Function<ExternalTrade, String>> externalTradeSearchablePropertiesList = Arrays.asList(
	//(anExternalTrade) -> anExternalTrade.getOid().toString(),
	(anExternalTrade) -> anExternalTrade.getExternalTradeOid().toString(),
	externalTradeSourceFunction,
	externalTradeStateFunction,
	externalTradeStatusFunction,
	externalTradeCommodityFunction);

	//This is not working since we are giving the same predicate reference every time and the FilteredList is thinking that the predicate is not changed not apply it.
	public Predicate<ExternalTrade> somePredicate = (anExternalTrade) -> {
		//String filterText = externalTradeTableViewDataFilterTextField.getText().trim().toLowerCase();
		final String filterText = null;

		if(filterText.isEmpty() || (filterText == null) || filterText.equals(""))
			return true;

		//if(anExternalTrade.getOid().toString().contains(filterText))
		if(anExternalTrade.getExternalTradeOid().toString().contains(filterText))
			return true;
		//else if(anExternalTrade.getExternalTradeSourceOid().getExternalTradeSrcName().toLowerCase().contains(filterText))
		else if(anExternalTrade.getExternalTradeSourceO().getExternalTradeSrcName().toLowerCase().contains(filterText))
			return true;
		//else if(anExternalTrade.getExternalTradeStatusOid().getExternalTradeStatusName().toLowerCase().contains(filterText))
		else if(anExternalTrade.getExternalTradeStatusO().getExternalTradeStatusName().toLowerCase().contains(filterText))
			return true;
		//else if(anExternalTrade.getExternalTradeStateOid().getExternalTradeStateName().toLowerCase().contains(filterText))
		else if(anExternalTrade.getExternalTradeStateO().getExternalTradeStateName().toLowerCase().contains(filterText))
			return true;

		return false;
	};

	default public Predicate<ExternalTrade> externalTradesTableViewFilterPredicateTemp(final String filterText)
	{
		return (anExternalTrade) -> {
			//String filterText = externalTradeTableViewDataFilterTextField.getText().trim().toLowerCase();

			if(filterText.isEmpty() || (filterText == null) || filterText.equals(""))
				return true;
			//if(anExternalTrade.getOid().toString().contains(filterText))
			if(anExternalTrade.getExternalTradeOid().toString().contains(filterText))
				return true;
			//else if(anExternalTrade.getExternalTradeSourceOid().getExternalTradeSrcName().toLowerCase().contains(filterText))
			else if(anExternalTrade.getExternalTradeSourceO().getExternalTradeSrcName().toLowerCase().contains(filterText))
				return true;
			//else if(anExternalTrade.getExternalTradeStatusOid().getExternalTradeStatusName().toLowerCase().contains(filterText))
			else if(anExternalTrade.getExternalTradeStatusO().getExternalTradeStatusName().toLowerCase().contains(filterText))
				return true;
			//else if(anExternalTrade.getExternalTradeStateOid().getExternalTradeStateName().toLowerCase().contains(filterText))
			else if(anExternalTrade.getExternalTradeStateO().getExternalTradeStateName().toLowerCase().contains(filterText))
				return true;

			return false;
		};
	}

	//default public Predicate<IExternalTradeEntity> externalTradesTableViewFilterPredicate(String filterText)
	default public Predicate<ExternalTrade> externalTradesTableViewFilterPredicate(final String filterText)
	{
		return (anExternalTrade) -> {
			//String filterText = externalTradeTableViewDataFilterTextField.getText().trim().toLowerCase();
			return filterText.isEmpty() || (filterText == null) || filterText.equals("") || externalTradeSearchablePropertiesList.stream().anyMatch((aFunction) -> aFunction.apply(anExternalTrade).contains(filterText));
		};
	}

	/*
	public default void handleExternalTradeTableViewFilterByKey()
	{
		if(externalTradeTableViewDataFilterTextField.textProperty().get().isEmpty())
		{
			externalTradesTableView.setItems(FXCollections.observableArrayList(externalTradesObservableList));
			return;
		}
		ObservableList<ExternalTrade> tableItems = FXCollections.observableArrayList();
		ObservableList<TableColumn<ExternalTrade, ?>> allCoulmns = externalTradesTableView.getColumns();
		for(int rowNum=0; rowNum<externalTradesObservableList.size(); rowNum++)
		{
			for(int colNum=0; colNum<allCoulmns.size(); colNum++)
			{
				TableColumn<ExternalTrade, ?> aColumn = allCoulmns.get(colNum);
				//String cellValue = aColumn.getCellData(externalTradesObservableList.get(rowNum)).toString();
				String cellValue = aColumn.getCellData(externalTradesObservableList.get(rowNum)) != null ? aColumn.getCellData(externalTradesObservableList.get(rowNum)).toString() : "";
				cellValue = cellValue.toLowerCase();
				if(cellValue.contains(externalTradeTableViewDataFilterTextField.textProperty().get().toLowerCase()))
				{
					tableItems.add(externalTradesObservableList.get(rowNum));
					break;
				}
			}
		}
		externalTradesTableView.setItems(tableItems);
	}
	 */
}