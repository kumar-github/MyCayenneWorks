package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCaptions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCaptions extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_CAPTION_ID = new Property<String>("fldchrCaptionId");
	public static final Property<String> FLDVCH_CONTROL_ID = new Property<String>("fldvchControlId");
	public static final Property<String> FLDVCH_CONTROL_SYMB_NAME = new Property<String>("fldvchControlSymbName");
	public static final Property<String> FLDVCH_ENGLISH_TEXT = new Property<String>("fldvchEnglishText");
	public static final Property<String> FLDVCH_ITALIAN_TEXT = new Property<String>("fldvchItalianText");
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

	public void setFldchrCaptionId(String fldchrCaptionId)
	{
		writeProperty("fldchrCaptionId", fldchrCaptionId);
	}

	public String getFldchrCaptionId()
	{
		return (String) readProperty("fldchrCaptionId");
	}

	public void setFldvchControlId(String fldvchControlId)
	{
		writeProperty("fldvchControlId", fldvchControlId);
	}

	public String getFldvchControlId()
	{
		return (String) readProperty("fldvchControlId");
	}

	public void setFldvchControlSymbName(String fldvchControlSymbName)
	{
		writeProperty("fldvchControlSymbName", fldvchControlSymbName);
	}

	public String getFldvchControlSymbName()
	{
		return (String) readProperty("fldvchControlSymbName");
	}

	public void setFldvchEnglishText(String fldvchEnglishText)
	{
		writeProperty("fldvchEnglishText", fldvchEnglishText);
	}

	public String getFldvchEnglishText()
	{
		return (String) readProperty("fldvchEnglishText");
	}

	public void setFldvchItalianText(String fldvchItalianText)
	{
		writeProperty("fldvchItalianText", fldvchItalianText);
	}

	public String getFldvchItalianText()
	{
		return (String) readProperty("fldvchItalianText");
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
