package com.senla.sobol.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.senla.sobol.di.PropertyInstance;

public class DBConnector {
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final String URL = "url";
	private static Logger log = Logger.getLogger(DBConnector.class.getName());
	private static DBConnector creatConnection;
	private Connection connection;
	private PropertyInstance propertyinstance = new PropertyInstance();

	private DBConnector() {
		try {
			connection = DriverManager.getConnection(propertyinstance.load(URL), propertyinstance.load(USERNAME),
					propertyinstance.load(PASSWORD));
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public Connection getConnection() throws SQLException {
		return connection;
	}

	public static DBConnector getInstance() throws SQLException {

		if (creatConnection == null) {
			creatConnection = new DBConnector();
		}

		return creatConnection;
	}

	public void closeDBConnector() {
		try {
			connection.close();
		} catch (SQLException e) {
			log.error(e);
		}
	}
}
