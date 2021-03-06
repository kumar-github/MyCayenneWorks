package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.CreditGroup;
import com.tc.app.exchangemonitor.model.cayenne.persistent.CreditTerm;

/**
 * Class _CreditTermGroup was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CreditTermGroup extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CREDIT_TERM_CODE_PK_COLUMN = "credit_term_code";
	public static final String GROUP_NUM_PK_COLUMN = "group_num";

	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<CreditGroup> CREDIT_GROUP = new Property<CreditGroup>("creditGroup");
	public static final Property<CreditTerm> CREDIT_TERM = new Property<CreditTerm>("creditTerm");

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCreditGroup(CreditGroup creditGroup)
	{
		setToOneTarget("creditGroup", creditGroup, true);
	}

	public CreditGroup getCreditGroup()
	{
		return (CreditGroup) readProperty("creditGroup");
	}

	public void setCreditTerm(CreditTerm creditTerm)
	{
		setToOneTarget("creditTerm", creditTerm, true);
	}

	public CreditTerm getCreditTerm()
	{
		return (CreditTerm) readProperty("creditTerm");
	}

}
