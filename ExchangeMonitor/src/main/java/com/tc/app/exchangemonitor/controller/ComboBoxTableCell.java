package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.controller.DummyLoadSchedule.LoadScheduleStatus;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;

public class ComboBoxTableCell extends TableCell<DummyLoadSchedule, LoadScheduleStatus>
{
	private ComboBox<LoadScheduleStatus> comboBox;

	public ComboBoxTableCell()
	{
	}

	@Override
	public void startEdit()
	{
		if(!this.isEmpty())
		{
			super.startEdit();
			this.createComboBox();
			this.setText(null);
			this.setGraphic(this.comboBox);
		}
	}

	@Override
	public void cancelEdit()
	{
		super.cancelEdit();

		//this.setText(this.getTyp().getTyp());
		this.setText(this.gett().name());
		this.setGraphic(null);
	}

	@Override
	public void updateItem(final LoadScheduleStatus item, final boolean empty)
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
				if(this.comboBox != null)
				{
					//this.comboBox.setValue(this.getTyp());
					this.comboBox.setValue(this.gett());
				}
				//this.setText(this.getTyp().getTyp());
				this.setText(this.gett().name());
				this.setGraphic(this.comboBox);
			}
			else
			{
				//this.setText(this.getTyp().getTyp());
				this.setText(this.gett().name());
				this.setGraphic(null);
			}
		}
	}

	private void createComboBox()
	{
		this.comboBox = new ComboBox<>();
		this.comboBoxConverter(this.comboBox);

		//this.comboBox.valueProperty().set(this.getTyp());
		this.comboBox.valueProperty().set(this.gett());

		this.comboBox.setMinWidth(this.getWidth() - (this.getGraphicTextGap() * 2));
		this.comboBox.setOnAction((e) -> {
			System.out.println("Committed: " + this.comboBox.getSelectionModel().getSelectedItem());
			this.commitEdit(this.comboBox.getSelectionModel().getSelectedItem());
		});
	}

	private void comboBoxConverter(final ComboBox<LoadScheduleStatus> comboBox)
	{
		// Define rendering of the list of values in ComboBox drop down.
		comboBox.setCellFactory((c) -> {
			return new ListCell<LoadScheduleStatus>(){
				@Override
				protected void updateItem(final LoadScheduleStatus item, final boolean empty)
				{
					super.updateItem(item, empty);

					if((item == null) || empty)
					{
						this.setText(null);
					}
					else
					{
						this.setText(item.name());
					}
				}
			};
		});
	}

	private LoadScheduleStatus gett()
	{
		return this.getItem() == null ? null : this.getItem();
	}
}