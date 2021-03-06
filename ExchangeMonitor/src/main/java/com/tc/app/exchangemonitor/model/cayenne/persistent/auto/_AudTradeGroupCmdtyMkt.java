package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudTradeGroupCmdtyMkt was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudTradeGroupCmdtyMkt extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<String> TRADE_EXCLUSION_IND = new Property<String>("tradeExclusionInd");
	public static final Property<Integer> TRADE_GROUP_NUM = new Property<Integer>("tradeGroupNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setStatus(String status)
	{
		writeProperty("status", status);
	}

	public String getStatus()
	{
		return (String) readProperty("status");
	}

	public void setTradeExclusionInd(String tradeExclusionInd)
	{
		writeProperty("tradeExclusionInd", tradeExclusionInd);
	}

	public String getTradeExclusionInd()
	{
		return (String) readProperty("tradeExclusionInd");
	}

	public void setTradeGroupNum(Integer tradeGroupNum)
	{
		writeProperty("tradeGroupNum", tradeGroupNum);
	}

	public Integer getTradeGroupNum()
	{
		return (Integer) readProperty("tradeGroupNum");
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
