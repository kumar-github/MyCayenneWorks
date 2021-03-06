package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCreditAlarmLogComment was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCreditAlarmLogComment extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ALARM_LOG_CMNT_NUM = new Property<Integer>("alarmLogCmntNum");
	public static final Property<String> CMNT_TEXT = new Property<String>("cmntText");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAlarmLogCmntNum(Integer alarmLogCmntNum)
	{
		writeProperty("alarmLogCmntNum", alarmLogCmntNum);
	}

	public Integer getAlarmLogCmntNum()
	{
		return (Integer) readProperty("alarmLogCmntNum");
	}

	public void setCmntText(String cmntText)
	{
		writeProperty("cmntText", cmntText);
	}

	public String getCmntText()
	{
		return (String) readProperty("cmntText");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
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
