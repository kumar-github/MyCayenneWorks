package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ExternalTradeStateCellFactory implements Callback<TableColumn<ExternalTrade, String>, TableCell<ExternalTrade, String>>
{
	/*
	// 1st way of implementing
	@Override
	public TableCell<DummyExternalTrade, ZonedDateTime> call(TableColumn<DummyExternalTrade, ZonedDateTime> param)
	{
		return new TableCell<DummyExternalTrade, ZonedDateTime>(){
			@Override
			protected void updateItem(ZonedDateTime item, boolean empty)
			{
				super.updateItem(item, empty);
				if(empty || item == null)
				{
					setText(null);
				}
				else
				{
					setText(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss z").format(item));
				}
			}
		};
	}
	 */

	//2nd way of implementing
	@Override
	public TableCell<ExternalTrade, String> call(final TableColumn<ExternalTrade, String> param)
	{
		final TableCell<ExternalTrade, String> aTableCell = new TableCell<ExternalTrade, String>(){
			@Override
			protected void updateItem(final String item, final boolean empty)
			{
				super.updateItem(item, empty);
				if(empty || (item == null))
				{
					this.setText(null);
				}
				else
				{
					if(item.equals("1"))
					{
						this.setText("Add");
					}
					else if(item.equals("2"))
					{
						this.setText("Update");
					}
					else if(item.equals("3"))
					{
						this.setText("Delete");
					}
					else if(item.equals("4"))
					{
						this.setText("DeleteAndAdd");
					}
				}
			}
		};
		return aTableCell;
	}
}