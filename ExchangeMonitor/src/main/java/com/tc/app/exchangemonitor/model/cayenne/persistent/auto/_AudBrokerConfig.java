package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudBrokerConfig was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudBrokerConfig extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<Integer> BROKER_GROUP_KEY = new Property<Integer>("brokerGroupKey");
	public static final Property<BigDecimal> CALCULATED = new Property<BigDecimal>("calculated");
	public static final Property<Boolean> CREATE_COST = new Property<Boolean>("createCost");
	public static final Property<String> CURRENCY = new Property<String>("currency");
	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<BigDecimal> LUMPSUM = new Property<BigDecimal>("lumpsum");
	public static final Property<BigDecimal> MAX = new Property<BigDecimal>("max");
	public static final Property<BigDecimal> MIN = new Property<BigDecimal>("min");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<BigDecimal> PERCENTAGE = new Property<BigDecimal>("percentage");
	public static final Property<String> RATE = new Property<String>("rate");
	public static final Property<Integer> RECORD_ID = new Property<Integer>("recordID");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setBrokerGroupKey(Integer brokerGroupKey)
	{
		writeProperty("brokerGroupKey", brokerGroupKey);
	}

	public Integer getBrokerGroupKey()
	{
		return (Integer) readProperty("brokerGroupKey");
	}

	public void setCalculated(BigDecimal calculated)
	{
		writeProperty("calculated", calculated);
	}

	public BigDecimal getCalculated()
	{
		return (BigDecimal) readProperty("calculated");
	}

	public void setCreateCost(Boolean createCost)
	{
		writeProperty("createCost", createCost);
	}

	public Boolean getCreateCost()
	{
		return (Boolean) readProperty("createCost");
	}

	public void setCurrency(String currency)
	{
		writeProperty("currency", currency);
	}

	public String getCurrency()
	{
		return (String) readProperty("currency");
	}

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setLumpsum(BigDecimal lumpsum)
	{
		writeProperty("lumpsum", lumpsum);
	}

	public BigDecimal getLumpsum()
	{
		return (BigDecimal) readProperty("lumpsum");
	}

	public void setMax(BigDecimal max)
	{
		writeProperty("max", max);
	}

	public BigDecimal getMax()
	{
		return (BigDecimal) readProperty("max");
	}

	public void setMin(BigDecimal min)
	{
		writeProperty("min", min);
	}

	public BigDecimal getMin()
	{
		return (BigDecimal) readProperty("min");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setPercentage(BigDecimal percentage)
	{
		writeProperty("percentage", percentage);
	}

	public BigDecimal getPercentage()
	{
		return (BigDecimal) readProperty("percentage");
	}

	public void setRate(String rate)
	{
		writeProperty("rate", rate);
	}

	public String getRate()
	{
		return (String) readProperty("rate");
	}

	public void setRecordID(Integer recordID)
	{
		writeProperty("recordID", recordID);
	}

	public Integer getRecordID()
	{
		return (Integer) readProperty("recordID");
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
