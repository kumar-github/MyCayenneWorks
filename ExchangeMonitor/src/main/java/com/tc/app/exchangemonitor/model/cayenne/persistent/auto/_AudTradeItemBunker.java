package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudTradeItemBunker was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudTradeItemBunker extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> CREDIT_TERM_CODE = new Property<String>("creditTermCode");
	public static final Property<Date> CURR_EXCH_DATE = new Property<Date>("currExchDate");
	public static final Property<Integer> DEL_AGENT_NUM = new Property<Integer>("delAgentNum");
	public static final Property<Date> DEL_DATE = new Property<Date>("delDate");
	public static final Property<String> DEL_TERM_CODE = new Property<String>("delTermCode");
	public static final Property<String> DELIVERY_MOT = new Property<String>("deliveryMot");
	public static final Property<Date> ETA_DATE = new Property<Date>("etaDate");
	public static final Property<String> EXP_TIME_ZONE_CODE = new Property<String>("expTimeZoneCode");
	public static final Property<String> HANDLING_TYPE_CODE = new Property<String>("handlingTypeCode");
	public static final Property<Integer> ITEM_NUM = new Property<Integer>("itemNum");
	public static final Property<BigDecimal> MAX_QTY = new Property<BigDecimal>("maxQty");
	public static final Property<String> MAX_QTY_UOM_CODE = new Property<String>("maxQtyUomCode");
	public static final Property<BigDecimal> MIN_QTY = new Property<BigDecimal>("minQty");
	public static final Property<String> MIN_QTY_UOM_CODE = new Property<String>("minQtyUomCode");
	public static final Property<String> MOT_CODE = new Property<String>("motCode");
	public static final Property<Integer> ORDER_NUM = new Property<Integer>("orderNum");
	public static final Property<String> PAY_TERM_CODE = new Property<String>("payTermCode");
	public static final Property<Integer> PORT_AGENT_NUM = new Property<Integer>("portAgentNum");
	public static final Property<String> PORT_LOC_CODE = new Property<String>("portLocCode");
	public static final Property<Date> PRICING_EXP_DATE = new Property<Date>("pricingExpDate");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> STORAGE_LOC_CODE = new Property<String>("storageLocCode");
	public static final Property<String> TOL_OPT = new Property<String>("tolOpt");
	public static final Property<BigDecimal> TOL_QTY = new Property<BigDecimal>("tolQty");
	public static final Property<String> TOL_QTY_UOM_CODE = new Property<String>("tolQtyUomCode");
	public static final Property<String> TOL_SIGN = new Property<String>("tolSign");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Double> TRANSP_PRICE_AMT = new Property<Double>("transpPriceAmt");
	public static final Property<String> TRANSP_PRICE_CURR_CODE = new Property<String>("transpPriceCurrCode");
	public static final Property<String> TRANSP_PRICE_UOM_CODE = new Property<String>("transpPriceUomCode");

	public void setCreditTermCode(String creditTermCode)
	{
		writeProperty("creditTermCode", creditTermCode);
	}

	public String getCreditTermCode()
	{
		return (String) readProperty("creditTermCode");
	}

	public void setCurrExchDate(Date currExchDate)
	{
		writeProperty("currExchDate", currExchDate);
	}

	public Date getCurrExchDate()
	{
		return (Date) readProperty("currExchDate");
	}

	public void setDelAgentNum(Integer delAgentNum)
	{
		writeProperty("delAgentNum", delAgentNum);
	}

	public Integer getDelAgentNum()
	{
		return (Integer) readProperty("delAgentNum");
	}

	public void setDelDate(Date delDate)
	{
		writeProperty("delDate", delDate);
	}

	public Date getDelDate()
	{
		return (Date) readProperty("delDate");
	}

	public void setDelTermCode(String delTermCode)
	{
		writeProperty("delTermCode", delTermCode);
	}

	public String getDelTermCode()
	{
		return (String) readProperty("delTermCode");
	}

	public void setDeliveryMot(String deliveryMot)
	{
		writeProperty("deliveryMot", deliveryMot);
	}

	public String getDeliveryMot()
	{
		return (String) readProperty("deliveryMot");
	}

	public void setEtaDate(Date etaDate)
	{
		writeProperty("etaDate", etaDate);
	}

	public Date getEtaDate()
	{
		return (Date) readProperty("etaDate");
	}

	public void setExpTimeZoneCode(String expTimeZoneCode)
	{
		writeProperty("expTimeZoneCode", expTimeZoneCode);
	}

	public String getExpTimeZoneCode()
	{
		return (String) readProperty("expTimeZoneCode");
	}

	public void setHandlingTypeCode(String handlingTypeCode)
	{
		writeProperty("handlingTypeCode", handlingTypeCode);
	}

	public String getHandlingTypeCode()
	{
		return (String) readProperty("handlingTypeCode");
	}

	public void setItemNum(Integer itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Integer getItemNum()
	{
		return (Integer) readProperty("itemNum");
	}

	public void setMaxQty(BigDecimal maxQty)
	{
		writeProperty("maxQty", maxQty);
	}

	public BigDecimal getMaxQty()
	{
		return (BigDecimal) readProperty("maxQty");
	}

	public void setMaxQtyUomCode(String maxQtyUomCode)
	{
		writeProperty("maxQtyUomCode", maxQtyUomCode);
	}

	public String getMaxQtyUomCode()
	{
		return (String) readProperty("maxQtyUomCode");
	}

	public void setMinQty(BigDecimal minQty)
	{
		writeProperty("minQty", minQty);
	}

	public BigDecimal getMinQty()
	{
		return (BigDecimal) readProperty("minQty");
	}

	public void setMinQtyUomCode(String minQtyUomCode)
	{
		writeProperty("minQtyUomCode", minQtyUomCode);
	}

	public String getMinQtyUomCode()
	{
		return (String) readProperty("minQtyUomCode");
	}

	public void setMotCode(String motCode)
	{
		writeProperty("motCode", motCode);
	}

	public String getMotCode()
	{
		return (String) readProperty("motCode");
	}

	public void setOrderNum(Integer orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Integer getOrderNum()
	{
		return (Integer) readProperty("orderNum");
	}

	public void setPayTermCode(String payTermCode)
	{
		writeProperty("payTermCode", payTermCode);
	}

	public String getPayTermCode()
	{
		return (String) readProperty("payTermCode");
	}

	public void setPortAgentNum(Integer portAgentNum)
	{
		writeProperty("portAgentNum", portAgentNum);
	}

	public Integer getPortAgentNum()
	{
		return (Integer) readProperty("portAgentNum");
	}

	public void setPortLocCode(String portLocCode)
	{
		writeProperty("portLocCode", portLocCode);
	}

	public String getPortLocCode()
	{
		return (String) readProperty("portLocCode");
	}

	public void setPricingExpDate(Date pricingExpDate)
	{
		writeProperty("pricingExpDate", pricingExpDate);
	}

	public Date getPricingExpDate()
	{
		return (Date) readProperty("pricingExpDate");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setStorageLocCode(String storageLocCode)
	{
		writeProperty("storageLocCode", storageLocCode);
	}

	public String getStorageLocCode()
	{
		return (String) readProperty("storageLocCode");
	}

	public void setTolOpt(String tolOpt)
	{
		writeProperty("tolOpt", tolOpt);
	}

	public String getTolOpt()
	{
		return (String) readProperty("tolOpt");
	}

	public void setTolQty(BigDecimal tolQty)
	{
		writeProperty("tolQty", tolQty);
	}

	public BigDecimal getTolQty()
	{
		return (BigDecimal) readProperty("tolQty");
	}

	public void setTolQtyUomCode(String tolQtyUomCode)
	{
		writeProperty("tolQtyUomCode", tolQtyUomCode);
	}

	public String getTolQtyUomCode()
	{
		return (String) readProperty("tolQtyUomCode");
	}

	public void setTolSign(String tolSign)
	{
		writeProperty("tolSign", tolSign);
	}

	public String getTolSign()
	{
		return (String) readProperty("tolSign");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setTranspPriceAmt(Double transpPriceAmt)
	{
		writeProperty("transpPriceAmt", transpPriceAmt);
	}

	public Double getTranspPriceAmt()
	{
		return (Double) readProperty("transpPriceAmt");
	}

	public void setTranspPriceCurrCode(String transpPriceCurrCode)
	{
		writeProperty("transpPriceCurrCode", transpPriceCurrCode);
	}

	public String getTranspPriceCurrCode()
	{
		return (String) readProperty("transpPriceCurrCode");
	}

	public void setTranspPriceUomCode(String transpPriceUomCode)
	{
		writeProperty("transpPriceUomCode", transpPriceUomCode);
	}

	public String getTranspPriceUomCode()
	{
		return (String) readProperty("transpPriceUomCode");
	}

}
