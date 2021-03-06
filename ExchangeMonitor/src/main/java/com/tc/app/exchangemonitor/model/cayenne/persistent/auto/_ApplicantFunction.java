package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ApplicantFunctionCounter;

/**
 * Class _ApplicantFunction was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ApplicantFunction extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String FLDCHR_APPLICANT_FUNC_CODE_PK_COLUMN = "fldchrApplicantFuncCode";

	public static final Property<String> FLDCHR_APPLICANT_ENABLED_FLAG = new Property<String>("fldchrApplicantEnabledFlag");
	public static final Property<String> FLDCHR_APPLICANT_FIXTURE_CODE = new Property<String>("fldchrApplicantFixtureCode");
	public static final Property<String> FLDCHR_APPLICANT_FUNC_DESC = new Property<String>("fldchrApplicantFuncDesc");
	public static final Property<List<ApplicantFunctionCounter>> APPLICANT_FUNCTION_COUNTERS = new Property<List<ApplicantFunctionCounter>>("applicantFunctionCounters");

	public void setFldchrApplicantEnabledFlag(String fldchrApplicantEnabledFlag)
	{
		writeProperty("fldchrApplicantEnabledFlag", fldchrApplicantEnabledFlag);
	}

	public String getFldchrApplicantEnabledFlag()
	{
		return (String) readProperty("fldchrApplicantEnabledFlag");
	}

	public void setFldchrApplicantFixtureCode(String fldchrApplicantFixtureCode)
	{
		writeProperty("fldchrApplicantFixtureCode", fldchrApplicantFixtureCode);
	}

	public String getFldchrApplicantFixtureCode()
	{
		return (String) readProperty("fldchrApplicantFixtureCode");
	}

	public void setFldchrApplicantFuncDesc(String fldchrApplicantFuncDesc)
	{
		writeProperty("fldchrApplicantFuncDesc", fldchrApplicantFuncDesc);
	}

	public String getFldchrApplicantFuncDesc()
	{
		return (String) readProperty("fldchrApplicantFuncDesc");
	}

	public void addToApplicantFunctionCounters(ApplicantFunctionCounter obj)
	{
		addToManyTarget("applicantFunctionCounters", obj, true);
	}

	public void removeFromApplicantFunctionCounters(ApplicantFunctionCounter obj)
	{
		removeToManyTarget("applicantFunctionCounters", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<ApplicantFunctionCounter> getApplicantFunctionCounters()
	{
		return (List<ApplicantFunctionCounter>) readProperty("applicantFunctionCounters");
	}

}
