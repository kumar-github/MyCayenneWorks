package com.tc.app.exchangemonitor.controller;

import java.util.List;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;
import com.tc.app.exchangemonitor.util.CayenneHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class FetchExternalTradesTask extends Task<ObservableList<ExternalTrade>>
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	private final ObjectSelect<ExternalTrade> objectSelect;

	public FetchExternalTradesTask()
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.objectSelect = null;
	}

	public FetchExternalTradesTask(final ObjectSelect<ExternalTrade> objectSelect)
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.objectSelect = objectSelect;
	}

	@Override
	protected ObservableList<ExternalTrade> call() throws Exception
	{
		try
		{
			if(this.isAnythingChangedInDB())
				return FXCollections.observableArrayList(this.fetchExternalTradesForObjectSelect(this.objectSelect));
			return null;
		}
		catch(final Exception exception)
		{
			throw exception;
		}
	}

	private List<ExternalTrade> fetchExternalTradesForObjectSelect(final ObjectSelect<ExternalTrade> objectSelect)
	{
		List<ExternalTrade> externalTrades = null;

		try
		{
			this.updateMessage("Task Started...");
			this.updateProgress(-1.0, -1.0);

			final long startTime = System.currentTimeMillis();
			externalTrades = objectSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();

			this.updateMessage("Task Completed. It took " + (endTime - startTime) + " milli seconds to fetch " + externalTrades.size() + " record(s).");
			this.updateProgress(1.0, 1.0);
		}
		catch(final Exception exception)
		{
			throw exception;
		}
		return externalTrades;
	}

	@Override
	protected void failed()
	{
		super.failed();
		LOGGER.debug("Inside Failed.");
		//this.updateMessage("Failed");
	}

	@Override
	protected void cancelled()
	{
		super.cancelled();
		LOGGER.debug("Inside Cancelled.");
		//this.updateMessage("Task Cancelled.");
	}

	@Override
	protected void running()
	{
		super.running();
		LOGGER.debug("Inside Running.");
		//this.updateMessage("Task Running.");
	}

	@Override
	protected void succeeded()
	{
		super.succeeded();
		LOGGER.debug("Inside Succeeded.");
		//updateMessage("Task Succeeded.");
	}

	@Override
	protected void scheduled()
	{
		super.scheduled();
		LOGGER.debug("Inside Scheduled.");
		//updateMessage("Task Scheduled.");
	}

	private static Integer previousMaxTransId = 0;
	private static Integer previousRecordCount = 0;
	private boolean isAnythingChangedInDB()
	{
		boolean isAnythingChangedInDB = false;

		//final String query = "SELECT MAX(trans_id) AS MaxTransID, COUNT(*) AS RecordCount from  external_trade";
		//final List<DataRow> data = SQLSelect.dataRowQuery(query).select(CayenneHelper.getCayenneServerRuntime().newContext());
		final List<DataRow> data = MappedSelect.query("IsAnythingChangedInDB", DataRow.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
		final Integer currentMaxTransId = (Integer) data.get(0).get("MaxTransID");
		final Integer currentRecordCount = (Integer) data.get(0).get("RecordCount");

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("Previous Max Trans Id {} Current Max Trans Id in DB {}", previousMaxTransId, currentMaxTransId);
			LOGGER.debug("Previous Total Records Count {} Current Total Records Count in DB {}", previousRecordCount, currentRecordCount);
		}

		if((currentMaxTransId.longValue() != previousMaxTransId.longValue()) || (currentRecordCount.longValue() != previousRecordCount.longValue()))
		{
			LOGGER.info("Something has changed in DB or previousMaxTransId and previousRecordCount got reset.");
			isAnythingChangedInDB = true;
			previousMaxTransId = currentMaxTransId;
			previousRecordCount = currentRecordCount;
		}
		return isAnythingChangedInDB;
	}

	/* resetting the previuos record count and previous max transids. */
	public static final void reset()
	{
		previousMaxTransId = 0;
		previousRecordCount = 0;
	}
}