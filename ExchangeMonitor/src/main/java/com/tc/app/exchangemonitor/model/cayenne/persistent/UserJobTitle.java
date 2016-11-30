package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._UserJobTitle;

public class UserJobTitle extends _UserJobTitle
{
	private static final long serialVersionUID = 1L;

	public String getUserJobTitle()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (String) this.getObjectId().getIdSnapshot().get(JOB_TITLE_PK_COLUMN) : null;
	}
}