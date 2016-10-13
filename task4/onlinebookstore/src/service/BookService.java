package service;

import java.util.List;

import database.DataBase;
import model.Book;

public class BookService extends AService {
	private DataBase database = new DataBase();
	private List<Book> listbook;

	public List<Book> getBooks() {
		return this.listbook;
	}

	public List<Book> getListBook() {
		listbook = getListBook(listbook, database.getBook());
		return listbook;
	}

	

	@Override
	public void writeBook(String[] word) {
		String[] books = database.getBook();
		database.addBookCatalog(anAssociation(books, word));

	}

}
