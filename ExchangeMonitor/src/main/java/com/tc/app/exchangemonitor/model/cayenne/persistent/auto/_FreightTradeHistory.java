package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _FreightTradeHistory was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FreightTradeHistory extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CARGO_KEY_PK_COLUMN = "cargo_key";
	public static final String MTM_ASOF_DATE_PK_COLUMN = "mtm_asof_date";

	public static final Property<Double> ADD_COMMISSION = new Property<Double>("addCommission");
	public static final Property<Double> BROKER_COMMISSION = new Property<Double>("brokerCommission");
	public static final Property<Date> CHARTERPARTY_DATE = new Property<Date>("charterpartyDate");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Date> LAYCAN_FROM = new Property<Date>("laycanFrom");
	public static final Property<Date> LAYCAN_TO = new Property<Date>("laycanTo");
	public static final Property<Integer> PORT_NUM = new Property<Integer>("portNum");
	public static final Property<String> RATE_TYPE = new Property<String>("rateType");
	public static final Property<Date> RISK_PERIOD_DATE = new Property<Date>("riskPeriodDate");
	public static final Property<Double> TRADE_PRICE = new Property<Double>("tradePrice");
	public static final Property<Double> TRADE_QUANTITY = new Property<Double>("tradeQuantity");
	public static final Property<String> TRADE_TYPE = new Property<String>("tradeType");
	public static final Property<String> UOM = new Property<String>("uom");

	public void setAddCommission(Double addCommission)
	{
		writeProperty("addCommission", addCommission);
	}

	public Double getAddCommission()
	{
		return (Double) readProperty("addCommission");
	}

	public void setBrokerCommission(Double brokerCommission)
	{
		writeProperty("brokerCommission", brokerCommission);
	}

	public Double getBrokerCommission()
	{
		return (Double) readProperty("brokerCommission");
	}

	public void setCharterpartyDate(Date charterpartyDate)
	{
		writeProperty("charterpartyDate", charterpartyDate);
	}

	public Date getCharterpartyDate()
	{
		return (Date) readProperty("charterpartyDate");
	}

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setLaycanFrom(Date laycanFrom)
	{
		writeProperty("laycanFrom", laycanFrom);
	}

	public Date getLaycanFrom()
	{
		return (Date) readProperty("laycanFrom");
	}

	public void setLaycanTo(Date laycanTo)
	{
		writeProperty("laycanTo", laycanTo);
	}

	public Date getLaycanTo()
	{
		return (Date) readProperty("laycanTo");
	}

	public void setPortNum(Integer portNum)
	{
		writeProperty("portNum", portNum);
	}

	public Integer getPortNum()
	{
		return (Integer) readProperty("portNum");
	}

	public void setRateType(String rateType)
	{
		writeProperty("rateType", rateType);
	}

	public String getRateType()
	{
		return (String) readProperty("rateType");
	}

	public void setRiskPeriodDate(Date riskPeriodDate)
	{
		writeProperty("riskPeriodDate", riskPeriodDate);
	}

	public Date getRiskPeriodDate()
	{
		return (Date) readProperty("riskPeriodDate");
	}

	public void setTradePrice(Double tradePrice)
	{
		writeProperty("tradePrice", tradePrice);
	}

	public Double getTradePrice()
	{
		return (Double) readProperty("tradePrice");
	}

	public void setTradeQuantity(Double tradeQuantity)
	{
		writeProperty("tradeQuantity", tradeQuantity);
	}

	public Double getTradeQuantity()
	{
		return (Double) readProperty("tradeQuantity");
	}

	public void setTradeType(String tradeType)
	{
		writeProperty("tradeType", tradeType);
	}

	public String getTradeType()
	{
		return (String) readProperty("tradeType");
	}

	public void setUom(String uom)
	{
		writeProperty("uom", uom);
	}

	public String getUom()
	{
		return (String) readProperty("uom");
	}

}
