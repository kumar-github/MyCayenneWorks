package com.tc.app.exchangemonitor.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class TradeItemFillDateCellFactory implements Callback<TableColumn<DummySettlePrice, LocalDateTime>, TableCell<DummySettlePrice, LocalDateTime>>
{
	@Override
	public TableCell<DummySettlePrice, LocalDateTime> call(final TableColumn<DummySettlePrice, LocalDateTime> param)
	{
		return new TableCell<DummySettlePrice, LocalDateTime>(){
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
					//@formatter:off
					this.setText(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss").format(item));
					//@formatter:on
				}
			}
		};
	}
}