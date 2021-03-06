package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudProvider was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudProvider extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_REC_ID = new Property<String>("fldchrRecId");
	public static final Property<String> FLDVCH_PROVIDER_CODE = new Property<String>("fldvchProviderCode");
	public static final Property<String> FLDVCH_PROVIDER_DESC = new Property<String>("fldvchProviderDesc");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setFldchrRecId(String fldchrRecId)
	{
		writeProperty("fldchrRecId", fldchrRecId);
	}

	public String getFldchrRecId()
	{
		return (String) readProperty("fldchrRecId");
	}

	public void setFldvchProviderCode(String fldvchProviderCode)
	{
		writeProperty("fldvchProviderCode", fldvchProviderCode);
	}

	public String getFldvchProviderCode()
	{
		return (String) readProperty("fldvchProviderCode");
	}

	public void setFldvchProviderDesc(String fldvchProviderDesc)
	{
		writeProperty("fldvchProviderDesc", fldvchProviderDesc);
	}

	public String getFldvchProviderDesc()
	{
		return (String) readProperty("fldvchProviderDesc");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setUserid(String userid)
	{
		writeProperty("userid", userid);
	}

	public String getUserid()
	{
		return (String) readProperty("userid");
	}

}
