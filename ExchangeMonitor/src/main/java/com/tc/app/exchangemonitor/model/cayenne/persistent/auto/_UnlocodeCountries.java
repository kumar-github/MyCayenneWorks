package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _UnlocodeCountries was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _UnlocodeCountries extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_COUNTRY_CODE_PK_COLUMN = "fldchrCountryCode";

	public static final Property<String> FLDVCH_COUNTRY_DESC = new Property<String>("fldvchCountryDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFldvchCountryDesc(String fldvchCountryDesc)
	{
		writeProperty("fldvchCountryDesc", fldvchCountryDesc);
	}

	public String getFldvchCountryDesc()
	{
		return (String) readProperty("fldvchCountryDesc");
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
