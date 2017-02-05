package com.senla.sobol.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Book;

public class BookDao extends ACommonDAO<Book> {
	private static final String ID_BOOK = "idBook";

	public BookDao() {
		super(Book.class);
	}

	public void addNewBook(Session session, Book t) {
		addNew(session, t);
	}

	public List<Book> getReadAllTable(Session session,String date) {
		List<Book> listbook = getAll(session,date);
		return listbook;
	}

	public void deleteBook(Session session, Book idbook) {
		delete(session, idbook);
	}

	public void updateBook(Session session, Book t) {
		update(session, t);
	}

	public Book getIdBook(Session session, Integer id) {
		Book book = getID(session, id);
		return book;
	}

	@Override
	public String getIdSearch() {
		return ID_BOOK;
	}

}
