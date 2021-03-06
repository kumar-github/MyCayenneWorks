package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ContrBookingCo;

/**
 * Class _ContrBookingCoOverride was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ContrBookingCoOverride extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> CONTR_BOOKING_CO_OVERRIDE_ID = new Property<Integer>("contrBookingCoOverrideId");
	public static final Property<Date> INACTV_DT = new Property<Date>("inactvDt");
	public static final Property<Date> MOD_TS = new Property<Date>("modTs");
	public static final Property<String> MOD_USER_CD = new Property<String>("modUserCd");
	public static final Property<Integer> PROD_CLASS_ID = new Property<Integer>("prodClassId");
	public static final Property<ContrBookingCo> CONTR_BOOKING_CO = new Property<ContrBookingCo>("contrBookingCo");
	public static final Property<ContrBookingCo> OVERRIDE_BOOKING_CO = new Property<ContrBookingCo>("overrideBookingCo");

	public void setContrBookingCoOverrideId(Integer contrBookingCoOverrideId)
	{
		writeProperty("contrBookingCoOverrideId", contrBookingCoOverrideId);
	}

	public Integer getContrBookingCoOverrideId()
	{
		return (Integer) readProperty("contrBookingCoOverrideId");
	}

	public void setInactvDt(Date inactvDt)
	{
		writeProperty("inactvDt", inactvDt);
	}

	public Date getInactvDt()
	{
		return (Date) readProperty("inactvDt");
	}

	public void setModTs(Date modTs)
	{
		writeProperty("modTs", modTs);
	}

	public Date getModTs()
	{
		return (Date) readProperty("modTs");
	}

	public void setModUserCd(String modUserCd)
	{
		writeProperty("modUserCd", modUserCd);
	}

	public String getModUserCd()
	{
		return (String) readProperty("modUserCd");
	}

	public void setProdClassId(Integer prodClassId)
	{
		writeProperty("prodClassId", prodClassId);
	}

	public Integer getProdClassId()
	{
		return (Integer) readProperty("prodClassId");
	}

	public void setContrBookingCo(ContrBookingCo contrBookingCo)
	{
		setToOneTarget("contrBookingCo", contrBookingCo, true);
	}

	public ContrBookingCo getContrBookingCo()
	{
		return (ContrBookingCo) readProperty("contrBookingCo");
	}

	public void setOverrideBookingCo(ContrBookingCo overrideBookingCo)
	{
		setToOneTarget("overrideBookingCo", overrideBookingCo, true);
	}

	public ContrBookingCo getOverrideBookingCo()
	{
		return (ContrBookingCo) readProperty("overrideBookingCo");
	}

}
