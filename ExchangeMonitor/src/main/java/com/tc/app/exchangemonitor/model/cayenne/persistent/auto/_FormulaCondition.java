package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.PriceSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradingPeriod;

/**
 * Class _FormulaCondition was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FormulaCondition extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FORMULA_COND_NUM_PK_COLUMN = "formula_cond_num";
	public static final String FORMULA_NUM_PK_COLUMN = "formula_num";

	public static final Property<String> BASIS_VAL_TYPE = new Property<String>("basisValType");
	public static final Property<Date> FORMULA_COND_DATE = new Property<Date>("formulaCondDate");
	public static final Property<String> FORMULA_COND_LAST_NEXT_IND = new Property<String>("formulaCondLastNextInd");
	public static final Property<Short> FORMULA_COND_QUOTE_RANGE = new Property<Short>("formulaCondQuoteRange");
	public static final Property<String> FORMULA_COND_TYPE = new Property<String>("formulaCondType");
	public static final Property<String> SRC_VAL_TYPE = new Property<String>("srcValType");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<PriceSource> PRICE_SOURCE = new Property<PriceSource>("priceSource");
	public static final Property<PriceSource> PRICE_SOURCE1 = new Property<PriceSource>("priceSource1");
	public static final Property<TradingPeriod> TRADING_PERIOD = new Property<TradingPeriod>("tradingPeriod");
	public static final Property<TradingPeriod> TRADING_PERIOD1 = new Property<TradingPeriod>("tradingPeriod1");
	public static final Property<TradingPeriod> TRADING_PERIOD2 = new Property<TradingPeriod>("tradingPeriod2");
	public static final Property<TradingPeriod> TRADING_PERIOD3 = new Property<TradingPeriod>("tradingPeriod3");

	public void setBasisValType(String basisValType)
	{
		writeProperty("basisValType", basisValType);
	}

	public String getBasisValType()
	{
		return (String) readProperty("basisValType");
	}

	public void setFormulaCondDate(Date formulaCondDate)
	{
		writeProperty("formulaCondDate", formulaCondDate);
	}

	public Date getFormulaCondDate()
	{
		return (Date) readProperty("formulaCondDate");
	}

	public void setFormulaCondLastNextInd(String formulaCondLastNextInd)
	{
		writeProperty("formulaCondLastNextInd", formulaCondLastNextInd);
	}

	public String getFormulaCondLastNextInd()
	{
		return (String) readProperty("formulaCondLastNextInd");
	}

	public void setFormulaCondQuoteRange(Short formulaCondQuoteRange)
	{
		writeProperty("formulaCondQuoteRange", formulaCondQuoteRange);
	}

	public Short getFormulaCondQuoteRange()
	{
		return (Short) readProperty("formulaCondQuoteRange");
	}

	public void setFormulaCondType(String formulaCondType)
	{
		writeProperty("formulaCondType", formulaCondType);
	}

	public String getFormulaCondType()
	{
		return (String) readProperty("formulaCondType");
	}

	public void setSrcValType(String srcValType)
	{
		writeProperty("srcValType", srcValType);
	}

	public String getSrcValType()
	{
		return (String) readProperty("srcValType");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setPriceSource(PriceSource priceSource)
	{
		setToOneTarget("priceSource", priceSource, true);
	}

	public PriceSource getPriceSource()
	{
		return (PriceSource) readProperty("priceSource");
	}

	public void setPriceSource1(PriceSource priceSource1)
	{
		setToOneTarget("priceSource1", priceSource1, true);
	}

	public PriceSource getPriceSource1()
	{
		return (PriceSource) readProperty("priceSource1");
	}

	public void setTradingPeriod(TradingPeriod tradingPeriod)
	{
		setToOneTarget("tradingPeriod", tradingPeriod, true);
	}

	public TradingPeriod getTradingPeriod()
	{
		return (TradingPeriod) readProperty("tradingPeriod");
	}

	public void setTradingPeriod1(TradingPeriod tradingPeriod1)
	{
		setToOneTarget("tradingPeriod1", tradingPeriod1, true);
	}

	public TradingPeriod getTradingPeriod1()
	{
		return (TradingPeriod) readProperty("tradingPeriod1");
	}

	public void setTradingPeriod2(TradingPeriod tradingPeriod2)
	{
		setToOneTarget("tradingPeriod2", tradingPeriod2, true);
	}

	public TradingPeriod getTradingPeriod2()
	{
		return (TradingPeriod) readProperty("tradingPeriod2");
	}

	public void setTradingPeriod3(TradingPeriod tradingPeriod3)
	{
		setToOneTarget("tradingPeriod3", tradingPeriod3, true);
	}

	public TradingPeriod getTradingPeriod3()
	{
		return (TradingPeriod) readProperty("tradingPeriod3");
	}

}
