package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalTradeState;

public class ExternalTradeState extends _ExternalTradeState
{
	private static final long serialVersionUID = 1L;

	public Integer getExternalTradeStateOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}

	@Override
	public String toString()
	{
		//return super.toString();
		return this.getExternalTradeStateName().trim().toUpperCase();
	}
}