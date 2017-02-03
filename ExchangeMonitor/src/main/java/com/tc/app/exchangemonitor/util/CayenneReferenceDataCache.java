package com.tc.app.exchangemonitor.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

public class CayenneReferenceDataCache
{
	//private static final Logger LOGGER = LogManager.getLogger(CayenneReferenceDataCache.class);
	/* In Log4j2, passing class name for getLogger() is optional. So the below is equal to the above. */
	private static final Logger LOGGER = LogManager.getLogger();

	public static void fetchAllReferenceData()
	{
		fetchExternalTradeSourceReferenceData();
		fetchExternalTradeStateReferenceData();
		fetchExternalTradeStatusReferenceData();
		fetchExternalTradeAccountReferenceData();
		fetchExternalMappingReferenceData();

		fetchAccountsReferenceData();
		fetchIctsUsersReferenceData();
		fetchCountriesReferenceData();
		fetchCommoditiesReferenceData();
		fetchPortfoliosReferenceData();
		fetchTemplateTradesReferenceData();
		fetchUomsReferenceData();

		/* The below is not needed since we already loaded all the commodities and a currency is nothing but a commodity of type "C".
		 * But still we are doing because we want to maintain a  seperate map for currencies which we use it directly at some situations instead of getting the commodities map and filtering it.
		 * Also believing that the previuos fetch for commodities will be in the cache, hence this won't affect the performance much.
		 */
		//fetchCurrenciesReferenceData();
	}

