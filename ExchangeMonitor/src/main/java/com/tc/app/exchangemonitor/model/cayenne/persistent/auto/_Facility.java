package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountContact;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountInstruction;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FacilityTankGroup;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Location;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Parcel;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemDryPhy;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemWetPhy;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _Facility was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Facility extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FACILITY_CODE_PK_COLUMN = "facility_code";

	public static final Property<BigDecimal> CAPACITY = new Property<>("capacity");
	public static final Property<String> FACILITY_LONG_NAME = new Property<>("facilityLongName");
	public static final Property<String> FACILITY_SHORT_NAME = new Property<>("facilityShortName");
	public static final Property<String> FACILITY_TYPE_CODE = new Property<>("facilityTypeCode");
	public static final Property<String> STOCK_LOCATION_IND = new Property<>("stockLocationInd");
	public static final Property<String> TAX_JURISDICTION_CODE = new Property<>("taxJurisdictionCode");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS = new Property<>("accountAddress");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS1 = new Property<>("accountAddress1");
	public static final Property<AccountContact> ACCOUNT_CONTACT = new Property<>("accountContact");
	public static final Property<AccountContact> ACCOUNT_CONTACT1 = new Property<>("accountContact1");
	public static final Property<AccountInstruction> ACCOUNT_INSTRUCTION = new Property<>("accountInstruction");
	public static final Property<AccountInstruction> ACCOUNT_INSTRUCTION1 = new Property<>("accountInstruction1");
	public static final Property<List<FacilityTankGroup>> FACILITY_TANK_GROUPS = new Property<>("facilityTankGroups");
	public static final Property<Location> LOCATION = new Property<>("location");
	public static final Property<List<Parcel>> PARCELS = new Property<>("parcels");
	public static final Property<List<TradeItemDryPhy>> TRADE_ITEM_DRY_PHIES = new Property<>("tradeItemDryPhies");
	public static final Property<List<TradeItemWetPhy>> TRADE_ITEM_WET_PHIES = new Property<>("tradeItemWetPhies");
	public static final Property<Uom> UOM = new Property<>("uom");

	public void setCapacity(final BigDecimal capacity)
	{
		this.writeProperty("capacity", capacity);
	}

	public BigDecimal getCapacity()
	{
		return (BigDecimal) this.readProperty("capacity");
	}

	public void setFacilityLongName(final String facilityLongName)
	{
		this.writeProperty("facilityLongName", facilityLongName);
	}

	public String getFacilityLongName()
	{
		return (String) this.readProperty("facilityLongName");
	}

	public void setFacilityShortName(final String facilityShortName)
	{
		this.writeProperty("facilityShortName", facilityShortName);
	}

	public String getFacilityShortName()
	{
		return (String) this.readProperty("facilityShortName");
	}

	public void setFacilityTypeCode(final String facilityTypeCode)
	{
		this.writeProperty("facilityTypeCode", facilityTypeCode);
	}

	public String getFacilityTypeCode()
	{
		return (String) this.readProperty("facilityTypeCode");
	}

	public void setStockLocationInd(final String stockLocationInd)
	{
		this.writeProperty("stockLocationInd", stockLocationInd);
	}

	public String getStockLocationInd()
	{
		return (String) this.readProperty("stockLocationInd");
	}

	public void setTaxJurisdictionCode(final String taxJurisdictionCode)
	{
		this.writeProperty("taxJurisdictionCode", taxJurisdictionCode);
	}

	public String getTaxJurisdictionCode()
	{
		return (String) this.readProperty("taxJurisdictionCode");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setAccountAddress(final AccountAddress accountAddress)
	{
		this.setToOneTarget("accountAddress", accountAddress, true);
	}

	public AccountAddress getAccountAddress()
	{
		return (AccountAddress) this.readProperty("accountAddress");
	}

	public void setAccountAddress1(final AccountAddress accountAddress1)
	{
		this.setToOneTarget("accountAddress1", accountAddress1, true);
	}

	public AccountAddress getAccountAddress1()
	{
		return (AccountAddress) this.readProperty("accountAddress1");
	}

	public void setAccountContact(final AccountContact accountContact)
	{
		this.setToOneTarget("accountContact", accountContact, true);
	}

	public AccountContact getAccountContact()
	{
		return (AccountContact) this.readProperty("accountContact");
	}

	public void setAccountContact1(final AccountContact accountContact1)
	{
		this.setToOneTarget("accountContact1", accountContact1, true);
	}

	public AccountContact getAccountContact1()
	{
		return (AccountContact) this.readProperty("accountContact1");
	}

	public void setAccountInstruction(final AccountInstruction accountInstruction)
	{
		this.setToOneTarget("accountInstruction", accountInstruction, true);
	}

	public AccountInstruction getAccountInstruction()
	{
		return (AccountInstruction) this.readProperty("accountInstruction");
	}

	public void setAccountInstruction1(final AccountInstruction accountInstruction1)
	{
		this.setToOneTarget("accountInstruction1", accountInstruction1, true);
	}

	public AccountInstruction getAccountInstruction1()
	{
		return (AccountInstruction) this.readProperty("accountInstruction1");
	}

	public void addToFacilityTankGroups(final FacilityTankGroup obj)
	{
		this.addToManyTarget("facilityTankGroups", obj, true);
	}

	public void removeFromFacilityTankGroups(final FacilityTankGroup obj)
	{
		this.removeToManyTarget("facilityTankGroups", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FacilityTankGroup> getFacilityTankGroups()
	{
		return (List<FacilityTankGroup>) this.readProperty("facilityTankGroups");
	}

	public void setLocation(final Location location)
	{
		this.setToOneTarget("location", location, true);
	}

	public Location getLocation()
	{
		return (Location) this.readProperty("location");
	}

	public void addToParcels(final Parcel obj)
	{
		this.addToManyTarget("parcels", obj, true);
	}

	public void removeFromParcels(final Parcel obj)
	{
		this.removeToManyTarget("parcels", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Parcel> getParcels()
	{
		return (List<Parcel>) this.readProperty("parcels");
	}

	public void addToTradeItemDryPhies(final TradeItemDryPhy obj)
	{
		this.addToManyTarget("tradeItemDryPhies", obj, true);
	}

	public void removeFromTradeItemDryPhies(final TradeItemDryPhy obj)
	{
		this.removeToManyTarget("tradeItemDryPhies", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemDryPhy> getTradeItemDryPhies()
	{
		return (List<TradeItemDryPhy>) this.readProperty("tradeItemDryPhies");
	}

	public void addToTradeItemWetPhies(final TradeItemWetPhy obj)
	{
		this.addToManyTarget("tradeItemWetPhies", obj, true);
	}

	public void removeFromTradeItemWetPhies(final TradeItemWetPhy obj)
	{
		this.removeToManyTarget("tradeItemWetPhies", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemWetPhy> getTradeItemWetPhies()
	{
		return (List<TradeItemWetPhy>) this.readProperty("tradeItemWetPhies");
	}

	public void setUom(final Uom uom)
	{
		this.setToOneTarget("uom", uom, true);
	}

	public Uom getUom()
	{
		return (Uom) this.readProperty("uom");
	}

}
