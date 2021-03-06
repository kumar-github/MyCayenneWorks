package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VMdsPassRestrict was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VMdsPassRestrict extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> LOC_CODE = new Property<String>("locCode");
	public static final Property<String> LOC_ZONE = new Property<String>("locZone");
	public static final Property<Integer> PASS_RESTRICT_TIME = new Property<Integer>("passRestrictTime");
	public static final Property<Integer> TIME_FROM_GMT = new Property<Integer>("timeFromGmt");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> USER_FIRST_NAME = new Property<String>("userFirstName");
	public static final Property<String> USER_JOB_TITLE = new Property<String>("userJobTitle");
	public static final Property<String> USER_LAST_NAME = new Property<String>("userLastName");
	public static final Property<String> USER_LOGON_ID = new Property<String>("userLogonId");
	public static final Property<String> USERNAME = new Property<String>("username");

	public void setLocCode(String locCode)
	{
		writeProperty("locCode", locCode);
	}

	public String getLocCode()
	{
		return (String) readProperty("locCode");
	}

	public void setLocZone(String locZone)
	{
		writeProperty("locZone", locZone);
	}

	public String getLocZone()
	{
		return (String) readProperty("locZone");
	}

	public void setPassRestrictTime(Integer passRestrictTime)
	{
		writeProperty("passRestrictTime", passRestrictTime);
	}

	public Integer getPassRestrictTime()
	{
		return (Integer) readProperty("passRestrictTime");
	}

	public void setTimeFromGmt(Integer timeFromGmt)
	{
		writeProperty("timeFromGmt", timeFromGmt);
	}

	public Integer getTimeFromGmt()
	{
		return (Integer) readProperty("timeFromGmt");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setUserFirstName(String userFirstName)
	{
		writeProperty("userFirstName", userFirstName);
	}

	public String getUserFirstName()
	{
		return (String) readProperty("userFirstName");
	}

	public void setUserJobTitle(String userJobTitle)
	{
		writeProperty("userJobTitle", userJobTitle);
	}

	public String getUserJobTitle()
	{
		return (String) readProperty("userJobTitle");
	}

	public void setUserLastName(String userLastName)
	{
		writeProperty("userLastName", userLastName);
	}

	public String getUserLastName()
	{
		return (String) readProperty("userLastName");
	}

	public void setUserLogonId(String userLogonId)
	{
		writeProperty("userLogonId", userLogonId);
	}

	public String getUserLogonId()
	{
		return (String) readProperty("userLogonId");
	}

	public void setUsername(String username)
	{
		writeProperty("username", username);
	}

	public String getUsername()
	{
		return (String) readProperty("username");
	}

}
