package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountInstruction;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Allocation;
import com.tc.app.exchangemonitor.model.cayenne.persistent.BrokerCommissionDefault;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Facility;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItem;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemExchOpt;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeItemFut;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeOrderBunker;
import com.tc.app.exchangemonitor.model.cayenne.persistent.UserContact;

/**
 * Class _AccountContact was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AccountContact extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ACCT_CONT_NUM_PK_COLUMN = "acct_cont_num";
	public static final String ACCT_NUM_PK_COLUMN = "acct_num";

	public static final Property<String> ACCT_CONT_ADDR_CITY = new Property<>("acctContAddrCity");
	public static final Property<String> ACCT_CONT_ADDR_LINE1 = new Property<>("acctContAddrLine1");
	public static final Property<String> ACCT_CONT_ADDR_LINE2 = new Property<>("acctContAddrLine2");
	public static final Property<String> ACCT_CONT_ADDR_LINE3 = new Property<>("acctContAddrLine3");
	public static final Property<String> ACCT_CONT_ADDR_LINE4 = new Property<>("acctContAddrLine4");
	public static final Property<String> ACCT_CONT_ADDR_ZIP_CODE = new Property<>("acctContAddrZipCode");
	public static final Property<String> ACCT_CONT_EMAIL = new Property<>("acctContEmail");
	public static final Property<String> ACCT_CONT_FAX_NUM = new Property<>("acctContFaxNum");
	public static final Property<String> ACCT_CONT_FIRST_NAME = new Property<>("acctContFirstName");
	public static final Property<String> ACCT_CONT_FUNCTION = new Property<>("acctContFunction");
	public static final Property<String> ACCT_CONT_HOME_PH_NUM = new Property<>("acctContHomePhNum");
	public static final Property<String> ACCT_CONT_LAST_NAME = new Property<>("acctContLastName");
	public static final Property<String> ACCT_CONT_NICK_NAME = new Property<>("acctContNickName");
	public static final Property<String> ACCT_CONT_OFF_PH_NUM = new Property<>("acctContOffPhNum");
	public static final Property<String> ACCT_CONT_OTH_PH_NUM = new Property<>("acctContOthPhNum");
	public static final Property<String> ACCT_CONT_STATUS = new Property<>("acctContStatus");
	public static final Property<String> ACCT_CONT_TELEX_NUM = new Property<>("acctContTelexNum");
	public static final Property<String> ACCT_CONT_TITLE = new Property<>("acctContTitle");
	public static final Property<String> COUNTRY_CODE = new Property<>("countryCode");
	public static final Property<String> STATE_CODE = new Property<>("stateCode");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Account> ACCOUNT = new Property<>("account");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS = new Property<>("accountAddress");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS1 = new Property<>("accountAddress1");
	public static final Property<List<AccountInstruction>> ACCOUNT_INSTRUCTIONS = new Property<>("accountInstructions");
	public static final Property<List<AccountInstruction>> ACCOUNT_INSTRUCTIONS1 = new Property<>("accountInstructions1");
	public static final Property<List<Allocation>> ALLOCATIONS = new Property<>("allocations");
	public static final Property<List<Allocation>> ALLOCATIONS1 = new Property<>("allocations1");
	public static final Property<List<BrokerCommissionDefault>> BROKER_COMMISSION_DEFAULTS = new Property<>("brokerCommissionDefaults");
	public static final Property<List<BrokerCommissionDefault>> BROKER_COMMISSION_DEFAULTS1 = new Property<>("brokerCommissionDefaults1");
	public static final Property<List<Facility>> FACILITIES = new Property<>("facilities");
	public static final Property<List<Facility>> FACILITIES1 = new Property<>("facilities1");
	public static final Property<List<TradeItemExchOpt>> TRADE_ITEM_EXCH_OPTS = new Property<>("tradeItemExchOpts");
	public static final Property<List<TradeItemExchOpt>> TRADE_ITEM_EXCH_OPTS1 = new Property<>("tradeItemExchOpts1");
	public static final Property<List<TradeItemFut>> TRADE_ITEM_FUTS = new Property<>("tradeItemFuts");
	public static final Property<List<TradeItemFut>> TRADE_ITEM_FUTS1 = new Property<>("tradeItemFuts1");
	public static final Property<List<TradeItem>> TRADE_ITEMS = new Property<>("tradeItems");
	public static final Property<List<TradeItem>> TRADE_ITEMS1 = new Property<>("tradeItems1");
	public static final Property<List<TradeOrderBunker>> TRADE_ORDER_BUNKERS = new Property<>("tradeOrderBunkers");
	public static final Property<List<TradeOrderBunker>> TRADE_ORDER_BUNKERS1 = new Property<>("tradeOrderBunkers1");
	public static final Property<List<Trade>> TRADES = new Property<>("trades");
	public static final Property<List<Trade>> TRADES1 = new Property<>("trades1");
	public static final Property<List<UserContact>> USER_CONTACTS = new Property<>("userContacts");
	public static final Property<List<UserContact>> USER_CONTACTS1 = new Property<>("userContacts1");

	public void setAcctContAddrCity(final String acctContAddrCity)
	{
		this.writeProperty("acctContAddrCity", acctContAddrCity);
	}

	public String getAcctContAddrCity()
	{
		return (String) this.readProperty("acctContAddrCity");
	}

	public void setAcctContAddrLine1(final String acctContAddrLine1)
	{
		this.writeProperty("acctContAddrLine1", acctContAddrLine1);
	}

	public String getAcctContAddrLine1()
	{
		return (String) this.readProperty("acctContAddrLine1");
	}

	public void setAcctContAddrLine2(final String acctContAddrLine2)
	{
		this.writeProperty("acctContAddrLine2", acctContAddrLine2);
	}

	public String getAcctContAddrLine2()
	{
		return (String) this.readProperty("acctContAddrLine2");
	}

	public void setAcctContAddrLine3(final String acctContAddrLine3)
	{
		this.writeProperty("acctContAddrLine3", acctContAddrLine3);
	}

	public String getAcctContAddrLine3()
	{
		return (String) this.readProperty("acctContAddrLine3");
	}

	public void setAcctContAddrLine4(final String acctContAddrLine4)
	{
		this.writeProperty("acctContAddrLine4", acctContAddrLine4);
	}

	public String getAcctContAddrLine4()
	{
		return (String) this.readProperty("acctContAddrLine4");
	}

	public void setAcctContAddrZipCode(final String acctContAddrZipCode)
	{
		this.writeProperty("acctContAddrZipCode", acctContAddrZipCode);
	}

	public String getAcctContAddrZipCode()
	{
		return (String) this.readProperty("acctContAddrZipCode");
	}

	public void setAcctContEmail(final String acctContEmail)
	{
		this.writeProperty("acctContEmail", acctContEmail);
	}

	public String getAcctContEmail()
	{
		return (String) this.readProperty("acctContEmail");
	}

	public void setAcctContFaxNum(final String acctContFaxNum)
	{
		this.writeProperty("acctContFaxNum", acctContFaxNum);
	}

	public String getAcctContFaxNum()
	{
		return (String) this.readProperty("acctContFaxNum");
	}

	public void setAcctContFirstName(final String acctContFirstName)
	{
		this.writeProperty("acctContFirstName", acctContFirstName);
	}

	public String getAcctContFirstName()
	{
		return (String) this.readProperty("acctContFirstName");
	}

	public void setAcctContFunction(final String acctContFunction)
	{
		this.writeProperty("acctContFunction", acctContFunction);
	}

	public String getAcctContFunction()
	{
		return (String) this.readProperty("acctContFunction");
	}

	public void setAcctContHomePhNum(final String acctContHomePhNum)
	{
		this.writeProperty("acctContHomePhNum", acctContHomePhNum);
	}

	public String getAcctContHomePhNum()
	{
		return (String) this.readProperty("acctContHomePhNum");
	}

	public void setAcctContLastName(final String acctContLastName)
	{
		this.writeProperty("acctContLastName", acctContLastName);
	}

	public String getAcctContLastName()
	{
		return (String) this.readProperty("acctContLastName");
	}

	public void setAcctContNickName(final String acctContNickName)
	{
		this.writeProperty("acctContNickName", acctContNickName);
	}

	public String getAcctContNickName()
	{
		return (String) this.readProperty("acctContNickName");
	}

	public void setAcctContOffPhNum(final String acctContOffPhNum)
	{
		this.writeProperty("acctContOffPhNum", acctContOffPhNum);
	}

	public String getAcctContOffPhNum()
	{
		return (String) this.readProperty("acctContOffPhNum");
	}

	public void setAcctContOthPhNum(final String acctContOthPhNum)
	{
		this.writeProperty("acctContOthPhNum", acctContOthPhNum);
	}

	public String getAcctContOthPhNum()
	{
		return (String) this.readProperty("acctContOthPhNum");
	}

	public void setAcctContStatus(final String acctContStatus)
	{
		this.writeProperty("acctContStatus", acctContStatus);
	}

	public String getAcctContStatus()
	{
		return (String) this.readProperty("acctContStatus");
	}

	public void setAcctContTelexNum(final String acctContTelexNum)
	{
		this.writeProperty("acctContTelexNum", acctContTelexNum);
	}

	public String getAcctContTelexNum()
	{
		return (String) this.readProperty("acctContTelexNum");
	}

	public void setAcctContTitle(final String acctContTitle)
	{
		this.writeProperty("acctContTitle", acctContTitle);
	}

	public String getAcctContTitle()
	{
		return (String) this.readProperty("acctContTitle");
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

	public void addToAllocations(final Allocation obj)
	{
		this.addToManyTarget("allocations", obj, true);
	}

	public void removeFromAllocations(final Allocation obj)
	{
		this.removeToManyTarget("allocations", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Allocation> getAllocations()
	{
		return (List<Allocation>) this.readProperty("allocations");
	}

	public void addToAllocations1(final Allocation obj)
	{
		this.addToManyTarget("allocations1", obj, true);
	}

	public void removeFromAllocations1(final Allocation obj)
	{
		this.removeToManyTarget("allocations1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Allocation> getAllocations1()
	{
		return (List<Allocation>) this.readProperty("allocations1");
	}

	public void addToBrokerCommissionDefaults(final BrokerCommissionDefault obj)
	{
		this.addToManyTarget("brokerCommissionDefaults", obj, true);
	}

	public void removeFromBrokerCommissionDefaults(final BrokerCommissionDefault obj)
	{
		this.removeToManyTarget("brokerCommissionDefaults", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<BrokerCommissionDefault> getBrokerCommissionDefaults()
	{
		return (List<BrokerCommissionDefault>) this.readProperty("brokerCommissionDefaults");
	}

	public void addToBrokerCommissionDefaults1(final BrokerCommissionDefault obj)
	{
		this.addToManyTarget("brokerCommissionDefaults1", obj, true);
	}

	public void removeFromBrokerCommissionDefaults1(final BrokerCommissionDefault obj)
	{
		this.removeToManyTarget("brokerCommissionDefaults1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<BrokerCommissionDefault> getBrokerCommissionDefaults1()
	{
		return (List<BrokerCommissionDefault>) this.readProperty("brokerCommissionDefaults1");
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

	public void addToTradeItemExchOpts(final TradeItemExchOpt obj)
	{
		this.addToManyTarget("tradeItemExchOpts", obj, true);
	}

	public void removeFromTradeItemExchOpts(final TradeItemExchOpt obj)
	{
		this.removeToManyTarget("tradeItemExchOpts", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemExchOpt> getTradeItemExchOpts()
	{
		return (List<TradeItemExchOpt>) this.readProperty("tradeItemExchOpts");
	}

	public void addToTradeItemExchOpts1(final TradeItemExchOpt obj)
	{
		this.addToManyTarget("tradeItemExchOpts1", obj, true);
	}

	public void removeFromTradeItemExchOpts1(final TradeItemExchOpt obj)
	{
		this.removeToManyTarget("tradeItemExchOpts1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemExchOpt> getTradeItemExchOpts1()
	{
		return (List<TradeItemExchOpt>) this.readProperty("tradeItemExchOpts1");
	}

	public void addToTradeItemFuts(final TradeItemFut obj)
	{
		this.addToManyTarget("tradeItemFuts", obj, true);
	}

	public void removeFromTradeItemFuts(final TradeItemFut obj)
	{
		this.removeToManyTarget("tradeItemFuts", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemFut> getTradeItemFuts()
	{
		return (List<TradeItemFut>) this.readProperty("tradeItemFuts");
	}

	public void addToTradeItemFuts1(final TradeItemFut obj)
	{
		this.addToManyTarget("tradeItemFuts1", obj, true);
	}

	public void removeFromTradeItemFuts1(final TradeItemFut obj)
	{
		this.removeToManyTarget("tradeItemFuts1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItemFut> getTradeItemFuts1()
	{
		return (List<TradeItemFut>) this.readProperty("tradeItemFuts1");
	}

	public void addToTradeItems(final TradeItem obj)
	{
		this.addToManyTarget("tradeItems", obj, true);
	}

	public void removeFromTradeItems(final TradeItem obj)
	{
		this.removeToManyTarget("tradeItems", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItem> getTradeItems()
	{
		return (List<TradeItem>) this.readProperty("tradeItems");
	}

	public void addToTradeItems1(final TradeItem obj)
	{
		this.addToManyTarget("tradeItems1", obj, true);
	}

	public void removeFromTradeItems1(final TradeItem obj)
	{
		this.removeToManyTarget("tradeItems1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeItem> getTradeItems1()
	{
		return (List<TradeItem>) this.readProperty("tradeItems1");
	}

	public void addToTradeOrderBunkers(final TradeOrderBunker obj)
	{
		this.addToManyTarget("tradeOrderBunkers", obj, true);
	}

	public void removeFromTradeOrderBunkers(final TradeOrderBunker obj)
	{
		this.removeToManyTarget("tradeOrderBunkers", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeOrderBunker> getTradeOrderBunkers()
	{
		return (List<TradeOrderBunker>) this.readProperty("tradeOrderBunkers");
	}

	public void addToTradeOrderBunkers1(final TradeOrderBunker obj)
	{
		this.addToManyTarget("tradeOrderBunkers1", obj, true);
	}

	public void removeFromTradeOrderBunkers1(final TradeOrderBunker obj)
	{
		this.removeToManyTarget("tradeOrderBunkers1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<TradeOrderBunker> getTradeOrderBunkers1()
	{
		return (List<TradeOrderBunker>) this.readProperty("tradeOrderBunkers1");
	}

	public void addToTrades(final Trade obj)
	{
		this.addToManyTarget("trades", obj, true);
	}

	public void removeFromTrades(final Trade obj)
	{
		this.removeToManyTarget("trades", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Trade> getTrades()
	{
		return (List<Trade>) this.readProperty("trades");
	}

	public void addToTrades1(final Trade obj)
	{
		this.addToManyTarget("trades1", obj, true);
	}

	public void removeFromTrades1(final Trade obj)
	{
		this.removeToManyTarget("trades1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Trade> getTrades1()
	{
		return (List<Trade>) this.readProperty("trades1");
	}

	public void addToUserContacts(final UserContact obj)
	{
		this.addToManyTarget("userContacts", obj, true);
	}

	public void removeFromUserContacts(final UserContact obj)
	{
		this.removeToManyTarget("userContacts", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<UserContact> getUserContacts()
	{
		return (List<UserContact>) this.readProperty("userContacts");
	}

	public void addToUserContacts1(final UserContact obj)
	{
		this.addToManyTarget("userContacts1", obj, true);
	}

	public void removeFromUserContacts1(final UserContact obj)
	{
		this.removeToManyTarget("userContacts1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<UserContact> getUserContacts1()
	{
		return (List<UserContact>) this.readProperty("userContacts1");
	}

}
