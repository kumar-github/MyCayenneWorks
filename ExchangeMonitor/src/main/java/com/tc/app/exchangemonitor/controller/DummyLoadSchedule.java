package com.tc.app.exchangemonitor.controller;

import java.util.Date;

import org.apache.cayenne.DataRow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DummyLoadSchedule
{
	private static final Logger LOGGER = LogManager.getLogger();

	private Integer externalTradeSourceOid;
	private String externalTradeSourceName;
	private String externalValue1;

	private ObjectProperty<LoadScheduleStatus> loadingSchedule;
	private ObjectProperty<Date> loadingTimeFrom;
	private ObjectProperty<Date> loadingTimeTo;
	private ObjectProperty<Date> tradeDateToLoad;
	private StringProperty loadingDateTimezone;

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

		this.loadingSchedule = new SimpleObjectProperty<>(LoadScheduleStatus.valueOf(aDataRow.get("loadingSchedule") != null ? (String) aDataRow.get("loadingSchedule") : "NULL"));
		this.loadingTimeFrom = new SimpleObjectProperty<>(aDataRow.get("loadingTimeFrom") != null ? (Date) aDataRow.get("loadingTimeFrom") : null);
		this.loadingTimeTo = new SimpleObjectProperty<>(aDataRow.get("loadingTimeTo") != null ? (Date) aDataRow.get("loadingTimeTo") : null);
		this.tradeDateToLoad = new SimpleObjectProperty<>(aDataRow.get("tradeDateToLoad") != null ? (Date) aDataRow.get("tradeDateToLoad") : null);
		this.loadingDateTimezone = new SimpleStringProperty(aDataRow.get("loadingDateTimezone") != null ? (String) aDataRow.get("loadingDateTimezone") : null);

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

	public LoadScheduleStatus getLoadingSchedule()
	{
		return this.loadingSchedule.get();
	}

	public void setLoadingSchedule(final LoadScheduleStatus loadingSchedule)
	{
		this.loadingSchedule.set(loadingSchedule);
	}

	public ObjectProperty<LoadScheduleStatus> loadingScheduleProperty()
	{
		return this.loadingSchedule;
	}

	public Date getLoadingTimeFrom()
	{
		return this.loadingTimeFrom.get();
	}

	public void setLoadingTimeFrom(final Date loadingTimeFrom)
	{
		this.loadingTimeFrom.set(loadingTimeFrom);
	}

	public ObjectProperty<Date> loadingTimeFromProperty()
	{
		return this.loadingTimeFrom;
	}

	public Date getLoadingTimeTo()
	{
		return this.loadingTimeTo.get();
	}

	public void setLoadingTimeTo(final Date loadingTimeTo)
	{
		this.loadingTimeTo.set(loadingTimeTo);
	}

	public ObjectProperty<Date> loadingTimeToProperty()
	{
		return this.loadingTimeTo;
	}

	public Date getTradeDateToLoad()
	{
		return this.tradeDateToLoad.get();
	}

	public void setTradeDateToLoad(final Date tradeDateToLoad)
	{
		this.tradeDateToLoad.set(tradeDateToLoad);
	}

	public ObjectProperty<Date> tradeDateToLoadProperty()
	{
		return this.tradeDateToLoad;
	}

	public String getLoadingDateTimezone()
	{
		return this.loadingDateTimezone.get();
	}

	public void setLoadingDateTimezone(final String loadingDateTimezone)
	{
		this.loadingDateTimezone.set(loadingDateTimezone);
	}

	public StringProperty loadingDateTimezoneProperty()
	{
		return this.loadingDateTimezone;
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
		O("Off"), L("Load All"), T("Load By Time"), D("Load By Trade Date"), B("Load By Time & Trade Date"), NULL("");

		private final String label;
		private LoadScheduleStatus(final String label)
		{
			this.label = label;
		}

		@Override
		public String toString()
		{
			return this.label;
		}
	}
}