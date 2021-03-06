package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCommodityMarketFormula was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCommodityMarketFormula extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> AVG_CLOSED_FORMULA_NUM = new Property<Integer>("avgClosedFormulaNum");
	public static final Property<Integer> AVG_CLOSED_SIMPLE_FORMULA_NUM = new Property<Integer>("avgClosedSimpleFormulaNum");
	public static final Property<Integer> CMF_NUM = new Property<Integer>("cmfNum");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Integer> HIGH_ASKED_FORMULA_NUM = new Property<Integer>("highAskedFormulaNum");
	public static final Property<Integer> HIGH_ASKED_SIMPLE_FORMULA_NUM = new Property<Integer>("highAskedSimpleFormulaNum");
	public static final Property<Integer> LOW_BID_FORMULA_NUM = new Property<Integer>("lowBidFormulaNum");
	public static final Property<Integer> LOW_BID_SIMPLE_FORMULA_NUM = new Property<Integer>("lowBidSimpleFormulaNum");
	public static final Property<Integer> MPT_NUM = new Property<Integer>("mptNum");
	public static final Property<String> PRICE_SOURCE_CODE = new Property<String>("priceSourceCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAvgClosedFormulaNum(Integer avgClosedFormulaNum)
	{
		writeProperty("avgClosedFormulaNum", avgClosedFormulaNum);
	}

	public Integer getAvgClosedFormulaNum()
	{
		return (Integer) readProperty("avgClosedFormulaNum");
	}

	public void setAvgClosedSimpleFormulaNum(Integer avgClosedSimpleFormulaNum)
	{
		writeProperty("avgClosedSimpleFormulaNum", avgClosedSimpleFormulaNum);
	}

	public Integer getAvgClosedSimpleFormulaNum()
	{
		return (Integer) readProperty("avgClosedSimpleFormulaNum");
	}

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

	public void setHighAskedFormulaNum(Integer highAskedFormulaNum)
	{
		writeProperty("highAskedFormulaNum", highAskedFormulaNum);
	}

	public Integer getHighAskedFormulaNum()
	{
		return (Integer) readProperty("highAskedFormulaNum");
	}

	public void setHighAskedSimpleFormulaNum(Integer highAskedSimpleFormulaNum)
	{
		writeProperty("highAskedSimpleFormulaNum", highAskedSimpleFormulaNum);
	}

	public Integer getHighAskedSimpleFormulaNum()
	{
		return (Integer) readProperty("highAskedSimpleFormulaNum");
	}

	public void setLowBidFormulaNum(Integer lowBidFormulaNum)
	{
		writeProperty("lowBidFormulaNum", lowBidFormulaNum);
	}

	public Integer getLowBidFormulaNum()
	{
		return (Integer) readProperty("lowBidFormulaNum");
	}

	public void setLowBidSimpleFormulaNum(Integer lowBidSimpleFormulaNum)
	{
		writeProperty("lowBidSimpleFormulaNum", lowBidSimpleFormulaNum);
	}

	public Integer getLowBidSimpleFormulaNum()
	{
		return (Integer) readProperty("lowBidSimpleFormulaNum");
	}

	public void setMptNum(Integer mptNum)
	{
		writeProperty("mptNum", mptNum);
	}

	public Integer getMptNum()
	{
		return (Integer) readProperty("mptNum");
	}

	public void setPriceSourceCode(String priceSourceCode)
	{
		writeProperty("priceSourceCode", priceSourceCode);
	}

	public String getPriceSourceCode()
	{
		return (String) readProperty("priceSourceCode");
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

}
