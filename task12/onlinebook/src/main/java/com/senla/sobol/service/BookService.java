package com.senla.sobol.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.BookDao;
import com.senla.sobol.interfaces.IBookService;
import com.senla.sobol.model.Book;

public class BookService implements IBookService {
	private BookDao bookdao;
	private SessionFactory sessionfactory;

	public BookService() {
		super();
		this.bookdao = new BookDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public Book getBookId(Integer idBook) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Book book = bookdao.getIdBook(session, idBook);
		session.getTransaction().commit();
		session.close();
		return book;
	}

	public void delete(Book idbook) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		bookdao.deleteBook(session, idbook);
		session.getTransaction().commit();
		session.close();

	}

	public void update(Book t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		bookdao.updateBook(session, t);
		session.getTransaction().commit();
		session.close();
	}

	public void add(Book t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		bookdao.addNewBook(session, t);
		session.getTransaction().commit();
		session.close();
	}

	public List<Book> getAll(String date) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		List<Book> listbook = bookdao.getReadAllTable(session,date);
		session.getTransaction().commit();
		session.close();
		return listbook;
	}

}
