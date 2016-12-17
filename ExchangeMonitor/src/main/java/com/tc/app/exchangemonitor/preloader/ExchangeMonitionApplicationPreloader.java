package com.tc.app.exchangemonitor.preloader;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.controller.LoginManager;
import com.tc.app.exchangemonitor.controller.PreferencesHelper;
import com.tc.app.exchangemonitor.util.DatabaseUtil;
import com.tc.app.exchangemonitor.util.StaticConstantsHelper;
import com.tc.app.exchangemonitor.view.java.PreloaderView;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class ExchangeMonitionApplicationPreloader extends Preloader
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean shouldShowLoginScreen;
	private static final boolean DEFAULT_BOOLEAN_VALUE = false;
	//private ProgressBar progressBar;
	private Stage preloaderStage;
	private Scene preloaderScene;

	static
	{
		shouldShowLoginScreen = !PreferencesHelper.getUserPreferences().getBoolean(StaticConstantsHelper.IS_AUTHENTICATED_USER, DEFAULT_BOOLEAN_VALUE);
	}

	public ExchangeMonitionApplicationPreloader()
	{
		LOGGER.debug("ExchangeMonitorApplicationPreloader constructor called by ", Thread.currentThread().getName());
	}

	@Override
	public void init() throws Exception
	{
		LOGGER.debug("ExchangeMonitorApplicationPreloader init called by ", Thread.currentThread().getName());
		super.init();
		/* If the preloader has complex UI it's initialization can be done in here. Ensure that you do it with Platform.runLater() */
	}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		LOGGER.debug("ExchangeMonitorApplicationPreloader start called by ", Thread.currentThread().getName());

		if(shouldShowLoginScreen)
		{
			this.showLoginScreen();
		}
		else
		{
			final boolean status = this.authenticateInBackground();
			if(!status)
			{
				LOGGER.info("Automatic Login Failed.");
				PreferencesHelper.forgetLoginCredentials();
				PreferencesHelper.getUserPreferences().clear();
				this.showLoginScreen();
			}
		}
		this.showPreloaderScreen(primaryStage);
	}

	@Override
	public void handleApplicationNotification(final PreloaderNotification info)
	{
		if(info instanceof ProgressNotification)
		{
			//this.preloaderViewModel.updateProgressText(this.MESSAGES[this.counter]);
		}
	}

	@Override
	public void handleProgressNotification(final ProgressNotification info)
	{
		super.handleProgressNotification(info);
		if((info.getProgress() != 1) && !this.preloaderStage.isShowing())
		{
			this.preloaderStage.show();
		}
		//progressBar.setProgress(info.getProgress());
	}

	@Override
	public void handleStateChangeNotification(final StateChangeNotification info)
	{
		super.handleStateChangeNotification(info);
		final StateChangeNotification.Type notificationType = info.getType();

		switch(notificationType)
		{
			case BEFORE_LOAD:
				// Called after preloader#start is called.
				LOGGER.debug("ExchangeMonitorApplicationPreloader ", notificationType);
				break;

			case BEFORE_INIT:
				//Called before application#init is called.
				LOGGER.debug("ExchangeMonitorApplicationPreloader ", notificationType);
				break;

			case BEFORE_START:
				//Called after application#init and before application#start is called.
				LOGGER.debug("ExchangeMonitorApplicationPreloader ", notificationType);
				if(this.preloaderStage.isShowing())
				{
					final FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), this.preloaderStage.getScene().getRoot());
					fadeTransition.setFromValue(1.0);
					fadeTransition.setToValue(0.0);
					final Stage tempStage = this.preloaderStage;

					final EventHandler<ActionEvent> eventHandler = event -> tempStage.hide();
					fadeTransition.setOnFinished(eventHandler);
					fadeTransition.play();
					//this.preloaderStage.hide();
				}
				break;
		}
	}

	private Scene createPreloaderScene()
	{
		//progressBar = new ProgressBar();
		//BorderPane borderPane = new BorderPane();
		//borderPane.setCenter(progressBar);
		//return new Scene(borderPane, 300, 150);

		final PreloaderView preloaderView = new PreloaderView();
		this.preloaderScene = new Scene(preloaderView.getView());
		this.preloaderScene.setFill(Color.TRANSPARENT);
		return this.preloaderScene;

		/*
		LoginView loginView = new LoginView();
		return new Scene(loginView.getView());
		 */
	}

	private Scene createLoginScene()
	{
		final Scene loginScene = new Scene(new StackPane());
		final LoginManager loginManager = new LoginManager(loginScene);
		loginManager.constructLoginScreen();
		return loginScene;
	}

	private void showLoginScreen()
	{
		final Stage loginStage = new Stage(StageStyle.TRANSPARENT);
		loginStage.setOnCloseRequest((final WindowEvent windowEvent) -> Platform.runLater(() -> {
			Platform.exit();
			System.exit(0);
		}));
		loginStage.setScene(this.createLoginScene());
		loginStage.showAndWait();
	}

	private void showPreloaderScreen(final Stage primaryStage)
	{
		this.preloaderStage = primaryStage;
		this.preloaderStage.setScene(this.createPreloaderScene());

		this.preloaderStage.sizeToScene();
		this.preloaderStage.centerOnScreen();
		this.preloaderStage.setAlwaysOnTop(true);
		this.preloaderStage.initStyle(StageStyle.TRANSPARENT);
		this.preloaderStage.show();
		this.preloaderStage.toFront();
	}

	private boolean authenticateInBackground()
	{
		boolean isAuthorized = DEFAULT_BOOLEAN_VALUE;

		try
		{
			isAuthorized = DatabaseUtil.makeTestConnection(PreferencesHelper.getUserPreferences().get(StaticConstantsHelper.CONNECTION_URL, ""), null, null);
		}
		catch(final SQLException exception)
		{
			exception.printStackTrace();
		}

		return isAuthorized;
	}
}