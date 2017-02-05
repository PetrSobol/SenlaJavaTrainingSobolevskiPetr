package com.senla.sobol.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnector {
	private static DBConnector creatConnection;
	private SessionFactory sessionfactory;

	private DBConnector() {
		sessionfactory = new Configuration().configure().buildSessionFactory();
	}

	public SessionFactory getConnection()  {
		return sessionfactory;
	}

	public static DBConnector getInstance()  {

		if (creatConnection == null) {
			creatConnection = new DBConnector();
		}
		return creatConnection;
	}

	public void closeDBConnector() {
		sessionfactory.close();
	}
}
