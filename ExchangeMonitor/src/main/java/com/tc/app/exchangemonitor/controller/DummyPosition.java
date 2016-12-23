package com.tc.app.exchangemonitor.controller;

import java.util.Date;
import java.util.Objects;

import org.apache.cayenne.DataRow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class DummyPosition
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean IS_DEBUG_ENABLED = LOGGER.isDebugEnabled();

	private String externalTradeStateName;
	private Date creationDate;
	private Date entryDate;
	private String exchToolsTradeNum;
	private String commodity;
	private String tradingPeriod;
	private String callPut;
	private Double strikePrice;
	private Double quantity;
	private Double price;
	private String inputAction;
	private String inputCompany;
	private String acceptedAction;
	private String acceptedCompany;
	private String buyerAccount;

	public DummyPosition()
	{
	}

	public DummyPosition(final String commodity, final String tradingPeriod, final String callPut, final Double strikePrice)
	{
		this.commodity = commodity;
		this.tradingPeriod = tradingPeriod;
		this.callPut = callPut;
		this.strikePrice = strikePrice;
	}

	/**
	 * @param externalTradeStateName2
	 * @param creationDate2
	 * @param entryDate2
	 * @param exchToolsTradeNum2
	 * @param commodity2
	 * @param tradingPeriod2
	 * @param callPut2
	 * @param strikePrice2
	 * @param quantity2
	 * @param price2
	 * @param inputAction2
	 * @param inputCompany2
	 * @param acceptedAction2
	 * @param acceptedCompany2
	 * @param buyerAccount2
	 */
	public DummyPosition(final String externalTradeStateName, final Date creationDate, final Date entryDate, final String exchToolsTradeNum, final String commodity, final String tradingPeriod, final String callPut, final Double strikePrice, final Double quantity, final Double price, final String inputAction, final String inputCompany, final String acceptedAction, final String acceptedCompany, final String buyerAccount)
	{
		this.externalTradeStateName = externalTradeStateName;
		this.creationDate = creationDate;
		this.entryDate = entryDate;
		this.exchToolsTradeNum = exchToolsTradeNum;
		this.commodity = commodity;
		this.tradingPeriod = tradingPeriod;
		this.callPut = callPut;
		this.strikePrice = strikePrice;
		this.quantity = quantity;
		this.price = price;
		this.inputAction = inputAction;
		this.inputCompany = inputCompany;
		this.acceptedAction = acceptedAction;
		this.acceptedCompany = acceptedCompany;
		this.buyerAccount = buyerAccount;
	}

	public DummyPosition(final DataRow aPositionDataRow)
	{
		this.externalTradeStateName = aPositionDataRow.get("externalTradeStateName") != null ? aPositionDataRow.get("externalTradeStateName").toString() : null;
		this.creationDate = aPositionDataRow.get("creationDate") != null ? (Date) aPositionDataRow.get("creationDate") : null;
		this.entryDate = aPositionDataRow.get("entryDate") != null ? (Date) aPositionDataRow.get("entryDate") : null;
		this.exchToolsTradeNum = aPositionDataRow.get("exchToolsTradeNum") != null ? aPositionDataRow.get("exchToolsTradeNum").toString() : null;
		this.commodity = aPositionDataRow.get("commodity") != null ? aPositionDataRow.get("commodity").toString() : null;
		this.tradingPeriod = aPositionDataRow.get("tradingPeriod") != null ? aPositionDataRow.get("tradingPeriod").toString() : null;
		this.callPut = aPositionDataRow.get("callPut") != null ? aPositionDataRow.get("callPut").toString() : "";
		this.strikePrice = aPositionDataRow.get("strikePrice") != null ? (Double) (aPositionDataRow.get("strikePrice")) : 0.0;
		this.quantity = aPositionDataRow.get("quantity") != null ? (Double) aPositionDataRow.get("quantity") : null;
		this.price = aPositionDataRow.get("price") != null ? (Double) aPositionDataRow.get("price") : null;
		this.inputAction = aPositionDataRow.get("inputAction") != null ? aPositionDataRow.get("inputAction").toString() : null;
		this.inputCompany = aPositionDataRow.get("inputCompany") != null ? aPositionDataRow.get("inputCompany").toString() : null;
		this.acceptedAction = aPositionDataRow.get("acceptedAction") != null ? aPositionDataRow.get("acceptedAction").toString() : "";
		this.acceptedCompany = aPositionDataRow.get("acceptedCompany") != null ? aPositionDataRow.get("acceptedCompany").toString() : null;
		this.buyerAccount = aPositionDataRow.get("buyerAccount") != null ? aPositionDataRow.get("buyerAccount").toString() : null;

		if(IS_DEBUG_ENABLED)
		{
			LOGGER.debug("A Position object constructed : {}", this.externalTradeStateName + "," + this.creationDate + "," + this.entryDate + "," + this.exchToolsTradeNum + "," + this.commodity + "," + this.tradingPeriod + "," + this.callPut + "," + this.strikePrice + "," + this.quantity + "," + this.price + "," + this.inputAction + "," + this.inputCompany + "," + this.acceptedAction + "," + this.acceptedCompany + "," + this.buyerAccount);
		}
	}

	public String getExternalTradeStateName()
	{
		return this.externalTradeStateName;
	}

	public void setExternalTradeStateName(final String externalTradeStateName)
	{
		this.externalTradeStateName = externalTradeStateName;
	}

	public Date getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(final Date creationDate)
	{
		this.creationDate = creationDate;
	}

	public Date getEntryDate()
	{
		return this.entryDate;
	}

	public void setEntryDate(final Date entryDate)
	{
		this.entryDate = entryDate;
	}

	public String getExchToolsTradeNum()
	{
		return this.exchToolsTradeNum;
	}

	public void setExchToolsTradeNum(final String exchToolsTradeNum)
	{
		this.exchToolsTradeNum = exchToolsTradeNum;
	}

	public String getCommodity()
	{
		return this.commodity;
	}

	public void setCommodity(final String commodity)
	{
		this.commodity = commodity;
	}

	public String getTradingPeriod()
	{
		return this.tradingPeriod;
	}

	public void setTradingPeriod(final String tradingPeriod)
	{
		this.tradingPeriod = tradingPeriod;
	}

	public String getCallPut()
	{
		return this.callPut;
	}

	public void setCallPut(final String callPut)
	{
		//this.callPut = callPut;
		this.callPut = (callPut == null) ? "" : callPut;
	}

	public Double getStrikePrice()
	{
		return this.strikePrice;
	}

	public void setStrikePrice(final Double strikePrice)
	{
		//this.strikePrice = strikePrice;
		this.strikePrice = (strikePrice == null) ? 0.0 : strikePrice;
	}

	public Double getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(final Double quantity)
	{
		this.quantity = quantity;
	}

	public Double getPrice()
	{
		return this.price;
	}

	public void setPrice(final Double price)
	{
		this.price = price;
	}

	public String getInputAction()
	{
		return this.inputAction;
	}

	public void setInputAction(final String inputAction)
	{
		this.inputAction = inputAction;
	}

	public String getInputCompany()
	{
		return this.inputCompany;
	}

	public void setInputCompany(final String inputCompany)
	{
		this.inputCompany = inputCompany;
	}

	public String getAcceptedAction()
	{
		return this.acceptedAction;
	}

	public void setAcceptedAction(final String acceptedAction)
	{
		this.acceptedAction = acceptedAction;
	}

	public String getAcceptedCompany()
	{
		return this.acceptedCompany;
	}

	public void setAcceptedCompany(final String acceptedCompany)
	{
		this.acceptedCompany = acceptedCompany;
	}

	public String getBuyerAccount()
	{
		return this.buyerAccount;
	}

	public void setBuyerAccount(final String buyerAccount)
	{
		this.buyerAccount = buyerAccount;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;

		final DummyPosition other = (DummyPosition) obj;
		return Objects.equals(this.exchToolsTradeNum, other.exchToolsTradeNum) &&
					Objects.equals(this.commodity, other.commodity) &&
					Objects.equals(this.externalTradeStateName, other.externalTradeStateName) &&
					Objects.equals(this.buyerAccount, other.buyerAccount) &&
					Objects.equals(this.creationDate, other.creationDate);
		//(this.creationDate.compareTo(other.creationDate) == 0);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.exchToolsTradeNum, this.commodity, this.externalTradeStateName, this.buyerAccount, this.creationDate);
	}

	/* ====================================================================== */
	/* ========================TEMP VARIABLES =============================== */
	/* ====================================================================== */

	private String buySell;
	public String getBuySell()
	{
		return this.buySell;
	}

	public void setBuySell(final String buySell)
	{
		this.buySell = buySell.trim();
	}

	/* Bought */
	/*private Double buyPosition;
	public Double getBuyPosition()
	{
		return buyPosition != null ? buyPosition : 0.0;
	}

	public void setBuyPosition(Double buyPosition)
	{
		this.buyPosition = buyPosition;
	}*/

	private Double buyPositionPrice;
	public Double getBuyPositionPrice()
	{
		return this.buyPositionPrice != null ? this.buyPositionPrice : 0.0;
	}

	public void setBuyPositionPrice(final Double buyPositionPrice)
	{
		this.buyPositionPrice = buyPositionPrice;
	}

	private Double buyPositionValue;
	public Double getBuyPositionValue()
	{
		return this.buyPositionValue != null ? this.buyPositionValue : 0.0;
	}

	public void setBuyPositionValue(final Double buyPositionValue)
	{
		this.buyPositionValue = buyPositionValue;
	}

	/* Sold */
	/*
	private Double sellPosition;
	public Double getSellPosition()
	{
		return sellPosition != null ? sellPosition : 0.0;
	}

	public void setSellPosition(Double sellPosition)
	{
		this.sellPosition = sellPosition;
	}*/

	private Double sellPositionPrice;
	public Double getSellPositionPrice()
	{
		return this.sellPositionPrice != null ? this.sellPositionPrice : 0.0;
	}

	public void setSellPositionPrice(final Double sellPositionPrice)
	{
		this.sellPositionPrice = sellPositionPrice;
	}

	private Double sellPositionValue;
	public Double getSellPositionValue()
	{
		return this.sellPositionValue != null ? this.sellPositionValue : 0.0;
	}

	public void setSellPositionValue(final Double sellPositionValue)
	{
		this.sellPositionValue = sellPositionValue;
	}

	private Double averageBuyPrice;
	public Double getAverageBuyPrice()
	{
		return this.averageBuyPrice;
	}

	public void setAverageBuyPrice(final Double averageBuyPrice)
	{
		this.averageBuyPrice = averageBuyPrice;
	}

	private Double averageSellPrice;
	public Double getAverageSellPrice()
	{
		return this.averageSellPrice;
	}

	public void setAverageSellPrice(final Double averageSellPrice)
	{
		this.averageSellPrice = averageSellPrice;
	}

	private Double lastPrice;
	public Double getLastPrice()
	{
		return this.lastPrice;
	}

	public void setLastPrice(final Double lastPrice)
	{
		this.lastPrice = lastPrice;
		/*
		if(this.lastPrice == null)
			this.lastPrice = lastPrice;
			*/
	}

	/*
	private Double netQuantity;
	public Double getNetQuantity()
	{
		return netQuantity;
	}

	public void setNetQuantity(Double netQuantity)
	{
		this.netQuantity = netQuantity;
	}
	 */

	/*
	private Double pl;
	public long getPL()
	{
		return Math.round(pl * 1000);
	}

	public void setPL(Double pl)
	{
		this.pl = pl;
	}
	 */

	/*
	private final ReadOnlyObjectWrapper<Double> total = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<Double> totalProperty()
	{
		return this.total.getReadOnlyProperty();
	}

	public final java.lang.Double getTotal()
	{
		return this.totalProperty().get();
	}
	 */

	private final ReadOnlyObjectWrapper<Double> buyPosition = new ReadOnlyObjectWrapper<>(0.0);
	public ReadOnlyObjectProperty<Double> buyPositionProperty()
	{
		return this.buyPosition.getReadOnlyProperty();
	}

	public final double getBuyPosition()
	{
		return this.buyPositionProperty().get();
	}

	public void setBuyPosition(final Double buyPosition)
	{
		this.buyPosition.set(buyPosition);
	}

	private final ReadOnlyObjectWrapper<Double> sellPosition = new ReadOnlyObjectWrapper<>(0.0);
	public ReadOnlyObjectProperty<Double> sellPositionProperty()
	{
		return this.sellPosition.getReadOnlyProperty();
	}

	public final double getSellPosition()
	{
		return this.sellPositionProperty().get();
	}

	public void setSellPosition(final Double sellPosition)
	{
		this.sellPosition.set(sellPosition);
	}

	private final ReadOnlyObjectWrapper<Double> netQuantity = new ReadOnlyObjectWrapper<>(0.0);
	public ReadOnlyObjectProperty<Double> netQuantityProperty()
	{
		return this.netQuantity.getReadOnlyProperty();
	}

	public final double getNetQuantity()
	{
		return this.netQuantityProperty().get();
	}

	public void setNetQuantity(final Double netQuantity)
	{
		this.netQuantity.set(netQuantity);
	}

	private final ReadOnlyObjectWrapper<Double> total = new ReadOnlyObjectWrapper<>();
	public ReadOnlyObjectProperty<Double> totalProperty()
	{
		return this.total.getReadOnlyProperty();
	}

	//public final java.lang.Double getTotal()
	public final double getTotal()
	{
		return this.totalProperty().get();
		//return Math.round(total.get() * 1000);
	}

	public void setTotal(final Double total)
	{
		//this.total.set(total * 1000);
		//this.total.set(2.0);
		this.total.set(total);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.getCommodity() + " <--> " + this.getBuySell() + " <--> " + this.getCallPut() + " <--> " + this.getExchToolsTradeNum() + " <--> " + this.getExternalTradeStateName() + " <--> " + this.getTradingPeriod() + " <--> " + this.getStrikePrice() + " <--> " + this.getPrice();
	}
}

