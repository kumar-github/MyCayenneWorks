package com.tc.app.exchangemonitor.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

// public class DateCellFactory implements Callback<TableColumn<ExternalTrade, ZonedDateTime>, TableCell<ExternalTrade, ZonedDateTime>>
public class DateCellFactory implements Callback<TableColumn<ExternalTrade, LocalDateTime>, TableCell<ExternalTrade, LocalDateTime>>
{
	@Override
	public TableCell<ExternalTrade, LocalDateTime> call(final TableColumn<ExternalTrade, LocalDateTime> param)
	{
		return new TableCell<ExternalTrade, LocalDateTime>(){
			@Override
			protected void updateItem(final LocalDateTime item, final boolean empty)
			{
				super.updateItem(item, empty);
				if(empty || (item == null))
				{
					this.setText(null);
				}
				else
				{
					//this.setText(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss z").format(item));
					this.setText(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss").format(item));
				}
			}
		};
	}
}