package com.tc.app.exchangemonitor.util;

import java.util.List;
import java.util.Map;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.query.MappedExec;
import org.apache.cayenne.query.MappedSelect;
import org.apache.cayenne.query.ProcedureQuery;

public class CayenneReferenceDataFetchUtil
{
	/* Read the Stored Procedure from the datamap.xml file, set the paramters and keep it ready. */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static Integer generateNewTransaction()
	{
		Integer transId = null;

		try
		{
			final ProcedureQuery genNewTransactionProcedureQuery = new ProcedureQuery("gen_new_transaction");
			genNewTransactionProcedureQuery.addParameter("app_name", "ExchangeMonitor");
			genNewTransactionProcedureQuery.addParameter("trans_type", 'U');

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

	/* Read the Stored Procedure from the datamap.xml file, set the paramters and keep it ready. */
	@SuppressWarnings("unchecked")
	public static Integer generateNewNum()
	{
		Integer newNum = null;

		try
		{
			final ProcedureQuery getNewNumProcedureQuery = new ProcedureQuery("get_new_num");
			getNewNumProcedureQuery.addParameter("key_name", "external_mapping_oid");
			getNewNumProcedureQuery.addParameter("location_num", 0);

			@SuppressWarnings("rawtypes")
			final List data = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(getNewNumProcedureQuery);
			if(!data.isEmpty())
			{
				newNum = ((Map<String, Integer>) data.get(0)).get("");
			}
		}
		catch(final Exception localException)
		{
			throw localException;
		}
		finally
		{
		}
		return newNum;
	}

	public static MappedExec getNonSelectQueryForName(final String queryName)
	{
		return MappedExec.query(queryName);
	}

	public static MappedSelect<DataRow> getSelectQueryForName(final String queryName)
	{
		//return MappedSelect.query(queryName, DataRow.class);
		return getSelectQueryForName(queryName, DataRow.class);
	}

	public static <T> MappedSelect<T> getSelectQueryForName(final String queryName, final Class<T> rootClass)
	{
		return MappedSelect.query(queryName, rootClass);
	}
}