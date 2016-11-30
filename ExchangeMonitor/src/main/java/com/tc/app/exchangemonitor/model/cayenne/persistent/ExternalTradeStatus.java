package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalTradeStatus;

public class ExternalTradeStatus extends _ExternalTradeStatus
{
	private static final long serialVersionUID = 1L;

	public Integer getExternalTradeStatusOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}
}