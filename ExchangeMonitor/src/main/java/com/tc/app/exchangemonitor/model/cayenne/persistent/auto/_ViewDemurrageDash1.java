package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ViewDemurrageDash1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ViewDemurrageDash1 extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ALLOC_ITEM = new Property<Integer>("allocItem");
	public static final Property<Integer> ALLOC_NUM = new Property<Integer>("allocNum");
	public static final Property<Double> AMOUNT = new Property<Double>("amount");
	public static final Property<Double> B_L_QUANTITY = new Property<Double>("b_L_Quantity");
	public static final Property<String> BELONG_TO = new Property<String>("belongTo");
	public static final Property<Date> BL_DATE = new Property<Date>("blDate");
	public static final Property<String> CMDTY_SHORT_NAME = new Property<String>("cmdtyShortName");
	public static final Property<String> COST_PRICE_CURR_CODE = new Property<String>("costPriceCurrCode");
	public static final Property<String> COST_TYPE = new Property<String>("cost_Type");
	public static final Property<String> COUNTER_PARTY = new Property<String>("counterParty");
	public static final Property<Date> CREATION_DATE = new Property<Date>("creation_Date");
	public static final Property<String> DEL_TERM_CODE = new Property<String>("delTermCode");
	public static final Property<String> DEMURRAGE_CURRENCY = new Property<String>("demurrageCurrency");
	public static final Property<Integer> DEMURRAGE_KEY = new Property<Integer>("demurrageKey");
	public static final Property<BigDecimal> DEMURRAGE_RATE = new Property<BigDecimal>("demurrageRate");
	public static final Property<String> EXPR1 = new Property<String>("expr1");
	public static final Property<BigDecimal> FINAL_HOURS = new Property<BigDecimal>("finalHours");
	public static final Property<String> LEGAL_ENTITY = new Property<String>("legalEntity");
	public static final Property<String> OWNER = new Property<String>("owner");
	public static final Property<String> PAY_TERM_CODE = new Property<String>("payTermCode");
	public static final Property<String> PAY_REC = new Property<String>("pay_Rec");
	public static final Property<Integer> PORT_NUM = new Property<Integer>("portNum");
	public static final Property<String> RATE_UNIT = new Property<String>("rate_Unit");
	public static final Property<String> STATUS = new Property<String>("status");
	public static final Property<String> TRANSPORTATION = new Property<String>("transportation");
	public static final Property<String> UOM = new Property<String>("uom");
	public static final Property<String> VOYAGE_KEY = new Property<String>("voyageKey");
	public static final Property<String> YEAR = new Property<String>("year");

	public void setAllocItem(Integer allocItem)
	{
		writeProperty("allocItem", allocItem);
	}

	public Integer getAllocItem()
	{
		return (Integer) readProperty("allocItem");
	}

	public void setAllocNum(Integer allocNum)
	{
		writeProperty("allocNum", allocNum);
	}

	public Integer getAllocNum()
	{
		return (Integer) readProperty("allocNum");
	}

	public void setAmount(Double amount)
	{
		writeProperty("amount", amount);
	}

	public Double getAmount()
	{
		return (Double) readProperty("amount");
	}

	public void setB_L_Quantity(Double b_L_Quantity)
	{
		writeProperty("b_L_Quantity", b_L_Quantity);
	}

	public Double getB_L_Quantity()
	{
		return (Double) readProperty("b_L_Quantity");
	}

	public void setBelongTo(String belongTo)
	{
		writeProperty("belongTo", belongTo);
	}

	public String getBelongTo()
	{
		return (String) readProperty("belongTo");
	}

	public void setBlDate(Date blDate)
	{
		writeProperty("blDate", blDate);
	}

	public Date getBlDate()
	{
		return (Date) readProperty("blDate");
	}

	public void setCmdtyShortName(String cmdtyShortName)
	{
		writeProperty("cmdtyShortName", cmdtyShortName);
	}

	public String getCmdtyShortName()
	{
		return (String) readProperty("cmdtyShortName");
	}

	public void setCostPriceCurrCode(String costPriceCurrCode)
	{
		writeProperty("costPriceCurrCode", costPriceCurrCode);
	}

	public String getCostPriceCurrCode()
	{
		return (String) readProperty("costPriceCurrCode");
	}

	public void setCost_Type(String cost_Type)
	{
		writeProperty("cost_Type", cost_Type);
	}

	public String getCost_Type()
	{
		return (String) readProperty("cost_Type");
	}

	public void setCounterParty(String counterParty)
	{
		writeProperty("counterParty", counterParty);
	}

	public String getCounterParty()
	{
		return (String) readProperty("counterParty");
	}

	public void setCreation_Date(Date creation_Date)
	{
		writeProperty("creation_Date", creation_Date);
	}

	public Date getCreation_Date()
	{
		return (Date) readProperty("creation_Date");
	}

	public void setDelTermCode(String delTermCode)
	{
		writeProperty("delTermCode", delTermCode);
	}

	public String getDelTermCode()
	{
		return (String) readProperty("delTermCode");
	}

	public void setDemurrageCurrency(String demurrageCurrency)
	{
		writeProperty("demurrageCurrency", demurrageCurrency);
	}

	public String getDemurrageCurrency()
	{
		return (String) readProperty("demurrageCurrency");
	}

	public void setDemurrageKey(Integer demurrageKey)
	{
		writeProperty("demurrageKey", demurrageKey);
	}

	public Integer getDemurrageKey()
	{
		return (Integer) readProperty("demurrageKey");
	}

	public void setDemurrageRate(BigDecimal demurrageRate)
	{
		writeProperty("demurrageRate", demurrageRate);
	}

	public BigDecimal getDemurrageRate()
	{
		return (BigDecimal) readProperty("demurrageRate");
	}

	public void setExpr1(String expr1)
	{
		writeProperty("expr1", expr1);
	}

	public String getExpr1()
	{
		return (String) readProperty("expr1");
	}

	public void setFinalHours(BigDecimal finalHours)
	{
		writeProperty("finalHours", finalHours);
	}

	public BigDecimal getFinalHours()
	{
		return (BigDecimal) readProperty("finalHours");
	}

	public void setLegalEntity(String legalEntity)
	{
		writeProperty("legalEntity", legalEntity);
	}

	public String getLegalEntity()
	{
		return (String) readProperty("legalEntity");
	}

	public void setOwner(String owner)
	{
		writeProperty("owner", owner);
	}

	public String getOwner()
	{
		return (String) readProperty("owner");
	}

	public void setPayTermCode(String payTermCode)
	{
		writeProperty("payTermCode", payTermCode);
	}

	public String getPayTermCode()
	{
		return (String) readProperty("payTermCode");
	}

	public void setPay_Rec(String pay_Rec)
	{
		writeProperty("pay_Rec", pay_Rec);
	}

	public String getPay_Rec()
	{
		return (String) readProperty("pay_Rec");
	}

	public void setPortNum(Integer portNum)
	{
		writeProperty("portNum", portNum);
	}

	public Integer getPortNum()
	{
		return (Integer) readProperty("portNum");
	}

	public void setRate_Unit(String rate_Unit)
	{
		writeProperty("rate_Unit", rate_Unit);
	}

	public String getRate_Unit()
	{
		return (String) readProperty("rate_Unit");
	}

	public void setStatus(String status)
	{
		writeProperty("status", status);
	}

	public String getStatus()
	{
		return (String) readProperty("status");
	}

	public void setTransportation(String transportation)
	{
		writeProperty("transportation", transportation);
	}

	public String getTransportation()
	{
		return (String) readProperty("transportation");
	}

	public void setUom(String uom)
	{
		writeProperty("uom", uom);
	}

	public String getUom()
	{
		return (String) readProperty("uom");
	}

	public void setVoyageKey(String voyageKey)
	{
		writeProperty("voyageKey", voyageKey);
	}

	public String getVoyageKey()
	{
		return (String) readProperty("voyageKey");
	}

	public void setYear(String year)
	{
		writeProperty("year", year);
	}

	public String getYear()
	{
		return (String) readProperty("year");
	}

}
