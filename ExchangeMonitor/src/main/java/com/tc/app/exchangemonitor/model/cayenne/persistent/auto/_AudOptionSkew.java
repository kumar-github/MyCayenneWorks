package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudOptionSkew was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudOptionSkew extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<BigDecimal> OPT_STRIKE_SKEW = new Property<BigDecimal>("optStrikeSkew");
	public static final Property<Date> OPT_VOL_QUOTE_DATE = new Property<Date>("optVolQuoteDate");
	public static final Property<String> PRICE_SOURCE_CODE = new Property<String>("priceSourceCode");
	public static final Property<String> PUT_CALL_IND = new Property<String>("putCallInd");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<BigDecimal> VOLATILITY = new Property<BigDecimal>("volatility");

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setOptStrikeSkew(BigDecimal optStrikeSkew)
	{
		writeProperty("optStrikeSkew", optStrikeSkew);
	}

	public BigDecimal getOptStrikeSkew()
	{
		return (BigDecimal) readProperty("optStrikeSkew");
	}

	public void setOptVolQuoteDate(Date optVolQuoteDate)
	{
		writeProperty("optVolQuoteDate", optVolQuoteDate);
	}

	public Date getOptVolQuoteDate()
	{
		return (Date) readProperty("optVolQuoteDate");
	}

	public void setPriceSourceCode(String priceSourceCode)
	{
		writeProperty("priceSourceCode", priceSourceCode);
	}

	public String getPriceSourceCode()
	{
		return (String) readProperty("priceSourceCode");
	}

	public void setPutCallInd(String putCallInd)
	{
		writeProperty("putCallInd", putCallInd);
	}

	public String getPutCallInd()
	{
		return (String) readProperty("putCallInd");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setTradingPrd(String tradingPrd)
	{
		writeProperty("tradingPrd", tradingPrd);
	}

	public String getTradingPrd()
	{
		return (String) readProperty("tradingPrd");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setVolatility(BigDecimal volatility)
	{
		writeProperty("volatility", volatility);
	}

	public BigDecimal getVolatility()
	{
		return (BigDecimal) readProperty("volatility");
	}

}
