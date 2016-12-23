package com.tc.app.exchangemonitor.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class DateCellFactory implements Callback<TableColumn<ExternalTrade, ZonedDateTime>, TableCell<ExternalTrade, ZonedDateTime>>
{
	@Override
	public TableCell<ExternalTrade, ZonedDateTime> call(final TableColumn<ExternalTrade, ZonedDateTime> param)
	{
		return new TableCell<ExternalTrade, ZonedDateTime>(){
			@Override
			protected void updateItem(final ZonedDateTime item, final boolean empty)
			{
				super.updateItem(item, empty);
				if(empty || (item == null))
				{
					this.setText(null);
				}
				else
				{
					this.setText(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss z").format(item));
				}
			}
		};
	}
}