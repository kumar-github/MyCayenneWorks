package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudAccountAddress was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudAccountAddress extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ACCOUNTING_SYSTEM_ID = new Property<String>("accountingSystemId");
	public static final Property<String> ACCT_ADDR_CITY = new Property<String>("acctAddrCity");
	public static final Property<String> ACCT_ADDR_EMAIL = new Property<String>("acctAddrEmail");
	public static final Property<String> ACCT_ADDR_FAX_ANSBACK = new Property<String>("acctAddrFaxAnsback");
	public static final Property<String> ACCT_ADDR_FAX_NUM = new Property<String>("acctAddrFaxNum");
	public static final Property<String> ACCT_ADDR_LINE1 = new Property<String>("acctAddrLine1");
	public static final Property<String> ACCT_ADDR_LINE2 = new Property<String>("acctAddrLine2");
	public static final Property<String> ACCT_ADDR_LINE3 = new Property<String>("acctAddrLine3");
	public static final Property<String> ACCT_ADDR_LINE4 = new Property<String>("acctAddrLine4");
	public static final Property<Short> ACCT_ADDR_NUM = new Property<Short>("acctAddrNum");
	public static final Property<String> ACCT_ADDR_PH_NUM = new Property<String>("acctAddrPhNum");
	public static final Property<String> ACCT_ADDR_STATUS = new Property<String>("acctAddrStatus");
	public static final Property<String> ACCT_ADDR_TELEX_ANSBACK = new Property<String>("acctAddrTelexAnsback");
	public static final Property<String> ACCT_ADDR_TELEX_NUM = new Property<String>("acctAddrTelexNum");
	public static final Property<String> ACCT_ADDR_ZIP_CODE = new Property<String>("acctAddrZipCode");
	public static final Property<Integer> ACCT_NUM = new Property<Integer>("acctNum");
	public static final Property<String> COUNTRY_CODE = new Property<String>("countryCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<String> STATE_CODE = new Property<String>("stateCode");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAccountingSystemId(String accountingSystemId)
	{
		writeProperty("accountingSystemId", accountingSystemId);
	}

	public String getAccountingSystemId()
	{
		return (String) readProperty("accountingSystemId");
	}

	public void setAcctAddrCity(String acctAddrCity)
	{
		writeProperty("acctAddrCity", acctAddrCity);
	}

	public String getAcctAddrCity()
	{
		return (String) readProperty("acctAddrCity");
	}

	public void setAcctAddrEmail(String acctAddrEmail)
	{
		writeProperty("acctAddrEmail", acctAddrEmail);
	}

	public String getAcctAddrEmail()
	{
		return (String) readProperty("acctAddrEmail");
	}

	public void setAcctAddrFaxAnsback(String acctAddrFaxAnsback)
	{
		writeProperty("acctAddrFaxAnsback", acctAddrFaxAnsback);
	}

	public String getAcctAddrFaxAnsback()
	{
		return (String) readProperty("acctAddrFaxAnsback");
	}

	public void setAcctAddrFaxNum(String acctAddrFaxNum)
	{
		writeProperty("acctAddrFaxNum", acctAddrFaxNum);
	}

	public String getAcctAddrFaxNum()
	{
		return (String) readProperty("acctAddrFaxNum");
	}

	public void setAcctAddrLine1(String acctAddrLine1)
	{
		writeProperty("acctAddrLine1", acctAddrLine1);
	}

	public String getAcctAddrLine1()
	{
		return (String) readProperty("acctAddrLine1");
	}

	public void setAcctAddrLine2(String acctAddrLine2)
	{
		writeProperty("acctAddrLine2", acctAddrLine2);
	}

	public String getAcctAddrLine2()
	{
		return (String) readProperty("acctAddrLine2");
	}

	public void setAcctAddrLine3(String acctAddrLine3)
	{
		writeProperty("acctAddrLine3", acctAddrLine3);
	}

	public String getAcctAddrLine3()
	{
		return (String) readProperty("acctAddrLine3");
	}

	public void setAcctAddrLine4(String acctAddrLine4)
	{
		writeProperty("acctAddrLine4", acctAddrLine4);
	}

	public String getAcctAddrLine4()
	{
		return (String) readProperty("acctAddrLine4");
	}

	public void setAcctAddrNum(Short acctAddrNum)
	{
		writeProperty("acctAddrNum", acctAddrNum);
	}

	public Short getAcctAddrNum()
	{
		return (Short) readProperty("acctAddrNum");
	}

	public void setAcctAddrPhNum(String acctAddrPhNum)
	{
		writeProperty("acctAddrPhNum", acctAddrPhNum);
	}

	public String getAcctAddrPhNum()
	{
		return (String) readProperty("acctAddrPhNum");
	}

	public void setAcctAddrStatus(String acctAddrStatus)
	{
		writeProperty("acctAddrStatus", acctAddrStatus);
	}

	public String getAcctAddrStatus()
	{
		return (String) readProperty("acctAddrStatus");
	}

	public void setAcctAddrTelexAnsback(String acctAddrTelexAnsback)
	{
		writeProperty("acctAddrTelexAnsback", acctAddrTelexAnsback);
	}

	public String getAcctAddrTelexAnsback()
	{
		return (String) readProperty("acctAddrTelexAnsback");
	}

	public void setAcctAddrTelexNum(String acctAddrTelexNum)
	{
		writeProperty("acctAddrTelexNum", acctAddrTelexNum);
	}

	public String getAcctAddrTelexNum()
	{
		return (String) readProperty("acctAddrTelexNum");
	}

	public void setAcctAddrZipCode(String acctAddrZipCode)
	{
		writeProperty("acctAddrZipCode", acctAddrZipCode);
	}

	public String getAcctAddrZipCode()
	{
		return (String) readProperty("acctAddrZipCode");
	}

	public void setAcctNum(Integer acctNum)
	{
		writeProperty("acctNum", acctNum);
	}

	public Integer getAcctNum()
	{
		return (Integer) readProperty("acctNum");
	}

	public void setCountryCode(String countryCode)
	{
		writeProperty("countryCode", countryCode);
	}

	public String getCountryCode()
	{
		return (String) readProperty("countryCode");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setStateCode(String stateCode)
	{
		writeProperty("stateCode", stateCode);
	}

	public String getStateCode()
	{
		return (String) readProperty("stateCode");
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
