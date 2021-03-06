package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AliasSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExtTransKeys;
import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsEntityName;

/**
 * Class _ExtTrandataMapping was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ExtTrandataMapping extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> EXTERNAL_KEY1 = new Property<String>("externalKey1");
	public static final Property<String> EXTERNAL_KEY2 = new Property<String>("externalKey2");
	public static final Property<String> EXTERNAL_KEY3 = new Property<String>("externalKey3");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<AliasSource> ALIAS_SOURCE = new Property<AliasSource>("aliasSource");
	public static final Property<IctsEntityName> ENTITY = new Property<IctsEntityName>("entity");
	public static final Property<ExtTransKeys> ENTITY_KEY1VALUE = new Property<ExtTransKeys>("entityKey1Value");
	public static final Property<ExtTransKeys> ENTITY_KEY2VALUE = new Property<ExtTransKeys>("entityKey2Value");
	public static final Property<ExtTransKeys> ENTITY_KEY3VALUE = new Property<ExtTransKeys>("entityKey3Value");
	public static final Property<ExtTransKeys> ENTITY_KEY4VALUE = new Property<ExtTransKeys>("entityKey4Value");
	public static final Property<ExtTransKeys> ENTITY_KEY5VALUE = new Property<ExtTransKeys>("entityKey5Value");
	public static final Property<ExtTransKeys> ENTITY_KEY6VALUE = new Property<ExtTransKeys>("entityKey6Value");

	public void setExternalKey1(String externalKey1)
	{
		writeProperty("externalKey1", externalKey1);
	}

	public String getExternalKey1()
	{
		return (String) readProperty("externalKey1");
	}

	public void setExternalKey2(String externalKey2)
	{
		writeProperty("externalKey2", externalKey2);
	}

	public String getExternalKey2()
	{
		return (String) readProperty("externalKey2");
	}

	public void setExternalKey3(String externalKey3)
	{
		writeProperty("externalKey3", externalKey3);
	}

	public String getExternalKey3()
	{
		return (String) readProperty("externalKey3");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setAliasSource(AliasSource aliasSource)
	{
		setToOneTarget("aliasSource", aliasSource, true);
	}

	public AliasSource getAliasSource()
	{
		return (AliasSource) readProperty("aliasSource");
	}

	public void setEntity(IctsEntityName entity)
	{
		setToOneTarget("entity", entity, true);
	}

	public IctsEntityName getEntity()
	{
		return (IctsEntityName) readProperty("entity");
	}

	public void setEntityKey1Value(ExtTransKeys entityKey1Value)
	{
		setToOneTarget("entityKey1Value", entityKey1Value, true);
	}

	public ExtTransKeys getEntityKey1Value()
	{
		return (ExtTransKeys) readProperty("entityKey1Value");
	}

	public void setEntityKey2Value(ExtTransKeys entityKey2Value)
	{
		setToOneTarget("entityKey2Value", entityKey2Value, true);
	}

	public ExtTransKeys getEntityKey2Value()
	{
		return (ExtTransKeys) readProperty("entityKey2Value");
	}

	public void setEntityKey3Value(ExtTransKeys entityKey3Value)
	{
		setToOneTarget("entityKey3Value", entityKey3Value, true);
	}

	public ExtTransKeys getEntityKey3Value()
	{
		return (ExtTransKeys) readProperty("entityKey3Value");
	}

	public void setEntityKey4Value(ExtTransKeys entityKey4Value)
	{
		setToOneTarget("entityKey4Value", entityKey4Value, true);
	}

	public ExtTransKeys getEntityKey4Value()
	{
		return (ExtTransKeys) readProperty("entityKey4Value");
	}

	public void setEntityKey5Value(ExtTransKeys entityKey5Value)
	{
		setToOneTarget("entityKey5Value", entityKey5Value, true);
	}

	public ExtTransKeys getEntityKey5Value()
	{
		return (ExtTransKeys) readProperty("entityKey5Value");
	}

	public void setEntityKey6Value(ExtTransKeys entityKey6Value)
	{
		setToOneTarget("entityKey6Value", entityKey6Value, true);
	}

	public ExtTransKeys getEntityKey6Value()
	{
		return (ExtTransKeys) readProperty("entityKey6Value");
	}

}
