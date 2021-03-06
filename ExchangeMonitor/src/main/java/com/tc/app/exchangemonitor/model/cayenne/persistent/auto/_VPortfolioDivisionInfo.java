package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _VPortfolioDivisionInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _VPortfolioDivisionInfo extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> DIVISION_CODE = new Property<String>("divisionCode");
	public static final Property<String> DIVISION_DESC = new Property<String>("divisionDesc");
	public static final Property<Integer> REAL_PORT_NUM = new Property<Integer>("realPortNum");

	public void setDivisionCode(String divisionCode)
	{
		writeProperty("divisionCode", divisionCode);
	}

	public String getDivisionCode()
	{
		return (String) readProperty("divisionCode");
	}

	public void setDivisionDesc(String divisionDesc)
	{
		writeProperty("divisionDesc", divisionDesc);
	}

	public String getDivisionDesc()
	{
		return (String) readProperty("divisionDesc");
	}

	public void setRealPortNum(Integer realPortNum)
	{
		writeProperty("realPortNum", realPortNum);
	}

	public Integer getRealPortNum()
	{
		return (Integer) readProperty("realPortNum");
	}

}
