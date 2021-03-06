package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AppUser;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ContrBookingCoOverride;

/**
 * Class _ContrBookingCo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ContrBookingCo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Boolean> AGENCY_LANG_REQ = new Property<Boolean>("agencyLangReq");
	public static final Property<String> CONTR_BOOKING_CO_NM = new Property<String>("contrBookingCoNm");
	public static final Property<Integer> GOVERNING_LAW_ID = new Property<Integer>("governingLawId");
	public static final Property<Date> INACTV_DT = new Property<Date>("inactvDt");
	public static final Property<Date> MOD_TS = new Property<Date>("modTs");
	public static final Property<String> MOD_USER_CD = new Property<String>("modUserCd");
	public static final Property<List<AppUser>> APP_USERS = new Property<List<AppUser>>("appUsers");
	public static final Property<List<ContrBookingCoOverride>> CONTR_BOOKING_CO_OVERRIDES = new Property<List<ContrBookingCoOverride>>("contrBookingCoOverrides");
	public static final Property<List<ContrBookingCoOverride>> CONTR_BOOKING_CO_OVERRIDES1 = new Property<List<ContrBookingCoOverride>>("contrBookingCoOverrides1");

	public void setAgencyLangReq(Boolean agencyLangReq)
	{
		writeProperty("agencyLangReq", agencyLangReq);
	}

	public Boolean getAgencyLangReq()
	{
		return (Boolean) readProperty("agencyLangReq");
	}

	public void setContrBookingCoNm(String contrBookingCoNm)
	{
		writeProperty("contrBookingCoNm", contrBookingCoNm);
	}

	public String getContrBookingCoNm()
	{
		return (String) readProperty("contrBookingCoNm");
	}

	public void setGoverningLawId(Integer governingLawId)
	{
		writeProperty("governingLawId", governingLawId);
	}

	public Integer getGoverningLawId()
	{
		return (Integer) readProperty("governingLawId");
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

	public void addToAppUsers(AppUser obj)
	{
		addToManyTarget("appUsers", obj, true);
	}

	public void removeFromAppUsers(AppUser obj)
	{
		removeToManyTarget("appUsers", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AppUser> getAppUsers()
	{
		return (List<AppUser>) readProperty("appUsers");
	}

	public void addToContrBookingCoOverrides(ContrBookingCoOverride obj)
	{
		addToManyTarget("contrBookingCoOverrides", obj, true);
	}

	public void removeFromContrBookingCoOverrides(ContrBookingCoOverride obj)
	{
		removeToManyTarget("contrBookingCoOverrides", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<ContrBookingCoOverride> getContrBookingCoOverrides()
	{
		return (List<ContrBookingCoOverride>) readProperty("contrBookingCoOverrides");
	}

	public void addToContrBookingCoOverrides1(ContrBookingCoOverride obj)
	{
		addToManyTarget("contrBookingCoOverrides1", obj, true);
	}

	public void removeFromContrBookingCoOverrides1(ContrBookingCoOverride obj)
	{
		removeToManyTarget("contrBookingCoOverrides1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<ContrBookingCoOverride> getContrBookingCoOverrides1()
	{
		return (List<ContrBookingCoOverride>) readProperty("contrBookingCoOverrides1");
	}

}
