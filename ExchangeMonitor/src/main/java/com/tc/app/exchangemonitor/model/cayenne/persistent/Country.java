package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._Country;

public class Country extends _Country
{
	private static final long serialVersionUID = 1L;

	public String getCountryCode()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (String) this.getObjectId().getIdSnapshot().get(COUNTRY_CODE_PK_COLUMN) : null;
	}
}