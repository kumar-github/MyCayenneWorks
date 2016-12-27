package com.tc.app.exchangemonitor.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class TradeItemFillDateCellValueFactory implements Callback<TableColumn.CellDataFeatures<DummySettlePrice, LocalDateTime>, ObservableValue<LocalDateTime>>
{
	@Override
	public ObservableValue<LocalDateTime> call(final CellDataFeatures<DummySettlePrice, LocalDateTime> cellData)
	{
		//@formatter:off
		return new ReadOnlyObjectWrapper<>(cellData.getValue().getFillDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		//@formatter:on
	}
}