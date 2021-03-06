package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttAckCnfrm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttAckCnfrmLitem;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttNomLitem;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttNomination;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttOrderTicket;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttSchUpdLitem;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttScheduleUpdt;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgBttTicketLitem;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgNomination;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AgSchedule;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedDefinition;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedDetailData;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedError;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedStatus;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedTransaction;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedXsdXmlText;
import com.tc.app.exchangemonitor.model.cayenne.persistent.MsiFeedData;
import com.tc.app.exchangemonitor.model.cayenne.persistent.RgStagingAcct;
import com.tc.app.exchangemonitor.model.cayenne.persistent.RgStagingAcctAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.RgStagingAcctBankInfo;

/**
 * Class _FeedData was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FeedData extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Integer> NUMBER_OF_ROWS = new Property<Integer>("numberOfRows");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<List<AgBttAckCnfrmLitem>> AG_BTT_ACK_CNFRM_LITEMS = new Property<List<AgBttAckCnfrmLitem>>("agBttAckCnfrmLitems");
	public static final Property<List<AgBttNomLitem>> AG_BTT_NOM_LITEMS = new Property<List<AgBttNomLitem>>("agBttNomLitems");
	public static final Property<List<AgBttSchUpdLitem>> AG_BTT_SCH_UPD_LITEMS = new Property<List<AgBttSchUpdLitem>>("agBttSchUpdLitems");
	public static final Property<List<AgBttTicketLitem>> AG_BTT_TICKET_LITEMS = new Property<List<AgBttTicketLitem>>("agBttTicketLitems");
	public static final Property<AgBttOrderTicket> FD_O = new Property<AgBttOrderTicket>("fdO");
	public static final Property<AgNomination> FD_O1 = new Property<AgNomination>("fdO1");
	public static final Property<AgSchedule> FD_O2 = new Property<AgSchedule>("fdO2");
	public static final Property<AgBttNomination> FD_O3 = new Property<AgBttNomination>("fdO3");
	public static final Property<AgBttAckCnfrm> FD_O4 = new Property<AgBttAckCnfrm>("fdO4");
	public static final Property<AgBttScheduleUpdt> FD_O5 = new Property<AgBttScheduleUpdt>("fdO5");
	public static final Property<FeedDefinition> FEED = new Property<FeedDefinition>("feed");
	public static final Property<List<FeedDetailData>> FEED_DETAIL_DATAS = new Property<List<FeedDetailData>>("feedDetailDatas");
	public static final Property<List<FeedError>> FEED_ERRORS = new Property<List<FeedError>>("feedErrors");
	public static final Property<FeedStatus> FEED_STATUS = new Property<FeedStatus>("feedStatus");
	public static final Property<List<FeedTransaction>> FEED_TRANSACTIONS = new Property<List<FeedTransaction>>("feedTransactions");
	public static final Property<List<MsiFeedData>> MSI_FEED_DATAS = new Property<List<MsiFeedData>>("msiFeedDatas");
	public static final Property<FeedXsdXmlText> REQUEST_XML = new Property<FeedXsdXmlText>("requestXml");
	public static final Property<FeedXsdXmlText> RESPONSE_XML = new Property<FeedXsdXmlText>("responseXml");
	public static final Property<List<RgStagingAcctAddress>> RG_STAGING_ACCT_ADDRESSES = new Property<List<RgStagingAcctAddress>>("rgStagingAcctAddresses");
	public static final Property<List<RgStagingAcctBankInfo>> RG_STAGING_ACCT_BANK_INFOES = new Property<List<RgStagingAcctBankInfo>>("rgStagingAcctBankInfoes");
	public static final Property<List<RgStagingAcct>> RG_STAGING_ACCTS = new Property<List<RgStagingAcct>>("rgStagingAccts");

	public void setNumberOfRows(Integer numberOfRows)
	{
		writeProperty("numberOfRows", numberOfRows);
	}

	public Integer getNumberOfRows()
	{
		return (Integer) readProperty("numberOfRows");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void addToAgBttAckCnfrmLitems(AgBttAckCnfrmLitem obj)
	{
		addToManyTarget("agBttAckCnfrmLitems", obj, true);
	}

	public void removeFromAgBttAckCnfrmLitems(AgBttAckCnfrmLitem obj)
	{
		removeToManyTarget("agBttAckCnfrmLitems", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AgBttAckCnfrmLitem> getAgBttAckCnfrmLitems()
	{
		return (List<AgBttAckCnfrmLitem>) readProperty("agBttAckCnfrmLitems");
	}

	public void addToAgBttNomLitems(AgBttNomLitem obj)
	{
		addToManyTarget("agBttNomLitems", obj, true);
	}

	public void removeFromAgBttNomLitems(AgBttNomLitem obj)
	{
		removeToManyTarget("agBttNomLitems", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AgBttNomLitem> getAgBttNomLitems()
	{
		return (List<AgBttNomLitem>) readProperty("agBttNomLitems");
	}

	public void addToAgBttSchUpdLitems(AgBttSchUpdLitem obj)
	{
		addToManyTarget("agBttSchUpdLitems", obj, true);
	}

	public void removeFromAgBttSchUpdLitems(AgBttSchUpdLitem obj)
	{
		removeToManyTarget("agBttSchUpdLitems", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AgBttSchUpdLitem> getAgBttSchUpdLitems()
	{
		return (List<AgBttSchUpdLitem>) readProperty("agBttSchUpdLitems");
	}

	public void addToAgBttTicketLitems(AgBttTicketLitem obj)
	{
		addToManyTarget("agBttTicketLitems", obj, true);
	}

	public void removeFromAgBttTicketLitems(AgBttTicketLitem obj)
	{
		removeToManyTarget("agBttTicketLitems", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<AgBttTicketLitem> getAgBttTicketLitems()
	{
		return (List<AgBttTicketLitem>) readProperty("agBttTicketLitems");
	}

	public void setFdO(AgBttOrderTicket fdO)
	{
		setToOneTarget("fdO", fdO, true);
	}

	public AgBttOrderTicket getFdO()
	{
		return (AgBttOrderTicket) readProperty("fdO");
	}

	public void setFdO1(AgNomination fdO1)
	{
		setToOneTarget("fdO1", fdO1, true);
	}

	public AgNomination getFdO1()
	{
		return (AgNomination) readProperty("fdO1");
	}

	public void setFdO2(AgSchedule fdO2)
	{
		setToOneTarget("fdO2", fdO2, true);
	}

	public AgSchedule getFdO2()
	{
		return (AgSchedule) readProperty("fdO2");
	}

	public void setFdO3(AgBttNomination fdO3)
	{
		setToOneTarget("fdO3", fdO3, true);
	}

	public AgBttNomination getFdO3()
	{
		return (AgBttNomination) readProperty("fdO3");
	}

	public void setFdO4(AgBttAckCnfrm fdO4)
	{
		setToOneTarget("fdO4", fdO4, true);
	}

	public AgBttAckCnfrm getFdO4()
	{
		return (AgBttAckCnfrm) readProperty("fdO4");
	}

	public void setFdO5(AgBttScheduleUpdt fdO5)
	{
		setToOneTarget("fdO5", fdO5, true);
	}

	public AgBttScheduleUpdt getFdO5()
	{
		return (AgBttScheduleUpdt) readProperty("fdO5");
	}

	public void setFeed(FeedDefinition feed)
	{
		setToOneTarget("feed", feed, true);
	}

	public FeedDefinition getFeed()
	{
		return (FeedDefinition) readProperty("feed");
	}

	public void addToFeedDetailDatas(FeedDetailData obj)
	{
		addToManyTarget("feedDetailDatas", obj, true);
	}

	public void removeFromFeedDetailDatas(FeedDetailData obj)
	{
		removeToManyTarget("feedDetailDatas", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FeedDetailData> getFeedDetailDatas()
	{
		return (List<FeedDetailData>) readProperty("feedDetailDatas");
	}

	public void addToFeedErrors(FeedError obj)
	{
		addToManyTarget("feedErrors", obj, true);
	}

	public void removeFromFeedErrors(FeedError obj)
	{
		removeToManyTarget("feedErrors", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FeedError> getFeedErrors()
	{
		return (List<FeedError>) readProperty("feedErrors");
	}

	public void setFeedStatus(FeedStatus feedStatus)
	{
		setToOneTarget("feedStatus", feedStatus, true);
	}

	public FeedStatus getFeedStatus()
	{
		return (FeedStatus) readProperty("feedStatus");
	}

	public void addToFeedTransactions(FeedTransaction obj)
	{
		addToManyTarget("feedTransactions", obj, true);
	}

	public void removeFromFeedTransactions(FeedTransaction obj)
	{
		removeToManyTarget("feedTransactions", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<FeedTransaction> getFeedTransactions()
	{
		return (List<FeedTransaction>) readProperty("feedTransactions");
	}

	public void addToMsiFeedDatas(MsiFeedData obj)
	{
		addToManyTarget("msiFeedDatas", obj, true);
	}

	public void removeFromMsiFeedDatas(MsiFeedData obj)
	{
		removeToManyTarget("msiFeedDatas", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<MsiFeedData> getMsiFeedDatas()
	{
		return (List<MsiFeedData>) readProperty("msiFeedDatas");
	}

	public void setRequestXml(FeedXsdXmlText requestXml)
	{
		setToOneTarget("requestXml", requestXml, true);
	}

	public FeedXsdXmlText getRequestXml()
	{
		return (FeedXsdXmlText) readProperty("requestXml");
	}

	public void setResponseXml(FeedXsdXmlText responseXml)
	{
		setToOneTarget("responseXml", responseXml, true);
	}

	public FeedXsdXmlText getResponseXml()
	{
		return (FeedXsdXmlText) readProperty("responseXml");
	}

	public void addToRgStagingAcctAddresses(RgStagingAcctAddress obj)
	{
		addToManyTarget("rgStagingAcctAddresses", obj, true);
	}

	public void removeFromRgStagingAcctAddresses(RgStagingAcctAddress obj)
	{
		removeToManyTarget("rgStagingAcctAddresses", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<RgStagingAcctAddress> getRgStagingAcctAddresses()
	{
		return (List<RgStagingAcctAddress>) readProperty("rgStagingAcctAddresses");
	}

	public void addToRgStagingAcctBankInfoes(RgStagingAcctBankInfo obj)
	{
		addToManyTarget("rgStagingAcctBankInfoes", obj, true);
	}

	public void removeFromRgStagingAcctBankInfoes(RgStagingAcctBankInfo obj)
	{
		removeToManyTarget("rgStagingAcctBankInfoes", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<RgStagingAcctBankInfo> getRgStagingAcctBankInfoes()
	{
		return (List<RgStagingAcctBankInfo>) readProperty("rgStagingAcctBankInfoes");
	}

	public void addToRgStagingAccts(RgStagingAcct obj)
	{
		addToManyTarget("rgStagingAccts", obj, true);
	}

	public void removeFromRgStagingAccts(RgStagingAcct obj)
	{
		removeToManyTarget("rgStagingAccts", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<RgStagingAcct> getRgStagingAccts()
	{
		return (List<RgStagingAcct>) readProperty("rgStagingAccts");
	}

}