/*
//public static class TotalLine extends DummyPosition
class TotalLine extends DummyPosition
{
	private final ReadOnlyObjectWrapper<Double> total = new ReadOnlyObjectWrapper<>();

	public TotalLine(ObservableList<? extends DummyPosition> items)
	{
		super("Total", null, null, null);

		// Bind total to the sum of the totals of all the other line items:
		//total.bind(Bindings.createObjectBinding(() -> items.stream().collect(Collectors.summingDouble(DummyPosition::getTotal)), items));
		total.bind(Bindings.createObjectBinding(() -> items.stream().collect(Collectors.summingDouble(DummyPosition::getTotal)), items));
	}

	@Override
	public ReadOnlyObjectProperty<Double> totalProperty()
	{
		return total;
	}
}
 */

/*

// TransformationList implementation. This TransformationList just has
// one extra line at the end, displaying the total. We use a subclass of
// LineItem for that line:
class LineItemListWithTotal extends TransformationList<DummyPosition, DummyPosition>
{
	private final TotalLine totalLine;

	protected LineItemListWithTotal(	ObservableList<? extends DummyPosition> source)
	{
		super(source);
		totalLine = new TotalLine(source);
	}

	@Override
	protected void sourceChanged(Change<? extends DummyPosition> c) {

		// no need to modify change:
		// indexes generated by the source list will match indexes in this
		// list

		fireChange(c);
	}

	// if index is in range for source list, just return that index
	// otherwise return -1, indicating index is not represented in source
	@Override
	public int getSourceIndex(int index) {
		if (index < getSource().size()) {
			return index;
		}
		return -1;
	}

	// if index is in range for source list, return corresponding
	// item from source list.
	// if index is one after the last element in the source list,
	// return total line.
	@Override
	public DummyPosition get(int index)
	{
		if (index < getSource().size())
		{
			return getSource().get(index);
		}
		else if (index == getSource().size())
		{
			return totalLine;
		}
		else
			throw new ArrayIndexOutOfBoundsException(index);
	}

	// size of transformation list is one bigger than size of source list:
	@Override
	public int size()
	{
		return getSource().size() + 1;
	}
}
 */