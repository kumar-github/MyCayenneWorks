package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedData;
import com.tc.app.exchangemonitor.model.cayenne.persistent.FeedDetailData;

/**
 * Class _AgBttTicketLitem was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AgBttTicketLitem extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FDD_OID_PK_COLUMN = "fdd_oid";

	public static final Property<Date> BL_DT = new Property<Date>("blDt");
	public static final Property<String> DESTINATION = new Property<String>("destination");
	public static final Property<Date> DT_OF_TRANSFER = new Property<Date>("dtOfTransfer");
	public static final Property<Date> EST_DT_OF_ARRIVAL = new Property<Date>("estDtOfArrival");
	public static final Property<String> EVENT_TYPE = new Property<String>("eventType");
	public static final Property<String> EXT_CHAR_COL1 = new Property<String>("extCharCol1");
	public static final Property<String> EXT_CHAR_COL2 = new Property<String>("extCharCol2");
	public static final Property<String> EXT_CHAR_COL3 = new Property<String>("extCharCol3");
	public static final Property<String> EXT_CHAR_COL4 = new Property<String>("extCharCol4");
	public static final Property<String> EXT_CHAR_COL5 = new Property<String>("extCharCol5");
	public static final Property<Integer> EXT_INT_COL1 = new Property<Integer>("extIntCol1");
	public static final Property<Integer> EXT_INT_COL2 = new Property<Integer>("extIntCol2");
	public static final Property<Integer> EXT_INT_COL3 = new Property<Integer>("extIntCol3");
	public static final Property<BigDecimal> GROSS_LITERS = new Property<BigDecimal>("grossLiters");
	public static final Property<Date> HOSE_OFF = new Property<Date>("hoseOff");
	public static final Property<Date> HOSE_ON = new Property<Date>("hoseOn");
	public static final Property<Integer> LINE_ITEM_NUM = new Property<Integer>("lineItemNum");
	public static final Property<String> LOAD_PORT = new Property<String>("loadPort");
	public static final Property<Date> LOADING_DT = new Property<Date>("loadingDt");
	public static final Property<String> MOT_NAME = new Property<String>("motName");
	public static final Property<String> MOT_TYPE = new Property<String>("motType");
	public static final Property<BigDecimal> NET_LITERS15C = new Property<BigDecimal>("netLiters15c");
	public static final Property<Date> NOR = new Property<Date>("nor");
	public static final Property<String> ORIGIN = new Property<String>("origin");
	public static final Property<Integer> PARCEL_NUM = new Property<Integer>("parcelNum");
	public static final Property<String> PARTY_ID = new Property<String>("partyId");
	public static final Property<String> PARTY_NAME = new Property<String>("partyName");
	public static final Property<String> PARTY_TYPE = new Property<String>("partyType");
	public static final Property<String> PRODUCT_CODE = new Property<String>("productCode");
	public static final Property<BigDecimal> QTY = new Property<BigDecimal>("qty");
	public static final Property<Date> SCHLD_FROM_DT = new Property<Date>("schldFromDt");
	public static final Property<Date> SCHLD_TO_DT = new Property<Date>("schldToDt");
	public static final Property<String> SHIP_COMP_NAME = new Property<String>("shipCompName");
	public static final Property<String> TANK = new Property<String>("tank");
	public static final Property<String> TERMINAL_ADD = new Property<String>("terminalAdd");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<String> UOM_CODE = new Property<String>("uomCode");
	public static final Property<Boolean> VESSEL_DEPARTED = new Property<Boolean>("vesselDeparted");
	public static final Property<FeedData> FD_O = new Property<FeedData>("fdO");
	public static final Property<FeedDetailData> FDD_O = new Property<FeedDetailData>("fddO");

	public void setBlDt(Date blDt)
	{
		writeProperty("blDt", blDt);
	}

	public Date getBlDt()
	{
		return (Date) readProperty("blDt");
	}

	public void setDestination(String destination)
	{
		writeProperty("destination", destination);
	}

	public String getDestination()
	{
		return (String) readProperty("destination");
	}

	public void setDtOfTransfer(Date dtOfTransfer)
	{
		writeProperty("dtOfTransfer", dtOfTransfer);
	}

	public Date getDtOfTransfer()
	{
		return (Date) readProperty("dtOfTransfer");
	}

	public void setEstDtOfArrival(Date estDtOfArrival)
	{
		writeProperty("estDtOfArrival", estDtOfArrival);
	}

	public Date getEstDtOfArrival()
	{
		return (Date) readProperty("estDtOfArrival");
	}

	public void setEventType(String eventType)
	{
		writeProperty("eventType", eventType);
	}

	public String getEventType()
	{
		return (String) readProperty("eventType");
	}

	public void setExtCharCol1(String extCharCol1)
	{
		writeProperty("extCharCol1", extCharCol1);
	}

	public String getExtCharCol1()
	{
		return (String) readProperty("extCharCol1");
	}

	public void setExtCharCol2(String extCharCol2)
	{
		writeProperty("extCharCol2", extCharCol2);
	}

	public String getExtCharCol2()
	{
		return (String) readProperty("extCharCol2");
	}

	public void setExtCharCol3(String extCharCol3)
	{
		writeProperty("extCharCol3", extCharCol3);
	}

	public String getExtCharCol3()
	{
		return (String) readProperty("extCharCol3");
	}

	public void setExtCharCol4(String extCharCol4)
	{
		writeProperty("extCharCol4", extCharCol4);
	}

	public String getExtCharCol4()
	{
		return (String) readProperty("extCharCol4");
	}

	public void setExtCharCol5(String extCharCol5)
	{
		writeProperty("extCharCol5", extCharCol5);
	}

	public String getExtCharCol5()
	{
		return (String) readProperty("extCharCol5");
	}

	public void setExtIntCol1(Integer extIntCol1)
	{
		writeProperty("extIntCol1", extIntCol1);
	}

	public Integer getExtIntCol1()
	{
		return (Integer) readProperty("extIntCol1");
	}

	public void setExtIntCol2(Integer extIntCol2)
	{
		writeProperty("extIntCol2", extIntCol2);
	}

	public Integer getExtIntCol2()
	{
		return (Integer) readProperty("extIntCol2");
	}

	public void setExtIntCol3(Integer extIntCol3)
	{
		writeProperty("extIntCol3", extIntCol3);
	}

	public Integer getExtIntCol3()
	{
		return (Integer) readProperty("extIntCol3");
	}

	public void setGrossLiters(BigDecimal grossLiters)
	{
		writeProperty("grossLiters", grossLiters);
	}

	public BigDecimal getGrossLiters()
	{
		return (BigDecimal) readProperty("grossLiters");
	}

	public void setHoseOff(Date hoseOff)
	{
		writeProperty("hoseOff", hoseOff);
	}

	public Date getHoseOff()
	{
		return (Date) readProperty("hoseOff");
	}

	public void setHoseOn(Date hoseOn)
	{
		writeProperty("hoseOn", hoseOn);
	}

	public Date getHoseOn()
	{
		return (Date) readProperty("hoseOn");
	}

	public void setLineItemNum(Integer lineItemNum)
	{
		writeProperty("lineItemNum", lineItemNum);
	}

	public Integer getLineItemNum()
	{
		return (Integer) readProperty("lineItemNum");
	}

	public void setLoadPort(String loadPort)
	{
		writeProperty("loadPort", loadPort);
	}

	public String getLoadPort()
	{
		return (String) readProperty("loadPort");
	}

	public void setLoadingDt(Date loadingDt)
	{
		writeProperty("loadingDt", loadingDt);
	}

	public Date getLoadingDt()
	{
		return (Date) readProperty("loadingDt");
	}

	public void setMotName(String motName)
	{
		writeProperty("motName", motName);
	}

	public String getMotName()
	{
		return (String) readProperty("motName");
	}

	public void setMotType(String motType)
	{
		writeProperty("motType", motType);
	}

	public String getMotType()
	{
		return (String) readProperty("motType");
	}

	public void setNetLiters15c(BigDecimal netLiters15c)
	{
		writeProperty("netLiters15c", netLiters15c);
	}

	public BigDecimal getNetLiters15c()
	{
		return (BigDecimal) readProperty("netLiters15c");
	}

	public void setNor(Date nor)
	{
		writeProperty("nor", nor);
	}

	public Date getNor()
	{
		return (Date) readProperty("nor");
	}

	public void setOrigin(String origin)
	{
		writeProperty("origin", origin);
	}

	public String getOrigin()
	{
		return (String) readProperty("origin");
	}

	public void setParcelNum(Integer parcelNum)
	{
		writeProperty("parcelNum", parcelNum);
	}

	public Integer getParcelNum()
	{
		return (Integer) readProperty("parcelNum");
	}

	public void setPartyId(String partyId)
	{
		writeProperty("partyId", partyId);
	}

	public String getPartyId()
	{
		return (String) readProperty("partyId");
	}

	public void setPartyName(String partyName)
	{
		writeProperty("partyName", partyName);
	}

	public String getPartyName()
	{
		return (String) readProperty("partyName");
	}

	public void setPartyType(String partyType)
	{
		writeProperty("partyType", partyType);
	}

	public String getPartyType()
	{
		return (String) readProperty("partyType");
	}

	public void setProductCode(String productCode)
	{
		writeProperty("productCode", productCode);
	}

	public String getProductCode()
	{
		return (String) readProperty("productCode");
	}

	public void setQty(BigDecimal qty)
	{
		writeProperty("qty", qty);
	}

	public BigDecimal getQty()
	{
		return (BigDecimal) readProperty("qty");
	}

	public void setSchldFromDt(Date schldFromDt)
	{
		writeProperty("schldFromDt", schldFromDt);
	}

	public Date getSchldFromDt()
	{
		return (Date) readProperty("schldFromDt");
	}

	public void setSchldToDt(Date schldToDt)
	{
		writeProperty("schldToDt", schldToDt);
	}

	public Date getSchldToDt()
	{
		return (Date) readProperty("schldToDt");
	}

	public void setShipCompName(String shipCompName)
	{
		writeProperty("shipCompName", shipCompName);
	}

	public String getShipCompName()
	{
		return (String) readProperty("shipCompName");
	}

	public void setTank(String tank)
	{
		writeProperty("tank", tank);
	}

	public String getTank()
	{
		return (String) readProperty("tank");
	}

	public void setTerminalAdd(String terminalAdd)
	{
		writeProperty("terminalAdd", terminalAdd);
	}

	public String getTerminalAdd()
	{
		return (String) readProperty("terminalAdd");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setUomCode(String uomCode)
	{
		writeProperty("uomCode", uomCode);
	}

	public String getUomCode()
	{
		return (String) readProperty("uomCode");
	}

	public void setVesselDeparted(Boolean vesselDeparted)
	{
		writeProperty("vesselDeparted", vesselDeparted);
	}

	public Boolean getVesselDeparted()
	{
		return (Boolean) readProperty("vesselDeparted");
	}

	public void setFdO(FeedData fdO)
	{
		setToOneTarget("fdO", fdO, true);
	}

	public FeedData getFdO()
	{
		return (FeedData) readProperty("fdO");
	}

	public void setFddO(FeedDetailData fddO)
	{
		setToOneTarget("fddO", fddO, true);
	}

	public FeedDetailData getFddO()
	{
		return (FeedDetailData) readProperty("fddO");
	}

}
