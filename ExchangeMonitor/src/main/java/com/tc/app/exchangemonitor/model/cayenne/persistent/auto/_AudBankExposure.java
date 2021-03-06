package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudBankExposure was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudBankExposure extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<Double> BANK_EXP_AMT = new Property<Double>("bankExpAmt");
	public static final Property<Date> BANK_EXP_DATE = new Property<Date>("bankExpDate");
	public static final Property<String> BANK_EXP_IMP_EXP_IND = new Property<String>("bankExpImpExpInd");
	public static final Property<String> BANK_EXP_LC_TYPE_CODE = new Property<String>("bankExpLcTypeCode");
	public static final Property<Integer> BANK_EXP_NUM = new Property<Integer>("bankExpNum");
	public static final Property<Integer> BOOK_COMP_NUM = new Property<Integer>("bookCompNum");
	public static final Property<String> CMDTY_CODE = new Property<String>("cmdtyCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setBankExpAmt(Double bankExpAmt)
	{
		writeProperty("bankExpAmt", bankExpAmt);
	}

	public Double getBankExpAmt()
	{
		return (Double) readProperty("bankExpAmt");
	}

	public void setBankExpDate(Date bankExpDate)
	{
		writeProperty("bankExpDate", bankExpDate);
	}

	public Date getBankExpDate()
	{
		return (Date) readProperty("bankExpDate");
	}

	public void setBankExpImpExpInd(String bankExpImpExpInd)
	{
		writeProperty("bankExpImpExpInd", bankExpImpExpInd);
	}

	public String getBankExpImpExpInd()
	{
		return (String) readProperty("bankExpImpExpInd");
	}

	public void setBankExpLcTypeCode(String bankExpLcTypeCode)
	{
		writeProperty("bankExpLcTypeCode", bankExpLcTypeCode);
	}

	public String getBankExpLcTypeCode()
	{
		return (String) readProperty("bankExpLcTypeCode");
	}

	public void setBankExpNum(Integer bankExpNum)
	{
		writeProperty("bankExpNum", bankExpNum);
	}

	public Integer getBankExpNum()
	{
		return (Integer) readProperty("bankExpNum");
	}

	public void setBookCompNum(Integer bookCompNum)
	{
		writeProperty("bookCompNum", bookCompNum);
	}

	public Integer getBookCompNum()
	{
		return (Integer) readProperty("bookCompNum");
	}

	public void setCmdtyCode(String cmdtyCode)
	{
		writeProperty("cmdtyCode", cmdtyCode);
	}

	public String getCmdtyCode()
	{
		return (String) readProperty("cmdtyCode");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
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
