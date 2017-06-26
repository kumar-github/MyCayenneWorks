package com.tc.app.exchangemonitor.controller;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ButtonCellFactory implements Callback<TableColumn<DummyLoadSchedule, Boolean>, TableCell<DummyLoadSchedule, Boolean>>
{
	@Override
	public TableCell<DummyLoadSchedule, Boolean> call(final TableColumn<DummyLoadSchedule, Boolean> param)
	{
		return new ButtonCell();
	}
}