package model;

import java.text.ParseException;
import java.util.Date;

public class Order {
	// id number order
	private String idNumberOrder;
	// lastname customer
	private String lastname;
	// first name customer
	private String firstname;
	// price order
	private Integer price;
	// date start order
	private Date date;
	// date finish order
	private Date dateFinishOrder;
	// where is the stock
	private String stage;
	private Book book;

	public Order() {
	}

	public Order(String id, String lastname, String firstname, Book book, Date date) throws ParseException {
		this.idNumberOrder = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.book = book;
		this.date = date;
		this.dateFinishOrder = new Date();
		this.stage = StageBook.NO_FINISH_ORDER.toString();
		this.price = book.getPrice();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIdNumberOrder() {
		return idNumberOrder;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setIdNumberOrder(String idNumberOrder) {
		this.idNumberOrder = idNumberOrder;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getStage() {
		return stage;
	}

	public Date getDateFinishOrder() {
		return dateFinishOrder;
	}

	public void setDateFinishOrder(Date date) {
		this.dateFinishOrder = date;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Date dateFinishOrder() {
		return dateFinishOrder;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
