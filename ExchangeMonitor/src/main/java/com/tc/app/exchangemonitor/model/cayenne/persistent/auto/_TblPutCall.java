package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _TblPutCall was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TblPutCall extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CALL_EQUIVALENT = new Property<String>("callEquivalent");
	public static final Property<String> CONFIG_NAME = new Property<String>("configName");
	public static final Property<String> PUT_EQUIVALENT = new Property<String>("putEquivalent");

	public void setCallEquivalent(String callEquivalent)
	{
		writeProperty("callEquivalent", callEquivalent);
	}

	public String getCallEquivalent()
	{
		return (String) readProperty("callEquivalent");
	}

	public void setConfigName(String configName)
	{
		writeProperty("configName", configName);
	}

	public String getConfigName()
	{
		return (String) readProperty("configName");
	}

	public void setPutEquivalent(String putEquivalent)
	{
		writeProperty("putEquivalent", putEquivalent);
	}

	public String getPutEquivalent()
	{
		return (String) readProperty("putEquivalent");
	}

}
