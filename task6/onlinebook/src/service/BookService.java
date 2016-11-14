package service;

import java.util.List;

import dao.BookDao;
import model.Book;

public class BookService {
	private BookDao bookdao;

	/**
	 * search book by name and return Book
	 * 
	 * @param name
	 * @return
	 */
	public Book searchBook(String name) {

		Book book = bookdao.search(name);
		if (book != null) {
			return book;
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

	public void updateBook(Book book, Book book2) {
		bookdao.updateBook(book, book2);
	}
}
