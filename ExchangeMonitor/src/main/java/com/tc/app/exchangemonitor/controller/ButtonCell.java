package com.tc.app.exchangemonitor.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<DummyLoadSchedule, Boolean>
{
	private final Button button = new Button("Save");

	public ButtonCell()
	{
		this.button.setMinWidth(70.0);
		this.button.setPrefWidth(80.0);
		this.button.setOnAction((actionEvent) -> this.handleButtonClick());
	}

	@Override
	public void updateItem(final Boolean item, final boolean empty)
	{
		super.updateItem(item, empty);

		if(!empty)
		{
			this.setGraphic(this.button);
		}
	}

	private void handleButtonClick()
	{
		final DummyLoadSchedule currentItem = this.getTableView().getItems().get(this.getIndex());
		System.out.println(currentItem);
	}
}