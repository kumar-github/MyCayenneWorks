/**
 * Copyright (c) 2017 by amphorainc.com. All rights reserved.
 * created on Jan 8, 2017
 */
package com.tc.app.exchangemonitor.util;

import java.util.concurrent.Callable;

import org.apache.poi.ss.formula.functions.T;

import javafx.concurrent.Task;

/**
 * @author Saravana Kumar M
 *
 */
public class TaskUtil
{
	//public static final void task(final Callable<T> callable)
	public static final Task<T> task(final Callable<T> callable)
	{
		return new Task<T>(){
			@Override
			protected T call() throws Exception
			{
				return callable.call();
			}
		};
	}
}