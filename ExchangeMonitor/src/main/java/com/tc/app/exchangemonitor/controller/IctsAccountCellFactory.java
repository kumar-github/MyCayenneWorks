package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsAccountCellFactory implements Callback<ListView<Account>, ListCell<Account>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Account> call(final ListView<Account> param)
	{
		return new IctsAccountButtonCell();
	}
}