package dao;

import java.io.Serializable;
import java.util.List;

import model.Book;

public class BookDao {
	private List<Book> listbook;

	public BookDao(List<Book> listbook) {
		this.listbook = listbook;
	}

	public List<Book> getListBook() {
		return listbook;
	}

	public void addBook(Book book){
		this.listbook.add(book);
	}
	
	public void deleteBook(String namebook){
		this.listbook.remove(searchBook(namebook));
	}
	// We are looking for a book on the number and return its index
	public int searchBook(String name) {
		int number = 0;
		for (Book book : listbook) {
			if (book.getName().equals(name)) {

				return number;
			}
			number++;
		}
		return number;
	}
}
