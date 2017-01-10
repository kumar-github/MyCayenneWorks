package com.tc.app.exchangemonitor.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

public class TextEditingCell extends TableCell<DummyLoadSchedule, Date>
{
	private TextField textField;
	DateFormat dateFormat = new SimpleDateFormat("hh:mm");

	public TextEditingCell()
	{
	}

	@Override
	public void startEdit()
	{
		if(!this.isEmpty())
		{
			super.startEdit();
			this.createTextField();
			this.setText(null);
			this.setGraphic(this.textField);
			this.textField.selectAll();
		}
	}

	@Override
	public void cancelEdit()
	{
		super.cancelEdit();

		//this.setText(this.getItem());
		//this.setText(this.getItem().toString());
		this.setText(this.getItem().getHours() + ":" + this.getItem().getMinutes());
		this.setGraphic(null);
	}

	@Override
	public void updateItem(final Date item, final boolean empty)
	{
		super.updateItem(item, empty);

		if(empty)
		{
			//this.setText(item);
			//this.setText(item.toString());
			//this.setText(item != null ? item.toString() : null);
			this.setText(item != null ? item.getHours() + ":" + item.getMinutes() : null);
			this.setGraphic(null);
		}
		else
		{
			if(this.isEditing())
			{
				if(this.textField != null)
				{
					this.textField.setText(this.getString());
					//setGraphic(null);
				}
				this.setText(null);
				this.setGraphic(this.textField);
			}
			else
			{
				this.setText(this.getString());
				this.setGraphic(null);
			}
		}
	}

	private void createTextField()
	{
		this.textField = new TextField(this.getString());
		this.textField.setMinWidth(this.getWidth() - (this.getGraphicTextGap() * 2));

		//this.textField.setOnAction((e) -> this.commitEdit(this.textField.getText()));
		this.textField.setOnAction((e) -> {
			try
			{
				this.commitEdit(this.dateFormat.parse(this.textField.getText()));
			}
			catch(final ParseException exception1)
			{
				exception1.printStackTrace();
			}
		});

		this.textField.focusedProperty().addListener((final ObservableValue<? extends Boolean> observable, final Boolean oldValue, final Boolean newValue) -> {
			if(!newValue)
			{
				System.out.println("Commiting " + this.textField.getText());
				try
				{
					this.commitEdit(this.dateFormat.parse(this.textField.getText()));
				}
				catch(final ParseException exception)
				{
					exception.printStackTrace();
				}
			}
		});
	}

	private String getString()
	{
		//return this.getItem() == null ? "" : this.getItem();
		return this.getItem() != null ? this.getItem().getHours() + ":" + this.getItem().getMinutes() : null;
	}
}