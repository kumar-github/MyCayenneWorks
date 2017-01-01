package com.tc.app.exchangemonitor.model.cayenne.persistent;

import com.tc.app.exchangemonitor.model.cayenne.persistent.auto._FakeDummySettlePrice;

public class FakeDummySettlePrice extends _FakeDummySettlePrice
{
	private static final long serialVersionUID = 1L;

	public String getTradeOrderItemFillNumString()
	{
		return this.getTradeNum() + "/" + this.getOrderNum() + "/" + this.getItemNum() + "/" + this.getItemFillNum();
	}

	public String getTraderFullName()
	{
		return this.getUserFirstName() + " " + this.getUserLastName();
	}

	public String getBuySellString()
	{
		return this.getPSInd().equals("P") ? "BUY" : "SELL";
	}

	public String getPortNumNameString()
	{
		return this.getRealPortNum() + "-" + this.getPortFullName();
	}
}