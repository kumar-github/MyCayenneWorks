package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CmfDependency was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CmfDependency extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> CMF_NUM = new Property<Integer>("cmfNum");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Date> LAST_TRADE_DATE = new Property<Date>("lastTradeDate");
	public static final Property<String> PRICE_SOURCE_CODE = new Property<String>("priceSourceCode");
	public static final Property<Integer> SUB_CMF_NUM = new Property<Integer>("subCmfNum");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setCmfNum(Integer cmfNum)
	{
		writeProperty("cmfNum", cmfNum);
	}

	public Integer getCmfNum()
	{
		return (Integer) readProperty("cmfNum");
	}

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setLastTradeDate(Date lastTradeDate)
	{
		writeProperty("lastTradeDate", lastTradeDate);
	}

	public Date getLastTradeDate()
	{
		return (Date) readProperty("lastTradeDate");
	}

	public void setPriceSourceCode(String priceSourceCode)
	{
		writeProperty("priceSourceCode", priceSourceCode);
	}

	public String getPriceSourceCode()
	{
		return (String) readProperty("priceSourceCode");
	}

	public void setSubCmfNum(Integer subCmfNum)
	{
		writeProperty("subCmfNum", subCmfNum);
	}

	public Integer getSubCmfNum()
	{
		return (Integer) readProperty("subCmfNum");
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

}
