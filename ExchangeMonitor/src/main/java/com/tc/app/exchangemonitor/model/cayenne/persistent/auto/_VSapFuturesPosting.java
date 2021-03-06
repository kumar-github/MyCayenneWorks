package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VSapFuturesPosting was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VSapFuturesPosting extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CLEARING_BRKR = new Property<String>("clearingBrkr");
	public static final Property<Integer> CLEARING_BRKR_VCI_CODE = new Property<Integer>("clearingBrkrVciCode");
	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<String> CPTY = new Property<String>("cpty");
	public static final Property<String> CREATE_MONTH = new Property<String>("createMonth");
	public static final Property<Integer> CREATE_YEAR = new Property<Integer>("createYear");
	public static final Property<String> CREATOR = new Property<String>("creator");
	public static final Property<String> CURRENCY = new Property<String>("currency");
	public static final Property<Double> CURRENCY_PL = new Property<Double>("currencyPl");
	public static final Property<Double> FILL_PRICE = new Property<Double>("fillPrice");
	public static final Property<String> FLOOR_BRKR = new Property<String>("floorBrkr");
	public static final Property<String> INHOUSE = new Property<String>("inhouse");
	public static final Property<Integer> INHOUSE_PORT_NUM = new Property<Integer>("inhousePortNum");
	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Date> LAST_ISSUE_DATE = new Property<Date>("lastIssueDate");
	public static final Property<Date> LAST_TRADE_DATE = new Property<Date>("lastTradeDate");
	public static final Property<Double> LONG_QTY = new Property<Double>("longQty");
	public static final Property<String> MKT_CODE = new Property<String>("mktCode");
	public static final Property<Double> MTM_PL = new Property<Double>("mtmPl");
	public static final Property<Double> NET_QTY = new Property<Double>("netQty");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<String> ORDER_TYPE_CODE = new Property<String>("orderTypeCode");
	public static final Property<Date> PL_ASOF_DATE = new Property<Date>("plAsofDate");
	public static final Property<Double> PL_MKT_PRICE = new Property<Double>("plMktPrice");
	public static final Property<String> PORT_BOOK_COMP_SHORT_NAME = new Property<String>("portBookCompShortName");
	public static final Property<String> PROFIT_CENTER = new Property<String>("profitCenter");
	public static final Property<Integer> REAL_PORT_NUM = new Property<Integer>("realPortNum");
	public static final Property<Double> SHORT_QTY = new Property<Double>("shortQty");
	public static final Property<String> TRADE_BOOK_COMP_SHORT_NAME = new Property<String>("tradeBookCompShortName");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<String> TRADING_PRD_CODE = new Property<String>("tradingPrdCode");

	public void setClearingBrkr(String clearingBrkr)
	{
		writeProperty("clearingBrkr", clearingBrkr);
	}

	public String getClearingBrkr()
	{
		return (String) readProperty("clearingBrkr");
	}

	public void setClearingBrkrVciCode(Integer clearingBrkrVciCode)
	{
		writeProperty("clearingBrkrVciCode", clearingBrkrVciCode);
	}

	public Integer getClearingBrkrVciCode()
	{
		return (Integer) readProperty("clearingBrkrVciCode");
	}

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setCpty(String cpty)
	{
		writeProperty("cpty", cpty);
	}

	public String getCpty()
	{
		return (String) readProperty("cpty");
	}

	public void setCreateMonth(String createMonth)
	{
		writeProperty("createMonth", createMonth);
	}

	public String getCreateMonth()
	{
		return (String) readProperty("createMonth");
	}

	public void setCreateYear(Integer createYear)
	{
		writeProperty("createYear", createYear);
	}

	public Integer getCreateYear()
	{
		return (Integer) readProperty("createYear");
	}

	public void setCreator(String creator)
	{
		writeProperty("creator", creator);
	}

	public String getCreator()
	{
		return (String) readProperty("creator");
	}

	public void setCurrency(String currency)
	{
		writeProperty("currency", currency);
	}

	public String getCurrency()
	{
		return (String) readProperty("currency");
	}

	public void setCurrencyPl(Double currencyPl)
	{
		writeProperty("currencyPl", currencyPl);
	}

	public Double getCurrencyPl()
	{
		return (Double) readProperty("currencyPl");
	}

	public void setFillPrice(Double fillPrice)
	{
		writeProperty("fillPrice", fillPrice);
	}

	public Double getFillPrice()
	{
		return (Double) readProperty("fillPrice");
	}

	public void setFloorBrkr(String floorBrkr)
	{
		writeProperty("floorBrkr", floorBrkr);
	}

	public String getFloorBrkr()
	{
		return (String) readProperty("floorBrkr");
	}

	public void setInhouse(String inhouse)
	{
		writeProperty("inhouse", inhouse);
	}

	public String getInhouse()
	{
		return (String) readProperty("inhouse");
	}

	public void setInhousePortNum(Integer inhousePortNum)
	{
		writeProperty("inhousePortNum", inhousePortNum);
	}

	public Integer getInhousePortNum()
	{
		return (Integer) readProperty("inhousePortNum");
	}

	public void setItemNum(Short itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) readProperty("itemNum");
	}

	public void setLastIssueDate(Date lastIssueDate)
	{
		writeProperty("lastIssueDate", lastIssueDate);
	}

	public Date getLastIssueDate()
	{
		return (Date) readProperty("lastIssueDate");
	}

	public void setLastTradeDate(Date lastTradeDate)
	{
		writeProperty("lastTradeDate", lastTradeDate);
	}

	public Date getLastTradeDate()
	{
		return (Date) readProperty("lastTradeDate");
	}

	public void setLongQty(Double longQty)
	{
		writeProperty("longQty", longQty);
	}

	public Double getLongQty()
	{
		return (Double) readProperty("longQty");
	}

	public void setMktCode(String mktCode)
	{
		writeProperty("mktCode", mktCode);
	}

	public String getMktCode()
	{
		return (String) readProperty("mktCode");
	}

	public void setMtmPl(Double mtmPl)
	{
		writeProperty("mtmPl", mtmPl);
	}

	public Double getMtmPl()
	{
		return (Double) readProperty("mtmPl");
	}

	public void setNetQty(Double netQty)
	{
		writeProperty("netQty", netQty);
	}

	public Double getNetQty()
	{
		return (Double) readProperty("netQty");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setOrderTypeCode(String orderTypeCode)
	{
		writeProperty("orderTypeCode", orderTypeCode);
	}

	public String getOrderTypeCode()
	{
		return (String) readProperty("orderTypeCode");
	}

	public void setPlAsofDate(Date plAsofDate)
	{
		writeProperty("plAsofDate", plAsofDate);
	}

	public Date getPlAsofDate()
	{
		return (Date) readProperty("plAsofDate");
	}

	public void setPlMktPrice(Double plMktPrice)
	{
		writeProperty("plMktPrice", plMktPrice);
	}

	public Double getPlMktPrice()
	{
		return (Double) readProperty("plMktPrice");
	}

	public void setPortBookCompShortName(String portBookCompShortName)
	{
		writeProperty("portBookCompShortName", portBookCompShortName);
	}

	public String getPortBookCompShortName()
	{
		return (String) readProperty("portBookCompShortName");
	}

	public void setProfitCenter(String profitCenter)
	{
		writeProperty("profitCenter", profitCenter);
	}

	public String getProfitCenter()
	{
		return (String) readProperty("profitCenter");
	}

	public void setRealPortNum(Integer realPortNum)
	{
		writeProperty("realPortNum", realPortNum);
	}

	public Integer getRealPortNum()
	{
		return (Integer) readProperty("realPortNum");
	}

	public void setShortQty(Double shortQty)
	{
		writeProperty("shortQty", shortQty);
	}

	public Double getShortQty()
	{
		return (Double) readProperty("shortQty");
	}

	public void setTradeBookCompShortName(String tradeBookCompShortName)
	{
		writeProperty("tradeBookCompShortName", tradeBookCompShortName);
	}

	public String getTradeBookCompShortName()
	{
		return (String) readProperty("tradeBookCompShortName");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

	public void setTradingPrd(String tradingPrd)
	{
		writeProperty("tradingPrd", tradingPrd);
	}

	public String getTradingPrd()
	{
		return (String) readProperty("tradingPrd");
	}

	public void setTradingPrdCode(String tradingPrdCode)
	{
		writeProperty("tradingPrdCode", tradingPrdCode);
	}

	public String getTradingPrdCode()
	{
		return (String) readProperty("tradingPrdCode");
	}

}
