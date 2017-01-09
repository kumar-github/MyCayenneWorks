package com.tc.app.exchangemonitor.controller;

import java.util.Date;

import org.apache.cayenne.DataRow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DummyLoadSchedule
{
	private static final Logger LOGGER = LogManager.getLogger();

	private Integer externalTradeSourceOid;
	private String externalTradeSourceName;
	private String externalValue1;
	private String loadingSchedule;
	private Date loadingTimeFrom;
	private Date loadingTimeTo;
	private Date tradeDateToLoad;
	private String loadingDateTimezone;
	private String userInit;
	private Integer oid;

	public DummyLoadSchedule()
	{
	}

	public DummyLoadSchedule(final DataRow aDataRow)
	{
		this.externalTradeSourceOid = aDataRow.get("externalTradeSourceOid") != null ? (Integer) aDataRow.get("externalTradeSourceOid") : null;
		this.externalTradeSourceName = aDataRow.get("externalTradeSourceName") != null ? (String) aDataRow.get("externalTradeSourceName") : null;
		this.externalValue1 = aDataRow.get("externalValue1") != null ? (String) aDataRow.get("externalValue1") : null;
		this.loadingSchedule = aDataRow.get("loadingSchedule") != null ? (String) aDataRow.get("loadingSchedule") : null;
		this.loadingTimeFrom = aDataRow.get("loadingTimeFrom") != null ? (Date) aDataRow.get("loadingTimeFrom") : null;
		this.loadingTimeTo = aDataRow.get("loadingTimeTo") != null ? (Date) aDataRow.get("loadingTimeTo") : null;
		this.tradeDateToLoad = aDataRow.get("tradeDateToLoad") != null ? (Date) aDataRow.get("tradeDateToLoad") : null;
		this.loadingDateTimezone = aDataRow.get("loadingDateTimezone") != null ? (String) aDataRow.get("loadingDateTimezone") : null;
		this.userInit = aDataRow.get("userInit") != null ? (String) aDataRow.get("userInit") : null;
		this.oid = aDataRow.get("oid") != null ? (Integer) aDataRow.get("oid") : null;

		LOGGER.info(this);
	}

	public Integer getExternalTradeSourceOid()
	{
		return this.externalTradeSourceOid;
	}

	public void setExternalTradeSourceOid(final Integer externalTradeSourceOid)
	{
		this.externalTradeSourceOid = externalTradeSourceOid;
	}

	public String getExternalTradeSourceName()
	{
		return this.externalTradeSourceName;
	}

	public void setExternalTradeSourceName(final String externalTradeSourceName)
	{
		this.externalTradeSourceName = externalTradeSourceName;
	}

	public String getExternalValue1()
	{
		return this.externalValue1;
	}

	public void setExternalValue1(final String externalValue1)
	{
		this.externalValue1 = externalValue1;
	}

	public String getLoadingSchedule()
	{
		return this.loadingSchedule;
	}

	public void setLoadingSchedule(final String loadingSchedule)
	{
		this.loadingSchedule = loadingSchedule;
	}

	public Date getLoadingTimeFrom()
	{
		return this.loadingTimeFrom;
	}

	public void setLoadingTimeFrom(final Date loadingTimeFrom)
	{
		this.loadingTimeFrom = loadingTimeFrom;
	}

	public Date getLoadingTimeTo()
	{
		return this.loadingTimeTo;
	}

	public void setLoadingTimeTo(final Date loadingTimeTo)
	{
		this.loadingTimeTo = loadingTimeTo;
	}

	public Date getTradeDateToLoad()
	{
		return this.tradeDateToLoad;
	}

	public void setTradeDateToLoad(final Date tradeDateToLoad)
	{
		this.tradeDateToLoad = tradeDateToLoad;
	}

	public String getLoadingDateTimezone()
	{
		return this.loadingDateTimezone;
	}

	public void setLoadingDateTimezone(final String loadingDateTimezone)
	{
		this.loadingDateTimezone = loadingDateTimezone;
	}

	public String getUserInit()
	{
		return this.userInit;
	}

	public void setUserInit(final String userInit)
	{
		this.userInit = userInit;
	}

	public Integer getOid()
	{
		return this.oid;
	}

	public void setOid(final Integer oid)
	{
		this.oid = oid;
	}

	@Override
	public String toString()
	{
		return this.externalTradeSourceOid + " <--> " + this.externalValue1 + " <--> " + this.loadingSchedule + " <--> " + this.loadingTimeFrom + " <--> " + this.loadingTimeTo + " <--> " + this.tradeDateToLoad + " <--> " + this.loadingDateTimezone + " <--> " + this.userInit + " <--> " + this.oid;
	}

	/* ================================================================ Few Utility Methods =============================================================== */

	/* A handy enum to deal with the load schedule statuses. */
	public enum LoadScheduleStatus
	{
		O("Off"), L("Load All"), T("Load By Time"), D("Load By Trade Date"), B("Load By Time & Trade Date");

		private final String label;
		LoadScheduleStatus(final String label)
		{
			this.label = label;
		}

		@Override
		public String toString()
		{
			return this.label;
		}
	}

	/* An utility method to get the external trade source name given the oid. But we should not hit DB every time. It is better to join the external trade source table in the query itself and fetch the name. */
	/*
	public String getExternalTradeSourceName()
	{
		return SelectById.query(ExternalTradeSource.class, this.externalTradeSourceOid).selectOne(CayenneHelper.getCayenneServerRuntime().newContext()).getExternalTradeSrcName();
	}
	*/

	public LoadScheduleStatus getLoadingScheduleStatus()
	{
		return this.loadingSchedule != null ? LoadScheduleStatus.valueOf(this.loadingSchedule) : null;
	}

	public String getLoadingTimeFromString()
	{
		return this.loadingTimeFrom != null ? this.loadingTimeFrom.getHours() + ":" + this.loadingTimeFrom.getMinutes() : null;
	}

	public String getLoadingTimeToString()
	{
		return this.loadingTimeTo != null ? this.loadingTimeTo.getHours() + ":" + this.loadingTimeTo.getMinutes() : null;
	}
}