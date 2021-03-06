package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.FxExposure;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FxLinking;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Portfolio;
import com.tc.app.exchangemonitor.model.cayenne.persistent.RiskCover;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Voyage;

/**
 * Class _CostExtInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CostExtInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String COST_NUM_PK_COLUMN = "cost_num";

	public static final Property<String> COST_DESC = new Property<String>("costDesc");
	public static final Property<String> COST_PL_CONTRIBUTION_IND = new Property<String>("costPlContributionInd");
	public static final Property<BigDecimal> CREATION_FX_RATE = new Property<BigDecimal>("creationFxRate");
	public static final Property<String> CREATION_RATE_MDIND = new Property<String>("creationRateMDInd");
	public static final Property<BigDecimal> DISCOUNT_RATE = new Property<BigDecimal>("discountRate");
	public static final Property<String> FX_COMPUTE_IND = new Property<String>("fxComputeInd");
	public static final Property<String> FX_LOCKING_STATUS = new Property<String>("fxLockingStatus");
	public static final Property<Integer> LC_NUM = new Property<Integer>("lcNum");
	public static final Property<String> MANUAL_INPUT_PL_CONTRIB_IND = new Property<String>("manualInputPlContribInd");
	public static final Property<String> MATERIAL_CODE = new Property<String>("materialCode");
	public static final Property<Integer> ORIG_VOUCHER_NUM = new Property<Integer>("origVoucherNum");
	public static final Property<String> PAY_TERM_OVERRIDE_IND = new Property<String>("payTermOverrideInd");
	public static final Property<Integer> PL_CONTRIB_MOD_TRANSID = new Property<Integer>("plContribModTransid");
	public static final Property<Integer> PR_COST_NUM = new Property<Integer>("prCostNum");
	public static final Property<String> PRELIM_TYPE_OVERRIDE_IND = new Property<String>("prelimTypeOverrideInd");
	public static final Property<String> PREPAYMENT_IND = new Property<String>("prepaymentInd");
	public static final Property<Double> QTY_ADJ_FACTOR = new Property<Double>("qtyAdjFactor");
	public static final Property<Integer> QTY_ADJ_RULE_NUM = new Property<Integer>("qtyAdjRuleNum");
	public static final Property<Integer> RELATED_COST_NUM = new Property<Integer>("relatedCostNum");
	public static final Property<BigDecimal> RESERVE_COST_AMT = new Property<BigDecimal>("reserveCostAmt");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<BigDecimal> VAT_RATE = new Property<BigDecimal>("vatRate");
	public static final Property<FxExposure> FX_EXPOSURE = new Property<FxExposure>("fxExposure");
	public static final Property<FxLinking> FX_LINK_O = new Property<FxLinking>("fxLinkO");
	public static final Property<Portfolio> PORTFOLIO = new Property<Portfolio>("portfolio");
	public static final Property<RiskCover> RISK_COVER = new Property<RiskCover>("riskCover");
	public static final Property<Voyage> VOYAGE = new Property<Voyage>("voyage");

	public void setCostDesc(String costDesc)
	{
		writeProperty("costDesc", costDesc);
	}

	public String getCostDesc()
	{
		return (String) readProperty("costDesc");
	}

	public void setCostPlContributionInd(String costPlContributionInd)
	{
		writeProperty("costPlContributionInd", costPlContributionInd);
	}

	public String getCostPlContributionInd()
	{
		return (String) readProperty("costPlContributionInd");
	}

	public void setCreationFxRate(BigDecimal creationFxRate)
	{
		writeProperty("creationFxRate", creationFxRate);
	}

	public BigDecimal getCreationFxRate()
	{
		return (BigDecimal) readProperty("creationFxRate");
	}

	public void setCreationRateMDInd(String creationRateMDInd)
	{
		writeProperty("creationRateMDInd", creationRateMDInd);
	}

	public String getCreationRateMDInd()
	{
		return (String) readProperty("creationRateMDInd");
	}

	public void setDiscountRate(BigDecimal discountRate)
	{
		writeProperty("discountRate", discountRate);
	}

	public BigDecimal getDiscountRate()
	{
		return (BigDecimal) readProperty("discountRate");
	}

	public void setFxComputeInd(String fxComputeInd)
	{
		writeProperty("fxComputeInd", fxComputeInd);
	}

	public String getFxComputeInd()
	{
		return (String) readProperty("fxComputeInd");
	}

	public void setFxLockingStatus(String fxLockingStatus)
	{
		writeProperty("fxLockingStatus", fxLockingStatus);
	}

	public String getFxLockingStatus()
	{
		return (String) readProperty("fxLockingStatus");
	}

	public void setLcNum(Integer lcNum)
	{
		writeProperty("lcNum", lcNum);
	}

	public Integer getLcNum()
	{
		return (Integer) readProperty("lcNum");
	}

	public void setManualInputPlContribInd(String manualInputPlContribInd)
	{
		writeProperty("manualInputPlContribInd", manualInputPlContribInd);
	}

	public String getManualInputPlContribInd()
	{
		return (String) readProperty("manualInputPlContribInd");
	}

	public void setMaterialCode(String materialCode)
	{
		writeProperty("materialCode", materialCode);
	}

	public String getMaterialCode()
	{
		return (String) readProperty("materialCode");
	}

	public void setOrigVoucherNum(Integer origVoucherNum)
	{
		writeProperty("origVoucherNum", origVoucherNum);
	}

	public Integer getOrigVoucherNum()
	{
		return (Integer) readProperty("origVoucherNum");
	}

	public void setPayTermOverrideInd(String payTermOverrideInd)
	{
		writeProperty("payTermOverrideInd", payTermOverrideInd);
	}

	public String getPayTermOverrideInd()
	{
		return (String) readProperty("payTermOverrideInd");
	}

	public void setPlContribModTransid(Integer plContribModTransid)
	{
		writeProperty("plContribModTransid", plContribModTransid);
	}

	public Integer getPlContribModTransid()
	{
		return (Integer) readProperty("plContribModTransid");
	}

	public void setPrCostNum(Integer prCostNum)
	{
		writeProperty("prCostNum", prCostNum);
	}

	public Integer getPrCostNum()
	{
		return (Integer) readProperty("prCostNum");
	}

	public void setPrelimTypeOverrideInd(String prelimTypeOverrideInd)
	{
		writeProperty("prelimTypeOverrideInd", prelimTypeOverrideInd);
	}

	public String getPrelimTypeOverrideInd()
	{
		return (String) readProperty("prelimTypeOverrideInd");
	}

	public void setPrepaymentInd(String prepaymentInd)
	{
		writeProperty("prepaymentInd", prepaymentInd);
	}

	public String getPrepaymentInd()
	{
		return (String) readProperty("prepaymentInd");
	}

	public void setQtyAdjFactor(Double qtyAdjFactor)
	{
		writeProperty("qtyAdjFactor", qtyAdjFactor);
	}

	public Double getQtyAdjFactor()
	{
		return (Double) readProperty("qtyAdjFactor");
	}

	public void setQtyAdjRuleNum(Integer qtyAdjRuleNum)
	{
		writeProperty("qtyAdjRuleNum", qtyAdjRuleNum);
	}

	public Integer getQtyAdjRuleNum()
	{
		return (Integer) readProperty("qtyAdjRuleNum");
	}

	public void setRelatedCostNum(Integer relatedCostNum)
	{
		writeProperty("relatedCostNum", relatedCostNum);
	}

	public Integer getRelatedCostNum()
	{
		return (Integer) readProperty("relatedCostNum");
	}

	public void setReserveCostAmt(BigDecimal reserveCostAmt)
	{
		writeProperty("reserveCostAmt", reserveCostAmt);
	}

	public BigDecimal getReserveCostAmt()
	{
		return (BigDecimal) readProperty("reserveCostAmt");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setVatRate(BigDecimal vatRate)
	{
		writeProperty("vatRate", vatRate);
	}

	public BigDecimal getVatRate()
	{
		return (BigDecimal) readProperty("vatRate");
	}

	public void setFxExposure(FxExposure fxExposure)
	{
		setToOneTarget("fxExposure", fxExposure, true);
	}

	public FxExposure getFxExposure()
	{
		return (FxExposure) readProperty("fxExposure");
	}

	public void setFxLinkO(FxLinking fxLinkO)
	{
		setToOneTarget("fxLinkO", fxLinkO, true);
	}

	public FxLinking getFxLinkO()
	{
		return (FxLinking) readProperty("fxLinkO");
	}

	public void setPortfolio(Portfolio portfolio)
	{
		setToOneTarget("portfolio", portfolio, true);
	}

	public Portfolio getPortfolio()
	{
		return (Portfolio) readProperty("portfolio");
	}

	public void setRiskCover(RiskCover riskCover)
	{
		setToOneTarget("riskCover", riskCover, true);
	}

	public RiskCover getRiskCover()
	{
		return (RiskCover) readProperty("riskCover");
	}

	public void setVoyage(Voyage voyage)
	{
		setToOneTarget("voyage", voyage, true);
	}

	public Voyage getVoyage()
	{
		return (Voyage) readProperty("voyage");
	}

}
