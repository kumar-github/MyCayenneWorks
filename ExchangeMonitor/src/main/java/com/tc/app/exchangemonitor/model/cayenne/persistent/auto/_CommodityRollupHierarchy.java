package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.CommodityRollupType;

/**
 * Class _CommodityRollupHierarchy was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CommodityRollupHierarchy extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CMDTY_CODE_PK_COLUMN = "cmdty_code";
	public static final String PARENT_CMDTY_CODE_PK_COLUMN = "parent_cmdty_code";
	public static final String ROLLUP_TYPE_CODE_PK_COLUMN = "rollup_type_code";

	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");
	public static final Property<Commodity> COMMODITY1 = new Property<Commodity>("commodity1");
	public static final Property<CommodityRollupType> COMMODITY_ROLLUP_TYPE = new Property<CommodityRollupType>("commodityRollupType");

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCommodity(Commodity commodity)
	{
		setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) readProperty("commodity");
	}

	public void setCommodity1(Commodity commodity1)
	{
		setToOneTarget("commodity1", commodity1, true);
	}

	public Commodity getCommodity1()
	{
		return (Commodity) readProperty("commodity1");
	}

	public void setCommodityRollupType(CommodityRollupType commodityRollupType)
	{
		setToOneTarget("commodityRollupType", commodityRollupType, true);
	}

	public CommodityRollupType getCommodityRollupType()
	{
		return (CommodityRollupType) readProperty("commodityRollupType");
	}

}
