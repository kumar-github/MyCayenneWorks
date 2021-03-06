package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.SpreadComposition;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;

/**
 * Class _IctsProduct was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _IctsProduct extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String PRODUCT_ID_PK_COLUMN = "product_id";

	public static final Property<String> ORDER_TYPE = new Property<String>("orderType");
	public static final Property<String> PRODUCT_NAME = new Property<String>("productName");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<SpreadComposition>> SPREAD_COMPOSITIONS = new Property<List<SpreadComposition>>("spreadCompositions");
	public static final Property<List<Trade>> TRADES = new Property<List<Trade>>("trades");

	public void setOrderType(String orderType)
	{
		writeProperty("orderType", orderType);
	}

	public String getOrderType()
	{
		return (String) readProperty("orderType");
	}

	public void setProductName(String productName)
	{
		writeProperty("productName", productName);
	}

	public String getProductName()
	{
		return (String) readProperty("productName");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToSpreadCompositions(SpreadComposition obj)
	{
		addToManyTarget("spreadCompositions", obj, true);
	}

	public void removeFromSpreadCompositions(SpreadComposition obj)
	{
		removeToManyTarget("spreadCompositions", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<SpreadComposition> getSpreadCompositions()
	{
		return (List<SpreadComposition>) readProperty("spreadCompositions");
	}

	public void addToTrades(Trade obj)
	{
		addToManyTarget("trades", obj, true);
	}

	public void removeFromTrades(Trade obj)
	{
		removeToManyTarget("trades", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Trade> getTrades()
	{
		return (List<Trade>) readProperty("trades");
	}

}
