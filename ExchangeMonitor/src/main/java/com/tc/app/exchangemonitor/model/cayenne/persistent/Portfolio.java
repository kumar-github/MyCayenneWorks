package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._Portfolio;

public class Portfolio extends _Portfolio
{
	private static final long serialVersionUID = 1L;

	public Integer getPortNum()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(PORT_NUM_PK_COLUMN) : null;
	}
}