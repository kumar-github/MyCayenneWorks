package application;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.configuration.server.ServerRuntimeBuilder;
import org.apache.cayenne.query.ObjectSelect;

import com.tc.app.exchangemonitor.model.cayenne.persistent.Account;

/**
 * Copyright (c) 2016 by amphorainc.com. All rights reserved.
 * created on Nov 18, 2016
 */

/**
 * @author Saravana Kumar M
 *
 */
public class CayenneMainClass
{
	public static void main(final String[] args)
	{
		/*
		final DataSource dataSource = DataSourceBuilder.url("jdbc:jtds:sqlserver://HYDDB07:1460/QA_30_trade_nov22").userName("ictspass").password("ictspass").driver("net.sourceforge.jtds.jdbc.Driver").pool(1, 2).build();
		final ServerRuntime serverRuntime = ServerRuntimeBuilder.builder().addConfig("cayenne-project.xml").dataSource(dataSource).build();
		 */
		final ServerRuntime serverRuntime = ServerRuntimeBuilder.builder().addConfig("cayenne/cayenne-ExchangeMonitor.xml").build();
		System.out.println(serverRuntime.getDataDomain());
		System.out.println(serverRuntime.getDataSource());
		System.out.println(serverRuntime.getModules());
		System.out.println(serverRuntime);

		final ObjectContext context = serverRuntime.newContext();
		final long startTime3 = System.currentTimeMillis();
		final List<Account> accounts = ObjectSelect.query(Account.class).select(context);
		final long endTime3 = System.currentTimeMillis();
		System.out.println("It took " + (endTime3 - startTime3) + " millisecs to fetch " + accounts.size() + " records");
		System.out.println("testing");

		/*
		final long startTime = System.currentTimeMillis();
		final ObjectContext context = serverRuntime.newContext();
		final long endTime = System.currentTimeMillis();
		System.out.println("To load context : " + (endTime - startTime));
		System.out.println(context);
		final long startTime2 = System.currentTimeMillis();
		final List<Trade> trades = ObjectSelect.query(Trade.class).where(Trade.ACCT_SHORT_NAME.ne("XTCCNTRPRTY")).select(context);
		final long endTime2 = System.currentTimeMillis();
		System.out.println("To fetch trades : " + (endTime2 - startTime2));
		System.out.println(trades.size());
		//trades.stream().forEach(System.out::println);

		//final List<Trade> aTrade = SelectById.query(Trade.class, 2000003).select(context);
		//System.out.println(aTrade);*/
	}
}