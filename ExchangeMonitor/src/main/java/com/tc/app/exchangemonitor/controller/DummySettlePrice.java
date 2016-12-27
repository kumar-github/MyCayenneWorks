package com.tc.app.exchangemonitor.controller;

import java.util.Date;

import org.apache.cayenne.DataRow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DummySettlePrice
{
	private static final Logger LOGGER = LogManager.getLogger();

	private Integer tradeNum;
	private int orderNum;
	private int itemNum;
	private int itemFillNum;
	private Date fillDate;
	private String cmdtyCode;
	private String riskMktCode;
	private String tradingPrd;
	private String psInd;
	private Double fillQty;
	private Double fillPrice;
	private String userFirstName;
	private String userLastName;
	private Integer realPortNum;
	private String portFullName;
	private String priceSourceCode;
	private String orderInstrCode;
	private Double orderPrice;
	private Integer cmntNum;
	private String externalTradeNum;
	private Integer commktKey;

	public DummySettlePrice()
	{
	}

	public DummySettlePrice(final DataRow aDataRow)
	{
		//@formatter:off

		this.tradeNum = aDataRow.get("tradeNum") != null ? (Integer)aDataRow.get("tradeNum") : null;
		this.orderNum = aDataRow.get("orderNum") != null ? (Short)aDataRow.get("orderNum") : null;
		this.itemNum = aDataRow.get("itemNum") != null ? (Short)aDataRow.get("itemNum") : null;
		this.orderNum = aDataRow.get("orderNum") != null ? (Short)aDataRow.get("orderNum") : null;
		this.itemFillNum = aDataRow.get("itemFillNum") != null ? (Short)aDataRow.get("itemFillNum") : null;
		this.fillDate = aDataRow.get("fillDate") != null ? (Date)aDataRow.get("fillDate") : null;
		this.cmdtyCode = aDataRow.get("cmdtyCode") != null ? (String)aDataRow.get("cmdtyCode") : null;
		this.riskMktCode = aDataRow.get("riskMktCode") != null ? (String)aDataRow.get("riskMktCode") : null;
		this.tradingPrd = aDataRow.get("tradingPrd") != null ? (String)aDataRow.get("tradingPrd") : null;
		this.psInd = aDataRow.get("psInd") != null ? (String)aDataRow.get("psInd") : null;
		this.fillQty = aDataRow.get("fillQty") != null ? (Double)aDataRow.get("fillQty") : null;
		this.fillPrice = aDataRow.get("fillPrice") != null ? (Double)aDataRow.get("fillPrice") : null;
		this.userFirstName = aDataRow.get("userFirstName") != null ? (String)aDataRow.get("userFirstName") : null;
		this.userLastName = aDataRow.get("userLastName") != null ? (String)aDataRow.get("userLastName") : null;
		this.realPortNum = aDataRow.get("realPortNum") != null ? (Integer)aDataRow.get("realPortNum") : null;
		this.portFullName = aDataRow.get("portFullName") != null ? (String)aDataRow.get("portFullName") : null;
		this.priceSourceCode = aDataRow.get("priceSourceCode") != null ? (String)aDataRow.get("priceSourceCode") : null;
		this.orderInstrCode = aDataRow.get("orderInstrCode") != null ? (String)aDataRow.get("orderInstrCode") : null;
		this.orderPrice = aDataRow.get("orderPrice") != null ? (Double)aDataRow.get("orderPrice") : 0.0;
		this.cmntNum = aDataRow.get("cmntNum") != null ? (Integer)aDataRow.get("cmntNum") : null;
		this.externalTradeNum = aDataRow.get("externalTradeNum") != null ? (String)aDataRow.get("externalTradeNum") : null;
		this.commktKey = aDataRow.get("commktKey") != null ? (Integer)aDataRow.get("commktKey") : null;

		LOGGER.info(this);

		//@formatter:on
	}

	public Integer getTradeNum()
	{
		return this.tradeNum;
	}

	public void setTradeNum(final Integer tradeNum)
	{
		this.tradeNum = tradeNum;
	}

	public int getOrderNum()
	{
		return this.orderNum;
	}

	public void setOrderNum(final int orderNum)
	{
		this.orderNum = orderNum;
	}

	public int getItemNum()
	{
		return this.itemNum;
	}

	public void setItemNum(final int itemNum)
	{
		this.itemNum = itemNum;
	}

	public int getItemFillNum()
	{
		return this.itemFillNum;
	}

	public void setItemFillNum(final int itemFillNum)
	{
		this.itemFillNum = itemFillNum;
	}

	public Date getFillDate()
	{
		return this.fillDate;
	}

	public void setFillDate(final Date fillDate)
	{
		this.fillDate = fillDate;
	}

	public String getCmdtyCode()
	{
		return this.cmdtyCode;
	}

	public void setCmdtyCode(final String cmdtyCode)
	{
		this.cmdtyCode = cmdtyCode;
	}

	public String getRiskMktCode()
	{
		return this.riskMktCode;
	}

	public void setRiskMktCode(final String riskMktCode)
	{
		this.riskMktCode = riskMktCode;
	}

	public String getTradingPrd()
	{
		return this.tradingPrd;
	}

	public void setTradingPrd(final String tradingPrd)
	{
		this.tradingPrd = tradingPrd;
	}

	public String getPsInd()
	{
		return this.psInd;
	}

	public void setPsInd(final String psInd)
	{
		this.psInd = psInd;
	}

	public Double getFillQty()
	{
		return this.fillQty;
	}

	public void setFillQty(final Double fillQty)
	{
		this.fillQty = fillQty;
	}

	public Double getFillPrice()
	{
		return this.fillPrice;
	}

	public void setFillPrice(final Double fillPrice)
	{
		this.fillPrice = fillPrice;
	}

	public String getUserFirstName()
	{
		return this.userFirstName;
	}

	public void setUserFirstName(final String userFirstName)
	{
		this.userFirstName = userFirstName;
	}

	public String getUserLastName()
	{
		return this.userLastName;
	}

	public void setUserLastName(final String userLastName)
	{
		this.userLastName = userLastName;
	}

	public Integer getRealPortNum()
	{
		return this.realPortNum;
	}

	public void setRealPortNum(final Integer realPortNum)
	{
		this.realPortNum = realPortNum;
	}

	public String getPortFullName()
	{
		return this.portFullName;
	}

	public void setPortFullName(final String portFullName)
	{
		this.portFullName = portFullName;
	}

	public String getPriceSourceCode()
	{
		return this.priceSourceCode;
	}

	public void setPriceSourceCode(final String priceSourceCode)
	{
		this.priceSourceCode = priceSourceCode;
	}

	public String getOrderInstrCode()
	{
		return this.orderInstrCode;
	}

	public void setOrderInstrCode(final String orderInstrCode)
	{
		this.orderInstrCode = orderInstrCode;
	}

	public Double getOrderPrice()
	{
		return this.orderPrice;
	}

	public void setOrderPrice(final Double orderPrice)
	{
		this.orderPrice = orderPrice;
	}

	public Integer getCmntNum()
	{
		return this.cmntNum;
	}

	public void setCmntNum(final Integer cmntNum)
	{
		this.cmntNum = cmntNum;
	}

	public String getExternalTradeNum()
	{
		return this.externalTradeNum;
	}

	public void setExternalTradeNum(final String externalTradeNum)
	{
		this.externalTradeNum = externalTradeNum;
	}

	public Integer getCommktKey()
	{
		return this.commktKey;
	}

	public void setCommktKey(final Integer commktKey)
	{
		this.commktKey = commktKey;
	}

	public String getTradeOrderItemFillNumString()
	{
		return this.getTradeNum() + "/" + this.getOrderNum() + "/" + this.getItemNum() + "/" + this.getItemFillNum();
	}

	public String getTraderFullName()
	{
		return this.getUserFirstName() + " " + this.getUserLastName();
	}

	public String getBuySellString()
	{
		return this.getPsInd() == "P" ? "BUY" : "SELL";
	}

	public String getPortNumNameString()
	{
		return this.getRealPortNum() + "-" + this.getPortFullName();
	}

	@Override
	public String toString()
	{
		return this.tradeNum + " <--> " + this.orderNum + " <--> " + this.itemNum + " <--> " + this.itemFillNum + " <--> " + this.fillDate + " <--> " + this.cmdtyCode + " <--> " + this.riskMktCode + " <--> " + this.tradingPrd + " <--> " + this.psInd + " <--> " + this.fillQty + " <--> " + this.fillPrice + " <--> " + this.userFirstName + " <--> " + this.userLastName + " <--> " + this.realPortNum + " <--> " + this.portFullName + " <--> " + this.priceSourceCode + " <--> " + this.orderInstrCode + " <--> " + this.orderPrice + " <--> " + this.cmntNum + " <--> " + this.externalTradeNum + " <--> " + this.commktKey;
	}
}