	/* Do we really need a map here? Think again... */
	//private static ConcurrentMap<String, ExternalTradeSource> externalTradeSourceReferenceDataHashMap = null;
	private static Map<String, ExternalTradeSource> externalTradeSourceReferenceDataHashMap = null;
	private static void fetchExternalTradeSourceReferenceData()
	{
		try
		{
			if(externalTradeSourceReferenceDataHashMap == null)
			{
				//externalTradeSourceReferenceDataHashMap = new ConcurrentHashMap<>();
				externalTradeSourceReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();

				final List<ExternalTradeSource> externalTradeSourceList = ObjectSelect.query(ExternalTradeSource.class).where(ExternalTradeSource.EXTERNAL_TRADE_SRC_NAME.ne("NonDefined")).select(CayenneHelper.getCayenneServerRuntime().newContext());

				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} external trade sources.", (endTime - startTime), externalTradeSourceList.size());

				//externalTradeSourceReferenceDataHashMap = externalTradeSourceList.stream().collect(Collectors.toConcurrentMap(theExternalTradeSource -> theExternalTradeSource.getExternalTradeSourceOid(), theExternalTradeSource -> theExternalTradeSource));
				//externalTradeSourceReferenceDataHashMap = externalTradeSourceList.stream().collect(Collectors.toConcurrentMap(ExternalTradeSource::getExternalTradeSrcName, theExternalTradeSource -> theExternalTradeSource));
				externalTradeSourceReferenceDataHashMap = externalTradeSourceList.stream().collect(Collectors.toMap(ExternalTradeSource::getExternalTradeSrcName, Function.identity(), (theExistingExternalTradeSource, theNewExternalTradeSource) -> theNewExternalTradeSource, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData External Trade Source.", exception);
			throw exception;
		}
	}

	private static Map<Integer, ExternalTradeState> externalTradeStateReferenceDataHashMap = null;
	private static void fetchExternalTradeStateReferenceData()
	{
		try
		{
			if(externalTradeStateReferenceDataHashMap == null)
			{
				externalTradeStateReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<ExternalTradeState> externalTradeStateList = ObjectSelect.query(ExternalTradeState.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} external trade states.", (endTime - startTime), externalTradeStateList.size());

				externalTradeStateReferenceDataHashMap = externalTradeStateList.stream().collect(Collectors.toMap(ExternalTradeState::getExternalTradeStateOid, theExternalTradeState -> theExternalTradeState, (theExistingExternalTradeState, theNewExternalTradeState) -> theNewExternalTradeState, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData External Trade State.", exception);
			throw exception;
		}
	}

	private static Map<Integer, ExternalTradeStatus> externalTradeStatusReferenceDataHashMap = null;
	private static void fetchExternalTradeStatusReferenceData()
	{
		try
		{
			if(externalTradeStatusReferenceDataHashMap == null)
			{
				externalTradeStatusReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<ExternalTradeStatus> externalTradeStatusList = ObjectSelect.query(ExternalTradeStatus.class).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} external trade statuses.", (endTime - startTime), externalTradeStatusList.size());

				externalTradeStatusReferenceDataHashMap = externalTradeStatusList.stream().collect(Collectors.toMap(ExternalTradeStatus::getExternalTradeStatusOid, theExternalTradeStatus -> theExternalTradeStatus, (theExistingExternalTradeStatus, theNewExternalTradeStatus) -> theNewExternalTradeStatus, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData External Trade Status.", exception);
			throw exception;
		}
	}

	private static Map<String, ExternalMapping> externalTradeAccountReferenceDataHashMap = null;
	private static void fetchExternalTradeAccountReferenceData()
	{
		try
		{
			if(externalTradeAccountReferenceDataHashMap == null)
			{
				externalTradeAccountReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<ExternalMapping> externalTradeAccountList = ObjectSelect.query(ExternalMapping.class).where(ExternalMapping.MAPPING_TYPE.eq("K")).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} external trade accounts.", (endTime - startTime), externalTradeAccountList.size());

				//externalTradeAccountReferenceDataHashMap = externalTradeAccountList.stream().collect(Collectors.toConcurrentMap(ExternalMapping::getExternalValue1, theExternalMapping -> theExternalMapping));
				externalTradeAccountReferenceDataHashMap = externalTradeAccountList.stream().collect(Collectors.toMap(ExternalMapping::getExternalValue1, theExternalMapping -> theExternalMapping, (theExistingMapping, theNewMapping) -> theExistingMapping, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData External Trade.", exception);
			throw exception;
		}
	}

	private static List<ExternalMapping> externalMappingReferenceDataList = null;
	private static void fetchExternalMappingReferenceData()
	{
		try
		{
			if(externalMappingReferenceDataList == null)
			{
				externalMappingReferenceDataList = new ArrayList<>();

				final long startTime = System.currentTimeMillis();
				externalMappingReferenceDataList = ObjectSelect.query(ExternalMapping.class).prefetch(ExternalMapping.EXTERNAL_TRADE_SOURCE_O.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} external mappings.", (endTime - startTime), externalMappingReferenceDataList.size());
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData External Mapping.", exception);
			throw exception;
		}
	}

	private static Map<Integer, Account> accountsReferenceDataHashMap = null;
	private static void fetchAccountsReferenceData()
	{
		try
		{
			if(accountsReferenceDataHashMap == null)
			{
				accountsReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<Account> accountList = ObjectSelect.query(Account.class).where(Account.ACCT_STATUS.eq("A")).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} accounts.", (endTime - startTime), accountList.size());

				accountsReferenceDataHashMap = accountList.stream().collect(Collectors.toMap(Account::getAccountNum, theAccount -> theAccount, (theExistingAccount, theNewAccount) -> theNewAccount, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData Account.", exception);
			throw exception;
		}
	}

	private static Map<String, IctsUser> ictsUsersReferenceDataHashMap = null;
	private static void fetchIctsUsersReferenceData()
	{
		try
		{
			if(ictsUsersReferenceDataHashMap == null)
			{
				ictsUsersReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<IctsUser> ictsUsersList = ObjectSelect.query(IctsUser.class).where(IctsUser.USER_STATUS.eq("A")).prefetch(IctsUser.USER_JOB_TITLE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} icts users.", (endTime - startTime), ictsUsersList.size());

				ictsUsersReferenceDataHashMap = ictsUsersList.stream().collect(Collectors.toMap(IctsUser::getUserInit, theIctsUser -> theIctsUser, (theExistingIctsUser, theNewIctsUser) -> theNewIctsUser, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData IctsUser.", exception);
			throw exception;
		}
	}

	private static Map<String, Country> countriesReferenceDataHashMap = null;
	private static Map<String, Country> isoCountriesReferenceDataHashMap = null;

	//private static Map<String, Country> countriesReferenceDataHashMapWithCountryName = null;
	private static void fetchCountriesReferenceData()
	{
		try
		{
			if(countriesReferenceDataHashMap == null)
			{
				countriesReferenceDataHashMap = new HashMap<>();
				isoCountriesReferenceDataHashMap = new HashMap<>();
				//countriesReferenceDataHashMapWithCountryName = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<Country> countriesList = ObjectSelect.query(Country.class).where(Country.COUNTRY_STATUS.eq("A")).and(Country.ISO_COUNTRY_CODE.isNotNull()).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} countries.", (endTime - startTime), countriesList.size());

				countriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toMap(Country::getCountryCode, theCountry -> theCountry, (theExistingCountry, theNewCountry) -> theNewCountry, LinkedHashMap::new));

				//isoCountriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toConcurrentMap(Country::getIsoCountryCode, theCountry -> theCountry));
				isoCountriesReferenceDataHashMap = countriesList.stream().collect(Collectors.toMap(Country::getIsoCountryCode, theCountry -> theCountry, (theExistingCountry, theNewCountry) -> theNewCountry, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData Country.", exception);
			throw exception;
		}
	}

	private static Map<String, Commodity> commoditiesReferenceDataHashMap = null;
	private static void fetchCommoditiesReferenceData()
	{
		try
		{
			if(commoditiesReferenceDataHashMap == null)
			{
				commoditiesReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				//final List<Commodity> commoditiesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final List<Commodity> commoditiesList = ObjectSelect.query(Commodity.class).where(Commodity.CMDTY_STATUS.eq("A")).prefetch(Commodity.COMMODITY_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} commodities.", (endTime - startTime), commoditiesList.size());

				commoditiesReferenceDataHashMap = commoditiesList.stream().collect(Collectors.toMap(Commodity::getCmdtyCode, theCommodity -> theCommodity, (theExistingCommodity, theNewCommodity) -> theNewCommodity, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData Commodity.", exception);
			throw exception;
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
			LOGGER.debug("It took {} milli seconds to fetch {} currencies.", (endTime - startTime), currenciesList.size());

			currenciesReferenceDataHashMap = currenciesList.stream().collect(Collectors.toConcurrentMap(Commodity::getCmdtyCode, theCommodity -> theCommodity));

			if(IS_DEBUG_ENABLED)
			{
				doSomeExtraLogginIfNeeded(currenciesList, currenciesReferenceDataHashMap);
			}
		}
	}
	 */

	private static Map<Integer, Portfolio> portfoliosReferenceDataHashMap = null;
	private static void fetchPortfoliosReferenceData()
	{
		try
		{
			if(portfoliosReferenceDataHashMap == null)
			{
				portfoliosReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();

				//@formatter:off
				final List<Portfolio> portfoliosList = ObjectSelect.query(Portfolio.class)
																													 .where(Portfolio.PORT_LOCKED.eq((short) 0))
																													 .and(Portfolio.PORT_TYPE.eq("R"))
																													 .select(CayenneHelper.getCayenneServerRuntime().newContext());
				//@formatter:on

				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} portfolios.", (endTime - startTime), portfoliosList.size());

				portfoliosReferenceDataHashMap = portfoliosList.stream().collect(Collectors.toMap(Portfolio::getPortNum, thePortfolio -> thePortfolio, (theExistingPortfolio, theNewPortfolio) -> theNewPortfolio, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData Portfolio.", exception);
			throw exception;
		}
	}

	private static Map<Integer, Trade> templateTradesReferenceDataHashMap = null;
	private static void fetchTemplateTradesReferenceData()
	{
		try
		{
			if(templateTradesReferenceDataHashMap == null)
			{
				templateTradesReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();

				//@formatter:off
				/* Actually we need to filter even the deleted trades but dont know how to do. We can go for query method to fetch the required trades. But leaving it for now. */
				final List<Trade> templateTradesList = ObjectSelect.query(Trade.class)
																														  .where(Trade.CONCLUSION_TYPE.eq("I"))
																														  .prefetch(Trade.TRADE_STATUS.joint())
																														  .select(CayenneHelper.getCayenneServerRuntime().newContext());
				//@formatter:on
				final List<Trade> undeletedTemplateTradesList = templateTradesList.stream().filter((aTrade) -> !aTrade.getTradeStatus().getTradeStatusCode().trim().equals("DELETE")).collect(Collectors.toList());

				//final EJBQLQuery queryToFetchTradeNums = new EJBQLQuery("select trade.trade_num FROM Trade trade where trade.copyType <> 'FULL'");
				//final List<String> tradeNums = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(queryToFetchTradeNums);
				//tradeNums.forEach(System.out::println);
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} template trades.", (endTime - startTime), templateTradesList.size());

				//templateTradesReferenceDataHashMap = templateTradesList.stream().collect(Collectors.toConcurrentMap(Trade::getTradeNum, theTrade -> theTrade));
				templateTradesReferenceDataHashMap = undeletedTemplateTradesList.stream().collect(Collectors.toMap(Trade::getTradeNum, theTrade -> theTrade, (theExistingTrade, theNewTrade) -> theNewTrade, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData Template Trade.", exception);
			throw exception;
		}
	}

	private static Map<String, Uom> uomsReferenceDataHashMap = null;
	private static void fetchUomsReferenceData()
	{
		try
		{
			if(uomsReferenceDataHashMap == null)
			{
				uomsReferenceDataHashMap = new HashMap<>();

				final long startTime = System.currentTimeMillis();
				final List<Uom> uomsList = ObjectSelect.query(Uom.class).where(Uom.UOM_STATUS.eq("A")).select(CayenneHelper.getCayenneServerRuntime().newContext());
				final long endTime = System.currentTimeMillis();
				LOGGER.debug("It took {} milli seconds to fetch {} uoms.", (endTime - startTime), uomsList.size());

				uomsReferenceDataHashMap = uomsList.stream().collect(Collectors.toMap(Uom::getUomCode, theUom -> theUom, (theExistingUom, theNewUom) -> theNewUom, LinkedHashMap::new));
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Error Loading ReferenceData UOM.", exception);
			throw exception;
		}
	}

	//public static ConcurrentMap<String, ExternalTradeSource> loadExternalTradeSources()
	public static Map<String, ExternalTradeSource> loadExternalTradeSources()
	{
		if(externalTradeSourceReferenceDataHashMap == null)
		{
			fetchExternalTradeSourceReferenceData();
		}
		return externalTradeSourceReferenceDataHashMap;
	}

	public static Map<Integer, ExternalTradeState> loadExternalTradeStates()
	{
		if(externalTradeStateReferenceDataHashMap == null)
		{
			fetchExternalTradeStateReferenceData();
		}
		return externalTradeStateReferenceDataHashMap;
	}

	public static Map<Integer, ExternalTradeStatus> loadExternalTradeStatuses()
	{
		if(externalTradeStatusReferenceDataHashMap == null)
		{
			fetchExternalTradeStatusReferenceData();
		}
		return externalTradeStatusReferenceDataHashMap;
	}

	public static Map<String, ExternalMapping> loadExternalTradeAccounts()
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

	public static Map<Integer, Account> loadAllActiveAccounts()
	{
		if(accountsReferenceDataHashMap == null)
		{
			fetchAccountsReferenceData();
		}
		return accountsReferenceDataHashMap;
	}

	public static Map<String, IctsUser> loadAllActiveIctsUsers()
	{
		if(ictsUsersReferenceDataHashMap == null)
		{
			fetchIctsUsersReferenceData();
		}
		return ictsUsersReferenceDataHashMap;
	}

	public static Map<String, Country> loadAllActiveCountries()
	{
		if(countriesReferenceDataHashMap == null)
		{
			fetchCountriesReferenceData();
		}
		return countriesReferenceDataHashMap;
	}

	public static Map<String, Commodity> loadAllActiveCommodities()
	{
		if(commoditiesReferenceDataHashMap == null)
		{
			fetchCommoditiesReferenceData();
		}
		return commoditiesReferenceDataHashMap;
	}

	public static Map<Integer, Portfolio> loadAllPortfolios()
	{
		if(portfoliosReferenceDataHashMap == null)
		{
			fetchPortfoliosReferenceData();
		}
		return portfoliosReferenceDataHashMap;
	}

	public static Map<Integer, Trade> loadAllTemplateTrades()
	{
		if(templateTradesReferenceDataHashMap == null)
		{
			fetchTemplateTradesReferenceData();
		}
		return templateTradesReferenceDataHashMap;
	}

	public static Map<String, Uom> loadAllActiveUoms()
	{
		if(uomsReferenceDataHashMap == null)
		{
			fetchUomsReferenceData();
		}
		return uomsReferenceDataHashMap;
	}

	public static Map<String, Uom> reloadAllActiveUoms()
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

	public static Map<String, Commodity> loadAllActiveCurrencies()
	{
		//return loadAllActiveCommodities().entrySet().stream().collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		//return loadAllActiveCommodities().entrySet().stream().filter(map -> map.getValue().getCommodityType().getCommodityTypeCode().equals("C")).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		return loadAllActiveCommodities().entrySet().stream().filter(map -> map.getValue().getCommodityType().getCommodityTypeCode().equals("C")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		//return loadAllActiveCommodities().entrySet().stream().collect(Collectors.toConcurrentMap(Function.identity(), key -> function.apply(input.get(key))));
	}
}