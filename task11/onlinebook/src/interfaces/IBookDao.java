package interfaces;

import java.sql.Connection;

import com.senla.sobol.model.IBook;

public interface IBookDao extends ICommonDAO<IBook> {
	public IBook getBook(Integer idBook);

	public void setConnection(Connection connection);
}
