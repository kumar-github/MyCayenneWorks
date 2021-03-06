package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _CostScheduledPrice was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostScheduledPrice extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String COST_NUM_PK_COLUMN = "cost_num";

	public static final Property<String> MINI_USE_INCL_IND = new Property<String>("miniUseInclInd");
	public static final Property<Double> MINI_USG = new Property<Double>("miniUsg");
	public static final Property<Double> MINI_USG_FEE = new Property<Double>("miniUsgFee");
	public static final Property<String> MINI_USG_TEST_IND = new Property<String>("miniUsgTestInd");
	public static final Property<String> REFERENCE = new Property<String>("reference");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> VOLUME_SCALE = new Property<String>("volumeScale");
	public static final Property<String> VOLUME_USG_FROM = new Property<String>("volumeUsgFrom");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");
	public static final Property<Uom> UOM = new Property<Uom>("uom");

	public void setMiniUseInclInd(String miniUseInclInd)
	{
		writeProperty("miniUseInclInd", miniUseInclInd);
	}

	public String getMiniUseInclInd()
	{
		return (String) readProperty("miniUseInclInd");
	}

	public void setMiniUsg(Double miniUsg)
	{
		writeProperty("miniUsg", miniUsg);
	}

	public Double getMiniUsg()
	{
		return (Double) readProperty("miniUsg");
	}

	public void setMiniUsgFee(Double miniUsgFee)
	{
		writeProperty("miniUsgFee", miniUsgFee);
	}

	public Double getMiniUsgFee()
	{
		return (Double) readProperty("miniUsgFee");
	}

	public void setMiniUsgTestInd(String miniUsgTestInd)
	{
		writeProperty("miniUsgTestInd", miniUsgTestInd);
	}

	public String getMiniUsgTestInd()
	{
		return (String) readProperty("miniUsgTestInd");
	}

	public void setReference(String reference)
	{
		writeProperty("reference", reference);
	}

	public String getReference()
	{
		return (String) readProperty("reference");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setVolumeScale(String volumeScale)
	{
		writeProperty("volumeScale", volumeScale);
	}

	public String getVolumeScale()
	{
		return (String) readProperty("volumeScale");
	}

	public void setVolumeUsgFrom(String volumeUsgFrom)
	{
		writeProperty("volumeUsgFrom", volumeUsgFrom);
	}

	public String getVolumeUsgFrom()
	{
		return (String) readProperty("volumeUsgFrom");
	}

	public void setCommodity(Commodity commodity)
	{
		setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) readProperty("commodity");
	}

	public void setUom(Uom uom)
	{
		setToOneTarget("uom", uom, true);
	}

	public Uom getUom()
	{
		return (Uom) readProperty("uom");
	}

}
