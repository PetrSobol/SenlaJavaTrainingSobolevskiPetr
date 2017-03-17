package com.senla.sobol.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.BookDao;
import com.senla.sobol.interfaces.IBookService;
import com.senla.sobol.model.Book;

public class BookService implements IBookService {
	private BookDao bookdao;
	private SessionFactory sessionfactory;
	private Logger log = Logger.getLogger(BookService.class.getName());

	public BookService() {
		super();
		this.bookdao = new BookDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public Book getBookId(Integer idBook) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			Book book = bookdao.getIdBook(session, idBook);
			session.getTransaction().commit();
			return book;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}

	public void delete(Book idbook) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			bookdao.deleteBook(session, idbook);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(Book t) {
		Session session = null;

		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			bookdao.updateBook(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void add(Book t) {
		Session session = null;

		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			bookdao.addNewBook(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public List<Book> getAll(String date) {
		Session session = null;

		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			List<Book> listbook = bookdao.getReadAllTable(session, date);
			session.getTransaction().commit();
			return listbook;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}

}
