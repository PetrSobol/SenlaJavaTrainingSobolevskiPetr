package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private static final String ORDER_STAGE = " Order stage: ";
	private static final String DATE_FINISH_ORDER = " Date finish order: ";
	private static final String DATE_ORDER = " Date order: ";
	private static final String PRICE2 = " Price: ";
	private static final String NAME_BOOK = " Name book: ";
	private static final String CUSTOMER_FIRSTNAME_ORDER = " Customer firstname order ";
	private static final String CUSTOMER_LASTNAME_ORDER = " Customer lastname order: ";
	private SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yyyy");
	private String idNumberOrder;
	private String lastname;
	private String firstname;
	private Integer price;
	private Date date;
	private Date dateFinishOrder;
	private String stage;
	private Book book;
	public Order() {
	}
	public Order(String id, String lastname, String firstname, Book book,  Date date) throws ParseException {
		this.idNumberOrder = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.book=book;
		this.date = date;
		this.dateFinishOrder=simple.parse("10.10.2000");
		this.stage="no finish order";
		this.price=book.getPrice();
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


	public String getDate() {
		return simple.format(date);
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
	public void setDate(String date) throws ParseException {
		this.date = simple.parse(date);
	}
	
	public String getDateFinishOrder() {
		return simple.format(dateFinishOrder);
	}

	public String getStage() {
		return stage;
	}

	public void setDateFinishOrder(String date) throws ParseException {
		this.dateFinishOrder  = simple.parse(date);;
	}
	public void setDateFinishOrder(Date date)  {
		this.dateFinishOrder  = date;
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

	public String printInfoOrderOll() {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(CUSTOMER_LASTNAME_ORDER);
		stringbuilder.append(getLastname());
		stringbuilder.append(CUSTOMER_FIRSTNAME_ORDER);
		stringbuilder.append(getFirstname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(book.getName());
		stringbuilder.append(PRICE2);
		stringbuilder.append(getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(getDate());
		stringbuilder.append(DATE_FINISH_ORDER);
		stringbuilder.append(getDateFinishOrder());
		stringbuilder.append(ORDER_STAGE);
		stringbuilder.append(getStage());
		return stringbuilder.toString();
	}

}
