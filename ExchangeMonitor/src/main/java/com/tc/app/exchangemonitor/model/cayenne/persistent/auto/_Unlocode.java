package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.DemurrageReport;

/**
 * Class _Unlocode was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Unlocode extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_COUNTRY_CODE_PK_COLUMN = "fldchrCountryCode";
	public static final String FLDCHR_LOCT_CODE_PK_COLUMN = "fldchrLoctCode";

	public static final Property<String> FLDCHR_AIRPORT_FLAG = new Property<String>("fldchrAirportFlag");
	public static final Property<String> FLDCHR_BORDER_CROSSING_FLAG = new Property<String>("fldchrBorderCrossingFlag");
	public static final Property<String> FLDCHR_CUSTOM_CODE_FLAG = new Property<String>("fldchrCustomCodeFlag");
	public static final Property<String> FLDCHR_FIXED_FUNCTIONS_FLAG = new Property<String>("fldchrFixedFunctionsFlag");
	public static final Property<String> FLDCHR_GEO_AREA_CODE = new Property<String>("fldchrGeoAreaCode");
	public static final Property<String> FLDCHR_LOCT_ENABLED_FLAG = new Property<String>("fldchrLoctEnabledFlag");
	public static final Property<String> FLDCHR_LOCT_SUB = new Property<String>("fldchrLoctSub");
	public static final Property<String> FLDCHR_MULTIMODAL_FLAG = new Property<String>("fldchrMultimodalFlag");
	public static final Property<String> FLDCHR_PORT_FLAG = new Property<String>("fldchrPortFlag");
	public static final Property<String> FLDCHR_POSTAL_EXCHANGE_OFFICE_FLAG = new Property<String>("fldchrPostalExchangeOfficeFlag");
	public static final Property<String> FLDCHR_RAIL_TRML_FLAG = new Property<String>("fldchrRailTrmlFlag");
	public static final Property<String> FLDCHR_ROAD_TRML_FLAG = new Property<String>("fldchrRoadTrmlFlag");
	public static final Property<String> FLDCHR_USER_NAME = new Property<String>("fldchrUserName");
	public static final Property<BigDecimal> FLDDBL_AVERAGE_LURATE = new Property<BigDecimal>("flddblAverageLURate");
	public static final Property<Date> FLDSDT_TIME_STAMP = new Property<Date>("fldsdtTimeStamp");
	public static final Property<String> FLDVCH_LOCT_DESC = new Property<String>("fldvchLoctDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<DemurrageReport>> DEMURRAGE_REPORTS = new Property<List<DemurrageReport>>("demurrageReports");

	public void setFldchrAirportFlag(String fldchrAirportFlag)
	{
		writeProperty("fldchrAirportFlag", fldchrAirportFlag);
	}

	public String getFldchrAirportFlag()
	{
		return (String) readProperty("fldchrAirportFlag");
	}

	public void setFldchrBorderCrossingFlag(String fldchrBorderCrossingFlag)
	{
		writeProperty("fldchrBorderCrossingFlag", fldchrBorderCrossingFlag);
	}

	public String getFldchrBorderCrossingFlag()
	{
		return (String) readProperty("fldchrBorderCrossingFlag");
	}

	public void setFldchrCustomCodeFlag(String fldchrCustomCodeFlag)
	{
		writeProperty("fldchrCustomCodeFlag", fldchrCustomCodeFlag);
	}

	public String getFldchrCustomCodeFlag()
	{
		return (String) readProperty("fldchrCustomCodeFlag");
	}

	public void setFldchrFixedFunctionsFlag(String fldchrFixedFunctionsFlag)
	{
		writeProperty("fldchrFixedFunctionsFlag", fldchrFixedFunctionsFlag);
	}

	public String getFldchrFixedFunctionsFlag()
	{
		return (String) readProperty("fldchrFixedFunctionsFlag");
	}

	public void setFldchrGeoAreaCode(String fldchrGeoAreaCode)
	{
		writeProperty("fldchrGeoAreaCode", fldchrGeoAreaCode);
	}

	public String getFldchrGeoAreaCode()
	{
		return (String) readProperty("fldchrGeoAreaCode");
	}

	public void setFldchrLoctEnabledFlag(String fldchrLoctEnabledFlag)
	{
		writeProperty("fldchrLoctEnabledFlag", fldchrLoctEnabledFlag);
	}

	public String getFldchrLoctEnabledFlag()
	{
		return (String) readProperty("fldchrLoctEnabledFlag");
	}

	public void setFldchrLoctSub(String fldchrLoctSub)
	{
		writeProperty("fldchrLoctSub", fldchrLoctSub);
	}

	public String getFldchrLoctSub()
	{
		return (String) readProperty("fldchrLoctSub");
	}

	public void setFldchrMultimodalFlag(String fldchrMultimodalFlag)
	{
		writeProperty("fldchrMultimodalFlag", fldchrMultimodalFlag);
	}

	public String getFldchrMultimodalFlag()
	{
		return (String) readProperty("fldchrMultimodalFlag");
	}

	public void setFldchrPortFlag(String fldchrPortFlag)
	{
		writeProperty("fldchrPortFlag", fldchrPortFlag);
	}

	public String getFldchrPortFlag()
	{
		return (String) readProperty("fldchrPortFlag");
	}

	public void setFldchrPostalExchangeOfficeFlag(String fldchrPostalExchangeOfficeFlag)
	{
		writeProperty("fldchrPostalExchangeOfficeFlag", fldchrPostalExchangeOfficeFlag);
	}

	public String getFldchrPostalExchangeOfficeFlag()
	{
		return (String) readProperty("fldchrPostalExchangeOfficeFlag");
	}

	public void setFldchrRailTrmlFlag(String fldchrRailTrmlFlag)
	{
		writeProperty("fldchrRailTrmlFlag", fldchrRailTrmlFlag);
	}

	public String getFldchrRailTrmlFlag()
	{
		return (String) readProperty("fldchrRailTrmlFlag");
	}

	public void setFldchrRoadTrmlFlag(String fldchrRoadTrmlFlag)
	{
		writeProperty("fldchrRoadTrmlFlag", fldchrRoadTrmlFlag);
	}

	public String getFldchrRoadTrmlFlag()
	{
		return (String) readProperty("fldchrRoadTrmlFlag");
	}

	public void setFldchrUserName(String fldchrUserName)
	{
		writeProperty("fldchrUserName", fldchrUserName);
	}

	public String getFldchrUserName()
	{
		return (String) readProperty("fldchrUserName");
	}

	public void setFlddblAverageLURate(BigDecimal flddblAverageLURate)
	{
		writeProperty("flddblAverageLURate", flddblAverageLURate);
	}

	public BigDecimal getFlddblAverageLURate()
	{
		return (BigDecimal) readProperty("flddblAverageLURate");
	}

	public void setFldsdtTimeStamp(Date fldsdtTimeStamp)
	{
		writeProperty("fldsdtTimeStamp", fldsdtTimeStamp);
	}

	public Date getFldsdtTimeStamp()
	{
		return (Date) readProperty("fldsdtTimeStamp");
	}

	public void setFldvchLoctDesc(String fldvchLoctDesc)
	{
		writeProperty("fldvchLoctDesc", fldvchLoctDesc);
	}

	public String getFldvchLoctDesc()
	{
		return (String) readProperty("fldvchLoctDesc");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	@SuppressWarnings("unchecked")
	public List<DemurrageReport> getDemurrageReports()
	{
		return (List<DemurrageReport>) readProperty("demurrageReports");
	}

}
