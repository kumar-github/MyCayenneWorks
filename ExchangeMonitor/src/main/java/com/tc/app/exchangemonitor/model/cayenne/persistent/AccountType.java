package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._AccountType;

public class AccountType extends _AccountType
{
	private static final long serialVersionUID = 1L;

	public String getAccountTypeCode()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (String) this.getObjectId().getIdSnapshot().get(ACCT_TYPE_CODE_PK_COLUMN) : null;
	}
}