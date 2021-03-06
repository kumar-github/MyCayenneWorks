package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VCubeAccountInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VCubeAccountInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ACCT_FULL_NAME = new Property<String>("acctFullName");
	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<String> ACCT_SHORT_NAME = new Property<String>("acctShortName");
	public static final Property<String> ACCT_STATUS = new Property<String>("acctStatus");
	public static final Property<String> ACCT_TYPE_CODE = new Property<String>("acctTypeCode");

	public void setAcctFullName(String acctFullName)
	{
		writeProperty("acctFullName", acctFullName);
	}

	public String getAcctFullName()
	{
		return (String) readProperty("acctFullName");
	}

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setAcctShortName(String acctShortName)
	{
		writeProperty("acctShortName", acctShortName);
	}

	public String getAcctShortName()
	{
		return (String) readProperty("acctShortName");
	}

	public void setAcctStatus(String acctStatus)
	{
		writeProperty("acctStatus", acctStatus);
	}

	public String getAcctStatus()
	{
		return (String) readProperty("acctStatus");
	}

	public void setAcctTypeCode(String acctTypeCode)
	{
		writeProperty("acctTypeCode", acctTypeCode);
	}

	public String getAcctTypeCode()
	{
		return (String) readProperty("acctTypeCode");
	}

}
