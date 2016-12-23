package com.tc.app.exchangemonitor.controller;

import org.apache.cayenne.query.ObjectSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.util.Duration;

public class FetchExternalTradesScheduledService extends ScheduledService<ObservableList<ExternalTrade>>
{
	private static final Logger LOGGER = LogManager.getLogger();

	private ObjectSelect<ExternalTrade> objectSelect;
	//private final Duration DELAY = Duration.seconds(5);
	//private final Duration PERIOD = Duration.seconds(30);

	public FetchExternalTradesScheduledService()
	{
		this(null, Duration.seconds(5.0), Duration.seconds(30.0));
	}

	public FetchExternalTradesScheduledService(final ObjectSelect<ExternalTrade> objectSelect, final Duration delay, final Duration period)
	{
		super();
		this.objectSelect = objectSelect;
		this.setDelay(delay);
		this.setPeriod(period);
	}

	public void setObjectSelect(final ObjectSelect<ExternalTrade> objectSelect)
	{
		this.objectSelect = objectSelect;
	}

	@Override
	protected Task<ObservableList<ExternalTrade>> createTask()
	{
		final FetchExternalTradesTask fetchExternalTradesTask = new FetchExternalTradesTask(this.objectSelect);
		return fetchExternalTradesTask;
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