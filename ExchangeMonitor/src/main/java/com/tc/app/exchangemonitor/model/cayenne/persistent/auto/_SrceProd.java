package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ProdKstProd;

/**
 * Class _SrceProd was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _SrceProd extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String SRCE_PROD_ID_PK_COLUMN = "srce_prod_id";

	public static final Property<Date> CRE_TS = new Property<Date>("creTs");
	public static final Property<String> EXTN_SYS_CD = new Property<String>("extnSysCd");
	public static final Property<Date> MOD_TS = new Property<Date>("modTs");
	public static final Property<String> MOD_USER_CD = new Property<String>("modUserCd");
	public static final Property<Boolean> SRCE_ACTV_FLG = new Property<Boolean>("srceActvFlg");
	public static final Property<String> SRCE_PROD_ABBR = new Property<String>("srceProdAbbr");
	public static final Property<String> SRCE_PROD_CD = new Property<String>("srceProdCd");
	public static final Property<String> SRCE_PROD_NM = new Property<String>("srceProdNm");
	public static final Property<List<ProdKstProd>> PROD_KST_PRODS = new Property<List<ProdKstProd>>("prodKstProds");

	public void setCreTs(Date creTs)
	{
		writeProperty("creTs", creTs);
	}

	public Date getCreTs()
	{
		return (Date) readProperty("creTs");
	}

	public void setExtnSysCd(String extnSysCd)
	{
		writeProperty("extnSysCd", extnSysCd);
	}

	public String getExtnSysCd()
	{
		return (String) readProperty("extnSysCd");
	}

	public void setModTs(Date modTs)
	{
		writeProperty("modTs", modTs);
	}

	public Date getModTs()
	{
		return (Date) readProperty("modTs");
	}

	public void setModUserCd(String modUserCd)
	{
		writeProperty("modUserCd", modUserCd);
	}

	public String getModUserCd()
	{
		return (String) readProperty("modUserCd");
	}

	public void setSrceActvFlg(Boolean srceActvFlg)
	{
		writeProperty("srceActvFlg", srceActvFlg);
	}

	public Boolean getSrceActvFlg()
	{
		return (Boolean) readProperty("srceActvFlg");
	}

	public void setSrceProdAbbr(String srceProdAbbr)
	{
		writeProperty("srceProdAbbr", srceProdAbbr);
	}

	public String getSrceProdAbbr()
	{
		return (String) readProperty("srceProdAbbr");
	}

	public void setSrceProdCd(String srceProdCd)
	{
		writeProperty("srceProdCd", srceProdCd);
	}

	public String getSrceProdCd()
	{
		return (String) readProperty("srceProdCd");
	}

	public void setSrceProdNm(String srceProdNm)
	{
		writeProperty("srceProdNm", srceProdNm);
	}

	public String getSrceProdNm()
	{
		return (String) readProperty("srceProdNm");
	}

	public void addToProdKstProds(ProdKstProd obj)
	{
		addToManyTarget("prodKstProds", obj, true);
	}

	public void removeFromProdKstProds(ProdKstProd obj)
	{
		removeToManyTarget("prodKstProds", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<ProdKstProd> getProdKstProds()
	{
		return (List<ProdKstProd>) readProperty("prodKstProds");
	}

}
