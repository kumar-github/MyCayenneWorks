package com.tc.app.exchangemonitor.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Manages control flow for logins */
public class LoginManager
{
	private final Scene scene;

	public LoginManager(final Scene scene)
	{
		this.scene = scene;
	}

	/**
	 * Callback method invoked to notify that a user has been authenticated.
	 * Will show the main application screen.
	 */
	//public void authenticated(String sessionID)
	public void authenticated()
	{
		//showMainView(sessionID);
		((Stage) this.scene.getWindow()).close();
	}

	/**
	 * Callback method invoked to notify that a user has logged out of the main application.
	 * Will show the login application screen.
	 */
	public void logout()
	{
		this.constructLoginScreen();
	}

	public void constructLoginScreen()
	{
		try
		{
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
			final FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/tc/app/exchangemonitor/view/fxml/LoginView.fxml"));

			this.scene.setRoot((Parent) loader.load());
			final LoginController controller = loader.<LoginController>getController();
			controller.initManager(this);
		}
		catch(final IOException ex)
		{
			Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}