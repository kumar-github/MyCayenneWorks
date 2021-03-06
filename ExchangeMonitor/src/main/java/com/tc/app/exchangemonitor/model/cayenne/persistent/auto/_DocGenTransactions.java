package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _DocGenTransactions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DocGenTransactions extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String PROCESS_NAME_PK_COLUMN = "process_name";

	public static final Property<Integer> LAST_TRANS_ID = new Property<Integer>("lastTransId");

	public void setLastTransId(Integer lastTransId)
	{
		writeProperty("lastTransId", lastTransId);
	}

	public Integer getLastTransId()
	{
		return (Integer) readProperty("lastTransId");
	}

}
