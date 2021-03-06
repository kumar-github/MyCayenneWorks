package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.CreditTerm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.DeliveryTerm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Location;
import com.tc.app.exchangemonitor.model.cayenne.persistent.LocationTankInfo;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Mot;
import com.tc.app.exchangemonitor.model.cayenne.persistent.PaymentTerm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.PipelineCycle;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _TradeItemStorage was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TradeItemStorage extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ITEM_NUM_PK_COLUMN = "item_num";
	public static final String ORDER_NUM_PK_COLUMN = "order_num";
	public static final String TRADE_NUM_PK_COLUMN = "trade_num";

	public static final Property<BigDecimal> CAPACITY = new Property<>("capacity");
	public static final Property<BigDecimal> HEEL = new Property<>("heel");
	public static final Property<Double> LOSS_ALLOWANCE_QTY = new Property<>("lossAllowanceQty");
	public static final Property<BigDecimal> MIN_OP_REQ_QTY = new Property<>("minOpReqQty");
	public static final Property<Double> MIN_OPERATING_QTY = new Property<>("minOperatingQty");
	public static final Property<Integer> PAY_DAYS = new Property<>("payDays");
	public static final Property<BigDecimal> SAFE_FILL = new Property<>("safeFill");
	public static final Property<Double> SHRINKAGE_QTY = new Property<>("shrinkageQty");
	public static final Property<String> STORAGE_AVAIL_IND = new Property<>("storageAvailInd");
	public static final Property<Date> STORAGE_END_DATE = new Property<>("storageEndDate");
	public static final Property<Integer> STORAGE_PRD = new Property<>("storagePrd");
	public static final Property<Date> STORAGE_START_DATE = new Property<>("storageStartDate");
	public static final Property<String> STORAGE_SUBLOC_NAME = new Property<>("storageSublocName");
	public static final Property<String> SUBLEASE_IND = new Property<>("subleaseInd");
	public static final Property<BigDecimal> TARGET_MAX_QTY = new Property<>("targetMaxQty");
	public static final Property<BigDecimal> TARGET_MIN_QTY = new Property<>("targetMinQty");
	public static final Property<Short> TIMING_CYCLE_YEAR = new Property<>("timingCycleYear");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Commodity> COMMODITY = new Property<>("commodity");
	public static final Property<CreditTerm> CREDIT_TERM = new Property<>("creditTerm");
	public static final Property<DeliveryTerm> DELIVERY_TERM = new Property<>("deliveryTerm");
	public static final Property<Location> LOCATION = new Property<>("location");
	public static final Property<LocationTankInfo> LOCATION_TANK_INFO = new Property<>("locationTankInfo");
	public static final Property<Mot> MOT = new Property<>("mot");
	public static final Property<PaymentTerm> PAYMENT_TERM = new Property<>("paymentTerm");
	public static final Property<PipelineCycle> PIPELINE_CYCLE = new Property<>("pipelineCycle");
	public static final Property<Uom> UOM = new Property<>("uom");
	public static final Property<Uom> UOM1 = new Property<>("uom1");
	public static final Property<Uom> UOM2 = new Property<>("uom2");
	public static final Property<Uom> UOM3 = new Property<>("uom3");

	public void setCapacity(final BigDecimal capacity)
	{
		this.writeProperty("capacity", capacity);
	}

	public BigDecimal getCapacity()
	{
		return (BigDecimal) this.readProperty("capacity");
	}

	public void setHeel(final BigDecimal heel)
	{
		this.writeProperty("heel", heel);
	}

	public BigDecimal getHeel()
	{
		return (BigDecimal) this.readProperty("heel");
	}

	public void setLossAllowanceQty(final Double lossAllowanceQty)
	{
		this.writeProperty("lossAllowanceQty", lossAllowanceQty);
	}

	public Double getLossAllowanceQty()
	{
		return (Double) this.readProperty("lossAllowanceQty");
	}

	public void setMinOpReqQty(final BigDecimal minOpReqQty)
	{
		this.writeProperty("minOpReqQty", minOpReqQty);
	}

	public BigDecimal getMinOpReqQty()
	{
		return (BigDecimal) this.readProperty("minOpReqQty");
	}

	public void setMinOperatingQty(final Double minOperatingQty)
	{
		this.writeProperty("minOperatingQty", minOperatingQty);
	}

	public Double getMinOperatingQty()
	{
		return (Double) this.readProperty("minOperatingQty");
	}

	public void setPayDays(final Integer payDays)
	{
		this.writeProperty("payDays", payDays);
	}

	public Integer getPayDays()
	{
		return (Integer) this.readProperty("payDays");
	}

	public void setSafeFill(final BigDecimal safeFill)
	{
		this.writeProperty("safeFill", safeFill);
	}

	public BigDecimal getSafeFill()
	{
		return (BigDecimal) this.readProperty("safeFill");
	}

	public void setShrinkageQty(final Double shrinkageQty)
	{
		this.writeProperty("shrinkageQty", shrinkageQty);
	}

	public Double getShrinkageQty()
	{
		return (Double) this.readProperty("shrinkageQty");
	}

	public void setStorageAvailInd(final String storageAvailInd)
	{
		this.writeProperty("storageAvailInd", storageAvailInd);
	}

	public String getStorageAvailInd()
	{
		return (String) this.readProperty("storageAvailInd");
	}

	public void setStorageEndDate(final Date storageEndDate)
	{
		this.writeProperty("storageEndDate", storageEndDate);
	}

	public Date getStorageEndDate()
	{
		return (Date) this.readProperty("storageEndDate");
	}

	public void setStoragePrd(final Integer storagePrd)
	{
		this.writeProperty("storagePrd", storagePrd);
	}

	public Integer getStoragePrd()
	{
		return (Integer) this.readProperty("storagePrd");
	}

	public void setStorageStartDate(final Date storageStartDate)
	{
		this.writeProperty("storageStartDate", storageStartDate);
	}

	public Date getStorageStartDate()
	{
		return (Date) this.readProperty("storageStartDate");
	}

	public void setStorageSublocName(final String storageSublocName)
	{
		this.writeProperty("storageSublocName", storageSublocName);
	}

	public String getStorageSublocName()
	{
		return (String) this.readProperty("storageSublocName");
	}

	public void setSubleaseInd(final String subleaseInd)
	{
		this.writeProperty("subleaseInd", subleaseInd);
	}

	public String getSubleaseInd()
	{
		return (String) this.readProperty("subleaseInd");
	}

	public void setTargetMaxQty(final BigDecimal targetMaxQty)
	{
		this.writeProperty("targetMaxQty", targetMaxQty);
	}

	public BigDecimal getTargetMaxQty()
	{
		return (BigDecimal) this.readProperty("targetMaxQty");
	}

	public void setTargetMinQty(final BigDecimal targetMinQty)
	{
		this.writeProperty("targetMinQty", targetMinQty);
	}

	public BigDecimal getTargetMinQty()
	{
		return (BigDecimal) this.readProperty("targetMinQty");
	}

	public void setTimingCycleYear(final Short timingCycleYear)
	{
		this.writeProperty("timingCycleYear", timingCycleYear);
	}

	public Short getTimingCycleYear()
	{
		return (Short) this.readProperty("timingCycleYear");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setCommodity(final Commodity commodity)
	{
		this.setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) this.readProperty("commodity");
	}

	public void setCreditTerm(final CreditTerm creditTerm)
	{
		this.setToOneTarget("creditTerm", creditTerm, true);
	}

	public CreditTerm getCreditTerm()
	{
		return (CreditTerm) this.readProperty("creditTerm");
	}

	public void setDeliveryTerm(final DeliveryTerm deliveryTerm)
	{
		this.setToOneTarget("deliveryTerm", deliveryTerm, true);
	}

	public DeliveryTerm getDeliveryTerm()
	{
		return (DeliveryTerm) this.readProperty("deliveryTerm");
	}

	public void setLocation(final Location location)
	{
		this.setToOneTarget("location", location, true);
	}

	public Location getLocation()
	{
		return (Location) this.readProperty("location");
	}

	public void setLocationTankInfo(final LocationTankInfo locationTankInfo)
	{
		this.setToOneTarget("locationTankInfo", locationTankInfo, true);
	}

	public LocationTankInfo getLocationTankInfo()
	{
		return (LocationTankInfo) this.readProperty("locationTankInfo");
	}

	public void setMot(final Mot mot)
	{
		this.setToOneTarget("mot", mot, true);
	}

	public Mot getMot()
	{
		return (Mot) this.readProperty("mot");
	}

	public void setPaymentTerm(final PaymentTerm paymentTerm)
	{
		this.setToOneTarget("paymentTerm", paymentTerm, true);
	}

	public PaymentTerm getPaymentTerm()
	{
		return (PaymentTerm) this.readProperty("paymentTerm");
	}

	public void setPipelineCycle(final PipelineCycle pipelineCycle)
	{
		this.setToOneTarget("pipelineCycle", pipelineCycle, true);
	}

	public PipelineCycle getPipelineCycle()
	{
		return (PipelineCycle) this.readProperty("pipelineCycle");
	}

	public void setUom(final Uom uom)
	{
		this.setToOneTarget("uom", uom, true);
	}

	public Uom getUom()
	{
		return (Uom) this.readProperty("uom");
	}

	public void setUom1(final Uom uom1)
	{
		this.setToOneTarget("uom1", uom1, true);
	}

	public Uom getUom1()
	{
		return (Uom) this.readProperty("uom1");
	}

	public void setUom2(final Uom uom2)
	{
		this.setToOneTarget("uom2", uom2, true);
	}

	public Uom getUom2()
	{
		return (Uom) this.readProperty("uom2");
	}

	public void setUom3(final Uom uom3)
	{
		this.setToOneTarget("uom3", uom3, true);
	}

	public Uom getUom3()
	{
		return (Uom) this.readProperty("uom3");
	}

}
