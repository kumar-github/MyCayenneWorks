package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VPosgridTradeItemInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VPosgridTradeItemInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<Date> CONTR_DATE = new Property<Date>("contrDate");
	public static final Property<Double> CONTR_QTY = new Property<Double>("contrQty");
	public static final Property<String> CONTR_QTY_UOM_CODE = new Property<String>("contrQtyUomCode");
	public static final Property<Date> CREATION_DATE = new Property<Date>("creationDate");
	public static final Property<String> INHOUSE_IND = new Property<String>("inhouseInd");
	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<String> ORDER_TYPE_CODE = new Property<String>("orderTypeCode");
	public static final Property<String> P_SIND = new Property<String>("pSInd");
	public static final Property<Integer> PORT_NUM = new Property<Integer>("portNum");
	public static final Property<String> PRODUCT = new Property<String>("product");
	public static final Property<Date> TRADE_MOD_DATE = new Property<Date>("tradeModDate");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<String> TRADER_INIT = new Property<String>("traderInit");

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setContrDate(Date contrDate)
	{
		writeProperty("contrDate", contrDate);
	}

	public Date getContrDate()
	{
		return (Date) readProperty("contrDate");
	}

	public void setContrQty(Double contrQty)
	{
		writeProperty("contrQty", contrQty);
	}

	public Double getContrQty()
	{
		return (Double) readProperty("contrQty");
	}

	public void setContrQtyUomCode(String contrQtyUomCode)
	{
		writeProperty("contrQtyUomCode", contrQtyUomCode);
	}

	public String getContrQtyUomCode()
	{
		return (String) readProperty("contrQtyUomCode");
	}

	public void setCreationDate(Date creationDate)
	{
		writeProperty("creationDate", creationDate);
	}

	public Date getCreationDate()
	{
		return (Date) readProperty("creationDate");
	}

	public void setInhouseInd(String inhouseInd)
	{
		writeProperty("inhouseInd", inhouseInd);
	}

	public String getInhouseInd()
	{
		return (String) readProperty("inhouseInd");
	}

	public void setItemNum(Short itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) readProperty("itemNum");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setOrderTypeCode(String orderTypeCode)
	{
		writeProperty("orderTypeCode", orderTypeCode);
	}

	public String getOrderTypeCode()
	{
		return (String) readProperty("orderTypeCode");
	}

	public void setPSInd(String pSInd)
	{
		writeProperty("pSInd", pSInd);
	}

	public String getPSInd()
	{
		return (String) readProperty("pSInd");
	}

	public void setPortNum(Integer portNum)
	{
		writeProperty("portNum", portNum);
	}

	public Integer getPortNum()
	{
		return (Integer) readProperty("portNum");
	}

	public void setProduct(String product)
	{
		writeProperty("product", product);
	}

	public String getProduct()
	{
		return (String) readProperty("product");
	}

	public void setTradeModDate(Date tradeModDate)
	{
		writeProperty("tradeModDate", tradeModDate);
	}

	public Date getTradeModDate()
	{
		return (Date) readProperty("tradeModDate");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

	public void setTraderInit(String traderInit)
	{
		writeProperty("traderInit", traderInit);
	}

	public String getTraderInit()
	{
		return (String) readProperty("traderInit");
	}

}
