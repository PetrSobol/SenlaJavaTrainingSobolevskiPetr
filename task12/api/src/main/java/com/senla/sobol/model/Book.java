package com.senla.sobol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.senla.sobol.intarfaces.AEntity;
import com.sobol.senla.anotation.PrintableObject;

@Entity
@Table(name = "book")
@PrintableObject(name = "Book")
public class Book extends AEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBook")
	private Integer idBook;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idWriter")
	private Writer writer;
	@Column(name = "nameBook")
	private String nameBook;
	@Column(name = "quantityBook")
	private Integer quantityPages;
	@Column(name = "price")
	private Integer price;
	@OneToMany(mappedBy = "book",fetch=FetchType.LAZY)
	private List<Orders> listorder;

	public Book() {
		super();
	}

	public Book(Writer writer, String nameBook, Integer quantityPages, Integer price) {
		super();
		this.writer = writer;
		this.nameBook = nameBook;
		this.quantityPages = quantityPages;
		this.price = price;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public Integer getIdBook() {
		return idBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public List<Orders> getListorder() {
		return listorder;
	}

	public void setListorder(List<Orders> listorder) {
		this.listorder = listorder;
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
