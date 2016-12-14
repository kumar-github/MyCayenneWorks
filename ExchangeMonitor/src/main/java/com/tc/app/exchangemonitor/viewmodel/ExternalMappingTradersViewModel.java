/*
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 16, 2016
 */
package com.tc.app.exchangemonitor.viewmodel;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Saravana Kumar M
 *
 * This class will act as a ViewModel. Few properties which are declared inside the respective controller class are needed in other controller classes. So we will figure out such properties and move it to common class.
 * Every controller which is in need of that property should come to this ViewModel class and access the property.
 * The very important point is how the ViewModel is instantiated. We need to maintain a single instance across the application life cycle. Currently it is getting instantiated through DI (@Inject).
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

	/* The below property is accessed from different controllers. */
	private final ObservableList<ExternalMapping> externalMappingTradersObservableList = FXCollections.observableArrayList();
	public final ObservableList<ExternalMapping> getExternalMappingTradersObservableList()
	{
		return this.externalMappingTradersObservableList;
	}

	private ObjectProperty<ExternalMapping> selectedRecord = null;
	public ObjectProperty<ExternalMapping> selectedRecordProperty()
	{
		if(this.selectedRecord == null)
		{
			this.selectedRecord = new SimpleObjectProperty<>();
		}
		return this.selectedRecord;
	}
}