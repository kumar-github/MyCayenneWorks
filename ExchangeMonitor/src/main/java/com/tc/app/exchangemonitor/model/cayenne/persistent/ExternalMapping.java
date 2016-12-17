package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalMapping;

public class ExternalMapping extends _ExternalMapping
{
	private static final long serialVersionUID = 1L;

	/*
	public void setOid(final Integer oid)
	{
		this.writeProperty("oid", oid);
	}
	
	public Integer getOid()
	{
		return (Integer) this.readProperty("oid");
	}
	 */

	public Integer getExternalMappingOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}

	@Override
	public String toString()
	{
		return this.getExternalValue1().trim().toUpperCase();
	}
}