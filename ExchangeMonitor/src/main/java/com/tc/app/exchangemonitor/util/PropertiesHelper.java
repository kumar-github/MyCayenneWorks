/**
 * Copyright (c) 2017 by amphorainc.com. All rights reserved.
 * created on Jan 6, 2017
 */
package com.tc.app.exchangemonitor.util;

/**
 * @author Saravana Kumar M
 *
 */
public class PropertiesHelper
{
	public static void set(final String key, final String value)
	{
		System.setProperty(key, value);
	}

	public static String get(final String key)
	{
		return System.getProperty(key, null);
	}
}