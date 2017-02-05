package com.senla.sobol.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sobol.senla.anotation.PrintableObject;
@Entity
@Table(name = "orders")
@PrintableObject(name = "Order")
public class Orders implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idOrder")
	private Integer idOrder;
	@ManyToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="idBook")
	private Book book;
	@Column(name = "dateOrder")
	private String dateOrder;

	public Orders() {
		super();
	}

	public Orders(Book book, Customer customer, String dateOrder) {
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

}
