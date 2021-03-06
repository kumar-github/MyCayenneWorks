package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudFunctionDetail was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudFunctionDetail extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ATTR_NAME = new Property<String>("attrName");
	public static final Property<Boolean> ENTITY_IND = new Property<Boolean>("entityInd");
	public static final Property<String> ENTITY_NAME = new Property<String>("entityName");
	public static final Property<Integer> FD_ID = new Property<Integer>("fdId");
	public static final Property<Integer> FUNCTION_NUM = new Property<Integer>("functionNum");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAttrName(String attrName)
	{
		writeProperty("attrName", attrName);
	}

	public String getAttrName()
	{
		return (String) readProperty("attrName");
	}

	public void setEntityInd(Boolean entityInd)
	{
		writeProperty("entityInd", entityInd);
	}

	public Boolean getEntityInd()
	{
		return (Boolean) readProperty("entityInd");
	}

	public void setEntityName(String entityName)
	{
		writeProperty("entityName", entityName);
	}

	public String getEntityName()
	{
		return (String) readProperty("entityName");
	}

	public void setFdId(Integer fdId)
	{
		writeProperty("fdId", fdId);
	}

	public Integer getFdId()
	{
		return (Integer) readProperty("fdId");
	}

	public void setFunctionNum(Integer functionNum)
	{
		writeProperty("functionNum", functionNum);
	}

	public Integer getFunctionNum()
	{
		return (Integer) readProperty("functionNum");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
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
