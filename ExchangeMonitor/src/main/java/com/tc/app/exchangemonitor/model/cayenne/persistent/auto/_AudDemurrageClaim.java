package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudDemurrageClaim was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudDemurrageClaim extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> COST_NUMBER = new Property<Integer>("costNumber");
	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<Integer> DEMURRAGE_KEY = new Property<Integer>("demurrageKey");
	public static final Property<BigDecimal> ESTIMATED = new Property<BigDecimal>("estimated");
	public static final Property<BigDecimal> EXPECTED = new Property<BigDecimal>("expected");
	public static final Property<BigDecimal> FINAL = new Property<BigDecimal>("final");
	public static final Property<BigDecimal> OFFERED = new Property<BigDecimal>("offered");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<BigDecimal> REQUESTED = new Property<BigDecimal>("requested");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setCostNumber(Integer costNumber)
	{
		writeProperty("costNumber", costNumber);
	}

	public Integer getCostNumber()
	{
		return (Integer) readProperty("costNumber");
	}

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setDemurrageKey(Integer demurrageKey)
	{
		writeProperty("demurrageKey", demurrageKey);
	}

	public Integer getDemurrageKey()
	{
		return (Integer) readProperty("demurrageKey");
	}

	public void setEstimated(BigDecimal estimated)
	{
		writeProperty("estimated", estimated);
	}

	public BigDecimal getEstimated()
	{
		return (BigDecimal) readProperty("estimated");
	}

	public void setExpected(BigDecimal expected)
	{
		writeProperty("expected", expected);
	}

	public BigDecimal getExpected()
	{
		return (BigDecimal) readProperty("expected");
	}

	public void setFinal(BigDecimal _final)
	{
		writeProperty("final", _final);
	}

	public BigDecimal getFinal()
	{
		return (BigDecimal) readProperty("final");
	}

	public void setOffered(BigDecimal offered)
	{
		writeProperty("offered", offered);
	}

	public BigDecimal getOffered()
	{
		return (BigDecimal) readProperty("offered");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setRequested(BigDecimal requested)
	{
		writeProperty("requested", requested);
	}

	public BigDecimal getRequested()
	{
		return (BigDecimal) readProperty("requested");
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
