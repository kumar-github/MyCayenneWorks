package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieGRIDWbvoxxBreakdown was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieGRIDWbvoxxBreakdown extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_LOT_KEY = new Property<String>("fldchrLotKey");
	public static final Property<String> FLDCHR_OP_DESC = new Property<String>("fldchrOpDesc");
	public static final Property<String> FLDCHR_OP_KEY = new Property<String>("fldchrOpKey");
	public static final Property<String> FLDCHR_OP_SUB_TYPE = new Property<String>("fldchrOpSubType");
	public static final Property<String> FLDCHR_OP_TYPE = new Property<String>("fldchrOpType");
	public static final Property<Date> FLDSDT_OP_END = new Property<Date>("fldsdtOpEnd");
	public static final Property<Date> FLDSDT_OP_START = new Property<Date>("fldsdtOpStart");
	public static final Property<Short> FLDTIN_VOYG_SORT_ORDER = new Property<Short>("fldtinVoygSortOrder");

	public void setFldchrLotKey(String fldchrLotKey)
	{
		writeProperty("fldchrLotKey", fldchrLotKey);
	}

	public String getFldchrLotKey()
	{
		return (String) readProperty("fldchrLotKey");
	}

	public void setFldchrOpDesc(String fldchrOpDesc)
	{
		writeProperty("fldchrOpDesc", fldchrOpDesc);
	}

	public String getFldchrOpDesc()
	{
		return (String) readProperty("fldchrOpDesc");
	}

	public void setFldchrOpKey(String fldchrOpKey)
	{
		writeProperty("fldchrOpKey", fldchrOpKey);
	}

	public String getFldchrOpKey()
	{
		return (String) readProperty("fldchrOpKey");
	}

	public void setFldchrOpSubType(String fldchrOpSubType)
	{
		writeProperty("fldchrOpSubType", fldchrOpSubType);
	}

	public String getFldchrOpSubType()
	{
		return (String) readProperty("fldchrOpSubType");
	}

	public void setFldchrOpType(String fldchrOpType)
	{
		writeProperty("fldchrOpType", fldchrOpType);
	}

	public String getFldchrOpType()
	{
		return (String) readProperty("fldchrOpType");
	}

	public void setFldsdtOpEnd(Date fldsdtOpEnd)
	{
		writeProperty("fldsdtOpEnd", fldsdtOpEnd);
	}

	public Date getFldsdtOpEnd()
	{
		return (Date) readProperty("fldsdtOpEnd");
	}

	public void setFldsdtOpStart(Date fldsdtOpStart)
	{
		writeProperty("fldsdtOpStart", fldsdtOpStart);
	}

	public Date getFldsdtOpStart()
	{
		return (Date) readProperty("fldsdtOpStart");
	}

	public void setFldtinVoygSortOrder(Short fldtinVoygSortOrder)
	{
		writeProperty("fldtinVoygSortOrder", fldtinVoygSortOrder);
	}

	public Short getFldtinVoygSortOrder()
	{
		return (Short) readProperty("fldtinVoygSortOrder");
	}

}
