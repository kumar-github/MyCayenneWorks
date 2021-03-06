package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudDemurrageTypeEvent was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudDemurrageTypeEvent extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<Integer> DEMURRAGE_EVENT = new Property<Integer>("demurrageEvent");
	public static final Property<Integer> DEMURRAGE_ORDER = new Property<Integer>("demurrageOrder");
	public static final Property<Integer> DEMURRAGE_TYPE = new Property<Integer>("demurrageType");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setDemurrageEvent(Integer demurrageEvent)
	{
		writeProperty("demurrageEvent", demurrageEvent);
	}

	public Integer getDemurrageEvent()
	{
		return (Integer) readProperty("demurrageEvent");
	}

	public void setDemurrageOrder(Integer demurrageOrder)
	{
		writeProperty("demurrageOrder", demurrageOrder);
	}

	public Integer getDemurrageOrder()
	{
		return (Integer) readProperty("demurrageOrder");
	}

	public void setDemurrageType(Integer demurrageType)
	{
		writeProperty("demurrageType", demurrageType);
	}

	public Integer getDemurrageType()
	{
		return (Integer) readProperty("demurrageType");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setUserid(String userid)
	{
		writeProperty("userid", userid);
	}

	public String getUserid()
	{
		return (String) readProperty("userid");
	}

}
