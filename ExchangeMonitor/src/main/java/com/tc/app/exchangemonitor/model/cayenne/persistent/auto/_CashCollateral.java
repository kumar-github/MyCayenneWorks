package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.CashCollStatus;

/**
 * Class _CashCollateral was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CashCollateral extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String CASH_COLL_NUM_PK_COLUMN = "cash_coll_num";

	public static final Property<Double> CASH_AMT = new Property<Double>("cashAmt");
	public static final Property<String> CASH_CURR_CODE = new Property<String>("cashCurrCode");
	public static final Property<String> CMNT_TEXT = new Property<String>("cmntText");
	public static final Property<Integer> DOC_NUM = new Property<Integer>("docNum");
	public static final Property<Integer> MCA_NUM = new Property<Integer>("mcaNum");
	public static final Property<Date> REC_DATE = new Property<Date>("recDate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Account> ACCOUNT = new Property<Account>("account");
	public static final Property<CashCollStatus> CASH_COLL_STATUS = new Property<CashCollStatus>("cashCollStatus");

	public void setCashAmt(Double cashAmt)
	{
		writeProperty("cashAmt", cashAmt);
	}

	public Double getCashAmt()
	{
		return (Double) readProperty("cashAmt");
	}

	public void setCashCurrCode(String cashCurrCode)
	{
		writeProperty("cashCurrCode", cashCurrCode);
	}

	public String getCashCurrCode()
	{
		return (String) readProperty("cashCurrCode");
	}

	public void setCmntText(String cmntText)
	{
		writeProperty("cmntText", cmntText);
	}

	public String getCmntText()
	{
		return (String) readProperty("cmntText");
	}

	public void setDocNum(Integer docNum)
	{
		writeProperty("docNum", docNum);
	}

	public Integer getDocNum()
	{
		return (Integer) readProperty("docNum");
	}

	public void setMcaNum(Integer mcaNum)
	{
		writeProperty("mcaNum", mcaNum);
	}

	public Integer getMcaNum()
	{
		return (Integer) readProperty("mcaNum");
	}

	public void setRecDate(Date recDate)
	{
		writeProperty("recDate", recDate);
	}

	public Date getRecDate()
	{
		return (Date) readProperty("recDate");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setAccount(Account account)
	{
		setToOneTarget("account", account, true);
	}

	public Account getAccount()
	{
		return (Account) readProperty("account");
	}

	public void setCashCollStatus(CashCollStatus cashCollStatus)
	{
		setToOneTarget("cashCollStatus", cashCollStatus, true);
	}

	public CashCollStatus getCashCollStatus()
	{
		return (CashCollStatus) readProperty("cashCollStatus");
	}

}
