package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._Trade;

public class Trade extends _Trade
{
	private static final long serialVersionUID = 1L;

	public Integer getTradeNum()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(TRADE_NUM_PK_COLUMN) : null;
	}
}