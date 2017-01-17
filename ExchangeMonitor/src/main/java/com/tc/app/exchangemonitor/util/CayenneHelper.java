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
	private static ServerRuntime cayenneServerRuntime;
	//private static String CONNECTION_URL = "jdbc:jtds:sqlserver://HYDDB07:1460;databaseName=QA_30_trade_nov22";
	private static String CONNECTION_URL = null;
	private static final String DATABASE_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static String USERNAME = null;
	private static String PASSWORD = null;

	private static void initialize()
	{
		try
		{
			//final Instant startTime = Instant.now();
			final long startTime = System.currentTimeMillis();
			//cayenneServerRuntime = ServerRuntimeBuilder.builder().addConfig("cayenne/cayenne-ExchangeMonitor.xml").build();

			CONNECTION_URL = PropertiesHelper.getSystemProperty("ConnectionUrl");
			USERNAME = PropertiesHelper.getSystemProperty("Username");
			PASSWORD = PropertiesHelper.getSystemProperty("Password");

			//@formatter:off
			final DataSource dataSource = DataSourceBuilder.url(CONNECTION_URL)
																												 .driver(DATABASE_DRIVER)
																												 .userName(USERNAME)
																												 .password(PASSWORD)
																												 .pool(1, 2).build();
			cayenneServerRuntime = ServerRuntimeBuilder.builder()
																											.addConfig("cayenne/cayenne-ExchangeMonitor.xml")
																											.dataSource(dataSource)
																											.build();

			//@formatter:on
			cayenneServerRuntime.newContext();

			//final Instant endTime = Instant.now();
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to create Cayenne Server Runtime.", (endTime - startTime));
		}
		catch(final Throwable exception)
		{
			// Log the exception.
			LOGGER.error("Cayenne ServerRuntime Creation Failed. {}", exception.getMessage());
			throw new RuntimeException(exception);
		}
		finally
		{
		}
	}

	public static void initializeCayenneServerRuntime()
	{
		initialize();
	}

	public static ServerRuntime getCayenneServerRuntime()
	{
		return cayenneServerRuntime;
	}
}