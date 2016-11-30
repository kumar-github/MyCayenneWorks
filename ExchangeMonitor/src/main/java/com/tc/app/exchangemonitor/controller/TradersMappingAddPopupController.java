/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 17, 2016
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class TradersMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger(TradersMappingAddPopupController.class);

	@FXML
	private Label titleLabel;
	@FXML
	private TextField externalSourceTraderTextField;
	@FXML
	private ComboBox<IctsUser> ictsTraderComboBox;
	@FXML
	private Button saveButton;
	@FXML
	private Button cancelButton;

	private final ObservableList<IctsUser> observableIctsTradersList = FXCollections.observableArrayList();

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.setAnyUIComponentStateIfNeeded();
	}

	@Override
	public void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(TradersMappingAddPopupController.class, this);
	}

	@Override
	public void doAssertion()
	{
		assert this.externalSourceTraderTextField != null : "fx:id=\"externalSourceTraderTextField\" was not injected. Check your FXML file TradersMappingAddPopupView.fxml";
	}

	@Override
	public void doInitialDataBinding()
	{
		this.ictsTraderComboBox.setItems(this.observableIctsTradersList);
		this.saveButton.disableProperty().bind(this.externalSourceTraderTextField.textProperty().isEmpty().or(this.ictsTraderComboBox.valueProperty().isNull()));
	}

	@Override
	public void initializeGUI()
	{
		this.fetchIctsTraders();
	}

	@Override
	public void setAnyUIComponentStateIfNeeded()
	{
		/* Actually, the focus should be set on the first input field so that user can start typing the data. But, we set the "Prompt Text" on the text fields and
		 * if the focus is set then the prompt text won't be visible and user should move to some other field and come back to know what text field is this.
		 */
		Platform.runLater(() -> this.titleLabel.requestFocus());
	}

	@Override
	public void createListeners()
	{
	}

	@Override
	public void attachListeners()
	{
	}

	private void fetchIctsTraders()
	{
		//this.observableIctsTradersList.clear();
		//this.observableIctsTradersList.addAll(ReferenceDataCache.fetchAllActiveIctsUsers().values());

		this.observableIctsTradersList.clear();
		this.observableIctsTradersList.addAll(this.filter(CayenneReferenceDataCache.fetchAllActiveIctsUsers().values(), (final IctsUser anIctsUser) -> anIctsUser.getUserJobTitle().getUserJobTitle().trim().equals("TRADER")));
		LOGGER.debug("Traders Count : " + this.observableIctsTradersList.size());

		/*
		final Session session = HibernateUtil.beginTransaction();
		final Criteria criteria = session.createCriteria(com.tc.app.exchangemonitor.model.IctsUser.class);
		criteria.add(Restrictions.eq("userStatus", 'A'));
		criteria.add(Restrictions.eq("userJobTitle.jobTitle", "TRADER"));
		final long startTime = System.currentTimeMillis();
		this.observableIctsTraderList.clear();
		this.observableIctsTraderList.addAll(criteria.list());
		final long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		session.close();
		 */
	}

	/*
	private void saveTraderMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);
		final String externalSourceTrader = this.externalSourceTraderTextField.getText().trim().toUpperCase();
		final String ictsTrader = this.ictsTraderComboBox.getSelectionModel().getSelectedItem().getUserInit();
		Session session = null;
		//final boolean doesTraderMappingExistsAlready = this.doesTraderMappingExistsAlready(externalTradeSourceOid, externalSourceTrader, ictsTrader);
		final boolean doesTraderMappingExistsAlready = false;

		try
		{
			if(!doesTraderMappingExistsAlready)
			{
				session = HibernateUtil.beginTransaction();
				final Integer transid = HibernateReferenceDataFetchUtil.generateNewTransaction();
				final Integer newNum = HibernateReferenceDataFetchUtil.generateNewNum();
				session.getNamedQuery("InsertNewMapping").setParameter("oidParam", newNum).setParameter("externalTradeSourceOidParam", externalTradeSourceOid).setParameter("mappingTypeParam", TRADER_MAPPING_TYPE).setParameter("externalValue1Param", externalSourceTrader).setParameter("externalValue2Param", null).setParameter("externalValue3Param", null).setParameter("externalValue4Param", null).setParameter("aliasValueParam", ictsTrader).setParameter("transIdParam", transid).executeUpdate();
				session.getTransaction().commit();
				LOGGER.info("Mapping Saved Successfully.");
			}
			else
			{
				LOGGER.error("Mapping Already Exists!");
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Save Failed." + exception);
			session.getTransaction().rollback();
			throw new RuntimeException("Save Failed.", exception);
		}
		finally
		{
			if((session != null) && session.isOpen())
			{
				if((session.getTransaction() != null) && (session.getTransaction().getStatus() == TransactionStatus.ACTIVE))
				{
					session.getTransaction().commit();//This is mandatory - to avoid DB locking
					//session.close();
				}
			}
		}
	}
	 */

	/*
	private boolean doesTraderMappingExistsAlready(final Integer externalTradeSourceOid, final String externalSourceTrader, final String ictsTrader)
	{
		boolean doesExists = false;
		Session session = null;
		List aMapping = null;

		try
		{
			session = HibernateUtil.beginTransaction();
			aMapping = session.getNamedQuery("DoesMappingExists").setParameter("externalTradeSourceOidParam", externalTradeSourceOid).setParameter("mappingTypeParam", TRADER_MAPPING_TYPE).setParameter("externalValue1Param", externalSourceTrader).setParameter("externalValue2Param", null).setParameter("externalValue3Param", null).setParameter("externalValue4Param", null).list();
			System.out.println(aMapping);
			doesExists = (aMapping.size() == 0) ? false : true;
		}
		catch(final Exception exception)
		{
		}
		finally
		{
			session.close();
		}

		return doesExists;
	}
	 */

	@FXML
	private void handleSaveButtonClick()
	{
		//this.saveTraderMapping();
	}

	@FXML
	private void handleCancelButtonClick()
	{
		((Stage) this.cancelButton.getScene().getWindow()).close();
	}
}