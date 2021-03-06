package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudLocationTankInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudLocationTankInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ADDRESS_LINE1 = new Property<String>("addressLine1");
	public static final Property<String> ADDRESS_LINE2 = new Property<String>("addressLine2");
	public static final Property<String> API_WELL_NUM = new Property<String>("apiWellNum");
	public static final Property<String> BATTERY_GOVT_CODE = new Property<String>("batteryGovtCode");
	public static final Property<Boolean> BONDED_WAREHOUSE_LOC_IND = new Property<Boolean>("bondedWarehouseLocInd");
	public static final Property<String> CITY_CODE = new Property<String>("cityCode");
	public static final Property<Boolean> CONFIRMATION_STATUS = new Property<Boolean>("confirmationStatus");
	public static final Property<String> COUNTRY_CODE = new Property<String>("countryCode");
	public static final Property<String> COUNTY_CODE = new Property<String>("countyCode");
	public static final Property<String> EXCISE_INFO_ID = new Property<String>("exciseInfoId");
	public static final Property<Boolean> EXCISE_WAREHOUSE_LOC_IND = new Property<Boolean>("exciseWarehouseLocInd");
	public static final Property<String> FIELD_NAME = new Property<String>("fieldName");
	public static final Property<Boolean> FIRST_PURCHASER_IND = new Property<Boolean>("firstPurchaserInd");
	public static final Property<String> GEOLOGIC_FORMATION = new Property<String>("geologicFormation");
	public static final Property<BigDecimal> LATITUDE = new Property<BigDecimal>("latitude");
	public static final Property<String> LEGAL_DESC = new Property<String>("legalDesc");
	public static final Property<String> LOC_CODE = new Property<String>("locCode");
	public static final Property<String> LOCATION_TANK_INFO_TYPE = new Property<String>("locationTankInfoType");
	public static final Property<String> LONG_DESCRIPTION = new Property<String>("longDescription");
	public static final Property<BigDecimal> LONGITUDE = new Property<BigDecimal>("longitude");
	public static final Property<String> METER_NUM = new Property<String>("meterNum");
	public static final Property<Integer> OPERATOR_NUM = new Property<Integer>("operatorNum");
	public static final Property<Integer> OWNER_NUM = new Property<Integer>("ownerNum");
	public static final Property<String> POSTAL_CODE = new Property<String>("postalCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> STATE_CODE = new Property<String>("stateCode");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<String> SURVEY_ADDRESS = new Property<String>("surveyAddress");
	public static final Property<BigDecimal> TANK_CAPACITY = new Property<BigDecimal>("tankCapacity");
	public static final Property<String> TANK_CAPACITY_UOM_CODE = new Property<String>("tankCapacityUomCode");
	public static final Property<Integer> TANK_NUM = new Property<Integer>("tankNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> WELL_NAME = new Property<String>("wellName");

	public void setAddressLine1(String addressLine1)
	{
		writeProperty("addressLine1", addressLine1);
	}

	public String getAddressLine1()
	{
		return (String) readProperty("addressLine1");
	}

	public void setAddressLine2(String addressLine2)
	{
		writeProperty("addressLine2", addressLine2);
	}

	public String getAddressLine2()
	{
		return (String) readProperty("addressLine2");
	}

	public void setApiWellNum(String apiWellNum)
	{
		writeProperty("apiWellNum", apiWellNum);
	}

	public String getApiWellNum()
	{
		return (String) readProperty("apiWellNum");
	}

	public void setBatteryGovtCode(String batteryGovtCode)
	{
		writeProperty("batteryGovtCode", batteryGovtCode);
	}

	public String getBatteryGovtCode()
	{
		return (String) readProperty("batteryGovtCode");
	}

	public void setBondedWarehouseLocInd(Boolean bondedWarehouseLocInd)
	{
		writeProperty("bondedWarehouseLocInd", bondedWarehouseLocInd);
	}

	public Boolean getBondedWarehouseLocInd()
	{
		return (Boolean) readProperty("bondedWarehouseLocInd");
	}

	public void setCityCode(String cityCode)
	{
		writeProperty("cityCode", cityCode);
	}

	public String getCityCode()
	{
		return (String) readProperty("cityCode");
	}

	public void setConfirmationStatus(Boolean confirmationStatus)
	{
		writeProperty("confirmationStatus", confirmationStatus);
	}

	public Boolean getConfirmationStatus()
	{
		return (Boolean) readProperty("confirmationStatus");
	}

	public void setCountryCode(String countryCode)
	{
		writeProperty("countryCode", countryCode);
	}

	public String getCountryCode()
	{
		return (String) readProperty("countryCode");
	}

	public void setCountyCode(String countyCode)
	{
		writeProperty("countyCode", countyCode);
	}

	public String getCountyCode()
	{
		return (String) readProperty("countyCode");
	}

	public void setExciseInfoId(String exciseInfoId)
	{
		writeProperty("exciseInfoId", exciseInfoId);
	}

	public String getExciseInfoId()
	{
		return (String) readProperty("exciseInfoId");
	}

	public void setExciseWarehouseLocInd(Boolean exciseWarehouseLocInd)
	{
		writeProperty("exciseWarehouseLocInd", exciseWarehouseLocInd);
	}

	public Boolean getExciseWarehouseLocInd()
	{
		return (Boolean) readProperty("exciseWarehouseLocInd");
	}

	public void setFieldName(String fieldName)
	{
		writeProperty("fieldName", fieldName);
	}

	public String getFieldName()
	{
		return (String) readProperty("fieldName");
	}

	public void setFirstPurchaserInd(Boolean firstPurchaserInd)
	{
		writeProperty("firstPurchaserInd", firstPurchaserInd);
	}

	public Boolean getFirstPurchaserInd()
	{
		return (Boolean) readProperty("firstPurchaserInd");
	}

	public void setGeologicFormation(String geologicFormation)
	{
		writeProperty("geologicFormation", geologicFormation);
	}

	public String getGeologicFormation()
	{
		return (String) readProperty("geologicFormation");
	}

	public void setLatitude(BigDecimal latitude)
	{
		writeProperty("latitude", latitude);
	}

	public BigDecimal getLatitude()
	{
		return (BigDecimal) readProperty("latitude");
	}

	public void setLegalDesc(String legalDesc)
	{
		writeProperty("legalDesc", legalDesc);
	}

	public String getLegalDesc()
	{
		return (String) readProperty("legalDesc");
	}

	public void setLocCode(String locCode)
	{
		writeProperty("locCode", locCode);
	}

	public String getLocCode()
	{
		return (String) readProperty("locCode");
	}

	public void setLocationTankInfoType(String locationTankInfoType)
	{
		writeProperty("locationTankInfoType", locationTankInfoType);
	}

	public String getLocationTankInfoType()
	{
		return (String) readProperty("locationTankInfoType");
	}

	public void setLongDescription(String longDescription)
	{
		writeProperty("longDescription", longDescription);
	}

	public String getLongDescription()
	{
		return (String) readProperty("longDescription");
	}

	public void setLongitude(BigDecimal longitude)
	{
		writeProperty("longitude", longitude);
	}

	public BigDecimal getLongitude()
	{
		return (BigDecimal) readProperty("longitude");
	}

	public void setMeterNum(String meterNum)
	{
		writeProperty("meterNum", meterNum);
	}

	public String getMeterNum()
	{
		return (String) readProperty("meterNum");
	}

	public void setOperatorNum(Integer operatorNum)
	{
		writeProperty("operatorNum", operatorNum);
	}

	public Integer getOperatorNum()
	{
		return (Integer) readProperty("operatorNum");
	}

	public void setOwnerNum(Integer ownerNum)
	{
		writeProperty("ownerNum", ownerNum);
	}

	public Integer getOwnerNum()
	{
		return (Integer) readProperty("ownerNum");
	}

	public void setPostalCode(String postalCode)
	{
		writeProperty("postalCode", postalCode);
	}

	public String getPostalCode()
	{
		return (String) readProperty("postalCode");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setStateCode(String stateCode)
	{
		writeProperty("stateCode", stateCode);
	}

	public String getStateCode()
	{
		return (String) readProperty("stateCode");
	}

	public void setStatus(String status)
	{
		writeProperty("status", status);
	}

	public String getStatus()
	{
		return (String) readProperty("status");
	}

	public void setSurveyAddress(String surveyAddress)
	{
		writeProperty("surveyAddress", surveyAddress);
	}

	public String getSurveyAddress()
	{
		return (String) readProperty("surveyAddress");
	}

	public void setTankCapacity(BigDecimal tankCapacity)
	{
		writeProperty("tankCapacity", tankCapacity);
	}

	public BigDecimal getTankCapacity()
	{
		return (BigDecimal) readProperty("tankCapacity");
	}

	public void setTankCapacityUomCode(String tankCapacityUomCode)
	{
		writeProperty("tankCapacityUomCode", tankCapacityUomCode);
	}

	public String getTankCapacityUomCode()
	{
		return (String) readProperty("tankCapacityUomCode");
	}

	public void setTankNum(Integer tankNum)
	{
		writeProperty("tankNum", tankNum);
	}

	public Integer getTankNum()
	{
		return (Integer) readProperty("tankNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setWellName(String wellName)
	{
		writeProperty("wellName", wellName);
	}

	public String getWellName()
	{
		return (String) readProperty("wellName");
	}

}
