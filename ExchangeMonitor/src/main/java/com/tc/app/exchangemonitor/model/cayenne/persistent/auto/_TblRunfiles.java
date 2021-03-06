package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _TblRunfiles was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TblRunfiles extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final Property<String> FILE_NAME = new Property<String>("fileName");
	public static final Property<String> FILE_PATH = new Property<String>("filePath");
	public static final Property<Short> ORDEN = new Property<Short>("orden");
	public static final Property<String> START_END = new Property<String>("startEnd");

	public void setFileName(String fileName)
	{
		writeProperty("fileName", fileName);
	}

	public String getFileName()
	{
		return (String) readProperty("fileName");
	}

	public void setFilePath(String filePath)
	{
		writeProperty("filePath", filePath);
	}

	public String getFilePath()
	{
		return (String) readProperty("filePath");
	}

	public void setOrden(Short orden)
	{
		writeProperty("orden", orden);
	}

	public Short getOrden()
	{
		return (Short) readProperty("orden");
	}

	public void setStartEnd(String startEnd)
	{
		writeProperty("startEnd", startEnd);
	}

	public String getStartEnd()
	{
		return (String) readProperty("startEnd");
	}

}
