/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 28, 2016
 */
package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

import javafx.scene.control.ListCell;

/**
 * @author Saravana Kumar M
 *
 */
public class IctsUomButtonCell extends ListCell<Uom>
{
	/* (non-Javadoc)
	 * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
	 */
	@Override
	protected void updateItem(final Uom item, final boolean empty)
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
			this.setText(item.getUomCode() + " <--> " + item.getUomShortName());
		}
	}
}