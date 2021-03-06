package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.LloydsShipParticulars;

/**
 * Class _LloydsPort was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _LloydsPort extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_PORT_CODE_PK_COLUMN = "fldchrPortCode";

	public static final Property<String> FLDVCH_PORT_DESC = new Property<String>("fldvchPortDesc");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<LloydsShipParticulars>> LLOYDS_SHIP_PARTICULARSS = new Property<List<LloydsShipParticulars>>("lloydsShipParticularss");

	public void setFldvchPortDesc(String fldvchPortDesc)
	{
		writeProperty("fldvchPortDesc", fldvchPortDesc);
	}

	public String getFldvchPortDesc()
	{
		return (String) readProperty("fldvchPortDesc");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToLloydsShipParticularss(LloydsShipParticulars obj)
	{
		addToManyTarget("lloydsShipParticularss", obj, true);
	}

	public void removeFromLloydsShipParticularss(LloydsShipParticulars obj)
	{
		removeToManyTarget("lloydsShipParticularss", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<LloydsShipParticulars> getLloydsShipParticularss()
	{
		return (List<LloydsShipParticulars>) readProperty("lloydsShipParticularss");
	}

}
