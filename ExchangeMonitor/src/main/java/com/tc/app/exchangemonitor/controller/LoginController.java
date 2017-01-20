package com.tc.app.exchangemonitor.controller;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tc.app.exchangemonitor.util.DatabaseUtil;
import com.tc.app.exchangemonitor.util.PropertiesHelper;
import com.tc.app.exchangemonitor.util.StaticConstantsHelper;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.text.Text;

/** Controls the login screen */
public class LoginController
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static final boolean DEFAULT_BOOLEAN_VALUE = false;
	//public static String CONNECTION_URL ="jdbc:jtds:sqlserver://{0};databaseName={1}";

	@FXML
	private TextField serverNamePortNumTextField;
	@FXML
	private TextField databaseNameTextField;
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button loginButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Text loginStatusTextField;
	@FXML
	private ComboBox<String> authenticationTypeComboBox;

	private LoginManager loginManager;

	private final InvalidationListener authenticationTypeComboBoxSelectedItemListener = observable -> this.doThisWhenSelectionChanged();
	UnaryOperator<Change> filter = change -> {
		/*String text = change.getText();
		if (text.matches("[0-9]*")) {
			return change;
		}
		return null;*/
		//return change.getText().toUpperCase();
		return null;
	};

	public void initialize()
	{
		this.serverNamePortNumTextField.textProperty().addListener((observable, oldValue, newValue) -> this.doThis(newValue));
		//serverNamePortNumTextField.setTextFormatter(new TextFormatter<String>(filter));
		/*serverNamePortNumTextField.setTextFormatter(new TextFormatter<>(new StringConverter<String>() {

			@Override
			public String toString(String object) {
				//return null;
				return "a";
			}

			@Override
			public String fromString(String string) {
				//return null;
				return "b";
			}
		}));*/
		//loginStatusTextField.textProperty().bind(Bindings.concat("jdbc:jtds:sqlserver://").concat(serverNamePortNumTextField.textProperty()).concat(";databaseName=").concat(databaseNameTextField.textProperty()));
		//usernameTextField.disableProperty().bind(authenticationTypeComboBox.valueProperty().isEqualTo("Windows Authentication"));
		this.bind();
		this.addListeners();
	}

	private void bind()
	{
		this.loginButton.disableProperty().bind(this.serverNamePortNumTextField.textProperty().isEmpty().or(this.databaseNameTextField.textProperty().isEmpty().or(this.usernameTextField.textProperty().isEmpty().or(this.passwordTextField.textProperty().isEmpty()))));
		//this.rememberMeCheckBox.disableProperty().bind(this.serverNamePortNumTextField.textProperty().isEmpty().or(this.databaseNameTextField.textProperty().isEmpty().or(this.usernameTextField.textProperty().isEmpty().or(this.passwordTextField.textProperty().isEmpty()))));
	}

	private void addListeners()
	{
		this.authenticationTypeComboBox.getSelectionModel().selectedItemProperty().addListener(this.authenticationTypeComboBoxSelectedItemListener);
	}

	public void initManager(final LoginManager loginManager)
	{
		this.loginManager = loginManager;
		/*loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent event) {
				String sessionID = authorize();
				if (sessionID != null) {
					loginManager.authenticated(sessionID);
				}
			}
		});

		cancelButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Platform.runLater(() -> { Platform.exit(); System.exit(0); } );
			}
		});*/
	}

	@FXML
	private void handleLoginButtonClick()
	{
		try
		{
			this.login();
		}
		catch(final SQLException exception)
		{
			LOGGER.error("Login Failed.", exception);
		}
	}

	@FXML
	private void handleCancelButtonClick()
	{
		Platform.runLater(() -> {
			this.cleanUpBindingsAndListeners();
			Platform.exit();
			System.exit(0);
		});
	}

	private void login() throws SQLException
	{
		/*String sessionID = authorize();
		if(sessionID != null)
			loginManager.authenticated(sessionID);*/
		try
		{
			if(this.authorize())
			{
				this.loginManager.authenticated();
			}
			else
			{
				//loginStatusTxt.setText("Login Failure");
			}
		}
		catch(final SQLException exception)
		{
			throw exception;
		}
	}

	/**
	 * Check authorization credentials.
	 * If accepted, return a sessionID for the authorized session
	 * otherwise, return null.
	 */
	String connectionURL = null;

	private boolean authorize() throws SQLException
	{
		//final boolean isFirstTimeLogin = !PreferencesHelper.getUserPreferences().getBoolean(StaticConstantsHelper.IS_AUTHENTICATED_USER, DEFAULT_BOOLEAN_VALUE);
		boolean isAuthorized = DEFAULT_BOOLEAN_VALUE;

		if(true)
		{
			/* no key in registry. so may be this is the first time login */
			final boolean isWindowsAuthentication = this.authenticationTypeComboBox.getValue().equals("Windows Authentication") ? true : false;
			//final boolean shouldRemember = this.rememberMeCheckBox.isSelected();
			final String serverName = this.serverNamePortNumTextField.getText();
			final String databaseName = this.databaseNameTextField.getText();
			final String username = isWindowsAuthentication ? null : this.usernameTextField.getText();
			final String password = isWindowsAuthentication ? null : this.passwordTextField.getText();
			//String connectionURL = MessageFormat.format(StaticConstantsHelper.CONNECTION_URL, serverName, databaseName);
			this.connectionURL = MessageFormat.format(StaticConstantsHelper.CONNECTION_URL_FORMAT, serverName, databaseName);

			try
			{
				isAuthorized = DatabaseUtil.makeTestConnection(this.connectionURL, username, password);
				if(isAuthorized)
				{
					this.loginStatusTextField.setText("Login Success...");
					PropertiesHelper.setAsSystemProperty("ConnectionUrl", this.connectionURL);
					if(username != null)
					{
						PropertiesHelper.setAsSystemProperty("Username", username);
					}
					if(password != null)
					{
						PropertiesHelper.setAsSystemProperty("Password", password);
					}
					this.cleanUpBindingsAndListeners();
				}
			}
			catch(final SQLException exception)
			{
				this.loginStatusTextField.setText(exception.getMessage());
			}
		}
		return isAuthorized;
	}

	private void doThisWhenSelectionChanged()
	{
		if(this.authenticationTypeComboBox.getSelectionModel().getSelectedIndex() == 0) //SQL Authentication
		{
			this.usernameTextField.setText(null);
			this.passwordTextField.setText(null);
			this.usernameTextField.setDisable(false);
			this.passwordTextField.setDisable(false);
			this.usernameTextField.requestFocus();
		}
		else if(this.authenticationTypeComboBox.getSelectionModel().getSelectedIndex() == 1) //Windows Authentication
		{
			this.usernameTextField.setText(System.getenv("username"));
			this.passwordTextField.setText(System.getenv("username"));
			this.usernameTextField.setDisable(true);
			this.passwordTextField.setDisable(true);
		}
	}

	private void doThis(final String newValue)
	{
		this.serverNamePortNumTextField.setText(newValue.toUpperCase());
	}

	private void cleanUpBindingsAndListeners()
	{
		this.unbindAll();
		this.removeAllListeners();
	}

	private void unbindAll()
	{
		this.loginButton.disableProperty().unbind();
	}

	private void removeAllListeners()
	{
		this.authenticationTypeComboBox.getSelectionModel().selectedItemProperty().removeListener(this.authenticationTypeComboBoxSelectedItemListener);
	}
}