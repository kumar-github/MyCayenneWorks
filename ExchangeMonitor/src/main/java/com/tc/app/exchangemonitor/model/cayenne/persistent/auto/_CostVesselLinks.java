package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Cost;

/**
 * Class _CostVesselLinks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostVesselLinks extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDINT_COST_NUM_PK_COLUMN = "fldintCostNum";

	public static final Property<String> FLDCHR_CONTR_KEY = new Property<String>("fldchrContrKey");
	public static final Property<String> FLDCHR_COST_ACTUAL_FLAG = new Property<String>("fldchrCostActualFlag");
	public static final Property<String> FLDCHR_COST_APPROVAL_FLAG = new Property<String>("fldchrCostApprovalFlag");
	public static final Property<String> FLDCHR_COST_AUTO_FLAG = new Property<String>("fldchrCostAutoFlag");
	public static final Property<String> FLDCHR_LLOYDS_REF_NUM = new Property<String>("fldchrLloydsRefNum");
	public static final Property<String> FLDCHR_REF_MONTH = new Property<String>("fldchrRefMonth");
	public static final Property<String> FLDCHR_REF_YEAR = new Property<String>("fldchrRefYear");
	public static final Property<Date> FLDSDT_COST_ACTUAL_DATE = new Property<Date>("fldsdtCostActualDate");
	public static final Property<Date> FLDSDT_COST_APPROVAL_DATE = new Property<Date>("fldsdtCostApprovalDate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Cost> COST = new Property<Cost>("cost");

	public void setFldchrContrKey(String fldchrContrKey)
	{
		writeProperty("fldchrContrKey", fldchrContrKey);
	}

	public String getFldchrContrKey()
	{
		return (String) readProperty("fldchrContrKey");
	}

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

	public void setFldchrLloydsRefNum(String fldchrLloydsRefNum)
	{
		writeProperty("fldchrLloydsRefNum", fldchrLloydsRefNum);
	}

	public String getFldchrLloydsRefNum()
	{
		return (String) readProperty("fldchrLloydsRefNum");
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

	public void setCost(Cost cost)
	{
		setToOneTarget("cost", cost, true);
	}

	public Cost getCost()
	{
		return (Cost) readProperty("cost");
	}

}
