package com.tc.app.exchangemonitor.view.java;

import java.util.Objects;

import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.framework.fxmlview.FXMLView;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class MainWindowView extends FXMLView
{
	private double xOffset = 0.0;
	private double yOffset = 0.0;

	public MainWindowView()
	{
	}

	private Stage primaryStage;

	public MainWindowView(final Stage primaryStage)
	{
		this.primaryStage = Objects.requireNonNull(primaryStage, "Primary Stage cannot be NULL");
		this.primaryStage.setOnCloseRequest((final WindowEvent windowEvent) -> this.closeStageWithAnimation(windowEvent));
	}

	@Override
	public Parent getView()
	{
		return super.getView();
	}

	private Scene primaryScene;

	public Scene getScene()
	{
		this.primaryScene = new Scene(this.getView());
		this.makePrimarySceneDraggable();
		return this.primaryScene;
	}

	/* Since our stage is undecorated, we cannot drag it. This method will make the scene draggable. */
	private void makePrimarySceneDraggable()
	{
		this.primaryScene.setOnMousePressed(event -> {
			this.xOffset = this.primaryStage.getX() - event.getScreenX();
			this.yOffset = this.primaryStage.getY() - event.getScreenY();
		});

		this.primaryScene.setOnMouseDragged(event -> {
			this.primaryStage.setX(event.getScreenX() + this.xOffset);
			this.primaryStage.setY(event.getScreenY() + this.yOffset);
		});
	}

	private void closeStageWithAnimation(final WindowEvent windowEvent)
	{
		/* Shutdown the Cayenne Runtime. May not be needed, but it makes me feel great doing a  good thing. */
		CayenneHelper.getCayenneServerRuntime().shutdown();

		windowEvent.consume();
		/*
		RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.5), this.primaryScene.getRoot());
		rotateTransition.setOnFinished((ActionEvent actionEvent)->{
			this.primaryStage.close();
			Platform.exit();
			System.exit(0);
		});

		rotateTransition.setFromAngle(0);
		rotateTransition.setByAngle(360);
		rotateTransition.play();*/
		final TranslateTransition tt = new TranslateTransition(Duration.seconds(2), this.primaryScene.getRoot());
		tt.setOnFinished((final ActionEvent actionEvent) -> {
			this.primaryStage.close();
			Platform.exit();
			System.exit(0);
		});
		tt.setFromX(100);
		tt.setToX(1200);
		//tt.setCycleCount(Timeline.INDEFINITE);
		tt.play();
	}
}