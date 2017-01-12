/**
 * Copyright (c) 2017 by amphorainc.com. All rights reserved.
 * created on Jan 12, 2017
 */
package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.MaskerPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author Saravana Kumar M
 *
 */
public class ExchangeMonitorShellController implements Initializable
{
	@FXML
	private MaskerPane maskerPane;

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
	}

	public void disableMaskerPane()
	{
		this.maskerPane.setVisible(false);
	}
}