package com.tc.app.exchangemonitor.util;

import javax.sql.DataSource;

import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.configuration.server.ServerRuntimeBuilder;
import org.apache.cayenne.datasource.DataSourceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CayenneHelper
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final ServerRuntime cayenneServerRuntime;
	private static String CONNECTION_URL = "jdbc:jtds:sqlserver://HYDDB07:1460;databaseName=QA_30_trade_nov22";
	private static final String DATABASE_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static String USERNAME = null;
	private static String PASSWORD = null;

	static
	{
		try
		{
			//final Instant startTime = Instant.now();
			final long startTime = System.currentTimeMillis();
			//cayenneServerRuntime = ServerRuntimeBuilder.builder().addConfig("cayenne/cayenne-ExchangeMonitor.xml").build();

			//CONNECTION_URL = PropertiesHelper.get("CONNECTION_URL");
			USERNAME = PropertiesHelper.getSystemProperty("USERNAME");
			PASSWORD = PropertiesHelper.getSystemProperty("PASSWORD");

			//@formatter:off
			//final DataSource dataSource = DataSourceBuilder.url("jdbc:jtds:sqlserver://HYDDB07:1460;databaseName=QA_30_trade_nov22").driver("net.sourceforge.jtds.jdbc.Driver").userName("ictspass").password("ictspass").pool(1, 2).build();
			final DataSource dataSource = DataSourceBuilder.url(CONNECTION_URL)
																												 .driver(DATABASE_DRIVER)
																												 .userName(USERNAME)
																												 .password(PASSWORD)
																												 .pool(1, 3).build();
			cayenneServerRuntime = ServerRuntimeBuilder.builder()
																											.addConfig("cayenne/cayenne-ExchangeMonitor.xml")
																											.dataSource(dataSource)
																											.build();

			//@formatter:on
			cayenneServerRuntime.newContext();

			//final Instant endTime = Instant.now();
			final long endTime = System.currentTimeMillis();
			//LOGGER.info("It took " + (endTime - startTime) + " milli seconds to create Cayenne Server Runtime.");
			LOGGER.info("It took {} milli seconds to create Cayenne Server Runtime.", (endTime - startTime));
		}
		catch(final Throwable exception)
		{
			// Log the exception.
			LOGGER.error("ServerRuntime Creation Failed.", exception);
			throw new ExceptionInInitializerError(exception);
		}
		finally
		{
			//LOGGER.info(Duration.between(startTime, endTime));
			//System.out.println("cayenneServerRuntime : " + cayenneServerRuntime);
		}
	}

	public static void initializeCayenneServerRuntime()
	{
	}

	public static ServerRuntime getCayenneServerRuntime()
	{
		return cayenneServerRuntime;
	}
}