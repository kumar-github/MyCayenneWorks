package com.tc.app.exchangemonitor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

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

import javafx.concurrent.Task;

public class CayenneReferenceDataCache
{
	//private static final Logger LOGGER = LogManager.getLogger(CayenneReferenceDataCache.class);
	/* In Log4j2, passing class name for getLogger() is optional. So the below is equal to the above. */
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	public static void fetchAllReferenceData()
	{
		fetchExternalTradeSourceReferenceData();
		fetchExternalTradeStateReferenceData();
		fetchExternalTradeStatusReferenceData();
		fetchExternalTradeAccountReferenceData();
		fetchExternalMappingReferenceData();

		/*
		fetchAccountsReferenceData();
		fetchIctsUsersReferenceData();
		fetchCountriesReferenceData();
		fetchCommoditiesReferenceData();
		fetchPortfoliosReferenceData();
		fetchTemplateTradesReferenceData();
		fetchUomsReferenceData();
		*/

		Task task;
		task = TaskUtil.task(() -> {
			fetchAccountsReferenceData();
			fetchIctsUsersReferenceData();
			fetchCountriesReferenceData();
			fetchCommoditiesReferenceData();
			fetchPortfoliosReferenceData();
			fetchTemplateTradesReferenceData();
			fetchUomsReferenceData();
			return null;
		});
		new Thread(task).start();

		/*
		final Task task;
		task = new Task<Void>(){
			@Override
			protected Void call() throws Exception
			{
				fetchAccountsReferenceData();
				fetchIctsUsersReferenceData();
				fetchCountriesReferenceData();
				fetchCommoditiesReferenceData();
				fetchPortfoliosReferenceData();
				fetchTemplateTradesReferenceData();
				fetchUomsReferenceData();
				return null;
			}
		};
		new Thread(task).start();
		*/

		/* The below is not needed since we already loaded all the commodities and a currency is nothing but a commodity of type "C".
		 * But still we are doing because we want to maintain a  seperate map for currencies which we use it directly at some situations instead of getting the commodities map and filtering it.
		 * Also believing that the previuos fetch for commodities will be in the cache, hence this won't affect the performance much.
		 */
		//fetchCurrenciesReferenceData();
	}

	/* Do we really need a map here? Think again... */
	private static ConcurrentMap<String, ExternalTradeSource> externalTradeSourceReferenceDataHashMap = null;

	private static void fetchExternalTradeSourceReferenceData()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			externalTradeSourceReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();

