package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.IBook;

public interface IBookService {
	public IBook getBookId(Integer idBook);

	public void delete(Integer idbook);

	public void update(IBook t);

	public void add(IBook t);

	public List<IBook> getAll(String date);
}
