package interfaces;

import com.senla.sobol.model.IWriter;

public interface IWriterService extends ICommonService<IWriter> {
	public void setWriterdao(IWriterDao writerdao);

	public IWriter getWriter(Integer id);
}
