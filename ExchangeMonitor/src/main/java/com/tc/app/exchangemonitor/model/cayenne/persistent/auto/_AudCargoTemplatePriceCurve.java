package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCargoTemplatePriceCurve was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCargoTemplatePriceCurve extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Date> DATE_OP = new Property<Date>("dateOp");
	public static final Property<Double> HARBOUR_VALUE = new Property<Double>("harbourValue");
	public static final Property<BigDecimal> IFO_CONSUMED = new Property<BigDecimal>("ifoConsumed");
	public static final Property<Double> IFO_VALUE = new Property<Double>("ifoValue");
	public static final Property<BigDecimal> MDO_CONSUMED = new Property<BigDecimal>("mdoConsumed");
	public static final Property<Double> MDO_VALUE = new Property<Double>("mdoValue");
	public static final Property<String> OPERATION = new Property<String>("operation");
	public static final Property<Date> PRICE_QUOTE_DATE = new Property<Date>("priceQuoteDate");
	public static final Property<Date> PRICE_TRADING_DATE = new Property<Date>("priceTradingDate");
	public static final Property<Double> PRICE_VALUE = new Property<Double>("priceValue");
	public static final Property<BigDecimal> QUANTITY = new Property<BigDecimal>("quantity");
	public static final Property<Integer> TEMPLATE_ID = new Property<Integer>("templateId");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<String> USERID = new Property<String>("userid");
	public static final Property<Double> VOYAGE_COST_DAY_VALUE = new Property<Double>("voyageCostDayValue");
	public static final Property<BigDecimal> VOYAGE_DURATION = new Property<BigDecimal>("voyageDuration");
	public static final Property<Double> VOYAGE_VALUE = new Property<Double>("voyageValue");

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setDateOp(Date dateOp)
	{
		writeProperty("dateOp", dateOp);
	}

	public Date getDateOp()
	{
		return (Date) readProperty("dateOp");
	}

	public void setHarbourValue(Double harbourValue)
	{
		writeProperty("harbourValue", harbourValue);
	}

	public Double getHarbourValue()
	{
		return (Double) readProperty("harbourValue");
	}

	public void setIfoConsumed(BigDecimal ifoConsumed)
	{
		writeProperty("ifoConsumed", ifoConsumed);
	}

	public BigDecimal getIfoConsumed()
	{
		return (BigDecimal) readProperty("ifoConsumed");
	}

	public void setIfoValue(Double ifoValue)
	{
		writeProperty("ifoValue", ifoValue);
	}

	public Double getIfoValue()
	{
		return (Double) readProperty("ifoValue");
	}

	public void setMdoConsumed(BigDecimal mdoConsumed)
	{
		writeProperty("mdoConsumed", mdoConsumed);
	}

	public BigDecimal getMdoConsumed()
	{
		return (BigDecimal) readProperty("mdoConsumed");
	}

	public void setMdoValue(Double mdoValue)
	{
		writeProperty("mdoValue", mdoValue);
	}

	public Double getMdoValue()
	{
		return (Double) readProperty("mdoValue");
	}

	public void setOperation(String operation)
	{
		writeProperty("operation", operation);
	}

	public String getOperation()
	{
		return (String) readProperty("operation");
	}

	public void setPriceQuoteDate(Date priceQuoteDate)
	{
		writeProperty("priceQuoteDate", priceQuoteDate);
	}

	public Date getPriceQuoteDate()
	{
		return (Date) readProperty("priceQuoteDate");
	}

	public void setPriceTradingDate(Date priceTradingDate)
	{
		writeProperty("priceTradingDate", priceTradingDate);
	}

	public Date getPriceTradingDate()
	{
		return (Date) readProperty("priceTradingDate");
	}

	public void setPriceValue(Double priceValue)
	{
		writeProperty("priceValue", priceValue);
	}

	public Double getPriceValue()
	{
		return (Double) readProperty("priceValue");
	}

	public void setQuantity(BigDecimal quantity)
	{
		writeProperty("quantity", quantity);
	}

	public BigDecimal getQuantity()
	{
		return (BigDecimal) readProperty("quantity");
	}

	public void setTemplateId(Integer templateId)
	{
		writeProperty("templateId", templateId);
	}

	public Integer getTemplateId()
	{
		return (Integer) readProperty("templateId");
	}

	public void setTradingPrd(String tradingPrd)
	{
		writeProperty("tradingPrd", tradingPrd);
	}

	public String getTradingPrd()
	{
		return (String) readProperty("tradingPrd");
	}

	public void setUserid(String userid)
	{
		writeProperty("userid", userid);
	}

	public String getUserid()
	{
		return (String) readProperty("userid");
	}

	public void setVoyageCostDayValue(Double voyageCostDayValue)
	{
		writeProperty("voyageCostDayValue", voyageCostDayValue);
	}

	public Double getVoyageCostDayValue()
	{
		return (Double) readProperty("voyageCostDayValue");
	}

	public void setVoyageDuration(BigDecimal voyageDuration)
	{
		writeProperty("voyageDuration", voyageDuration);
	}

	public BigDecimal getVoyageDuration()
	{
		return (BigDecimal) readProperty("voyageDuration");
	}

	public void setVoyageValue(Double voyageValue)
	{
		writeProperty("voyageValue", voyageValue);
	}

	public Double getVoyageValue()
	{
		return (Double) readProperty("voyageValue");
	}

}
