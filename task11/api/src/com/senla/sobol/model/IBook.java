package com.senla.sobol.model;

import java.io.Serializable;

public interface IBook extends Serializable {
	public IWriter getWriter();

	public void setWriter(IWriter writer);

	public Integer getIdBook();

	public String getNameBook();

	public Integer getQuantityPages();

	public Integer getPrice();

	public void setIdBook(Integer idBook);

	public void setNameBook(String nameBook);

	public void setQuantityPages(Integer quantityPages);

	public void setPrice(Integer price);
}
