package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ExternalTradeExchangesCellFactory implements Callback<TableColumn<ExternalTrade, String>, TableCell<ExternalTrade, String>>
{
	/*
	// 1st way of implementing
	@Override
	public TableCell<ExternalTrade, ZonedDateTime> call(TableColumn<ExternalTrade, ZonedDateTime> param)
	{
		return new TableCell<ExternalTrade, ZonedDateTime>(){
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
					switch(item)
					{
						case "1":
							this.setText("NYMEX");
							break;
						case "2":
							this.setText("IPE");
							break;
						case "3":
							this.setText("ICE");
							break;
						case "4":
							this.setText("ExchangeTools");
							break;
						case "5":
							this.setText("DashBoard");
							break;
						case "6":
							this.setText("Excel");
							break;
						case "7":
							this.setText("DME");
							break;
						case "8":
							this.setText("ECONFIRM");
							break;
						case "9":
							this.setText("CEE");
							break;
						case "10":
							this.setText("Olympus");
							break;
						case "11":
							this.setText("CBT");
							break;
						case "12":
							this.setText("NonDefined");
							break;
						default:
							this.setText(null);
					}
				}
			}
		};
		return aTableCell;
	}
}