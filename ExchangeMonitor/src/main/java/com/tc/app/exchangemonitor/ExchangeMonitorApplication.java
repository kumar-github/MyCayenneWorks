package com.tc.app.exchangemonitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.controller.ExchangeMonitorShellController;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.DaemonThreadFactory;
import com.tc.app.exchangemonitor.util.TaskUtil;
import com.tc.app.exchangemonitor.view.java.ExchangeMonitorShellView;
import com.tc.framework.injection.Injector;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ExchangeMonitorApplication extends Application
{
	//private Rectangle2D primaryMonitor = Screen.getPrimary().getVisualBounds();
	private static final Logger LOGGER = LogManager.getLogger();

	private Stage primaryStage = null;
	private Scene primaryScene = null;

	public ExchangeMonitorApplication()
	{
		LOGGER.debug("ExchangeMonitorApplication constructor called by ", Thread.currentThread().getName());
	}

	private static long startTime;
	private static long endTime;
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
		LOGGER.debug("ExchangeMonitorApplication init called by ", Thread.currentThread().getName());
		final ExecutorService referenceDataExecutorService = Executors.newCachedThreadPool(new DaemonThreadFactory());

		/* create a task which initialize the Cayenne Runtime and loads the referencedata, and give the task to an executor service which executes it in a background thread. */
		//@formatter:off

		CayenneHelper.initializeCayenneServerRuntime();
		final Task<Void> referenceDataTask = TaskUtil.task(() -> {
			CayenneReferenceDataCache.fetchAllReferenceData();
			return null;
		});

		//@formatter:on

		/* give a callback method to the task so that it will let us know once it is done with the task. */
		referenceDataTask.setOnSucceeded(event -> this.enableUI());
		referenceDataTask.setOnFailed(event -> this.terminateApplication());

		/* its time to execute the task. */
		referenceDataExecutorService.execute(referenceDataTask);

		/* Nothing special. just shutdown the executor to avoid any memory leaks. The shutdown will be effective once all the tasks are completed. */
		referenceDataExecutorService.shutdown();
	}

	@Override
	public void start(final Stage primaryStage)
	{
		LOGGER.debug("ExchangeMonitorApplication start called by ", Thread.currentThread().getName());
		// Do all the heavy lifting stuff. One Question. Can we do the heavy lifting stuff in init() instead here?
		// then load the primary stage
		try
		{
			this.primaryStage = primaryStage;
			this.primaryScene = this.createPrimaryScene();

			this.initializePrimaryStage();
			this.initializePrimaryScene();

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
			//Injector.forgetAll();
			//Platform.exit();
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
		//final MainWindowView mainWindowView = new MainWindowView(this.primaryStage);
		//return mainWindowView.getScene();

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
		LOGGER.debug("ExchangeMonitorApplication stop called by ", Thread.currentThread().getName());
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
		Platform.exit();
		System.exit(0);
	}
}