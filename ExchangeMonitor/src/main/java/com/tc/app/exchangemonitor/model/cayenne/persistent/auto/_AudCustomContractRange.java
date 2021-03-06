package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCustomContractRange was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCustomContractRange extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> LAST_NUM = new Property<Integer>("lastNum");
	public static final Property<Integer> MAX_NUM = new Property<Integer>("maxNum");
	public static final Property<Integer> NUMBER_FORMAT_WIDTH = new Property<Integer>("numberFormatWidth");
	public static final Property<String> POSTFIX_STRING = new Property<String>("postfixString");
	public static final Property<String> PREFIX_STRING = new Property<String>("prefixString");
	public static final Property<Integer> RANGE_NUM = new Property<Integer>("rangeNum");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setLastNum(Integer lastNum)
	{
		writeProperty("lastNum", lastNum);
	}

	public Integer getLastNum()
	{
		return (Integer) readProperty("lastNum");
	}

	public void setMaxNum(Integer maxNum)
	{
		writeProperty("maxNum", maxNum);
	}

	public Integer getMaxNum()
	{
		return (Integer) readProperty("maxNum");
	}

	public void setNumberFormatWidth(Integer numberFormatWidth)
	{
		writeProperty("numberFormatWidth", numberFormatWidth);
	}

	public Integer getNumberFormatWidth()
	{
		return (Integer) readProperty("numberFormatWidth");
	}

	public void setPostfixString(String postfixString)
	{
		writeProperty("postfixString", postfixString);
	}

	public String getPostfixString()
	{
		return (String) readProperty("postfixString");
	}

	public void setPrefixString(String prefixString)
	{
		writeProperty("prefixString", prefixString);
	}

	public String getPrefixString()
	{
		return (String) readProperty("prefixString");
	}

	public void setRangeNum(Integer rangeNum)
	{
		writeProperty("rangeNum", rangeNum);
	}

	public Integer getRangeNum()
	{
		return (Integer) readProperty("rangeNum");
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
