package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _ExchFifoAllocItem was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ExchFifoAllocItem extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String EXCH_FIFO_ALLOC_ITEM_NUM_PK_COLUMN = "exch_fifo_alloc_item_num";
	public static final String EXCH_FIFO_ALLOC_NUM_PK_COLUMN = "exch_fifo_alloc_num";

	public static final Property<BigDecimal> ALLOC_QTY = new Property<>("allocQty");
	public static final Property<Short> FILL_NUM = new Property<>("fillNum");
	public static final Property<Short> ITEM_NUM = new Property<>("itemNum");
	public static final Property<Date> LEDGER_DATE = new Property<>("ledgerDate");
	public static final Property<Short> ORDER_NUM = new Property<>("orderNum");
	public static final Property<String> P_SIND = new Property<>("pSInd");
	public static final Property<Integer> TRADE_NUM = new Property<>("tradeNum");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Uom> UOM = new Property<>("uom");

	public void setAllocQty(final BigDecimal allocQty)
	{
		this.writeProperty("allocQty", allocQty);
	}

	public BigDecimal getAllocQty()
	{
		return (BigDecimal) this.readProperty("allocQty");
	}

	public void setFillNum(final Short fillNum)
	{
		this.writeProperty("fillNum", fillNum);
	}

	public Short getFillNum()
	{
		return (Short) this.readProperty("fillNum");
	}

	public void setItemNum(final Short itemNum)
	{
		this.writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) this.readProperty("itemNum");
	}

	public void setLedgerDate(final Date ledgerDate)
	{
		this.writeProperty("ledgerDate", ledgerDate);
	}

	public Date getLedgerDate()
	{
		return (Date) this.readProperty("ledgerDate");
	}

	public void setOrderNum(final Short orderNum)
	{
		this.writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) this.readProperty("orderNum");
	}

	public void setPSInd(final String pSInd)
	{
		this.writeProperty("pSInd", pSInd);
	}

	public String getPSInd()
	{
		return (String) this.readProperty("pSInd");
	}

	public void setTradeNum(final Integer tradeNum)
	{
		this.writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) this.readProperty("tradeNum");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setUom(final Uom uom)
	{
		this.setToOneTarget("uom", uom, true);
	}

	public Uom getUom()
	{
		return (Uom) this.readProperty("uom");
	}

}
