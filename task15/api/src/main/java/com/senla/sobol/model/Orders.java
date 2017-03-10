package com.senla.sobol.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.senla.sobol.intarfaces.AEntity;
import com.sobol.senla.anotation.PrintableObject;

@Entity
@Table(name = "orders")
@PrintableObject(name = "Order")
public class Orders extends AEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOrder")
	private Integer idOrder;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCustomer")
	private Customer customer;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idBook")
	private Book book;
	@Column(name = "dateOrder")
	private Date dateOrder;

	public Orders() {
		super();
	}

	public Orders(Book book, Customer customer, Date dateOrder) {
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

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

}
