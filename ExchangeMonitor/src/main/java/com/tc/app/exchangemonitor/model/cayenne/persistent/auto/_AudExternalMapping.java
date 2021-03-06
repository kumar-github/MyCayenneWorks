package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudExternalMapping was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudExternalMapping extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ALIAS_VALUE = new Property<String>("aliasValue");
	public static final Property<Integer> EXTERNAL_TRADE_SOURCE_OID = new Property<Integer>("externalTradeSourceOid");
	public static final Property<String> EXTERNAL_VALUE1 = new Property<String>("externalValue1");
	public static final Property<String> EXTERNAL_VALUE2 = new Property<String>("externalValue2");
	public static final Property<String> EXTERNAL_VALUE3 = new Property<String>("externalValue3");
	public static final Property<String> EXTERNAL_VALUE4 = new Property<String>("externalValue4");
	public static final Property<String> MAPPING_TYPE = new Property<String>("mappingType");
	public static final Property<Integer> OID = new Property<Integer>("oid");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAliasValue(String aliasValue)
	{
		writeProperty("aliasValue", aliasValue);
	}

	public String getAliasValue()
	{
		return (String) readProperty("aliasValue");
	}

	public void setExternalTradeSourceOid(Integer externalTradeSourceOid)
	{
		writeProperty("externalTradeSourceOid", externalTradeSourceOid);
	}

	public Integer getExternalTradeSourceOid()
	{
		return (Integer) readProperty("externalTradeSourceOid");
	}

	public void setExternalValue1(String externalValue1)
	{
		writeProperty("externalValue1", externalValue1);
	}

	public String getExternalValue1()
	{
		return (String) readProperty("externalValue1");
	}

	public void setExternalValue2(String externalValue2)
	{
		writeProperty("externalValue2", externalValue2);
	}

	public String getExternalValue2()
	{
		return (String) readProperty("externalValue2");
	}

	public void setExternalValue3(String externalValue3)
	{
		writeProperty("externalValue3", externalValue3);
	}

	public String getExternalValue3()
	{
		return (String) readProperty("externalValue3");
	}

	public void setExternalValue4(String externalValue4)
	{
		writeProperty("externalValue4", externalValue4);
	}

	public String getExternalValue4()
	{
		return (String) readProperty("externalValue4");
	}

	public void setMappingType(String mappingType)
	{
		writeProperty("mappingType", mappingType);
	}

	public String getMappingType()
	{
		return (String) readProperty("mappingType");
	}

	public void setOid(Integer oid)
	{
		writeProperty("oid", oid);
	}

	public Integer getOid()
	{
		return (Integer) readProperty("oid");
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
