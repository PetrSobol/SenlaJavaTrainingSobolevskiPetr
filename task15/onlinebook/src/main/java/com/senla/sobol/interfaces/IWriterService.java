package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.Writer;


public interface IWriterService {
	public Writer getWriter(Integer id);

	public void delete(Writer Writer);

	public void update(Writer t);

	public void add(Writer t);

	public List<Writer> getAll(String date);

}
