/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 10, 2016
 */
package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;

/**
 * @author Saravana Kumar M
 */
public class ExternalTradeSourceCheckBoxCell extends ListCell<ExternalTradeSource>
{
	private final CheckBox checkBox = new CheckBox();
	public ExternalTradeSourceCheckBoxCell()
	{
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
	 */
	@Override
	protected void updateItem(final ExternalTradeSource item, final boolean empty)
	{
		super.updateItem(item, empty);
		if(empty || (item == null))
		{
			this.setText(null);
			this.setGraphic(null);
		}
		else
		{
			this.checkBox.setText(item.getExternalTradeSrcName());
			this.setGraphic(this.checkBox);
		}
	}
}