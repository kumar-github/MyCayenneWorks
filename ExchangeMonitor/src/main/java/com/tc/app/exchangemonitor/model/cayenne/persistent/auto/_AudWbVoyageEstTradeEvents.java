package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudWbVoyageEstTradeEvents was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudWbVoyageEstTradeEvents extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<Integer> FLD_INT_EVENT = new Property<Integer>("fldIntEvent");
	public static final Property<String> FLDCHR_ESTIMATED_PORT_KEY = new Property<String>("fldchrEstimatedPortKey");
	public static final Property<Date> FLDSDT_DATE = new Property<Date>("fldsdtDate");
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

	public void setFldIntEvent(Integer fldIntEvent)
	{
		writeProperty("fldIntEvent", fldIntEvent);
	}

	public Integer getFldIntEvent()
	{
		return (Integer) readProperty("fldIntEvent");
	}

	public void setFldchrEstimatedPortKey(String fldchrEstimatedPortKey)
	{
		writeProperty("fldchrEstimatedPortKey", fldchrEstimatedPortKey);
	}

	public String getFldchrEstimatedPortKey()
	{
		return (String) readProperty("fldchrEstimatedPortKey");
	}

	public void setFldsdtDate(Date fldsdtDate)
	{
		writeProperty("fldsdtDate", fldsdtDate);
	}

	public Date getFldsdtDate()
	{
		return (Date) readProperty("fldsdtDate");
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
