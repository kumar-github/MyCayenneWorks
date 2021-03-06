package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;

/**
 * Class _ExternalMapping was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ExternalMapping extends CayenneDataObject
{
	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Integer> OID = new Property<>("oid");
	public static final Property<String> ALIAS_VALUE = new Property<>("aliasValue");
	public static final Property<String> EXTERNAL_VALUE1 = new Property<>("externalValue1");
	public static final Property<String> EXTERNAL_VALUE2 = new Property<>("externalValue2");
	public static final Property<String> EXTERNAL_VALUE3 = new Property<>("externalValue3");
	public static final Property<String> EXTERNAL_VALUE4 = new Property<>("externalValue4");
	public static final Property<String> MAPPING_TYPE = new Property<>("mappingType");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<ExternalTradeSource> EXTERNAL_TRADE_SOURCE_O = new Property<>("externalTradeSourceO");

	public void setAliasValue(final String aliasValue)
	{
		this.writeProperty("aliasValue", aliasValue);
	}

	public String getAliasValue()
	{
		return (String) this.readProperty("aliasValue");
	}

	public void setExternalValue1(final String externalValue1)
	{
		this.writeProperty("externalValue1", externalValue1);
	}

	public String getExternalValue1()
	{
		return (String) this.readProperty("externalValue1");
	}

	public void setExternalValue2(final String externalValue2)
	{
		this.writeProperty("externalValue2", externalValue2);
	}

	public String getExternalValue2()
	{
		return (String) this.readProperty("externalValue2");
	}

	public void setExternalValue3(final String externalValue3)
	{
		this.writeProperty("externalValue3", externalValue3);
	}

	public String getExternalValue3()
	{
		return (String) this.readProperty("externalValue3");
	}

	public void setExternalValue4(final String externalValue4)
	{
		this.writeProperty("externalValue4", externalValue4);
	}

	public String getExternalValue4()
	{
		return (String) this.readProperty("externalValue4");
	}

	public void setMappingType(final String mappingType)
	{
		this.writeProperty("mappingType", mappingType);
	}

	public String getMappingType()
	{
		return (String) this.readProperty("mappingType");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setExternalTradeSourceO(final ExternalTradeSource externalTradeSourceO)
	{
		this.setToOneTarget("externalTradeSourceO", externalTradeSourceO, true);
	}

	public ExternalTradeSource getExternalTradeSourceO()
	{
		return (ExternalTradeSource) this.readProperty("externalTradeSourceO");
	}
}