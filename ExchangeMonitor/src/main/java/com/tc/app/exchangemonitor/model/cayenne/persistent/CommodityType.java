package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._CommodityType;

public class CommodityType extends _CommodityType
{
	private static final long serialVersionUID = 1L;

	public String getCommodityTypeCode()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (String) this.getObjectId().getIdSnapshot().get(CMDTY_TYPE_CODE_PK_COLUMN) : null;
	}
}