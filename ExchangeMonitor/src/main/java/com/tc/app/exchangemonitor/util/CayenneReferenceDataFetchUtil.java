package com.tc.app.exchangemonitor.util;

import java.util.List;
import java.util.Map;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.ProcedureQuery;

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

	/* Read the Stored Procedure from the datamap.xml file, set the paramters and keep it ready. */
	public static Integer generateNewTransaction()
	{
		Integer transId = null;

		try
		{
			final ProcedureQuery genNewTransactionProcedureQuery = new ProcedureQuery("gen_new_transaction");
			genNewTransactionProcedureQuery.addParameter("app_name", "ExchangeMonitor");
			genNewTransactionProcedureQuery.addParameter("trans_type", "U");

			final List data = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(genNewTransactionProcedureQuery);
			if(!data.isEmpty())
			{
				transId = ((Map<String, Integer>) data.get(0)).get("");
			}
		}
		catch(final Exception localException)
		{
			throw localException;
		}
		finally
		{
		}
		return transId;
	}
}