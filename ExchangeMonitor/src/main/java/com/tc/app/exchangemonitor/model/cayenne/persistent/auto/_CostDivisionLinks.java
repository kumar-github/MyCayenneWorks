package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CostDivisionLinks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostDivisionLinks extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDINT_COST_NUM_PK_COLUMN = "fldintCostNum";

	public static final Property<String> FLDCHR_CONTR_KEY = new Property<String>("fldchrContrKey");
	public static final Property<String> FLDCHR_REF_MONTH = new Property<String>("fldchrRefMonth");
	public static final Property<String> FLDCHR_REF_YEAR = new Property<String>("fldchrRefYear");
	public static final Property<BigDecimal> FLDDEC_DAILY_FEE = new Property<BigDecimal>("flddecDailyFee");
	public static final Property<Integer> FLDINT_DIVISION_PERIOD = new Property<Integer>("fldintDivisionPeriod");
	public static final Property<Integer> FLDINT_IS_DIVIDED = new Property<Integer>("fldintIsDivided");
	public static final Property<Integer> FLDINT_REF_MONTH_DAYS = new Property<Integer>("fldintRefMonthDays");
	public static final Property<Integer> FLDINT_VOYG_DIVISION_TYPE = new Property<Integer>("fldintVoygDivisionType");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFldchrContrKey(String fldchrContrKey)
	{
		writeProperty("fldchrContrKey", fldchrContrKey);
	}

	public String getFldchrContrKey()
	{
		return (String) readProperty("fldchrContrKey");
	}

	public void setFldchrRefMonth(String fldchrRefMonth)
	{
		writeProperty("fldchrRefMonth", fldchrRefMonth);
	}

	public String getFldchrRefMonth()
	{
		return (String) readProperty("fldchrRefMonth");
	}

	public void setFldchrRefYear(String fldchrRefYear)
	{
		writeProperty("fldchrRefYear", fldchrRefYear);
	}

	public String getFldchrRefYear()
	{
		return (String) readProperty("fldchrRefYear");
	}

	public void setFlddecDailyFee(BigDecimal flddecDailyFee)
	{
		writeProperty("flddecDailyFee", flddecDailyFee);
	}

	public BigDecimal getFlddecDailyFee()
	{
		return (BigDecimal) readProperty("flddecDailyFee");
	}

	public void setFldintDivisionPeriod(Integer fldintDivisionPeriod)
	{
		writeProperty("fldintDivisionPeriod", fldintDivisionPeriod);
	}

	public Integer getFldintDivisionPeriod()
	{
		return (Integer) readProperty("fldintDivisionPeriod");
	}

	public void setFldintIsDivided(Integer fldintIsDivided)
	{
		writeProperty("fldintIsDivided", fldintIsDivided);
	}

	public Integer getFldintIsDivided()
	{
		return (Integer) readProperty("fldintIsDivided");
	}

	public void setFldintRefMonthDays(Integer fldintRefMonthDays)
	{
		writeProperty("fldintRefMonthDays", fldintRefMonthDays);
	}

	public Integer getFldintRefMonthDays()
	{
		return (Integer) readProperty("fldintRefMonthDays");
	}

	public void setFldintVoygDivisionType(Integer fldintVoygDivisionType)
	{
		writeProperty("fldintVoygDivisionType", fldintVoygDivisionType);
	}

	public Integer getFldintVoygDivisionType()
	{
		return (Integer) readProperty("fldintVoygDivisionType");
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
