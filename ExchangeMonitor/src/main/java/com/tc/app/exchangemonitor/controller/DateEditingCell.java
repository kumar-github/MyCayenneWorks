package com.tc.app.exchangemonitor.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

public class DateEditingCell extends TableCell<DummyLoadSchedule, Date>
{
	private DatePicker datePicker;
	public DateEditingCell()
	{
	}

	@Override
	public void startEdit()
	{
		if(!this.isEmpty())
		{
			super.startEdit();
			this.createDatePicker();
			this.setText(null);
			this.setGraphic(this.datePicker);
		}
	}

	@Override
	public void cancelEdit()
	{
		super.cancelEdit();

		//this.setText(this.getDate().toString());
		this.setText(this.getDate() != null ? this.getDate().toString() : null);
		this.setGraphic(null);
	}

	@Override
	public void updateItem(final Date item, final boolean empty)
	{
		super.updateItem(item, empty);

		if(empty)
		{
			this.setText(null);
			this.setGraphic(null);
		}
		else
		{
			if(this.isEditing())
			{
				if(this.datePicker != null)
				{
					this.datePicker.setValue(this.getDate());
				}
				this.setText(null);
				this.setGraphic(this.datePicker);
			}
			else
			{
				this.setText(this.getDate() != null ? this.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) : null);
				this.setGraphic(null);
			}
		}
	}

	private void createDatePicker()
	{
		this.datePicker = new DatePicker(this.getDate());
		this.datePicker.setMinWidth(this.getWidth() - (this.getGraphicTextGap() * 2));
		this.datePicker.setOnAction((e) -> {
			System.out.println("Committed: " + this.datePicker.getValue().toString());
			this.commitEdit(Date.from(this.datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		});
		//            datePicker.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		//                if (!newValue) {
		//                    commitEdit(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		//                }
		//            });
	}

	private LocalDate getDate()
	{
		//return this.getItem() == null ? LocalDate.now() : this.getItem().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return this.getItem() != null ? this.getItem().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
	}
}