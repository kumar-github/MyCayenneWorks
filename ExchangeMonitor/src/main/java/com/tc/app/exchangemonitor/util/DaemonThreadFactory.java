/**
 * Copyright (c) 2017 by amphorainc.com. All rights reserved.
 * created on Jan 9, 2017
 */
package com.tc.app.exchangemonitor.util;

import java.util.concurrent.ThreadFactory;

/**
 * @author Saravana Kumar M
 *
 */
public class DaemonThreadFactory implements ThreadFactory
{
	private final String threadName;

	public DaemonThreadFactory()
	{
		this.threadName = "ReferenceData Fetch Thread";
	}

	public DaemonThreadFactory(final String threadName)
	{
		this.threadName = threadName;
	}

	@Override
	public Thread newThread(final Runnable runnable)
	{
		final Thread thread = new Thread(runnable, this.threadName);
		thread.setDaemon(true);
		return thread;
	}
}