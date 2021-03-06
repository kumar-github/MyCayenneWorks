package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Mot;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ParcelQualitySlate;
import com.tc.app.exchangemonitor.model.cayenne.persistent.QualSlateCmdtySptest;

/**
 * Class _QualitySlate was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _QualitySlate extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<String> CODE = new Property<String>("code");
	public static final Property<String> DESCRIPTION = new Property<String>("description");
	public static final Property<Boolean> IS_DEFAULT_SLATE = new Property<Boolean>("isDefaultSlate");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<Mot> MOT = new Property<Mot>("mot");
	public static final Property<List<ParcelQualitySlate>> PARCEL_QUALITY_SLATES = new Property<List<ParcelQualitySlate>>("parcelQualitySlates");
	public static final Property<List<QualSlateCmdtySptest>> QUAL_SLATE_CMDTY_SPTESTS = new Property<List<QualSlateCmdtySptest>>("qualSlateCmdtySptests");

	public void setCode(String code)
	{
		writeProperty("code", code);
	}

	public String getCode()
	{
		return (String) readProperty("code");
	}

	public void setDescription(String description)
	{
		writeProperty("description", description);
	}

	public String getDescription()
	{
		return (String) readProperty("description");
	}

	public void setIsDefaultSlate(Boolean isDefaultSlate)
	{
		writeProperty("isDefaultSlate", isDefaultSlate);
	}

	public Boolean getIsDefaultSlate()
	{
		return (Boolean) readProperty("isDefaultSlate");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setMot(Mot mot)
	{
		setToOneTarget("mot", mot, true);
	}

	public Mot getMot()
	{
		return (Mot) readProperty("mot");
	}

	public void addToParcelQualitySlates(ParcelQualitySlate obj)
	{
		addToManyTarget("parcelQualitySlates", obj, true);
	}

	public void removeFromParcelQualitySlates(ParcelQualitySlate obj)
	{
		removeToManyTarget("parcelQualitySlates", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<ParcelQualitySlate> getParcelQualitySlates()
	{
		return (List<ParcelQualitySlate>) readProperty("parcelQualitySlates");
	}

	public void addToQualSlateCmdtySptests(QualSlateCmdtySptest obj)
	{
		addToManyTarget("qualSlateCmdtySptests", obj, true);
	}

	public void removeFromQualSlateCmdtySptests(QualSlateCmdtySptest obj)
	{
		removeToManyTarget("qualSlateCmdtySptests", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<QualSlateCmdtySptest> getQualSlateCmdtySptests()
	{
		return (List<QualSlateCmdtySptest>) readProperty("qualSlateCmdtySptests");
	}

}
