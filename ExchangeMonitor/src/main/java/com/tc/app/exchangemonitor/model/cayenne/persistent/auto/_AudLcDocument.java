package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudLcDocument was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudLcDocument extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> LC_DOC_CODE = new Property<String>("lcDocCode");
	public static final Property<Short> LC_DOC_COPY_NUM = new Property<Short>("lcDocCopyNum");
	public static final Property<Short> LC_NO_OF_ORIG_DOC_REQD = new Property<Short>("lcNoOfOrigDocReqd");
	public static final Property<Integer> LC_NUM = new Property<Integer>("lcNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setLcDocCode(String lcDocCode)
	{
		writeProperty("lcDocCode", lcDocCode);
	}

	public String getLcDocCode()
	{
		return (String) readProperty("lcDocCode");
	}

	public void setLcDocCopyNum(Short lcDocCopyNum)
	{
		writeProperty("lcDocCopyNum", lcDocCopyNum);
	}

	public Short getLcDocCopyNum()
	{
		return (Short) readProperty("lcDocCopyNum");
	}

	public void setLcNoOfOrigDocReqd(Short lcNoOfOrigDocReqd)
	{
		writeProperty("lcNoOfOrigDocReqd", lcNoOfOrigDocReqd);
	}

	public Short getLcNoOfOrigDocReqd()
	{
		return (Short) readProperty("lcNoOfOrigDocReqd");
	}

	public void setLcNum(Integer lcNum)
	{
		writeProperty("lcNum", lcNum);
	}

	public Integer getLcNum()
	{
		return (Integer) readProperty("lcNum");
	}

	public void setRespTransId(Integer respTransId)
	{
		writeProperty("respTransId", respTransId);
	}

	public Integer getRespTransId()
	{
		return (Integer) readProperty("respTransId");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

}
