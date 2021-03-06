package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieUNLOCODEDest was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieUNLOCODEDest extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_DEST_AIRPORT_FLAG = new Property<String>("fldchrDestAirportFlag");
	public static final Property<String> FLDCHR_DEST_COUNTRY_CODE = new Property<String>("fldchrDestCountryCode");
	public static final Property<String> FLDCHR_DEST_FIXED_FUNCTIONS_FLAG = new Property<String>("fldchrDestFixedFunctionsFlag");
	public static final Property<String> FLDCHR_DEST_GEO_AREA_CODE = new Property<String>("fldchrDestGeoAreaCode");
	public static final Property<String> FLDCHR_DEST_LOCT_CODE = new Property<String>("fldchrDestLoctCode");
	public static final Property<String> FLDCHR_DEST_LOCT_KEY = new Property<String>("fldchrDestLoctKey");
	public static final Property<String> FLDCHR_DEST_PORT_FLAG = new Property<String>("fldchrDestPortFlag");
	public static final Property<String> FLDCHR_DEST_RAIL_TRML_FLAG = new Property<String>("fldchrDestRailTrmlFlag");
	public static final Property<String> FLDCHR_DEST_ROAD_TRML_FLAG = new Property<String>("fldchrDestRoadTrmlFlag");
	public static final Property<String> FLDVCH_DEST_COUNTRY_DESC = new Property<String>("fldvchDestCountryDesc");
	public static final Property<String> FLDVCH_DEST_GEO_AREA_DESC = new Property<String>("fldvchDestGeoAreaDesc");
	public static final Property<String> FLDVCH_DEST_LOCT_DESC = new Property<String>("fldvchDestLoctDesc");
	public static final Property<String> FLDVCH_DEST_LOCT_FULL_DESC = new Property<String>("fldvchDestLoctFullDesc");

	public void setFldchrDestAirportFlag(String fldchrDestAirportFlag)
	{
		writeProperty("fldchrDestAirportFlag", fldchrDestAirportFlag);
	}

	public String getFldchrDestAirportFlag()
	{
		return (String) readProperty("fldchrDestAirportFlag");
	}

	public void setFldchrDestCountryCode(String fldchrDestCountryCode)
	{
		writeProperty("fldchrDestCountryCode", fldchrDestCountryCode);
	}

	public String getFldchrDestCountryCode()
	{
		return (String) readProperty("fldchrDestCountryCode");
	}

	public void setFldchrDestFixedFunctionsFlag(String fldchrDestFixedFunctionsFlag)
	{
		writeProperty("fldchrDestFixedFunctionsFlag", fldchrDestFixedFunctionsFlag);
	}

	public String getFldchrDestFixedFunctionsFlag()
	{
		return (String) readProperty("fldchrDestFixedFunctionsFlag");
	}

	public void setFldchrDestGeoAreaCode(String fldchrDestGeoAreaCode)
	{
		writeProperty("fldchrDestGeoAreaCode", fldchrDestGeoAreaCode);
	}

	public String getFldchrDestGeoAreaCode()
	{
		return (String) readProperty("fldchrDestGeoAreaCode");
	}

	public void setFldchrDestLoctCode(String fldchrDestLoctCode)
	{
		writeProperty("fldchrDestLoctCode", fldchrDestLoctCode);
	}

	public String getFldchrDestLoctCode()
	{
		return (String) readProperty("fldchrDestLoctCode");
	}

	public void setFldchrDestLoctKey(String fldchrDestLoctKey)
	{
		writeProperty("fldchrDestLoctKey", fldchrDestLoctKey);
	}

	public String getFldchrDestLoctKey()
	{
		return (String) readProperty("fldchrDestLoctKey");
	}

	public void setFldchrDestPortFlag(String fldchrDestPortFlag)
	{
		writeProperty("fldchrDestPortFlag", fldchrDestPortFlag);
	}

	public String getFldchrDestPortFlag()
	{
		return (String) readProperty("fldchrDestPortFlag");
	}

	public void setFldchrDestRailTrmlFlag(String fldchrDestRailTrmlFlag)
	{
		writeProperty("fldchrDestRailTrmlFlag", fldchrDestRailTrmlFlag);
	}

	public String getFldchrDestRailTrmlFlag()
	{
		return (String) readProperty("fldchrDestRailTrmlFlag");
	}

	public void setFldchrDestRoadTrmlFlag(String fldchrDestRoadTrmlFlag)
	{
		writeProperty("fldchrDestRoadTrmlFlag", fldchrDestRoadTrmlFlag);
	}

	public String getFldchrDestRoadTrmlFlag()
	{
		return (String) readProperty("fldchrDestRoadTrmlFlag");
	}

	public void setFldvchDestCountryDesc(String fldvchDestCountryDesc)
	{
		writeProperty("fldvchDestCountryDesc", fldvchDestCountryDesc);
	}

	public String getFldvchDestCountryDesc()
	{
		return (String) readProperty("fldvchDestCountryDesc");
	}

	public void setFldvchDestGeoAreaDesc(String fldvchDestGeoAreaDesc)
	{
		writeProperty("fldvchDestGeoAreaDesc", fldvchDestGeoAreaDesc);
	}

	public String getFldvchDestGeoAreaDesc()
	{
		return (String) readProperty("fldvchDestGeoAreaDesc");
	}

	public void setFldvchDestLoctDesc(String fldvchDestLoctDesc)
	{
		writeProperty("fldvchDestLoctDesc", fldvchDestLoctDesc);
	}

	public String getFldvchDestLoctDesc()
	{
		return (String) readProperty("fldvchDestLoctDesc");
	}

	public void setFldvchDestLoctFullDesc(String fldvchDestLoctFullDesc)
	{
		writeProperty("fldvchDestLoctFullDesc", fldvchDestLoctFullDesc);
	}

	public String getFldvchDestLoctFullDesc()
	{
		return (String) readProperty("fldvchDestLoctFullDesc");
	}

}
