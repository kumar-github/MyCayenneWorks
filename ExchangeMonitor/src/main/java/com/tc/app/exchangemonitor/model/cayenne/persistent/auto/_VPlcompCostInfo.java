package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VPlcompCostInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VPlcompCostInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> ALLOC_CREATION_DATE = new Property<Date>("allocCreationDate");
	public static final Property<Integer> ALLOC_TRANS_ID = new Property<Integer>("allocTransId");
	public static final Property<String> COST_CODE = new Property<String>("costCode");
	public static final Property<String> COST_COUNTERPARTY_NAME = new Property<String>("costCounterpartyName");
	public static final Property<Date> COST_CREATION_DATE = new Property<Date>("costCreationDate");
	public static final Property<Date> COST_EFF_DATE = new Property<Date>("costEffDate");
	public static final Property<Integer> COST_NUM = new Property<Integer>("costNum");
	public static final Property<String> COST_OWNER_CODE = new Property<String>("costOwnerCode");
	public static final Property<Integer> COST_OWNER_KEY1 = new Property<Integer>("costOwnerKey1");
	public static final Property<Integer> COST_OWNER_KEY2 = new Property<Integer>("costOwnerKey2");
	public static final Property<String> COST_PRICE_CURR_CODE = new Property<String>("costPriceCurrCode");
	public static final Property<String> COST_PRIM_SEC_IND = new Property<String>("costPrimSecInd");
	public static final Property<Integer> COST_TRANS_ID = new Property<Integer>("costTransId");
	public static final Property<String> CREATOR_INIT = new Property<String>("creatorInit");
	public static final Property<String> SCH_INIT = new Property<String>("schInit");

	public void setAllocCreationDate(Date allocCreationDate)
	{
		writeProperty("allocCreationDate", allocCreationDate);
	}

	public Date getAllocCreationDate()
	{
		return (Date) readProperty("allocCreationDate");
	}

	public void setAllocTransId(Integer allocTransId)
	{
		writeProperty("allocTransId", allocTransId);
	}

	public Integer getAllocTransId()
	{
		return (Integer) readProperty("allocTransId");
	}

	public void setCostCode(String costCode)
	{
		writeProperty("costCode", costCode);
	}

	public String getCostCode()
	{
		return (String) readProperty("costCode");
	}

	public void setCostCounterpartyName(String costCounterpartyName)
	{
		writeProperty("costCounterpartyName", costCounterpartyName);
	}

	public String getCostCounterpartyName()
	{
		return (String) readProperty("costCounterpartyName");
	}

	public void setCostCreationDate(Date costCreationDate)
	{
		writeProperty("costCreationDate", costCreationDate);
	}

	public Date getCostCreationDate()
	{
		return (Date) readProperty("costCreationDate");
	}

	public void setCostEffDate(Date costEffDate)
	{
		writeProperty("costEffDate", costEffDate);
	}

	public Date getCostEffDate()
	{
		return (Date) readProperty("costEffDate");
	}

	public void setCostNum(Integer costNum)
	{
		writeProperty("costNum", costNum);
	}

	public Integer getCostNum()
	{
		return (Integer) readProperty("costNum");
	}

	public void setCostOwnerCode(String costOwnerCode)
	{
		writeProperty("costOwnerCode", costOwnerCode);
	}

	public String getCostOwnerCode()
	{
		return (String) readProperty("costOwnerCode");
	}

	public void setCostOwnerKey1(Integer costOwnerKey1)
	{
		writeProperty("costOwnerKey1", costOwnerKey1);
	}

	public Integer getCostOwnerKey1()
	{
		return (Integer) readProperty("costOwnerKey1");
	}

	public void setCostOwnerKey2(Integer costOwnerKey2)
	{
		writeProperty("costOwnerKey2", costOwnerKey2);
	}

	public Integer getCostOwnerKey2()
	{
		return (Integer) readProperty("costOwnerKey2");
	}

	public void setCostPriceCurrCode(String costPriceCurrCode)
	{
		writeProperty("costPriceCurrCode", costPriceCurrCode);
	}

	public String getCostPriceCurrCode()
	{
		return (String) readProperty("costPriceCurrCode");
	}

	public void setCostPrimSecInd(String costPrimSecInd)
	{
		writeProperty("costPrimSecInd", costPrimSecInd);
	}

	public String getCostPrimSecInd()
	{
		return (String) readProperty("costPrimSecInd");
	}

	public void setCostTransId(Integer costTransId)
	{
		writeProperty("costTransId", costTransId);
	}

	public Integer getCostTransId()
	{
		return (Integer) readProperty("costTransId");
	}

	public void setCreatorInit(String creatorInit)
	{
		writeProperty("creatorInit", creatorInit);
	}

	public String getCreatorInit()
	{
		return (String) readProperty("creatorInit");
	}

	public void setSchInit(String schInit)
	{
		writeProperty("schInit", schInit);
	}

	public String getSchInit()
	{
		return (String) readProperty("schInit");
	}

}
