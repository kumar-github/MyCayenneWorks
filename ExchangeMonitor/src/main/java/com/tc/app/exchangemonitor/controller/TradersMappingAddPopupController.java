/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 17, 2016
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.cayenne.query.MappedExec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.model.cayenne.persistent.IctsUser;
import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataFetchUtil;
import com.tc.app.exchangemonitor.viewmodel.ExternalMappingTradersViewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Saravana Kumar M
 *
 */
public class TradersMappingAddPopupController implements IGenericController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String TRADER_MAPPING_TYPE = "T";

	@Inject
	private ExternalMappingTradersViewModel externalMappingTradersViewModel;

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

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.initializeGUI();
		this.setAnyUIComponentStateIfNeeded();
		this.createListeners();
		this.attachListeners();
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
		this.externalSourceTraderTextField.textProperty().addListener((observable, oldValue, newValue) -> this.convertToUpperCase(this.externalSourceTraderTextField, newValue));
	}

	private void convertToUpperCase(final TextField aTextField, final String newValue)
	{
		aTextField.setText(newValue.toUpperCase());
	}

	private void fetchIctsTraders()
	{
		this.observableIctsTradersList.clear();
		this.observableIctsTradersList.addAll(this.filter(CayenneReferenceDataCache.loadAllActiveIctsUsers().values(), (final IctsUser anIctsUser) -> anIctsUser.getUserJobTitle().getUserJobTitle().trim().equals("TRADER")));
		LOGGER.debug("Traders Count : {}", this.observableIctsTradersList.size());

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
		this.saveTraderMapping();
	}

	@FXML
	private void handleCancelButtonClick()
	{
		this.closePopup();
	}

	private void closePopup()
	{
		((Stage) this.cancelButton.getScene().getWindow()).close();
	}

	private void saveTraderMapping()
	{
		final String externalTradeSourceName = ((RadioButton) ExternalTradeSourceRadioCellForMappingsTab.toggleGroup.getSelectedToggle()).getText();
		final Integer externalTradeSourceOid = this.getOidForExternalSourceName(externalTradeSourceName);

		final String externalSourceTrader = this.externalSourceTraderTextField.getText().trim();
		final String ictsTrader = this.ictsTraderComboBox.getSelectionModel().getSelectedItem().getUserInit();

		//final boolean doesTraderMappingExistsAlready = this.doesTraderMappingExistsAlready(externalTradeSourceOid, externalSourceTrader, ictsTrader);
		final boolean doesTraderMappingExistsAlready = false;

		try
		{
			if(!doesTraderMappingExistsAlready)
			{
				final MappedExec insertMappingQuery = CayenneReferenceDataFetchUtil.getNonSelectQueryForName("InsertMapping");
				insertMappingQuery.param("oidParam", CayenneReferenceDataFetchUtil.generateNewNum());
				insertMappingQuery.param("externalTradeSourceOidParam", externalTradeSourceOid);
				insertMappingQuery.param("mappingTypeParam", TRADER_MAPPING_TYPE);
				insertMappingQuery.param("externalValue1Param", externalSourceTrader);
				insertMappingQuery.param("externalValue2Param", null);
				insertMappingQuery.param("externalValue3Param", null);
				insertMappingQuery.param("externalValue4Param", null);
				insertMappingQuery.param("aliasValueParam", ictsTrader);
				insertMappingQuery.param("transIdParam", CayenneReferenceDataFetchUtil.generateNewTransaction());
				insertMappingQuery.execute(CayenneHelper.getCayenneServerRuntime().newContext());

				/*
				final ObjectContext context = CayenneHelper.getCayenneServerRuntime().newContext();
				final ExternalTradeSource tempSource = SelectById.query(ExternalTradeSource.class, 1).selectOne(context);
				final ExternalMapping newExternalMapping = context.newObject(ExternalMapping.class);
				newExternalMapping.setOid(newNum);
				newExternalMapping.setExternalTradeSourceO(tempSource);
				newExternalMapping.setMappingType(TRADER_MAPPING_TYPE);
				newExternalMapping.setExternalValue1(null);
				newExternalMapping.setExternalValue2(null);
				newExternalMapping.setExternalValue3(null);
				newExternalMapping.setExternalValue4(null);
				newExternalMapping.setAliasValue(ictsTrader);
				newExternalMapping.setTransId(transid);
				context.commitChanges();
				 */
				LOGGER.info("Mapping Saved Successfully.");
				this.closePopup();
				this.refreshExternalMappingTradersTableView();
			}
			else
			{
				LOGGER.error("Mapping Already Exists!");
			}
		}
		catch(final Exception exception)
		{
			LOGGER.error("Save Failed.", exception);
			throw new RuntimeException("Save Failed.", exception);
		}
		finally
		{
		}
	}

	private Integer getOidForExternalSourceName(final String externalTradeSourceName)
	{
		return CayenneReferenceDataCache.loadExternalTradeSources().get(externalTradeSourceName).getExternalTradeSourceOid();
	}

	private void refreshExternalMappingTradersTableView()
	{
		LOGGER.debug("ExternalMappingTradersViewModel Instance {}", this.externalMappingTradersViewModel);
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().clear();
		this.externalMappingTradersViewModel.getExternalMappingTradersObservableList().addAll(CayenneReferenceDataCache.reloadExternalMappings());
	}
}