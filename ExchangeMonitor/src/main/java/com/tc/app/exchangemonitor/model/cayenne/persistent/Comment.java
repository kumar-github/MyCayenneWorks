package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._Comment;

public class Comment extends _Comment
{
	private static final long serialVersionUID = 1L;

	public Integer getCommentNum()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(CMNT_NUM_PK_COLUMN) : null;
	}
}