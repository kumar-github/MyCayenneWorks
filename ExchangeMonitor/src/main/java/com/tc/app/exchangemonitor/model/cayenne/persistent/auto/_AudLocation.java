package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudLocation was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudLocation extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> DEL_LOC_IND = new Property<String>("delLocInd");
	public static final Property<String> INV_LOC_IND = new Property<String>("invLocInd");
	public static final Property<BigDecimal> LATITUDE = new Property<BigDecimal>("latitude");
	public static final Property<String> LOC_CODE = new Property<String>("locCode");
	public static final Property<String> LOC_NAME = new Property<String>("locName");
	public static final Property<Short> LOC_NUM = new Property<Short>("locNum");
	public static final Property<String> LOC_STATUS = new Property<String>("locStatus");
	public static final Property<BigDecimal> LONGITUDE = new Property<BigDecimal>("longitude");
	public static final Property<String> OFFICE_LOC_IND = new Property<String>("officeLocInd");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> WAREHOUSE_AGP_NUM = new Property<String>("warehouseAgpNum");

	public void setDelLocInd(String delLocInd)
	{
		writeProperty("delLocInd", delLocInd);
	}

	public String getDelLocInd()
	{
		return (String) readProperty("delLocInd");
	}

	public void setInvLocInd(String invLocInd)
	{
		writeProperty("invLocInd", invLocInd);
	}

	public String getInvLocInd()
	{
		return (String) readProperty("invLocInd");
	}

	public void setLatitude(BigDecimal latitude)
	{
		writeProperty("latitude", latitude);
	}

	public BigDecimal getLatitude()
	{
		return (BigDecimal) readProperty("latitude");
	}

	public void setLocCode(String locCode)
	{
		writeProperty("locCode", locCode);
	}

	public String getLocCode()
	{
		return (String) readProperty("locCode");
	}

	public void setLocName(String locName)
	{
		writeProperty("locName", locName);
	}

	public String getLocName()
	{
		return (String) readProperty("locName");
	}

	public void setLocNum(Short locNum)
	{
		writeProperty("locNum", locNum);
	}

	public Short getLocNum()
	{
		return (Short) readProperty("locNum");
	}

	public void setLocStatus(String locStatus)
	{
		writeProperty("locStatus", locStatus);
	}

	public String getLocStatus()
	{
		return (String) readProperty("locStatus");
	}

	public void setLongitude(BigDecimal longitude)
	{
		writeProperty("longitude", longitude);
	}

	public BigDecimal getLongitude()
	{
		return (BigDecimal) readProperty("longitude");
	}

	public void setOfficeLocInd(String officeLocInd)
	{
		writeProperty("officeLocInd", officeLocInd);
	}

	public String getOfficeLocInd()
	{
		return (String) readProperty("officeLocInd");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setWarehouseAgpNum(String warehouseAgpNum)
	{
		writeProperty("warehouseAgpNum", warehouseAgpNum);
	}

	public String getWarehouseAgpNum()
	{
		return (String) readProperty("warehouseAgpNum");
	}

}
