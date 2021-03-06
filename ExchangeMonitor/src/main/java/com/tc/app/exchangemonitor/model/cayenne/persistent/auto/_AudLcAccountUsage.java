package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudLcAccountUsage was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudLcAccountUsage extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<String> LC_ACCT_REF = new Property<String>("lcAcctRef");
	public static final Property<String> LC_ACCT_USAGE = new Property<String>("lcAcctUsage");
	public static final Property<Short> LC_ACCT_USAGE_NUM = new Property<Short>("lcAcctUsageNum");
	public static final Property<Integer> LC_NUM = new Property<Integer>("lcNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setLcAcctRef(String lcAcctRef)
	{
		writeProperty("lcAcctRef", lcAcctRef);
	}

	public String getLcAcctRef()
	{
		return (String) readProperty("lcAcctRef");
	}

	public void setLcAcctUsage(String lcAcctUsage)
	{
		writeProperty("lcAcctUsage", lcAcctUsage);
	}

	public String getLcAcctUsage()
	{
		return (String) readProperty("lcAcctUsage");
	}

	public void setLcAcctUsageNum(Short lcAcctUsageNum)
	{
		writeProperty("lcAcctUsageNum", lcAcctUsageNum);
	}

	public Short getLcAcctUsageNum()
	{
		return (Short) readProperty("lcAcctUsageNum");
	}

	public void setLcNum(Integer lcNum)
	{
		writeProperty("lcNum", lcNum);
	}

	public Integer getLcNum()
	{
		return (Integer) readProperty("lcNum");
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
