package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CargoInspectionTypes was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CargoInspectionTypes extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_INSP_TYPE_ID_PK_COLUMN = "fldchrInspTypeId";

	public static final Property<String> FLDVCH_INSP_TYPE_DESC = new Property<String>("fldvchInspTypeDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFldvchInspTypeDesc(String fldvchInspTypeDesc)
	{
		writeProperty("fldvchInspTypeDesc", fldvchInspTypeDesc);
	}

	public String getFldvchInspTypeDesc()
	{
		return (String) readProperty("fldvchInspTypeDesc");
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
