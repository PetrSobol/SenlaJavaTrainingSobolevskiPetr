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

	public void addBook(Book book) {
		this.listbook.add(book);
	}

	public void deleteBook(String namebook) {
		this.listbook.remove(searchBook(namebook));
	}

	public void updateBook(Book book, Book book2) {
		if (book2 != null) {
			book2.setWriter(book.getWriter());
			book2.setId(book.getId());
			book2.setPrice(book.getPrice());
			book2.setQuantityPages(book.getQuantityPages());
			book2.setStage(book.getStage());
		}

	}

	public Book search(String name) {

		for (Book book : getListBook()) {
			if (book.getName().equals(name)) {
				return book;
			}
		}
		return null;
	}

	/**
	 * We are looking for a book on the number and return its index
	 * 
	 * @param name
	 * @return
	 */
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
