package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudAccountInstrType was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudAccountInstrType extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ACCT_INSTR_TYPE_CODE = new Property<String>("acctInstrTypeCode");
	public static final Property<String> ACCT_INSTR_TYPE_DESC = new Property<String>("acctInstrTypeDesc");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAcctInstrTypeCode(String acctInstrTypeCode)
	{
		writeProperty("acctInstrTypeCode", acctInstrTypeCode);
	}

	public String getAcctInstrTypeCode()
	{
		return (String) readProperty("acctInstrTypeCode");
	}

	public void setAcctInstrTypeDesc(String acctInstrTypeDesc)
	{
		writeProperty("acctInstrTypeDesc", acctInstrTypeDesc);
	}

	public String getAcctInstrTypeDesc()
	{
		return (String) readProperty("acctInstrTypeDesc");
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
