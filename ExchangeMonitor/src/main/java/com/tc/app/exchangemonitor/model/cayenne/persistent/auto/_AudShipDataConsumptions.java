package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudShipDataConsumptions was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudShipDataConsumptions extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<String> FLDCHR_CMDTY_CODE = new Property<String>("fldchrCmdtyCode");
	public static final Property<String> FLDCHR_CMDTY_UMCODE = new Property<String>("fldchrCmdtyUMCode");
	public static final Property<String> FLDCHR_LLOYDS_REF_NUM = new Property<String>("fldchrLloydsRefNum");
	public static final Property<String> FLDCHR_REC_ID = new Property<String>("fldchrRecId");
	public static final Property<String> FLDCHR_USER_NAME = new Property<String>("fldchrUserName");
	public static final Property<BigDecimal> FLDDEC_CSPT_HEAT = new Property<BigDecimal>("flddecCsptHeat");
	public static final Property<BigDecimal> FLDDEC_CSPT_IGS = new Property<BigDecimal>("flddecCsptIGS");
	public static final Property<BigDecimal> FLDDEC_CSPT_IDLE = new Property<BigDecimal>("flddecCsptIdle");
	public static final Property<BigDecimal> FLDDEC_CSPT_NAVG = new Property<BigDecimal>("flddecCsptNavg");
	public static final Property<BigDecimal> FLDDEC_CSPT_PUMP = new Property<BigDecimal>("flddecCsptPump");
	public static final Property<Date> FLDSDT_TIME_STAMP = new Property<Date>("fldsdtTimeStamp");
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

	public void setFldchrCmdtyCode(String fldchrCmdtyCode)
	{
		writeProperty("fldchrCmdtyCode", fldchrCmdtyCode);
	}

	public String getFldchrCmdtyCode()
	{
		return (String) readProperty("fldchrCmdtyCode");
	}

	public void setFldchrCmdtyUMCode(String fldchrCmdtyUMCode)
	{
		writeProperty("fldchrCmdtyUMCode", fldchrCmdtyUMCode);
	}

	public String getFldchrCmdtyUMCode()
	{
		return (String) readProperty("fldchrCmdtyUMCode");
	}

	public void setFldchrLloydsRefNum(String fldchrLloydsRefNum)
	{
		writeProperty("fldchrLloydsRefNum", fldchrLloydsRefNum);
	}

	public String getFldchrLloydsRefNum()
	{
		return (String) readProperty("fldchrLloydsRefNum");
	}

	public void setFldchrRecId(String fldchrRecId)
	{
		writeProperty("fldchrRecId", fldchrRecId);
	}

	public String getFldchrRecId()
	{
		return (String) readProperty("fldchrRecId");
	}

	public void setFldchrUserName(String fldchrUserName)
	{
		writeProperty("fldchrUserName", fldchrUserName);
	}

	public String getFldchrUserName()
	{
		return (String) readProperty("fldchrUserName");
	}

	public void setFlddecCsptHeat(BigDecimal flddecCsptHeat)
	{
		writeProperty("flddecCsptHeat", flddecCsptHeat);
	}

	public BigDecimal getFlddecCsptHeat()
	{
		return (BigDecimal) readProperty("flddecCsptHeat");
	}

	public void setFlddecCsptIGS(BigDecimal flddecCsptIGS)
	{
		writeProperty("flddecCsptIGS", flddecCsptIGS);
	}

	public BigDecimal getFlddecCsptIGS()
	{
		return (BigDecimal) readProperty("flddecCsptIGS");
	}

	public void setFlddecCsptIdle(BigDecimal flddecCsptIdle)
	{
		writeProperty("flddecCsptIdle", flddecCsptIdle);
	}

	public BigDecimal getFlddecCsptIdle()
	{
		return (BigDecimal) readProperty("flddecCsptIdle");
	}

	public void setFlddecCsptNavg(BigDecimal flddecCsptNavg)
	{
		writeProperty("flddecCsptNavg", flddecCsptNavg);
	}

	public BigDecimal getFlddecCsptNavg()
	{
		return (BigDecimal) readProperty("flddecCsptNavg");
	}

	public void setFlddecCsptPump(BigDecimal flddecCsptPump)
	{
		writeProperty("flddecCsptPump", flddecCsptPump);
	}

	public BigDecimal getFlddecCsptPump()
	{
		return (BigDecimal) readProperty("flddecCsptPump");
	}

	public void setFldsdtTimeStamp(Date fldsdtTimeStamp)
	{
		writeProperty("fldsdtTimeStamp", fldsdtTimeStamp);
	}

	public Date getFldsdtTimeStamp()
	{
		return (Date) readProperty("fldsdtTimeStamp");
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
