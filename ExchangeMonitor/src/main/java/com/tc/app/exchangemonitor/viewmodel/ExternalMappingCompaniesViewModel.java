/*
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 16, 2016
 */
package com.tc.app.exchangemonitor.viewmodel;

import com.tc.app.exchangemonitor.model.cayenne.persistent.ExternalMapping;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Saravana Kumar M
 *
 * This class will act as a ViewModel. Few properties which are declared inside the respective controller class are needed in other controller classes. So we will figure out such properties and move it to common class.
 * Every controller which is in need of that property should come to this ViewModel class and access the property.
 * The very important point is how the ViewModel is instantiated. We need to maintain a single instance across the application life cycle. Currently it is getting instantiated through DI (@Inject).
 */

public class ExternalMappingCompaniesViewModel
{
	/* The below property is accessed from different controllers. */
	private final ObservableList<ExternalMapping> externalMappingCompaniesObservableList = FXCollections.observableArrayList();

	public final ObservableList<ExternalMapping> getExternalMappingCompaniesObservableList()
	{
		return this.externalMappingCompaniesObservableList;
	}
}