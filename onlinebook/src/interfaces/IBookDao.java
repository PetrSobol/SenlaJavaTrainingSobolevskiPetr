package interfaces;

import java.util.List;

import com.senla.sobol.model.IBook;

public interface IBookDao {
	public List<IBook> getListBook();

	public void addBook(IBook book);

	public void deleteBook(String namebook);
	public void updateBook(IBook book, IBook book2);

	public IBook search(String name);

	public int searchBook(String name);

	public void setListbook(List<IBook> listbook);
}
