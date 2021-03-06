package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SiatbLog was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SiatbLog extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_LOG_YEAR_PK_COLUMN = "fldchrLogYear";
	public static final String FLDCHR_REC_ID_PK_COLUMN = "fldchrRecId";

	public static final Property<String> FLDCHR_LOG_CLASS_CODE = new Property<String>("fldchrLogClassCode");
	public static final Property<String> FLDCHR_LOG_KEY = new Property<String>("fldchrLogKey");
	public static final Property<String> FLDCHR_SESSION_TIME_STAMP = new Property<String>("fldchrSessionTimeStamp");
	public static final Property<Date> FLDSDT_LOG_TIME = new Property<Date>("fldsdtLogTime");
	public static final Property<Date> FLDSDT_TIME_STAMP = new Property<Date>("fldsdtTimeStamp");
	public static final Property<String> FLDVCH_LOG_TEXT = new Property<String>("fldvchLogText");
	public static final Property<String> FLDVCH_LOG_TOPIC = new Property<String>("fldvchLogTopic");
	public static final Property<String> FLDVCH_LOG_USER = new Property<String>("fldvchLogUser");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFldchrLogClassCode(String fldchrLogClassCode)
	{
		writeProperty("fldchrLogClassCode", fldchrLogClassCode);
	}

	public String getFldchrLogClassCode()
	{
		return (String) readProperty("fldchrLogClassCode");
	}

	public void setFldchrLogKey(String fldchrLogKey)
	{
		writeProperty("fldchrLogKey", fldchrLogKey);
	}

	public String getFldchrLogKey()
	{
		return (String) readProperty("fldchrLogKey");
	}

	public void setFldchrSessionTimeStamp(String fldchrSessionTimeStamp)
	{
		writeProperty("fldchrSessionTimeStamp", fldchrSessionTimeStamp);
	}

	public String getFldchrSessionTimeStamp()
	{
		return (String) readProperty("fldchrSessionTimeStamp");
	}

	public void setFldsdtLogTime(Date fldsdtLogTime)
	{
		writeProperty("fldsdtLogTime", fldsdtLogTime);
	}

	public Date getFldsdtLogTime()
	{
		return (Date) readProperty("fldsdtLogTime");
	}

	public void setFldsdtTimeStamp(Date fldsdtTimeStamp)
	{
		writeProperty("fldsdtTimeStamp", fldsdtTimeStamp);
	}

	public Date getFldsdtTimeStamp()
	{
		return (Date) readProperty("fldsdtTimeStamp");
	}

	public void setFldvchLogText(String fldvchLogText)
	{
		writeProperty("fldvchLogText", fldvchLogText);
	}

	public String getFldvchLogText()
	{
		return (String) readProperty("fldvchLogText");
	}

	public void setFldvchLogTopic(String fldvchLogTopic)
	{
		writeProperty("fldvchLogTopic", fldvchLogTopic);
	}

	public String getFldvchLogTopic()
	{
		return (String) readProperty("fldvchLogTopic");
	}

	public void setFldvchLogUser(String fldvchLogUser)
	{
		writeProperty("fldvchLogUser", fldvchLogUser);
	}

	public String getFldvchLogUser()
	{
		return (String) readProperty("fldvchLogUser");
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
