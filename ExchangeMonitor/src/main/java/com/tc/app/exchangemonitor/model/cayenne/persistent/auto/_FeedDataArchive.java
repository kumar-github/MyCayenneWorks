package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _FeedDataArchive was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FeedDataArchive extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ARCHIVED_DATE_PK_COLUMN = "archived_date";
	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Integer> FEED_ID = new Property<Integer>("feedId");
	public static final Property<Integer> NUMBER_OF_ROWS = new Property<Integer>("numberOfRows");
	public static final Property<Integer> REQUEST_XML_ID = new Property<Integer>("requestXmlId");
	public static final Property<Integer> RESPONSE_XML_ID = new Property<Integer>("responseXmlId");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFeedId(Integer feedId)
	{
		writeProperty("feedId", feedId);
	}

	public Integer getFeedId()
	{
		return (Integer) readProperty("feedId");
	}

	public void setNumberOfRows(Integer numberOfRows)
	{
		writeProperty("numberOfRows", numberOfRows);
	}

	public Integer getNumberOfRows()
	{
		return (Integer) readProperty("numberOfRows");
	}

	public void setRequestXmlId(Integer requestXmlId)
	{
		writeProperty("requestXmlId", requestXmlId);
	}

	public Integer getRequestXmlId()
	{
		return (Integer) readProperty("requestXmlId");
	}

	public void setResponseXmlId(Integer responseXmlId)
	{
		writeProperty("responseXmlId", responseXmlId);
	}

	public Integer getResponseXmlId()
	{
		return (Integer) readProperty("responseXmlId");
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
