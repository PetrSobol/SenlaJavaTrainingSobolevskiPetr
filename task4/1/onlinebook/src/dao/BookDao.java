package dao;

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
