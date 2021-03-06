package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AudCommktSrcAliasInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AudCommktSrcAliasInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> ALIAS_SOURCE_CODE = new Property<String>("aliasSourceCode");
	public static final Property<String> CALC_AVG_PRICE_IND = new Property<String>("calcAvgPriceInd");
	public static final Property<String> COMMKT_CODED_AS_SPOT_IND = new Property<String>("commktCodedAsSpotInd");
	public static final Property<String> COMMKT_GENERATE_SPOT_IND = new Property<String>("commktGenerateSpotInd");
	public static final Property<Integer> COMMKT_KEY = new Property<Integer>("commktKey");
	public static final Property<Integer> PRICE_LOAD_DURATION = new Property<Integer>("priceLoadDuration");
	public static final Property<Integer> PRICE_LOAD_FREQ = new Property<Integer>("priceLoadFreq");
	public static final Property<Integer> PRICE_LOAD_START = new Property<Integer>("priceLoadStart");
	public static final Property<String> PRICE_SOURCE_CODE = new Property<String>("priceSourceCode");
	public static final Property<String> PRICE_UOM_CODE = new Property<String>("priceUomCode");
	public static final Property<Integer> RESP_TRANS_ID = new Property<Integer>("respTransId");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");

	public void setAliasSourceCode(String aliasSourceCode)
	{
		writeProperty("aliasSourceCode", aliasSourceCode);
	}

	public String getAliasSourceCode()
	{
		return (String) readProperty("aliasSourceCode");
	}

	public void setCalcAvgPriceInd(String calcAvgPriceInd)
	{
		writeProperty("calcAvgPriceInd", calcAvgPriceInd);
	}

	public String getCalcAvgPriceInd()
	{
		return (String) readProperty("calcAvgPriceInd");
	}

	public void setCommktCodedAsSpotInd(String commktCodedAsSpotInd)
	{
		writeProperty("commktCodedAsSpotInd", commktCodedAsSpotInd);
	}

	public String getCommktCodedAsSpotInd()
	{
		return (String) readProperty("commktCodedAsSpotInd");
	}

	public void setCommktGenerateSpotInd(String commktGenerateSpotInd)
	{
		writeProperty("commktGenerateSpotInd", commktGenerateSpotInd);
	}

	public String getCommktGenerateSpotInd()
	{
		return (String) readProperty("commktGenerateSpotInd");
	}

	public void setCommktKey(Integer commktKey)
	{
		writeProperty("commktKey", commktKey);
	}

	public Integer getCommktKey()
	{
		return (Integer) readProperty("commktKey");
	}

	public void setPriceLoadDuration(Integer priceLoadDuration)
	{
		writeProperty("priceLoadDuration", priceLoadDuration);
	}

	public Integer getPriceLoadDuration()
	{
		return (Integer) readProperty("priceLoadDuration");
	}

	public void setPriceLoadFreq(Integer priceLoadFreq)
	{
		writeProperty("priceLoadFreq", priceLoadFreq);
	}

	public Integer getPriceLoadFreq()
	{
		return (Integer) readProperty("priceLoadFreq");
	}

	public void setPriceLoadStart(Integer priceLoadStart)
	{
		writeProperty("priceLoadStart", priceLoadStart);
	}

	public Integer getPriceLoadStart()
	{
		return (Integer) readProperty("priceLoadStart");
	}

	public void setPriceSourceCode(String priceSourceCode)
	{
		writeProperty("priceSourceCode", priceSourceCode);
	}

	public String getPriceSourceCode()
	{
		return (String) readProperty("priceSourceCode");
	}

	public void setPriceUomCode(String priceUomCode)
	{
		writeProperty("priceUomCode", priceUomCode);
	}

	public String getPriceUomCode()
	{
		return (String) readProperty("priceUomCode");
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
