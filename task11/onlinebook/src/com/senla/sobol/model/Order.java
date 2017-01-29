package com.senla.sobol.model;

import java.io.Serializable;
import java.util.Date;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;
import com.sobol.senla.anotation.PrintableObject;

@PrintableObject(name = "Order")
public class Order implements Serializable, IOrder {
	private Integer idOrder;
	private IBook book;
	private ICustomer customer;
	private Date dateOrder;

	public Order() {
		super();
	}

	public Order(IBook book, ICustomer customer, Date dateOrder) {
		super();
		this.book = book;
		this.customer = customer;
		this.dateOrder = dateOrder;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public IBook getBook() {
		return book;
	}

	public void setBook(IBook book) {
		this.book = book;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

}
