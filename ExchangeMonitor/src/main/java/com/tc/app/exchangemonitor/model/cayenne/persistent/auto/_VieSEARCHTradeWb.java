package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VieSEARCHTradeWb was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VieSEARCHTradeWb extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FLDCHR_ANLST_USER_FULL_NAME = new Property<String>("fldchrAnlstUserFullName");
	public static final Property<String> FLDCHR_ANLST_USER_INIT = new Property<String>("fldchrAnlstUserInit");
	public static final Property<String> FLDCHR_BILLING_TYPE_FLAG = new Property<String>("fldchrBillingTypeFlag");
	public static final Property<String> FLDCHR_BOOKC_FULL_NAME = new Property<String>("fldchrBookcFullName");
	public static final Property<String> FLDCHR_BOOKC_SHORT_NAME = new Property<String>("fldchrBookcShortName");
	public static final Property<String> FLDCHR_BROKER_FULL_NAME = new Property<String>("fldchrBrokerFullName");
	public static final Property<String> FLDCHR_CHART_MODE_FLAG = new Property<String>("fldchrChartModeFlag");
	public static final Property<String> FLDCHR_CMDTY_FULL_NAME = new Property<String>("fldchrCmdtyFullName");
	public static final Property<String> FLDCHR_COASTWISE_FLAG = new Property<String>("fldchrCoastwiseFlag");
	public static final Property<String> FLDCHR_CONTR_KEY = new Property<String>("fldchrContrKey");
	public static final Property<String> FLDCHR_CONTR_NUM = new Property<String>("fldchrContrNum");
	public static final Property<String> FLDCHR_CONTR_STATUS = new Property<String>("fldchrContrStatus");
	public static final Property<String> FLDCHR_CONTR_TYPE_FLAG = new Property<String>("fldchrContrTypeFlag");
	public static final Property<String> FLDCHR_CPART_FULL_NAME = new Property<String>("fldchrCpartFullName");
	public static final Property<String> FLDCHR_CREDIT_TERM_CODE = new Property<String>("fldchrCreditTermCode");
	public static final Property<String> FLDCHR_DELIVERY_LOCT = new Property<String>("fldchrDeliveryLoct");
	public static final Property<String> FLDCHR_DOMESTIC_FLAG = new Property<String>("fldchrDomesticFlag");
	public static final Property<String> FLDCHR_FIXTURE_PREFIX = new Property<String>("fldchrFixturePrefix");
	public static final Property<String> FLDCHR_FREIGHT_CALCULATION_FLAG = new Property<String>("fldchrFreightCalculationFlag");
	public static final Property<String> FLDCHR_GOODS_CHEMICAL_FLAG = new Property<String>("fldchrGoodsChemicalFlag");
	public static final Property<String> FLDCHR_GOODS_CLEAN_FLAG = new Property<String>("fldchrGoodsCleanFlag");
	public static final Property<String> FLDCHR_GOODS_CRUDES_FLAG = new Property<String>("fldchrGoodsCrudesFlag");
	public static final Property<String> FLDCHR_GOODS_DIRTY_FLAG = new Property<String>("fldchrGoodsDirtyFlag");
	public static final Property<String> FLDCHR_GOODS_GAS_FLAG = new Property<String>("fldchrGoodsGasFlag");
	public static final Property<String> FLDCHR_GOODS_LUBRICANTS_FLAG = new Property<String>("fldchrGoodsLubricantsFlag");
	public static final Property<String> FLDCHR_GOODS_SEMIREFINED_FLAG = new Property<String>("fldchrGoodsSemirefinedFlag");
	public static final Property<String> FLDCHR_GTC_CODE = new Property<String>("fldchrGtcCode");
	public static final Property<String> FLDCHR_LLOYDS_REF_NUM = new Property<String>("fldchrLloydsRefNum");
	public static final Property<String> FLDCHR_MOT_CODE = new Property<String>("fldchrMotCode");
	public static final Property<String> FLDCHR_PAYABLE_FULL_NAME = new Property<String>("fldchrPayableFullName");
	public static final Property<String> FLDCHR_PAYMENT_TERM_CODE = new Property<String>("fldchrPaymentTermCode");
	public static final Property<String> FLDCHR_REDELIVERY_LOCT = new Property<String>("fldchrRedeliveryLoct");
	public static final Property<String> FLDCHR_SHIP_OWN_FULL_NAME = new Property<String>("fldchrShipOwnFullName");
	public static final Property<String> FLDCHR_TRAD_USER_INIT = new Property<String>("fldchrTradUserInit");
	public static final Property<String> FLDCHR_TRADE_USER_FULL_NAME = new Property<String>("fldchrTradeUserFullName");
	public static final Property<BigDecimal> FLDDEC_MIN_QTY = new Property<BigDecimal>("flddecMinQty");
	public static final Property<BigDecimal> FLDDEC_PSHARE_BASE_RATE = new Property<BigDecimal>("flddecPShareBaseRate");
	public static final Property<BigDecimal> FLDDEC_PSHARE_PCTG = new Property<BigDecimal>("flddecPSharePctg");
	public static final Property<Integer> FLDINT_BOOKC_ACCT_NUM = new Property<Integer>("fldintBookcAcctNum");
	public static final Property<Integer> FLDINT_BROKER_ACCT_NUM = new Property<Integer>("fldintBrokerAcctNum");
	public static final Property<Integer> FLDINT_CPART_ACCT_NUM = new Property<Integer>("fldintCpartAcctNum");
	public static final Property<Integer> FLDINT_PAYABLE_ACCT_NUM = new Property<Integer>("fldintPayableAcctNum");
	public static final Property<Integer> FLDINT_SHIP_OWN_ACCT_NUM = new Property<Integer>("fldintShipOwnAcctNum");
	public static final Property<Date> FLDSDT_CONTR_END_DATE = new Property<Date>("fldsdtContrEndDate");
	public static final Property<Date> FLDSDT_CONTR_START_DATE = new Property<Date>("fldsdtContrStartDate");
	public static final Property<Date> FLDSDT_CPARTY_DATE = new Property<Date>("fldsdtCpartyDate");
	public static final Property<Date> FLDSDT_DELIVERY_LCAN_END = new Property<Date>("fldsdtDeliveryLcanEnd");
	public static final Property<Date> FLDSDT_DELIVERY_LCAN_START = new Property<Date>("fldsdtDeliveryLcanStart");
	public static final Property<Date> FLDSDT_LOAD_LCAN_END = new Property<Date>("fldsdtLoadLcanEnd");
	public static final Property<Date> FLDSDT_LOAD_LCAN_START = new Property<Date>("fldsdtLoadLcanStart");
	public static final Property<Date> FLDSDT_NEGOTIATION_DATE = new Property<Date>("fldsdtNegotiationDate");
	public static final Property<Date> FLDSDT_REDELIVERY_LCAN_END = new Property<Date>("fldsdtRedeliveryLcanEnd");
	public static final Property<Date> FLDSDT_REDELIVERY_LCAN_START = new Property<Date>("fldsdtRedeliveryLcanStart");
	public static final Property<Date> FLDSDT_SUBJECTS_DATE = new Property<Date>("fldsdtSubjectsDate");
	public static final Property<Date> FLDSDT_UNLD_LCAN_END = new Property<Date>("fldsdtUnldLcanEnd");
	public static final Property<Date> FLDSDT_UNLD_LCAN_START = new Property<Date>("fldsdtUnldLcanStart");
	public static final Property<String> FLDVCH_FIXTURE_NUMBER = new Property<String>("fldvchFixtureNumber");
	public static final Property<String> FLDVCH_MOT_FULL_NAME = new Property<String>("fldvchMotFullName");
	public static final Property<String> FLDVCH_MOT_SHORT_NAME = new Property<String>("fldvchMotShortName");
	public static final Property<String> FLDVCH_REQUEST_NUM = new Property<String>("fldvchRequestNum");

	public void setFldchrAnlstUserFullName(String fldchrAnlstUserFullName)
	{
		writeProperty("fldchrAnlstUserFullName", fldchrAnlstUserFullName);
	}

	public String getFldchrAnlstUserFullName()
	{
		return (String) readProperty("fldchrAnlstUserFullName");
	}

	public void setFldchrAnlstUserInit(String fldchrAnlstUserInit)
	{
		writeProperty("fldchrAnlstUserInit", fldchrAnlstUserInit);
	}

	public String getFldchrAnlstUserInit()
	{
		return (String) readProperty("fldchrAnlstUserInit");
	}

	public void setFldchrBillingTypeFlag(String fldchrBillingTypeFlag)
	{
		writeProperty("fldchrBillingTypeFlag", fldchrBillingTypeFlag);
	}

	public String getFldchrBillingTypeFlag()
	{
		return (String) readProperty("fldchrBillingTypeFlag");
	}

	public void setFldchrBookcFullName(String fldchrBookcFullName)
	{
		writeProperty("fldchrBookcFullName", fldchrBookcFullName);
	}

	public String getFldchrBookcFullName()
	{
		return (String) readProperty("fldchrBookcFullName");
	}

	public void setFldchrBookcShortName(String fldchrBookcShortName)
	{
		writeProperty("fldchrBookcShortName", fldchrBookcShortName);
	}

	public String getFldchrBookcShortName()
	{
		return (String) readProperty("fldchrBookcShortName");
	}

	public void setFldchrBrokerFullName(String fldchrBrokerFullName)
	{
		writeProperty("fldchrBrokerFullName", fldchrBrokerFullName);
	}

	public String getFldchrBrokerFullName()
	{
		return (String) readProperty("fldchrBrokerFullName");
	}

	public void setFldchrChartModeFlag(String fldchrChartModeFlag)
	{
		writeProperty("fldchrChartModeFlag", fldchrChartModeFlag);
	}

	public String getFldchrChartModeFlag()
	{
		return (String) readProperty("fldchrChartModeFlag");
	}

	public void setFldchrCmdtyFullName(String fldchrCmdtyFullName)
	{
		writeProperty("fldchrCmdtyFullName", fldchrCmdtyFullName);
	}

	public String getFldchrCmdtyFullName()
	{
		return (String) readProperty("fldchrCmdtyFullName");
	}

	public void setFldchrCoastwiseFlag(String fldchrCoastwiseFlag)
	{
		writeProperty("fldchrCoastwiseFlag", fldchrCoastwiseFlag);
	}

	public String getFldchrCoastwiseFlag()
	{
		return (String) readProperty("fldchrCoastwiseFlag");
	}

	public void setFldchrContrKey(String fldchrContrKey)
	{
		writeProperty("fldchrContrKey", fldchrContrKey);
	}

	public String getFldchrContrKey()
	{
		return (String) readProperty("fldchrContrKey");
	}

	public void setFldchrContrNum(String fldchrContrNum)
	{
		writeProperty("fldchrContrNum", fldchrContrNum);
	}

	public String getFldchrContrNum()
	{
		return (String) readProperty("fldchrContrNum");
	}

	public void setFldchrContrStatus(String fldchrContrStatus)
	{
		writeProperty("fldchrContrStatus", fldchrContrStatus);
	}

	public String getFldchrContrStatus()
	{
		return (String) readProperty("fldchrContrStatus");
	}

	public void setFldchrContrTypeFlag(String fldchrContrTypeFlag)
	{
		writeProperty("fldchrContrTypeFlag", fldchrContrTypeFlag);
	}

	public String getFldchrContrTypeFlag()
	{
		return (String) readProperty("fldchrContrTypeFlag");
	}

	public void setFldchrCpartFullName(String fldchrCpartFullName)
	{
		writeProperty("fldchrCpartFullName", fldchrCpartFullName);
	}

	public String getFldchrCpartFullName()
	{
		return (String) readProperty("fldchrCpartFullName");
	}

	public void setFldchrCreditTermCode(String fldchrCreditTermCode)
	{
		writeProperty("fldchrCreditTermCode", fldchrCreditTermCode);
	}

	public String getFldchrCreditTermCode()
	{
		return (String) readProperty("fldchrCreditTermCode");
	}

	public void setFldchrDeliveryLoct(String fldchrDeliveryLoct)
	{
		writeProperty("fldchrDeliveryLoct", fldchrDeliveryLoct);
	}

	public String getFldchrDeliveryLoct()
	{
		return (String) readProperty("fldchrDeliveryLoct");
	}

	public void setFldchrDomesticFlag(String fldchrDomesticFlag)
	{
		writeProperty("fldchrDomesticFlag", fldchrDomesticFlag);
	}

	public String getFldchrDomesticFlag()
	{
		return (String) readProperty("fldchrDomesticFlag");
	}

	public void setFldchrFixturePrefix(String fldchrFixturePrefix)
	{
		writeProperty("fldchrFixturePrefix", fldchrFixturePrefix);
	}

	public String getFldchrFixturePrefix()
	{
		return (String) readProperty("fldchrFixturePrefix");
	}

	public void setFldchrFreightCalculationFlag(String fldchrFreightCalculationFlag)
	{
		writeProperty("fldchrFreightCalculationFlag", fldchrFreightCalculationFlag);
	}

	public String getFldchrFreightCalculationFlag()
	{
		return (String) readProperty("fldchrFreightCalculationFlag");
	}

	public void setFldchrGoodsChemicalFlag(String fldchrGoodsChemicalFlag)
	{
		writeProperty("fldchrGoodsChemicalFlag", fldchrGoodsChemicalFlag);
	}

	public String getFldchrGoodsChemicalFlag()
	{
		return (String) readProperty("fldchrGoodsChemicalFlag");
	}

	public void setFldchrGoodsCleanFlag(String fldchrGoodsCleanFlag)
	{
		writeProperty("fldchrGoodsCleanFlag", fldchrGoodsCleanFlag);
	}

	public String getFldchrGoodsCleanFlag()
	{
		return (String) readProperty("fldchrGoodsCleanFlag");
	}

	public void setFldchrGoodsCrudesFlag(String fldchrGoodsCrudesFlag)
	{
		writeProperty("fldchrGoodsCrudesFlag", fldchrGoodsCrudesFlag);
	}

	public String getFldchrGoodsCrudesFlag()
	{
		return (String) readProperty("fldchrGoodsCrudesFlag");
	}

	public void setFldchrGoodsDirtyFlag(String fldchrGoodsDirtyFlag)
	{
		writeProperty("fldchrGoodsDirtyFlag", fldchrGoodsDirtyFlag);
	}

	public String getFldchrGoodsDirtyFlag()
	{
		return (String) readProperty("fldchrGoodsDirtyFlag");
	}

	public void setFldchrGoodsGasFlag(String fldchrGoodsGasFlag)
	{
		writeProperty("fldchrGoodsGasFlag", fldchrGoodsGasFlag);
	}

	public String getFldchrGoodsGasFlag()
	{
		return (String) readProperty("fldchrGoodsGasFlag");
	}

	public void setFldchrGoodsLubricantsFlag(String fldchrGoodsLubricantsFlag)
	{
		writeProperty("fldchrGoodsLubricantsFlag", fldchrGoodsLubricantsFlag);
	}

	public String getFldchrGoodsLubricantsFlag()
	{
		return (String) readProperty("fldchrGoodsLubricantsFlag");
	}

	public void setFldchrGoodsSemirefinedFlag(String fldchrGoodsSemirefinedFlag)
	{
		writeProperty("fldchrGoodsSemirefinedFlag", fldchrGoodsSemirefinedFlag);
	}

	public String getFldchrGoodsSemirefinedFlag()
	{
		return (String) readProperty("fldchrGoodsSemirefinedFlag");
	}

	public void setFldchrGtcCode(String fldchrGtcCode)
	{
		writeProperty("fldchrGtcCode", fldchrGtcCode);
	}

	public String getFldchrGtcCode()
	{
		return (String) readProperty("fldchrGtcCode");
	}

	public void setFldchrLloydsRefNum(String fldchrLloydsRefNum)
	{
		writeProperty("fldchrLloydsRefNum", fldchrLloydsRefNum);
	}

	public String getFldchrLloydsRefNum()
	{
		return (String) readProperty("fldchrLloydsRefNum");
	}

	public void setFldchrMotCode(String fldchrMotCode)
	{
		writeProperty("fldchrMotCode", fldchrMotCode);
	}

	public String getFldchrMotCode()
	{
		return (String) readProperty("fldchrMotCode");
	}

	public void setFldchrPayableFullName(String fldchrPayableFullName)
	{
		writeProperty("fldchrPayableFullName", fldchrPayableFullName);
	}

	public String getFldchrPayableFullName()
	{
		return (String) readProperty("fldchrPayableFullName");
	}

	public void setFldchrPaymentTermCode(String fldchrPaymentTermCode)
	{
		writeProperty("fldchrPaymentTermCode", fldchrPaymentTermCode);
	}

	public String getFldchrPaymentTermCode()
	{
		return (String) readProperty("fldchrPaymentTermCode");
	}

	public void setFldchrRedeliveryLoct(String fldchrRedeliveryLoct)
	{
		writeProperty("fldchrRedeliveryLoct", fldchrRedeliveryLoct);
	}

	public String getFldchrRedeliveryLoct()
	{
		return (String) readProperty("fldchrRedeliveryLoct");
	}

	public void setFldchrShipOwnFullName(String fldchrShipOwnFullName)
	{
		writeProperty("fldchrShipOwnFullName", fldchrShipOwnFullName);
	}

	public String getFldchrShipOwnFullName()
	{
		return (String) readProperty("fldchrShipOwnFullName");
	}

	public void setFldchrTradUserInit(String fldchrTradUserInit)
	{
		writeProperty("fldchrTradUserInit", fldchrTradUserInit);
	}

	public String getFldchrTradUserInit()
	{
		return (String) readProperty("fldchrTradUserInit");
	}

	public void setFldchrTradeUserFullName(String fldchrTradeUserFullName)
	{
		writeProperty("fldchrTradeUserFullName", fldchrTradeUserFullName);
	}

	public String getFldchrTradeUserFullName()
	{
		return (String) readProperty("fldchrTradeUserFullName");
	}

	public void setFlddecMinQty(BigDecimal flddecMinQty)
	{
		writeProperty("flddecMinQty", flddecMinQty);
	}

	public BigDecimal getFlddecMinQty()
	{
		return (BigDecimal) readProperty("flddecMinQty");
	}

	public void setFlddecPShareBaseRate(BigDecimal flddecPShareBaseRate)
	{
		writeProperty("flddecPShareBaseRate", flddecPShareBaseRate);
	}

	public BigDecimal getFlddecPShareBaseRate()
	{
		return (BigDecimal) readProperty("flddecPShareBaseRate");
	}

	public void setFlddecPSharePctg(BigDecimal flddecPSharePctg)
	{
		writeProperty("flddecPSharePctg", flddecPSharePctg);
	}

	public BigDecimal getFlddecPSharePctg()
	{
		return (BigDecimal) readProperty("flddecPSharePctg");
	}

	public void setFldintBookcAcctNum(Integer fldintBookcAcctNum)
	{
		writeProperty("fldintBookcAcctNum", fldintBookcAcctNum);
	}

	public Integer getFldintBookcAcctNum()
	{
		return (Integer) readProperty("fldintBookcAcctNum");
	}

	public void setFldintBrokerAcctNum(Integer fldintBrokerAcctNum)
	{
		writeProperty("fldintBrokerAcctNum", fldintBrokerAcctNum);
	}

	public Integer getFldintBrokerAcctNum()
	{
		return (Integer) readProperty("fldintBrokerAcctNum");
	}

	public void setFldintCpartAcctNum(Integer fldintCpartAcctNum)
	{
		writeProperty("fldintCpartAcctNum", fldintCpartAcctNum);
	}

	public Integer getFldintCpartAcctNum()
	{
		return (Integer) readProperty("fldintCpartAcctNum");
	}

	public void setFldintPayableAcctNum(Integer fldintPayableAcctNum)
	{
		writeProperty("fldintPayableAcctNum", fldintPayableAcctNum);
	}

	public Integer getFldintPayableAcctNum()
	{
		return (Integer) readProperty("fldintPayableAcctNum");
	}

	public void setFldintShipOwnAcctNum(Integer fldintShipOwnAcctNum)
	{
		writeProperty("fldintShipOwnAcctNum", fldintShipOwnAcctNum);
	}

	public Integer getFldintShipOwnAcctNum()
	{
		return (Integer) readProperty("fldintShipOwnAcctNum");
	}

	public void setFldsdtContrEndDate(Date fldsdtContrEndDate)
	{
		writeProperty("fldsdtContrEndDate", fldsdtContrEndDate);
	}

	public Date getFldsdtContrEndDate()
	{
		return (Date) readProperty("fldsdtContrEndDate");
	}

	public void setFldsdtContrStartDate(Date fldsdtContrStartDate)
	{
		writeProperty("fldsdtContrStartDate", fldsdtContrStartDate);
	}

	public Date getFldsdtContrStartDate()
	{
		return (Date) readProperty("fldsdtContrStartDate");
	}

	public void setFldsdtCpartyDate(Date fldsdtCpartyDate)
	{
		writeProperty("fldsdtCpartyDate", fldsdtCpartyDate);
	}

	public Date getFldsdtCpartyDate()
	{
		return (Date) readProperty("fldsdtCpartyDate");
	}

	public void setFldsdtDeliveryLcanEnd(Date fldsdtDeliveryLcanEnd)
	{
		writeProperty("fldsdtDeliveryLcanEnd", fldsdtDeliveryLcanEnd);
	}

	public Date getFldsdtDeliveryLcanEnd()
	{
		return (Date) readProperty("fldsdtDeliveryLcanEnd");
	}

	public void setFldsdtDeliveryLcanStart(Date fldsdtDeliveryLcanStart)
	{
		writeProperty("fldsdtDeliveryLcanStart", fldsdtDeliveryLcanStart);
	}

	public Date getFldsdtDeliveryLcanStart()
	{
		return (Date) readProperty("fldsdtDeliveryLcanStart");
	}

	public void setFldsdtLoadLcanEnd(Date fldsdtLoadLcanEnd)
	{
		writeProperty("fldsdtLoadLcanEnd", fldsdtLoadLcanEnd);
	}

	public Date getFldsdtLoadLcanEnd()
	{
		return (Date) readProperty("fldsdtLoadLcanEnd");
	}

	public void setFldsdtLoadLcanStart(Date fldsdtLoadLcanStart)
	{
		writeProperty("fldsdtLoadLcanStart", fldsdtLoadLcanStart);
	}

	public Date getFldsdtLoadLcanStart()
	{
		return (Date) readProperty("fldsdtLoadLcanStart");
	}

	public void setFldsdtNegotiationDate(Date fldsdtNegotiationDate)
	{
		writeProperty("fldsdtNegotiationDate", fldsdtNegotiationDate);
	}

	public Date getFldsdtNegotiationDate()
	{
		return (Date) readProperty("fldsdtNegotiationDate");
	}

	public void setFldsdtRedeliveryLcanEnd(Date fldsdtRedeliveryLcanEnd)
	{
		writeProperty("fldsdtRedeliveryLcanEnd", fldsdtRedeliveryLcanEnd);
	}

	public Date getFldsdtRedeliveryLcanEnd()
	{
		return (Date) readProperty("fldsdtRedeliveryLcanEnd");
	}

	public void setFldsdtRedeliveryLcanStart(Date fldsdtRedeliveryLcanStart)
	{
		writeProperty("fldsdtRedeliveryLcanStart", fldsdtRedeliveryLcanStart);
	}

	public Date getFldsdtRedeliveryLcanStart()
	{
		return (Date) readProperty("fldsdtRedeliveryLcanStart");
	}

	public void setFldsdtSubjectsDate(Date fldsdtSubjectsDate)
	{
		writeProperty("fldsdtSubjectsDate", fldsdtSubjectsDate);
	}

	public Date getFldsdtSubjectsDate()
	{
		return (Date) readProperty("fldsdtSubjectsDate");
	}

	public void setFldsdtUnldLcanEnd(Date fldsdtUnldLcanEnd)
	{
		writeProperty("fldsdtUnldLcanEnd", fldsdtUnldLcanEnd);
	}

	public Date getFldsdtUnldLcanEnd()
	{
		return (Date) readProperty("fldsdtUnldLcanEnd");
	}

	public void setFldsdtUnldLcanStart(Date fldsdtUnldLcanStart)
	{
		writeProperty("fldsdtUnldLcanStart", fldsdtUnldLcanStart);
	}

	public Date getFldsdtUnldLcanStart()
	{
		return (Date) readProperty("fldsdtUnldLcanStart");
	}

	public void setFldvchFixtureNumber(String fldvchFixtureNumber)
	{
		writeProperty("fldvchFixtureNumber", fldvchFixtureNumber);
	}

	public String getFldvchFixtureNumber()
	{
		return (String) readProperty("fldvchFixtureNumber");
	}

	public void setFldvchMotFullName(String fldvchMotFullName)
	{
		writeProperty("fldvchMotFullName", fldvchMotFullName);
	}

	public String getFldvchMotFullName()
	{
		return (String) readProperty("fldvchMotFullName");
	}

	public void setFldvchMotShortName(String fldvchMotShortName)
	{
		writeProperty("fldvchMotShortName", fldvchMotShortName);
	}

	public String getFldvchMotShortName()
	{
		return (String) readProperty("fldvchMotShortName");
	}

	public void setFldvchRequestNum(String fldvchRequestNum)
	{
		writeProperty("fldvchRequestNum", fldvchRequestNum);
	}

	public String getFldvchRequestNum()
	{
		return (String) readProperty("fldvchRequestNum");
	}

}
