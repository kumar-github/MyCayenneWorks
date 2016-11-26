package com.tc.app.exchangemonitor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Saravana Kumar M
 */
@Entity
@Table(name = "account", catalog = "QA_30_trade_nov22", schema = "dbo", uniqueConstraints = {@UniqueConstraint(columnNames = {"acct_short_name", "acct_type_code"})})
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"), @NamedQuery(name = "Account.findByAcctNum", query = "SELECT a FROM Account a WHERE a.acctNum = :acctNum"), @NamedQuery(name = "Account.findByAcctShortName", query = "SELECT a FROM Account a WHERE a.acctShortName = :acctShortName"), @NamedQuery(name = "Account.findByAcctFullName", query = "SELECT a FROM Account a WHERE a.acctFullName = :acctFullName"), @NamedQuery(name = "Account.findByAcctStatus", query = "SELECT a FROM Account a WHERE a.acctStatus = :acctStatus"), @NamedQuery(name = "Account.findByAcctParentInd", query = "SELECT a FROM Account a WHERE a.acctParentInd = :acctParentInd"), @NamedQuery(name = "Account.findByAcctSubInd", query = "SELECT a FROM Account a WHERE a.acctSubInd = :acctSubInd"), @NamedQuery(name = "Account.findByAcctVatCode", query = "SELECT a FROM Account a WHERE a.acctVatCode = :acctVatCode"), @NamedQuery(name = "Account.findByAcctFiscalCode", query = "SELECT a FROM Account a WHERE a.acctFiscalCode = :acctFiscalCode"), @NamedQuery(name = "Account.findByAcctTypeCode", query = "SELECT a FROM Account a WHERE a.acctStatus = 'A' and a.acctTypeCode = :acctTypeCode"), @NamedQuery(name = "Account.findByAcctSubTypeCode", query = "SELECT a FROM Account a WHERE a.acctSubTypeCode = :acctSubTypeCode"), @NamedQuery(name = "Account.findByTransId", query = "SELECT a FROM Account a WHERE a.transId = :transId"), @NamedQuery(name = "Account.findByManInputSecQtyRequired", query = "SELECT a FROM Account a WHERE a.manInputSecQtyRequired = :manInputSecQtyRequired"), @NamedQuery(name = "Account.findByLegalEntityNum", query = "SELECT a FROM Account a WHERE a.legalEntityNum = :legalEntityNum"), @NamedQuery(name = "Account.findByGovtCode", query = "SELECT a FROM Account a WHERE a.govtCode = :govtCode"), @NamedQuery(name = "Account.findByAllowsNetout", query = "SELECT a FROM Account a WHERE a.allowsNetout = :allowsNetout"), @NamedQuery(name = "Account.findByAllowsBookout", query = "SELECT a FROM Account a WHERE a.allowsBookout = :allowsBookout"), @NamedQuery(name = "Account.findByMasterAgreementDate", query = "SELECT a FROM Account a WHERE a.masterAgreementDate = :masterAgreementDate")})

