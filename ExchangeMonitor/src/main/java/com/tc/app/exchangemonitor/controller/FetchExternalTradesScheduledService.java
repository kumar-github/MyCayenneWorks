package com.tc.app.exchangemonitor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import com.tc.app.exchangemonitor.entitybase.IExternalTradeEntity;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.util.Duration;

public class FetchExternalTradesScheduledService extends ScheduledService<ObservableList<IExternalTradeEntity>>
{
	private static final Logger LOGGER = LogManager.getLogger();

	//private final SQLQuery sqlQuery;
	private Query sqlQuery;
	//private final Duration DELAY = Duration.seconds(5);
	//private final Duration PERIOD = Duration.seconds(30);

	public FetchExternalTradesScheduledService()
	{
		this(null, Duration.seconds(5.0), Duration.seconds(30.0));
	}

	public FetchExternalTradesScheduledService(final Query sqlQuery, final Duration delay, final Duration period)
	{
		super();
		this.sqlQuery = sqlQuery;
		this.setDelay(delay);
		this.setPeriod(period);
	}

	public void setSQLQuery(final Query sqlQuery)
	{
		this.sqlQuery = sqlQuery;
	}

	@Override
	protected Task<ObservableList<IExternalTradeEntity>> createTask()
	{
		final FetchExternalTradesTask fetchExternalTradesTask = new FetchExternalTradesTask(this.sqlQuery);
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