package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.TiInboundDataXml;

/**
 * Class _TiZdefExchObjective was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TiZdefExchObjective extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> CONTRACT_ITEM = new Property<String>("contractItem");
	public static final Property<String> CONTRACT_NUMBER = new Property<String>("contractNumber");
	public static final Property<String> DELIVERY_RECEIPT_INDICATOR = new Property<String>("deliveryReceiptIndicator");
	public static final Property<Date> END_DATE = new Property<Date>("endDate");
	public static final Property<Date> ETL_TIMESTAMP = new Property<Date>("etlTimestamp");
	public static final Property<String> EXCHANGE_NUMBER = new Property<String>("exchangeNumber");
	public static final Property<BigDecimal> EXCHANGE_OBJECTIVE = new Property<BigDecimal>("exchangeObjective");
	public static final Property<String> LOCATION = new Property<String>("location");
	public static final Property<String> MATERIAL = new Property<String>("material");
	public static final Property<String> MOT = new Property<String>("mot");
	public static final Property<Date> START_DATE = new Property<Date>("startDate");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<String> UOM = new Property<String>("uom");
	public static final Property<TiInboundDataXml> INBOUND_DATA_O = new Property<TiInboundDataXml>("inboundDataO");

	public void setContractItem(String contractItem)
	{
		writeProperty("contractItem", contractItem);
	}

	public String getContractItem()
	{
		return (String) readProperty("contractItem");
	}

	public void setContractNumber(String contractNumber)
	{
		writeProperty("contractNumber", contractNumber);
	}

	public String getContractNumber()
	{
		return (String) readProperty("contractNumber");
	}

	public void setDeliveryReceiptIndicator(String deliveryReceiptIndicator)
	{
		writeProperty("deliveryReceiptIndicator", deliveryReceiptIndicator);
	}

	public String getDeliveryReceiptIndicator()
	{
		return (String) readProperty("deliveryReceiptIndicator");
	}

	public void setEndDate(Date endDate)
	{
		writeProperty("endDate", endDate);
	}

	public Date getEndDate()
	{
		return (Date) readProperty("endDate");
	}

	public void setEtlTimestamp(Date etlTimestamp)
	{
		writeProperty("etlTimestamp", etlTimestamp);
	}

	public Date getEtlTimestamp()
	{
		return (Date) readProperty("etlTimestamp");
	}

	public void setExchangeNumber(String exchangeNumber)
	{
		writeProperty("exchangeNumber", exchangeNumber);
	}

	public String getExchangeNumber()
	{
		return (String) readProperty("exchangeNumber");
	}

	public void setExchangeObjective(BigDecimal exchangeObjective)
	{
		writeProperty("exchangeObjective", exchangeObjective);
	}

	public BigDecimal getExchangeObjective()
	{
		return (BigDecimal) readProperty("exchangeObjective");
	}

	public void setLocation(String location)
	{
		writeProperty("location", location);
	}

	public String getLocation()
	{
		return (String) readProperty("location");
	}

	public void setMaterial(String material)
	{
		writeProperty("material", material);
	}

	public String getMaterial()
	{
		return (String) readProperty("material");
	}

	public void setMot(String mot)
	{
		writeProperty("mot", mot);
	}

	public String getMot()
	{
		return (String) readProperty("mot");
	}

	public void setStartDate(Date startDate)
	{
		writeProperty("startDate", startDate);
	}

	public Date getStartDate()
	{
		return (Date) readProperty("startDate");
	}

	public void setStatus(String status)
	{
		writeProperty("status", status);
	}

	public String getStatus()
	{
		return (String) readProperty("status");
	}

	public void setUom(String uom)
	{
		writeProperty("uom", uom);
	}

	public String getUom()
	{
		return (String) readProperty("uom");
	}

	public void setInboundDataO(TiInboundDataXml inboundDataO)
	{
		setToOneTarget("inboundDataO", inboundDataO, true);
	}

	public TiInboundDataXml getInboundDataO()
	{
		return (TiInboundDataXml) readProperty("inboundDataO");
	}

}
