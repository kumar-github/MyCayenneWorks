package com.tc.app.exchangemonitor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;
import org.controlsfx.control.StatusBar;

import com.tc.app.exchangemonitor.util.ApplicationHelper;
import com.tc.app.exchangemonitor.util.PropertiesHelper;
import com.tc.app.exchangemonitor.view.java.PreferencesView;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainWindowController implements Initializable
{
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through FXML starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private BorderPane mainWindowBorderPane;
	@FXML
	private TabPane mainWindowTabPane;
	@FXML
	private ImageView homeImageView;
	@FXML
	private ImageView minimizeImageView;
	@FXML
	private ImageView maximizeOrRestoreImageView;
	@FXML
	private ImageView closeImageView;
	@FXML
	private StatusBar mainWindowStatusBar;
	@FXML
	private Button monitorStatusButton;
	@FXML
	private Button allTradesCountButton;
	@FXML
	private Button pendingTradesCountButton;
	@FXML
	private Button completedTradesCountButton;
	@FXML
	private Button failedTradesCountButton;
	@FXML
	private Button skippedTradesCountButton;
	@FXML
	private Separator leftSeparator;

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through FXML ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through @Inject starts here
	 * ============================================================================================================================================================================
	 */

	@Inject
	private String APPLICATION_TITLE;


	/**
	 * ============================================================================================================================================================================
	 * All Variables injected through @Inject ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All other variable declaration starts here
	 * ============================================================================================================================================================================
	 */

	private ChangeListener<Tab> mainWindowTabPaneChangeListener = null;

	private BoundingBox savedBounds;
	private boolean isInMaximizedState = false;
	private boolean isInRestoredState = true;

	/**
	 * ============================================================================================================================================================================
	 * All other variable declaration ends here
	 * ============================================================================================================================================================================
	 */

	@Override
	public void initialize(final URL location, final ResourceBundle resources)
	{
		this.addThisControllerToControllersMap();
		this.doAssertion();
		this.doInitialDataBinding();
		this.setComponentToolTipIfNeeded();
		this.initializeGUI();
		this.createListeners();
		this.attachListeners();
	}

	private void addThisControllerToControllersMap()
	{
		ApplicationHelper.controllersMap.putInstance(MainWindowController.class, this);
	}

	private void doAssertion()
	{
		assert this.homeImageView != null : "fx:id=\"homeImageView\" was not injected. Check your FXML file MainWindowView.fxml";
	}

	private void doInitialDataBinding()
	{
		this.monitorStatusButton.textProperty().bind(Bindings.format("%s", Bindings.when(this.isRunningProperty()).then("Monitor Running").otherwise("Monitor Not Running")));
		this.monitorStatusButton.managedProperty().bind(this.monitorStatusButton.visibleProperty());

		this.allTradesCountButton.textProperty().bind(this.allTradesCountProperty().asString());
		this.allTradesCountButton.managedProperty().bind(this.allTradesCountButton.visibleProperty());

		this.pendingTradesCountButton.textProperty().bind(this.pendingTradesCountProperty().asString());
		this.pendingTradesCountButton.managedProperty().bind(this.pendingTradesCountButton.visibleProperty());

		this.completedTradesCountButton.textProperty().bind(this.completedTradesCountProperty().asString());
		this.completedTradesCountButton.managedProperty().bind(this.pendingTradesCountButton.visibleProperty());

		this.failedTradesCountButton.textProperty().bind(this.failedTradesCountProperty().asString());
		this.failedTradesCountButton.managedProperty().bind(this.pendingTradesCountButton.visibleProperty());

		this.skippedTradesCountButton.textProperty().bind(this.skippedTradesCountProperty().asString());
		this.skippedTradesCountButton.managedProperty().bind(this.pendingTradesCountButton.visibleProperty());

		this.mainWindowStatusBar.textProperty().bind(this.statusMessagesProperty());
		this.mainWindowStatusBar.progressProperty().bind(this.progressStatusesProperty());
	}

	private void setComponentToolTipIfNeeded()
	{
		Tooltip.install(this.homeImageView, new Tooltip("Home"));
		Tooltip.install(this.minimizeImageView, new Tooltip("Minimize"));
		Tooltip.install(this.maximizeOrRestoreImageView, new Tooltip("Maximize"));
		Tooltip.install(this.closeImageView, new Tooltip("Close"));
	}

	private void initializeGUI()
	{
	}

	private void createListeners()
	{
		this.mainWindowTabPaneChangeListener = (observableValue, oldValue, newValue) -> {
			this.handleMainWindowTabPaneTabChange(oldValue, newValue);
		};
	}

	private void attachListeners()
	{
		this.mainWindowTabPane.getSelectionModel().selectedItemProperty().addListener(this.mainWindowTabPaneChangeListener);
	}

	/**
	 * ============================================================================================================================================================================
	 * Methods injected through FXML starts here
	 * ============================================================================================================================================================================
	 */

	@FXML
	private void handleHomeImageViewClick(final MouseEvent mouseEvent)
	{
		if(mouseEvent.getButton() == MouseButton.PRIMARY)
		{
			this.showPreferencesPopOver();
		}
	}

	@FXML
	private void handleTitleBarHBoxClick(final MouseEvent mouseEvent)
	{
		if(mouseEvent.getClickCount() > 1)
		{
			this.handleMaximizeOrRestoreImageViewClick(mouseEvent);
		}
	}

	@FXML
	private void handleMinimizeImageViewClick()
	{
		this.minimizeStage();
	}

	@FXML
	private void handleMaximizeOrRestoreImageViewClick(final MouseEvent mouseEvent)
	{
		/* We may be here bcoz user clicked maximize of restore. so first find out. */
		if(this.isInMaximizedState)
		{
			/* do restore stuff. */
			this.restoreStage();
			this.removeCSSStyleFromNode(this.maximizeOrRestoreImageView, "mainWindowViewRestoreImageViewStyle");
			this.addCSSStyleToNode(this.maximizeOrRestoreImageView, "mainWindowViewMaximizeImageViewStyle");
			Tooltip.install(this.maximizeOrRestoreImageView, new Tooltip("Maximize"));

			this.isInRestoredState = true;
			this.isInMaximizedState = false;
		}
		else if(this.isInRestoredState)
		{
			/* do maximize stuff. */
			this.saveStageBounds();
			this.maximizeStage();

			this.removeCSSStyleFromNode(this.maximizeOrRestoreImageView, "mainWindowViewMaximizeImageViewStyle");
			this.addCSSStyleToNode(this.maximizeOrRestoreImageView, "mainWindowViewRestoreImageViewStyle");
			Tooltip.install(this.maximizeOrRestoreImageView, new Tooltip("Restore"));

			this.isInMaximizedState = true;
			this.isInRestoredState = false;
		}
	}

	@FXML
	private void handleCloseImageViewClick(final MouseEvent mouseEvent)
	{
		/* don't close the stage by yourself, instead just raise a close request event and leave it. we will handle it somewhere. */
		final Stage primaryStage = (Stage) (this.mainWindowBorderPane.getScene().getWindow());
		Platform.runLater(() -> {
			primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
		});
	}

	/**
	 * ============================================================================================================================================================================
	 * Methods injected through FXML ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods starts here
	 * ============================================================================================================================================================================
	 */

	private void handleMainWindowTabPaneTabChange(final Tab previousTab, final Tab currentTab)
	{
		this.doThisWhenTabSelectionChanges(previousTab, currentTab);
	}

	private void doThisWhenTabSelectionChanges(final Tab previousTab, final Tab currentTab)
	{
		if((previousTab != null) && previousTab.getText().equals("Monitor"))
		{
			if(this.mainWindowStatusBar.textProperty().isBound())
			{
				this.mainWindowStatusBar.textProperty().unbind();
			}

			if(this.mainWindowStatusBar.progressProperty().isBound())
			{
				this.mainWindowStatusBar.progressProperty().unbind();
			}

			this.showHideMonitorTabStatusBarButtons(false);
		}
		else if((previousTab != null) && previousTab.getText().equals("Positions"))
		{
		}
		else if((previousTab != null) && previousTab.getText().equals("Mappings"))
		{
		}
		else if((previousTab != null) && previousTab.getText().equals("Settle Prices"))
		{
		}
		else if((previousTab != null) && previousTab.getText().equals("Loading Schedule"))
		{
		}

		if(currentTab.getText().equals("Monitor"))
		{
			if(!this.mainWindowStatusBar.textProperty().isBound())
			{
				this.mainWindowStatusBar.textProperty().bind(this.statusMessagesProperty());
			}
			if(!this.mainWindowStatusBar.progressProperty().isBound())
			{
				this.mainWindowStatusBar.progressProperty().bind(this.progressStatusesProperty());
			}

			this.showHideMonitorTabStatusBarButtons(true);
		}
		else if(currentTab.getText().equals("Positions"))
		{
			this.showHidePositionsTabStatusBarButtons(true);
		}
	}

	private void showHideMonitorTabStatusBarButtons(final boolean shouldShow)
	{
		this.monitorStatusButton.setVisible(shouldShow);
		this.allTradesCountButton.setVisible(shouldShow);
		this.completedTradesCountButton.setVisible(shouldShow);
		this.pendingTradesCountButton.setVisible(shouldShow);
		this.failedTradesCountButton.setVisible(shouldShow);
		this.skippedTradesCountButton.setVisible(shouldShow);
		this.leftSeparator.setVisible(shouldShow);
	}

	private void showHidePositionsTabStatusBarButtons(final boolean shouldShow)
	{
		/*
		this.allTradesCountButton.setVisible(shouldShow);
		this.completedTradesCountButton.setVisible(shouldShow);
		this.pendingTradesCountButton.setVisible(shouldShow);
		this.failedTradesCountButton.setVisible(shouldShow);
		this.skippedTradesCountButton.setVisible(shouldShow);
		this.leftSeparator.setVisible(shouldShow);
		 */
	}

	/**
	 * ============================================================================================================================================================================
	 * All Listeners methods ends here
	 * ============================================================================================================================================================================
	 */

	/**
	 * ============================================================================================================================================================================
	 * General Methods starts here
	 * ============================================================================================================================================================================
	 */

	VBox preferencesVbox = (VBox) new PreferencesView().getView();

	private void showPreferencesPopOver()
	{
		final PopOver preferencesPopOver = new PopOver();
		preferencesPopOver.setTitle("Preferences");
		preferencesPopOver.setDetached(true);
		preferencesPopOver.setArrowLocation(ArrowLocation.TOP_LEFT);
		preferencesPopOver.setAutoFix(true);
		preferencesPopOver.setAutoHide(true);
		preferencesPopOver.setHideOnEscape(true);
		preferencesPopOver.setCornerRadius(4);
		//popOver.setContentNode(new PreferencesView().getView());
		preferencesPopOver.setContentNode(this.preferencesVbox);
		preferencesPopOver.show(this.homeImageView);
	}

	public void minimizeStage()
	{
		if(!Platform.isFxApplicationThread())
		{
			Platform.runLater(() -> this._minimize());
		}
		else
		{
			this._minimize();
		}
	}

	/* According to my code convention, methods starts with underscore (_) are very low level methods. so avoid calling them directly. there will be a helper method
	 * available with same name without underscore (_) try using that.  */
	private void _minimize()
	{
		//BorderPane mainApplicationBorderPane = ApplicationHelper.controllersMap.getInstance(MainApplicationController.class).getMainApplicationBorderPane();
		//((Stage)(mainApplicationBorderPane.getScene().getWindow())).setIconified(true);
		((Stage) this.mainWindowBorderPane.getScene().getWindow()).setIconified(true);
	}

	public void restoreStage()
	{
		if(!Platform.isFxApplicationThread())
		{
			Platform.runLater(() -> this._restore());
		}
		else
		{
			this._restore();
		}
	}

	private void _restore()
	{
		if(!this.isInRestoredState)
		{
			//primaryStage.setMaximized(true); /* Technically this should work but it is not bcoz of undecoration. */

			//BorderPane mainApplicationBorderPane = ApplicationHelper.controllersMap.getInstance(MainApplicationController.class).getMainApplicationBorderPane();
			final Stage primaryStage = ((Stage) (this.mainWindowBorderPane.getScene().getWindow()));
			primaryStage.setX(this.savedBounds.getMinX());
			primaryStage.setY(this.savedBounds.getMinY());
			primaryStage.setWidth(this.savedBounds.getWidth());
			primaryStage.setHeight(this.savedBounds.getHeight());
		}
	}

	public void maximizeStage()
	{
		/* If we are here, then user maximized the application. Since the app is initially loaded in the restore mode, the maximize button will be visible and it should be
		 * toggled back and forth from maximize image to restore image as the user clicks maximize and restore buttons.
		 * Here we remove the old css style and set the new css style. In this case remove the "applicationMainWindowMaximizeImageViewStyle" css style which shows a maximize image and set the
		 * "applicationMainWindowRestoreImageViewStyle" css style which shows a restore image.
		 */
		if(!Platform.isFxApplicationThread())
		{
			Platform.runLater(() -> this._maximize());
		}
		else
		{
			this._maximize();
		}
	}

	private void _maximize()
	{
		if(!this.isInMaximizedState)
		{
			//primaryStage.setMaximized(true); /* Technically this should work but it is not bcoz of undecoration. */

			//BorderPane mainApplicationBorderPane = ApplicationHelper.controllersMap.getInstance(MainApplicationController.class).getMainApplicationBorderPane();

			//Get current screen of the stage
			final Stage primaryStage = ((Stage) (this.mainWindowBorderPane.getScene().getWindow()));
			final ObservableList<Screen> screens = Screen.getScreensForRectangle(primaryStage.getX(), primaryStage.getY(), primaryStage.getWidth(), primaryStage.getHeight());
			final Rectangle2D bounds = screens.get(0).getVisualBounds();
			primaryStage.setX(bounds.getMinX());
			primaryStage.setY(bounds.getMinY());
			primaryStage.setWidth(bounds.getWidth());
			primaryStage.setHeight(bounds.getHeight());
		}
	}

	private void addCSSStyleToNode(final Node aNode, final String cssStyle)
	{
		aNode.getStyleClass().add(cssStyle);
	}

	private void removeCSSStyleFromNode(final Node aNode, final String cssStyle)
	{
		aNode.getStyleClass().remove(cssStyle);
	}

	private void saveStageBounds()
	{
		//BorderPane mainApplicationBorderPane = ApplicationHelper.controllersMap.getInstance(MainApplicationController.class).getMainApplicationBorderPane();
		final Stage primaryStage = ((Stage) (this.mainWindowBorderPane.getScene().getWindow()));
		this.savedBounds = new BoundingBox(primaryStage.getX(), primaryStage.getY(), primaryStage.getWidth(), primaryStage.getHeight());
	}

	public String getAPPLICATION_TITLE()
	{
		return this.APPLICATION_TITLE;
	}

	public String getAPPLICATION_TITLE_WITH_USERNAME_AND_DBNAME()
	{
		return String.join(" ", System.getenv("username"), "@", this.getAPPLICATION_TITLE(), "On", getDBName());
	}

	private static String getDBName()
	{
		return PropertiesHelper.getSystemProperty("ConnectionUrl").substring(PropertiesHelper.getSystemProperty("ConnectionUrl").lastIndexOf("=") + 1);
	}

	/**
	 * ============================================================================================================================================================================
	 * General Methods ends here
	 * ============================================================================================================================================================================
	 */

	private StringProperty statusMessages = null;
	public StringProperty statusMessagesProperty()
	{
		if(this.statusMessages == null)
		{
			this.statusMessages = new SimpleStringProperty();
		}
		return this.statusMessages;
	}

	//private DoubleProperty progressStatusesProperty = null;
	private DoubleProperty progressStatuses = null;
	public DoubleProperty progressStatusesProperty()
	{
		if(this.progressStatuses == null)
		{
			this.progressStatuses = new SimpleDoubleProperty();
		}
		return this.progressStatuses;
	}

	//private BooleanProperty isRunningProperty = null;
	private BooleanProperty isRunning = null;
	public BooleanProperty isRunningProperty()
	{
		if(this.isRunning == null)
		{
			this.isRunning = new SimpleBooleanProperty();
		}
		return this.isRunning;
	}

	//private IntegerProperty allTradesCountProperty = null;
	private IntegerProperty allTradesCount = null;
	public IntegerProperty allTradesCountProperty()
	{
		if(this.allTradesCount == null)
		{
			this.allTradesCount = new SimpleIntegerProperty();
		}
		return this.allTradesCount;
	}

	//private IntegerProperty pendingTradesCountProperty = null;
	private IntegerProperty pendingTradesCount = null;
	public IntegerProperty pendingTradesCountProperty()
	{
		if(this.pendingTradesCount == null)
		{
			this.pendingTradesCount = new SimpleIntegerProperty();
		}
		return this.pendingTradesCount;
	}

	//private IntegerProperty completedTradesCountProperty = null;
	private IntegerProperty completedTradesCount = null;
	public IntegerProperty completedTradesCountProperty()
	{
		if(this.completedTradesCount == null)
		{
			this.completedTradesCount = new SimpleIntegerProperty();
		}
		return this.completedTradesCount;
	}

	//private IntegerProperty failedTradesCountProperty = null;
	private IntegerProperty failedTradesCount = null;
	public IntegerProperty failedTradesCountProperty()
	{
		if(this.failedTradesCount == null)
		{
			this.failedTradesCount = new SimpleIntegerProperty();
		}
		return this.failedTradesCount;
	}

	//private IntegerProperty skippedTradesCountProperty = null;
	private IntegerProperty skippedTradesCount = null;
	public IntegerProperty skippedTradesCountProperty()
	{
		if(this.skippedTradesCount == null)
		{
			this.skippedTradesCount = new SimpleIntegerProperty();
		}
		return this.skippedTradesCount;
	}
}

