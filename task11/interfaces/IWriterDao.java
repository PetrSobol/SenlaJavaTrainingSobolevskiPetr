package interfaces;

import java.sql.Connection;

import com.senla.sobol.model.IWriter;

public interface IWriterDao extends ICommonDAO<IWriter> {
	public IWriter getWriter(Integer id);

	public void setConnection(Connection connection);
}
