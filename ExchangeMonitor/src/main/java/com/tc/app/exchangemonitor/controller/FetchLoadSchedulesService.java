package com.tc.app.exchangemonitor.controller;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.util.Duration;

public class FetchLoadSchedulesService extends Service<ObservableList<DataRow>>
{
	private static final Logger LOGGER = LogManager.getLogger();

	private MappedSelect<DataRow> mappedSelect;

	public FetchLoadSchedulesService()
	{
		this(null, Duration.seconds(5.0), Duration.seconds(30.0));
	}

	public FetchLoadSchedulesService(final MappedSelect<DataRow> mappedSelect, final Duration delay, final Duration period)
	{
		super();
		this.mappedSelect = mappedSelect;
	}

	public void setMappedSelect(final MappedSelect<DataRow> mappedSelect)
	{
		this.mappedSelect = mappedSelect;
	}

	@Override
	protected Task<ObservableList<DataRow>> createTask()
	{
		final FetchLoadSchedulesTask fetchLoadSchedulesTask = new FetchLoadSchedulesTask(this.mappedSelect);
		return fetchLoadSchedulesTask;
	}

	@Override
	protected void failed()
	{
		super.failed();
		LOGGER.debug("Inside Failed.");
	}

	@Override
	protected void cancelled()
	{
		super.cancelled();
		LOGGER.debug("Inside Cancelled.");
	}

	@Override
	protected void succeeded()
	{
		super.succeeded();
		LOGGER.debug("Inside Succeeded.");
	}

	@Override
	protected void scheduled()
	{
		super.scheduled();
		LOGGER.debug("Inside Scheduled.");
	}

	@Override
	protected void ready()
	{
		super.ready();
		LOGGER.debug("Inside Ready.");
	}

	@Override
	protected void running()
	{
		super.running();
		LOGGER.debug("Inside Running.");
	}
}