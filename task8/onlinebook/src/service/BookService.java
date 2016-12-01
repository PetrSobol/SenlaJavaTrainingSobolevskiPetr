package service;

import java.util.List;

import com.senla.sobol.model.IBook;

import interfaces.IBookDao;
import interfaces.IBookService;

public class BookService implements IBookService {
	private IBookDao bookdao;

	/**
	 * search book by name and return Book
	 * 
	 * @param name
	 * @return
	 */
	public BookService() {

	}

	public IBook searchBook(String name) {

		IBook book = bookdao.search(name);
		if (book != null) {
			return book;
		}

		return null;
	}

	public BookService(IBookDao bookdao) {
		this.bookdao = bookdao;
	}

	public IBookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(IBookDao bookdao) {
		this.bookdao = bookdao;
	}

	public void addBook(IBook book) {
		bookdao.addBook(book);
	}

	public void deleteBook(String namebook) {
		bookdao.deleteBook(namebook);
	}

	public List<IBook> getListBook() {
		List<IBook> listbook = bookdao.getListBook();
		return listbook;
	}

	public void updateBook(IBook book, IBook book2) {
		bookdao.updateBook(book, book2);
	}
}
