package com.senla.sobol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.BookDao;
import com.senla.sobol.interfaces.IBookService;
import com.senla.sobol.model.IBook;

public class BookService implements IBookService {
	private BookDao bookdao;
	private Connection connection;
	private static Logger log = Logger.getLogger(BookService.class.getName());

	public BookService() {
		super();
		this.bookdao = new BookDao();
		try {
			this.connection = DBConnector.getInstance().getConnection();
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public IBook getBookId(Integer idBook) {
		IBook book = bookdao.getIdBook(connection, idBook);
		return book;
	}

	public void delete(Integer idbook) {
		bookdao.deleteBook(connection, idbook);

	}

	public void update(IBook t) {
		try {
			bookdao.updateBook(connection, t);
		} catch (SQLException e) {
			log.error(e);
		}

	}

	public void add(IBook t) {
		try {
			bookdao.addNewBook(connection, t);
		} catch (SQLException e) {
			log.error(e);
		}

	}

	public List<IBook> getAll(String date) {
		List<IBook> listbook = null;
		if (date != null) {
			listbook = bookdao.getReadAllTable(connection, date);
		} else {
			listbook = bookdao.getReadAllTable(connection, null);
		}

		return listbook;
	}

}
