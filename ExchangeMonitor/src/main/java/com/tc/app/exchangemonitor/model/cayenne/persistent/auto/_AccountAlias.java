package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AliasSource;

/**
 * Class _AccountAlias was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AccountAlias extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ACCT_ADDR_NUM_PK_COLUMN = "acct_addr_num";
	public static final String ACCT_NUM_PK_COLUMN = "acct_num";
	public static final String ALIAS_SOURCE_CODE_PK_COLUMN = "alias_source_code";

	public static final Property<String> ACCT_ALIAS_NAME = new Property<>("acctAliasName");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS = new Property<>("accountAddress");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS1 = new Property<>("accountAddress1");
	public static final Property<AliasSource> ALIAS_SOURCE = new Property<>("aliasSource");

	public void setAcctAliasName(final String acctAliasName)
	{
		this.writeProperty("acctAliasName", acctAliasName);
	}

	public String getAcctAliasName()
	{
		return (String) this.readProperty("acctAliasName");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
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

	public void setAliasSource(final AliasSource aliasSource)
	{
		this.setToOneTarget("aliasSource", aliasSource, true);
	}

	public AliasSource getAliasSource()
	{
		return (AliasSource) this.readProperty("aliasSource");
	}

}
