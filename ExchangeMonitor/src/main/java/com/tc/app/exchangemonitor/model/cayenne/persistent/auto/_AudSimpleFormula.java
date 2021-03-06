package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudSimpleFormula was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudSimpleFormula extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> QUOTE_COMMKT_KEY = new Property<Integer>("quoteCommktKey");
	public static final Property<Double> QUOTE_DIFF = new Property<Double>("quoteDiff");
	public static final Property<String> QUOTE_DIFF_CURR_CODE = new Property<String>("quoteDiffCurrCode");
	public static final Property<String> QUOTE_DIFF_UOM_CODE = new Property<String>("quoteDiffUomCode");
	public static final Property<String> QUOTE_PRICE_SOURCE_CODE = new Property<String>("quotePriceSourceCode");
	public static final Property<String> QUOTE_PRICE_TYPE = new Property<String>("quotePriceType");
	public static final Property<String> QUOTE_TRADING_PRD = new Property<String>("quoteTradingPrd");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> SIMPLE_FORMULA_NUM = new Property<Integer>("simpleFormulaNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setQuoteCommktKey(Integer quoteCommktKey)
	{
		writeProperty("quoteCommktKey", quoteCommktKey);
	}

	public Integer getQuoteCommktKey()
	{
		return (Integer) readProperty("quoteCommktKey");
	}

	public void setQuoteDiff(Double quoteDiff)
	{
		writeProperty("quoteDiff", quoteDiff);
	}

	public Double getQuoteDiff()
	{
		return (Double) readProperty("quoteDiff");
	}

	public void setQuoteDiffCurrCode(String quoteDiffCurrCode)
	{
		writeProperty("quoteDiffCurrCode", quoteDiffCurrCode);
	}

	public String getQuoteDiffCurrCode()
	{
		return (String) readProperty("quoteDiffCurrCode");
	}

	public void setQuoteDiffUomCode(String quoteDiffUomCode)
	{
		writeProperty("quoteDiffUomCode", quoteDiffUomCode);
	}

	public String getQuoteDiffUomCode()
	{
		return (String) readProperty("quoteDiffUomCode");
	}

	public void setQuotePriceSourceCode(String quotePriceSourceCode)
	{
		writeProperty("quotePriceSourceCode", quotePriceSourceCode);
	}

	public String getQuotePriceSourceCode()
	{
		return (String) readProperty("quotePriceSourceCode");
	}

	public void setQuotePriceType(String quotePriceType)
	{
		writeProperty("quotePriceType", quotePriceType);
	}

	public String getQuotePriceType()
	{
		return (String) readProperty("quotePriceType");
	}

	public void setQuoteTradingPrd(String quoteTradingPrd)
	{
		writeProperty("quoteTradingPrd", quoteTradingPrd);
	}

	public String getQuoteTradingPrd()
	{
		return (String) readProperty("quoteTradingPrd");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setSimpleFormulaNum(Integer simpleFormulaNum)
	{
		writeProperty("simpleFormulaNum", simpleFormulaNum);
	}

	public Integer getSimpleFormulaNum()
	{
		return (Integer) readProperty("simpleFormulaNum");
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
