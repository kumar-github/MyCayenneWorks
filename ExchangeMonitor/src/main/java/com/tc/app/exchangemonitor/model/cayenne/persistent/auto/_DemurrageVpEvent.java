package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _DemurrageVpEvent was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DemurrageVpEvent extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String DEMURRAGE_KEY_PK_COLUMN = "DemurrageKey";
	public static final String EVENT_ORDER_PK_COLUMN = "EventOrder";
	public static final String PORT_KEY_PK_COLUMN = "PortKey";
	public static final String PORT_ORDER_PK_COLUMN = "PortOrder";

	public static final Property<String> COMMENTS = new Property<String>("comments");
	public static final Property<Date> END_DATE = new Property<Date>("endDate");
	public static final Property<Integer> EVENT_ID = new Property<Integer>("eventId");
	public static final Property<Date> START_DATE = new Property<Date>("startDate");

	public void setComments(String comments)
	{
		writeProperty("comments", comments);
	}

	public String getComments()
	{
		return (String) readProperty("comments");
	}

	public void setEndDate(Date endDate)
	{
		writeProperty("endDate", endDate);
	}

	public Date getEndDate()
	{
		return (Date) readProperty("endDate");
	}

	public void setEventId(Integer eventId)
	{
		writeProperty("eventId", eventId);
	}

	public Integer getEventId()
	{
		return (Integer) readProperty("eventId");
	}

	public void setStartDate(Date startDate)
	{
		writeProperty("startDate", startDate);
	}

	public Date getStartDate()
	{
		return (Date) readProperty("startDate");
	}

}
