package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VMdsInternalTradePhys was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VMdsInternalTradePhys extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Short> ALLOC_ITEM_NUM = new Property<Short>("allocItemNum");
	public static final Property<Integer> ALLOC_NUM = new Property<Integer>("allocNum");
	public static final Property<Date> CONTR_DATE = new Property<Date>("contrDate");
	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Short> OPP_ALLOC_ITEM_NUM = new Property<Short>("oppAllocItemNum");
	public static final Property<Integer> OPP_ALLOC_NUM = new Property<Integer>("oppAllocNum");
	public static final Property<Short> OPP_ITEM_NUM = new Property<Short>("oppItemNum");
	public static final Property<Short> OPP_ORDER_NUM = new Property<Short>("oppOrderNum");
	public static final Property<Integer> OPP_PORT_NUM = new Property<Integer>("oppPortNum");
	public static final Property<Integer> OPP_TRADE_NUM = new Property<Integer>("oppTradeNum");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<String> P_SIND = new Property<String>("pSInd");
	public static final Property<Integer> PORT_NUM = new Property<Integer>("portNum");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");

	public void setAllocItemNum(Short allocItemNum)
	{
		writeProperty("allocItemNum", allocItemNum);
	}

	public Short getAllocItemNum()
	{
		return (Short) readProperty("allocItemNum");
	}

	public void setAllocNum(Integer allocNum)
	{
		writeProperty("allocNum", allocNum);
	}

	public Integer getAllocNum()
	{
		return (Integer) readProperty("allocNum");
	}

	public void setContrDate(Date contrDate)
	{
		writeProperty("contrDate", contrDate);
	}

	public Date getContrDate()
	{
		return (Date) readProperty("contrDate");
	}

	public void setItemNum(Short itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) readProperty("itemNum");
	}

	public void setOppAllocItemNum(Short oppAllocItemNum)
	{
		writeProperty("oppAllocItemNum", oppAllocItemNum);
	}

	public Short getOppAllocItemNum()
	{
		return (Short) readProperty("oppAllocItemNum");
	}

	public void setOppAllocNum(Integer oppAllocNum)
	{
		writeProperty("oppAllocNum", oppAllocNum);
	}

	public Integer getOppAllocNum()
	{
		return (Integer) readProperty("oppAllocNum");
	}

	public void setOppItemNum(Short oppItemNum)
	{
		writeProperty("oppItemNum", oppItemNum);
	}

	public Short getOppItemNum()
	{
		return (Short) readProperty("oppItemNum");
	}

	public void setOppOrderNum(Short oppOrderNum)
	{
		writeProperty("oppOrderNum", oppOrderNum);
	}

	public Short getOppOrderNum()
	{
		return (Short) readProperty("oppOrderNum");
	}

	public void setOppPortNum(Integer oppPortNum)
	{
		writeProperty("oppPortNum", oppPortNum);
	}

	public Integer getOppPortNum()
	{
		return (Integer) readProperty("oppPortNum");
	}

	public void setOppTradeNum(Integer oppTradeNum)
	{
		writeProperty("oppTradeNum", oppTradeNum);
	}

	public Integer getOppTradeNum()
	{
		return (Integer) readProperty("oppTradeNum");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setPSInd(String pSInd)
	{
		writeProperty("pSInd", pSInd);
	}

	public String getPSInd()
	{
		return (String) readProperty("pSInd");
	}

	public void setPortNum(Integer portNum)
	{
		writeProperty("portNum", portNum);
	}

	public Integer getPortNum()
	{
		return (Integer) readProperty("portNum");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

}
