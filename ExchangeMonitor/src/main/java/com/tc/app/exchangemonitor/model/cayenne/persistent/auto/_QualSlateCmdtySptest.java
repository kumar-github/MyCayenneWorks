package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.QualitySlate;
import com.tc.app.exchangemonitor.model.cayenne.persistent.SpecTest;

/**
 * Class _QualSlateCmdtySptest was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _QualSlateCmdtySptest extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String OID_PK_COLUMN = "oid";

	public static final Property<Boolean> IS_DEFAULT_TEST = new Property<Boolean>("isDefaultTest");
	public static final Property<Integer> TRANS_ID = new Property<Integer>("transId");
	public static final Property<QualitySlate> QUALITY_SLATE = new Property<QualitySlate>("qualitySlate");
	public static final Property<SpecTest> SPEC_TEST = new Property<SpecTest>("specTest");
	public static final Property<SpecTest> SPEC_TEST1 = new Property<SpecTest>("specTest1");
	public static final Property<SpecTest> SPEC_TEST2 = new Property<SpecTest>("specTest2");

	public void setIsDefaultTest(Boolean isDefaultTest)
	{
		writeProperty("isDefaultTest", isDefaultTest);
	}

	public Boolean getIsDefaultTest()
	{
		return (Boolean) readProperty("isDefaultTest");
	}

	public void setTransId(Integer transId)
	{
		writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) readProperty("transId");
	}

	public void setQualitySlate(QualitySlate qualitySlate)
	{
		setToOneTarget("qualitySlate", qualitySlate, true);
	}

	public QualitySlate getQualitySlate()
	{
		return (QualitySlate) readProperty("qualitySlate");
	}

	public void setSpecTest(SpecTest specTest)
	{
		setToOneTarget("specTest", specTest, true);
	}

	public SpecTest getSpecTest()
	{
		return (SpecTest) readProperty("specTest");
	}

	public void setSpecTest1(SpecTest specTest1)
	{
		setToOneTarget("specTest1", specTest1, true);
	}

	public SpecTest getSpecTest1()
	{
		return (SpecTest) readProperty("specTest1");
	}

	public void setSpecTest2(SpecTest specTest2)
	{
		setToOneTarget("specTest2", specTest2, true);
	}

	public SpecTest getSpecTest2()
	{
		return (SpecTest) readProperty("specTest2");
	}

}
