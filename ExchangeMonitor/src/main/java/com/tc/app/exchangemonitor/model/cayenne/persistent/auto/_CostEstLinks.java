package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CostEstLinks was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostEstLinks extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDINT_COST_NUM_PK_COLUMN = "fldintCostNum";

	public static final Property<String> FLDCHR_COST_AUTO_FLAG = new Property<String>("fldchrCostAutoFlag");
	public static final Property<String> FLDCHR_LLOYDS_REF_NUM = new Property<String>("fldchrLloydsRefNum");
	public static final Property<String> FLDCHR_LOCT_KEY = new Property<String>("fldchrLoctKey");
	public static final Property<String> FLDCHR_LOT_KEY = new Property<String>("fldchrLotKey");
	public static final Property<String> FLDCHR_REF_MONTH = new Property<String>("fldchrRefMonth");
	public static final Property<String> FLDCHR_REF_YEAR = new Property<String>("fldchrRefYear");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

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

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

}
