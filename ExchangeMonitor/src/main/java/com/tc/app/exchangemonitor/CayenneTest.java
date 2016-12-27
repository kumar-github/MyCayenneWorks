/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Dec 19, 2016
 */
package com.tc.app.exchangemonitor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.cayenne.DataRow;
import org.apache.cayenne.map.EntityResult;
import org.apache.cayenne.map.SQLResult;
import org.apache.cayenne.query.MappedSelect;
import org.apache.cayenne.query.SQLExec;
import org.apache.cayenne.query.SQLSelect;
import org.apache.cayenne.query.SQLTemplate;
import org.apache.cayenne.query.SelectById;

import com.tc.app.exchangemonitor.controller.DummySettlePrice;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Comment;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExchToolsTrade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTrade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Price;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemFill;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;

/**
 * @author Saravana Kumar M
 *
 */
public class CayenneTest
{
	//@formatter:off
	public static void main(final String[] args)
	{
		CayenneHelper.initializeCayenneServerRuntime();
		//testCall();
		//@formatter:off
		//testCall1();
		//@formatter:on
		updateSettleTest();
	}

	private static void updateSettleTest()
	{
		double fillPriceToUse = 0.0;
		double avgFillPrice = 0.0;
		final boolean shouldConsiderFASDifferentialSet = true;
		//@formatter:off
		final MappedSelect<DataRow> mappedSelectQueryToFetchSettlePrices = CayenneReferenceDataFetchUtil.getSelectQueryForName("FetchTradeItemFills");
		final Map<String, String> parametersMap = new HashMap<>();
		parametersMap.put("startDateParam", "2014-01-01");
		parametersMap.put("endDateParam", "2016-12-26");
		mappedSelectQueryToFetchSettlePrices.params(parametersMap);
		final List<DataRow> dummySettlePrices = mappedSelectQueryToFetchSettlePrices.select(CayenneHelper.getCayenneServerRuntime().newContext());
		final List<DummySettlePrice> allSettlePrices = createDummySettlePriceObjectsForSettlePriceDataRows(dummySettlePrices);

		for(final DummySettlePrice aRecord : allSettlePrices)
		{
			final Integer transId = 0;
			final Integer tradeNum = 	aRecord.getTradeNum();
			final Integer orderNum = 	aRecord.getOrderNum();
			final Integer itemNum = 	aRecord.getItemNum();
			final Integer itemFillNum = 	aRecord.getItemFillNum();
			final Integer commentNum = 	aRecord.getCmntNum();
			final String exchToolsTradeNum = 	aRecord.getExternalTradeNum();


			/* Find settlement price. */
			final Map<String, Object> map = new HashMap<>();
			map.put(Price.COMMKT_KEY_PK_COLUMN, aRecord.getCommktKey());
			map.put(Price.PRICE_SOURCE_CODE_PK_COLUMN, aRecord.getPriceSourceCode());
			map.put(Price.TRADING_PRD_PK_COLUMN, aRecord.getTradingPrd());
			map.put(Price.PRICE_QUOTE_DATE_PK_COLUMN, aRecord.getFillDate());
			final SelectById<Price> settlementPrice = SelectById.query(Price.class, map);
			final Price aPriceRecord = settlementPrice.selectOne(CayenneHelper.getCayenneServerRuntime().newContext());

			System.out.println(aPriceRecord.getAvgClosedPrice());


			if((aPriceRecord == null) || (aPriceRecord.getAvgClosedPrice() == null))
			{
				/* We cannot find a price. So just set the fail comment and continue with other records. */
				setFailComment();
				continue;
			}
			//final Double rPrice = aPriceRecord.getAvgClosedPrice();
			final Double avgClosedPrice = aPriceRecord.getAvgClosedPrice();
			// need just to update it in the comment text
			final Double theOldFillPrice = aRecord.getFillPrice();
			final Double theNewFillPrice = shouldConsiderFASDifferentialSet ? theOldFillPrice + avgClosedPrice + aRecord.getOrderPrice() : theOldFillPrice + avgClosedPrice;


			final String findAvgPrice = "select * from trade_item_fill where trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam)";
			final SQLSelect<TradeItemFill> fillSQLSelect = SQLSelect.query(TradeItemFill.class, findAvgPrice);
			fillSQLSelect.params("tradeNumParam", tradeNum);
			fillSQLSelect.params("orderNumParam", orderNum);
			fillSQLSelect.params("itemNumParam", itemNum);
			final List<TradeItemFill> tradeItemFills = fillSQLSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());

			if((tradeItemFills == null) || (tradeItemFills.size() < 0))
			{
				setFailComment();
				continue;
			}

			double sumnum = 0.0;
			double fillQtySum = 0.0;
			for(final TradeItemFill tradeItemFill : tradeItemFills)
			{
				if(tradeItemFill.getFillNum() == aRecord.getItemFillNum())
				{
					fillPriceToUse = theNewFillPrice;
				}
				else
				{
					fillPriceToUse = tradeItemFill.getFillPrice();
				}
				sumnum = sumnum + (tradeItemFill.getFillQty() * fillPriceToUse);
				fillQtySum = fillQtySum + tradeItemFill.getFillQty();
			}
			if(fillQtySum != 0.0)
			{
				avgFillPrice = sumnum / fillQtySum;
			}
			else
			{
				avgFillPrice = 0.0;
			}

			/* update fill price, avg price, avg fill price, tiny cmnt*/
			final String updateTradeItemFill = "update trade_item_fill set fill_price = #bind($newFillPriceParam), trans_id = #bind($transIdParam) where trade_num = #bind($tradeNumParam) and order_num = #bind($orderNumParam) and item_num = #bind($itemNumParam) and item_fill_num = #bind($itemFillNumParam)";
			final String updateTradeItemFut = "update trade_item_fut set avg_fill_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) where trade_num =  #bind($tradeNumParam) and order_num = o#bind($orderNumParam) and item_num = #bind($itemNumParam)";
			final String updateTradeItem = "update trade_item set avg_price = #bind($avgFillPriceParam), trans_id = #bind($transIdParam) where trade_num = #bind($tradeNumParam) and order_num = o#bind($orderNumParam) and item_num = #bind($itemNumParam)";
			final String updateComment = "update comment set tiny_cmnt = 'Priced', trans_id = #bind($transIdParam) where cmnt_num = #bind($cmntNumParam)";
			final String updateExchToolsTrde = "update exch_tools_trade set price = #bind($priceParam), trans_id = #bind($transIdParam) where exch_tools_trade_num = #bind(@exchToolsTradeNumParam) and external_trade_oid in (select oid from external_trade where trade_num = #bind($tradeNumParam)";

			/* update comment with old price if comment exists else create a new comment */
			String theCommentToSet = "";
			final String selectTradeComment = "SELECT tradecommentalias.cmnt_num, commentalias.tiny_cmnt, commentalias.short_cmnt, commentalias.cmnt_text FROM trade_comment AS tradecommentalias RIGHT OUTER JOIN comment AS commentalias ON tradecommentalias.cmnt_num = commentalias.cmnt_num WHERE tradecommentalias.trade_num = #bind($tradeNumParam) AND tradecommentalias.trade_cmnt_type = 'T'";
			final Comment theComment = SQLSelect.query(Comment.class, selectTradeComment).params("tradeNumParam", tradeNum).selectOne(CayenneHelper.getCayenneServerRuntime().newContext());
			if(theComment != null)
			{
				// use the existing comment and update the necessary columns
				if((theComment.getTinyCmnt() != null) && !theComment.getTinyCmnt().isEmpty())
				{
					theCommentToSet = theComment.getTinyCmnt();
				}
				else if((theComment.getShortCmnt() != null) && !theComment.getShortCmnt().isEmpty())
				{
					theCommentToSet = theComment.getShortCmnt();
				}
				else if((theComment.getCmntText() != null) && !theComment.getCmntText().isEmpty())
				{
					theCommentToSet = theComment.getCmntText();
				}
			}
			else
			{
				//create a new trade comment and update the necessary columns
				final String insertTradeComment = "INSERT INTO trade_comment values(#bind($tradeNumParam), #bind($cmntNumParam), #bind($tradeCmntTypeParam), #bind($transIdParam))";
				final SQLExec insertTradeCommentSQLExce = new SQLExec(insertTradeComment);
				final int cmntNum = CayenneReferenceDataFetchUtil.generateNewNum("cmnt_num", 0);
				insertTradeCommentSQLExce.params("tradeNumParam", tradeNum);
				insertTradeCommentSQLExce.params("cmntNumParam", cmntNum);
				insertTradeCommentSQLExce.params("tradeCmntTypeParam", "T");
				insertTradeCommentSQLExce.params("transIdParam", transId);

				insertTradeCommentSQLExce.execute(CayenneHelper.getCayenneServerRuntime().newContext());
				theCommentToSet = "";
			}
			theCommentToSet = theCommentToSet + "\r\n****\r\n" + "Price Differential For Item Fill Number " + itemFillNum + " was " + theOldFillPrice + "\r\n****\r\n";
			String tinyCmnt = "";
			String shortCmnt = "";
			String cmntText = "";
			if(theCommentToSet.length() <= 16)
			{
				tinyCmnt = theCommentToSet;
				shortCmnt = null;
				cmntText = null;
			}
			else if(theCommentToSet.length() <= 255)
			{
				tinyCmnt = null;
				shortCmnt = theCommentToSet;
				cmntText = null;
			}
			else
			{
				tinyCmnt = null;
				shortCmnt = null;
				cmntText = theCommentToSet;
			}
			final String insertComment = "INSERT INTO comment values(#bind($cmntNumParam), #bind($tinyCmntParam), #bind($shortCmntParam), #bind($cmntPathParam), #bind($cmntTextParam), #bind($transIdParam))";
			final SQLExec insertCommentSQLExce = new SQLExec(insertComment);
			insertCommentSQLExce.params("cmntNumParam", cmntNum);
			insertCommentSQLExce.params("tinyCmntParam", tinyCmnt);
			insertCommentSQLExce.params("shortCmntParam", shortCmnt);
			insertCommentSQLExce.params("cmntPathParam", null);
			insertCommentSQLExce.params("cmntTextParam", cmntText);
			insertCommentSQLExce.params("transIdParam", transId);


			transId = CayenneReferenceDataFetchUtil.generateNewTransaction("ExchangeMonitor", "U");

			insertCommentSQLExce.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				System.out.println("testing...");
		}

