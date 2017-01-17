package com.tc.app.exchangemonitor;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.controller.ExchangeMonitorShellController;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.DaemonThreadFactory;
import com.tc.app.exchangemonitor.util.DatabaseUtil;
import com.tc.app.exchangemonitor.util.PropertiesHelper;
import com.tc.app.exchangemonitor.util.TaskUtil;
import com.tc.app.exchangemonitor.view.java.ExchangeMonitorShellView;
import com.tc.framework.injection.Injector;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class ExchangeMonitorApplication extends Application
{
	//private Rectangle2D primaryMonitor = Screen.getPrimary().getVisualBounds();
	private static final Logger LOGGER = LogManager.getLogger();

	private final ExecutorService referenceDataExecutorService = Executors.newCachedThreadPool(new DaemonThreadFactory());

	private Stage primaryStage = null;
	private Scene primaryScene = null;

	private static long startTime;
	private static long endTime;

	private static String CONNECTION_URL = null;
	private static String USERNAME = null;
	private static String PASSWORD = null;

	public ExchangeMonitorApplication()
	{
		//LOGGER.debug("ExchangeMonitorApplication constructor called by ", Thread.currentThread().getName());
		CONNECTION_URL = PropertiesHelper.getSystemProperty("ConnectionUrl");
		USERNAME = PropertiesHelper.getSystemProperty("Username");
		PASSWORD = PropertiesHelper.getSystemProperty("Password");
	}

	public static void main(final String[] args)
	{
		LOGGER.debug("ExchangeMonitorApplication main called by ", Thread.currentThread().getName());
		startTime = System.currentTimeMillis();
		LOGGER.info("App Launch Initiated Time {}", startTime);
		Application.launch();
		//LauncherImpl.launchApplication(ExchangeMonitorApplication.class, ExchangeMonitionApplicationPreloader.class, args);
	}

	@Override
	public void init()
	{
		//LOGGER.debug("ExchangeMonitorApplication init called by ", Thread.currentThread().getName());

		try
		{
			DatabaseUtil.makeTestConnection(CONNECTION_URL, USERNAME, PASSWORD);
		}
		catch(final SQLException exception)
		{
			LOGGER.error("Unable to Login. Please Check connection url and credentials. {}", exception.getMessage());
			this.terminateApplication();
		}

		try
		{
			CayenneHelper.initializeCayenneServerRuntime();
		}
		catch(final Exception exception)
		{
			LOGGER.error("Cayenne Server Runtime Creation Failed.", exception);
			this.terminateApplication();
		}

		//@formatter:off

		/* create a task which initialize the Cayenne Runtime and loads the referencedata, and give the task to an executor service which executes it in a background thread. */
		final Task<Void> referenceDataTask = TaskUtil.task(() -> {
			CayenneReferenceDataCache.fetchAllReferenceData();
			return null;
		});

		//@formatter:on

		/* give a callback method to the task so that it will let us know once it is done with the task. */
		referenceDataTask.setOnSucceeded(event -> this.enableUI());
		referenceDataTask.setOnFailed(event -> this.terminateApplication());

		/* its time to execute the task. */
		this.referenceDataExecutorService.execute(referenceDataTask);

		/* Nothing special. just shutdown the executor to avoid any memory leaks. The shutdown will be effective once all the tasks are completed. */
		this.referenceDataExecutorService.shutdown();
	}

	@Override
	public void start(final Stage primaryStage)
	{
		//LOGGER.debug("ExchangeMonitorApplication start called by ", Thread.currentThread().getName());

		// Do all the heavy lifting stuff. One Question. Can we do the heavy lifting stuff in init() instead here?
		// then load the primary stage
		try
		{
			this.primaryStage = primaryStage;
			this.primaryScene = this.createPrimaryScene();

			this.initializePrimaryStage();
			this.initializePrimaryScene();
			this.attachKeyListenerToPrimaryScene();

			//animateStageIfNeeded();

			this.primaryStage.setScene(this.primaryScene);
			this.animateStageIfNeeded();

			endTime = System.currentTimeMillis();
			LOGGER.info("UI Displayed Time {}", endTime);
			LOGGER.info("It took {} milli seconds to load the UI.", (endTime - startTime));
			primaryStage.show();
			primaryStage.toFront();
		}
		catch(final Exception exception)
		{
			LOGGER.error(exception);
			Injector.forgetAll();
			Platform.exit();
		}
		finally
		{
		}
	}

	private void initializePrimaryStage()
	{
		this.undecoratePrimaryStage();

		/* commented the below line. don't do it here instead do it in the respective view's controller class.*/
		//primaryStage.setTitle("Exchange Monitor");

		this.primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/icons/exchange-512.png")));
		this.primaryStage.setFullScreen(false);
		this.primaryStage.setResizable(false);

		this.primaryStage.sizeToScene();
		this.primaryStage.centerOnScreen();
	}

	private void initializePrimaryScene()
	{
		this.primaryScene.setFill(Color.TRANSPARENT);
	}

	private void undecoratePrimaryStage()
	{
		this.primaryStage.initStyle(StageStyle.UNDECORATED);
		this.primaryStage.initStyle(StageStyle.TRANSPARENT);
	}

	private ExchangeMonitorShellController exchangeMonitorShellController = null;

	private Scene createPrimaryScene()
	{
		final ExchangeMonitorShellView exchangeMonitorShellView = new ExchangeMonitorShellView(this.primaryStage);
		/* Not a better way but no other go... */
		this.exchangeMonitorShellController = (ExchangeMonitorShellController) exchangeMonitorShellView.getPresenter();
		return exchangeMonitorShellView.getScene();
	}

	private void animateStageIfNeeded()
	{
		this.setFadeInTransition();
	}

	private void setFadeInTransition()
	{
		this.primaryScene.getRoot().setOpacity(0.0);
		this.primaryStage.showingProperty().addListener((observableValue, oldValue, newValue) -> {
			if(newValue)
			{
				final FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), this.primaryScene.getRoot());
				fadeTransition.setToValue(1);
				fadeTransition.play();
			}
		});
	}

	@Override
	public void stop() throws Exception
	{
		//LOGGER.debug("ExchangeMonitorApplication stop called by ", Thread.currentThread().getName());
		super.stop();
		Injector.forgetAll();
		CayenneHelper.getCayenneServerRuntime().shutdown();
		LOGGER.info("Application Terminated.");
		Platform.exit();
		System.exit(0);
	}

	private void enableUI()
	{
		this.exchangeMonitorShellController.disableMaskerPane();
	}

	private void terminateApplication()
	{
		this.referenceDataExecutorService.shutdown();
		Platform.exit();
		System.exit(0);
	}

	private void attachKeyListenerToPrimaryScene()
	{
		/*this.primaryScene.setOnKeyPressed(event -> {
			LOGGER.error(event.getCode());
		});*/

		this.primaryScene.addEventFilter(KeyEvent.KEY_PRESSED, (keyEvent) -> this.doActionAsPerKeyPressed(keyEvent));
	}

	private void doActionAsPerKeyPressed(final KeyEvent keyEvent)
	{
		final KeyCombination controlWKeyCombination = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		final KeyCombination altF4KeyCombination = new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN);
		if(altF4KeyCombination.match(keyEvent) || controlWKeyCombination.match(keyEvent))
		{
			/* don't close the stage by yourself, instead just raise a close request event and leave it. we will handle it somewhere. */
			Platform.runLater(() -> {
				this.primaryStage.fireEvent(new WindowEvent(this.primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
			});
			keyEvent.consume();
		}
	}
}