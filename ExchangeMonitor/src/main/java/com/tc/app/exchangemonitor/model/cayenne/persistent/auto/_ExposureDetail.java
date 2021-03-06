package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.LcType;

/**
 * Class _ExposureDetail was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ExposureDetail extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String COST_NUM_PK_COLUMN = "cost_num";
	public static final String EXPOSURE_NUM_PK_COLUMN = "exposure_num";

	public static final Property<Double> CASH_EXP_AMT = new Property<>("cashExpAmt");
	public static final Property<Date> CASH_FROM_DATE = new Property<>("cashFromDate");
	public static final Property<Date> CASH_TO_DATE = new Property<>("cashToDate");
	public static final Property<BigDecimal> COST_AMT = new Property<>("costAmt");
	public static final Property<String> COST_PRICE_CURR_CODE = new Property<>("costPriceCurrCode");
	public static final Property<Integer> CREDIT_EXPOSURE_OID = new Property<>("creditExposureOid");
	public static final Property<Date> MTM_END_DATE = new Property<>("mtmEndDate");
	public static final Property<Date> MTM_FROM_DATE = new Property<>("mtmFromDate");
	public static final Property<Double> MTM_PL = new Property<>("mtmPl");
	public static final Property<Integer> SHIFT_EXPOSURE_NUM = new Property<>("shiftExposureNum");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<LcType> LC_TYPE = new Property<>("lcType");

	public void setCashExpAmt(final Double cashExpAmt)
	{
		this.writeProperty("cashExpAmt", cashExpAmt);
	}

	public Double getCashExpAmt()
	{
		return (Double) this.readProperty("cashExpAmt");
	}

	public void setCashFromDate(final Date cashFromDate)
	{
		this.writeProperty("cashFromDate", cashFromDate);
	}

	public Date getCashFromDate()
	{
		return (Date) this.readProperty("cashFromDate");
	}

	public void setCashToDate(final Date cashToDate)
	{
		this.writeProperty("cashToDate", cashToDate);
	}

	public Date getCashToDate()
	{
		return (Date) this.readProperty("cashToDate");
	}

	public void setCostAmt(final BigDecimal costAmt)
	{
		this.writeProperty("costAmt", costAmt);
	}

	public BigDecimal getCostAmt()
	{
		return (BigDecimal) this.readProperty("costAmt");
	}

	public void setCostPriceCurrCode(final String costPriceCurrCode)
	{
		this.writeProperty("costPriceCurrCode", costPriceCurrCode);
	}

	public String getCostPriceCurrCode()
	{
		return (String) this.readProperty("costPriceCurrCode");
	}

	public void setCreditExposureOid(final Integer creditExposureOid)
	{
		this.writeProperty("creditExposureOid", creditExposureOid);
	}

	public Integer getCreditExposureOid()
	{
		return (Integer) this.readProperty("creditExposureOid");
	}

	public void setMtmEndDate(final Date mtmEndDate)
	{
		this.writeProperty("mtmEndDate", mtmEndDate);
	}

	public Date getMtmEndDate()
	{
		return (Date) this.readProperty("mtmEndDate");
	}

	public void setMtmFromDate(final Date mtmFromDate)
	{
		this.writeProperty("mtmFromDate", mtmFromDate);
	}

	public Date getMtmFromDate()
	{
		return (Date) this.readProperty("mtmFromDate");
	}

	public void setMtmPl(final Double mtmPl)
	{
		this.writeProperty("mtmPl", mtmPl);
	}

	public Double getMtmPl()
	{
		return (Double) this.readProperty("mtmPl");
	}

	public void setShiftExposureNum(final Integer shiftExposureNum)
	{
		this.writeProperty("shiftExposureNum", shiftExposureNum);
	}

	public Integer getShiftExposureNum()
	{
		return (Integer) this.readProperty("shiftExposureNum");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setLcType(final LcType lcType)
	{
		this.setToOneTarget("lcType", lcType, true);
	}

	public LcType getLcType()
	{
		return (LcType) this.readProperty("lcType");
	}

}
