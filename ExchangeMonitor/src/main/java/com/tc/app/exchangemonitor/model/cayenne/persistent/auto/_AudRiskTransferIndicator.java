package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudRiskTransferIndicator was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudRiskTransferIndicator extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> RISK_TRANSFER_IND_CODE = new Property<String>("riskTransferIndCode");
	public static final Property<String> RISK_TRANSFER_IND_DESC = new Property<String>("riskTransferIndDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setRiskTransferIndCode(String riskTransferIndCode)
	{
		writeProperty("riskTransferIndCode", riskTransferIndCode);
	}

	public String getRiskTransferIndCode()
	{
		return (String) readProperty("riskTransferIndCode");
	}

	public void setRiskTransferIndDesc(String riskTransferIndDesc)
	{
		writeProperty("riskTransferIndDesc", riskTransferIndDesc);
	}

	public String getRiskTransferIndDesc()
	{
		return (String) readProperty("riskTransferIndDesc");
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
