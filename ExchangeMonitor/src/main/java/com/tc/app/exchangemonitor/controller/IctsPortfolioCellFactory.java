package com.tc.app.exchangemonitor.controller;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Portfolio;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IctsPortfolioCellFactory implements Callback<ListView<Portfolio>, ListCell<Portfolio>>
{
	/* (non-Javadoc)
	 * @see javafx.util.Callback#call(java.lang.Object)
	 */
	@Override
	public ListCell<Portfolio> call(final ListView<Portfolio> param)
	{
		return new IctsPortfolioButtonCell();
	}
}