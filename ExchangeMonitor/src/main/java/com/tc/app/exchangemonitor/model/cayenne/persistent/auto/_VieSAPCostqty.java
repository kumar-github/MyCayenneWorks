package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieSAPCostqty was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieSAPCostqty extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_CONTR_KEY = new Property<String>("fldchrContrKey");
	public static final Property<BigDecimal> QTY = new Property<BigDecimal>("qty");
	public static final Property<String> UOM = new Property<String>("uom");

	public void setFldchrContrKey(String fldchrContrKey)
	{
		writeProperty("fldchrContrKey", fldchrContrKey);
	}

	public String getFldchrContrKey()
	{
		return (String) readProperty("fldchrContrKey");
	}

	public void setQty(BigDecimal qty)
	{
		writeProperty("qty", qty);
	}

	public BigDecimal getQty()
	{
		return (BigDecimal) readProperty("qty");
	}

	public void setUom(String uom)
	{
		writeProperty("uom", uom);
	}

	public String getUom()
	{
		return (String) readProperty("uom");
	}

}
