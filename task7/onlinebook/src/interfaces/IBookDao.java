package interfaces;

import java.util.List;

import model.Book;

public interface IBookDao {
	public List<Book> getListBook();

	public void addBook(Book book);

	public void deleteBook(String namebook);

	public void updateBook(Book book, Book book2);

	public Book search(String name);

	public int searchBook(String name);

	public void setListbook(List<Book> listbook);
}
