package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudAllocationItemSpec was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudAllocationItemSpec extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Short> ALLOC_ITEM_NUM = new Property<Short>("allocItemNum");
	public static final Property<Integer> ALLOC_NUM = new Property<Integer>("allocNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Double> SPEC_ACTUAL_VALUE = new Property<Double>("specActualValue");
	public static final Property<String> SPEC_CODE = new Property<String>("specCode");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAllocItemNum(Short allocItemNum)
	{
		writeProperty("allocItemNum", allocItemNum);
	}

	public Short getAllocItemNum()
	{
		return (Short) readProperty("allocItemNum");
	}

	public void setAllocNum(Integer allocNum)
	{
		writeProperty("allocNum", allocNum);
	}

	public Integer getAllocNum()
	{
		return (Integer) readProperty("allocNum");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setSpecActualValue(Double specActualValue)
	{
		writeProperty("specActualValue", specActualValue);
	}

	public Double getSpecActualValue()
	{
		return (Double) readProperty("specActualValue");
	}

	public void setSpecCode(String specCode)
	{
		writeProperty("specCode", specCode);
	}

	public String getSpecCode()
	{
		return (String) readProperty("specCode");
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
