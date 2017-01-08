/**
 * Copyright (c) 2017 by amphorainc.com. All rights reserved.
 * created on Jan 6, 2017
 */
package com.tc.app.exchangemonitor.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Saravana Kumar M
 *
 */
public class PropertiesHelper
{
	private static final Map<String, String> properties = new HashMap<>();

	public static void setAsSystemProperty(final String key, final String value)
	{
		System.setProperty(key, value);
	}

	public static String getSystemProperty(final String key)
	{
		return System.getProperty(key, null);
	}

	public static void setAsUserProperty(final String key, final String value)
	{
		properties.put(key, value);
	}

	public static String getUserProperty(final String key)
	{
		return properties.get(key);
	}
}