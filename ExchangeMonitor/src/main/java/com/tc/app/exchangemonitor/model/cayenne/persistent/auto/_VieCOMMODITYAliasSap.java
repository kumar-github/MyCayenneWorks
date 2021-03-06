package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieCOMMODITYAliasSap was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieCOMMODITYAliasSap extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_CMDTY_CODE = new Property<String>("fldchrCmdtyCode");
	public static final Property<String> FLDVCH_CMDTY_CODE_SAP_ALIAS = new Property<String>("fldvchCmdtyCodeSapAlias");

	public void setFldchrCmdtyCode(String fldchrCmdtyCode)
	{
		writeProperty("fldchrCmdtyCode", fldchrCmdtyCode);
	}

	public String getFldchrCmdtyCode()
	{
		return (String) readProperty("fldchrCmdtyCode");
	}

	public void setFldvchCmdtyCodeSapAlias(String fldvchCmdtyCodeSapAlias)
	{
		writeProperty("fldvchCmdtyCodeSapAlias", fldvchCmdtyCodeSapAlias);
	}

	public String getFldvchCmdtyCodeSapAlias()
	{
		return (String) readProperty("fldvchCmdtyCodeSapAlias");
	}

}
