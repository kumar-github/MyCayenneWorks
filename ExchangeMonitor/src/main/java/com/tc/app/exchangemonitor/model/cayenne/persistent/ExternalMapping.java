package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalMapping;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;

public class ExternalMapping extends _ExternalMapping
{
	private static final long serialVersionUID = 1L;

	/*
	public void setOid(final Integer oid)
	{
		this.writeProperty("oid", oid);
	}

	public Integer getOid()
	{
		return (Integer) this.readProperty("oid");
	}
	 */

	public Integer getExternalMappingOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}

	/* The below method is added to display the alias value with some string concatenated. This is needed when we want to display the acctNum with acctShortName. */
	public String getAliasValueForBrokers()
	{
		final String aliasValue = this.getAliasValue();
		//return aliasValue + " <--> " + CayenneReferenceDataCache.loadAllActiveAccounts().get(Integer.parseInt(aliasValue)).getAcctShortName();
		/* Commented the above 1 line and added the below 2 lines.
		 * This is Strange but got to do bcoz, Assume we created a Broker or Company mapping using an Account but later made that account inactive. So when we load the accounts initially we load
		 * only the active accounts and but we have a mapping which points to an inactive account.
		 * When trying to get the account from the map by giving the acct num which is in the mapping will return NULL
		 */
		final Account anActiveAccount = CayenneReferenceDataCache.loadAllActiveAccounts().get(Integer.parseInt(aliasValue));
		return (anActiveAccount != null) ? aliasValue + " <--> " + anActiveAccount.getAcctShortName() : "NULL";
	}

	public String getAliasValueForCompanies()
	{
		final String aliasValue = this.getAliasValue();
		final Account anActiveAccount = CayenneReferenceDataCache.loadAllActiveAccounts().get(Integer.parseInt(aliasValue));
		return (anActiveAccount != null) ? aliasValue + " <--> " + anActiveAccount.getAcctShortName() : "NULL";
	}

	public String getExternalValue4ForForCompanies()
	{
		final String externalValue4 = this.getExternalValue4();
		if((externalValue4 != null) && !externalValue4.isEmpty())
		{
			final Country aCountry = CayenneReferenceDataCache.getCountryForISOCode(externalValue4.trim().toUpperCase());
			return (aCountry != null) ? aCountry.getCountryName() : "NULL";
		}
		return "";
	}

	public String getAliasValueForPortfolios()
	{
		final String aliasValue = this.getAliasValue();
		final Portfolio aPortfolio = CayenneReferenceDataCache.loadAllPortfolios().get(Integer.parseInt(aliasValue));
		return (aPortfolio != null) ? aliasValue + " <--> " + aPortfolio.getPortShortName() : "NULL";
	}

	@Override
	public String toString()
	{
		return this.getExternalValue1().trim().toUpperCase();
	}
}