package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _DocGenAudit was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DocGenAudit extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String AUDIT_ID_PK_COLUMN = "audit_id";

	public static final Property<String> AUDIT_GUID = new Property<String>("auditGuid");
	public static final Property<String> PROCESS_NAME = new Property<String>("processName");
	public static final Property<String> PROCESS_STEP = new Property<String>("processStep");
	public static final Property<Integer> THREAD_ID = new Property<Integer>("threadId");
	public static final Property<Date> TIME_STAMP = new Property<Date>("timeStamp");

	public void setAuditGuid(String auditGuid)
	{
		writeProperty("auditGuid", auditGuid);
	}

	public String getAuditGuid()
	{
		return (String) readProperty("auditGuid");
	}

	public void setProcessName(String processName)
	{
		writeProperty("processName", processName);
	}

	public String getProcessName()
	{
		return (String) readProperty("processName");
	}

	public void setProcessStep(String processStep)
	{
		writeProperty("processStep", processStep);
	}

	public String getProcessStep()
	{
		return (String) readProperty("processStep");
	}

	public void setThreadId(Integer threadId)
	{
		writeProperty("threadId", threadId);
	}

	public Integer getThreadId()
	{
		return (Integer) readProperty("threadId");
	}

	public void setTimeStamp(Date timeStamp)
	{
		writeProperty("timeStamp", timeStamp);
	}

	public Date getTimeStamp()
	{
		return (Date) readProperty("timeStamp");
	}

}
