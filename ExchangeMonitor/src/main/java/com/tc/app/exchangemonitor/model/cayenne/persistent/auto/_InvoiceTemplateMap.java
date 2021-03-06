package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _InvoiceTemplateMap was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _InvoiceTemplateMap extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<Integer> BOOKING_COMP = new Property<Integer>("bookingComp");
	public static final Property<String> MOT_TYPE = new Property<String>("motType");
	public static final Property<String> PRICE_IND = new Property<String>("priceInd");
	public static final Property<String> TEMPLATE_NAME = new Property<String>("templateName");
	public static final Property<String> TEMPLATE_TYPE = new Property<String>("templateType");
	public static final Property<String> VOUCHER_TYPE_CODE = new Property<String>("voucherTypeCode");

	public void setBookingComp(Integer bookingComp)
	{
		writeProperty("bookingComp", bookingComp);
	}

	public Integer getBookingComp()
	{
		return (Integer) readProperty("bookingComp");
	}

	public void setMotType(String motType)
	{
		writeProperty("motType", motType);
	}

	public String getMotType()
	{
		return (String) readProperty("motType");
	}

	public void setPriceInd(String priceInd)
	{
		writeProperty("priceInd", priceInd);
	}

	public String getPriceInd()
	{
		return (String) readProperty("priceInd");
	}

	public void setTemplateName(String templateName)
	{
		writeProperty("templateName", templateName);
	}

	public String getTemplateName()
	{
		return (String) readProperty("templateName");
	}

	public void setTemplateType(String templateType)
	{
		writeProperty("templateType", templateType);
	}

	public String getTemplateType()
	{
		return (String) readProperty("templateType");
	}

	public void setVoucherTypeCode(String voucherTypeCode)
	{
		writeProperty("voucherTypeCode", voucherTypeCode);
	}

	public String getVoucherTypeCode()
	{
		return (String) readProperty("voucherTypeCode");
	}

}
