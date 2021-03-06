package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountCreditLimit;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Uom;

/**
 * Class _LimitType was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _LimitType extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String LIMIT_TYPE_CODE_PK_COLUMN = "limit_type_code";

	public static final Property<String> LIMIT_TYPE_DESC = new Property<String>("limitTypeDesc");
	public static final Property<Short> LIMIT_TYPE_NUM = new Property<Short>("limitTypeNum");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<AccountCreditLimit>> ACCOUNT_CREDIT_LIMITS = new Property<List<AccountCreditLimit>>("accountCreditLimits");
	public static final Property<Uom> UOM = new Property<Uom>("uom");

	public void setLimitTypeDesc(String limitTypeDesc)
	{
		writeProperty("limitTypeDesc", limitTypeDesc);
	}

	public String getLimitTypeDesc()
	{
		return (String) readProperty("limitTypeDesc");
	}

	public void setLimitTypeNum(Short limitTypeNum)
	{
		writeProperty("limitTypeNum", limitTypeNum);
	}

	public Short getLimitTypeNum()
	{
		return (Short) readProperty("limitTypeNum");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToAccountCreditLimits(AccountCreditLimit obj)
	{
		addToManyTarget("accountCreditLimits", obj, true);
	}

	public void removeFromAccountCreditLimits(AccountCreditLimit obj)
	{
		removeToManyTarget("accountCreditLimits", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AccountCreditLimit> getAccountCreditLimits()
	{
		return (List<AccountCreditLimit>) readProperty("accountCreditLimits");
	}

	public void setUom(Uom uom)
	{
		setToOneTarget("uom", uom, true);
	}

	public Uom getUom()
	{
		return (Uom) readProperty("uom");
	}

}
