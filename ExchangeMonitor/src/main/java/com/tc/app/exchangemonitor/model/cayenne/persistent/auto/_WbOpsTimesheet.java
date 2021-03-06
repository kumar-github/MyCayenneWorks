package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.WbOpsPort;
import com.tc.app.exchangemonitor.model.cayenne.persistent.WbTimesheetDetail;
import com.tc.app.exchangemonitor.model.cayenne.persistent.WbTimesheetReasons;

/**
 * Class _WbOpsTimesheet was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _WbOpsTimesheet extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_OP_KEY_PK_COLUMN = "fldchrOpKey";
	public static final String FLDCHR_TSHT_DTL_ID_PK_COLUMN = "fldchrTshtDtlId";

	public static final Property<String> FLDCHR_DETAIL_TIME_ACTUAL_FLAG = new Property<String>("fldchrDetailTimeActualFlag");
	public static final Property<String> FLDCHR_DETAIL_TIME_AUTO_FLAG = new Property<String>("fldchrDetailTimeAutoFlag");
	public static final Property<String> FLDCHR_REC_ID = new Property<String>("fldchrRecId");
	public static final Property<Date> FLDSDT_DETAIL_TIME = new Property<Date>("fldsdtDetailTime");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<WbTimesheetDetail> FLDCHR_TSHT_DTL = new Property<WbTimesheetDetail>("fldchrTshtDtl");
	public static final Property<WbTimesheetReasons> FLDCHR_TSHT_REASON = new Property<WbTimesheetReasons>("fldchrTshtReason");
	public static final Property<WbOpsPort> WB_OPS_PORT = new Property<WbOpsPort>("wbOpsPort");

	public void setFldchrDetailTimeActualFlag(String fldchrDetailTimeActualFlag)
	{
		writeProperty("fldchrDetailTimeActualFlag", fldchrDetailTimeActualFlag);
	}

	public String getFldchrDetailTimeActualFlag()
	{
		return (String) readProperty("fldchrDetailTimeActualFlag");
	}

	public void setFldchrDetailTimeAutoFlag(String fldchrDetailTimeAutoFlag)
	{
		writeProperty("fldchrDetailTimeAutoFlag", fldchrDetailTimeAutoFlag);
	}

	public String getFldchrDetailTimeAutoFlag()
	{
		return (String) readProperty("fldchrDetailTimeAutoFlag");
	}

	public void setFldchrRecId(String fldchrRecId)
	{
		writeProperty("fldchrRecId", fldchrRecId);
	}

	public String getFldchrRecId()
	{
		return (String) readProperty("fldchrRecId");
	}

	public void setFldsdtDetailTime(Date fldsdtDetailTime)
	{
		writeProperty("fldsdtDetailTime", fldsdtDetailTime);
	}

	public Date getFldsdtDetailTime()
	{
		return (Date) readProperty("fldsdtDetailTime");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setFldchrTshtDtl(WbTimesheetDetail fldchrTshtDtl)
	{
		setToOneTarget("fldchrTshtDtl", fldchrTshtDtl, true);
	}

	public WbTimesheetDetail getFldchrTshtDtl()
	{
		return (WbTimesheetDetail) readProperty("fldchrTshtDtl");
	}

	public void setFldchrTshtReason(WbTimesheetReasons fldchrTshtReason)
	{
		setToOneTarget("fldchrTshtReason", fldchrTshtReason, true);
	}

	public WbTimesheetReasons getFldchrTshtReason()
	{
		return (WbTimesheetReasons) readProperty("fldchrTshtReason");
	}

	public void setWbOpsPort(WbOpsPort wbOpsPort)
	{
		setToOneTarget("wbOpsPort", wbOpsPort, true);
	}

	public WbOpsPort getWbOpsPort()
	{
		return (WbOpsPort) readProperty("wbOpsPort");
	}

}
