package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;

/**
 * Class _CostCreditExposure was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostCreditExposure extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<BigDecimal> ASSET_COST_AMOUNT = new Property<BigDecimal>("assetCostAmount");
	public static final Property<String> EXPOSURE_TYPE = new Property<String>("exposureType");
	public static final Property<BigDecimal> LC_ELB_AMOUNT = new Property<BigDecimal>("lcElbAmount");
	public static final Property<BigDecimal> LC_ELD_AMOUNT = new Property<BigDecimal>("lcEldAmount");
	public static final Property<BigDecimal> LC_ELO_AMOUNT = new Property<BigDecimal>("lcEloAmount");
	public static final Property<BigDecimal> LC_ELS_AMOUNT = new Property<BigDecimal>("lcElsAmount");
	public static final Property<BigDecimal> LC_ILB_AMOUNT = new Property<BigDecimal>("lcIlbAmount");
	public static final Property<BigDecimal> LC_ILD_AMOUNT = new Property<BigDecimal>("lcIldAmount");
	public static final Property<BigDecimal> LC_ILO_AMOUNT = new Property<BigDecimal>("lcIloAmount");
	public static final Property<BigDecimal> LC_ILS_AMOUNT = new Property<BigDecimal>("lcIlsAmount");
	public static final Property<BigDecimal> LIB_COST_AMOUNT = new Property<BigDecimal>("libCostAmount");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Account> ACCOUNT = new Property<Account>("account");
	public static final Property<Account> ACCOUNT1 = new Property<Account>("account1");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");

	public void setAssetCostAmount(BigDecimal assetCostAmount)
	{
		writeProperty("assetCostAmount", assetCostAmount);
	}

	public BigDecimal getAssetCostAmount()
	{
		return (BigDecimal) readProperty("assetCostAmount");
	}

	public void setExposureType(String exposureType)
	{
		writeProperty("exposureType", exposureType);
	}

	public String getExposureType()
	{
		return (String) readProperty("exposureType");
	}

	public void setLcElbAmount(BigDecimal lcElbAmount)
	{
		writeProperty("lcElbAmount", lcElbAmount);
	}

	public BigDecimal getLcElbAmount()
	{
		return (BigDecimal) readProperty("lcElbAmount");
	}

	public void setLcEldAmount(BigDecimal lcEldAmount)
	{
		writeProperty("lcEldAmount", lcEldAmount);
	}

	public BigDecimal getLcEldAmount()
	{
		return (BigDecimal) readProperty("lcEldAmount");
	}

	public void setLcEloAmount(BigDecimal lcEloAmount)
	{
		writeProperty("lcEloAmount", lcEloAmount);
	}

	public BigDecimal getLcEloAmount()
	{
		return (BigDecimal) readProperty("lcEloAmount");
	}

	public void setLcElsAmount(BigDecimal lcElsAmount)
	{
		writeProperty("lcElsAmount", lcElsAmount);
	}

	public BigDecimal getLcElsAmount()
	{
		return (BigDecimal) readProperty("lcElsAmount");
	}

	public void setLcIlbAmount(BigDecimal lcIlbAmount)
	{
		writeProperty("lcIlbAmount", lcIlbAmount);
	}

	public BigDecimal getLcIlbAmount()
	{
		return (BigDecimal) readProperty("lcIlbAmount");
	}

	public void setLcIldAmount(BigDecimal lcIldAmount)
	{
		writeProperty("lcIldAmount", lcIldAmount);
	}

	public BigDecimal getLcIldAmount()
	{
		return (BigDecimal) readProperty("lcIldAmount");
	}

	public void setLcIloAmount(BigDecimal lcIloAmount)
	{
		writeProperty("lcIloAmount", lcIloAmount);
	}

	public BigDecimal getLcIloAmount()
	{
		return (BigDecimal) readProperty("lcIloAmount");
	}

	public void setLcIlsAmount(BigDecimal lcIlsAmount)
	{
		writeProperty("lcIlsAmount", lcIlsAmount);
	}

	public BigDecimal getLcIlsAmount()
	{
		return (BigDecimal) readProperty("lcIlsAmount");
	}

	public void setLibCostAmount(BigDecimal libCostAmount)
	{
		writeProperty("libCostAmount", libCostAmount);
	}

	public BigDecimal getLibCostAmount()
	{
		return (BigDecimal) readProperty("libCostAmount");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setAccount(Account account)
	{
		setToOneTarget("account", account, true);
	}

	public Account getAccount()
	{
		return (Account) readProperty("account");
	}

	public void setAccount1(Account account1)
	{
		setToOneTarget("account1", account1, true);
	}

	public Account getAccount1()
	{
		return (Account) readProperty("account1");
	}

	public void setCommodity(Commodity commodity)
	{
		setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) readProperty("commodity");
	}

}
