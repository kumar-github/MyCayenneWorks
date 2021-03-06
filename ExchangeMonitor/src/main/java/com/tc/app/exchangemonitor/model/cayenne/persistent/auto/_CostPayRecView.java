package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CostPayRecView was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostPayRecView extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> COST_PAY_REC_IND = new Property<String>("costPayRecInd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setCostPayRecInd(String costPayRecInd)
	{
		writeProperty("costPayRecInd", costPayRecInd);
	}

	public String getCostPayRecInd()
	{
		return (String) readProperty("costPayRecInd");
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
