package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _BulkVoucherQueue was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _BulkVoucherQueue extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> ACTION_TYPE = new Property<String>("actionType");
	public static final Property<Date> CREATION_DATE = new Property<Date>("creationDate");
	public static final Property<String> MISC_COL = new Property<String>("miscCol");
	public static final Property<Integer> VOUCHER_NUM = new Property<Integer>("voucherNum");

	public void setActionType(String actionType)
	{
		writeProperty("actionType", actionType);
	}

	public String getActionType()
	{
		return (String) readProperty("actionType");
	}

	public void setCreationDate(Date creationDate)
	{
		writeProperty("creationDate", creationDate);
	}

	public Date getCreationDate()
	{
		return (Date) readProperty("creationDate");
	}

	public void setMiscCol(String miscCol)
	{
		writeProperty("miscCol", miscCol);
	}

	public String getMiscCol()
	{
		return (String) readProperty("miscCol");
	}

	public void setVoucherNum(Integer voucherNum)
	{
		writeProperty("voucherNum", voucherNum);
	}

	public Integer getVoucherNum()
	{
		return (Integer) readProperty("voucherNum");
	}

}
