package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudExternalPosition was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudExternalPosition extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> CLR_BRKR_NUM = new Property<Integer>("clrBrkrNum");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Integer> EXT_POS_NUM = new Property<Integer>("extPosNum");
	public static final Property<String> ITEM_TYPE = new Property<String>("itemType");
	public static final Property<String> PUT_CALL_IND = new Property<String>("putCallInd");
	public static final Property<String> QTY_UOM_CODE = new Property<String>("qtyUomCode");
	public static final Property<BigDecimal> QUANTITY = new Property<BigDecimal>("quantity");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<BigDecimal> STRIKE_PRICE = new Property<BigDecimal>("strikePrice");
	public static final Property<String> TRADING_PRD = new Property<String>("tradingPrd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setClrBrkrNum(Integer clrBrkrNum)
	{
		writeProperty("clrBrkrNum", clrBrkrNum);
	}

	public Integer getClrBrkrNum()
	{
		return (Integer) readProperty("clrBrkrNum");
	}

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setExtPosNum(Integer extPosNum)
	{
		writeProperty("extPosNum", extPosNum);
	}

	public Integer getExtPosNum()
	{
		return (Integer) readProperty("extPosNum");
	}

	public void setItemType(String itemType)
	{
		writeProperty("itemType", itemType);
	}

	public String getItemType()
	{
		return (String) readProperty("itemType");
	}

	public void setPutCallInd(String putCallInd)
	{
		writeProperty("putCallInd", putCallInd);
	}

	public String getPutCallInd()
	{
		return (String) readProperty("putCallInd");
	}

	public void setQtyUomCode(String qtyUomCode)
	{
		writeProperty("qtyUomCode", qtyUomCode);
	}

	public String getQtyUomCode()
	{
		return (String) readProperty("qtyUomCode");
	}

	public void setQuantity(BigDecimal quantity)
	{
		writeProperty("quantity", quantity);
	}

	public BigDecimal getQuantity()
	{
		return (BigDecimal) readProperty("quantity");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setStrikePrice(BigDecimal strikePrice)
	{
		writeProperty("strikePrice", strikePrice);
	}

	public BigDecimal getStrikePrice()
	{
		return (BigDecimal) readProperty("strikePrice");
	}

	public void setTradingPrd(String tradingPrd)
	{
		writeProperty("tradingPrd", tradingPrd);
	}

	public String getTradingPrd()
	{
		return (String) readProperty("tradingPrd");
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
