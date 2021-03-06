package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudLcType was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudLcType extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> LC_TYPE_CODE = new Property<String>("lcTypeCode");
	public static final Property<String> LC_TYPE_DESC = new Property<String>("lcTypeDesc");
	public static final Property<Short> LC_TYPE_NUM = new Property<Short>("lcTypeNum");
	public static final Property<String> LC_TYPE_SHORT_NAME = new Property<String>("lcTypeShortName");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setLcTypeCode(String lcTypeCode)
	{
		writeProperty("lcTypeCode", lcTypeCode);
	}

	public String getLcTypeCode()
	{
		return (String) readProperty("lcTypeCode");
	}

	public void setLcTypeDesc(String lcTypeDesc)
	{
		writeProperty("lcTypeDesc", lcTypeDesc);
	}

	public String getLcTypeDesc()
	{
		return (String) readProperty("lcTypeDesc");
	}

	public void setLcTypeNum(Short lcTypeNum)
	{
		writeProperty("lcTypeNum", lcTypeNum);
	}

	public Short getLcTypeNum()
	{
		return (Short) readProperty("lcTypeNum");
	}

	public void setLcTypeShortName(String lcTypeShortName)
	{
		writeProperty("lcTypeShortName", lcTypeShortName);
	}

	public String getLcTypeShortName()
	{
		return (String) readProperty("lcTypeShortName");
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
