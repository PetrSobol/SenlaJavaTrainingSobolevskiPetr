package service;

import java.util.List;

import dao.BookDao;
import model.Book;

public class BookService {
	private BookDao bookdao;
	private List<Book> listbook;

	public BookService(BookDao bookdao) {
		this.bookdao = bookdao;
		this.listbook = bookdao.getListBook();
	}

	public void addBook(Book book) {
		this.listbook.add(book);
	}

	public void deleteBook(String namebook) {
		this.listbook.remove(bookdao.searchBook(namebook));
	}

	

}
