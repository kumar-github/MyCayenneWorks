package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudTradeItemStorage was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudTradeItemStorage extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<BigDecimal> CAPACITY = new Property<BigDecimal>("capacity");
	public static final Property<String> CREDIT_TERM_CODE = new Property<String>("creditTermCode");
	public static final Property<String> DEL_TERM_CODE = new Property<String>("delTermCode");
	public static final Property<BigDecimal> HEEL = new Property<BigDecimal>("heel");
	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Double> LOSS_ALLOWANCE_QTY = new Property<Double>("lossAllowanceQty");
	public static final Property<String> LOSS_ALLOWANCE_UOM_CODE = new Property<String>("lossAllowanceUomCode");
	public static final Property<BigDecimal> MIN_OP_REQ_QTY = new Property<BigDecimal>("minOpReqQty");
	public static final Property<Double> MIN_OPERATING_QTY = new Property<Double>("minOperatingQty");
	public static final Property<String> MIN_OPERATING_QTY_UOM_CODE = new Property<String>("minOperatingQtyUomCode");
	public static final Property<String> MOT_CODE = new Property<String>("motCode");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<Integer> PAY_DAYS = new Property<Integer>("payDays");
	public static final Property<String> PAY_TERM_CODE = new Property<String>("payTermCode");
	public static final Property<Integer> PIPELINE_CYCLE_NUM = new Property<Integer>("pipelineCycleNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<BigDecimal> SAFE_FILL = new Property<BigDecimal>("safeFill");
	public static final Property<Double> SHRINKAGE_QTY = new Property<Double>("shrinkageQty");
	public static final Property<String> SHRINKAGE_UOM_CODE = new Property<String>("shrinkageUomCode");
	public static final Property<String> STORAGE_AVAIL_IND = new Property<String>("storageAvailInd");
	public static final Property<Date> STORAGE_END_DATE = new Property<Date>("storageEndDate");
	public static final Property<String> STORAGE_LOC_CODE = new Property<String>("storageLocCode");
	public static final Property<Integer> STORAGE_PRD = new Property<Integer>("storagePrd");
	public static final Property<String> STORAGE_PRD_UOM_CODE = new Property<String>("storagePrdUomCode");
	public static final Property<Date> STORAGE_START_DATE = new Property<Date>("storageStartDate");
	public static final Property<String> STORAGE_SUBLOC_NAME = new Property<String>("storageSublocName");
	public static final Property<String> STORED_CMDTY_CODE = new Property<String>("storedCmdtyCode");
	public static final Property<String> SUBLEASE_IND = new Property<String>("subleaseInd");
	public static final Property<Integer> TANK_NUM = new Property<Integer>("tankNum");
	public static final Property<BigDecimal> TARGET_MAX_QTY = new Property<BigDecimal>("targetMaxQty");
	public static final Property<BigDecimal> TARGET_MIN_QTY = new Property<BigDecimal>("targetMinQty");
	public static final Property<Short> TIMING_CYCLE_YEAR = new Property<Short>("timingCycleYear");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setCapacity(BigDecimal capacity)
	{
		writeProperty("capacity", capacity);
	}

	public BigDecimal getCapacity()
	{
		return (BigDecimal) readProperty("capacity");
	}

	public void setCreditTermCode(String creditTermCode)
	{
		writeProperty("creditTermCode", creditTermCode);
	}

	public String getCreditTermCode()
	{
		return (String) readProperty("creditTermCode");
	}

	public void setDelTermCode(String delTermCode)
	{
		writeProperty("delTermCode", delTermCode);
	}

	public String getDelTermCode()
	{
		return (String) readProperty("delTermCode");
	}

	public void setHeel(BigDecimal heel)
	{
		writeProperty("heel", heel);
	}

	public BigDecimal getHeel()
	{
		return (BigDecimal) readProperty("heel");
	}

	public void setItemNum(Short itemNum)
	{
		writeProperty("itemNum", itemNum);
	}

	public Short getItemNum()
	{
		return (Short) readProperty("itemNum");
	}

	public void setLossAllowanceQty(Double lossAllowanceQty)
	{
		writeProperty("lossAllowanceQty", lossAllowanceQty);
	}

	public Double getLossAllowanceQty()
	{
		return (Double) readProperty("lossAllowanceQty");
	}

	public void setLossAllowanceUomCode(String lossAllowanceUomCode)
	{
		writeProperty("lossAllowanceUomCode", lossAllowanceUomCode);
	}

	public String getLossAllowanceUomCode()
	{
		return (String) readProperty("lossAllowanceUomCode");
	}

	public void setMinOpReqQty(BigDecimal minOpReqQty)
	{
		writeProperty("minOpReqQty", minOpReqQty);
	}

	public BigDecimal getMinOpReqQty()
	{
		return (BigDecimal) readProperty("minOpReqQty");
	}

	public void setMinOperatingQty(Double minOperatingQty)
	{
		writeProperty("minOperatingQty", minOperatingQty);
	}

	public Double getMinOperatingQty()
	{
		return (Double) readProperty("minOperatingQty");
	}

	public void setMinOperatingQtyUomCode(String minOperatingQtyUomCode)
	{
		writeProperty("minOperatingQtyUomCode", minOperatingQtyUomCode);
	}

	public String getMinOperatingQtyUomCode()
	{
		return (String) readProperty("minOperatingQtyUomCode");
	}

	public void setMotCode(String motCode)
	{
		writeProperty("motCode", motCode);
	}

	public String getMotCode()
	{
		return (String) readProperty("motCode");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setPayDays(Integer payDays)
	{
		writeProperty("payDays", payDays);
	}

	public Integer getPayDays()
	{
		return (Integer) readProperty("payDays");
	}

	public void setPayTermCode(String payTermCode)
	{
		writeProperty("payTermCode", payTermCode);
	}

	public String getPayTermCode()
	{
		return (String) readProperty("payTermCode");
	}

	public void setPipelineCycleNum(Integer pipelineCycleNum)
	{
		writeProperty("pipelineCycleNum", pipelineCycleNum);
	}

	public Integer getPipelineCycleNum()
	{
		return (Integer) readProperty("pipelineCycleNum");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setSafeFill(BigDecimal safeFill)
	{
		writeProperty("safeFill", safeFill);
	}

	public BigDecimal getSafeFill()
	{
		return (BigDecimal) readProperty("safeFill");
	}

	public void setShrinkageQty(Double shrinkageQty)
	{
		writeProperty("shrinkageQty", shrinkageQty);
	}

	public Double getShrinkageQty()
	{
		return (Double) readProperty("shrinkageQty");
	}

	public void setShrinkageUomCode(String shrinkageUomCode)
	{
		writeProperty("shrinkageUomCode", shrinkageUomCode);
	}

	public String getShrinkageUomCode()
	{
		return (String) readProperty("shrinkageUomCode");
	}

	public void setStorageAvailInd(String storageAvailInd)
	{
		writeProperty("storageAvailInd", storageAvailInd);
	}

	public String getStorageAvailInd()
	{
		return (String) readProperty("storageAvailInd");
	}

	public void setStorageEndDate(Date storageEndDate)
	{
		writeProperty("storageEndDate", storageEndDate);
	}

	public Date getStorageEndDate()
	{
		return (Date) readProperty("storageEndDate");
	}

	public void setStorageLocCode(String storageLocCode)
	{
		writeProperty("storageLocCode", storageLocCode);
	}

	public String getStorageLocCode()
	{
		return (String) readProperty("storageLocCode");
	}

	public void setStoragePrd(Integer storagePrd)
	{
		writeProperty("storagePrd", storagePrd);
	}

	public Integer getStoragePrd()
	{
		return (Integer) readProperty("storagePrd");
	}

	public void setStoragePrdUomCode(String storagePrdUomCode)
	{
		writeProperty("storagePrdUomCode", storagePrdUomCode);
	}

	public String getStoragePrdUomCode()
	{
		return (String) readProperty("storagePrdUomCode");
	}

	public void setStorageStartDate(Date storageStartDate)
	{
		writeProperty("storageStartDate", storageStartDate);
	}

	public Date getStorageStartDate()
	{
		return (Date) readProperty("storageStartDate");
	}

	public void setStorageSublocName(String storageSublocName)
	{
		writeProperty("storageSublocName", storageSublocName);
	}

	public String getStorageSublocName()
	{
		return (String) readProperty("storageSublocName");
	}

	public void setStoredCmdtyCode(String storedCmdtyCode)
	{
		writeProperty("storedCmdtyCode", storedCmdtyCode);
	}

	public String getStoredCmdtyCode()
	{
		return (String) readProperty("storedCmdtyCode");
	}

	public void setSubleaseInd(String subleaseInd)
	{
		writeProperty("subleaseInd", subleaseInd);
	}

	public String getSubleaseInd()
	{
		return (String) readProperty("subleaseInd");
	}

	public void setTankNum(Integer tankNum)
	{
		writeProperty("tankNum", tankNum);
	}

	public Integer getTankNum()
	{
		return (Integer) readProperty("tankNum");
	}

	public void setTargetMaxQty(BigDecimal targetMaxQty)
	{
		writeProperty("targetMaxQty", targetMaxQty);
	}

	public BigDecimal getTargetMaxQty()
	{
		return (BigDecimal) readProperty("targetMaxQty");
	}

	public void setTargetMinQty(BigDecimal targetMinQty)
	{
		writeProperty("targetMinQty", targetMinQty);
	}

	public BigDecimal getTargetMinQty()
	{
		return (BigDecimal) readProperty("targetMinQty");
	}

	public void setTimingCycleYear(Short timingCycleYear)
	{
		writeProperty("timingCycleYear", timingCycleYear);
	}

	public Short getTimingCycleYear()
	{
		return (Short) readProperty("timingCycleYear");
	}

	public void setTradeNum(Integer tradeNum)
	{
		writeProperty("tradeNum", tradeNum);
	}

	public Integer getTradeNum()
	{
		return (Integer) readProperty("tradeNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

}
