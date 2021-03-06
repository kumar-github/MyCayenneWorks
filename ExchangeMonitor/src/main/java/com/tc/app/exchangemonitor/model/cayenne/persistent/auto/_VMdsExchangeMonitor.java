package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VMdsExchangeMonitor was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VMdsExchangeMonitor extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ACCEPTED_COMPANY = new Property<String>("acceptedCompany");
	public static final Property<String> ACCEPTED_TRADER = new Property<String>("acceptedTrader");
	public static final Property<String> CLEARING_ACCOUNT = new Property<String>("clearingAccount");
	public static final Property<String> COMMENT = new Property<String>("comment");
	public static final Property<String> COMMODITY = new Property<String>("commodity");
	public static final Property<Date> ENTRY_DATE = new Property<Date>("entryDate");
	public static final Property<String> EX_SOURCE = new Property<String>("exSource");
	public static final Property<String> EX_STATE = new Property<String>("exState");
	public static final Property<String> EX_STATUS = new Property<String>("exStatus");
	public static final Property<String> EXCH_TOOLS_TRADE_NUM = new Property<String>("exchToolsTradeNum");
	public static final Property<Integer> EXTERNAL_TRADE_OID = new Property<Integer>("externalTradeOid");
	public static final Property<Integer> EXTERNAL_TRADE_SOURCE_OID = new Property<Integer>("externalTradeSourceOid");
	public static final Property<Integer> EXTERNAL_TRADE_STATE_OID = new Property<Integer>("externalTradeStateOid");
	public static final Property<Integer> EXTERNAL_TRADE_STATUS_OID = new Property<Integer>("externalTradeStatusOid");
	public static final Property<Integer> EXTERNAL_TRADE_SYSTEM_OID = new Property<Integer>("externalTradeSystemOid");
	public static final Property<Integer> I_CTSPORT = new Property<Integer>("iCTSPort");
	public static final Property<Integer> I_CTSTRD = new Property<Integer>("iCTSTrd");
	public static final Property<String> INPUT_ACTION = new Property<String>("inputAction");
	public static final Property<String> INPUT_COMPANY = new Property<String>("inputCompany");
	public static final Property<String> INPUT_TRADER = new Property<String>("inputTrader");
	public static final Property<Double> PRICE = new Property<Double>("price");
	public static final Property<String> PUT_CALL = new Property<String>("putCall");
	public static final Property<Double> QTY = new Property<Double>("qty");
	public static final Property<BigDecimal> SEQUENCE = new Property<BigDecimal>("sequence");
	public static final Property<Double> STRIKE_PRICE = new Property<Double>("strikePrice");
	public static final Property<String> TRD_PERIOD = new Property<String>("trdPeriod");

	public void setAcceptedCompany(String acceptedCompany)
	{
		writeProperty("acceptedCompany", acceptedCompany);
	}

	public String getAcceptedCompany()
	{
		return (String) readProperty("acceptedCompany");
	}

	public void setAcceptedTrader(String acceptedTrader)
	{
		writeProperty("acceptedTrader", acceptedTrader);
	}

	public String getAcceptedTrader()
	{
		return (String) readProperty("acceptedTrader");
	}

	public void setClearingAccount(String clearingAccount)
	{
		writeProperty("clearingAccount", clearingAccount);
	}

	public String getClearingAccount()
	{
		return (String) readProperty("clearingAccount");
	}

	public void setComment(String comment)
	{
		writeProperty("comment", comment);
	}

	public String getComment()
	{
		return (String) readProperty("comment");
	}

	public void setCommodity(String commodity)
	{
		writeProperty("commodity", commodity);
	}

	public String getCommodity()
	{
		return (String) readProperty("commodity");
	}

	public void setEntryDate(Date entryDate)
	{
		writeProperty("entryDate", entryDate);
	}

	public Date getEntryDate()
	{
		return (Date) readProperty("entryDate");
	}

	public void setExSource(String exSource)
	{
		writeProperty("exSource", exSource);
	}

	public String getExSource()
	{
		return (String) readProperty("exSource");
	}

	public void setExState(String exState)
	{
		writeProperty("exState", exState);
	}

	public String getExState()
	{
		return (String) readProperty("exState");
	}

	public void setExStatus(String exStatus)
	{
		writeProperty("exStatus", exStatus);
	}

	public String getExStatus()
	{
		return (String) readProperty("exStatus");
	}

	public void setExchToolsTradeNum(String exchToolsTradeNum)
	{
		writeProperty("exchToolsTradeNum", exchToolsTradeNum);
	}

	public String getExchToolsTradeNum()
	{
		return (String) readProperty("exchToolsTradeNum");
	}

	public void setExternalTradeOid(Integer externalTradeOid)
	{
		writeProperty("externalTradeOid", externalTradeOid);
	}

	public Integer getExternalTradeOid()
	{
		return (Integer) readProperty("externalTradeOid");
	}

	public void setExternalTradeSourceOid(Integer externalTradeSourceOid)
	{
		writeProperty("externalTradeSourceOid", externalTradeSourceOid);
	}

	public Integer getExternalTradeSourceOid()
	{
		return (Integer) readProperty("externalTradeSourceOid");
	}

	public void setExternalTradeStateOid(Integer externalTradeStateOid)
	{
		writeProperty("externalTradeStateOid", externalTradeStateOid);
	}

	public Integer getExternalTradeStateOid()
	{
		return (Integer) readProperty("externalTradeStateOid");
	}

	public void setExternalTradeStatusOid(Integer externalTradeStatusOid)
	{
		writeProperty("externalTradeStatusOid", externalTradeStatusOid);
	}

	public Integer getExternalTradeStatusOid()
	{
		return (Integer) readProperty("externalTradeStatusOid");
	}

	public void setExternalTradeSystemOid(Integer externalTradeSystemOid)
	{
		writeProperty("externalTradeSystemOid", externalTradeSystemOid);
	}

	public Integer getExternalTradeSystemOid()
	{
		return (Integer) readProperty("externalTradeSystemOid");
	}

	public void setICTSPort(Integer iCTSPort)
	{
		writeProperty("iCTSPort", iCTSPort);
	}

	public Integer getICTSPort()
	{
		return (Integer) readProperty("iCTSPort");
	}

	public void setICTSTrd(Integer iCTSTrd)
	{
		writeProperty("iCTSTrd", iCTSTrd);
	}

	public Integer getICTSTrd()
	{
		return (Integer) readProperty("iCTSTrd");
	}

	public void setInputAction(String inputAction)
	{
		writeProperty("inputAction", inputAction);
	}

	public String getInputAction()
	{
		return (String) readProperty("inputAction");
	}

	public void setInputCompany(String inputCompany)
	{
		writeProperty("inputCompany", inputCompany);
	}

	public String getInputCompany()
	{
		return (String) readProperty("inputCompany");
	}

	public void setInputTrader(String inputTrader)
	{
		writeProperty("inputTrader", inputTrader);
	}

	public String getInputTrader()
	{
		return (String) readProperty("inputTrader");
	}

	public void setPrice(Double price)
	{
		writeProperty("price", price);
	}

	public Double getPrice()
	{
		return (Double) readProperty("price");
	}

	public void setPutCall(String putCall)
	{
		writeProperty("putCall", putCall);
	}

	public String getPutCall()
	{
		return (String) readProperty("putCall");
	}

	public void setQty(Double qty)
	{
		writeProperty("qty", qty);
	}

	public Double getQty()
	{
		return (Double) readProperty("qty");
	}

	public void setSequence(BigDecimal sequence)
	{
		writeProperty("sequence", sequence);
	}

	public BigDecimal getSequence()
	{
		return (BigDecimal) readProperty("sequence");
	}

	public void setStrikePrice(Double strikePrice)
	{
		writeProperty("strikePrice", strikePrice);
	}

	public Double getStrikePrice()
	{
		return (Double) readProperty("strikePrice");
	}

	public void setTrdPeriod(String trdPeriod)
	{
		writeProperty("trdPeriod", trdPeriod);
	}

	public String getTrdPeriod()
	{
		return (String) readProperty("trdPeriod");
	}

}
