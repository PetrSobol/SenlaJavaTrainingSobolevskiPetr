package com.senla.sobol.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.WriterDao;
import com.senla.sobol.interfaces.IWriterService;
import com.senla.sobol.model.Writer;

public class WriterService implements IWriterService {
	private SessionFactory sessionfactory;
	private WriterDao writerdao;
	private Logger log = Logger.getLogger(WriterService.class.getName());

	public WriterService() {
		super();

		this.writerdao = new WriterDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public void delete(Writer Writer) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			writerdao.deleteWriter(session, Writer);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(Writer t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			writerdao.updateWriter(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void add(Writer t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			writerdao.addNewWriter(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public List<Writer> getAll(String date) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			List<Writer> listwriter = writerdao.getReadAllTable(session, date);
			session.getTransaction().commit();
			return listwriter;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}

	public Writer getWriter(Integer id) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			Writer writer = writerdao.getIdWriter(session, id);
			session.getTransaction().commit();
			return writer;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}
}
