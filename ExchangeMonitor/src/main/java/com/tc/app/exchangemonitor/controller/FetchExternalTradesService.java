package com.tc.app.exchangemonitor.controller;

import org.apache.cayenne.query.ObjectSelect;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FetchExternalTradesService extends Service<ObservableList<ExternalTrade>>
{
	private final ObjectSelect<ExternalTrade> objectSelect;

	public FetchExternalTradesService()
	{
		this.objectSelect = null;
	}

	public FetchExternalTradesService(final ObjectSelect<ExternalTrade> objectSelect)
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