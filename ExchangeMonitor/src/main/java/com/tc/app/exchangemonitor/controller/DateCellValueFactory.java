package com.tc.app.exchangemonitor.controller;

import java.time.LocalDateTime;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class DateCellValueFactory implements Callback<TableColumn.CellDataFeatures<ExternalTrade, LocalDateTime>, ObservableValue<LocalDateTime>>
{
	@Override
	public ObservableValue<LocalDateTime> call(final CellDataFeatures<ExternalTrade, LocalDateTime> param)
	{
		//return param.getValue().getCreationDate().toInstant().atZone(ZoneId.systemDefault());
		//return new ReadOnlyObjectWrapper<ZonedDateTime>(param.getValue().getCreationDate().toInstant().atZone(ZoneId.systemDefault()));
		return null;
	}
}