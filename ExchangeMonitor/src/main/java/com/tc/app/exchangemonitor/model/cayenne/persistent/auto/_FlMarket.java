package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _FlMarket was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _FlMarket extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ID_MARKET_PK_COLUMN = "IdMarket";

	public static final Property<String> MARKET_DESCRIPTION = new Property<String>("marketDescription");
	public static final Property<String> MARKET_NAME = new Property<String>("marketName");

	public void setMarketDescription(String marketDescription)
	{
		writeProperty("marketDescription", marketDescription);
	}

	public String getMarketDescription()
	{
		return (String) readProperty("marketDescription");
	}

	public void setMarketName(String marketName)
	{
		writeProperty("marketName", marketName);
	}

	public String getMarketName()
	{
		return (String) readProperty("marketName");
	}

}
