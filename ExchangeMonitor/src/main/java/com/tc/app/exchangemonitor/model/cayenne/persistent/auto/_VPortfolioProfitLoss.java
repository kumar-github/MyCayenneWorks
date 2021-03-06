package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VPortfolioProfitLoss was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VPortfolioProfitLoss extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> PL_ASOF_DATE = new Property<Date>("plAsofDate");
	public static final Property<Integer> REAL_PORT_NUM = new Property<Integer>("realPortNum");
	public static final Property<Double> SUMMARY_PL_AMT = new Property<Double>("summaryPlAmt");
	public static final Property<BigDecimal> TOTAL_PL_NO_SEC_COST = new Property<BigDecimal>("totalPlNoSecCost");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setPlAsofDate(Date plAsofDate)
	{
		writeProperty("plAsofDate", plAsofDate);
	}

	public Date getPlAsofDate()
	{
		return (Date) readProperty("plAsofDate");
	}

	public void setRealPortNum(Integer realPortNum)
	{
		writeProperty("realPortNum", realPortNum);
	}

	public Integer getRealPortNum()
	{
		return (Integer) readProperty("realPortNum");
	}

	public void setSummaryPlAmt(Double summaryPlAmt)
	{
		writeProperty("summaryPlAmt", summaryPlAmt);
	}

	public Double getSummaryPlAmt()
	{
		return (Double) readProperty("summaryPlAmt");
	}

	public void setTotalPlNoSecCost(BigDecimal totalPlNoSecCost)
	{
		writeProperty("totalPlNoSecCost", totalPlNoSecCost);
	}

	public BigDecimal getTotalPlNoSecCost()
	{
		return (BigDecimal) readProperty("totalPlNoSecCost");
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
