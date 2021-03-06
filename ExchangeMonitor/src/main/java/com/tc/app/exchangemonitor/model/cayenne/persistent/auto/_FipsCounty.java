package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.FipsCity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FipsState;

/**
 * Class _FipsCounty was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FipsCounty extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Boolean> ACTIVE_IND = new Property<Boolean>("activeInd");
	public static final Property<String> COUNTY_NAME = new Property<String>("countyName");
	public static final Property<String> FIPS_COUNTY_CODE = new Property<String>("fipsCountyCode");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<FipsCity>> FIPS_CITIES = new Property<List<FipsCity>>("fipsCities");
	public static final Property<FipsState> FIPS_STATE = new Property<FipsState>("fipsState");

	public void setActiveInd(Boolean activeInd)
	{
		writeProperty("activeInd", activeInd);
	}

	public Boolean getActiveInd()
	{
		return (Boolean) readProperty("activeInd");
	}

	public void setCountyName(String countyName)
	{
		writeProperty("countyName", countyName);
	}

	public String getCountyName()
	{
		return (String) readProperty("countyName");
	}

	public void setFipsCountyCode(String fipsCountyCode)
	{
		writeProperty("fipsCountyCode", fipsCountyCode);
	}

	public String getFipsCountyCode()
	{
		return (String) readProperty("fipsCountyCode");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToFipsCities(FipsCity obj)
	{
		addToManyTarget("fipsCities", obj, true);
	}

	public void removeFromFipsCities(FipsCity obj)
	{
		removeToManyTarget("fipsCities", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FipsCity> getFipsCities()
	{
		return (List<FipsCity>) readProperty("fipsCities");
	}

	public void setFipsState(FipsState fipsState)
	{
		setToOneTarget("fipsState", fipsState, true);
	}

	public FipsState getFipsState()
	{
		return (FipsState) readProperty("fipsState");
	}

}
