package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.PlContract;

/**
 * Class _PlContractTariffAdj was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PlContractTariffAdj extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_REC_ID_PK_COLUMN = "fldchrRecId";

	public static final Property<String> FLDCHR_CMDTY_CODE = new Property<String>("fldchrCmdtyCode");
	public static final Property<String> FLDCHR_DWT_HI_LIMIT_HANDLING_FLAG = new Property<String>("fldchrDwtHiLimitHandlingFlag");
	public static final Property<String> FLDCHR_DWT_LO_LIMIT_HANDLING_FLAG = new Property<String>("fldchrDwtLoLimitHandlingFlag");
	public static final Property<String> FLDCHR_DWT_UMCODE = new Property<String>("fldchrDwtUMCode");
	public static final Property<String> FLDCHR_PLTRML_KEY = new Property<String>("fldchrPLTrmlKey");
	public static final Property<String> FLDCHR_TARIFF_UMCODE = new Property<String>("fldchrTariffUMCode");
	public static final Property<String> FLDCHR_TPUT_HI_LIMIT_HANDLING_FLAG = new Property<String>("fldchrTputHiLimitHandlingFlag");
	public static final Property<String> FLDCHR_TPUT_LO_LIMIT_HANDLING_FLAG = new Property<String>("fldchrTputLoLimitHandlingFlag");
	public static final Property<String> FLDCHR_TPUT_UMCODE = new Property<String>("fldchrTputUMCode");
	public static final Property<BigDecimal> FLDDEC_SPOT_RATE = new Property<BigDecimal>("flddecSpotRate");
	public static final Property<BigDecimal> FLDDEC_TARIFF = new Property<BigDecimal>("flddecTariff");
	public static final Property<Integer> FLDINT_DWT_HI_LIMIT = new Property<Integer>("fldintDwtHiLimit");
	public static final Property<Integer> FLDINT_DWT_LO_LIMIT = new Property<Integer>("fldintDwtLoLimit");
	public static final Property<Integer> FLDINT_TPUT_HI_LIMIT = new Property<Integer>("fldintTputHiLimit");
	public static final Property<Integer> FLDINT_TPUT_LO_LIMIT = new Property<Integer>("fldintTputLoLimit");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Commodity> COMMODITY = new Property<Commodity>("commodity");
	public static final Property<Commodity> COMMODITY1 = new Property<Commodity>("commodity1");
	public static final Property<PlContract> PL_CONTRACT = new Property<PlContract>("plContract");

	public void setFldchrCmdtyCode(String fldchrCmdtyCode)
	{
		writeProperty("fldchrCmdtyCode", fldchrCmdtyCode);
	}

	public String getFldchrCmdtyCode()
	{
		return (String) readProperty("fldchrCmdtyCode");
	}

	public void setFldchrDwtHiLimitHandlingFlag(String fldchrDwtHiLimitHandlingFlag)
	{
		writeProperty("fldchrDwtHiLimitHandlingFlag", fldchrDwtHiLimitHandlingFlag);
	}

	public String getFldchrDwtHiLimitHandlingFlag()
	{
		return (String) readProperty("fldchrDwtHiLimitHandlingFlag");
	}

	public void setFldchrDwtLoLimitHandlingFlag(String fldchrDwtLoLimitHandlingFlag)
	{
		writeProperty("fldchrDwtLoLimitHandlingFlag", fldchrDwtLoLimitHandlingFlag);
	}

	public String getFldchrDwtLoLimitHandlingFlag()
	{
		return (String) readProperty("fldchrDwtLoLimitHandlingFlag");
	}

	public void setFldchrDwtUMCode(String fldchrDwtUMCode)
	{
		writeProperty("fldchrDwtUMCode", fldchrDwtUMCode);
	}

	public String getFldchrDwtUMCode()
	{
		return (String) readProperty("fldchrDwtUMCode");
	}

	public void setFldchrPLTrmlKey(String fldchrPLTrmlKey)
	{
		writeProperty("fldchrPLTrmlKey", fldchrPLTrmlKey);
	}

	public String getFldchrPLTrmlKey()
	{
		return (String) readProperty("fldchrPLTrmlKey");
	}

	public void setFldchrTariffUMCode(String fldchrTariffUMCode)
	{
		writeProperty("fldchrTariffUMCode", fldchrTariffUMCode);
	}

	public String getFldchrTariffUMCode()
	{
		return (String) readProperty("fldchrTariffUMCode");
	}

	public void setFldchrTputHiLimitHandlingFlag(String fldchrTputHiLimitHandlingFlag)
	{
		writeProperty("fldchrTputHiLimitHandlingFlag", fldchrTputHiLimitHandlingFlag);
	}

	public String getFldchrTputHiLimitHandlingFlag()
	{
		return (String) readProperty("fldchrTputHiLimitHandlingFlag");
	}

	public void setFldchrTputLoLimitHandlingFlag(String fldchrTputLoLimitHandlingFlag)
	{
		writeProperty("fldchrTputLoLimitHandlingFlag", fldchrTputLoLimitHandlingFlag);
	}

	public String getFldchrTputLoLimitHandlingFlag()
	{
		return (String) readProperty("fldchrTputLoLimitHandlingFlag");
	}

	public void setFldchrTputUMCode(String fldchrTputUMCode)
	{
		writeProperty("fldchrTputUMCode", fldchrTputUMCode);
	}

	public String getFldchrTputUMCode()
	{
		return (String) readProperty("fldchrTputUMCode");
	}

	public void setFlddecSpotRate(BigDecimal flddecSpotRate)
	{
		writeProperty("flddecSpotRate", flddecSpotRate);
	}

	public BigDecimal getFlddecSpotRate()
	{
		return (BigDecimal) readProperty("flddecSpotRate");
	}

	public void setFlddecTariff(BigDecimal flddecTariff)
	{
		writeProperty("flddecTariff", flddecTariff);
	}

	public BigDecimal getFlddecTariff()
	{
		return (BigDecimal) readProperty("flddecTariff");
	}

	public void setFldintDwtHiLimit(Integer fldintDwtHiLimit)
	{
		writeProperty("fldintDwtHiLimit", fldintDwtHiLimit);
	}

	public Integer getFldintDwtHiLimit()
	{
		return (Integer) readProperty("fldintDwtHiLimit");
	}

	public void setFldintDwtLoLimit(Integer fldintDwtLoLimit)
	{
		writeProperty("fldintDwtLoLimit", fldintDwtLoLimit);
	}

	public Integer getFldintDwtLoLimit()
	{
		return (Integer) readProperty("fldintDwtLoLimit");
	}

	public void setFldintTputHiLimit(Integer fldintTputHiLimit)
	{
		writeProperty("fldintTputHiLimit", fldintTputHiLimit);
	}

	public Integer getFldintTputHiLimit()
	{
		return (Integer) readProperty("fldintTputHiLimit");
	}

	public void setFldintTputLoLimit(Integer fldintTputLoLimit)
	{
		writeProperty("fldintTputLoLimit", fldintTputLoLimit);
	}

	public Integer getFldintTputLoLimit()
	{
		return (Integer) readProperty("fldintTputLoLimit");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setCommodity(Commodity commodity)
	{
		setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) readProperty("commodity");
	}

	public void setCommodity1(Commodity commodity1)
	{
		setToOneTarget("commodity1", commodity1, true);
	}

	public Commodity getCommodity1()
	{
		return (Commodity) readProperty("commodity1");
	}

	public void setPlContract(PlContract plContract)
	{
		setToOneTarget("plContract", plContract, true);
	}

	public PlContract getPlContract()
	{
		return (PlContract) readProperty("plContract");
	}

}
