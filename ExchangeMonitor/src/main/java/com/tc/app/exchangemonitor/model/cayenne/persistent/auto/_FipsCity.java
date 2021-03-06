package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.FipsCounty;

/**
 * Class _FipsCity was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FipsCity extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Boolean> ACTIVE_IND = new Property<Boolean>("activeInd");
	public static final Property<String> COMPONENT_NAME = new Property<String>("componentName");
	public static final Property<String> CSA_TITLE = new Property<String>("csaTitle");
	public static final Property<String> FIPS_CITY_CODE = new Property<String>("fipsCityCode");
	public static final Property<String> METRO_DIV_TITLE = new Property<String>("metroDivTitle");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<FipsCounty> FIPS_COUNTY = new Property<FipsCounty>("fipsCounty");

	public void setActiveInd(Boolean activeInd)
	{
		writeProperty("activeInd", activeInd);
	}

	public Boolean getActiveInd()
	{
		return (Boolean) readProperty("activeInd");
	}

	public void setComponentName(String componentName)
	{
		writeProperty("componentName", componentName);
	}

	public String getComponentName()
	{
		return (String) readProperty("componentName");
	}

	public void setCsaTitle(String csaTitle)
	{
		writeProperty("csaTitle", csaTitle);
	}

	public String getCsaTitle()
	{
		return (String) readProperty("csaTitle");
	}

	public void setFipsCityCode(String fipsCityCode)
	{
		writeProperty("fipsCityCode", fipsCityCode);
	}

	public String getFipsCityCode()
	{
		return (String) readProperty("fipsCityCode");
	}

	public void setMetroDivTitle(String metroDivTitle)
	{
		writeProperty("metroDivTitle", metroDivTitle);
	}

	public String getMetroDivTitle()
	{
		return (String) readProperty("metroDivTitle");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setFipsCounty(FipsCounty fipsCounty)
	{
		setToOneTarget("fipsCounty", fipsCounty, true);
	}

	public FipsCounty getFipsCounty()
	{
		return (FipsCounty) readProperty("fipsCounty");
	}

}
