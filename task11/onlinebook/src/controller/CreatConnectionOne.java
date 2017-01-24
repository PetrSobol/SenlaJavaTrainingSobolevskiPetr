package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.senla.sobol.di.PropertyInstance;

public class CreatConnectionOne {
	private static Logger log = Logger.getLogger(CreatConnectionOne.class.getName());
	private static CreatConnectionOne creatConnection;
	private Connection connection;
	private PropertyInstance propertyinstance = new PropertyInstance();

	private CreatConnectionOne() {
		try {
			connection = DriverManager.getConnection(propertyinstance.load("url"), propertyinstance.load("username"),
					propertyinstance.load("password"));
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public Connection getConnection() throws SQLException {
		return connection;
	}

	public static CreatConnectionOne getInstance() throws SQLException {

		if (creatConnection == null) {
			creatConnection = new CreatConnectionOne();
		}

		return creatConnection;
	}
}
