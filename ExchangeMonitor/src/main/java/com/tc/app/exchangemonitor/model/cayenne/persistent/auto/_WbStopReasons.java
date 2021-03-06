package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.WbOpsOffhire;
import com.tc.app.exchangemonitor.model.cayenne.persistent.WbOpsStoppage;
import com.tc.app.exchangemonitor.model.cayenne.persistent.WbPreStoppage;

/**
 * Class _WbStopReasons was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _WbStopReasons extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_STOP_REASON_ID_PK_COLUMN = "fldchrStopReasonId";

	public static final Property<String> FLDCHR_OFFH_FLAG = new Property<String>("fldchrOffhFlag");
	public static final Property<String> FLDCHR_PHASE_IND = new Property<String>("fldchrPhaseInd");
	public static final Property<String> FLDCHR_STOPPAGE_FLAG = new Property<String>("fldchrStoppageFlag");
	public static final Property<String> FLDVCH_STOP_REASON_DESC = new Property<String>("fldvchStopReasonDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<WbOpsOffhire>> WB_OPS_OFFHIRES = new Property<List<WbOpsOffhire>>("wbOpsOffhires");
	public static final Property<List<WbOpsStoppage>> WB_OPS_STOPPAGES = new Property<List<WbOpsStoppage>>("wbOpsStoppages");
	public static final Property<List<WbPreStoppage>> WB_PRE_STOPPAGES = new Property<List<WbPreStoppage>>("wbPreStoppages");

	public void setFldchrOffhFlag(String fldchrOffhFlag)
	{
		writeProperty("fldchrOffhFlag", fldchrOffhFlag);
	}

	public String getFldchrOffhFlag()
	{
		return (String) readProperty("fldchrOffhFlag");
	}

	public void setFldchrPhaseInd(String fldchrPhaseInd)
	{
		writeProperty("fldchrPhaseInd", fldchrPhaseInd);
	}

	public String getFldchrPhaseInd()
	{
		return (String) readProperty("fldchrPhaseInd");
	}

	public void setFldchrStoppageFlag(String fldchrStoppageFlag)
	{
		writeProperty("fldchrStoppageFlag", fldchrStoppageFlag);
	}

	public String getFldchrStoppageFlag()
	{
		return (String) readProperty("fldchrStoppageFlag");
	}

	public void setFldvchStopReasonDesc(String fldvchStopReasonDesc)
	{
		writeProperty("fldvchStopReasonDesc", fldvchStopReasonDesc);
	}

	public String getFldvchStopReasonDesc()
	{
		return (String) readProperty("fldvchStopReasonDesc");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToWbOpsOffhires(WbOpsOffhire obj)
	{
		addToManyTarget("wbOpsOffhires", obj, true);
	}

	public void removeFromWbOpsOffhires(WbOpsOffhire obj)
	{
		removeToManyTarget("wbOpsOffhires", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<WbOpsOffhire> getWbOpsOffhires()
	{
		return (List<WbOpsOffhire>) readProperty("wbOpsOffhires");
	}

	public void addToWbOpsStoppages(WbOpsStoppage obj)
	{
		addToManyTarget("wbOpsStoppages", obj, true);
	}

	public void removeFromWbOpsStoppages(WbOpsStoppage obj)
	{
		removeToManyTarget("wbOpsStoppages", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<WbOpsStoppage> getWbOpsStoppages()
	{
		return (List<WbOpsStoppage>) readProperty("wbOpsStoppages");
	}

	public void addToWbPreStoppages(WbPreStoppage obj)
	{
		addToManyTarget("wbPreStoppages", obj, true);
	}

	public void removeFromWbPreStoppages(WbPreStoppage obj)
	{
		removeToManyTarget("wbPreStoppages", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<WbPreStoppage> getWbPreStoppages()
	{
		return (List<WbPreStoppage>) readProperty("wbPreStoppages");
	}

}
