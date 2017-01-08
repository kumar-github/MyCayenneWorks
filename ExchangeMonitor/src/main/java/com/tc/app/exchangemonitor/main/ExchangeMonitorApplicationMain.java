package com.tc.app.exchangemonitor.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sun.javafx.application.LauncherImpl;
import com.tc.app.exchangemonitor.ExchangeMonitorApplication;
import com.tc.app.exchangemonitor.preloader.ExchangeMonitionApplicationPreloader;

/**
 * @author Saravana Kumar M
 */
@SuppressWarnings("restriction")
public class ExchangeMonitorApplicationMain
{
	public static void main(final String[] args)
	{
		setUserPropertiesAsSystemProperties(loadPropertiesFromPropertiesFileIfExists());
		//System.out.println(java.lang.System.getProperty("java.library.path"));
		LauncherImpl.launchApplication(ExchangeMonitorApplication.class, ExchangeMonitionApplicationPreloader.class, args);
	}

	private static final Properties loadPropertiesFromPropertiesFileIfExists()
	{
		final Properties userProperties = new Properties();
		try(FileReader fileReader = new FileReader(new File("ExchangeMonitor.prop")))
		{
			userProperties.load(fileReader);
		}
		catch(final FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
		catch(final IOException exception)
		{
			exception.printStackTrace();
		}
		return userProperties;
	}

	private static final void setUserPropertiesAsSystemProperties(final Properties userProperties)
	{
		userProperties.forEach((key, value) -> System.setProperty(key.toString(), value.toString()));
		//userProperties.forEach((key, value) -> PropertiesHelper.setUserProperty(key.toString(), value.toString()));
	}
}