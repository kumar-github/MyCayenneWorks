package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AcctVatNumber;
import com.tc.app.exchangemonitor.model.cayenne.persistent.CmdtyNomenclature;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Country;
import com.tc.app.exchangemonitor.model.cayenne.persistent.LocationExtInfo;
import com.tc.app.exchangemonitor.model.cayenne.persistent.LocationTankInfo;
import com.tc.app.exchangemonitor.model.cayenne.persistent.VatDeclaration;
import com.tc.app.exchangemonitor.model.cayenne.persistent.VatTransNature;
import com.tc.app.exchangemonitor.model.cayenne.persistent.VatType;

/**
 * Class _AiEstActualVat was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AiEstActualVat extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String AI_EST_ACTUAL_NUM_PK_COLUMN = "ai_est_actual_num";
	public static final String ALLOC_ITEM_NUM_PK_COLUMN = "alloc_item_num";
	public static final String ALLOC_NUM_PK_COLUMN = "alloc_num";

	public static final Property<String> AAD = new Property<String>("aad");
	public static final Property<String> EXCISE_NUM = new Property<String>("exciseNum");
	public static final Property<String> READY_FOR_ACCOUNTING_IND = new Property<String>("readyForAccountingInd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> VAT_APPLIES_IND = new Property<String>("vatAppliesInd");
	public static final Property<String> WPH_EXCISE_NUM = new Property<String>("wphExciseNum");
	public static final Property<Account> ACCOUNT = new Property<Account>("account");
	public static final Property<Account> ACCOUNT1 = new Property<Account>("account1");
	public static final Property<Account> ACCOUNT2 = new Property<Account>("account2");
	public static final Property<AcctVatNumber> BOOKING_COMP_VAT_NUMBER = new Property<AcctVatNumber>("bookingCompVatNumber");
	public static final Property<CmdtyNomenclature> CMDTY_NOMENCLATURE = new Property<CmdtyNomenclature>("cmdtyNomenclature");
	public static final Property<AcctVatNumber> COUNTERPARTY_VAT_NUMBER = new Property<AcctVatNumber>("counterpartyVatNumber");
	public static final Property<Country> COUNTRY = new Property<Country>("country");
	public static final Property<Country> COUNTRY1 = new Property<Country>("country1");
	public static final Property<Country> COUNTRY2 = new Property<Country>("country2");
	public static final Property<Country> COUNTRY3 = new Property<Country>("country3");
	public static final Property<AcctVatNumber> EXCISE_NUMBER = new Property<AcctVatNumber>("exciseNumber");
	public static final Property<LocationExtInfo> LOCATION_EXT_INFO = new Property<LocationExtInfo>("locationExtInfo");
	public static final Property<LocationTankInfo> LOCATION_TANK_INFO = new Property<LocationTankInfo>("locationTankInfo");
	public static final Property<VatDeclaration> VAT_DECLARATION = new Property<VatDeclaration>("vatDeclaration");
	public static final Property<VatTransNature> VAT_TRANS_NATURE = new Property<VatTransNature>("vatTransNature");
	public static final Property<VatType> VAT_TYPE = new Property<VatType>("vatType");
	public static final Property<AcctVatNumber> WPH_VAT_NUMBER = new Property<AcctVatNumber>("wphVatNumber");

	public void setAad(String aad)
	{
		writeProperty("aad", aad);
	}

	public String getAad()
	{
		return (String) readProperty("aad");
	}

	public void setExciseNum(String exciseNum)
	{
		writeProperty("exciseNum", exciseNum);
	}

	public String getExciseNum()
	{
		return (String) readProperty("exciseNum");
	}

	public void setReadyForAccountingInd(String readyForAccountingInd)
	{
		writeProperty("readyForAccountingInd", readyForAccountingInd);
	}

	public String getReadyForAccountingInd()
	{
		return (String) readProperty("readyForAccountingInd");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setVatAppliesInd(String vatAppliesInd)
	{
		writeProperty("vatAppliesInd", vatAppliesInd);
	}

	public String getVatAppliesInd()
	{
		return (String) readProperty("vatAppliesInd");
	}

	public void setWphExciseNum(String wphExciseNum)
	{
		writeProperty("wphExciseNum", wphExciseNum);
	}

	public String getWphExciseNum()
	{
		return (String) readProperty("wphExciseNum");
	}

	public void setAccount(Account account)
	{
		setToOneTarget("account", account, true);
	}

	public Account getAccount()
	{
		return (Account) readProperty("account");
	}

	public void setAccount1(Account account1)
	{
		setToOneTarget("account1", account1, true);
	}

	public Account getAccount1()
	{
		return (Account) readProperty("account1");
	}

	public void setAccount2(Account account2)
	{
		setToOneTarget("account2", account2, true);
	}

	public Account getAccount2()
	{
		return (Account) readProperty("account2");
	}

	public void setBookingCompVatNumber(AcctVatNumber bookingCompVatNumber)
	{
		setToOneTarget("bookingCompVatNumber", bookingCompVatNumber, true);
	}

	public AcctVatNumber getBookingCompVatNumber()
	{
		return (AcctVatNumber) readProperty("bookingCompVatNumber");
	}

	public void setCmdtyNomenclature(CmdtyNomenclature cmdtyNomenclature)
	{
		setToOneTarget("cmdtyNomenclature", cmdtyNomenclature, true);
	}

	public CmdtyNomenclature getCmdtyNomenclature()
	{
		return (CmdtyNomenclature) readProperty("cmdtyNomenclature");
	}

	public void setCounterpartyVatNumber(AcctVatNumber counterpartyVatNumber)
	{
		setToOneTarget("counterpartyVatNumber", counterpartyVatNumber, true);
	}

	public AcctVatNumber getCounterpartyVatNumber()
	{
		return (AcctVatNumber) readProperty("counterpartyVatNumber");
	}

	public void setCountry(Country country)
	{
		setToOneTarget("country", country, true);
	}

	public Country getCountry()
	{
		return (Country) readProperty("country");
	}

	public void setCountry1(Country country1)
	{
		setToOneTarget("country1", country1, true);
	}

	public Country getCountry1()
	{
		return (Country) readProperty("country1");
	}

	public void setCountry2(Country country2)
	{
		setToOneTarget("country2", country2, true);
	}

	public Country getCountry2()
	{
		return (Country) readProperty("country2");
	}

	public void setCountry3(Country country3)
	{
		setToOneTarget("country3", country3, true);
	}

	public Country getCountry3()
	{
		return (Country) readProperty("country3");
	}

	public void setExciseNumber(AcctVatNumber exciseNumber)
	{
		setToOneTarget("exciseNumber", exciseNumber, true);
	}

	public AcctVatNumber getExciseNumber()
	{
		return (AcctVatNumber) readProperty("exciseNumber");
	}

	public void setLocationExtInfo(LocationExtInfo locationExtInfo)
	{
		setToOneTarget("locationExtInfo", locationExtInfo, true);
	}

	public LocationExtInfo getLocationExtInfo()
	{
		return (LocationExtInfo) readProperty("locationExtInfo");
	}

	public void setLocationTankInfo(LocationTankInfo locationTankInfo)
	{
		setToOneTarget("locationTankInfo", locationTankInfo, true);
	}

	public LocationTankInfo getLocationTankInfo()
	{
		return (LocationTankInfo) readProperty("locationTankInfo");
	}

	public void setVatDeclaration(VatDeclaration vatDeclaration)
	{
		setToOneTarget("vatDeclaration", vatDeclaration, true);
	}

	public VatDeclaration getVatDeclaration()
	{
		return (VatDeclaration) readProperty("vatDeclaration");
	}

	public void setVatTransNature(VatTransNature vatTransNature)
	{
		setToOneTarget("vatTransNature", vatTransNature, true);
	}

	public VatTransNature getVatTransNature()
	{
		return (VatTransNature) readProperty("vatTransNature");
	}

	public void setVatType(VatType vatType)
	{
		setToOneTarget("vatType", vatType, true);
	}

	public VatType getVatType()
	{
		return (VatType) readProperty("vatType");
	}

	public void setWphVatNumber(AcctVatNumber wphVatNumber)
	{
		setToOneTarget("wphVatNumber", wphVatNumber, true);
	}

	public AcctVatNumber getWphVatNumber()
	{
		return (AcctVatNumber) readProperty("wphVatNumber");
	}

}
