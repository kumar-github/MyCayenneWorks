package com.tc.app.exchangemonitor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.javafx.application.LauncherImpl;
import com.tc.app.exchangemonitor.util.CayenneHelper;
import com.tc.app.exchangemonitor.util.CayenneReferenceDataCache;
import com.tc.app.exchangemonitor.util.HibernateUtil;
import com.tc.app.exchangemonitor.util.ReferenceDataCache;
import com.tc.app.exchangemonitor.view.java.MainWindowView;
import com.tc.framework.injection.Injector;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

@SuppressWarnings("restriction")
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

	public static void main(final String[] args)
	{
		LOGGER.debug("ExchangeMonitorApplication main called by ", Thread.currentThread().getName());
		Application.launch();
		//LauncherImpl.launchApplication(ExchangeMonitorApplication.class, ExchangeMonitionApplicationPreloader.class, args);
	}

	@Override
	public void init()
	{
		LOGGER.debug("ExchangeMonitorApplication init called by ", Thread.currentThread().getName());
		HibernateUtil.getSessionFactory();
		CayenneHelper.initializeCayenneServerRuntime();
		this.testCall();
		ReferenceDataCache.loadAllReferenceData();
		CayenneReferenceDataCache.fetchAllReferenceData();
		for(int i = 0; i < 1000; i++)
		{
			final double progress = (100 * i) / 1000;
			LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
		}
	}

	@Override
	public void start(final Stage primaryStage)
	{
		//System.out.println(HibernateReferenceDataFetchUtil.fetchDataFromDBForSQLNamedQuery("GenNewTransactionSP"));
		//System.out.println(HibernateReferenceDataFetchUtil.fetchDataFromDBForSQLNamedQuery("testStoredProc"));
		//System.out.println(HibernateUtil.beginTransaction().getNamedQuery("testStoredProc").list());
		//HibernateUtil.beginTransaction().getNamedQuery("testStoredProc").executeUpdate();
		//HibernateUtil.beginTransaction().getNamedQuery("testStoredProc").list();

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

	private Scene createPrimaryScene()
	{
		final MainWindowView mainWindowView = new MainWindowView(this.primaryStage);
		return mainWindowView.getScene();
	}

	private void animateStageIfNeeded()
	{
		this.setFadeInTransition();
		//setRotateTransition();
	}

	private void setFadeInTransition()
	{
		//super.setOpacity(0);
		this.primaryScene.getRoot().setOpacity(0.0);
		//primaryStage.setOpacity(0);
		this.primaryStage.showingProperty().addListener((observableValue, oldValue, newValue) -> {
			if(newValue)
			{
				final FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), this.primaryScene.getRoot());
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
		HibernateUtil.closeSessionFactory();
		CayenneHelper.getCayenneServerRuntime().shutdown();
		LOGGER.info("Application Terminated.");
		Platform.exit();
		System.exit(0);
	}

	private void testCall()
	{
		/*
		final String query = "SELECT MAX(trans_id) AS MaxTransID, COUNT(*) AS RecordCount from  external_trade";
		final List<DataRow> data = SQLSelect.dataRowQuery(query).select(CayenneHelper.getCayenneServerRuntime().newContext());
		final Integer a = (Integer) data.get(0).get("MaxTransID");
		final Integer b = (Integer) data.get(0).get("RecordCount");
		System.out.println(a);
		System.out.println(b);
		System.exit(0);
		 */

		//final EJBQLQuery query = new EJBQLQuery("select user FROM IctsUser user JOIN user.userJobTitle title");
		/*final EJBQLQuery query = new EJBQLQuery("select account FROM Account account JOIN account.accountType code");
		long startTime = System.currentTimeMillis();
		CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));
		System.exit(0);
		 */

		/*
		final ProcedureQuery getNewNumProcedureQuery = new ProcedureQuery("get_new_num");
		getNewNumProcedureQuery.addParameter("key_name", "external_mapping_oid");
		getNewNumProcedureQuery.addParameter("location_num", 0);

		final List data = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(getNewNumProcedureQuery);
		if(!data.isEmpty())
		{
			final Integer newNum = ((Map<String, Integer>) data.get(0)).get("");
			System.out.println(newNum);
		}
		 */

		/*
		long startTime = System.currentTimeMillis();
		ObjectSelect.query(Account.class).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		long endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		ObjectSelect.query(Account.class).prefetch(Account.ACCOUNT_TYPE.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		endTime = System.currentTimeMillis();
		System.out.println("Time : " + (endTime - startTime));
		 */

		/*
		final EJBQLQuery query = new EJBQLQuery("select ets FROM ExternalTradeSource ets");
		final List<ExternalTradeSource> x = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(query);
		System.out.println(x);
		x.forEach((a) -> System.out.println(a.getExternalTradeSrcName()));
		final SQLTemplate select = new SQLTemplate(ExternalTradeState.class, "select * from external_trade_state");
		final List<ExternalTradeState> y = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(select);
		System.out.println(x);
		y.forEach((a) -> System.out.println(a.getExternalTradeStateName()));
		//final String ss = "SELECT et.* FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.external_trade_source_oid IN (:externalTradeSourcesParam)) AND (et.external_trade_status_oid IN (:externalTradeStatusesParam)) AND (et.external_trade_state_oid IN (:externalTradeStatesParam)) AND (ett.buyer_account IN (:buyerAccountsParam)) AND (ett.creation_date >= (:startDate)) AND (ett.creation_date <= (:endDate)) ORDER BY ett.creation_date DESC";
		final String ss = "SELECT et.* FROM dbo.external_trade AS et LEFT OUTER JOIN dbo.external_comment AS ec ON et.external_comment_oid = ec.oid INNER JOIN dbo.exch_tools_trade AS ett ON et.oid = ett.external_trade_oid WHERE (et.oid = 18853833)";
		final SQLTemplate select1 = new SQLTemplate(ExternalTrade.class, ss);
		final List<ExternalTrade> ab = CayenneHelper.getCayenneServerRuntime().newContext().performQuery(select1);
		System.out.println(ab);
		ab.forEach((a) -> System.out.println(a.getExternalTradeStateO()));
		final List<ExternalTrade> abcd = ObjectSelect.query(ExternalTrade.class).where(ExternalTrade.EXTERNAL_TRADE_STATUS_O.dot(ExternalTradeStatus.EXTERNAL_TRADE_STATUS_NAME).eq("Pending")).prefetch(ExternalTrade.EXTERNAL_TRADE_O1.joint()).select(CayenneHelper.getCayenneServerRuntime().newContext());
		System.out.println(abcd);
		abcd.forEach((a) -> System.out.println(a.getExternalTradeO1().getExchToolsTradeNum()));
		System.exit(0);*/
	}
}