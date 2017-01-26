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

	public Boolean searchIdWriter(Integer idWriter) {
		List<IBook> listbook = getAll(null);
		for (IBook book : listbook) {
			if (book.getWriter().getIdWriter().equals(idWriter)) {
				return true;
			}
		}
		return false;

	}

	public IBook findbook(IBook bookfind) {
		List<IBook> listbook = bookdao.getReadAllTable(connection,null);
		for (IBook book : listbook) {
			if (!bookfind.getNameBook().equals(book.getNameBook())
					|| bookfind.getWriter().getIdWriter().equals(book.getWriter().getIdWriter())) {
				return book;
			}
		}
		return null;
	}

	public IBook getBook(Integer idBook) {
		IBook book = bookdao.getBook(connection,idBook);
		return book;
	}



	public void delete(Integer idbook) {
		bookdao.delete(connection,idbook);

	}


	public void update(IBook t) {
		try {
			bookdao.update(connection,t);
		} catch (SQLException e) {
			log.error(e);
		}

	}


	public void add(IBook t) {
		bookdao.addNew(connection,t);

	}


	public List<IBook> getAll(String date) {
		List<IBook> listbook=null;
		if(date!=null){
			listbook = bookdao.getReadAllTable(connection,date);
		}else{
			listbook = bookdao.getReadAllTable(connection,null);
		}
		
		return listbook;
	}

}
