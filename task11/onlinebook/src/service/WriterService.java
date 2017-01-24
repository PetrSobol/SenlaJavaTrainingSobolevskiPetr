package service;

import java.util.List;

import com.senla.sobol.model.IWriter;

import interfaces.IWriterDao;
import interfaces.IWriterService;

public class WriterService implements IWriterService {
	private IWriterDao writerdao;

	public WriterService() {
		super();
	}

	public WriterService(IWriterDao writer) {
		super();
		this.writerdao = writer;
	}

	@Override
	public void delete(IWriter t) {
		writerdao.delete(t);

	}

	@Override
	public void update(IWriter t) {
		writerdao.update(t);

	}

	@Override
	public void add(IWriter t) {
		writerdao.addNew(t);

	}

	@Override
	public List<IWriter> getAll() {
		List<IWriter> listwriter = writerdao.getReadAllTable();
		return listwriter;
	}

	public void setWriterdao(IWriterDao writerdao) {
		this.writerdao = writerdao;
	}

	public IWriter getWriter(Integer id) {
		IWriter writer = writerdao.getWriter(id);
		return writer;

	}
}