/* ******************************************************************************************************************************************************************************************************* */

/**
 * ============================================================================================================================================================================
 * All temporarily commented code starts here. We may need in future for reference
 * ============================================================================================================================================================================
 */

/*tradeAccountListView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
@Override
public BooleanProperty call(String item) {
//public ObservableValue<Boolean> call(String item) {
    /*BooleanProperty observable = new SimpleBooleanProperty();
    observable.addListener((obs, wasSelected, isNowSelected) -> System.out.println("Check box for "+item+" changed from "+wasSelected+" to "+isNowSelected));
    return observable ;
}
}));*/

// set the cell factory
/*Callback<String, ObservableValue<Boolean>> getProperty = new Callback<String, ObservableValue<Boolean>>() {
@Override
public BooleanProperty call(String item) {
    // given a person, we return the property that represents
    // whether or not they are invited. We can then bind to this
    // bidirectionally.
    //return item;
	System.out.println(item + " is clicked");
	return null;
}};

tradeAccountListView.setCellFactory(CheckBoxListCell.forListView(getProperty));*/

/*
public void handleSearchByKey2(String oldVal, String newVal)
{
	// If the number of characters in the text box is less than last time it must be because the user pressed delete
	if(oldVal != null && (newVal.length() < oldVal.length()))
	{
		// Restore the lists original set of entries and start from the beginning
		tradeAccountListView.setItems(FXCollections.observableArrayList(externalTradeAccounts));
	}

	// Break out all of the parts of the search text by splitting on white space
	String[] parts = newVal.toUpperCase().split(" ");

	// Filter out the entries that don't contain the entered text
	ObservableList<String> subentries = FXCollections.observableArrayList();
	//for (Object entry: tradeAccountListView.getItems())
	for(String entry: tradeAccountListView.getItems())
	{
		boolean match = true;
		for(String part: parts)
		{
			// The entry needs to contain all portions of the search string *but* in any order
			if(!entry.toUpperCase().contains(part))
			{
				match = false;
				break;
			}
		}

		if (match)
		{
			subentries.add(entry);
		}
	}
	tradeAccountListView.setItems(subentries);
}
 */

/**
 * ============================================================================================================================================================================
 * All temporarily commented code ends here. We may need in future for reference
 * ============================================================================================================================================================================
 */