			final List<ExternalTradeSource> externalTradeSourceList = ObjectSelect.query(ExternalTradeSource.class).where(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME.ne("NonDefined")).select(CayenneHelper.getCayenneServerRuntime().newContext());

			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} external trade sources.", (endTime - startTime), externalTradeSourceList.size());

			//Bye Bye loops... Welcome Lambdas
			/*
			if(externalTradeSourceList != null)
			{
				for(final ExternalTradeSource anExternalTradeSource : externalTradeSourceList)
				{
					externalTradeSourceReferenceDataHashMap.put(anExternalTradeSource.getExternalTradeSourceOid(), anExternalTradeSource);
				}
			}
			 */
			//externalTradeSourceReferenceDataHashMap = externalTradeSourceList.stream().collect(Collectors.toConcurrentMap(theExternalTradeSource -> theExternalTradeSource.getExternalTradeSourceOid(), theExternalTradeSource -> theExternalTradeSource));

			externalTradeSourceReferenceDataHashMap = externalTradeSourceList.stream().collect(Collectors.toConcurrentMap(ExternalTradeSource::getExternalTradeSrcName, theExternalTradeSource -> theExternalTradeSource));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(externalTradeSourceList, externalTradeSourceReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<Integer, ExternalTradeState> externalTradeStateReferenceDataHashMap = null;

	private static void fetchExternalTradeStateReferenceData()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			externalTradeStateReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalTradeState> externalTradeStateList = ObjectSelect.query(ExternalTradeState.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} external trade states.", (endTime - startTime), externalTradeStateList.size());

			externalTradeStateReferenceDataHashMap = externalTradeStateList.stream().collect(Collectors.toConcurrentMap(ExternalTradeState::getExternalTradeStateOid, theExternalTradeState -> theExternalTradeState));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(externalTradeStateList, externalTradeStateReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<Integer, ExternalTradeStatus> externalTradeStatusReferenceDataHashMap = null;

	private static void fetchExternalTradeStatusReferenceData()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			externalTradeStatusReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalTradeStatus> externalTradeStatusList = ObjectSelect.query(ExternalTradeStatus.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} external trade statuses.", (endTime - startTime), externalTradeStatusList.size());

			externalTradeStatusReferenceDataHashMap = externalTradeStatusList.stream().collect(Collectors.toConcurrentMap(ExternalTradeStatus::getExternalTradeStatusOid, theExternalTradeStatus -> theExternalTradeStatus));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(externalTradeStatusList, externalTradeStatusReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<String, ExternalMapping> externalTradeAccountReferenceDataHashMap = null;

	private static void fetchExternalTradeAccountReferenceData()
	{
		if(externalTradeAccountReferenceDataHashMap == null)
		{
			externalTradeAccountReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<ExternalMapping> externalTradeAccountList = ObjectSelect.query(ExternalMapping.class).where(ExternalMapping.MAPPING_TYPE.eq("K")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} external trade accounts.", (endTime - startTime), externalTradeAccountList.size());

			//externalTradeAccountReferenceDataHashMap = externalTradeAccountList.stream().collect(Collectors.toConcurrentMap(ExternalMapping::getExternalValue1, theExternalMapping -> theExternalMapping));
			externalTradeAccountReferenceDataHashMap = externalTradeAccountList.stream().collect(Collectors.toConcurrentMap(ExternalMapping::getExternalValue1, theExternalMapping -> theExternalMapping, (theExistingMapping, theNewMapping) -> theExistingMapping));
			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(externalTradeAccountList, externalTradeAccountReferenceDataHashMap);
			}
		}
	}

	private static List<ExternalMapping> externalMappingReferenceDataList = null;

	private static void fetchExternalMappingReferenceData()
	{
		if(externalMappingReferenceDataList == null)
		{
			externalMappingReferenceDataList = new ArrayList<>();

			final long startTime = System.currentTimeMillis();
			externalMappingReferenceDataList = ObjectSelect.query(ExternalMapping.class).prefetch(ExternalMapping.EXTERNAL_TRADE_SOURCE_O.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} external mappings.", (endTime - startTime), externalMappingReferenceDataList.size());

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(externalMappingReferenceDataList);
			}
		}
	}

	private static ConcurrentMap<Integer, Account> accountsReferenceDataHashMap = null;

	private static void fetchAccountsReferenceData()
	{
		if(accountsReferenceDataHashMap == null)
		{
			accountsReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Account> accountList = ObjectSelect.query(Account.class).where(Account.ACCT_STATUS.eq("A")).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} accounts.", (endTime - startTime), accountList.size());

			accountsReferenceDataHashMap = accountList.stream().collect(Collectors.toConcurrentMap(Account::getAccountNum, theAccount -> theAccount));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(accountList, accountsReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<String, IctsUser> ictsUsersReferenceDataHashMap = null;

	private static void fetchIctsUsersReferenceData()
	{
		if(ictsUsersReferenceDataHashMap == null)
		{
			ictsUsersReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<IctsUser> ictsUsersList = ObjectSelect.query(IctsUser.class).where(IctsUser.USER_STATUS.eq("A")).prefetch(IctsUser.USER_JOB_TITLE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} icts users.", (endTime - startTime), ictsUsersList.size());

			ictsUsersReferenceDataHashMap = ictsUsersList.stream().collect(Collectors.toConcurrentMap(IctsUser::getUserInit, theIctsUser -> theIctsUser));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(ictsUsersList, ictsUsersReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<String, Country> countriesReferenceDataHashMap = null;
	private static ConcurrentMap<String, Country> isoCountriesReferenceDataHashMap = null;
	private static ConcurrentMap<String, Country> countriesReferenceDataHashMapWithCountryName = null;

	private static void fetchCountriesReferenceData()
	{
		if(countriesReferenceDataHashMap == null)
		{
			countriesReferenceDataHashMap = new ConcurrentHashMap<>();
			isoCountriesReferenceDataHashMap = new ConcurrentHashMap<>();
			countriesReferenceDataHashMapWithCountryName = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Country> countriesList = ObjectSelect.query(Country.class).where(Country.COUNTRY_STATUS.eq("A")).and(Country.ISO_COUNTRY_CODE.isNotNull()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} countries.", (endTime - startTime), countriesList.size());

			countriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toConcurrentMap(Country::getCountryCode, theCountry -> theCountry));

			//isoCountriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toConcurrentMap(Country::getIsoCountryCode, theCountry -> theCountry));
			isoCountriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toConcurrentMap(Country::getIsoCountryCode, theCountry -> theCountry, (theExistingCountry, theNewCountry) -> theExistingCountry));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(countriesList, countriesReferenceDataHashMap);
				doSomeExtraLogginIfNeeded(countriesList, isoCountriesReferenceDataHashMap);
				doSomeExtraLogginIfNeeded(countriesList, countriesReferenceDataHashMapWithCountryName);
			}
		}
	}

	private static ConcurrentMap<String, Commodity> commoditiesReferenceDataHashMap = null;

	private static void fetchCommoditiesReferenceData()
	{
		if(commoditiesReferenceDataHashMap == null)
		{
			commoditiesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			//final List<Commodity> commoditiesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final List<Commodity> commoditiesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).prefetch(Commodity.COMMODITY_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} commodities.", (endTime - startTime), commoditiesList.size());

			commoditiesReferenceDataHashMap = commoditiesList.stream().collect(Collectors.toConcurrentMap(Commodity::getCmdtyCode, theCommodity -> theCommodity));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(commoditiesList, commoditiesReferenceDataHashMap);
			}
		}
	}

	/*
	private static ConcurrentMap<String, Commodity> currenciesReferenceDataHashMap = null;
	private static void fetchCurrenciesReferenceData()
	{
		if(currenciesReferenceDataHashMap == null)
		{
			currenciesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Commodity> currenciesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).prefetch(Commodity.COMMODITY_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			//final EJBQLQuery query = new EJBQLQuery("select commodity FROM Commodity commodity JOIN commodity.commodityType commodityType where commodityType = 'C'");
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} currencies.", (endTime - startTime), currenciesList.size());

			currenciesReferenceDataHashMap = currenciesList.stream().collect(Collectors.toConcurrentMap(Commodity::getCmdtyCode, theCommodity -> theCommodity));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(currenciesList, currenciesReferenceDataHashMap);
			}
		}
	}
	 */

	private static ConcurrentMap<Integer, Portfolio> portfoliosReferenceDataHashMap = null;

	private static void fetchPortfoliosReferenceData()
	{
		if(portfoliosReferenceDataHashMap == null)
		{
			portfoliosReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Portfolio> portfoliosList = ObjectSelect.query(Portfolio.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} portfolios.", (endTime - startTime), portfoliosList.size());

			portfoliosReferenceDataHashMap = portfoliosList.stream().collect(Collectors.toConcurrentMap(Portfolio::getPortNum, thePortfolio -> thePortfolio));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(portfoliosList, portfoliosReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<Integer, Trade> templateTradesReferenceDataHashMap = null;

	private static void fetchTemplateTradesReferenceData()
	{
		if(templateTradesReferenceDataHashMap == null)
		{
			templateTradesReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			/* Actually we need to filter even the deleted trades but dont know how to do. We can go for query method to fetch the required trades. But leaving it for now. */
			final List<Trade> templateTradesList = ObjectSelect.query(Trade.class).where(Trade.CONCLUSION_TYPE.eq("I")).prefetch(Trade.TRADE_STATUS.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final List<Trade> undeletedTemplateTradesList = templateTradesList.stream().filter((aTrade) -> !aTrade.getTradeStatus().getTradeStatusCode().trim().equals("DELETE")).collect(Collectors.toList());

			//final EJBQLQuery queryToFetchTradeNums = new EJBQLQuery("select trade.trade_num FROM Trade trade where trade.copyType <> 'FULL'");
			//final List<String> tradeNums = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(queryToFetchTradeNums);
			//tradeNums.forEach(System.out::println);
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} template trades.", (endTime - startTime), templateTradesList.size());

			//templateTradesReferenceDataHashMap = templateTradesList.stream().collect(Collectors.toConcurrentMap(Trade::getTradeNum, theTrade -> theTrade));
			templateTradesReferenceDataHashMap = undeletedTemplateTradesList.stream().collect(Collectors.toConcurrentMap(Trade::getTradeNum, theTrade -> theTrade));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(templateTradesList, templateTradesReferenceDataHashMap);
				doSomeExtraLogginIfNeeded(undeletedTemplateTradesList, templateTradesReferenceDataHashMap);
			}
		}
	}

	private static ConcurrentMap<String, Uom> uomsReferenceDataHashMap = null;

	private static void fetchUomsReferenceData()
	{
		if(uomsReferenceDataHashMap == null)
		{
			uomsReferenceDataHashMap = new ConcurrentHashMap<>();

			final long startTime = System.currentTimeMillis();
			final List<Uom> uomsList = ObjectSelect.query(Uom.class).where(Uom.UOM_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
			final long endTime = System.currentTimeMillis();
			LOGGER.info("It took {} milli seconds to fetch {} uoms.", (endTime - startTime), uomsList.size());

			uomsReferenceDataHashMap = uomsList.stream().collect(Collectors.toConcurrentMap(Uom::getUomCode, theUom -> theUom));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(uomsList, uomsReferenceDataHashMap);
			}
		}
	}

	public static ConcurrentMap<String, ExternalTradeSource> loadExternalTradeSources()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			fetchExternalTradeSourceReferenceData();
		}
		return externalTradeSourceReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, ExternalTradeState> loadExternalTradeStates()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			fetchExternalTradeStateReferenceData();
		}
		return externalTradeStateReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, ExternalTradeStatus> loadExternalTradeStatuses()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			fetchExternalTradeStatusReferenceData();
		}
		return externalTradeStatusReferenceDataHashMap;
	}

	public static ConcurrentMap<String, ExternalMapping> loadExternalTradeAccounts()
	{
		if(externalTradeAccountReferenceDataHashMap == null)
		{
			fetchExternalTradeAccountReferenceData();
		}
		return externalTradeAccountReferenceDataHashMap;
	}

	public static List<ExternalMapping> loadExternalMappings()
	{
		if(externalMappingReferenceDataList == null)
		{
			fetchExternalMappingReferenceData();
		}
		return externalMappingReferenceDataList;
	}

	public static ConcurrentMap<Integer, Account> loadAllActiveAccounts()
	{
		if(accountsReferenceDataHashMap == null)
		{
			fetchAccountsReferenceData();
		}
		return accountsReferenceDataHashMap;
	}

	public static ConcurrentMap<String, IctsUser> loadAllActiveIctsUsers()
	{
		if(ictsUsersReferenceDataHashMap == null)
		{
			fetchIctsUsersReferenceData();
		}
		return ictsUsersReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Country> loadAllActiveCountries()
	{
		if(countriesReferenceDataHashMap == null)
		{
			fetchCountriesReferenceData();
		}
		return countriesReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Commodity> loadAllActiveCommodities()
	{
		if(commoditiesReferenceDataHashMap == null)
		{
			fetchCommoditiesReferenceData();
		}
		return commoditiesReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, Portfolio> loadAllPortfolios()
	{
		if(portfoliosReferenceDataHashMap == null)
		{
			fetchPortfoliosReferenceData();
		}
		return portfoliosReferenceDataHashMap;
	}

	public static ConcurrentMap<Integer, Trade> loadAllTemplateTrades()
	{
		if(templateTradesReferenceDataHashMap == null)
		{
			fetchTemplateTradesReferenceData();
		}
		return templateTradesReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Uom> loadAllActiveUoms()
	{
		if(uomsReferenceDataHashMap == null)
		{
			fetchUomsReferenceData();
		}
		return uomsReferenceDataHashMap;
	}

	public static ConcurrentMap<String, Uom> reloadAllActiveUoms()
	{
		uomsReferenceDataHashMap = null;
		return loadAllActiveUoms();
	}

	public static List<ExternalMapping> reloadExternalMappings()
	{
		externalMappingReferenceDataList = null;
		return loadExternalMappings();
	}

	public static Country getCountryForISOCode(final String isoCode)
	{
		if((isoCountriesReferenceDataHashMap != null) && (isoCode != null))
			return isoCountriesReferenceDataHashMap.get(isoCode);
		return null;
	}

	public static ConcurrentMap<String, Commodity> loadAllActiveCurrencies()
	{
		//return loadAllActiveCommodities().entrySet().stream().collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		//return loadAllActiveCommodities().entrySet().stream().filter(map -> map.getValue().getCommodityType().getCommodityTypeCode().equals("C")).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		return loadAllActiveCommodities().entrySet().stream().filter(map -> map.getValue().getCommodityType().getCommodityTypeCode().equals("C")).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		//return loadAllActiveCommodities().entrySet().stream().collect(Collectors.toConcurrentMap(Function.identity(), key -> function.apply(input.get(key))));
	}

	/**
	 * @param someList
	 * @param someMap
	 */
	@SuppressWarnings("rawtypes")
	private static void doSomeExtraLogginIfNeeded(final List someList, final ConcurrentMap someMap)
	{
		LOGGER.debug("List Count : {}", someList.size());
		LOGGER.debug("List : {}", someList);

		LOGGER.debug("Map Count : {}", someMap.size());
		LOGGER.debug("Map : {}", someMap);
	}

	/**
	 * @param someList
	 */
	@SuppressWarnings("rawtypes")
	private static void doSomeExtraLogginIfNeeded(final List someList)
	{
		LOGGER.debug("List Count : {}", someList.size());
		LOGGER.debug("List : {}", someList);
	}

	private Optional<List<ExternalTradeSource>> ret()
	{
		final List<ExternalTradeSource> externalTradeSourceList = ObjectSelect.query(ExternalTradeSource.class).where(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME.ne("NonDefined")).select(CayenneHelper.getCayenneServerRuntime().newContext());
		return Optional.ofNullable(externalTradeSourceList);
	}
}