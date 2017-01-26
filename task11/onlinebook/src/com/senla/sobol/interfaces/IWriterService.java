package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.IWriter;

public interface IWriterService {
	public IWriter getWriter(Integer id);

	public void delete(Integer idWriter);

	public void update(IWriter t);

	public void add(IWriter t);

	public List<IWriter> getAll(String date);

}
