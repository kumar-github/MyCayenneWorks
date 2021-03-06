package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCommodityLocation was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCommodityLocation extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<String> CMDTY_DELIVERED_SCHEDULED = new Property<String>("cmdtyDeliveredScheduled");
	public static final Property<String> CMDTY_RECEIVED_SCHEDULED = new Property<String>("cmdtyReceivedScheduled");
	public static final Property<String> LOC_CODE = new Property<String>("locCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Double> TYPICAL_GRAVITY = new Property<Double>("typicalGravity");

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setCmdtyDeliveredScheduled(String cmdtyDeliveredScheduled)
	{
		writeProperty("cmdtyDeliveredScheduled", cmdtyDeliveredScheduled);
	}

	public String getCmdtyDeliveredScheduled()
	{
		return (String) readProperty("cmdtyDeliveredScheduled");
	}

	public void setCmdtyReceivedScheduled(String cmdtyReceivedScheduled)
	{
		writeProperty("cmdtyReceivedScheduled", cmdtyReceivedScheduled);
	}

	public String getCmdtyReceivedScheduled()
	{
		return (String) readProperty("cmdtyReceivedScheduled");
	}

	public void setLocCode(String locCode)
	{
		writeProperty("locCode", locCode);
	}

	public String getLocCode()
	{
		return (String) readProperty("locCode");
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

	public void setTypicalGravity(Double typicalGravity)
	{
		writeProperty("typicalGravity", typicalGravity);
	}

	public Double getTypicalGravity()
	{
		return (Double) readProperty("typicalGravity");
	}

}
