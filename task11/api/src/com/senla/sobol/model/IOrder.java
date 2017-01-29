package com.senla.sobol.model;

import java.util.Date;

public interface IOrder {
	public IBook getBook();

	public void setBook(IBook book);

	public ICustomer getCustomer();

	public void setCustomer(ICustomer customer);

	public Date getDateOrder();

	public void setDateOrder(Date dateOrder);

	public void setIdOrder(Integer idOrder);

	public Integer getIdOrder();
}
