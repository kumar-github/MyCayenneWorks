package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CostLotLinks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostLotLinks extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDINT_COST_NUM_PK_COLUMN = "fldintCostNum";

	public static final Property<String> FLDCHR_COST_ACTUAL_FLAG = new Property<String>("fldchrCostActualFlag");
	public static final Property<String> FLDCHR_COST_APPROVAL_FLAG = new Property<String>("fldchrCostApprovalFlag");
	public static final Property<String> FLDCHR_COST_AUTO_FLAG = new Property<String>("fldchrCostAutoFlag");
	public static final Property<String> FLDCHR_LOCT_KEY = new Property<String>("fldchrLoctKey");
	public static final Property<String> FLDCHR_LOT_KEY = new Property<String>("fldchrLotKey");
	public static final Property<String> FLDCHR_OP_ID = new Property<String>("fldchrOpId");
	public static final Property<String> FLDCHR_REF_MONTH = new Property<String>("fldchrRefMonth");
	public static final Property<String> FLDCHR_REF_YEAR = new Property<String>("fldchrRefYear");
	public static final Property<Date> FLDSDT_COST_ACTUAL_DATE = new Property<Date>("fldsdtCostActualDate");
	public static final Property<Date> FLDSDT_COST_APPROVAL_DATE = new Property<Date>("fldsdtCostApprovalDate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setFldchrCostActualFlag(String fldchrCostActualFlag)
	{
		writeProperty("fldchrCostActualFlag", fldchrCostActualFlag);
	}

	public String getFldchrCostActualFlag()
	{
		return (String) readProperty("fldchrCostActualFlag");
	}

	public void setFldchrCostApprovalFlag(String fldchrCostApprovalFlag)
	{
		writeProperty("fldchrCostApprovalFlag", fldchrCostApprovalFlag);
	}

	public String getFldchrCostApprovalFlag()
	{
		return (String) readProperty("fldchrCostApprovalFlag");
	}

	public void setFldchrCostAutoFlag(String fldchrCostAutoFlag)
	{
		writeProperty("fldchrCostAutoFlag", fldchrCostAutoFlag);
	}

	public String getFldchrCostAutoFlag()
	{
		return (String) readProperty("fldchrCostAutoFlag");
	}

	public void setFldchrLoctKey(String fldchrLoctKey)
	{
		writeProperty("fldchrLoctKey", fldchrLoctKey);
	}

	public String getFldchrLoctKey()
	{
		return (String) readProperty("fldchrLoctKey");
	}

	public void setFldchrLotKey(String fldchrLotKey)
	{
		writeProperty("fldchrLotKey", fldchrLotKey);
	}

	public String getFldchrLotKey()
	{
		return (String) readProperty("fldchrLotKey");
	}

	public void setFldchrOpId(String fldchrOpId)
	{
		writeProperty("fldchrOpId", fldchrOpId);
	}

	public String getFldchrOpId()
	{
		return (String) readProperty("fldchrOpId");
	}

	public void setFldchrRefMonth(String fldchrRefMonth)
	{
		writeProperty("fldchrRefMonth", fldchrRefMonth);
	}

	public String getFldchrRefMonth()
	{
		return (String) readProperty("fldchrRefMonth");
	}

	public void setFldchrRefYear(String fldchrRefYear)
	{
		writeProperty("fldchrRefYear", fldchrRefYear);
	}

	public String getFldchrRefYear()
	{
		return (String) readProperty("fldchrRefYear");
	}

	public void setFldsdtCostActualDate(Date fldsdtCostActualDate)
	{
		writeProperty("fldsdtCostActualDate", fldsdtCostActualDate);
	}

	public Date getFldsdtCostActualDate()
	{
		return (Date) readProperty("fldsdtCostActualDate");
	}

	public void setFldsdtCostApprovalDate(Date fldsdtCostApprovalDate)
	{
		writeProperty("fldsdtCostApprovalDate", fldsdtCostApprovalDate);
	}

	public Date getFldsdtCostApprovalDate()
	{
		return (Date) readProperty("fldsdtCostApprovalDate");
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
