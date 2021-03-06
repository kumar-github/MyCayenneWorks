package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.CostType;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItem;

/**
 * Class _FxCostDrawDownHist was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FxCostDrawDownHist extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> COST_CODE = new Property<String>("costCode");
	public static final Property<String> DRAW_DOWN_UP_IND = new Property<String>("drawDownUpInd");
	public static final Property<Integer> FROM_COST_NUM = new Property<Integer>("fromCostNum");
	public static final Property<Date> FROM_FX_PL_ASOF_DATE = new Property<Date>("fromFxPlAsofDate");
	public static final Property<Date> FX_PL_ROLL_DATE = new Property<Date>("fxPlRollDate");
	public static final Property<String> PAY_REC_IND = new Property<String>("payRecInd");
	public static final Property<Integer> TO_COST_NUM = new Property<Integer>("toCostNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<CostType> COST_TYPE = new Property<CostType>("costType");
	public static final Property<TradeItem> TRADE_ITEM = new Property<TradeItem>("tradeItem");
	public static final Property<TradeItem> TRADE_ITEM1 = new Property<TradeItem>("tradeItem1");
	public static final Property<TradeItem> TRADE_ITEM2 = new Property<TradeItem>("tradeItem2");

	public void setCostCode(String costCode)
	{
		writeProperty("costCode", costCode);
	}

	public String getCostCode()
	{
		return (String) readProperty("costCode");
	}

	public void setDrawDownUpInd(String drawDownUpInd)
	{
		writeProperty("drawDownUpInd", drawDownUpInd);
	}

	public String getDrawDownUpInd()
	{
		return (String) readProperty("drawDownUpInd");
	}

	public void setFromCostNum(Integer fromCostNum)
	{
		writeProperty("fromCostNum", fromCostNum);
	}

	public Integer getFromCostNum()
	{
		return (Integer) readProperty("fromCostNum");
	}

	public void setFromFxPlAsofDate(Date fromFxPlAsofDate)
	{
		writeProperty("fromFxPlAsofDate", fromFxPlAsofDate);
	}

	public Date getFromFxPlAsofDate()
	{
		return (Date) readProperty("fromFxPlAsofDate");
	}

	public void setFxPlRollDate(Date fxPlRollDate)
	{
		writeProperty("fxPlRollDate", fxPlRollDate);
	}

	public Date getFxPlRollDate()
	{
		return (Date) readProperty("fxPlRollDate");
	}

	public void setPayRecInd(String payRecInd)
	{
		writeProperty("payRecInd", payRecInd);
	}

	public String getPayRecInd()
	{
		return (String) readProperty("payRecInd");
	}

	public void setToCostNum(Integer toCostNum)
	{
		writeProperty("toCostNum", toCostNum);
	}

	public Integer getToCostNum()
	{
		return (Integer) readProperty("toCostNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCostType(CostType costType)
	{
		setToOneTarget("costType", costType, true);
	}

	public CostType getCostType()
	{
		return (CostType) readProperty("costType");
	}

	public void setTradeItem(TradeItem tradeItem)
	{
		setToOneTarget("tradeItem", tradeItem, true);
	}

	public TradeItem getTradeItem()
	{
		return (TradeItem) readProperty("tradeItem");
	}

	public void setTradeItem1(TradeItem tradeItem1)
	{
		setToOneTarget("tradeItem1", tradeItem1, true);
	}

	public TradeItem getTradeItem1()
	{
		return (TradeItem) readProperty("tradeItem1");
	}

	public void setTradeItem2(TradeItem tradeItem2)
	{
		setToOneTarget("tradeItem2", tradeItem2, true);
	}

	public TradeItem getTradeItem2()
	{
		return (TradeItem) readProperty("tradeItem2");
	}

}
