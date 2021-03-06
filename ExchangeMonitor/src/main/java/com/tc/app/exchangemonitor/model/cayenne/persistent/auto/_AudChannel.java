package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudChannel was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudChannel extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_CHANNEL_CODE = new Property<String>("fldchrChannelCode");
	public static final Property<String> FLDCHR_PARENT_CHANNEL_CODE = new Property<String>("fldchrParentChannelCode");
	public static final Property<String> FLDVCH_CHANNEL_DESC = new Property<String>("fldvchChannelDesc");
	public static final Property<String> FLDVCH_CHANNEL_SAP_ALIAS = new Property<String>("fldvchChannelSapAlias");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setFldchrChannelCode(String fldchrChannelCode)
	{
		writeProperty("fldchrChannelCode", fldchrChannelCode);
	}

	public String getFldchrChannelCode()
	{
		return (String) readProperty("fldchrChannelCode");
	}

	public void setFldchrParentChannelCode(String fldchrParentChannelCode)
	{
		writeProperty("fldchrParentChannelCode", fldchrParentChannelCode);
	}

	public String getFldchrParentChannelCode()
	{
		return (String) readProperty("fldchrParentChannelCode");
	}

	public void setFldvchChannelDesc(String fldvchChannelDesc)
	{
		writeProperty("fldvchChannelDesc", fldvchChannelDesc);
	}

	public String getFldvchChannelDesc()
	{
		return (String) readProperty("fldvchChannelDesc");
	}

	public void setFldvchChannelSapAlias(String fldvchChannelSapAlias)
	{
		writeProperty("fldvchChannelSapAlias", fldvchChannelSapAlias);
	}

	public String getFldvchChannelSapAlias()
	{
		return (String) readProperty("fldvchChannelSapAlias");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
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
