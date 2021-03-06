package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.CounterTypes;

/**
 * Class _CounterEntityLinks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CounterEntityLinks extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_ENTITY_ALIAS_PK_COLUMN = "fldchrEntityAlias";

	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<CounterTypes> FLDCHR_COUNTER = new Property<CounterTypes>("fldchrCounter");

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setFldchrCounter(CounterTypes fldchrCounter)
	{
		setToOneTarget("fldchrCounter", fldchrCounter, true);
	}

	public CounterTypes getFldchrCounter()
	{
		return (CounterTypes) readProperty("fldchrCounter");
	}

}
