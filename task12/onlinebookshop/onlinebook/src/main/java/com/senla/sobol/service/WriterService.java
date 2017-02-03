package com.senla.sobol.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.WriterDao;
import com.senla.sobol.interfaces.IWriterService;
import com.senla.sobol.model.Writer;

public class WriterService implements IWriterService {
	private SessionFactory sessionfactory;
	private WriterDao writerdao;

	public WriterService() {
		super();

		this.writerdao = new WriterDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public void delete(Writer Writer) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		writerdao.deleteWriter(session, Writer);
		session.getTransaction().commit();
		session.close();

	}

	public void update(Writer t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		writerdao.updateWriter(session, t);
		session.getTransaction().commit();
		session.close();
	}

	public void add(Writer t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		writerdao.addNewWriter(session, t);
		session.getTransaction().commit();
		session.close();
	}

	public List<Writer> getAll(String date) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		List<Writer> listwriter = writerdao.getReadAllTable(session, date);
		session.getTransaction().commit();
		session.close();
		return listwriter;
	}

	public Writer getWriter(Integer id) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Writer writer = writerdao.getIdWriter(session, id);
		session.getTransaction().commit();
		session.close();
		return writer;
	}
}
