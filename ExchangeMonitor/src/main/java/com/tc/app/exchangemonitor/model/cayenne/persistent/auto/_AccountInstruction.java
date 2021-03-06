package com.tc.app.exchangemonitor.model.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountAddress;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountContact;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Commodity;
import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;
import com.tc.app.exchangemonitor.model.cayenne.persistent.AccountInstrType;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ConfirmMethod;
import com.tc.app.exchangemonitor.model.cayenne.persistent.ConfirmTemplate;
import com.tc.app.exchangemonitor.model.cayenne.persistent.DeliveryTerm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Facility;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Mot;
import com.tc.app.exchangemonitor.model.cayenne.persistent.PaymentMethod;
import com.tc.app.exchangemonitor.model.cayenne.persistent.PaymentTerm;
import com.tc.app.exchangemonitor.model.cayenne.persistent.Voucher;

/**
 * Class _AccountInstruction was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AccountInstruction extends CayenneDataObject
{

	private static final long serialVersionUID = 1L;

	public static final String ACCT_INSTR_NUM_PK_COLUMN = "acct_instr_num";
	public static final String ACCT_NUM_PK_COLUMN = "acct_num";

	public static final Property<String> BANK_ACCT_NUM = new Property<>("bankAcctNum");
	public static final Property<Short> NUM_OF_DOC_COPIES = new Property<>("numOfDocCopies");
	public static final Property<String> SEND_DOC_BY_MEDIA = new Property<>("sendDocByMedia");
	public static final Property<Integer> TRANS_ID = new Property<>("transId");
	public static final Property<Account> ACCOUNT = new Property<>("account");
	public static final Property<Account> ACCOUNT1 = new Property<>("account1");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS = new Property<>("accountAddress");
	public static final Property<AccountAddress> ACCOUNT_ADDRESS1 = new Property<>("accountAddress1");
	public static final Property<AccountContact> ACCOUNT_CONTACT = new Property<>("accountContact");
	public static final Property<AccountContact> ACCOUNT_CONTACT1 = new Property<>("accountContact1");
	public static final Property<AccountInstrType> ACCOUNT_INSTR_TYPE = new Property<>("accountInstrType");
	public static final Property<Commodity> COMMODITY = new Property<>("commodity");
	public static final Property<Commodity> COMMODITY1 = new Property<>("commodity1");
	public static final Property<Commodity> COMMODITY2 = new Property<>("commodity2");
	public static final Property<ConfirmMethod> CONFIRM_METHOD_O = new Property<>("confirmMethodO");
	public static final Property<ConfirmTemplate> CONFIRM_TEMPLATE_O = new Property<>("confirmTemplateO");
	public static final Property<DeliveryTerm> DELIVERY_TERM = new Property<>("deliveryTerm");
	public static final Property<List<Facility>> FACILITIES = new Property<>("facilities");
	public static final Property<List<Facility>> FACILITIES1 = new Property<>("facilities1");
	public static final Property<IctsUser> ICTS_USER = new Property<>("ictsUser");
	public static final Property<Mot> MOT = new Property<>("mot");
	public static final Property<PaymentMethod> PAYMENT_METHOD = new Property<>("paymentMethod");
	public static final Property<PaymentTerm> PAYMENT_TERM = new Property<>("paymentTerm");
	public static final Property<List<Voucher>> VOUCHERS = new Property<>("vouchers");
	public static final Property<List<Voucher>> VOUCHERS1 = new Property<>("vouchers1");

	public void setBankAcctNum(final String bankAcctNum)
	{
		this.writeProperty("bankAcctNum", bankAcctNum);
	}

	public String getBankAcctNum()
	{
		return (String) this.readProperty("bankAcctNum");
	}

	public void setNumOfDocCopies(final Short numOfDocCopies)
	{
		this.writeProperty("numOfDocCopies", numOfDocCopies);
	}

	public Short getNumOfDocCopies()
	{
		return (Short) this.readProperty("numOfDocCopies");
	}

	public void setSendDocByMedia(final String sendDocByMedia)
	{
		this.writeProperty("sendDocByMedia", sendDocByMedia);
	}

	public String getSendDocByMedia()
	{
		return (String) this.readProperty("sendDocByMedia");
	}

	public void setTransId(final Integer transId)
	{
		this.writeProperty("transId", transId);
	}

	public Integer getTransId()
	{
		return (Integer) this.readProperty("transId");
	}

	public void setAccount(final Account account)
	{
		this.setToOneTarget("account", account, true);
	}

	public Account getAccount()
	{
		return (Account) this.readProperty("account");
	}

	public void setAccount1(final Account account1)
	{
		this.setToOneTarget("account1", account1, true);
	}

	public Account getAccount1()
	{
		return (Account) this.readProperty("account1");
	}

	public void setAccountAddress(final AccountAddress accountAddress)
	{
		this.setToOneTarget("accountAddress", accountAddress, true);
	}

	public AccountAddress getAccountAddress()
	{
		return (AccountAddress) this.readProperty("accountAddress");
	}

	public void setAccountAddress1(final AccountAddress accountAddress1)
	{
		this.setToOneTarget("accountAddress1", accountAddress1, true);
	}

	public AccountAddress getAccountAddress1()
	{
		return (AccountAddress) this.readProperty("accountAddress1");
	}

	public void setAccountContact(final AccountContact accountContact)
	{
		this.setToOneTarget("accountContact", accountContact, true);
	}

	public AccountContact getAccountContact()
	{
		return (AccountContact) this.readProperty("accountContact");
	}

	public void setAccountContact1(final AccountContact accountContact1)
	{
		this.setToOneTarget("accountContact1", accountContact1, true);
	}

	public AccountContact getAccountContact1()
	{
		return (AccountContact) this.readProperty("accountContact1");
	}

	public void setAccountInstrType(final AccountInstrType accountInstrType)
	{
		this.setToOneTarget("accountInstrType", accountInstrType, true);
	}

	public AccountInstrType getAccountInstrType()
	{
		return (AccountInstrType) this.readProperty("accountInstrType");
	}

	public void setCommodity(final Commodity commodity)
	{
		this.setToOneTarget("commodity", commodity, true);
	}

	public Commodity getCommodity()
	{
		return (Commodity) this.readProperty("commodity");
	}

	public void setCommodity1(final Commodity commodity1)
	{
		this.setToOneTarget("commodity1", commodity1, true);
	}

	public Commodity getCommodity1()
	{
		return (Commodity) this.readProperty("commodity1");
	}

	public void setCommodity2(final Commodity commodity2)
	{
		this.setToOneTarget("commodity2", commodity2, true);
	}

	public Commodity getCommodity2()
	{
		return (Commodity) this.readProperty("commodity2");
	}

	public void setConfirmMethodO(final ConfirmMethod confirmMethodO)
	{
		this.setToOneTarget("confirmMethodO", confirmMethodO, true);
	}

	public ConfirmMethod getConfirmMethodO()
	{
		return (ConfirmMethod) this.readProperty("confirmMethodO");
	}

	public void setConfirmTemplateO(final ConfirmTemplate confirmTemplateO)
	{
		this.setToOneTarget("confirmTemplateO", confirmTemplateO, true);
	}

	public ConfirmTemplate getConfirmTemplateO()
	{
		return (ConfirmTemplate) this.readProperty("confirmTemplateO");
	}

	public void setDeliveryTerm(final DeliveryTerm deliveryTerm)
	{
		this.setToOneTarget("deliveryTerm", deliveryTerm, true);
	}

	public DeliveryTerm getDeliveryTerm()
	{
		return (DeliveryTerm) this.readProperty("deliveryTerm");
	}

	public void addToFacilities(final Facility obj)
	{
		this.addToManyTarget("facilities", obj, true);
	}

	public void removeFromFacilities(final Facility obj)
	{
		this.removeToManyTarget("facilities", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Facility> getFacilities()
	{
		return (List<Facility>) this.readProperty("facilities");
	}

	public void addToFacilities1(final Facility obj)
	{
		this.addToManyTarget("facilities1", obj, true);
	}

	public void removeFromFacilities1(final Facility obj)
	{
		this.removeToManyTarget("facilities1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Facility> getFacilities1()
	{
		return (List<Facility>) this.readProperty("facilities1");
	}

	public void setIctsUser(final IctsUser ictsUser)
	{
		this.setToOneTarget("ictsUser", ictsUser, true);
	}

	public IctsUser getIctsUser()
	{
		return (IctsUser) this.readProperty("ictsUser");
	}

	public void setMot(final Mot mot)
	{
		this.setToOneTarget("mot", mot, true);
	}

	public Mot getMot()
	{
		return (Mot) this.readProperty("mot");
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod)
	{
		this.setToOneTarget("paymentMethod", paymentMethod, true);
	}

	public PaymentMethod getPaymentMethod()
	{
		return (PaymentMethod) this.readProperty("paymentMethod");
	}

	public void setPaymentTerm(final PaymentTerm paymentTerm)
	{
		this.setToOneTarget("paymentTerm", paymentTerm, true);
	}

	public PaymentTerm getPaymentTerm()
	{
		return (PaymentTerm) this.readProperty("paymentTerm");
	}

	public void addToVouchers(final Voucher obj)
	{
		this.addToManyTarget("vouchers", obj, true);
	}

	public void removeFromVouchers(final Voucher obj)
	{
		this.removeToManyTarget("vouchers", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Voucher> getVouchers()
	{
		return (List<Voucher>) this.readProperty("vouchers");
	}

	public void addToVouchers1(final Voucher obj)
	{
		this.addToManyTarget("vouchers1", obj, true);
	}

	public void removeFromVouchers1(final Voucher obj)
	{
		this.removeToManyTarget("vouchers1", obj, true);
	}

	@SuppressWarnings("unchecked")
	public List<Voucher> getVouchers1()
	{
		return (List<Voucher>) this.readProperty("vouchers1");
	}

}
