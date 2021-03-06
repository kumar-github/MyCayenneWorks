package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VSapPortfolio was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VSapPortfolio extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> BOOKING_COMPANY = new Property<String>("bookingCompany");
	public static final Property<String> GROUP_CODE = new Property<String>("groupCode");
	public static final Property<Date> LAST_UPDATE_DATE = new Property<Date>("lastUpdateDate");
	public static final Property<Integer> PARENT_PORT_NUM = new Property<Integer>("parentPortNum");
	public static final Property<String> PORT_FULL_NAME = new Property<String>("portFullName");
	public static final Property<Short> PORT_LOCKED = new Property<Short>("portLocked");
	public static final Property<Integer> PORT_NUM = new Property<Integer>("portNum");
	public static final Property<String> PORT_SHORT_NAME = new Property<String>("portShortName");
	public static final Property<String> PORT_TYPE = new Property<String>("portType");
	public static final Property<String> PROFIT_CENTER_CODE = new Property<String>("profitCenterCode");
	public static final Property<String> TRADING_ENTITY = new Property<String>("tradingEntity");

	public void setBookingCompany(String bookingCompany)
	{
		writeProperty("bookingCompany", bookingCompany);
	}

	public String getBookingCompany()
	{
		return (String) readProperty("bookingCompany");
	}

	public void setGroupCode(String groupCode)
	{
		writeProperty("groupCode", groupCode);
	}

	public String getGroupCode()
	{
		return (String) readProperty("groupCode");
	}

	public void setLastUpdateDate(Date lastUpdateDate)
	{
		writeProperty("lastUpdateDate", lastUpdateDate);
	}

	public Date getLastUpdateDate()
	{
		return (Date) readProperty("lastUpdateDate");
	}

	public void setParentPortNum(Integer parentPortNum)
	{
		writeProperty("parentPortNum", parentPortNum);
	}

	public Integer getParentPortNum()
	{
		return (Integer) readProperty("parentPortNum");
	}

	public void setPortFullName(String portFullName)
	{
		writeProperty("portFullName", portFullName);
	}

	public String getPortFullName()
	{
		return (String) readProperty("portFullName");
	}

	public void setPortLocked(Short portLocked)
	{
		writeProperty("portLocked", portLocked);
	}

	public Short getPortLocked()
	{
		return (Short) readProperty("portLocked");
	}

	public void setPortNum(Integer portNum)
	{
		writeProperty("portNum", portNum);
	}

	public Integer getPortNum()
	{
		return (Integer) readProperty("portNum");
	}

	public void setPortShortName(String portShortName)
	{
		writeProperty("portShortName", portShortName);
	}

	public String getPortShortName()
	{
		return (String) readProperty("portShortName");
	}

	public void setPortType(String portType)
	{
		writeProperty("portType", portType);
	}

	public String getPortType()
	{
		return (String) readProperty("portType");
	}

	public void setProfitCenterCode(String profitCenterCode)
	{
		writeProperty("profitCenterCode", profitCenterCode);
	}

	public String getProfitCenterCode()
	{
		return (String) readProperty("profitCenterCode");
	}

	public void setTradingEntity(String tradingEntity)
	{
		writeProperty("tradingEntity", tradingEntity);
	}

	public String getTradingEntity()
	{
		return (String) readProperty("tradingEntity");
	}

}