public class Account implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "acct_num", nullable = false)
	private Integer acctNum;

	@Basic(optional = false)
	@Column(name = "acct_short_name", nullable = false, length = 15, columnDefinition = "NVARCHAR")
	private String acctShortName;

	@Basic(optional = false)
	@Column(name = "acct_full_name", nullable = false, length = 255, columnDefinition = "NVARCHAR")
	private String acctFullName;
	@Basic(optional = false)
	@Column(name = "acct_status", nullable = false)
	private Character acctStatus;
	@Basic(optional = false)
	@Column(name = "acct_parent_ind", nullable = false)
	private Character acctParentInd;
	@Basic(optional = false)
	@Column(name = "acct_sub_ind", nullable = false)
	private Character acctSubInd;
	@Column(name = "acct_vat_code", length = 11)
	private String acctVatCode;
	@Column(name = "acct_fiscal_code", length = 16)
	private String acctFiscalCode;

	@Column(name = "acct_sub_type_code", length = 8, columnDefinition = "CHAR")
	private String acctSubTypeCode;

	@Basic(optional = false)
	@Column(name = "trans_id", nullable = false)
	private int transId;
	@Column(name = "man_input_sec_qty_required")
	private Character manInputSecQtyRequired;
	@Column(name = "legal_entity_num")
	private Integer legalEntityNum;
	@Column(name = "govt_code", length = 50)
	private String govtCode;
	@Basic(optional = false)
	@Column(name = "allows_netout", nullable = false)
	private boolean allowsNetout;
	@Basic(optional = false)
	@Column(name = "allows_bookout", nullable = false)
	private boolean allowsBookout;
	@Column(name = "master_agreement_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date masterAgreementDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "acctNum", fetch = FetchType.LAZY)
	private Collection<AccountAgreement> accountAgreementCollection;
	@OneToMany(mappedBy = "targetBookCompNum", fetch = FetchType.LAZY)
	private Collection<AccountAgreement> accountAgreementCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
	private Collection<AccountContact> accountContactCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
	private Collection<AccountAddress> accountAddressCollection;

	@JoinColumn(name = "acct_type_code", referencedColumnName = "acct_type_code", nullable = false, columnDefinition = "CHAR")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	//@ManyToOne(optional = false, fetch = FetchType.EAGER)
	/* The below code added to solve "org.hibernate.LazyInitializationException: could not initialize proxy - no Session"
	 * 3 ways to solve the problem.
	 * solution1: add the below property and set the value to true
	 * solution2: change the fetch type from LAZY to EAGER for the particular property. In our case it is acctTypeCode from Account class.
	 * solution3: otherwise once the main object(Account) is fetched, loop through each object and call Hibernate.initialize(accountObject.getAcctTypeCode)
	 */
	private AccountType acctTypeCode;

	@JoinColumn(name = "contract_cmnt_num", referencedColumnName = "cmnt_num")
	@ManyToOne(fetch = FetchType.LAZY)
	private Comment contractCmntNum;

	@JoinColumn(name = "risk_transfer_ind_code", referencedColumnName = "risk_transfer_ind_code", columnDefinition = "CHAR")
	@ManyToOne(fetch = FetchType.LAZY)
	private RiskTransferIndicator riskTransferIndCode;

	public Account()
	{
	}

	public Account(final Integer acctNum)
	{
		this.acctNum = acctNum;
	}

	public Account(final Integer acctNum, final String acctShortName, final String acctFullName, final Character acctStatus, final Character acctParentInd, final Character acctSubInd, final int transId, final boolean allowsNetout, final boolean allowsBookout)
	{
		this.acctNum = acctNum;
		this.acctShortName = acctShortName;
		this.acctFullName = acctFullName;
		this.acctStatus = acctStatus;
		this.acctParentInd = acctParentInd;
		this.acctSubInd = acctSubInd;
		this.transId = transId;
		this.allowsNetout = allowsNetout;
		this.allowsBookout = allowsBookout;
	}

	public Integer getAcctNum()
	{
		return this.acctNum;
	}

	public void setAcctNum(final Integer acctNum)
	{
		this.acctNum = acctNum;
	}

	public String getAcctShortName()
	{
		return this.acctShortName;
	}

	public void setAcctShortName(final String acctShortName)
	{
		this.acctShortName = acctShortName;
	}

	public String getAcctFullName()
	{
		return this.acctFullName;
	}

	public void setAcctFullName(final String acctFullName)
	{
		this.acctFullName = acctFullName;
	}

	public Character getAcctStatus()
	{
		return this.acctStatus;
	}

	public void setAcctStatus(final Character acctStatus)
	{
		this.acctStatus = acctStatus;
	}

	public Character getAcctParentInd()
	{
		return this.acctParentInd;
	}

	public void setAcctParentInd(final Character acctParentInd)
	{
		this.acctParentInd = acctParentInd;
	}

	public Character getAcctSubInd()
	{
		return this.acctSubInd;
	}

	public void setAcctSubInd(final Character acctSubInd)
	{
		this.acctSubInd = acctSubInd;
	}

	public String getAcctVatCode()
	{
		return this.acctVatCode;
	}

	public void setAcctVatCode(final String acctVatCode)
	{
		this.acctVatCode = acctVatCode;
	}

	public String getAcctFiscalCode()
	{
		return this.acctFiscalCode;
	}

	public void setAcctFiscalCode(final String acctFiscalCode)
	{
		this.acctFiscalCode = acctFiscalCode;
	}

	public String getAcctSubTypeCode()
	{
		return this.acctSubTypeCode;
	}

	public void setAcctSubTypeCode(final String acctSubTypeCode)
	{
		this.acctSubTypeCode = acctSubTypeCode;
	}

	public int getTransId()
	{
		return this.transId;
	}

	public void setTransId(final int transId)
	{
		this.transId = transId;
	}

	public Character getManInputSecQtyRequired()
	{
		return this.manInputSecQtyRequired;
	}

	public void setManInputSecQtyRequired(final Character manInputSecQtyRequired)
	{
		this.manInputSecQtyRequired = manInputSecQtyRequired;
	}

	public Integer getLegalEntityNum()
	{
		return this.legalEntityNum;
	}

	public void setLegalEntityNum(final Integer legalEntityNum)
	{
		this.legalEntityNum = legalEntityNum;
	}

	public String getGovtCode()
	{
		return this.govtCode;
	}

	public void setGovtCode(final String govtCode)
	{
		this.govtCode = govtCode;
	}

	public boolean getAllowsNetout()
	{
		return this.allowsNetout;
	}

	public void setAllowsNetout(final boolean allowsNetout)
	{
		this.allowsNetout = allowsNetout;
	}

	public boolean getAllowsBookout()
	{
		return this.allowsBookout;
	}

	public void setAllowsBookout(final boolean allowsBookout)
	{
		this.allowsBookout = allowsBookout;
	}

	public Date getMasterAgreementDate()
	{
		return this.masterAgreementDate;
	}

	public void setMasterAgreementDate(final Date masterAgreementDate)
	{
		this.masterAgreementDate = masterAgreementDate;
	}

	@XmlTransient
	public Collection<AccountAgreement> getAccountAgreementCollection()
	{
		return this.accountAgreementCollection;
	}

	public void setAccountAgreementCollection(final Collection<AccountAgreement> accountAgreementCollection)
	{
		this.accountAgreementCollection = accountAgreementCollection;
	}

	@XmlTransient
	public Collection<AccountAgreement> getAccountAgreementCollection1()
	{
		return this.accountAgreementCollection1;
	}

	public void setAccountAgreementCollection1(final Collection<AccountAgreement> accountAgreementCollection1)
	{
		this.accountAgreementCollection1 = accountAgreementCollection1;
	}

	@XmlTransient
	public Collection<AccountContact> getAccountContactCollection()
	{
		return this.accountContactCollection;
	}

	public void setAccountContactCollection(final Collection<AccountContact> accountContactCollection)
	{
		this.accountContactCollection = accountContactCollection;
	}

	@XmlTransient
	public Collection<AccountAddress> getAccountAddressCollection()
	{
		return this.accountAddressCollection;
	}

	public void setAccountAddressCollection(final Collection<AccountAddress> accountAddressCollection)
	{
		this.accountAddressCollection = accountAddressCollection;
	}

	public AccountType getAcctTypeCode()
	{
		return this.acctTypeCode;
	}

	public void setAcctTypeCode(final AccountType acctTypeCode)
	{
		this.acctTypeCode = acctTypeCode;
	}

	public Comment getContractCmntNum()
	{
		return this.contractCmntNum;
	}

	public void setContractCmntNum(final Comment contractCmntNum)
	{
		this.contractCmntNum = contractCmntNum;
	}

	public RiskTransferIndicator getRiskTransferIndCode()
	{
		return this.riskTransferIndCode;
	}

	public void setRiskTransferIndCode(final RiskTransferIndicator riskTransferIndCode)
	{
		this.riskTransferIndCode = riskTransferIndCode;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (this.acctNum != null ? this.acctNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(final Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if(!(object instanceof Account))
			return false;
		final Account other = (Account) object;
		if(((this.acctNum == null) && (other.acctNum != null)) || ((this.acctNum != null) && !this.acctNum.equals(other.acctNum)))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return this.acctNum + " <--> " + this.acctShortName;
	}
}