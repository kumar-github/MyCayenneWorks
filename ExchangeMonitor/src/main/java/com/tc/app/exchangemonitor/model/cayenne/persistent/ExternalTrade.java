package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._ExternalTrade;

public class ExternalTrade extends _ExternalTrade
{
	private static final long serialVersionUID = 1L;

	public Integer getExternalTradeOid()
	{
		return (this.getObjectId() != null) && !this.getObjectId().isTemporary() ? (Integer) this.getObjectId().getIdSnapshot().get(OID_PK_COLUMN) : null;
	}

	/* so sad. PropertyValueFactory is looking exactly for the below format. */
	public String get_commodity()
	{
		return this.getExternalTradeO1().getCommodity();
	}

	public String get_tradingPeriod()
	{
		return this.getExternalTradeO1().getTradingPeriod();
	}

	public String get_callPut()
	{
		return this.getExternalTradeO1().getCallPut();
	}

	public Double get_strikePrice()
	{
		return this.getExternalTradeO1().getStrikePrice();
	}

	public Double get_quantity()
	{
		return this.getExternalTradeO1().getQuantity();
	}

	public Double get_price()
	{
		return this.getExternalTradeO1().getPrice();
	}

	public String get_exchToolsTradeNum()
	{
		return this.getExternalTradeO1().getExchToolsTradeNum();
	}

	public String get_ictsTradeNum()
	{
		return this.getTradeNum() != null ? this.getTradeNum().toString() : null;
	}

	public String get_ictsPortNum()
	{
		return this.getPortNum() != null ? this.getPortNum().toString() : null;
	}

	public String get_buyingCompany()
	{
		if(this.getExternalTradeO1().getInputAction().trim().equals("BUY"))
			return this.getExternalTradeO1().getInputCompany();
		return this.getExternalTradeO1().getAcceptedCompany();
	}

	public String get_sellingCompany()
	{
		if(this.getExternalTradeO1().getInputAction().trim().equals("BUY"))
			return this.getExternalTradeO1().getAcceptedCompany();
		return this.getExternalTradeO1().getInputCompany();
	}

	public String get_buyingTrader()
	{
		if(this.getExternalTradeO1().getInputAction().trim().equals("BUY"))
			return this.getExternalTradeO1().getInputTrader();
		return this.getExternalTradeO1().getAcceptedTrader();
	}

	public String get_sellingTrader()
	{
		if(this.getExternalTradeO1().getInputAction().trim().equals("BUY"))
			return this.getExternalTradeO1().getAcceptedTrader();
		return this.getExternalTradeO1().getInputTrader();
	}

	public String get_inputBroker()
	{
		if(this.getExternalTradeO1().getInputAction().trim().equals("BUY"))
			return this.getExternalTradeO1().getInputBroker();
		return this.getExternalTradeO1().getAcceptedBroker();
	}

	public String get_buyerClearingBroker()
	{
		return this.getExternalTradeO1().getBuyerClrngBroker();
	}

	public String get_sellerClearingBroker()
	{
		return this.getExternalTradeO1().getSellerClrngBroker();
	}

	public String get_buyerAccount()
	{
		return this.getExternalTradeO1().getBuyerAccount();
	}

	public String get_tradeType()
	{
		return this.getExternalTradeO1().getTradeType();
	}

	public String get_comment()
	{
		return this.getExternalComment() != null ? this.getExternalComment().getCommentText() : null;
	}
}