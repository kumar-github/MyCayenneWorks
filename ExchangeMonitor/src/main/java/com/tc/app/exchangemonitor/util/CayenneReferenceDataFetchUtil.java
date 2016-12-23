package com.tc.app.exchangemonitor.util;

import java.util.List;
import java.util.Map;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.MappedExec;
import org.apache.cayenne.query.MappedSelect;
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
	public static Integer generateNewNum()
	{
		Integer newNum = null;

		try
		{
			final ProcedureQuery getNewNumProcedureQuery = new ProcedureQuery("get_new_num");
			getNewNumProcedureQuery.addParameter("key_name", "external_mapping_oid");
			getNewNumProcedureQuery.addParameter("location_num", 0);

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
		return MappedSelect.query(queryName, DataRow.class);
	}

	public static final String getPositionWithoutBuyerAccountQuery()
	{
		//return "SELECT et.* FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (1)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.buyer_account NOT IN ('TC123')) AND (ett.creation_date >= ('2016-01-01')) AND (ett.creation_date <= ('2016-12-21')) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
		return "SELECT et.* FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (1)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.buyer_account NOT IN ('TC123')) AND (ett.creation_date >= ('2016-01-01')) AND (ett.creation_date <= ('2016-12-21')) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
	}

	public static final String getPositionWithBuyerAccountQuery()
	{
		return "SELECT et.* FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND (et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND 	(ett.creation_date <= (:endDate)) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
	}
}