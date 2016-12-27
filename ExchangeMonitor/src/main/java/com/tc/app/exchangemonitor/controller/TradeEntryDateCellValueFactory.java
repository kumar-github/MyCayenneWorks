package com.tc.app.exchangemonitor.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class TradeEntryDateCellValueFactory implements Callback<TableColumn.CellDataFeatures<ExternalTrade, LocalDateTime>, ObservableValue<LocalDateTime>>
{
	@Override
	public ObservableValue<LocalDateTime> call(final CellDataFeatures<ExternalTrade, LocalDateTime> cellData)
	{
		//return param.getValue().getCreationDate().toInstant().atZone(ZoneId.systemDefault());
		//@formatter:off
		return new ReadOnlyObjectWrapper<>(cellData.getValue().getEntryDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		//@formatter:on
	}
}