package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieCOMMODITYCurrency was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieCOMMODITYCurrency extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_CRNCY_CODE = new Property<String>("fldchrCrncyCode");
	public static final Property<String> FLDCHR_CRNCY_FULL_NAME = new Property<String>("fldchrCrncyFullName");
	public static final Property<String> FLDCHR_CRNCY_SHORT_NAME = new Property<String>("fldchrCrncyShortName");

	public void setFldchrCrncyCode(String fldchrCrncyCode)
	{
		writeProperty("fldchrCrncyCode", fldchrCrncyCode);
	}

	public String getFldchrCrncyCode()
	{
		return (String) readProperty("fldchrCrncyCode");
	}

	public void setFldchrCrncyFullName(String fldchrCrncyFullName)
	{
		writeProperty("fldchrCrncyFullName", fldchrCrncyFullName);
	}

	public String getFldchrCrncyFullName()
	{
		return (String) readProperty("fldchrCrncyFullName");
	}

	public void setFldchrCrncyShortName(String fldchrCrncyShortName)
	{
		writeProperty("fldchrCrncyShortName", fldchrCrncyShortName);
	}

	public String getFldchrCrncyShortName()
	{
		return (String) readProperty("fldchrCrncyShortName");
	}

}
