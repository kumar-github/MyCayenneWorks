/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 16, 2016
 */
package com.tc.app.exchangemonitor.viewmodel;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

/**
 * @author Saravana Kumar M
 *
 */
public class ExternalMappingTradersViewModel
{
	//private final ListProperty<ExternalMapping> externalMappingsListProperty = new SimpleListProperty<>();
	//externalMappingsListProperty.set(FXCollections.observableArrayList(europeanCurrencyList));

	private ListProperty<ExternalMapping> externalMappingsObservableList = null;
	public ListProperty<ExternalMapping> externalMappingsObservableListProperty()
	{
		if(this.externalMappingsObservableList == null)
		{
			this.externalMappingsObservableList = new SimpleListProperty<>();
		}
		return this.externalMappingsObservableList;
	}
}