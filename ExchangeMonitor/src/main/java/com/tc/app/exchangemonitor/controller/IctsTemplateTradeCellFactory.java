package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsTemplateTradeCellFactory implements Callback<ListView<Trade>, ListCell<Trade>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Trade> call(final ListView<Trade> param)
	{
		return new IctsTemplateTradeButtonCell();
	}
}