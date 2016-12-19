/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Dec 19, 2016
 */
package com.tc.app.exchangemonitor;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.query.EJBQLQuery;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SQLTemplate;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExchToolsTrade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus;
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
		testCall();
	}

	private static void testCall()
	{
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

		final List<ExternalTradeSource> src = ObjectSelect.query(ExternalTradeSource.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
		System.out.println(src);
		System.out.println(src.get(0).getExternalTradeSrcOid());

		final Date startDate = new Date(116, 9, 01);
		final Date endDate = new Date(116, 11, 18);
		System.out.println(startDate);
		System.out.println(endDate);

		final List<ExternalTrade> abcd = ObjectSelect.query(ExternalTrade.class).where(ExternalTrade.EXTERNAL_TRADE_STATUS_O.dot(ExternalTradeStatus.EXTERNAL_TRADE_STATUS_NAME).in("Pending", "Completed", "Failed", "Skipped")).and(ExternalTrade.EXTERNAL_TRADE_SOURCE_O.dot(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME).in("NYMEX", "ICE")).and(ExternalTrade.EXTERNAL_TRADE_STATE_O.dot(ExternalTradeState.EXTERNAL_TRADE_STATE_NAME).in("Add", "Update", "Delete", "DeleteAndAdd")).and(ExternalTrade.EXTERNAL_TRADE_O1.dot(ExchToolsTrade.CREATION_DATE).between(startDate, endDate)).and(ExternalTrade.EXTERNAL_TRADE_O1.dot(ExchToolsTrade.BUYER_ACCOUNT).in("B82B18", "B82B34", "B82A35", "AMPDEMO111", "TEST", "TC123", "VARTEST EXC BRK", "WU500206")).prefetch(ExternalTrade.EXTERNAL_TRADE_O1.joint()).prefetch(ExternalTrade.EXTERNAL_COMMENT.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
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