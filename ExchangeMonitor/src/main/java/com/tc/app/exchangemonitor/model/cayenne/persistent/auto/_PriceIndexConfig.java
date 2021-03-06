package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.PriceIndexSources;

/**
 * Class _PriceIndexConfig was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PriceIndexConfig extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String PRICE_INDEX_CONFIG_KEY_PK_COLUMN = "price_index_config_key";

	public static final Property<String> DESCRIPTION = new Property<String>("description");
	public static final Property<Date> END_DATE = new Property<Date>("endDate");
	public static final Property<String> FORMULA = new Property<String>("formula");
	public static final Property<Date> START_DATE = new Property<Date>("startDate");
	public static final Property<List<PriceIndexSources>> PRICE_INDEX_SOURCESES = new Property<List<PriceIndexSources>>("priceIndexSourceses");

	public void setDescription(String description)
	{
		writeProperty("description", description);
	}

	public String getDescription()
	{
		return (String) readProperty("description");
	}

	public void setEndDate(Date endDate)
	{
		writeProperty("endDate", endDate);
	}

	public Date getEndDate()
	{
		return (Date) readProperty("endDate");
	}

	public void setFormula(String formula)
	{
		writeProperty("formula", formula);
	}

	public String getFormula()
	{
		return (String) readProperty("formula");
	}

	public void setStartDate(Date startDate)
	{
		writeProperty("startDate", startDate);
	}

	public Date getStartDate()
	{
		return (Date) readProperty("startDate");
	}

	public void addToPriceIndexSourceses(PriceIndexSources obj)
	{
		addToManyTarget("priceIndexSourceses", obj, true);
	}

	public void removeFromPriceIndexSourceses(PriceIndexSources obj)
	{
		removeToManyTarget("priceIndexSourceses", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<PriceIndexSources> getPriceIndexSourceses()
	{
		return (List<PriceIndexSources>) readProperty("priceIndexSourceses");
	}

}
