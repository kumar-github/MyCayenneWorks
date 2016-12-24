package com.tc.app.exchangemonitor.controller;

import java.util.List;

import org.apache.cayenne.query.MappedSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.FakeDummySettlePrice;
import com.tc.app.exchangemonitor.util.CayenneHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class FetchSettlePricesTask extends Task<ObservableList<FakeDummySettlePrice>>
{
	private static final Logger LOGGER = LogManager.getLogger();

	private final MappedSelect<FakeDummySettlePrice> mappedSelect;

	public FetchSettlePricesTask()
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.mappedSelect = null;
	}

	public FetchSettlePricesTask(final MappedSelect<FakeDummySettlePrice> mappedSelect)
	{
		this.updateMessage("");
		this.updateProgress(0.0, 0.0);
		this.mappedSelect = mappedSelect;
	}

	@Override
	protected ObservableList<FakeDummySettlePrice> call() throws Exception
	{
		try
		{
			return FXCollections.observableArrayList(this.fetchSettlePricesForQuery(this.mappedSelect));
		}
		catch(final Exception exception)
		{
			throw exception;
		}
	}

	private List<FakeDummySettlePrice> fetchSettlePricesForQuery(final MappedSelect<FakeDummySettlePrice> mappedSelect)
	{
		List<FakeDummySettlePrice> settlePrices = null;

		try
		{
			this.updateMessage("Task Started...");
			this.updateProgress(-1.0, -1.0);

			final long startTime = System.currentTimeMillis();
			//@formatter:off
			settlePrices = mappedSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());
			//@formatter:on
			final long endTime = System.currentTimeMillis();

			this.updateMessage("Task Completed. It took " + (endTime - startTime) + " milli seconds to fetch " + settlePrices.size() + " record(s).");
			this.updateProgress(1.0, 1.0);
		}
		catch(final Exception exception)
		{
			throw exception;
		}
		return settlePrices;
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
	protected void running()
	{
		super.running();
		LOGGER.debug("Inside Running.");
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
}