package com.tc.app.exchangemonitor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseUtil
{
	private static final Logger LOGGER = LogManager.getLogger();

	public static boolean makeTestConnection(final String url, final String username, final String password) throws SQLException
	{
		boolean isSuccess = false;
		//String driver = "net.sourceforge.jtds.jdbc.Driver";

		/* If no username, password mentioned or username, password is null, then it will be treated as Windows Authentication. */
		try(Connection connection = DriverManager.getConnection(url, username, password))
		{
			isSuccess = true;
		}
		catch(final SQLException exception)
		{
			LOGGER.error(exception);
			throw exception;
		}
		return isSuccess;
	}
}