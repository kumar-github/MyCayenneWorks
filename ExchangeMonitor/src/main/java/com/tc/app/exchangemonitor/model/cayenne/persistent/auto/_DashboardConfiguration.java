package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _DashboardConfiguration was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DashboardConfiguration extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CONFIG_NAME_PK_COLUMN = "config_name";

	public static final Property<String> CONFIG_VALUE = new Property<String>("configValue");

	public void setConfigValue(String configValue)
	{
		writeProperty("configValue", configValue);
	}

	public String getConfigValue()
	{
		return (String) readProperty("configValue");
	}

}
