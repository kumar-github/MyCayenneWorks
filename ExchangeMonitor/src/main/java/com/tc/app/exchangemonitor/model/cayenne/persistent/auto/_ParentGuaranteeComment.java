package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ParentGuaranteeComment was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ParentGuaranteeComment extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CMNT_NUM_PK_COLUMN = "cmnt_num";
	public static final String PG_NUM_PK_COLUMN = "pg_num";

	public static final Property<String> PG_CMNT_TYPE = new Property<String>("pgCmntType");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setPgCmntType(String pgCmntType)
	{
		writeProperty("pgCmntType", pgCmntType);
	}

	public String getPgCmntType()
	{
		return (String) readProperty("pgCmntType");
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
