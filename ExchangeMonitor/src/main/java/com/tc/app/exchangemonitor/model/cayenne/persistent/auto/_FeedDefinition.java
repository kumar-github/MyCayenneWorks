package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AiEstActualInterface;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedData;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedDefinitionXsdXml;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedScheduler;

/**
 * Class _FeedDefinition was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FeedDefinition extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Boolean> ACTIVE_IND = new Property<Boolean>("activeInd");
	public static final Property<String> DISPLAY_NAME = new Property<String>("displayName");
	public static final Property<String> FEED_NAME = new Property<String>("feedName");
	public static final Property<String> INTERFACE = new Property<String>("interface");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<AiEstActualInterface>> AI_EST_ACTUAL_INTERFACES = new Property<List<AiEstActualInterface>>("aiEstActualInterfaces");
	public static final Property<List<FeedData>> FEED_DATAS = new Property<List<FeedData>>("feedDatas");
	public static final Property<List<FeedScheduler>> FEED_SCHEDULERS = new Property<List<FeedScheduler>>("feedSchedulers");
	public static final Property<FeedDefinitionXsdXml> MAPPING_XML = new Property<FeedDefinitionXsdXml>("mappingXml");
	public static final Property<FeedDefinitionXsdXml> REQUEST_XSD = new Property<FeedDefinitionXsdXml>("requestXsd");
	public static final Property<FeedDefinitionXsdXml> RESPONSE_XSD = new Property<FeedDefinitionXsdXml>("responseXsd");

	public void setActiveInd(Boolean activeInd)
	{
		writeProperty("activeInd", activeInd);
	}

	public Boolean getActiveInd()
	{
		return (Boolean) readProperty("activeInd");
	}

	public void setDisplayName(String displayName)
	{
		writeProperty("displayName", displayName);
	}

	public String getDisplayName()
	{
		return (String) readProperty("displayName");
	}

	public void setFeedName(String feedName)
	{
		writeProperty("feedName", feedName);
	}

	public String getFeedName()
	{
		return (String) readProperty("feedName");
	}

	public void setInterface(String _interface)
	{
		writeProperty("interface", _interface);
	}

	public String getInterface()
	{
		return (String) readProperty("interface");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToAiEstActualInterfaces(AiEstActualInterface obj)
	{
		addToManyTarget("aiEstActualInterfaces", obj, true);
	}

	public void removeFromAiEstActualInterfaces(AiEstActualInterface obj)
	{
		removeToManyTarget("aiEstActualInterfaces", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AiEstActualInterface> getAiEstActualInterfaces()
	{
		return (List<AiEstActualInterface>) readProperty("aiEstActualInterfaces");
	}

	public void addToFeedDatas(FeedData obj)
	{
		addToManyTarget("feedDatas", obj, true);
	}

	public void removeFromFeedDatas(FeedData obj)
	{
		removeToManyTarget("feedDatas", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FeedData> getFeedDatas()
	{
		return (List<FeedData>) readProperty("feedDatas");
	}

	public void addToFeedSchedulers(FeedScheduler obj)
	{
		addToManyTarget("feedSchedulers", obj, true);
	}

	public void removeFromFeedSchedulers(FeedScheduler obj)
	{
		removeToManyTarget("feedSchedulers", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FeedScheduler> getFeedSchedulers()
	{
		return (List<FeedScheduler>) readProperty("feedSchedulers");
	}

	public void setMappingXml(FeedDefinitionXsdXml mappingXml)
	{
		setToOneTarget("mappingXml", mappingXml, true);
	}

	public FeedDefinitionXsdXml getMappingXml()
	{
		return (FeedDefinitionXsdXml) readProperty("mappingXml");
	}

	public void setRequestXsd(FeedDefinitionXsdXml requestXsd)
	{
		setToOneTarget("requestXsd", requestXsd, true);
	}

	public FeedDefinitionXsdXml getRequestXsd()
	{
		return (FeedDefinitionXsdXml) readProperty("requestXsd");
	}

	public void setResponseXsd(FeedDefinitionXsdXml responseXsd)
	{
		setToOneTarget("responseXsd", responseXsd, true);
	}

	public FeedDefinitionXsdXml getResponseXsd()
	{
		return (FeedDefinitionXsdXml) readProperty("responseXsd");
	}

}
