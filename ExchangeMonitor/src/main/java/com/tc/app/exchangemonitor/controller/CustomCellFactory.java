package com.tc.app.exchangemonitor.controller;

import java.util.List;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class CustomCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>>
{
	private final Callback<TableColumn<S, T>, TableCell<S, T>> cellFactory;
	private final Callback<TableCell<S, T>, List<MenuItem>> menuItemFactory;

	public CustomCellFactory()
	{
		this.cellFactory = null;
		this.menuItemFactory = null;
	}

	public CustomCellFactory(final Callback<TableCell<S, T>, List<MenuItem>> menuItemFactory)
	{
		this(null, menuItemFactory);
	}

	public CustomCellFactory(final Callback<TableColumn<S, T>, TableCell<S, T>> cellFactory, final Callback<TableCell<S, T>, List<MenuItem>> menuItemFactory)
	{
		this.cellFactory = cellFactory;
		this.menuItemFactory = menuItemFactory;
	}

	@Override
	public TableCell<S, T> call(final TableColumn<S, T> theTableColumn)
	{
		final TableCell<S, T> theCell;

		if(this.cellFactory == null)
		{
			theCell = new TableCell<S, T>(){
				@Override
				protected void updateItem(final T item, final boolean empty)
				{
					super.updateItem(item, empty);
					if(empty || (item == null))
					{
						this.setText(null);
					}
					else
					{
						this.setText(item.toString());
					}
				}
			};
		}
		else
		{
			theCell = this.cellFactory.call(theTableColumn);
		}

		theCell.itemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue == null)
			{
				theCell.setContextMenu(null);
			}
			else
			{
				theCell.setContextMenu(this.createContextMenu(theCell));
			}
		});

		return theCell;
	}

	private ContextMenu createContextMenu(final TableCell<S, T> theCell)
	{
		final ContextMenu contextMenu = new ContextMenu();
		final TableRow<?> theRow = theCell.getTableRow();
		if(theRow != null)
		{
			final ContextMenu rowMenu = theRow.getContextMenu();
			if(rowMenu == null)
			{
				final TableView<S> table = theCell.getTableView();
				final ContextMenu tableMenu = table.getContextMenu();
				if(tableMenu != null)
				{
					contextMenu.getItems().addAll(tableMenu.getItems());
					contextMenu.getItems().add(new SeparatorMenuItem());
				}
			}
			else
			{
				contextMenu.getItems().addAll(rowMenu.getItems());
				contextMenu.getItems().add(new SeparatorMenuItem());
			}
		}
		contextMenu.getItems().addAll(this.menuItemFactory.call(theCell));
		return contextMenu;
	}
}