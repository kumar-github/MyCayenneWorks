package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _FeedDetailDataArchive was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FeedDetailDataArchive extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ARCHIVED_DATE_PK_COLUMN = "archived_date";
	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Date> ETL_TIMESTAMP = new Property<Date>("etlTimestamp");
	public static final Property<Integer> FEED_DATA_ID = new Property<Integer>("feedDataId");
	public static final Property<Integer> REQUEST_XML_ID = new Property<Integer>("requestXmlId");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setEtlTimestamp(Date etlTimestamp)
	{
		writeProperty("etlTimestamp", etlTimestamp);
	}

	public Date getEtlTimestamp()
	{
		return (Date) readProperty("etlTimestamp");
	}

	public void setFeedDataId(Integer feedDataId)
	{
		writeProperty("feedDataId", feedDataId);
	}

	public Integer getFeedDataId()
	{
		return (Integer) readProperty("feedDataId");
	}

	public void setRequestXmlId(Integer requestXmlId)
	{
		writeProperty("requestXmlId", requestXmlId);
	}

	public Integer getRequestXmlId()
	{
		return (Integer) readProperty("requestXmlId");
	}

	public void setStatus(String status)
	{
		writeProperty("status", status);
	}

	public String getStatus()
	{
		return (String) readProperty("status");
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
