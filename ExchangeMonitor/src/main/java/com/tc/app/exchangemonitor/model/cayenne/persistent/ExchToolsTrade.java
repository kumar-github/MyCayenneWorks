package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExchToolsTrade;

public class ExchToolsTrade extends _ExchToolsTrade
{
	private static final long serialVersionUID = 1L;

	public Integer getExternalTradeOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(EXTERNAL_TRADE_OID_PK_COLUMN) : null;
	}
}