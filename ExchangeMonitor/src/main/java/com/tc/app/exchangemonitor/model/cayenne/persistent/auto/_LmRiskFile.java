package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _LmRiskFile was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _LmRiskFile extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> EXCH_CODE = new Property<String>("exchCode");
	public static final Property<Date> RISK_FILE_DATE = new Property<Date>("riskFileDate");
	public static final Property<String> RISK_FILE_STATUS = new Property<String>("riskFileStatus");
	public static final Property<String> RISK_FILENAME = new Property<String>("riskFilename");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setExchCode(String exchCode)
	{
		writeProperty("exchCode", exchCode);
	}

	public String getExchCode()
	{
		return (String) readProperty("exchCode");
	}

	public void setRiskFileDate(Date riskFileDate)
	{
		writeProperty("riskFileDate", riskFileDate);
	}

	public Date getRiskFileDate()
	{
		return (Date) readProperty("riskFileDate");
	}

	public void setRiskFileStatus(String riskFileStatus)
	{
		writeProperty("riskFileStatus", riskFileStatus);
	}

	public String getRiskFileStatus()
	{
		return (String) readProperty("riskFileStatus");
	}

	public void setRiskFilename(String riskFilename)
	{
		writeProperty("riskFilename", riskFilename);
	}

	public String getRiskFilename()
	{
		return (String) readProperty("riskFilename");
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
