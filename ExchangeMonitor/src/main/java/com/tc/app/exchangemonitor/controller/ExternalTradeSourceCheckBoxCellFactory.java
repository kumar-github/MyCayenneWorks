package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ExternalTradeSourceCheckBoxCellFactory implements Callback<ListView<ExternalTradeSource>, ListCell<ExternalTradeSource>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<ExternalTradeSource> call(final ListView<ExternalTradeSource> param)
	{
		return new ExternalTradeSourceCheckBoxCell();
	}
}