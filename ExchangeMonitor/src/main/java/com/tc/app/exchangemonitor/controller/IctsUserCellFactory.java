package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsUserCellFactory implements Callback<ListView<IctsUser>, ListCell<IctsUser>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<IctsUser> call(final ListView<IctsUser> param)
	{
		return new IctsUserButtonCell();
		/*return new ListCell<IctsUser>(){
			@Override
			protected void updateItem(final IctsUser item, final boolean empty)
			{
				super.updateItem(item, empty);
				if(empty || (item == null))
				{
					this.setGraphic(null);
					this.setText(null);
				}
				else
				{
					this.setText(item.getUserInit());
				}
			}
		};*/
	}
}