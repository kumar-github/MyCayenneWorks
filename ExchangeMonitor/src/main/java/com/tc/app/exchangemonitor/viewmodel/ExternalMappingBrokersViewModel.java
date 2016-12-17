/*
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 16, 2016
 */
package com.tc.app.exchangemonitor.viewmodel;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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

public class ExternalMappingBrokersViewModel
{
	/* The below property is accessed from different controllers. */
	private final ObservableList<ExternalMapping> externalMappingBrokersObservableList = FXCollections.observableArrayList();

	public final ObservableList<ExternalMapping> getExternalMappingBrokersObservableList()
	{
		return this.externalMappingBrokersObservableList;
	}

	/* This is to get the selected record. When the user select any record and click update button then we need to show the "Update Mapping" popup with the selected record details. */
	private ObjectProperty<ExternalMapping> selectedRecord = null;
	public ObjectProperty<ExternalMapping> selectedRecordProperty()
	{
		if(this.selectedRecord == null)
		{
			this.selectedRecord = new SimpleObjectProperty<>();
		}
		return this.selectedRecord;
	}

	/* This is to know whether the user clicked "Add" button or "Update" button, bcoz for both we are planning to show the same popup with few changes. so we need to know whether it is "Add" or "Update". */
	private BooleanProperty isAdd = null;

	public BooleanProperty isAddProperty()
	{
		if(this.isAdd == null)
		{
			this.isAdd = new SimpleBooleanProperty();
		}
		return this.isAdd;
	}
}