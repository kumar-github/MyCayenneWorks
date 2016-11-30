package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Country;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsCountryCellFactory implements Callback<ListView<Country>, ListCell<Country>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Country> call(final ListView<Country> param)
	{
		return new IctsCountryButtonCell();
	}
}