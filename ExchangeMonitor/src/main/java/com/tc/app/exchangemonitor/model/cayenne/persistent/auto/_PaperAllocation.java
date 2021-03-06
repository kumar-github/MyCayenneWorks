package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;

/**
 * Class _PaperAllocation was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PaperAllocation extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String PAPER_ALLOC_NUM_PK_COLUMN = "paper_alloc_num";

	public static final Property<Double> ALLOC_BROKERAGE_COST = new Property<Double>("allocBrokerageCost");
	public static final Property<Date> ALLOC_DATE = new Property<Date>("allocDate");
	public static final Property<Double> ALLOC_PL = new Property<Double>("allocPl");
	public static final Property<Date> ALLOC_PL_ASOF_DATE = new Property<Date>("allocPlAsofDate");
	public static final Property<Date> ALLOC_PL_CALC_DATE = new Property<Date>("allocPlCalcDate");
	public static final Property<String> PAPER_ALLOC_STATUS = new Property<String>("paperAllocStatus");
	public static final Property<Integer> POS_NUM = new Property<Integer>("posNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");

	public void setAllocBrokerageCost(Double allocBrokerageCost)
	{
		writeProperty("allocBrokerageCost", allocBrokerageCost);
	}

	public Double getAllocBrokerageCost()
	{
		return (Double) readProperty("allocBrokerageCost");
	}

	public void setAllocDate(Date allocDate)
	{
		writeProperty("allocDate", allocDate);
	}

	public Date getAllocDate()
	{
		return (Date) readProperty("allocDate");
	}

	public void setAllocPl(Double allocPl)
	{
		writeProperty("allocPl", allocPl);
	}

	public Double getAllocPl()
	{
		return (Double) readProperty("allocPl");
	}

	public void setAllocPlAsofDate(Date allocPlAsofDate)
	{
		writeProperty("allocPlAsofDate", allocPlAsofDate);
	}

	public Date getAllocPlAsofDate()
	{
		return (Date) readProperty("allocPlAsofDate");
	}

	public void setAllocPlCalcDate(Date allocPlCalcDate)
	{
		writeProperty("allocPlCalcDate", allocPlCalcDate);
	}

	public Date getAllocPlCalcDate()
	{
		return (Date) readProperty("allocPlCalcDate");
	}

	public void setPaperAllocStatus(String paperAllocStatus)
	{
		writeProperty("paperAllocStatus", paperAllocStatus);
	}

	public String getPaperAllocStatus()
	{
		return (String) readProperty("paperAllocStatus");
	}

	public void setPosNum(Integer posNum)
	{
		writeProperty("posNum", posNum);
	}

	public Integer getPosNum()
	{
		return (Integer) readProperty("posNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCommodity(Commodity commodity)
	{
		setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) readProperty("commodity");
	}

}
