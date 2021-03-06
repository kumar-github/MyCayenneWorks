package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudDemurrageEvents was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudDemurrageEvents extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> DEMURRAGE_EVENT = new Property<String>("demurrageEvent");
	public static final Property<Integer> DEMURRAGE_EVENT_ID = new Property<Integer>("demurrageEventId");
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

	public void setDemurrageEvent(String demurrageEvent)
	{
		writeProperty("demurrageEvent", demurrageEvent);
	}

	public String getDemurrageEvent()
	{
		return (String) readProperty("demurrageEvent");
	}

	public void setDemurrageEventId(Integer demurrageEventId)
	{
		writeProperty("demurrageEventId", demurrageEventId);
	}

	public Integer getDemurrageEventId()
	{
		return (Integer) readProperty("demurrageEventId");
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
