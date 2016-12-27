package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._TradeItemFill;

public class TradeItemFill extends _TradeItemFill
{
	private static final long serialVersionUID = 1L;

	public Short getFillNum()
	{
		//@formatter:off
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Short) this.getObjectId().getIdSnapshot().get(ITEM_FILL_NUM_PK_COLUMN) : null;
		//@formatter:on
	}
}