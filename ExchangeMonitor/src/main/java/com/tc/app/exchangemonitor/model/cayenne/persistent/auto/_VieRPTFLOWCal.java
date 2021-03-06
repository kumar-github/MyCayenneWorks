package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieRPTFLOWCal was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieRPTFLOWCal extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_CHANNEL_CODE = new Property<String>("fldchrChannelCode");
	public static final Property<String> FLDCHR_CMDTY_FULL_NAME = new Property<String>("fldchrCmdtyFullName");
	public static final Property<String> FLDCHR_CMDTY_UMCODE = new Property<String>("fldchrCmdtyUMCode");
	public static final Property<String> FLDCHR_MONTH = new Property<String>("fldchrMonth");
	public static final Property<String> FLDCHR_VOYG_TYPE_FLAG = new Property<String>("fldchrVoygTypeFlag");
	public static final Property<String> FLDCHR_YEAR = new Property<String>("fldchrYear");
	public static final Property<BigDecimal> FLDDEC_CMDTY_QTY = new Property<BigDecimal>("flddecCmdtyQty");
	public static final Property<Date> FLDSDT_LCAN_END = new Property<Date>("fldsdtLcanEnd");
	public static final Property<Date> FLDSDT_LCAN_START = new Property<Date>("fldsdtLcanStart");
	public static final Property<String> FLDVCH_CHANNEL_DESC = new Property<String>("fldvchChannelDesc");
	public static final Property<String> FLDVCH_DEST_STORAGE_DESC = new Property<String>("fldvchDestStorageDesc");
	public static final Property<String> FLDVCH_ORIG_STORAGE_DESC = new Property<String>("fldvchOrigStorageDesc");
	public static final Property<String> FLDVCH_RECV_DESC = new Property<String>("fldvchRecvDesc");
	public static final Property<String> FLDVCH_SHPR_DESC = new Property<String>("fldvchShprDesc");

	public void setFldchrChannelCode(String fldchrChannelCode)
	{
		writeProperty("fldchrChannelCode", fldchrChannelCode);
	}

	public String getFldchrChannelCode()
	{
		return (String) readProperty("fldchrChannelCode");
	}

	public void setFldchrCmdtyFullName(String fldchrCmdtyFullName)
	{
		writeProperty("fldchrCmdtyFullName", fldchrCmdtyFullName);
	}

	public String getFldchrCmdtyFullName()
	{
		return (String) readProperty("fldchrCmdtyFullName");
	}

	public void setFldchrCmdtyUMCode(String fldchrCmdtyUMCode)
	{
		writeProperty("fldchrCmdtyUMCode", fldchrCmdtyUMCode);
	}

	public String getFldchrCmdtyUMCode()
	{
		return (String) readProperty("fldchrCmdtyUMCode");
	}

	public void setFldchrMonth(String fldchrMonth)
	{
		writeProperty("fldchrMonth", fldchrMonth);
	}

	public String getFldchrMonth()
	{
		return (String) readProperty("fldchrMonth");
	}

	public void setFldchrVoygTypeFlag(String fldchrVoygTypeFlag)
	{
		writeProperty("fldchrVoygTypeFlag", fldchrVoygTypeFlag);
	}

	public String getFldchrVoygTypeFlag()
	{
		return (String) readProperty("fldchrVoygTypeFlag");
	}

	public void setFldchrYear(String fldchrYear)
	{
		writeProperty("fldchrYear", fldchrYear);
	}

	public String getFldchrYear()
	{
		return (String) readProperty("fldchrYear");
	}

	public void setFlddecCmdtyQty(BigDecimal flddecCmdtyQty)
	{
		writeProperty("flddecCmdtyQty", flddecCmdtyQty);
	}

	public BigDecimal getFlddecCmdtyQty()
	{
		return (BigDecimal) readProperty("flddecCmdtyQty");
	}

	public void setFldsdtLcanEnd(Date fldsdtLcanEnd)
	{
		writeProperty("fldsdtLcanEnd", fldsdtLcanEnd);
	}

	public Date getFldsdtLcanEnd()
	{
		return (Date) readProperty("fldsdtLcanEnd");
	}

	public void setFldsdtLcanStart(Date fldsdtLcanStart)
	{
		writeProperty("fldsdtLcanStart", fldsdtLcanStart);
	}

	public Date getFldsdtLcanStart()
	{
		return (Date) readProperty("fldsdtLcanStart");
	}

	public void setFldvchChannelDesc(String fldvchChannelDesc)
	{
		writeProperty("fldvchChannelDesc", fldvchChannelDesc);
	}

	public String getFldvchChannelDesc()
	{
		return (String) readProperty("fldvchChannelDesc");
	}

	public void setFldvchDestStorageDesc(String fldvchDestStorageDesc)
	{
		writeProperty("fldvchDestStorageDesc", fldvchDestStorageDesc);
	}

	public String getFldvchDestStorageDesc()
	{
		return (String) readProperty("fldvchDestStorageDesc");
	}

	public void setFldvchOrigStorageDesc(String fldvchOrigStorageDesc)
	{
		writeProperty("fldvchOrigStorageDesc", fldvchOrigStorageDesc);
	}

	public String getFldvchOrigStorageDesc()
	{
		return (String) readProperty("fldvchOrigStorageDesc");
	}

	public void setFldvchRecvDesc(String fldvchRecvDesc)
	{
		writeProperty("fldvchRecvDesc", fldvchRecvDesc);
	}

	public String getFldvchRecvDesc()
	{
		return (String) readProperty("fldvchRecvDesc");
	}

	public void setFldvchShprDesc(String fldvchShprDesc)
	{
		writeProperty("fldvchShprDesc", fldvchShprDesc);
	}

	public String getFldvchShprDesc()
	{
		return (String) readProperty("fldvchShprDesc");
	}

}
