package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _ReportMenuData was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ReportMenuData extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_REC_ID_PK_COLUMN = "fldchrRecId";

	public static final Property<String> FLDCHR_PACKAGE_NAME = new Property<String>("fldchrPackageName");
	public static final Property<String> FLDCHR_REPORT_ADMIN_DEFAULT_FLAG = new Property<String>("fldchrReportAdminDefaultFlag");
	public static final Property<String> FLDCHR_REPORT_CONFIG = new Property<String>("fldchrReportConfig");
	public static final Property<String> FLDCHR_REPORT_CONFIG_NAME = new Property<String>("fldchrReportConfigName");
	public static final Property<String> FLDCHR_REPORT_NAME = new Property<String>("fldchrReportName");
	public static final Property<Integer> FLDINT_REPORT_REC_ID = new Property<Integer>("fldintReportRecId");
	public static final Property<String> USER_INIT = new Property<String>("userInit");

	public void setFldchrPackageName(String fldchrPackageName)
	{
		writeProperty("fldchrPackageName", fldchrPackageName);
	}

	public String getFldchrPackageName()
	{
		return (String) readProperty("fldchrPackageName");
	}

	public void setFldchrReportAdminDefaultFlag(String fldchrReportAdminDefaultFlag)
	{
		writeProperty("fldchrReportAdminDefaultFlag", fldchrReportAdminDefaultFlag);
	}

	public String getFldchrReportAdminDefaultFlag()
	{
		return (String) readProperty("fldchrReportAdminDefaultFlag");
	}

	public void setFldchrReportConfig(String fldchrReportConfig)
	{
		writeProperty("fldchrReportConfig", fldchrReportConfig);
	}

	public String getFldchrReportConfig()
	{
		return (String) readProperty("fldchrReportConfig");
	}

	public void setFldchrReportConfigName(String fldchrReportConfigName)
	{
		writeProperty("fldchrReportConfigName", fldchrReportConfigName);
	}

	public String getFldchrReportConfigName()
	{
		return (String) readProperty("fldchrReportConfigName");
	}

	public void setFldchrReportName(String fldchrReportName)
	{
		writeProperty("fldchrReportName", fldchrReportName);
	}

	public String getFldchrReportName()
	{
		return (String) readProperty("fldchrReportName");
	}

	public void setFldintReportRecId(Integer fldintReportRecId)
	{
		writeProperty("fldintReportRecId", fldintReportRecId);
	}

	public Integer getFldintReportRecId()
	{
		return (Integer) readProperty("fldintReportRecId");
	}

	public void setUserInit(String userInit)
	{
		writeProperty("userInit", userInit);
	}

	public String getUserInit()
	{
		return (String) readProperty("userInit");
	}

}
