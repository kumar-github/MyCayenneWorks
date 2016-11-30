package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalTradeSource;

public class ExternalTradeSource extends _ExternalTradeSource
{
	private static final long serialVersionUID = 1L;

	public Integer getExternalTradeSourceOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}
}
