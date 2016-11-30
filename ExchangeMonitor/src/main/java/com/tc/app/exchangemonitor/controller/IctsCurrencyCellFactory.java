package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsCurrencyCellFactory implements Callback<ListView<Commodity>, ListCell<Commodity>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Commodity> call(final ListView<Commodity> param)
	{
		return new IctsCurrencyButtonCell();
	}
}