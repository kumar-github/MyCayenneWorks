package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VRiskCommodityGroup was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VRiskCommodityGroup extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<String> CMDTY_SHORT_NAME = new Property<String>("cmdtyShortName");
	public static final Property<String> PARENT_CMDTY_CODE = new Property<String>("parentCmdtyCode");
	public static final Property<String> PARENT_CMDTY_SHORT_NAME = new Property<String>("parentCmdtyShortName");

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setCmdtyShortName(String cmdtyShortName)
	{
		writeProperty("cmdtyShortName", cmdtyShortName);
	}

	public String getCmdtyShortName()
	{
		return (String) readProperty("cmdtyShortName");
	}

	public void setParentCmdtyCode(String parentCmdtyCode)
	{
		writeProperty("parentCmdtyCode", parentCmdtyCode);
	}

	public String getParentCmdtyCode()
	{
		return (String) readProperty("parentCmdtyCode");
	}

	public void setParentCmdtyShortName(String parentCmdtyShortName)
	{
		writeProperty("parentCmdtyShortName", parentCmdtyShortName);
	}

	public String getParentCmdtyShortName()
	{
		return (String) readProperty("parentCmdtyShortName");
	}

}
