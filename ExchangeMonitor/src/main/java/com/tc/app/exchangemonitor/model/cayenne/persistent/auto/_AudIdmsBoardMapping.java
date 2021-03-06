package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudIdmsBoardMapping was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudIdmsBoardMapping extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> IDMS_NAME = new Property<String>("idmsName");
	public static final Property<String> NEXT_NAME = new Property<String>("nextName");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setIdmsName(String idmsName)
	{
		writeProperty("idmsName", idmsName);
	}

	public String getIdmsName()
	{
		return (String) readProperty("idmsName");
	}

	public void setNextName(String nextName)
	{
		writeProperty("nextName", nextName);
	}

	public String getNextName()
	{
		return (String) readProperty("nextName");
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
