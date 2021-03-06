package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Ba;
import com.tc.app.exchangemonitor.model.cayenne.persistent.SrceBa;

/**
 * Class _BaKstBa was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _BaKstBa extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String EFF_DT_PK_COLUMN = "eff_dt";
	public static final String SRCE_BA_ID_PK_COLUMN = "srce_ba_id";

	public static final Property<Date> EXPR_DT = new Property<Date>("exprDt");
	public static final Property<Date> MOD_TS = new Property<Date>("modTs");
	public static final Property<String> MOD_USER_CD = new Property<String>("modUserCd");
	public static final Property<Ba> BA = new Property<Ba>("ba");
	public static final Property<SrceBa> SRCE_BA = new Property<SrceBa>("srceBa");

	public void setExprDt(Date exprDt)
	{
		writeProperty("exprDt", exprDt);
	}

	public Date getExprDt()
	{
		return (Date) readProperty("exprDt");
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

	public void setBa(Ba ba)
	{
		setToOneTarget("ba", ba, true);
	}

	public Ba getBa()
	{
		return (Ba) readProperty("ba");
	}

	public void setSrceBa(SrceBa srceBa)
	{
		setToOneTarget("srceBa", srceBa, true);
	}

	public SrceBa getSrceBa()
	{
		return (SrceBa) readProperty("srceBa");
	}

}
