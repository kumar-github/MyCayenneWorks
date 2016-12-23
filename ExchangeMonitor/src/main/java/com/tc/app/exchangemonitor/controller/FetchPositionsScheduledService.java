package com.tc.app.exchangemonitor.controller;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.util.Duration;

// public class FetchPositionsScheduledService extends ScheduledService<ObservableList<DummyPosition>>
public class FetchPositionsScheduledService extends ScheduledService<ObservableList<DataRow>>
{
	//private final SQLQuery sqlQuery;
	private MappedSelect<DataRow> mappedSelect;
	//private final Duration DELAY = Duration.seconds(5);
	//private final Duration PERIOD = Duration.seconds(30);

	public FetchPositionsScheduledService()
	{
		this(null, Duration.seconds(5.0), Duration.seconds(30.0));
	}

	public FetchPositionsScheduledService(final MappedSelect<DataRow> mappedSelect, final Duration delay, final Duration period)
	{
		super();
		this.mappedSelect = mappedSelect;
		this.setDelay(delay);
		this.setPeriod(period);
	}

	public void setMappedSelect(final MappedSelect<DataRow> mappedSelect)
	{
		this.mappedSelect = mappedSelect;
	}

	@Override
	protected Task<ObservableList<DataRow>> createTask()
	{
		final FetchPositionsTask fetchPositionsTask = new FetchPositionsTask(this.mappedSelect);
		return fetchPositionsTask;
	}

	@Override
	protected void failed()
	{
		super.failed();
		System.out.println("Inside Failed.");
	}

	@Override
	protected void cancelled()
	{
		super.cancelled();
		System.out.println("Inside Cancelled.");
	}

	@Override
	protected void succeeded()
	{
		super.succeeded();
		System.out.println("Inside Succeeded.");
	}

	@Override
	protected void scheduled()
	{
		super.scheduled();
		System.out.println("Inside Scheduled.");
	}

	@Override
	protected void ready()
	{
		super.ready();
		System.out.println("Inside Ready.");
	}

	@Override
	protected void running()
	{
		super.running();
		System.out.println("Inside Running.");
	}
}