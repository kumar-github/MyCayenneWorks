package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VVoucherPaymentRev was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VVoucherPaymentRev extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ASOF_TRANS_ID = new Property<Integer>("asofTransId");
	public static final Property<Integer> CMNT_NUM = new Property<Integer>("cmntNum");
	public static final Property<BigDecimal> CONFIRMED_AMT = new Property<BigDecimal>("confirmedAmt");
	public static final Property<String> CONFIRMED_AMT_CURR_CODE = new Property<String>("confirmedAmtCurrCode");
	public static final Property<String> CONFIRMED_BY_BANK = new Property<String>("confirmedByBank");
	public static final Property<String> CONFIRMED_BY_CP = new Property<String>("confirmedByCp");
	public static final Property<Integer> EFFECTIVE_ACCT_BANK_ID = new Property<Integer>("effectiveAcctBankId");
	public static final Property<Date> PAID_DATE = new Property<Date>("paidDate");
	public static final Property<String> PAYEE_INIT = new Property<String>("payeeInit");
	public static final Property<Integer> PAYMENT_APPROVAL_TRANS_ID = new Property<Integer>("paymentApprovalTransId");
	public static final Property<String> PAYMENT_STATUS = new Property<String>("paymentStatus");
	public static final Property<Date> PROCESSED_DATE = new Property<Date>("processedDate");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Date> SENT_ON_DATE = new Property<Date>("sentOnDate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Date> VALUE_DATE = new Property<Date>("valueDate");
	public static final Property<Integer> VOUCHER_NUM = new Property<Integer>("voucherNum");
	public static final Property<Double> VOUCHER_PAY_AMT = new Property<Double>("voucherPayAmt");
	public static final Property<String> VOUCHER_PAY_AMT_CURR_CODE = new Property<String>("voucherPayAmtCurrCode");
	public static final Property<Short> VOUCHER_PAY_NUM = new Property<Short>("voucherPayNum");
	public static final Property<String> VOUCHER_PAY_REF = new Property<String>("voucherPayRef");
	public static final Property<String> VOUCHER_PAYMENT_APPLIED_IND = new Property<String>("voucherPaymentAppliedInd");

	public void setAsofTransId(Integer asofTransId)
	{
		writeProperty("asofTransId", asofTransId);
	}

	public Integer getAsofTransId()
	{
		return (Integer) readProperty("asofTransId");
	}

	public void setCmntNum(Integer cmntNum)
	{
		writeProperty("cmntNum", cmntNum);
	}

	public Integer getCmntNum()
	{
		return (Integer) readProperty("cmntNum");
	}

	public void setConfirmedAmt(BigDecimal confirmedAmt)
	{
		writeProperty("confirmedAmt", confirmedAmt);
	}

	public BigDecimal getConfirmedAmt()
	{
		return (BigDecimal) readProperty("confirmedAmt");
	}

	public void setConfirmedAmtCurrCode(String confirmedAmtCurrCode)
	{
		writeProperty("confirmedAmtCurrCode", confirmedAmtCurrCode);
	}

	public String getConfirmedAmtCurrCode()
	{
		return (String) readProperty("confirmedAmtCurrCode");
	}

	public void setConfirmedByBank(String confirmedByBank)
	{
		writeProperty("confirmedByBank", confirmedByBank);
	}

	public String getConfirmedByBank()
	{
		return (String) readProperty("confirmedByBank");
	}

	public void setConfirmedByCp(String confirmedByCp)
	{
		writeProperty("confirmedByCp", confirmedByCp);
	}

	public String getConfirmedByCp()
	{
		return (String) readProperty("confirmedByCp");
	}

	public void setEffectiveAcctBankId(Integer effectiveAcctBankId)
	{
		writeProperty("effectiveAcctBankId", effectiveAcctBankId);
	}

	public Integer getEffectiveAcctBankId()
	{
		return (Integer) readProperty("effectiveAcctBankId");
	}

	public void setPaidDate(Date paidDate)
	{
		writeProperty("paidDate", paidDate);
	}

	public Date getPaidDate()
	{
		return (Date) readProperty("paidDate");
	}

	public void setPayeeInit(String payeeInit)
	{
		writeProperty("payeeInit", payeeInit);
	}

	public String getPayeeInit()
	{
		return (String) readProperty("payeeInit");
	}

	public void setPaymentApprovalTransId(Integer paymentApprovalTransId)
	{
		writeProperty("paymentApprovalTransId", paymentApprovalTransId);
	}

	public Integer getPaymentApprovalTransId()
	{
		return (Integer) readProperty("paymentApprovalTransId");
	}

	public void setPaymentStatus(String paymentStatus)
	{
		writeProperty("paymentStatus", paymentStatus);
	}

	public String getPaymentStatus()
	{
		return (String) readProperty("paymentStatus");
	}

	public void setProcessedDate(Date processedDate)
	{
		writeProperty("processedDate", processedDate);
	}

	public Date getProcessedDate()
	{
		return (Date) readProperty("processedDate");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setSentOnDate(Date sentOnDate)
	{
		writeProperty("sentOnDate", sentOnDate);
	}

	public Date getSentOnDate()
	{
		return (Date) readProperty("sentOnDate");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setValueDate(Date valueDate)
	{
		writeProperty("valueDate", valueDate);
	}

	public Date getValueDate()
	{
		return (Date) readProperty("valueDate");
	}

	public void setVoucherNum(Integer voucherNum)
	{
		writeProperty("voucherNum", voucherNum);
	}

	public Integer getVoucherNum()
	{
		return (Integer) readProperty("voucherNum");
	}

	public void setVoucherPayAmt(Double voucherPayAmt)
	{
		writeProperty("voucherPayAmt", voucherPayAmt);
	}

	public Double getVoucherPayAmt()
	{
		return (Double) readProperty("voucherPayAmt");
	}

	public void setVoucherPayAmtCurrCode(String voucherPayAmtCurrCode)
	{
		writeProperty("voucherPayAmtCurrCode", voucherPayAmtCurrCode);
	}

	public String getVoucherPayAmtCurrCode()
	{
		return (String) readProperty("voucherPayAmtCurrCode");
	}

	public void setVoucherPayNum(Short voucherPayNum)
	{
		writeProperty("voucherPayNum", voucherPayNum);
	}

	public Short getVoucherPayNum()
	{
		return (Short) readProperty("voucherPayNum");
	}

	public void setVoucherPayRef(String voucherPayRef)
	{
		writeProperty("voucherPayRef", voucherPayRef);
	}

	public String getVoucherPayRef()
	{
		return (String) readProperty("voucherPayRef");
	}

	public void setVoucherPaymentAppliedInd(String voucherPaymentAppliedInd)
	{
		writeProperty("voucherPaymentAppliedInd", voucherPaymentAppliedInd);
	}

	public String getVoucherPaymentAppliedInd()
	{
		return (String) readProperty("voucherPaymentAppliedInd");
	}

}
