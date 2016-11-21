package interfaces;

import java.util.List;

import model.Book;

public interface IBookService {
	public void addBook(Book book);

	public void deleteBook(String namebook);

	public List<Book> getListBook();

	public void updateBook(Book book, Book book2);

	public Book searchBook(String name);

	public void setBookdao(IBookDao bookdao);
}
