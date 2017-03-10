package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.Book;
public interface IBookService {
	public Book getBookId(Integer idBook);

	public void delete(Book idbook);

	public void update(Book t);

	public void add(Book t);

	public List<Book> getAll(String date);
}
