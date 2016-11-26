package com.tc.app.exchangemonitor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.cayenne.query.ObjectSelect;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus;

public class CayenneReferenceDataCache
{
	public CayenneReferenceDataCache()
	{
	}

	public static void loadAllReferenceData()
	{
		loadExternalTradeSourceReferenceData();
		loadExternalTradeStateReferenceData();
		loadExternalTradeStatusReferenceData();
		loadExternalTradeAccountReferenceData();
		loadExternalMappingReferenceData();
	}

	/* Do we really need a map here? Think please...*/
	//private static ConcurrentMap<Integer, IExternalTradeSourceEntity> externalTradeSourceReferenceDataHashMap = null;
	private static ConcurrentMap<String, ExternalTradeSource> externalTradeSourceReferenceDataHashMap = null;
	public static void loadExternalTradeSourceReferenceData()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			//externalTradeSourceReferenceDataHashMap = new ConcurrentHashMap<Integer, IExternalTradeSourceEntity>();
			externalTradeSourceReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource> externalTradeSourceList = ObjectSelect.query(com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeSourceList.size() + " external trade sources.");

			if(externalTradeSourceList != null)
			{
				for(final ExternalTradeSource anExternalTradeSource : externalTradeSourceList)
				{
					externalTradeSourceReferenceDataHashMap.put(anExternalTradeSource.OID_PK_COLUMN, anExternalTradeSource);
				}
			}
		}
	}

	private static ConcurrentMap<String, ExternalTradeState> externalTradeStateReferenceDataHashMap = null;
	public static void loadExternalTradeStateReferenceData()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			externalTradeStateReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState> externalTradeStateList = ObjectSelect.query(com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeStateList.size() + " external trade states.");

			if(externalTradeStateList != null)
			{
				for(final ExternalTradeState anExternalTradeState : externalTradeStateList)
				{
					externalTradeStateReferenceDataHashMap.put(anExternalTradeState.OID_PK_COLUMN, anExternalTradeState);
				}
			}
		}
	}

	private static ConcurrentMap<String, ExternalTradeStatus> externalTradeStatusReferenceDataHashMap = null;
	public static void loadExternalTradeStatusReferenceData()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			externalTradeStatusReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus> externalTradeStatusList = ObjectSelect.query(com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeStatusList.size() + " external trade statuses.");

			if(externalTradeStatusList != null)
			{
				for(final ExternalTradeStatus anExternalTradeStatus : externalTradeStatusList)
				{
					externalTradeStatusReferenceDataHashMap.put(anExternalTradeStatus.OID_PK_COLUMN, anExternalTradeStatus);
				}
			}
		}
	}

	private static ConcurrentMap<String, ExternalMapping> externalTradeAccountReferenceDataHashMap = null;
	public static void loadExternalTradeAccountReferenceData()
	{
		if(externalTradeAccountReferenceDataHashMap == null)
		{
			externalTradeAccountReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping> externalTradeAccountList = ObjectSelect.query(com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping.class).where(ExternalMapping.MAPPING_TYPE.eq("K")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeAccountList.size() + " external trade accounts.");

			if(externalTradeAccountList != null)
			{
				for(final ExternalMapping anExternalTradeAccount : externalTradeAccountList)
				{
					//externalTradeAccountReferenceDataHashMap.put(anExternalTradeStatus.getOid(), anExternalTradeStatus);
					externalTradeAccountReferenceDataHashMap.put(anExternalTradeAccount.getExternalValue1(), anExternalTradeAccount);
				}
			}
		}
	}

	//private static ConcurrentMap<String, ExternalMapping> externalMappingReferenceDataHashMap = null;
	private static List<ExternalMapping> externalMappingReferenceDataList = null;
	@SuppressWarnings("unchecked")
	public static void loadExternalMappingReferenceData()
	{
		if(externalMappingReferenceDataList == null)
		{
			externalMappingReferenceDataList = new ArrayList<>();

			final long startTime = System.currentTimeMillis();
			externalMappingReferenceDataList = HibernateReferenceDataFetchUtil.fetchDataFromDBForSQLNamedQuery("ExternalMapping.findAllExternalMappings");
			externalMappingReferenceDataList = ObjectSelect.query(com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			System.out.println("It took " + (endTime - startTime) + " milli seconds to fetch " + externalMappingReferenceDataList.size() + " external mappings.");
		}
	}

	//public static ConcurrentMap<Integer, IExternalTradeSourceEntity> fetchExternalTradeSources()
	public static ConcurrentMap<String, ExternalTradeSource> fetchExternalTradeSources()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			loadExternalTradeSourceReferenceData();
		}
		return externalTradeSourceReferenceDataHashMap;
	}

	public static ConcurrentMap<String, ExternalTradeState> fetchExternalTradeStates()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			loadExternalTradeStateReferenceData();
		}
		return externalTradeStateReferenceDataHashMap;
	}

	public static ConcurrentMap<String, ExternalTradeStatus> fetchExternalTradeStatuses()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			loadExternalTradeStatusReferenceData();
		}
		return externalTradeStatusReferenceDataHashMap;
	}

	public static ConcurrentMap<String, ExternalMapping> fetchExternalTradeAccounts()
	{
		if(externalTradeAccountReferenceDataHashMap == null)
		{
			loadExternalTradeAccountReferenceData();
		}
		return externalTradeAccountReferenceDataHashMap;
	}

	public static List<ExternalMapping> fetchExternalMappings()
	{
		if(externalMappingReferenceDataList == null)
		{
			loadExternalMappingReferenceData();
		}
		return externalMappingReferenceDataList;
	}
}