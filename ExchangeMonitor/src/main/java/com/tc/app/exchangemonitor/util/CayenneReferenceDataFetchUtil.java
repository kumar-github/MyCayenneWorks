package com.tc.app.exchangemonitor.util;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;

public class CayenneReferenceDataFetchUtil
{
	public static List fetchDataFromDB()
	{
		List data = null;
		ObjectContext objectContext;

		try
		{
			final long sTime1 = System.currentTimeMillis();
			objectContext = CayenneHelper.getCayenneServerRuntime().newContext();
			final long eTime1 = System.currentTimeMillis();
			System.out.println("Context creation : " + (eTime1 - sTime1));

			final long sTime2 = System.currentTimeMillis();
			data = ObjectSelect.query(ExternalTradeSource.class).select(objectContext);
			final long eTime2 = System.currentTimeMillis();
			System.out.println(eTime2 - sTime2);
		}
		catch(final Exception localException)
		{
			throw localException;
		}
		finally
		{
		}
		return data;
	}
}