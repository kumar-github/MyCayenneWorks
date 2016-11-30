package com.tc.app.exchangemonitor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.cayenne.query.ObjectSelect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Country;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeSource;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeState;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalTradeStatus;
import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Portfolio;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Trade;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

public class CayenneReferenceDataCache
{
	private static final Logger LOGGER = LogManager.getLogger(CayenneReferenceDataCache.class);

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
		loadAccountsReferenceData();
		loadIctsUsersReferenceData();
		loadCountriesReferenceData();
		loadCommoditiesReferenceData();
		loadPortfoliosReferenceData();
		loadTemplateTradesReferenceData();
		loadUomsReferenceData();
	}

	/* Do we really need a map here? Think please...*/
	private static ConcurrentMap<Integer, ExternalTradeSource> externalTradeSourceReferenceDataHashMap = null;
	public static void loadExternalTradeSourceReferenceData()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			externalTradeSourceReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalTradeSource> externalTradeSourceList = ObjectSelect.query(ExternalTradeSource.class).where(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME.ne("NonDefined")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeSourceList.size() + " external trade sources.");

			if(externalTradeSourceList != null)
			{
				for(final ExternalTradeSource anExternalTradeSource : externalTradeSourceList)
				{
					externalTradeSourceReferenceDataHashMap.put(anExternalTradeSource.getExternalTradeSourceOid(), anExternalTradeSource);
				}
			}
		}
	}

	private static ConcurrentMap<Integer, ExternalTradeState> externalTradeStateReferenceDataHashMap = null;
	public static void loadExternalTradeStateReferenceData()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			externalTradeStateReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalTradeState> externalTradeStateList = ObjectSelect.query(ExternalTradeState.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeStateList.size() + " external trade states.");

			if(externalTradeStateList != null)
			{
				for(final ExternalTradeState anExternalTradeState : externalTradeStateList)
				{
					externalTradeStateReferenceDataHashMap.put(anExternalTradeState.getExternalTradeStateOid(), anExternalTradeState);
				}
			}
		}
	}

	private static ConcurrentMap<Integer, ExternalTradeStatus> externalTradeStatusReferenceDataHashMap = null;
	public static void loadExternalTradeStatusReferenceData()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			externalTradeStatusReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalTradeStatus> externalTradeStatusList = ObjectSelect.query(ExternalTradeStatus.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeStatusList.size() + " external trade statuses.");

			if(externalTradeStatusList != null)
			{
				for(final ExternalTradeStatus anExternalTradeStatus : externalTradeStatusList)
				{
					externalTradeStatusReferenceDataHashMap.put(anExternalTradeStatus.getExternalTradeStatusOid(), anExternalTradeStatus);
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
			//final List<ExternalMapping> externalTradeAccountList = ObjectSelect.query(ExternalMapping.class).where(ExternalMapping.MAPPING_TYPE.eq("K")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final List<ExternalMapping> externalTradeAccountList = ObjectSelect.query(ExternalMapping.class).where(ExternalMapping.MAPPING_TYPE.eq("K")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + externalTradeAccountList.size() + " external trade accounts.");

			if(externalTradeAccountList != null)
			{
				for(final ExternalMapping anExternalTradeAccount : externalTradeAccountList)
				{
					externalTradeAccountReferenceDataHashMap.put(anExternalTradeAccount.getExternalValue1(), anExternalTradeAccount);
				}
			}
		}
	}

	private static List<ExternalMapping> externalMappingReferenceDataList = null;
	public static void loadExternalMappingReferenceData()
	{
		if(externalMappingReferenceDataList == null)
		{
			externalMappingReferenceDataList = new ArrayList<>();

			final long startTime = System.currentTimeMillis();
			//externalMappingReferenceDataList = HibernateReferenceDataFetchUtil.fetchDataFromDBForSQLNamedQuery("ExternalMapping.findAllExternalMappings");
			externalMappingReferenceDataList = ObjectSelect.query(ExternalMapping.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + externalMappingReferenceDataList.size() + " external mappings.");
		}
	}

	private static ConcurrentMap<Integer, Account> accountsReferenceDataHashMap = null;
	public static void loadAccountsReferenceData()
	{
		if(accountsReferenceDataHashMap == null)
		{
			accountsReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			//final List<Account> accountList = ObjectSelect.query(Account.class).where(Account.ACCT_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final List<Account> accountList = ObjectSelect.query(Account.class).where(Account.ACCT_STATUS.eq("A")).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + accountList.size() + " accounts.");

			if(accountList != null)
			{
				for(final Account anAccount : accountList)
				{
					accountsReferenceDataHashMap.put(anAccount.getAccountNum(), anAccount);
				}
			}
		}
	}

	private static ConcurrentMap<String, IctsUser> ictsUsersReferenceDataHashMap = null;
	public static void loadIctsUsersReferenceData()
	{
		if(ictsUsersReferenceDataHashMap == null)
		{
			ictsUsersReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<IctsUser> ictsUsersList = ObjectSelect.query(IctsUser.class).where(IctsUser.USER_STATUS.eq("A")).prefetch(IctsUser.USER_JOB_TITLE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + ictsUsersList.size() + " icts users.");

			if(ictsUsersList != null)
			{
				for(final IctsUser anIctsUser : ictsUsersList)
				{
					ictsUsersReferenceDataHashMap.put(anIctsUser.getUserInit(), anIctsUser);
				}
			}
		}
	}

	private static ConcurrentMap<String, Country> countriesReferenceDataHashMap = null;
	public static void loadCountriesReferenceData()
	{
		if(countriesReferenceDataHashMap == null)
		{
			countriesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Country> countriesList = ObjectSelect.query(Country.class).where(Country.COUNTRY_STATUS.eq("A")).and(Country.ISO_COUNTRY_CODE.isNotNull()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + countriesList.size() + " countries.");

			if(countriesList != null)
			{
				for(final Country aCountry : countriesList)
				{
					countriesReferenceDataHashMap.put(aCountry.getCountryCode(), aCountry);
				}
			}
		}
	}

	private static ConcurrentMap<String, Commodity> commoditiesReferenceDataHashMap = null;
	public static void loadCommoditiesReferenceData()
	{
		if(commoditiesReferenceDataHashMap == null)
		{
			commoditiesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Commodity> commoditiesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + commoditiesList.size() + " commodities.");

			if(commoditiesList != null)
			{
				for(final Commodity aCommodity : commoditiesList)
				{
					commoditiesReferenceDataHashMap.put(aCommodity.getCmdtyCode(), aCommodity);
				}
			}
		}
	}

	private static ConcurrentMap<Integer, Portfolio> portfoliosReferenceDataHashMap = null;
	public static void loadPortfoliosReferenceData()
	{
		if(portfoliosReferenceDataHashMap == null)
		{
			portfoliosReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Portfolio> portfoliosList = ObjectSelect.query(Portfolio.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + portfoliosList.size() + " portfolios.");

			if(portfoliosList != null)
			{
				for(final Portfolio aPortfolio : portfoliosList)
				{
					portfoliosReferenceDataHashMap.put(aPortfolio.getPortNum(), aPortfolio);
				}
			}
		}
	}

	private static ConcurrentMap<Integer, Trade> templateTradesReferenceDataHashMap = null;
	public static void loadTemplateTradesReferenceData()
	{
		if(templateTradesReferenceDataHashMap == null)
		{
			templateTradesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			/* Actually we need to filter even the deleted trades but dont know how to do. We can go for query method to fetch the required trades. But leaving it for now. */
			final List<Trade> templateTradesList = ObjectSelect.query(Trade.class).where(Trade.CONCLUSION_TYPE.eq("I")).prefetch(Trade.TRADE_STATUS.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + templateTradesList.size() + " template trades.");

			if(templateTradesList != null)
			{
				for(final Trade aTrade : templateTradesList)
				{
					templateTradesReferenceDataHashMap.put(aTrade.getTradeNum(), aTrade);
				}
			}
		}
	}

	private static ConcurrentMap<String, Uom> uomsReferenceDataHashMap = null;
	public static void loadUomsReferenceData()
	{
		if(uomsReferenceDataHashMap == null)
		{
			uomsReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Uom> uomsList = ObjectSelect.query(Uom.class).where(Uom.UOM_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took " + (endTime - startTime) + " milli seconds to fetch " + uomsList.size() + " uoms.");

			if(uomsList != null)
			{
				for(final Uom anUom : uomsList)
				{
					uomsReferenceDataHashMap.put(anUom.getUomCode(), anUom);
				}
			}
		}
	}

	//public static ConcurrentMap<Integer, IExternalTradeSourceEntity> fetchExternalTradeSources()
	public static ConcurrentMap<Integer, ExternalTradeSource> fetchExternalTradeSources()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			loadExternalTradeSourceReferenceData();
		}
		return externalTradeSourceReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, ExternalTradeState> fetchExternalTradeStates()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			loadExternalTradeStateReferenceData();
		}
		return externalTradeStateReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, ExternalTradeStatus> fetchExternalTradeStatuses()
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

	public static ConcurrentMap<Integer, Account> fetchAllActiveAccounts()
	{
		if(accountsReferenceDataHashMap == null)
		{
			loadAccountsReferenceData();
		}
		return accountsReferenceDataHashMap;
	}

	public static ConcurrentMap<String, IctsUser> fetchAllActiveIctsUsers()
	{
		if(ictsUsersReferenceDataHashMap == null)
		{
			loadIctsUsersReferenceData();
		}
		return ictsUsersReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Country> fetchAllActiveCountries()
	{
		if(countriesReferenceDataHashMap == null)
		{
			loadCountriesReferenceData();
		}
		return countriesReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Commodity> fetchAllActiveCommodities()
	{
		if(commoditiesReferenceDataHashMap == null)
		{
			loadCommoditiesReferenceData();
		}
		return commoditiesReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, Portfolio> fetchAllPortfolios()
	{
		if(portfoliosReferenceDataHashMap == null)
		{
			loadPortfoliosReferenceData();
		}
		return portfoliosReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, Trade> fetchAllTemplateTrades()
	{
		if(templateTradesReferenceDataHashMap == null)
		{
			loadTemplateTradesReferenceData();
		}
		return templateTradesReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Uom> fetchAllActiveUoms()
	{
		if(uomsReferenceDataHashMap == null)
		{
			loadUomsReferenceData();
		}
		return uomsReferenceDataHashMap;
	}
}