/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Dec 19, 2016
 */
package com.tc.app.exchangemonitor;

import java.sql.Date;
import java.util.List;

import org.apache.cayenne.map.EntityResult;
import org.apache.cayenne.map.SQLResult;
import org.apache.cayenne.query.SQLTemplate;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;
import com.tc.app.exchangemonitor.util.CayenneHelper;

/**
 * @author Saravana Kumar M
 *
 */
public class CayenneTest
{
	public static void main(final String[] args)
	{
		CayenneHelper.initializeCayenneServerRuntime();
		//testCall();
	}

	private static void testCall()
	{
		final String accountQuery = "select #result('aa.acct_addr_line_1' '' 'accountAddresses' 'accountAddresses.acct_addr_line_1'), #result('aa.acct_addr_num' '' 'accountAddresses' 'accountAddresses.acct_addr_num'), #result('a.acct_num' '' 'acct_num' 'acct_num'), #result('aa.acct_num' '' 'accountAddresses' 'accountAddresses.acct_num') from account a join account_address aa on a.acct_num = aa.acct_num where a.acct_num = 1";
		final SQLTemplate sqlT1 = new SQLTemplate(Account.class, accountQuery);
		sqlT1.addPrefetch("accountAddresses");
		final List<Account> accounts = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(sqlT1);
		System.out.println(accounts.size());
		System.out.println(accounts.get(0).getAccountAddresses());
		final List<AccountAddress> aas = accounts.get(0).getAccountAddresses();
		System.out.println(aas.size());
		System.exit(0);
		//final String q = "select t.trade_num, ti.trade_num, ti.order_num, ti.item_num from trade t join trade_item ti on t.trade_num = ti.trade_num where t.trade_num = 193307";
		//final String q = "select t.* from trade t join account a on t.acct_num = a.acct_num where t.trade_num = 193307";
		//final String q = "select t.trade_num, a.acct_num from trade t join account a on t.acct_num = a.acct_num where t.trade_num = 193307";
		final String q = "select #result('t.trade_num' '' '' 'trade_num'), #result('contr_date' 'Date'), #result('a.acct_num' '' '' 'account.acct_num'), #result('a.acct_short_name' '' '' 'account.acct_short_name') from trade t join account a on t.acct_num = a.acct_num where t.trade_num = 193307";
		final SQLTemplate sqlT = new SQLTemplate(Trade.class, q);
		sqlT.addPrefetch("account");
		final List<Trade> y = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(sqlT);
		System.out.println(y.size());
		//y.stream().forEach((aTrade) -> System.out.println(aTrade.getTradeNum() + "" + aTrade.getAccount()));
		y.stream().forEach((aTrade) -> System.out.println(aTrade.getTradeNum() + "" + aTrade.getContrDate()));
		//System.exit(0);

		//final MappedExec positionsQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("PositionWithoutBuyerAccount");
		final String query = "SELECT et.* FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (1)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.buyer_account NOT IN ('TC123')) AND (ett.creation_date >= ('2016-01-01')) AND (ett.creation_date <= ('2016-12-21')) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
		final SQLTemplate sqlTemplate = new SQLTemplate(ExternalTrade.class, query);
		//sqlTemplate.addPrefetch("EXTERNAL_TRADE_O1");
		//sqlTemplate.addPrefetch("externalTradeO1");
		final List<ExternalTrade> externalTrades = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(sqlTemplate);

		System.out.println(externalTrades.size());
		for(final ExternalTrade anExternalTrade : externalTrades)
		{
			System.out.println(anExternalTrade.getTradeNum());
			if(anExternalTrade.getExternalTradeO1() != null)
			{
				System.out.println(anExternalTrade.getExternalTradeO1().getCommodity());
			}
		}

		//System.exit(0);

		//final String positionQuery = "SELECT ets.external_trade_state_name as externalTradeStateName, ett.creation_date as creationDate, et.entry_date as entryDate, ett.exch_tools_trade_num as exchToolsTradeNum, ett.commodity as commodity, ett.trading_period as tradingPeriod, ett.call_put as callPut, ett.strike_price as strikePrice, ett.quantity as quantity, ett.price as price, ett.input_action as inputAction, ett.input_company as inputCompany, ett.accepted_action as acceptedAction, ett.accepted_company as acceptedCompany, ett.buyer_account as buyerAccount FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND (et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account NOT IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND (ett.creation_date <= (:endDate)) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
		final String positionQuery = "SELECT ets.external_trade_state_name as externalTradeStateName, ett.creation_date as creationDate, et.entry_date as entryDate, ett.exch_tools_trade_num as exchToolsTradeNum, ett.commodity as commodity, ett.trading_period as tradingPeriod, ett.call_put as callPut, ett.strike_price as strikePrice, ett.quantity as quantity, ett.price as price, ett.input_action as inputAction, ett.input_company as inputCompany, ett.accepted_action as acceptedAction, ett.accepted_company as acceptedCompany, ett.buyer_account as buyerAccount FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (1)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.creation_date >= ('2016-01-01')) AND (ett.creation_date <= ('2016-12-21')) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
		//final String positionQuery = "SELECT et.* FROM external_trade et, exch_tools_trade ett,external_trade_state ets WHERE (et.external_trade_system_oid IN (1)) AND (et.external_trade_source_oid in (1)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.creation_date >= ('2016-01-01')) AND (ett.creation_date <= ('2016-12-20')) AND NOT EXISTS (SELECT 1 FROM exch_tools_trade ett1 JOIN external_trade et1 ON et1.oid = ett1.external_trade_oid  JOIN external_trade_state ets1 ON et1.external_trade_state_oid = ets1.oid WHERE ett.commodity = ett1.commodity AND ett.exch_tools_trade_num  = ett1.exch_tools_trade_num AND ett.trading_period = ett1.trading_period AND ett.buyer_account = ett1.buyer_account AND convert(datetime,convert(varchar,ett.creation_date,109)) = convert(datetime,convert(varchar,ett1.creation_date,109)) AND ISNULL(ett.call_put,'NULL') = ISNULL(ett1.call_put,'NULL') AND ISNULL(ett.strike_price,0) = ISNULL(ett1.strike_price,0) AND (((ets1.external_trade_state_name = 'Update' or ets1.external_trade_state_name = 'Delete') AND (ets.external_trade_state_name = 'Add')) OR (ets1.external_trade_state_name = 'Delete' AND ets.external_trade_state_name = 'Update'))) AND ets.external_trade_state_name != 'Delete'  AND et.oid = ett.external_trade_oid AND et.external_trade_state_oid = ets.oid";
		///final String positionQuery = "SELECT * FROM external_trade et JOIN exch_tools_trade ett ON et.oid = ett.external_trade_oid WHERE et.trade_num = 2494184";
		//final SQLTemplate querySelect = new SQLTemplate(ExternalTrade.class, positionQuery);
		final SQLTemplate querySelect = new SQLTemplate(com.tc.app.exchangemonitor.controller.DummyPosition.class, positionQuery);
		final EntityResult entityResult = new EntityResult(com.tc.app.exchangemonitor.controller.DummyPosition.class);
		final SQLResult resultDescriptor = new SQLResult();
		resultDescriptor.addEntityResult(entityResult);
		querySelect.setResult(resultDescriptor);
		//querySelect.addPrefetch("externalTradeO1");
		//querySelect.addPrefetch("EXTERNAL_TRADE_O1");
		//querySelect.addPrefetch("ExternalTrade.externalTradeO1");
		final List x = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(querySelect);
		System.out.println(x);
		System.exit(0);

		/*
		//final EJBQLQuery query = new EJBQLQuery("SELECT externalTradeAlias from ExternalTrade externalTradeAlias JOIN externalTradeAlias.externalTradeO1 exch where externalTradeAlias.tradeNum = 2494177");
		final EJBQLQuery query = new EJBQLQuery("SELECT etAlias from ExternalTrade etAlias LEFT OUTER JOIN etalias.externalTradeO1 ex where etalias.tradeNum = 2494177");
		final List<ExternalTrade> red = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		System.out.println(red.get(0).getExternalTradeO1());
		System.out.println(red.get(0).getExternalTradeO1().getBuyerAccount());

		//final EJBQLQuery query = new EJBQLQuery("SELECT tradeOrderAlias from TradeOrder tradeOrderAlias where tradeOrderAlias.tradeNum = 135962");
		//final EJBQLQuery query = new EJBQLQuery("SELECT tradeOrderAlias from TradeOrder tradeOrderAlias where tradeOrderAlias.cashSettleType <> 'P'");
		//final EJBQLQuery query = new EJBQLQuery("SELECT tradeOrderAlias from Trade tradeOrderAlias where tradeOrderAlias.TradeNum = 135962");
		//final List<TradeOrder> red = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		//System.out.println(red.get(0).getOrderType());

		//System.exit(0);
		 */

		/*
		final ConcurrentMap<String, Commodity> x = CayenneReferenceDataCache.loadAllActiveCurrencies();
		System.out.println(x);
		System.out.println(x.get("USD"));
		System.exit(0);

		final EJBQLQuery query1 = new EJBQLQuery("select commodity FROM Commodity commodity JOIN commodity.commodityType type");
		System.out.println(query1);
		final List<Commodity> commodities = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query1);
		System.out.println(commodities.get(10).getCmdtyCode());
		System.out.println(commodities.get(10).getCommodityType());

		final EJBQLQuery query2 = new EJBQLQuery("select type FROM Commodity commodity JOIN commodity.commodityType type where type.commodityTypeCode = 'C'");
		System.out.println(query2);
		final List<CommodityType> commodityTypes = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query2);
		System.out.println(commodityTypes.get(10).getCommodityTypeCode());
		System.out.println(commodityTypes.get(10).getCmdtyTypeDesc());
		System.exit(0);
		 */

		//final EJBQLQuery query = new EJBQLQuery("select user FROM IctsUser user JOIN user.userJobTitle title");
		/*final EJBQLQuery query = new EJBQLQuery("select account FROM Account account JOIN account.accountType code");
		long startTime = System.currentTimeMillis();
		CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));
		System.exit(0);
		 */

		/*
		long startTime = System.currentTimeMillis();
		ObjectSelect.query(Account.class).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		ObjectSelect.query(Account.class).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));
		 */

		/*
		final EJBQLQuery query = new EJBQLQuery("select ets FROM ExternalTradeSource ets");
		final List<ExternalTradeSource> x = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		System.out.println(x);
		x.forEach((a) -> System.out.println(a.getExternalTradeSrcName()));
		final SQLTemplate select = new SQLTemplate(ExternalTradeState.class, "select * from external_trade_state");
		final List<ExternalTradeState> y = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(select);
		System.out.println(x);
		y.forEach((a) -> System.out.println(a.getExternalTradeStateName()));
		 */

		//final String ss = "SELECT et.* FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_source_oid IN (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND (et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND (ett.creation_date <= (:endDate)) ORDER BY ett.creation_date DESC";
		//final String ss = "SELECT et.* FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.oid = 18853833)";
		final String ss = "SELECT et.* FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_source_oid IN (1, 3, 6)) AND (et.external_trade_status_oid IN (1, 2, 3, 4)) AND (et.external_trade_state_oid IN (1, 2, 3, 4)) AND (ett.buyer_account IN ('B82B18', 'B82B34', 'B82A35', 'AMPDEMO111', 'TEST', 'TC123', 'VARTEST EXC BRK', 'WU500206')) AND (ett.creation_date between '2016-10-01' AND '2016-12-19') ORDER BY ett.creation_date DESC";
		final SQLTemplate select1 = new SQLTemplate(ExternalTrade.class, ss);
		select1.addPrefetch("externalTradeO1");
		final List<ExternalTrade> ab = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(select1);
		for(final ExternalTrade a : ab)
		{
			System.out.println(a.getExternalTradeO1());
			if(a.getExternalTradeO1() != null)
			{
				System.out.println(a.getExternalTradeO1().getBuyerAccount());
			}
		}
		//ab.forEach((a) -> System.out.println(a.getExternalTradeStateO() + a.getExternalTradeO1().getBuyerAccount() + a.getExternalCommentOid()));

		final Date startDate = new Date(116, 9, 01);
		final Date endDate = new Date(116, 11, 18);
		System.out.println(startDate);
		System.out.println(endDate);

		//final List<ExternalTrade> abcd = ObjectSelect.query(ExternalTrade.class).where(ExternalTrade.EXTERNAL_TRADE_STATUS_O.dot(ExternalTradeStatus.EXTERNAL_TRADE_STATUS_NAME).in("Pending", "Completed", "Failed", "Skipped")).and(ExternalTrade.EXTERNAL_TRADE_SOURCE_O.dot(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME).in("NYMEX", "ICE")).and(ExternalTrade.EXTERNAL_TRADE_STATE_O.dot(ExternalTradeState.EXTERNAL_TRADE_STATE_NAME).in("Add", "Update", "Delete", "DeleteAndAdd")).and(ExternalTrade.EXTERNAL_TRADE_O1.dot(ExchToolsTrade.CREATION_DATE).between(startDate, endDate)).and(ExternalTrade.EXTERNAL_TRADE_O1.dot(ExchToolsTrade.BUYER_ACCOUNT).in("B82B18", "B82B34", "B82A35", "AMPDEMO111", "TEST", "TC123", "VARTEST EXC BRK", "WU500206")).prefetch(ExternalTrade.EXTERNAL_TRADE_O1.joint()).prefetch(ExternalTrade.EXTERNAL_COMMENT.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		final List<ExternalTrade> abcd = null;
		abcd.forEach((a) -> System.out.println(a.getExternalCommentOid()));

		for(final ExternalTrade anExternalTrade : abcd)
		{
			if(anExternalTrade.getExternalComment() != null)
			{
				System.out.println(anExternalTrade.getExternalComment().getCommentText());
			}
		}
	}
}