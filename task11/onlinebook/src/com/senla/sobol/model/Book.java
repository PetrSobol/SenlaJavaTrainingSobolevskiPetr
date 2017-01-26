package com.senla.sobol.model;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IWriter;
import com.sobol.senla.anotation.PrintableObject;

@PrintableObject(name = "Book")
public class Book implements  IBook {

	private Integer idBook;
	private IWriter writer;
	private String nameBook;
	private Integer quantityPages;
	private Integer price;

	public Book() {
		super();
	}

	public Book(IWriter writer, String nameBook, Integer quantityPages, Integer price) {
		super();
		this.writer=writer;
		this.nameBook = nameBook;
		this.quantityPages = quantityPages;
		this.price = price;
	}

	public IWriter getWriter() {
		return writer;
	}

	public void setWriter(IWriter writer) {
		this.writer = writer;
	}

	public Integer getIdBook() {
		return idBook;
	}
	public String getNameBook() {
		return nameBook;
	}

	public Integer getQuantityPages() {
		return quantityPages;
	}

	public Integer getPrice() {
		return price;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public void setQuantityPages(Integer quantityPages) {
		this.quantityPages = quantityPages;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
