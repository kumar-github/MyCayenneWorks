package com.tc.app.exchangemonitor.controller;

import java.util.List;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import com.tc.app.exchangemonitor.entitybase.IExternalTradeEntity;
import com.tc.app.exchangemonitor.util.CayenneHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class FetchExternalTradesTask extends Task<ObservableList<IExternalTradeEntity>>
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	private final Query sqlQuery;

	public FetchExternalTradesTask()
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.sqlQuery = null;
	}

	public FetchExternalTradesTask(final Query sqlQuery)
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.sqlQuery = sqlQuery;
	}

	@Override
	protected ObservableList<IExternalTradeEntity> call() throws Exception
	{
		try
		{
			if(this.isAnythingChangedInDB())
				return FXCollections.observableArrayList(this.fetchExternalTradesForQuery(this.sqlQuery));
			return null;
		}
		catch(final Exception exception)
		{
			throw exception;
		}
	}

	private List<IExternalTradeEntity> fetchExternalTradesForQuery(final Query sqlQuery)
	{
		List<IExternalTradeEntity> externalTrades = null;

		try
		{
			this.updateMessage("Task Started...");
			this.updateProgress(-1.0, -1.0);

			/*
			try
			{
				Thread.sleep(1000);
			}
			catch(final InterruptedException ex)
			{
				this.updateMessage(ex.toString());
			}
			 */

			final long startTime = System.currentTimeMillis();
			externalTrades = sqlQuery.list();
			final long endTime = System.currentTimeMillis();
			this.updateMessage("Task Completed. It took " + (endTime - startTime) + " milli seconds to fetch " + externalTrades.size() + " record(s).");
			this.updateProgress(1.0, 1.0);

			/*
			try
			{
				Thread.sleep(1000);
			}
			catch(final InterruptedException ex)
			{
				this.updateMessage(ex.toString());
			}
			 */
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
			LOGGER.info("Something has changed in DB.");
			isAnythingChangedInDB = true;
			previousMaxTransId = currentMaxTransId;
			previousRecordCount = currentRecordCount;
		}

		return isAnythingChangedInDB;
	}
}