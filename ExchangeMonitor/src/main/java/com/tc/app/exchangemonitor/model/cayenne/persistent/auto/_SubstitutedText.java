package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SubstitutedText was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SubstitutedText extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ALIAS_SOURCE_NAME_PK_COLUMN = "alias_source_name";
	public static final String KEYWORD_PK_COLUMN = "keyword";

	public static final Property<String> SUBSTITUTED_STRING = new Property<String>("substitutedString");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setSubstitutedString(String substitutedString)
	{
		writeProperty("substitutedString", substitutedString);
	}

	public String getSubstitutedString()
	{
		return (String) readProperty("substitutedString");
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
