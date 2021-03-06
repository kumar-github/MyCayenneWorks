package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VTsAssignTrade1 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VTsAssignTrade1 extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Integer> LC_COMMENT = new Property<Integer>("lcComment");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");

	public void setItemNum(Short itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) readProperty("itemNum");
	}

	public void setLcComment(Integer lcComment)
	{
		writeProperty("lcComment", lcComment);
	}

	public Integer getLcComment()
	{
		return (Integer) readProperty("lcComment");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

}
