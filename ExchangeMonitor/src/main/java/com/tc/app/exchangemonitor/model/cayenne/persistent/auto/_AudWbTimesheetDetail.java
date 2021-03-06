package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudWbTimesheetDetail was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudWbTimesheetDetail extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_OPS_CARGO_FLAG = new Property<String>("fldchrOpsCargoFlag");
	public static final Property<String> FLDCHR_OPS_NAVG_FLAG = new Property<String>("fldchrOpsNavgFlag");
	public static final Property<String> FLDCHR_OPS_PORT_FLAG = new Property<String>("fldchrOpsPortFlag");
	public static final Property<String> FLDCHR_TSHT_DTL_ID = new Property<String>("fldchrTshtDtlId");
	public static final Property<Short> FLDSMI_SORT_ORDER = new Property<Short>("fldsmiSortOrder");
	public static final Property<String> FLDVCH_TSHT_DTL_DESC = new Property<String>("fldvchTshtDtlDesc");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setFldchrOpsCargoFlag(String fldchrOpsCargoFlag)
	{
		writeProperty("fldchrOpsCargoFlag", fldchrOpsCargoFlag);
	}

	public String getFldchrOpsCargoFlag()
	{
		return (String) readProperty("fldchrOpsCargoFlag");
	}

	public void setFldchrOpsNavgFlag(String fldchrOpsNavgFlag)
	{
		writeProperty("fldchrOpsNavgFlag", fldchrOpsNavgFlag);
	}

	public String getFldchrOpsNavgFlag()
	{
		return (String) readProperty("fldchrOpsNavgFlag");
	}

	public void setFldchrOpsPortFlag(String fldchrOpsPortFlag)
	{
		writeProperty("fldchrOpsPortFlag", fldchrOpsPortFlag);
	}

	public String getFldchrOpsPortFlag()
	{
		return (String) readProperty("fldchrOpsPortFlag");
	}

	public void setFldchrTshtDtlId(String fldchrTshtDtlId)
	{
		writeProperty("fldchrTshtDtlId", fldchrTshtDtlId);
	}

	public String getFldchrTshtDtlId()
	{
		return (String) readProperty("fldchrTshtDtlId");
	}

	public void setFldsmiSortOrder(Short fldsmiSortOrder)
	{
		writeProperty("fldsmiSortOrder", fldsmiSortOrder);
	}

	public Short getFldsmiSortOrder()
	{
		return (Short) readProperty("fldsmiSortOrder");
	}

	public void setFldvchTshtDtlDesc(String fldvchTshtDtlDesc)
	{
		writeProperty("fldvchTshtDtlDesc", fldvchTshtDtlDesc);
	}

	public String getFldvchTshtDtlDesc()
	{
		return (String) readProperty("fldvchTshtDtlDesc");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
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
