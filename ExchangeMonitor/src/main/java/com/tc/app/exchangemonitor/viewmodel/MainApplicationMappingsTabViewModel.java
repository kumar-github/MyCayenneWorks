/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Dec 30, 2016
 */
package com.tc.app.exchangemonitor.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Saravana Kumar M
 *
 */
public class MainApplicationMappingsTabViewModel
{
	private StringProperty currentVisibleMappingView = null;
	public StringProperty currentVisibleMappingViewProperty()
	{
		if(this.currentVisibleMappingView == null)
		{
			this.currentVisibleMappingView = new SimpleStringProperty();
		}
		return this.currentVisibleMappingView;
	}
}