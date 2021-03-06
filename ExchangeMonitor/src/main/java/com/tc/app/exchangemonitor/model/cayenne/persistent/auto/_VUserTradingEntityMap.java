package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VUserTradingEntityMap was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VUserTradingEntityMap extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> TRADING_ENTITY_FULL_NAME = new Property<String>("tradingEntityFullName");
	public static final Property<String> TRADING_ENTITY_NAME = new Property<String>("tradingEntityName");
	public static final Property<Integer> TRADING_ENTITY_NUM = new Property<Integer>("tradingEntityNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> USER_INIT = new Property<String>("userInit");
	public static final Property<String> USER_LOGON_ID = new Property<String>("userLogonId");

	public void setTradingEntityFullName(String tradingEntityFullName)
	{
		writeProperty("tradingEntityFullName", tradingEntityFullName);
	}

	public String getTradingEntityFullName()
	{
		return (String) readProperty("tradingEntityFullName");
	}

	public void setTradingEntityName(String tradingEntityName)
	{
		writeProperty("tradingEntityName", tradingEntityName);
	}

	public String getTradingEntityName()
	{
		return (String) readProperty("tradingEntityName");
	}

	public void setTradingEntityNum(Integer tradingEntityNum)
	{
		writeProperty("tradingEntityNum", tradingEntityNum);
	}

	public Integer getTradingEntityNum()
	{
		return (Integer) readProperty("tradingEntityNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setUserInit(String userInit)
	{
		writeProperty("userInit", userInit);
	}

	public String getUserInit()
	{
		return (String) readProperty("userInit");
	}

	public void setUserLogonId(String userLogonId)
	{
		writeProperty("userLogonId", userLogonId);
	}

	public String getUserLogonId()
	{
		return (String) readProperty("userLogonId");
	}

}
