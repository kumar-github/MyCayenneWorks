package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudWbContractCoaVessel was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudWbContractCoaVessel extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_CONTR_KEY = new Property<String>("fldchrContrKey");
	public static final Property<String> FLDCHR_LLOYDS_REF_NUM = new Property<String>("fldchrLloydsRefNum");
	public static final Property<BigDecimal> FLDINT_REC_ID = new Property<BigDecimal>("fldintRecId");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setFldchrContrKey(String fldchrContrKey)
	{
		writeProperty("fldchrContrKey", fldchrContrKey);
	}

	public String getFldchrContrKey()
	{
		return (String) readProperty("fldchrContrKey");
	}

	public void setFldchrLloydsRefNum(String fldchrLloydsRefNum)
	{
		writeProperty("fldchrLloydsRefNum", fldchrLloydsRefNum);
	}

	public String getFldchrLloydsRefNum()
	{
		return (String) readProperty("fldchrLloydsRefNum");
	}

	public void setFldintRecId(BigDecimal fldintRecId)
	{
		writeProperty("fldintRecId", fldintRecId);
	}

	public BigDecimal getFldintRecId()
	{
		return (BigDecimal) readProperty("fldintRecId");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
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
