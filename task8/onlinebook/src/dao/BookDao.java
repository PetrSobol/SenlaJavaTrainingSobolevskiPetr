package dao;

import java.util.List;

import com.senla.sobol.model.IBook;

import interfaces.IBookDao;


public class BookDao implements IBookDao {
	private List<IBook> listbook;

	public BookDao() {

	}

	public BookDao(List<IBook> listbook) {
		this.listbook = listbook;
	}

	public List<IBook> getListBook() {
		return listbook;
	}


	public void setListbook(List<IBook> listbook) {
		this.listbook = listbook;
	}

	public void addBook(IBook book) {
		this.listbook.add(book);
	}

	public void deleteBook(String namebook) {
		this.listbook.remove(searchBook(namebook));
	}

	public void updateBook(IBook book, IBook book2) {
		if (book2 != null) {
			book2.setWriter(book.getWriter());
			book2.setId(book.getId());
			book2.setPrice(book.getPrice());
			book2.setQuantityPages(book.getQuantityPages());
			book2.setStage(book.getStage());
		}

	}

	public IBook search(String name) {

		for (IBook book : getListBook()) {
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
		for (IBook book : listbook) {
			if (book.getName().equals(name)) {

				return number;
			}
			number++;
		}
		return number;
	}
}
