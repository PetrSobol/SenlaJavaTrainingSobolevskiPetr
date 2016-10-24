package service;

import java.util.List;

import dao.BookDao;
import model.Book;

public class BookService {
	private BookDao bookdao;


	public BookService(BookDao bookdao) {
		this.bookdao = bookdao;
		}

	public void addBook(Book book) {
		bookdao.getListBook().add(book);
	}
	public void deleteBook(String namebook) {
		bookdao.getListBook().remove(bookdao.searchBook(namebook));
	}
	public List<Book> getListBook(){
		List<Book> listbook=bookdao.getListBook();
	    return listbook;
	}
}
