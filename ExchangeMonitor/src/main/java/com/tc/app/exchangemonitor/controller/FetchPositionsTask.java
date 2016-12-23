package com.tc.app.exchangemonitor.controller;

import java.util.List;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;

import com.tc.app.exchangemonitor.util.CayenneHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

// public class FetchPositionsTask extends Task<ObservableList<DummyPosition>>
public class FetchPositionsTask extends Task<ObservableList<DataRow>>
{
	private final MappedSelect<DataRow> mappedSelect;

	public FetchPositionsTask()
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.mappedSelect = null;
	}

	public FetchPositionsTask(final MappedSelect<DataRow> mappedSelect)
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.mappedSelect = mappedSelect;
	}

	@Override
	protected ObservableList<DataRow> call() throws Exception
	{
		try
		{
			return FXCollections.observableArrayList(this.fetchPositionsForQuery(this.mappedSelect));
		}
		catch(final Exception exception)
		{
			throw exception;
		}
	}

	private List<DataRow> fetchPositionsForQuery(final MappedSelect<DataRow> mappedSelect)
	{
		List<DataRow> dummyPositions = null;

		try
		{
			this.updateMessage("Task Started...");
			this.updateProgress(-1.0, -1.0);

			try
			{
				Thread.sleep(1000);
			}
			catch(final InterruptedException ex)
			{
				this.updateMessage(ex.toString());
			}

			final long startTime = System.currentTimeMillis();
			dummyPositions = mappedSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			this.updateMessage("Task Completed. It took " + (endTime - startTime) + " milliseconds to fetch " + dummyPositions.size() + " record(s).");
			this.updateProgress(1.0, 1.0);

			try
			{
				Thread.sleep(1000);
			}
			catch(final InterruptedException ex)
			{
				this.updateMessage(ex.toString());
			}
		}
		catch(final Exception exception)
		{
			throw exception;
		}
		return dummyPositions;
	}

	@Override
	protected void failed()
	{
		super.failed();
		/*System.out.println("inside failed.");
		updateMessage("Failed");*/
	}

	@Override
	protected void cancelled()
	{
		super.cancelled();
		/*System.out.println("inside cancelled.");
		updateMessage("Task Cancelled.");*/
	}

	@Override
	protected void running()
	{
		super.running();
		/*System.out.println("inside running.");
		updateMessage("Task Running.");*/
	}

	@Override
	protected void succeeded()
	{
		super.succeeded();
		/*System.out.println("inside succeeded.");
		updateMessage("Task Succeeded.");*/
	}

	@Override
	protected void scheduled()
	{
		super.scheduled();
		/*System.out.println("inside scheduled.");
		updateMessage("Task Scheduled.");*/
	}
}