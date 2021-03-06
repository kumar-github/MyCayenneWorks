package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Location;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Mot;
import com.tc.app.exchangemonitor.model.cayenne.persistent.MotLocationTariff;

/**
 * Class _MotLocation was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MotLocation extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String LOC_CODE_PK_COLUMN = "loc_code";
	public static final String MOT_CODE_PK_COLUMN = "mot_code";

	public static final Property<Short> LOC_SEQ_NUM = new Property<>("locSeqNum");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Location> LOCATION = new Property<>("location");
	public static final Property<Mot> MOT = new Property<>("mot");
	public static final Property<List<MotLocationTariff>> MOT_LOCATION_TARIFFS = new Property<>("motLocationTariffs");
	public static final Property<List<MotLocationTariff>> MOT_LOCATION_TARIFFS1 = new Property<>("motLocationTariffs1");

	public void setLocSeqNum(final Short locSeqNum)
	{
		this.writeProperty("locSeqNum", locSeqNum);
	}

	public Short getLocSeqNum()
	{
		return (Short) this.readProperty("locSeqNum");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setLocation(final Location location)
	{
		this.setToOneTarget("location", location, true);
	}

	public Location getLocation()
	{
		return (Location) this.readProperty("location");
	}

	public void setMot(final Mot mot)
	{
		this.setToOneTarget("mot", mot, true);
	}

	public Mot getMot()
	{
		return (Mot) this.readProperty("mot");
	}

	public void addToMotLocationTariffs(final MotLocationTariff obj)
	{
		this.addToManyTarget("motLocationTariffs", obj, true);
	}

	public void removeFromMotLocationTariffs(final MotLocationTariff obj)
	{
		this.removeToManyTarget("motLocationTariffs", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<MotLocationTariff> getMotLocationTariffs()
	{
		return (List<MotLocationTariff>) this.readProperty("motLocationTariffs");
	}

	public void addToMotLocationTariffs1(final MotLocationTariff obj)
	{
		this.addToManyTarget("motLocationTariffs1", obj, true);
	}

	public void removeFromMotLocationTariffs1(final MotLocationTariff obj)
	{
		this.removeToManyTarget("motLocationTariffs1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<MotLocationTariff> getMotLocationTariffs1()
	{
		return (List<MotLocationTariff>) this.readProperty("motLocationTariffs1");
	}

}
