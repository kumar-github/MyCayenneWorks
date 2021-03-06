package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudFlMarketVoyageTmpltTs was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudFlMarketVoyageTmpltTs extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<Integer> ID_ORDER = new Property<Integer>("idOrder");
	public static final Property<Integer> ID_VOYAGE_TEMPLATE = new Property<Integer>("idVoyageTemplate");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<String> OPS_TYPE = new Property<String>("opsType");
	public static final Property<String> PORT_CODE = new Property<String>("portCode");
	public static final Property<BigDecimal> QTY = new Property<BigDecimal>("qty");
	public static final Property<String> USERID = new Property<String>("userid");

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setIdOrder(Integer idOrder)
	{
		writeProperty("idOrder", idOrder);
	}

	public Integer getIdOrder()
	{
		return (Integer) readProperty("idOrder");
	}

	public void setIdVoyageTemplate(Integer idVoyageTemplate)
	{
		writeProperty("idVoyageTemplate", idVoyageTemplate);
	}

	public Integer getIdVoyageTemplate()
	{
		return (Integer) readProperty("idVoyageTemplate");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setOpsType(String opsType)
	{
		writeProperty("opsType", opsType);
	}

	public String getOpsType()
	{
		return (String) readProperty("opsType");
	}

	public void setPortCode(String portCode)
	{
		writeProperty("portCode", portCode);
	}

	public String getPortCode()
	{
		return (String) readProperty("portCode");
	}

	public void setQty(BigDecimal qty)
	{
		writeProperty("qty", qty);
	}

	public BigDecimal getQty()
	{
		return (BigDecimal) readProperty("qty");
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
