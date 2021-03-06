package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCommodity was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCommodity extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CMDTY_CATEGORY_CODE = new Property<String>("cmdtyCategoryCode");
	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<String> CMDTY_FULL_NAME = new Property<String>("cmdtyFullName");
	public static final Property<String> CMDTY_LOC_DESC = new Property<String>("cmdtyLocDesc");
	public static final Property<String> CMDTY_SHORT_NAME = new Property<String>("cmdtyShortName");
	public static final Property<String> CMDTY_STATUS = new Property<String>("cmdtyStatus");
	public static final Property<String> CMDTY_TRADEABLE_IND = new Property<String>("cmdtyTradeableInd");
	public static final Property<String> CMDTY_TYPE = new Property<String>("cmdtyType");
	public static final Property<String> COUNTRY_CODE = new Property<String>("countryCode");
	public static final Property<String> GRADE = new Property<String>("grade");
	public static final Property<String> IS_COMPOSITE = new Property<String>("isComposite");
	public static final Property<String> MOVEMENTS_REQUIRE_SPECIFIC_ACTUALS = new Property<String>("movementsRequireSpecificActuals");
	public static final Property<String> PRIM_CURR_CODE = new Property<String>("primCurrCode");
	public static final Property<Double> PRIM_CURR_CONV_RATE = new Property<Double>("primCurrConvRate");
	public static final Property<String> PRIM_UOM_CODE = new Property<String>("primUomCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> SEC_UOM_CODE = new Property<String>("secUomCode");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setCmdtyCategoryCode(String cmdtyCategoryCode)
	{
		writeProperty("cmdtyCategoryCode", cmdtyCategoryCode);
	}

	public String getCmdtyCategoryCode()
	{
		return (String) readProperty("cmdtyCategoryCode");
	}

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setCmdtyFullName(String cmdtyFullName)
	{
		writeProperty("cmdtyFullName", cmdtyFullName);
	}

	public String getCmdtyFullName()
	{
		return (String) readProperty("cmdtyFullName");
	}

	public void setCmdtyLocDesc(String cmdtyLocDesc)
	{
		writeProperty("cmdtyLocDesc", cmdtyLocDesc);
	}

	public String getCmdtyLocDesc()
	{
		return (String) readProperty("cmdtyLocDesc");
	}

	public void setCmdtyShortName(String cmdtyShortName)
	{
		writeProperty("cmdtyShortName", cmdtyShortName);
	}

	public String getCmdtyShortName()
	{
		return (String) readProperty("cmdtyShortName");
	}

	public void setCmdtyStatus(String cmdtyStatus)
	{
		writeProperty("cmdtyStatus", cmdtyStatus);
	}

	public String getCmdtyStatus()
	{
		return (String) readProperty("cmdtyStatus");
	}

	public void setCmdtyTradeableInd(String cmdtyTradeableInd)
	{
		writeProperty("cmdtyTradeableInd", cmdtyTradeableInd);
	}

	public String getCmdtyTradeableInd()
	{
		return (String) readProperty("cmdtyTradeableInd");
	}

	public void setCmdtyType(String cmdtyType)
	{
		writeProperty("cmdtyType", cmdtyType);
	}

	public String getCmdtyType()
	{
		return (String) readProperty("cmdtyType");
	}

	public void setCountryCode(String countryCode)
	{
		writeProperty("countryCode", countryCode);
	}

	public String getCountryCode()
	{
		return (String) readProperty("countryCode");
	}

	public void setGrade(String grade)
	{
		writeProperty("grade", grade);
	}

	public String getGrade()
	{
		return (String) readProperty("grade");
	}

	public void setIsComposite(String isComposite)
	{
		writeProperty("isComposite", isComposite);
	}

	public String getIsComposite()
	{
		return (String) readProperty("isComposite");
	}

	public void setMovementsRequireSpecificActuals(String movementsRequireSpecificActuals)
	{
		writeProperty("movementsRequireSpecificActuals", movementsRequireSpecificActuals);
	}

	public String getMovementsRequireSpecificActuals()
	{
		return (String) readProperty("movementsRequireSpecificActuals");
	}

	public void setPrimCurrCode(String primCurrCode)
	{
		writeProperty("primCurrCode", primCurrCode);
	}

	public String getPrimCurrCode()
	{
		return (String) readProperty("primCurrCode");
	}

	public void setPrimCurrConvRate(Double primCurrConvRate)
	{
		writeProperty("primCurrConvRate", primCurrConvRate);
	}

	public Double getPrimCurrConvRate()
	{
		return (Double) readProperty("primCurrConvRate");
	}

	public void setPrimUomCode(String primUomCode)
	{
		writeProperty("primUomCode", primUomCode);
	}

	public String getPrimUomCode()
	{
		return (String) readProperty("primUomCode");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setSecUomCode(String secUomCode)
	{
		writeProperty("secUomCode", secUomCode);
	}

	public String getSecUomCode()
	{
		return (String) readProperty("secUomCode");
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
