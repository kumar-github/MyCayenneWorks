package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAlias;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountContact;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountInstruction;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Facility;

/**
 * Class _AccountAddress was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AccountAddress extends CayenneDataObject
{
	private static final long serialVersionUID = 1L;

	public static final String ACCT_ADDR_NUM_PK_COLUMN = "acct_addr_num";
	public static final String ACCT_NUM_PK_COLUMN = "acct_num";

	public static final Property<String> ACCOUNTING_SYSTEM_ID = new Property<>("accountingSystemId");
	public static final Property<String> ACCT_ADDR_CITY = new Property<>("acctAddrCity");
	public static final Property<String> ACCT_ADDR_EMAIL = new Property<>("acctAddrEmail");
	public static final Property<String> ACCT_ADDR_FAX_ANSBACK = new Property<>("acctAddrFaxAnsback");
	public static final Property<String> ACCT_ADDR_FAX_NUM = new Property<>("acctAddrFaxNum");
	public static final Property<String> ACCT_ADDR_LINE1 = new Property<>("acctAddrLine1");
	public static final Property<String> ACCT_ADDR_LINE2 = new Property<>("acctAddrLine2");
	public static final Property<String> ACCT_ADDR_LINE3 = new Property<>("acctAddrLine3");
	public static final Property<String> ACCT_ADDR_LINE4 = new Property<>("acctAddrLine4");
	public static final Property<String> ACCT_ADDR_PH_NUM = new Property<>("acctAddrPhNum");
	public static final Property<String> ACCT_ADDR_STATUS = new Property<>("acctAddrStatus");
	public static final Property<String> ACCT_ADDR_TELEX_ANSBACK = new Property<>("acctAddrTelexAnsback");
	public static final Property<String> ACCT_ADDR_TELEX_NUM = new Property<>("acctAddrTelexNum");
	public static final Property<String> ACCT_ADDR_ZIP_CODE = new Property<>("acctAddrZipCode");
	public static final Property<String> COUNTRY_CODE = new Property<>("countryCode");
	public static final Property<String> STATE_CODE = new Property<>("stateCode");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Account> ACCOUNT = new Property<>("account");
	public static final Property<List<AccountAlias>> ACCOUNT_ALIASS = new Property<>("accountAliass");
	public static final Property<List<AccountAlias>> ACCOUNT_ALIASS1 = new Property<>("accountAliass1");
	public static final Property<List<AccountContact>> ACCOUNT_CONTACTS = new Property<>("accountContacts");
	public static final Property<List<AccountContact>> ACCOUNT_CONTACTS1 = new Property<>("accountContacts1");
	public static final Property<List<AccountInstruction>> ACCOUNT_INSTRUCTIONS = new Property<>("accountInstructions");
	public static final Property<List<AccountInstruction>> ACCOUNT_INSTRUCTIONS1 = new Property<>("accountInstructions1");
	public static final Property<List<Facility>> FACILITIES = new Property<>("facilities");
	public static final Property<List<Facility>> FACILITIES1 = new Property<>("facilities1");

	public void setAccountingSystemId(final String accountingSystemId)
	{
		this.writeProperty("accountingSystemId", accountingSystemId);
	}

	public String getAccountingSystemId()
	{
		return (String) this.readProperty("accountingSystemId");
	}

	public void setAcctAddrCity(final String acctAddrCity)
	{
		this.writeProperty("acctAddrCity", acctAddrCity);
	}

	public String getAcctAddrCity()
	{
		return (String) this.readProperty("acctAddrCity");
	}

	public void setAcctAddrEmail(final String acctAddrEmail)
	{
		this.writeProperty("acctAddrEmail", acctAddrEmail);
	}

	public String getAcctAddrEmail()
	{
		return (String) this.readProperty("acctAddrEmail");
	}

	public void setAcctAddrFaxAnsback(final String acctAddrFaxAnsback)
	{
		this.writeProperty("acctAddrFaxAnsback", acctAddrFaxAnsback);
	}

	public String getAcctAddrFaxAnsback()
	{
		return (String) this.readProperty("acctAddrFaxAnsback");
	}

	public void setAcctAddrFaxNum(final String acctAddrFaxNum)
	{
		this.writeProperty("acctAddrFaxNum", acctAddrFaxNum);
	}

	public String getAcctAddrFaxNum()
	{
		return (String) this.readProperty("acctAddrFaxNum");
	}

	public void setAcctAddrLine1(final String acctAddrLine1)
	{
		this.writeProperty("acctAddrLine1", acctAddrLine1);
	}

	public String getAcctAddrLine1()
	{
		return (String) this.readProperty("acctAddrLine1");
	}

	public void setAcctAddrLine2(final String acctAddrLine2)
	{
		this.writeProperty("acctAddrLine2", acctAddrLine2);
	}

	public String getAcctAddrLine2()
	{
		return (String) this.readProperty("acctAddrLine2");
	}

	public void setAcctAddrLine3(final String acctAddrLine3)
	{
		this.writeProperty("acctAddrLine3", acctAddrLine3);
	}

	public String getAcctAddrLine3()
	{
		return (String) this.readProperty("acctAddrLine3");
	}

	public void setAcctAddrLine4(final String acctAddrLine4)
	{
		this.writeProperty("acctAddrLine4", acctAddrLine4);
	}

	public String getAcctAddrLine4()
	{
		return (String) this.readProperty("acctAddrLine4");
	}

	public void setAcctAddrPhNum(final String acctAddrPhNum)
	{
		this.writeProperty("acctAddrPhNum", acctAddrPhNum);
	}

	public String getAcctAddrPhNum()
	{
		return (String) this.readProperty("acctAddrPhNum");
	}

	public void setAcctAddrStatus(final String acctAddrStatus)
	{
		this.writeProperty("acctAddrStatus", acctAddrStatus);
	}

	public String getAcctAddrStatus()
	{
		return (String) this.readProperty("acctAddrStatus");
	}

	public void setAcctAddrTelexAnsback(final String acctAddrTelexAnsback)
	{
		this.writeProperty("acctAddrTelexAnsback", acctAddrTelexAnsback);
	}

	public String getAcctAddrTelexAnsback()
	{
		return (String) this.readProperty("acctAddrTelexAnsback");
	}

	public void setAcctAddrTelexNum(final String acctAddrTelexNum)
	{
		this.writeProperty("acctAddrTelexNum", acctAddrTelexNum);
	}

	public String getAcctAddrTelexNum()
	{
		return (String) this.readProperty("acctAddrTelexNum");
	}

	public void setAcctAddrZipCode(final String acctAddrZipCode)
	{
		this.writeProperty("acctAddrZipCode", acctAddrZipCode);
	}

	public String getAcctAddrZipCode()
	{
		return (String) this.readProperty("acctAddrZipCode");
	}

	public void setCountryCode(final String countryCode)
	{
		this.writeProperty("countryCode", countryCode);
	}

	public String getCountryCode()
	{
		return (String) this.readProperty("countryCode");
	}

	public void setStateCode(final String stateCode)
	{
		this.writeProperty("stateCode", stateCode);
	}

	public String getStateCode()
	{
		return (String) this.readProperty("stateCode");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setAccount(final Account account)
	{
		this.setToOneTarget("account", account, true);
	}

	public Account getAccount()
	{
		return (Account) this.readProperty("account");
	}

	public void addToAccountAliass(final AccountAlias obj)
	{
		this.addToManyTarget("accountAliass", obj, true);
	}

	public void removeFromAccountAliass(final AccountAlias obj)
	{
		this.removeToManyTarget("accountAliass", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountAlias> getAccountAliass()
	{
		return (List<AccountAlias>) this.readProperty("accountAliass");
	}

	public void addToAccountAliass1(final AccountAlias obj)
	{
		this.addToManyTarget("accountAliass1", obj, true);
	}

	public void removeFromAccountAliass1(final AccountAlias obj)
	{
		this.removeToManyTarget("accountAliass1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountAlias> getAccountAliass1()
	{
		return (List<AccountAlias>) this.readProperty("accountAliass1");
	}

	public void addToAccountContacts(final AccountContact obj)
	{
		this.addToManyTarget("accountContacts", obj, true);
	}

	public void removeFromAccountContacts(final AccountContact obj)
	{
		this.removeToManyTarget("accountContacts", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountContact> getAccountContacts()
	{
		return (List<AccountContact>) this.readProperty("accountContacts");
	}

	public void addToAccountContacts1(final AccountContact obj)
	{
		this.addToManyTarget("accountContacts1", obj, true);
	}

	public void removeFromAccountContacts1(final AccountContact obj)
	{
		this.removeToManyTarget("accountContacts1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountContact> getAccountContacts1()
	{
		return (List<AccountContact>) this.readProperty("accountContacts1");
	}

	public void addToAccountInstructions(final AccountInstruction obj)
	{
		this.addToManyTarget("accountInstructions", obj, true);
	}

	public void removeFromAccountInstructions(final AccountInstruction obj)
	{
		this.removeToManyTarget("accountInstructions", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountInstruction> getAccountInstructions()
	{
		return (List<AccountInstruction>) this.readProperty("accountInstructions");
	}

	public void addToAccountInstructions1(final AccountInstruction obj)
	{
		this.addToManyTarget("accountInstructions1", obj, true);
	}

	public void removeFromAccountInstructions1(final AccountInstruction obj)
	{
		this.removeToManyTarget("accountInstructions1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountInstruction> getAccountInstructions1()
	{
		return (List<AccountInstruction>) this.readProperty("accountInstructions1");
	}

	public void addToFacilities(final Facility obj)
	{
		this.addToManyTarget("facilities", obj, true);
	}

	public void removeFromFacilities(final Facility obj)
	{
		this.removeToManyTarget("facilities", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Facility> getFacilities()
	{
		return (List<Facility>) this.readProperty("facilities");
	}

	public void addToFacilities1(final Facility obj)
	{
		this.addToManyTarget("facilities1", obj, true);
	}

	public void removeFromFacilities1(final Facility obj)
	{
		this.removeToManyTarget("facilities1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Facility> getFacilities1()
	{
		return (List<Facility>) this.readProperty("facilities1");
	}
}