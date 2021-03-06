package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Country;

/**
 * Class _CountryExposure was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CountryExposure extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String COUNTRY_CODE_PK_COLUMN = "country_code";

	public static final Property<Double> COUNTRY_EXP_GROSS_AMT = new Property<Double>("countryExpGrossAmt");
	public static final Property<Double> COUNTRY_EXP_LOSS_AMT = new Property<Double>("countryExpLossAmt");
	public static final Property<Double> COUNTRY_EXP_LOSS_QTY = new Property<Double>("countryExpLossQty");
	public static final Property<Double> COUNTRY_EXP_PAY_AMT = new Property<Double>("countryExpPayAmt");
	public static final Property<Double> COUNTRY_EXP_PROFIT_AMT = new Property<Double>("countryExpProfitAmt");
	public static final Property<Double> COUNTRY_EXP_PROFIT_QTY = new Property<Double>("countryExpProfitQty");
	public static final Property<Double> COUNTRY_EXP_RECV_AMT = new Property<Double>("countryExpRecvAmt");
	public static final Property<Double> COUNTRY_FLW_PAY_AMT = new Property<Double>("countryFlwPayAmt");
	public static final Property<Double> COUNTRY_FLW_REC_AMT = new Property<Double>("countryFlwRecAmt");
	public static final Property<Double> COUNTRY_REXP_GROSS_AMT = new Property<Double>("countryRexpGrossAmt");
	public static final Property<Double> COUNTRY_REXP_LOSS_AMT = new Property<Double>("countryRexpLossAmt");
	public static final Property<Double> COUNTRY_REXP_LOSS_QTY = new Property<Double>("countryRexpLossQty");
	public static final Property<Double> COUNTRY_REXP_PAY_AMT = new Property<Double>("countryRexpPayAmt");
	public static final Property<Double> COUNTRY_REXP_PROFIT_AMT = new Property<Double>("countryRexpProfitAmt");
	public static final Property<Double> COUNTRY_REXP_PROFIT_QTY = new Property<Double>("countryRexpProfitQty");
	public static final Property<Double> COUNTRY_REXP_RECV_AMT = new Property<Double>("countryRexpRecvAmt");
	public static final Property<Double> COUNTRY_RFLW_PAY_AMT = new Property<Double>("countryRflwPayAmt");
	public static final Property<Double> COUNTRY_RFLW_REC_AMT = new Property<Double>("countryRflwRecAmt");
	public static final Property<Double> COUNTRY_SEXP_GROSS_AMT = new Property<Double>("countrySexpGrossAmt");
	public static final Property<Double> COUNTRY_SEXP_LOSS_AMT = new Property<Double>("countrySexpLossAmt");
	public static final Property<Double> COUNTRY_SEXP_LOSS_QTY = new Property<Double>("countrySexpLossQty");
	public static final Property<Double> COUNTRY_SEXP_PAY_AMT = new Property<Double>("countrySexpPayAmt");
	public static final Property<Double> COUNTRY_SEXP_PROFIT_AMT = new Property<Double>("countrySexpProfitAmt");
	public static final Property<Double> COUNTRY_SEXP_PROFIT_QTY = new Property<Double>("countrySexpProfitQty");
	public static final Property<Double> COUNTRY_SEXP_RECV_AMT = new Property<Double>("countrySexpRecvAmt");
	public static final Property<Double> COUNTRY_SFLW_PAY_AMT = new Property<Double>("countrySflwPayAmt");
	public static final Property<Double> COUNTRY_SFLW_REC_AMT = new Property<Double>("countrySflwRecAmt");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Country> COUNTRY = new Property<Country>("country");

	public void setCountryExpGrossAmt(Double countryExpGrossAmt)
	{
		writeProperty("countryExpGrossAmt", countryExpGrossAmt);
	}

	public Double getCountryExpGrossAmt()
	{
		return (Double) readProperty("countryExpGrossAmt");
	}

	public void setCountryExpLossAmt(Double countryExpLossAmt)
	{
		writeProperty("countryExpLossAmt", countryExpLossAmt);
	}

	public Double getCountryExpLossAmt()
	{
		return (Double) readProperty("countryExpLossAmt");
	}

	public void setCountryExpLossQty(Double countryExpLossQty)
	{
		writeProperty("countryExpLossQty", countryExpLossQty);
	}

	public Double getCountryExpLossQty()
	{
		return (Double) readProperty("countryExpLossQty");
	}

	public void setCountryExpPayAmt(Double countryExpPayAmt)
	{
		writeProperty("countryExpPayAmt", countryExpPayAmt);
	}

	public Double getCountryExpPayAmt()
	{
		return (Double) readProperty("countryExpPayAmt");
	}

	public void setCountryExpProfitAmt(Double countryExpProfitAmt)
	{
		writeProperty("countryExpProfitAmt", countryExpProfitAmt);
	}

	public Double getCountryExpProfitAmt()
	{
		return (Double) readProperty("countryExpProfitAmt");
	}

	public void setCountryExpProfitQty(Double countryExpProfitQty)
	{
		writeProperty("countryExpProfitQty", countryExpProfitQty);
	}

	public Double getCountryExpProfitQty()
	{
		return (Double) readProperty("countryExpProfitQty");
	}

	public void setCountryExpRecvAmt(Double countryExpRecvAmt)
	{
		writeProperty("countryExpRecvAmt", countryExpRecvAmt);
	}

	public Double getCountryExpRecvAmt()
	{
		return (Double) readProperty("countryExpRecvAmt");
	}

	public void setCountryFlwPayAmt(Double countryFlwPayAmt)
	{
		writeProperty("countryFlwPayAmt", countryFlwPayAmt);
	}

	public Double getCountryFlwPayAmt()
	{
		return (Double) readProperty("countryFlwPayAmt");
	}

	public void setCountryFlwRecAmt(Double countryFlwRecAmt)
	{
		writeProperty("countryFlwRecAmt", countryFlwRecAmt);
	}

	public Double getCountryFlwRecAmt()
	{
		return (Double) readProperty("countryFlwRecAmt");
	}

	public void setCountryRexpGrossAmt(Double countryRexpGrossAmt)
	{
		writeProperty("countryRexpGrossAmt", countryRexpGrossAmt);
	}

	public Double getCountryRexpGrossAmt()
	{
		return (Double) readProperty("countryRexpGrossAmt");
	}

	public void setCountryRexpLossAmt(Double countryRexpLossAmt)
	{
		writeProperty("countryRexpLossAmt", countryRexpLossAmt);
	}

	public Double getCountryRexpLossAmt()
	{
		return (Double) readProperty("countryRexpLossAmt");
	}

	public void setCountryRexpLossQty(Double countryRexpLossQty)
	{
		writeProperty("countryRexpLossQty", countryRexpLossQty);
	}

	public Double getCountryRexpLossQty()
	{
		return (Double) readProperty("countryRexpLossQty");
	}

	public void setCountryRexpPayAmt(Double countryRexpPayAmt)
	{
		writeProperty("countryRexpPayAmt", countryRexpPayAmt);
	}

	public Double getCountryRexpPayAmt()
	{
		return (Double) readProperty("countryRexpPayAmt");
	}

	public void setCountryRexpProfitAmt(Double countryRexpProfitAmt)
	{
		writeProperty("countryRexpProfitAmt", countryRexpProfitAmt);
	}

	public Double getCountryRexpProfitAmt()
	{
		return (Double) readProperty("countryRexpProfitAmt");
	}

	public void setCountryRexpProfitQty(Double countryRexpProfitQty)
	{
		writeProperty("countryRexpProfitQty", countryRexpProfitQty);
	}

	public Double getCountryRexpProfitQty()
	{
		return (Double) readProperty("countryRexpProfitQty");
	}

	public void setCountryRexpRecvAmt(Double countryRexpRecvAmt)
	{
		writeProperty("countryRexpRecvAmt", countryRexpRecvAmt);
	}

	public Double getCountryRexpRecvAmt()
	{
		return (Double) readProperty("countryRexpRecvAmt");
	}

	public void setCountryRflwPayAmt(Double countryRflwPayAmt)
	{
		writeProperty("countryRflwPayAmt", countryRflwPayAmt);
	}

	public Double getCountryRflwPayAmt()
	{
		return (Double) readProperty("countryRflwPayAmt");
	}

	public void setCountryRflwRecAmt(Double countryRflwRecAmt)
	{
		writeProperty("countryRflwRecAmt", countryRflwRecAmt);
	}

	public Double getCountryRflwRecAmt()
	{
		return (Double) readProperty("countryRflwRecAmt");
	}

	public void setCountrySexpGrossAmt(Double countrySexpGrossAmt)
	{
		writeProperty("countrySexpGrossAmt", countrySexpGrossAmt);
	}

	public Double getCountrySexpGrossAmt()
	{
		return (Double) readProperty("countrySexpGrossAmt");
	}

	public void setCountrySexpLossAmt(Double countrySexpLossAmt)
	{
		writeProperty("countrySexpLossAmt", countrySexpLossAmt);
	}

	public Double getCountrySexpLossAmt()
	{
		return (Double) readProperty("countrySexpLossAmt");
	}

	public void setCountrySexpLossQty(Double countrySexpLossQty)
	{
		writeProperty("countrySexpLossQty", countrySexpLossQty);
	}

	public Double getCountrySexpLossQty()
	{
		return (Double) readProperty("countrySexpLossQty");
	}

	public void setCountrySexpPayAmt(Double countrySexpPayAmt)
	{
		writeProperty("countrySexpPayAmt", countrySexpPayAmt);
	}

	public Double getCountrySexpPayAmt()
	{
		return (Double) readProperty("countrySexpPayAmt");
	}

	public void setCountrySexpProfitAmt(Double countrySexpProfitAmt)
	{
		writeProperty("countrySexpProfitAmt", countrySexpProfitAmt);
	}

	public Double getCountrySexpProfitAmt()
	{
		return (Double) readProperty("countrySexpProfitAmt");
	}

	public void setCountrySexpProfitQty(Double countrySexpProfitQty)
	{
		writeProperty("countrySexpProfitQty", countrySexpProfitQty);
	}

	public Double getCountrySexpProfitQty()
	{
		return (Double) readProperty("countrySexpProfitQty");
	}

	public void setCountrySexpRecvAmt(Double countrySexpRecvAmt)
	{
		writeProperty("countrySexpRecvAmt", countrySexpRecvAmt);
	}

	public Double getCountrySexpRecvAmt()
	{
		return (Double) readProperty("countrySexpRecvAmt");
	}

	public void setCountrySflwPayAmt(Double countrySflwPayAmt)
	{
		writeProperty("countrySflwPayAmt", countrySflwPayAmt);
	}

	public Double getCountrySflwPayAmt()
	{
		return (Double) readProperty("countrySflwPayAmt");
	}

	public void setCountrySflwRecAmt(Double countrySflwRecAmt)
	{
		writeProperty("countrySflwRecAmt", countrySflwRecAmt);
	}

	public Double getCountrySflwRecAmt()
	{
		return (Double) readProperty("countrySflwRecAmt");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCountry(Country country)
	{
		setToOneTarget("country", country, true);
	}

	public Country getCountry()
	{
		return (Country) readProperty("country");
	}

}
