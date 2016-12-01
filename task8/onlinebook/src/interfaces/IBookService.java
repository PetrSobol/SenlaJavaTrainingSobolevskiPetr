package interfaces;

import java.util.List;

import com.senla.sobol.model.IBook;

public interface IBookService {
	public void addBook(IBook book);

	public void deleteBook(String namebook);

	public List<IBook> getListBook();

	public void updateBook(IBook book, IBook book2);

	public IBook searchBook(String name);

	public void setBookdao(IBookDao bookdao);
}
