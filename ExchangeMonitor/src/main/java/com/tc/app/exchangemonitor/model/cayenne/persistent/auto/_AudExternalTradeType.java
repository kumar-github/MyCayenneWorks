package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudExternalTradeType was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudExternalTradeType extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> EXTERNAL_TRADE_SOURCE_OID = new Property<Integer>("externalTradeSourceOid");
	public static final Property<Integer> OID = new Property<Integer>("oid");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> TRADE_TYPE_CODE = new Property<String>("tradeTypeCode");
	public static final Property<String> TRADE_TYPE_NAME = new Property<String>("tradeTypeName");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setExternalTradeSourceOid(Integer externalTradeSourceOid)
	{
		writeProperty("externalTradeSourceOid", externalTradeSourceOid);
	}

	public Integer getExternalTradeSourceOid()
	{
		return (Integer) readProperty("externalTradeSourceOid");
	}

	public void setOid(Integer oid)
	{
		writeProperty("oid", oid);
	}

	public Integer getOid()
	{
		return (Integer) readProperty("oid");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setTradeTypeCode(String tradeTypeCode)
	{
		writeProperty("tradeTypeCode", tradeTypeCode);
	}

	public String getTradeTypeCode()
	{
		return (String) readProperty("tradeTypeCode");
	}

	public void setTradeTypeName(String tradeTypeName)
	{
		writeProperty("tradeTypeName", tradeTypeName);
	}

	public String getTradeTypeName()
	{
		return (String) readProperty("tradeTypeName");
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
