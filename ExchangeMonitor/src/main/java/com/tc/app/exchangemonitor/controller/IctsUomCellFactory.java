package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsUomCellFactory implements Callback<ListView<Uom>, ListCell<Uom>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Uom> call(final ListView<Uom> param)
	{
		return new IctsUomButtonCell();
	}
}