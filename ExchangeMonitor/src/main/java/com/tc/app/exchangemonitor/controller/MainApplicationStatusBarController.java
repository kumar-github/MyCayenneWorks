package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.StatusBar;

import com.tc.app.exchangemonitor.util.ApplicationHelper;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainApplicationStatusBarController implements Initializable
{
	@FXML
	private StatusBar mainApplicationStatusBar;

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doInitialBinding();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(MainApplicationStatusBarController.class, this);
	}

	private void doInitialBinding()
	{
		this.mainApplicationStatusBar.textProperty().bind(this.statusMessagesProperty());
		this.mainApplicationStatusBar.progressProperty().bind(this.progressStatusesProperty());
	}

	private StringProperty statusMessagesProperty = null;
	//private StringProperty statusMessagesProperty()
	public StringProperty statusMessagesProperty()
	{
		if(this.statusMessagesProperty == null)
		{
			this.statusMessagesProperty = new SimpleStringProperty();
		}
		return this.statusMessagesProperty;
	}

	private DoubleProperty progressStatusesProperty = null;
	//private DoubleProperty progressStatusesProperty()
	public DoubleProperty progressStatusesProperty()
	{
		if(this.progressStatusesProperty == null)
		{
			this.progressStatusesProperty = new SimpleDoubleProperty();
		}
		return this.progressStatusesProperty;
	}
}