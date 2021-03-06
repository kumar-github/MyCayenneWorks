package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VTradeItemTransportRev was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VTradeItemTransportRev extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ASOF_TRANS_ID = new Property<Integer>("asofTransId");
	public static final Property<BigDecimal> CAPACITY = new Property<BigDecimal>("capacity");
	public static final Property<String> CONTAINER_IND = new Property<String>("containerInd");
	public static final Property<String> CREDIT_TERM_CODE = new Property<String>("creditTermCode");
	public static final Property<String> DEL_LOC_CODE = new Property<String>("delLocCode");
	public static final Property<String> DEMURRAGE_CURR_CODE = new Property<String>("demurrageCurrCode");
	public static final Property<String> DEMURRAGE_PERIODICITY = new Property<String>("demurragePeriodicity");
	public static final Property<Double> DEMURRAGE_PRICE = new Property<Double>("demurragePrice");
	public static final Property<Date> DISCH_DATE_FROM = new Property<Date>("dischDateFrom");
	public static final Property<Date> DISCH_DATE_TO = new Property<Date>("dischDateTo");
	public static final Property<String> DISPATCH_CURR_CODE = new Property<String>("dispatchCurrCode");
	public static final Property<String> DISPATCH_PERIODICITY = new Property<String>("dispatchPeriodicity");
	public static final Property<Double> DISPATCH_PRICE = new Property<Double>("dispatchPrice");
	public static final Property<Short> FREE_TIME = new Property<Short>("freeTime");
	public static final Property<String> FREE_TIME_UOM_CODE = new Property<String>("freeTimeUomCode");
	public static final Property<BigDecimal> HEEL = new Property<BigDecimal>("heel");
	public static final Property<Short> ITEM_NUM = new Property<Short>("itemNum");
	public static final Property<Date> LOAD_DATE_FROM = new Property<Date>("loadDateFrom");
	public static final Property<Date> LOAD_DATE_TO = new Property<Date>("loadDateTo");
	public static final Property<String> LOAD_LOC_CODE = new Property<String>("loadLocCode");
	public static final Property<Double> LOSS_ALLOWANCE_QTY = new Property<Double>("lossAllowanceQty");
	public static final Property<String> LOSS_ALLOWANCE_UOM_CODE = new Property<String>("lossAllowanceUomCode");
	public static final Property<Double> MAX_QTY = new Property<Double>("maxQty");
	public static final Property<String> MAX_QTY_UOM_CODE = new Property<String>("maxQtyUomCode");
	public static final Property<BigDecimal> MIN_OP_REQ_QTY = new Property<BigDecimal>("minOpReqQty");
	public static final Property<Double> MIN_QTY = new Property<Double>("minQty");
	public static final Property<String> MIN_QTY_UOM_CODE = new Property<String>("minQtyUomCode");
	public static final Property<Double> MIN_SHIP_QTY = new Property<Double>("minShipQty");
	public static final Property<String> MIN_SHIP_QTY_UOM_CODE = new Property<String>("minShipQtyUomCode");
	public static final Property<String> MOT_CODE = new Property<String>("motCode");
	public static final Property<Integer> NUMBER_OF_TRUCKS = new Property<Integer>("numberOfTrucks");
	public static final Property<Short> ORDER_NUM = new Property<Short>("orderNum");
	public static final Property<String> OVERRUN_CURR_CODE = new Property<String>("overrunCurrCode");
	public static final Property<Double> OVERRUN_PRICE = new Property<Double>("overrunPrice");
	public static final Property<String> OVERRUN_UOM_CODE = new Property<String>("overrunUomCode");
	public static final Property<Integer> PAY_DAYS = new Property<Integer>("payDays");
	public static final Property<String> PAY_TERM_CODE = new Property<String>("payTermCode");
	public static final Property<Integer> PIPELINE_CYCLE_NUM = new Property<Integer>("pipelineCycleNum");
	public static final Property<Double> PUMP_RATE_QTY = new Property<Double>("pumpRateQty");
	public static final Property<String> PUMP_RATE_QTY_UOM_CODE = new Property<String>("pumpRateQtyUomCode");
	public static final Property<String> PUMP_RATE_TIME_UOM_CODE = new Property<String>("pumpRateTimeUomCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<BigDecimal> SAFE_FILL = new Property<BigDecimal>("safeFill");
	public static final Property<Double> SHRINKAGE_QTY = new Property<Double>("shrinkageQty");
	public static final Property<String> SHRINKAGE_UOM_CODE = new Property<String>("shrinkageUomCode");
	public static final Property<Integer> TANK_NUM = new Property<Integer>("tankNum");
	public static final Property<BigDecimal> TARGET_MAX_QTY = new Property<BigDecimal>("targetMaxQty");
	public static final Property<BigDecimal> TARGET_MIN_QTY = new Property<BigDecimal>("targetMinQty");
	public static final Property<Short> TIMING_CYCLE_YEAR = new Property<Short>("timingCycleYear");
	public static final Property<Double> TOL_QTY = new Property<Double>("tolQty");
	public static final Property<String> TOL_QTY_UOM_CODE = new Property<String>("tolQtyUomCode");
	public static final Property<String> TOL_SIGN = new Property<String>("tolSign");
	public static final Property<Integer> TRADE_NUM = new Property<Integer>("tradeNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> TRANSPORT_CMDTY_CODE = new Property<String>("transportCmdtyCode");
	public static final Property<String> TRANSPORTATION = new Property<String>("transportation");

	public void setAsofTransId(Integer asofTransId)
	{
		writeProperty("asofTransId", asofTransId);
	}

	public Integer getAsofTransId()
	{
		return (Integer) readProperty("asofTransId");
	}

	public void setCapacity(BigDecimal capacity)
	{
		writeProperty("capacity", capacity);
	}

	public BigDecimal getCapacity()
	{
		return (BigDecimal) readProperty("capacity");
	}

	public void setContainerInd(String containerInd)
	{
		writeProperty("containerInd", containerInd);
	}

	public String getContainerInd()
	{
		return (String) readProperty("containerInd");
	}

	public void setCreditTermCode(String creditTermCode)
	{
		writeProperty("creditTermCode", creditTermCode);
	}

	public String getCreditTermCode()
	{
		return (String) readProperty("creditTermCode");
	}

	public void setDelLocCode(String delLocCode)
	{
		writeProperty("delLocCode", delLocCode);
	}

	public String getDelLocCode()
	{
		return (String) readProperty("delLocCode");
	}

	public void setDemurrageCurrCode(String demurrageCurrCode)
	{
		writeProperty("demurrageCurrCode", demurrageCurrCode);
	}

	public String getDemurrageCurrCode()
	{
		return (String) readProperty("demurrageCurrCode");
	}

	public void setDemurragePeriodicity(String demurragePeriodicity)
	{
		writeProperty("demurragePeriodicity", demurragePeriodicity);
	}

	public String getDemurragePeriodicity()
	{
		return (String) readProperty("demurragePeriodicity");
	}

	public void setDemurragePrice(Double demurragePrice)
	{
		writeProperty("demurragePrice", demurragePrice);
	}

	public Double getDemurragePrice()
	{
		return (Double) readProperty("demurragePrice");
	}

	public void setDischDateFrom(Date dischDateFrom)
	{
		writeProperty("dischDateFrom", dischDateFrom);
	}

	public Date getDischDateFrom()
	{
		return (Date) readProperty("dischDateFrom");
	}

	public void setDischDateTo(Date dischDateTo)
	{
		writeProperty("dischDateTo", dischDateTo);
	}

	public Date getDischDateTo()
	{
		return (Date) readProperty("dischDateTo");
	}

	public void setDispatchCurrCode(String dispatchCurrCode)
	{
		writeProperty("dispatchCurrCode", dispatchCurrCode);
	}

	public String getDispatchCurrCode()
	{
		return (String) readProperty("dispatchCurrCode");
	}

	public void setDispatchPeriodicity(String dispatchPeriodicity)
	{
		writeProperty("dispatchPeriodicity", dispatchPeriodicity);
	}

	public String getDispatchPeriodicity()
	{
		return (String) readProperty("dispatchPeriodicity");
	}

	public void setDispatchPrice(Double dispatchPrice)
	{
		writeProperty("dispatchPrice", dispatchPrice);
	}

	public Double getDispatchPrice()
	{
		return (Double) readProperty("dispatchPrice");
	}

	public void setFreeTime(Short freeTime)
	{
		writeProperty("freeTime", freeTime);
	}

	public Short getFreeTime()
	{
		return (Short) readProperty("freeTime");
	}

	public void setFreeTimeUomCode(String freeTimeUomCode)
	{
		writeProperty("freeTimeUomCode", freeTimeUomCode);
	}

	public String getFreeTimeUomCode()
	{
		return (String) readProperty("freeTimeUomCode");
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

	public void setLoadDateFrom(Date loadDateFrom)
	{
		writeProperty("loadDateFrom", loadDateFrom);
	}

	public Date getLoadDateFrom()
	{
		return (Date) readProperty("loadDateFrom");
	}

	public void setLoadDateTo(Date loadDateTo)
	{
		writeProperty("loadDateTo", loadDateTo);
	}

	public Date getLoadDateTo()
	{
		return (Date) readProperty("loadDateTo");
	}

	public void setLoadLocCode(String loadLocCode)
	{
		writeProperty("loadLocCode", loadLocCode);
	}

	public String getLoadLocCode()
	{
		return (String) readProperty("loadLocCode");
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

	public void setMaxQty(Double maxQty)
	{
		writeProperty("maxQty", maxQty);
	}

	public Double getMaxQty()
	{
		return (Double) readProperty("maxQty");
	}

	public void setMaxQtyUomCode(String maxQtyUomCode)
	{
		writeProperty("maxQtyUomCode", maxQtyUomCode);
	}

	public String getMaxQtyUomCode()
	{
		return (String) readProperty("maxQtyUomCode");
	}

	public void setMinOpReqQty(BigDecimal minOpReqQty)
	{
		writeProperty("minOpReqQty", minOpReqQty);
	}

	public BigDecimal getMinOpReqQty()
	{
		return (BigDecimal) readProperty("minOpReqQty");
	}

	public void setMinQty(Double minQty)
	{
		writeProperty("minQty", minQty);
	}

	public Double getMinQty()
	{
		return (Double) readProperty("minQty");
	}

	public void setMinQtyUomCode(String minQtyUomCode)
	{
		writeProperty("minQtyUomCode", minQtyUomCode);
	}

	public String getMinQtyUomCode()
	{
		return (String) readProperty("minQtyUomCode");
	}

	public void setMinShipQty(Double minShipQty)
	{
		writeProperty("minShipQty", minShipQty);
	}

	public Double getMinShipQty()
	{
		return (Double) readProperty("minShipQty");
	}

	public void setMinShipQtyUomCode(String minShipQtyUomCode)
	{
		writeProperty("minShipQtyUomCode", minShipQtyUomCode);
	}

	public String getMinShipQtyUomCode()
	{
		return (String) readProperty("minShipQtyUomCode");
	}

	public void setMotCode(String motCode)
	{
		writeProperty("motCode", motCode);
	}

	public String getMotCode()
	{
		return (String) readProperty("motCode");
	}

	public void setNumberOfTrucks(Integer numberOfTrucks)
	{
		writeProperty("numberOfTrucks", numberOfTrucks);
	}

	public Integer getNumberOfTrucks()
	{
		return (Integer) readProperty("numberOfTrucks");
	}

	public void setOrderNum(Short orderNum)
	{
		writeProperty("orderNum", orderNum);
	}

	public Short getOrderNum()
	{
		return (Short) readProperty("orderNum");
	}

	public void setOverrunCurrCode(String overrunCurrCode)
	{
		writeProperty("overrunCurrCode", overrunCurrCode);
	}

	public String getOverrunCurrCode()
	{
		return (String) readProperty("overrunCurrCode");
	}

	public void setOverrunPrice(Double overrunPrice)
	{
		writeProperty("overrunPrice", overrunPrice);
	}

	public Double getOverrunPrice()
	{
		return (Double) readProperty("overrunPrice");
	}

	public void setOverrunUomCode(String overrunUomCode)
	{
		writeProperty("overrunUomCode", overrunUomCode);
	}

	public String getOverrunUomCode()
	{
		return (String) readProperty("overrunUomCode");
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

	public void setPumpRateQty(Double pumpRateQty)
	{
		writeProperty("pumpRateQty", pumpRateQty);
	}

	public Double getPumpRateQty()
	{
		return (Double) readProperty("pumpRateQty");
	}

	public void setPumpRateQtyUomCode(String pumpRateQtyUomCode)
	{
		writeProperty("pumpRateQtyUomCode", pumpRateQtyUomCode);
	}

	public String getPumpRateQtyUomCode()
	{
		return (String) readProperty("pumpRateQtyUomCode");
	}

	public void setPumpRateTimeUomCode(String pumpRateTimeUomCode)
	{
		writeProperty("pumpRateTimeUomCode", pumpRateTimeUomCode);
	}

	public String getPumpRateTimeUomCode()
	{
		return (String) readProperty("pumpRateTimeUomCode");
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

	public void setTolQty(Double tolQty)
	{
		writeProperty("tolQty", tolQty);
	}

	public Double getTolQty()
	{
		return (Double) readProperty("tolQty");
	}

	public void setTolQtyUomCode(String tolQtyUomCode)
	{
		writeProperty("tolQtyUomCode", tolQtyUomCode);
	}

	public String getTolQtyUomCode()
	{
		return (String) readProperty("tolQtyUomCode");
	}

	public void setTolSign(String tolSign)
	{
		writeProperty("tolSign", tolSign);
	}

	public String getTolSign()
	{
		return (String) readProperty("tolSign");
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

	public void setTransportCmdtyCode(String transportCmdtyCode)
	{
		writeProperty("transportCmdtyCode", transportCmdtyCode);
	}

	public String getTransportCmdtyCode()
	{
		return (String) readProperty("transportCmdtyCode");
	}

	public void setTransportation(String transportation)
	{
		writeProperty("transportation", transportation);
	}

	public String getTransportation()
	{
		return (String) readProperty("transportation");
	}

}
