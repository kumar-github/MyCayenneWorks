package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudBusCostState was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudBusCostState extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> BC_STATE_CODE = new Property<String>("bcStateCode");
	public static final Property<String> BC_STATE_DESC = new Property<String>("bcStateDesc");
	public static final Property<String> BC_STATE_FULL_NAME = new Property<String>("bcStateFullName");
	public static final Property<Short> BC_STATE_NUM = new Property<Short>("bcStateNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setBcStateCode(String bcStateCode)
	{
		writeProperty("bcStateCode", bcStateCode);
	}

	public String getBcStateCode()
	{
		return (String) readProperty("bcStateCode");
	}

	public void setBcStateDesc(String bcStateDesc)
	{
		writeProperty("bcStateDesc", bcStateDesc);
	}

	public String getBcStateDesc()
	{
		return (String) readProperty("bcStateDesc");
	}

	public void setBcStateFullName(String bcStateFullName)
	{
		writeProperty("bcStateFullName", bcStateFullName);
	}

	public String getBcStateFullName()
	{
		return (String) readProperty("bcStateFullName");
	}

	public void setBcStateNum(Short bcStateNum)
	{
		writeProperty("bcStateNum", bcStateNum);
	}

	public Short getBcStateNum()
	{
		return (Short) readProperty("bcStateNum");
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

}
