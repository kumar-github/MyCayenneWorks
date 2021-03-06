package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _UomConversion was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _UomConversion extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String UOM_CONV_NUM_PK_COLUMN = "uom_conv_num";

	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Double> UOM_API_VAL = new Property<Double>("uomApiVal");
	public static final Property<String> UOM_CONV_OPER = new Property<String>("uomConvOper");
	public static final Property<Double> UOM_CONV_RATE = new Property<Double>("uomConvRate");
	public static final Property<Double> UOM_GRAVITY_VAL = new Property<Double>("uomGravityVal");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");
	public static final Property<Uom> UOM = new Property<Uom>("uom");
	public static final Property<Uom> UOM1 = new Property<Uom>("uom1");

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setUomApiVal(Double uomApiVal)
	{
		writeProperty("uomApiVal", uomApiVal);
	}

	public Double getUomApiVal()
	{
		return (Double) readProperty("uomApiVal");
	}

	public void setUomConvOper(String uomConvOper)
	{
		writeProperty("uomConvOper", uomConvOper);
	}

	public String getUomConvOper()
	{
		return (String) readProperty("uomConvOper");
	}

	public void setUomConvRate(Double uomConvRate)
	{
		writeProperty("uomConvRate", uomConvRate);
	}

	public Double getUomConvRate()
	{
		return (Double) readProperty("uomConvRate");
	}

	public void setUomGravityVal(Double uomGravityVal)
	{
		writeProperty("uomGravityVal", uomGravityVal);
	}

	public Double getUomGravityVal()
	{
		return (Double) readProperty("uomGravityVal");
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

	public void setUom1(Uom uom1)
	{
		setToOneTarget("uom1", uom1, true);
	}

	public Uom getUom1()
	{
		return (Uom) readProperty("uom1");
	}

}
