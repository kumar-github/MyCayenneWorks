package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.util.StaticConstantsHelper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

public class PreferencesController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	@FXML
	private CheckBox resetCredentialsCheckBox;
	@FXML
	private CheckBox displayAccountsWithPermissionCheckBox;
	@FXML
	private CheckBox enableRowColorsCheckBox;
	@FXML
	private CheckBox enableRowToolTipsCheckBox;
	@FXML
	private CheckBox enableRowContextMenuCheckBox;

	public PreferencesController()
	{
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.syncPreferencesScreenWithRegistryData();
	}

	private void syncPreferencesScreenWithRegistryData()
	{
		this.displayAccountsWithPermissionCheckBox.setSelected(PreferencesHelper.getUserPreferences().getBoolean(StaticConstantsHelper.SHOULD_DISPLAY_ACCOUNTS_WITH_PERMISSION, false));
		this.enableRowColorsCheckBox.setSelected(PreferencesHelper.getUserPreferences().getBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_COLORS, true));
		this.enableRowToolTipsCheckBox.setSelected(PreferencesHelper.getUserPreferences().getBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_TOOLTIPS, true));
	}

	@FXML
	public void handleResetCredentialsCheckBoxClick(final ActionEvent event)
	{
		final CheckBox sourceCheckBox = ((CheckBox) event.getSource());
		if(sourceCheckBox.isSelected())
		{
			try
			{
				//PreferencesHelper.getUserPreferences().clear();
				PreferencesHelper.forgetLoginCredentials();
				LOGGER.info("Credentials reset successfully.");
			}
			catch(final Exception exception)
			{
				exception.printStackTrace();
			}
		}
		else
		{
		}
	}

	@FXML
	public void handleDisplayAccountsWithPermissionCheckBoxClick(final ActionEvent event)
	{
		final CheckBox sourceCheckBox = ((CheckBox) event.getSource());
		try
		{
			if(sourceCheckBox.isSelected())
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_DISPLAY_ACCOUNTS_WITH_PERMISSION, true);
				LOGGER.info("Hereafter, Only Accounts with permission will be displayed.");
			}
			else
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_DISPLAY_ACCOUNTS_WITH_PERMISSION, false);
				LOGGER.info("Hereafter, All Accounts will be displayed.");
			}
		}
		catch(final Exception exception)
		{
			exception.printStackTrace();
		}
	}

	@FXML
	public void handleEnableRowColorsCheckBoxClick(final ActionEvent event)
	{
		final CheckBox sourceCheckBox = ((CheckBox) event.getSource());
		try
		{
			if(sourceCheckBox.isSelected())
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_COLORS, true);
				LOGGER.info("Hereafter, Row Colors will be enabled. Records with different status will be displayed in different colors.");
			}
			else
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_COLORS, false);
				LOGGER.info("Hereafter, Row Colors will be disabled.");
			}
		}
		catch(final Exception exception)
		{
			exception.printStackTrace();
		}
	}

	@FXML
	public void handleEnableRowToolTipsCheckBoxClick(final ActionEvent event)
	{
		final CheckBox sourceCheckBox = ((CheckBox) event.getSource());
		try
		{
			if(sourceCheckBox.isSelected())
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_TOOLTIPS, true);
				LOGGER.info("Hereafter, Row ToolTips will be enabled. You will see few informations of the trade as a tooltip.");
			}
			else
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_TOOLTIPS, false);
				LOGGER.info("Hereafter, Row ToolTips will be disabled.");
			}
		}
		catch(final Exception exception)
		{
			exception.printStackTrace();
		}
	}

	@FXML
	public void handleEnableRowContextMenuCheckBoxClick(final ActionEvent event)
	{
		final CheckBox sourceCheckBox = ((CheckBox) event.getSource());
		try
		{
			if(sourceCheckBox.isSelected())
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_CONTEXT_MENU, true);
				LOGGER.info("Hereafter, Row context menu will be enabled. Right click on a record will give you few menu options.");
			}
			else
			{
				PreferencesHelper.getUserPreferences().putBoolean(StaticConstantsHelper.SHOULD_ENABLE_ROW_CONTEXT_MENU, false);
				LOGGER.info("Hereafter, Row context menu will be disabled.");
			}
		}
		catch(final Exception exception)
		{
			exception.printStackTrace();
		}
	}
}