package com.tc.app.exchangemonitor.controller;

import org.apache.cayenne.query.MappedExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<DummyLoadSchedule, Boolean>
{
	private static final Logger LOGGER = LogManager.getLogger();
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
		final DummyLoadSchedule recordToSave = this.getTableView().getItems().get(this.getIndex());
		LOGGER.debug("Modified Record {}", recordToSave);

		try
		{
			if(recordToSave.getOid() == null)
			{
				/* we are here bcoz it is a new record user trying to insert. */
				final MappedExec insertLoadScheduleQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("InsertLoadSchedule");
				final Integer newNum = CayenneReferenceDataFetchUtil.generateNewNum("ext_trade_loading_sched_oid", 0);
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
				insertLoadScheduleQuery.param("oidParam", newNum);
				insertLoadScheduleQuery.param("externalTradeSourceOidParam", null);
				insertLoadScheduleQuery.param("buyerSellerAccountParam", recordToSave.getExternalValue1());
				insertLoadScheduleQuery.param("loadingScheduleParam", recordToSave.getLoadingSchedule().name());
				insertLoadScheduleQuery.param("loadingTimeFromParam", recordToSave.getLoadingTimeFrom() != null ? new java.sql.Timestamp(recordToSave.getLoadingTimeFrom().getTime()) : null);
				insertLoadScheduleQuery.param("loadingTimeToParam", recordToSave.getLoadingTimeTo() != null ? new java.sql.Timestamp(recordToSave.getLoadingTimeTo().getTime()) : null);
				insertLoadScheduleQuery.param("loadingDateTimezoneParam", recordToSave.getLoadingDateTimezone());
				insertLoadScheduleQuery.param("tradeDateToLoadParam", recordToSave.getTradeDateToLoad());
				insertLoadScheduleQuery.param("transIdParam", transid);
				insertLoadScheduleQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				/*
				 * This is NEEDED.
				 * User saved a record for the first time. Assume he selected "Off" and saved. Since this is first time the oid will be null so we insert a new record.
				 * User again changed the value from "Off" to "Load All" and saved. Now we should treat this as an update but since we did not reload the UI after the previous save, this record still does not have the oid set
				 * and this leads to another insert.
				 */
				recordToSave.setOid(newNum);
			}
			else
			{
				/* we are here bcoz it is an existing record user trying to update. */
				final MappedExec updateLoadScheduleQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("UpdateLoadSchedule");
				final Integer transid = CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");
				updateLoadScheduleQuery.param("loadingScheduleParam", recordToSave.getLoadingSchedule().name());
				updateLoadScheduleQuery.param("loadingTimeFromParam", recordToSave.getLoadingTimeFrom() != null ? new java.sql.Timestamp(recordToSave.getLoadingTimeFrom().getTime()) : null);
				updateLoadScheduleQuery.param("loadingTimeToParam", recordToSave.getLoadingTimeTo() != null ? new java.sql.Timestamp(recordToSave.getLoadingTimeTo().getTime()) : null);
				updateLoadScheduleQuery.param("loadingDateTimezoneParam", recordToSave.getLoadingDateTimezone());
				updateLoadScheduleQuery.param("tradeDateToLoadParam", recordToSave.getTradeDateToLoad());
				updateLoadScheduleQuery.param("transIdParam", transid);
				updateLoadScheduleQuery.param("oidParam", recordToSave.getOid());
				updateLoadScheduleQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Insert/Update Failed.", exception);
		}
	}
}