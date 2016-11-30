package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._TradeStatus;

public class TradeStatus extends _TradeStatus
{
	private static final long serialVersionUID = 1L;

	public String getTradeStatusCode()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (String) this.getObjectId().getIdSnapshot().get(TRADE_STATUS_CODE_PK_COLUMN) : null;
	}
}