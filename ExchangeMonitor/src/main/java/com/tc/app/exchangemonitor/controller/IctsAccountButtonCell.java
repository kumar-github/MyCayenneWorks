/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 28, 2016
 */
package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;

import javafx.scene.control.ListCell;

/**
 * @author Saravana Kumar M
 *
 */
public class IctsAccountButtonCell extends ListCell<Account>
{
	/* (non-Javadoc)
	 * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
	 */
	@Override
	protected void updateItem(final Account item, final boolean empty)
	{
		super.updateItem(item, empty);
		if(empty || (item == null))
		{
			this.setGraphic(null);
			this.setText(null);
		}
		else
		{
			this.setGraphic(null);
			this.setText(item.getAccountNum() + " <--> " + item.getAcctShortName());
		}
	}
}