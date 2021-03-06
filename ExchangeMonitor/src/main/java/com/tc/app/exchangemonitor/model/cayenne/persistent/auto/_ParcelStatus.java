package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Parcel;

/**
 * Class _ParcelStatus was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ParcelStatus extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> ENABLE_PROFIT_LOSS = new Property<String>("enableProfitLoss");
	public static final Property<String> STATUS_DESCRIPTION = new Property<String>("statusDescription");
	public static final Property<Short> STATUS_IND = new Property<Short>("statusInd");
	public static final Property<Short> STATUS_WORKFLOW_RANK = new Property<Short>("statusWorkflowRank");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<Parcel>> PARCELS = new Property<List<Parcel>>("parcels");

	public void setEnableProfitLoss(String enableProfitLoss)
	{
		writeProperty("enableProfitLoss", enableProfitLoss);
	}

	public String getEnableProfitLoss()
	{
		return (String) readProperty("enableProfitLoss");
	}

	public void setStatusDescription(String statusDescription)
	{
		writeProperty("statusDescription", statusDescription);
	}

	public String getStatusDescription()
	{
		return (String) readProperty("statusDescription");
	}

	public void setStatusInd(Short statusInd)
	{
		writeProperty("statusInd", statusInd);
	}

	public Short getStatusInd()
	{
		return (Short) readProperty("statusInd");
	}

	public void setStatusWorkflowRank(Short statusWorkflowRank)
	{
		writeProperty("statusWorkflowRank", statusWorkflowRank);
	}

	public Short getStatusWorkflowRank()
	{
		return (Short) readProperty("statusWorkflowRank");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToParcels(Parcel obj)
	{
		addToManyTarget("parcels", obj, true);
	}

	public void removeFromParcels(Parcel obj)
	{
		removeToManyTarget("parcels", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Parcel> getParcels()
	{
		return (List<Parcel>) readProperty("parcels");
	}

}
