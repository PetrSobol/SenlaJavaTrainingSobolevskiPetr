package service;

import java.io.Serializable;
import java.util.List;

import dao.BookDao;
import model.Book;

public class BookService {
	private BookDao bookdao;

	// search book by name and return Book
	public Book searchBook(String name) {

		for (Book book : bookdao.getListBook()) {
			if (book.getName().equals(name)) {
				return book;
			}
		}
		return null;
	}

	public BookService(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	public void addBook(Book book) {
		bookdao.addBook(book);
	}

	public void deleteBook(String namebook) {
		bookdao.deleteBook(namebook);
	}

	public List<Book> getListBook() {
		List<Book> listbook = bookdao.getListBook();
		return listbook;
	}
}
