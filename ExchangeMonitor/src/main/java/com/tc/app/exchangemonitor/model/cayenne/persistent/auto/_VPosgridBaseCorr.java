package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VPosgridBaseCorr was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VPosgridBaseCorr extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<String> COMMKT = new Property<String>("commkt");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setCommkt(String commkt)
	{
		writeProperty("commkt", commkt);
	}

	public String getCommkt()
	{
		return (String) readProperty("commkt");
	}

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

}
