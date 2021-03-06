package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudTradeOrderOnExch was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudTradeOrderOnExch extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> ORDER_DATE = new Property<Date>("orderDate");
	public static final Property<String> ORDER_GOOD_TO_CANCEL_IND = new Property<String>("orderGoodToCancelInd");
	public static final Property<String> ORDER_INSTR_CODE = new Property<String>("orderInstrCode");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<Double> ORDER_POINTS = new Property<Double>("orderPoints");
	public static final Property<Double> ORDER_PRICE = new Property<Double>("orderPrice");
	public static final Property<String> ORDER_PRICE_CURR_CODE = new Property<String>("orderPriceCurrCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setOrderDate(Date orderDate)
	{
		writeProperty("orderDate", orderDate);
	}

	public Date getOrderDate()
	{
		return (Date) readProperty("orderDate");
	}

	public void setOrderGoodToCancelInd(String orderGoodToCancelInd)
	{
		writeProperty("orderGoodToCancelInd", orderGoodToCancelInd);
	}

	public String getOrderGoodToCancelInd()
	{
		return (String) readProperty("orderGoodToCancelInd");
	}

	public void setOrderInstrCode(String orderInstrCode)
	{
		writeProperty("orderInstrCode", orderInstrCode);
	}

	public String getOrderInstrCode()
	{
		return (String) readProperty("orderInstrCode");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setOrderPoints(Double orderPoints)
	{
		writeProperty("orderPoints", orderPoints);
	}

	public Double getOrderPoints()
	{
		return (Double) readProperty("orderPoints");
	}

	public void setOrderPrice(Double orderPrice)
	{
		writeProperty("orderPrice", orderPrice);
	}

	public Double getOrderPrice()
	{
		return (Double) readProperty("orderPrice");
	}

	public void setOrderPriceCurrCode(String orderPriceCurrCode)
	{
		writeProperty("orderPriceCurrCode", orderPriceCurrCode);
	}

	public String getOrderPriceCurrCode()
	{
		return (String) readProperty("orderPriceCurrCode");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
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