		//@formatter:on
	}

	private static void setFailComment()
	{
		final String commentString = "Settlement Price Not Found!";
	}

	private static List<DummySettlePrice> createDummySettlePriceObjectsForSettlePriceDataRows(final List<DataRow> settlePriceDataRows)
	{
		if(settlePriceDataRows == null)
			return null;
		//@formatter:off
		return settlePriceDataRows.stream().map(DummySettlePrice::new).collect(Collectors.toList());
		//@formatter:on
	}

	private static void testCall1()
	{
		//@formatter:off
		final String q = "select * from trade_item_fill where trade_num = 2469563";
		final TradeItemFill fills = SQLSelect.query(TradeItemFill.class, q)
		.selectOne(CayenneHelper.getCayenneServerRuntime()
		.newContext());

		final Date fillDate = fills.getFillDate();
		System.out.println(fillDate);

		//q = "select * from price where commkt_key = 5 and price_source_code = 'EXCHANGE' and trading_prd = '201502' and price_quote_date = '2015-01-09'";
		final String queryToFindSettlementPrice = "SELECT * FROM price WHERE commkt_key = #bind($commktParam) AND price_source_code = #bind($priceSourceCodeParam) AND trading_prd = #bind($tradingPrdParam) AND price_quote_date = #bind($fillDateParam)";
		final SQLSelect<Price> priceSQLSelect = SQLSelect.query(Price.class, queryToFindSettlementPrice);
		priceSQLSelect.params("commktParam", 5);
		priceSQLSelect.params("priceSourceCodeParam", "EXCHANGE");
		priceSQLSelect.params("tradingPrdParam", "201502");
		priceSQLSelect.params("fillDateParam", fillDate);
		System.out.println(priceSQLSelect.getParams());
		final List<Price> prices = priceSQLSelect.select(CayenneHelper.getCayenneServerRuntime().newContext());
		System.out.println(prices);
		System.out.println(prices.get(0).getAvgClosedPrice());

		final SQLTemplate temp = new SQLTemplate(Price.class, q);
		final List<Price> aa = CayenneHelper.getCayenneServerRuntime()
		.newContext()
		.performQuery(temp);

		System.out.println(aa);
		System.out.println(aa.get(0)
		.getAvgClosedPrice());

		final ExchToolsTrade exch = SelectById.query(ExchToolsTrade.class, 18853860)
		.selectOne(CayenneHelper.getCayenneServerRuntime()
		.newContext());

		/*

		System.out.println(exch.getCreationDate());
		final Instant anInstant = exch.getCreationDate()
		.toInstant();
		final ZonedDateTime zdt = anInstant.atZone(ZoneId.systemDefault());
		System.out.println(zdt);
		System.out.println(zdt.toLocalDateTime());
		System.out.println(zdt.toLocalDateTime()
		.truncatedTo(ChronoUnit.SECONDS));

		final Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		System.out.println(date.getTimezoneOffset());

		final Instant instantFromDate = date.toInstant();
		System.out.println(instantFromDate);
		final Date dateFromInstant = date.from(instantFromDate);
		System.out.println(dateFromInstant);

		final LocalDate newDate = date.toInstant()
		.atZone(ZoneId.systemDefault())
		.toLocalDate();

		System.out.println(newDate);

		System.exit(0);

		final List<DataRow> trades = MappedSelect.query("FetchSettlePrices", DataRow.class)
		.select(CayenneHelper.getCayenneServerRuntime()
		.newContext());

		final String prices = "select * from price where commkt_key = 5 and price_source_code = 'EXCHANGE' and trading_prd = '201502'";
		final List<DataRow> r = SQLSelect.dataRowQuery(prices)
		.select(CayenneHelper.getCayenneServerRuntime()
		.newContext());

		ObjectSelect.query(Price.class)
		.where(Price.PRICE_QUOTE_DATE_PK_COLUMN);

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(final DataRow dataRow : r)
		{
			System.out.println(dataRow.get("price_quote_date"));
			try
			{
				final java.util.Date a = sdf.parse(dataRow.get("price_quote_date")
				.toString());
				System.out.println(a);
			}
			catch(final ParseException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
		*/
		//@formatter:on
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
	//@formatter:on
}