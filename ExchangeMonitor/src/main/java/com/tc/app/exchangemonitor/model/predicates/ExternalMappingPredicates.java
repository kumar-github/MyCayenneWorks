package com.tc.app.exchangemonitor.model.predicates;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;

public class ExternalMappingPredicates
{
	/* An utility Predicate to check whether a given object is NULL. */
	public static final Predicate<ExternalMapping> isNull = Objects::isNull;

	/* An utility Predicate to check whether a given object is NOT NULL. */
	public static final Predicate<ExternalMapping> isNotNull = Objects::nonNull;

	public static final Predicate<ExternalMapping> applyShowAllPredicate = (anExternalMapping) -> {
		return true;
	};

	public static final Predicate<ExternalMapping> applyShowNonePredicate = (anExternalMapping) -> {
		return false;
	};

	/* A Predicate to check whether a given mapping's source is NYMEX. */
	public static final Predicate<ExternalMapping> isNYMEXPredicate = (anExternalMapping) -> {
		//return anExternalMapping.getExternalTradeSourceOid().getOid() == 1;
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("NYMEX");
	};

	/* A Predicate to check whether a given mapping's source is IPE. */
	public static final Predicate<ExternalMapping> isIPEPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("IPE");
	};

	/* A Predicate to check whether a given mapping's source is ICE. */
	public static final Predicate<ExternalMapping> isICEPredicate = (anExternalMapping) -> {
		//return anExternalMapping.getExternalTradeSourceOid().getOid() == 3;
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("ICE");
	};

	/* A Predicate to check whether a given mapping's source is EXCHANGE TOOLS. */
	public static final Predicate<ExternalMapping> isExchangeToolsPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("EXCHANGETOOLS");
	};

	/* A Predicate to check whether a given mapping's source is DASHBOARD. */
	public static final Predicate<ExternalMapping> isDashBoardPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("DASHBOARD");
	};

	/* A Predicate to check whether a given mapping's source is EXCEL. */
	public static final Predicate<ExternalMapping> isExcelPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("EXCEL");
	};

	/* A Predicate to check whether a given mapping's source is DME. */
	public static final Predicate<ExternalMapping> isDMEPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("DME");
	};

	/* A Predicate to check whether a given mapping's source is ECONFIRM. */
	public static final Predicate<ExternalMapping> isECONFIRMPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("ECONFIRM");
	};

	/* A Predicate to check whether a given mapping's source is CEE. */
	public static final Predicate<ExternalMapping> isCEEPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("CEE");
	};

	/* A Predicate to check whether a given mapping's source is OLYMPUS. */
	public static final Predicate<ExternalMapping> isOlympusPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("OLYMPUS");
	};

	/* A Predicate to check whether a given mapping's source is CBT. */
	public static final Predicate<ExternalMapping> isCBTPredicate = (anExternalMapping) -> {
		return anExternalMapping.getExternalTradeSourceO().getExternalTradeSrcName().trim().equals("CBT");
	};

	/* A Predicate to tell whether the given mapping is a TRADER. */
	public static final Predicate<ExternalMapping> isTraderPredicate = (anExternalMapping) -> {
		//return anExternalMapping.getMappingType().equals('T');
		return anExternalMapping.getMappingType().equals("T");
	};

	/* A Predicate to tell whether the given mapping is a BROKER. */
	public static final Predicate<ExternalMapping> isBrokerPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("B");
	};

	/* A Predicate to tell whether the given mapping is a COMPANY. */
	public static final Predicate<ExternalMapping> isCompanyPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("C");
	};

	/* A Predicate to tell whether the given mapping is a CURRENCY. */
	public static final Predicate<ExternalMapping> isCurrencyPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("U");
	};

	/* A Predicate to tell whether the given mapping is a PORTFOLIO. */
	public static final Predicate<ExternalMapping> isPortfolioPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("P");
	};

	/* A Predicate to tell whether the given mapping is a TEMPLATE TRADE. */
	public static final Predicate<ExternalMapping> isTemplateTradePredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("S");
	};

	/* A Predicate to tell whether the given mapping is an ACCOUNT. */
	public static final Predicate<ExternalMapping> isAccountPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("K");
	};

	/* A Predicate to tell whether the given mapping is an UOM CONVERSION. */
	public static final Predicate<ExternalMapping> isUomConversionPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("Q");
	};

	/* A Predicate to tell whether the given mapping is a TRADING PERIOD. */
	public static final Predicate<ExternalMapping> isTradingPeriodPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("O");
	};

	/* A Predicate to tell whether the given mapping is a BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isBookingCompanyPredicate = (anExternalMapping) -> {
		return anExternalMapping.getMappingType().equals("C") && (anExternalMapping.getExternalValue2() != null) && anExternalMapping.getExternalValue2().equals("BOOKING COMPANY");
	};

	//NYMEX
	/* Few utility predicates to test NYMEX related mappings. */
	public static final Predicate<ExternalMapping> isNymexTraderPredicate = isNYMEXPredicate.and(isTraderPredicate);
	public static final Predicate<ExternalMapping> isNymexBrokerPredicate = isNYMEXPredicate.and(isBrokerPredicate);
	public static final Predicate<ExternalMapping> isNymexCompanyPredicate = isNYMEXPredicate.and(isCompanyPredicate);
	public static final Predicate<ExternalMapping> isNymexCurrencyPredicate = isNYMEXPredicate.and(isCurrencyPredicate);
	public static final Predicate<ExternalMapping> isNymexPortfolioPredicate = isNYMEXPredicate.and(isPortfolioPredicate);
	public static final Predicate<ExternalMapping> isNymexTemplateTradePredicate = isNYMEXPredicate.and(isTemplateTradePredicate);
	public static final Predicate<ExternalMapping> isNymexAccountPredicate = isNYMEXPredicate.and(isAccountPredicate);
	public static final Predicate<ExternalMapping> isNymexUomConversionPredicate = isNYMEXPredicate.and(isUomConversionPredicate);
	public static final Predicate<ExternalMapping> isNymexTradingPeriodPredicate = isNYMEXPredicate.and(isTradingPeriodPredicate);
	public static final Predicate<ExternalMapping> isNymexBookingCompanyPredicate = isNYMEXPredicate.and(isBookingCompanyPredicate);

	/* A Predicate to tell whether the given mapping is an IPE BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isIpeBookingCompanyPredicate = isIPEPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isIpeTraderPredicate = isIPEPredicate.and(isTraderPredicate);

	//ICE
	/* Few utility predicates to test ICE related mappings. */
	public static final Predicate<ExternalMapping> isIceTraderPredicate = isICEPredicate.and(isTraderPredicate);
	public static final Predicate<ExternalMapping> isIceBrokerPredicate = isICEPredicate.and(isBrokerPredicate);
	public static final Predicate<ExternalMapping> isIceCompanyPredicate = isICEPredicate.and(isCompanyPredicate);
	public static final Predicate<ExternalMapping> isIceCurrencyPredicate = isICEPredicate.and(isCurrencyPredicate);
	public static final Predicate<ExternalMapping> isIcePortfolioPredicate = isICEPredicate.and(isPortfolioPredicate);
	public static final Predicate<ExternalMapping> isIceTemplateTradePredicate = isICEPredicate.and(isTemplateTradePredicate);
	public static final Predicate<ExternalMapping> isIceAccountPredicate = isICEPredicate.and(isAccountPredicate);
	public static final Predicate<ExternalMapping> isIceUomConversionPredicate = isICEPredicate.and(isUomConversionPredicate);
	public static final Predicate<ExternalMapping> isIceTradingPeriodPredicate = isICEPredicate.and(isTradingPeriodPredicate);
	public static final Predicate<ExternalMapping> isIceBookingCompanyPredicate = isICEPredicate.and(isBookingCompanyPredicate);

	/* A Predicate to tell whether the given mapping is an EXCHANGE TOOLS BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isExchangeToolsBookingCompanyPredicate = isExchangeToolsPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isExchangeToolsTraderPredicate = isExchangeToolsPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a DASHBOARD BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isDashBoardBookingCompanyPredicate = isDashBoardPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isDashBoardTraderPredicate = isDashBoardPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a EXCEL BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isExcelBookingCompanyPredicate = isExcelPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isExcelTraderPredicate = isExcelPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a DME BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isDMEBookingCompanyPredicate = isDMEPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isDMETraderPredicate = isDMEPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a ECONFIRM BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isECONFIRMBookingCompanyPredicate = isECONFIRMPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isECONFIRMTraderPredicate = isECONFIRMPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a CEE BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isCEEBookingCompanyPredicate = isCEEPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isCEETraderPredicate = isCEEPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a OLYMPUS BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isOlympusBookingCompanyPredicate = isOlympusPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isOlympusTraderPredicate = isOlympusPredicate.and(isTraderPredicate);

	/* A Predicate to tell whether the given mapping is a CBT BOOKING COMPANY. */
	public static final Predicate<ExternalMapping> isCBTBookingCompanyPredicate = isCBTPredicate.and(isBookingCompanyPredicate);
	public static final Predicate<ExternalMapping> isCBTTraderPredicate = isCBTPredicate.and(isTraderPredicate);

	/* An utility method to filter a given list of mappings with the given predicate. */
	public static final List<ExternalMapping> filterExternalMappings(final List<ExternalMapping> externalMappings, final Predicate<ExternalMapping> predicate)
	{
		return externalMappings.stream().filter(predicate).collect(Collectors.<ExternalMapping>toList());
	}

	/* An utility method to filter a given list of mappings with the given predicate. */
	public static final List<ExternalMapping> filter(final List<ExternalMapping> externalMappings, final Predicate<ExternalMapping> predicate)
	{
		return externalMappings.stream().filter(predicate).collect(Collectors.<ExternalMapping>toList());
	}

	/* An utility method to return the predicate for a given external trade source.. */
	public static final Predicate<ExternalMapping> getPredicateForExternalTradeSource(final String externalTradeSource)
	{
		final Predicate<ExternalMapping> predicate;
		switch(externalTradeSource)
		{
			case "NYMEX":
				predicate = ExternalMappingPredicates.isNYMEXPredicate;
				break;

			case "IPE":
				predicate = ExternalMappingPredicates.isIPEPredicate;
				break;

			case "ICE":
				predicate = ExternalMappingPredicates.isICEPredicate;
				break;

			case "EXCHANGETOOLS":
				predicate = ExternalMappingPredicates.isExchangeToolsPredicate;
				break;

			case "DASHBOARD":
				predicate = ExternalMappingPredicates.isDashBoardPredicate;
				break;

			case "EXCEL":
				predicate = ExternalMappingPredicates.isExcelPredicate;
				break;

			case "DME":
				predicate = ExternalMappingPredicates.isDMEPredicate;
				break;

			case "ECONFIRM":
				predicate = ExternalMappingPredicates.isECONFIRMPredicate;
				break;

			case "CEE":
				predicate = ExternalMappingPredicates.isCEEPredicate;
				break;

			case "OLYMPUS":
				predicate = ExternalMappingPredicates.isOlympusPredicate;
				break;

			case "CBT":
				predicate = ExternalMappingPredicates.isCBTPredicate;
				break;

			default:
				predicate = null;
				break;
		}
		return predicate;
	}

	/*
	 Predicate<BBTeam> nonNullPredicate = Objects::nonNull;
	 Predicate<BBTeam> nameNotNull = p -> p.teamName != null;
	 Predicate<BBTeam> teamWIPredicate = p -> p.teamName.equals("Wisconsin");
	 Predicate<BBTeam> fullPredicate = nonNullPredicate.and(nameNotNull).and(teamWIPredicate);
	 List<BBTeam> teams2 = teams.stream().filter(fullPredicate).collect(Collectors.toList());
	 */
}