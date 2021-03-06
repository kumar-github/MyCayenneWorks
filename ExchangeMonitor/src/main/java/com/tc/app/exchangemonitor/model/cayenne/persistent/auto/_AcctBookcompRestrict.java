package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AcctBookcomp;
import com.tc.app.exchangemonitor.model.cayenne.persistent.OrderTypeGrpDesc;
import com.tc.app.exchangemonitor.model.cayenne.persistent.TradeTenor;

/**
 * Class _AcctBookcompRestrict was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AcctBookcompRestrict extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ACCT_RESTRICTION_NUM_PK_COLUMN = "acct_restriction_num";

	public static final Property<Boolean> ALLOWS_BOOKOUT = new Property<Boolean>("allowsBookout");
	public static final Property<Boolean> ALLOWS_NETOUT = new Property<Boolean>("allowsNetout");
	public static final Property<String> NOBUY_RESTRICTION_IND = new Property<String>("nobuyRestrictionInd");
	public static final Property<String> NOSELL_RESTRICTION_IND = new Property<String>("nosellRestrictionInd");
	public static final Property<Date> RESTRICTION_EFF_DATE = new Property<Date>("restrictionEffDate");
	public static final Property<Date> RESTRICTION_END_DATE = new Property<Date>("restrictionEndDate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<AcctBookcomp> ACCT_BOOKCOMP = new Property<AcctBookcomp>("acctBookcomp");
	public static final Property<OrderTypeGrpDesc> ORDER_TYPE_GRP_DESC = new Property<OrderTypeGrpDesc>("orderTypeGrpDesc");
	public static final Property<TradeTenor> TRADE_TENOR = new Property<TradeTenor>("tradeTenor");

	public void setAllowsBookout(Boolean allowsBookout)
	{
		writeProperty("allowsBookout", allowsBookout);
	}

	public Boolean getAllowsBookout()
	{
		return (Boolean) readProperty("allowsBookout");
	}

	public void setAllowsNetout(Boolean allowsNetout)
	{
		writeProperty("allowsNetout", allowsNetout);
	}

	public Boolean getAllowsNetout()
	{
		return (Boolean) readProperty("allowsNetout");
	}

	public void setNobuyRestrictionInd(String nobuyRestrictionInd)
	{
		writeProperty("nobuyRestrictionInd", nobuyRestrictionInd);
	}

	public String getNobuyRestrictionInd()
	{
		return (String) readProperty("nobuyRestrictionInd");
	}

	public void setNosellRestrictionInd(String nosellRestrictionInd)
	{
		writeProperty("nosellRestrictionInd", nosellRestrictionInd);
	}

	public String getNosellRestrictionInd()
	{
		return (String) readProperty("nosellRestrictionInd");
	}

	public void setRestrictionEffDate(Date restrictionEffDate)
	{
		writeProperty("restrictionEffDate", restrictionEffDate);
	}

	public Date getRestrictionEffDate()
	{
		return (Date) readProperty("restrictionEffDate");
	}

	public void setRestrictionEndDate(Date restrictionEndDate)
	{
		writeProperty("restrictionEndDate", restrictionEndDate);
	}

	public Date getRestrictionEndDate()
	{
		return (Date) readProperty("restrictionEndDate");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setAcctBookcomp(AcctBookcomp acctBookcomp)
	{
		setToOneTarget("acctBookcomp", acctBookcomp, true);
	}

	public AcctBookcomp getAcctBookcomp()
	{
		return (AcctBookcomp) readProperty("acctBookcomp");
	}

	public void setOrderTypeGrpDesc(OrderTypeGrpDesc orderTypeGrpDesc)
	{
		setToOneTarget("orderTypeGrpDesc", orderTypeGrpDesc, true);
	}

	public OrderTypeGrpDesc getOrderTypeGrpDesc()
	{
		return (OrderTypeGrpDesc) readProperty("orderTypeGrpDesc");
	}

	public void setTradeTenor(TradeTenor tradeTenor)
	{
		setToOneTarget("tradeTenor", tradeTenor, true);
	}

	public TradeTenor getTradeTenor()
	{
		return (TradeTenor) readProperty("tradeTenor");
	}

}
