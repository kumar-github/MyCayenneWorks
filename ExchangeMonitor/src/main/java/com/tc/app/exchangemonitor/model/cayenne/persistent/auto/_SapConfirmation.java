package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _SapConfirmation was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SapConfirmation extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String VOUCHER_NUM_PK_COLUMN = "voucher_num";

	public static final Property<String> FILENAME = new Property<String>("filename");
	public static final Property<Date> ICTS_POST_DATETIME = new Property<Date>("ictsPostDatetime");
	public static final Property<String> SAP_DOCUMENT_NUMBER = new Property<String>("sapDocumentNumber");
	public static final Property<Date> SAP_POST_DATETIME = new Property<Date>("sapPostDatetime");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFilename(String filename)
	{
		writeProperty("filename", filename);
	}

	public String getFilename()
	{
		return (String) readProperty("filename");
	}

	public void setIctsPostDatetime(Date ictsPostDatetime)
	{
		writeProperty("ictsPostDatetime", ictsPostDatetime);
	}

	public Date getIctsPostDatetime()
	{
		return (Date) readProperty("ictsPostDatetime");
	}

	public void setSapDocumentNumber(String sapDocumentNumber)
	{
		writeProperty("sapDocumentNumber", sapDocumentNumber);
	}

	public String getSapDocumentNumber()
	{
		return (String) readProperty("sapDocumentNumber");
	}

	public void setSapPostDatetime(Date sapPostDatetime)
	{
		writeProperty("sapPostDatetime", sapPostDatetime);
	}

	public Date getSapPostDatetime()
	{
		return (Date) readProperty("sapPostDatetime");
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
