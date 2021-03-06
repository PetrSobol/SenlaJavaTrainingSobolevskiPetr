package model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.sobol.senla.anotation.Printable;
import com.sobol.senla.anotation.PrintableObject;
import com.sobol.senla.anotation.PrintableRef;

import interfaces.IOrder;

@PrintableObject(name = "Order")
public class Order implements Cloneable, Serializable,IOrder {
	/**
	 * id number order
	 */
	@Printable(isDetaledOnly = false, name = "idNumberOrder",order=1)
	private String idNumberOrder;
	/**
	 * lastname customer
	 */
	@Printable(isDetaledOnly = true, name = "lastname",order=2)
	private String lastname;
	/**
	 * first name customer
	 */
	@Printable(isDetaledOnly = false, name = "firstname",order=3)
	private String firstname;
	/**
	 * price order
	 */
	@Printable(isDetaledOnly = false, name = "price",order=4)
	private Integer price;
	/**
	 * date start order
	 */
	@Printable(isDetaledOnly = false, name = "date",order=5)
	private Date date;
	/**
	 * date finish order
	 */
	@Printable(isDetaledOnly = false, name = "dateFinishOrder",order=6)
	private Date dateFinishOrder;
	/**
	 * where is the stock
	 */
	@Printable(isDetaledOnly = true, name = "stage",order=7)
	private StageBook stage;
	@PrintableRef(name = "Book",isRecursiv=false,order =1)
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
		this.stage = StageBook.NO_FINISH_ORDER;
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

	public StageBook getStage() {
		return stage;
	}

	public Date getDateFinishOrder() {
		return dateFinishOrder;
	}

	public void setDateFinishOrder(Date date) {
		this.dateFinishOrder = date;
	}

	public void setStage(StageBook stage) {
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

	public Order clone() throws CloneNotSupportedException {
		return (Order) super.clone();
	}
}
