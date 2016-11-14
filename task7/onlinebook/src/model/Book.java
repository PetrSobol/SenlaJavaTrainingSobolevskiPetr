package model;

import java.io.Serializable;

import com.sobol.senla.anotation.Printable;
import com.sobol.senla.anotation.PrintableObject;
import com.sobol.senla.anotation.PrintableRef;

import interfaces.IBook;
import interfaces.IOrder;

@PrintableObject(name = "Book")
public class Book implements Serializable,IBook {
	/**
	 * name book
	 */
	@Printable(isDetaledOnly = false, name = "name")
	private String name;
	/**
	 * id book
	 */
	@Printable(isDetaledOnly = true, name = "id")
	private String id;
	/**
	 * name writer book
	 */
	@Printable(isDetaledOnly = false, name = "writer")
	private String writer;
	/**
	 * price book
	 */
	@Printable(isDetaledOnly = false, name = "price")
	private Integer price;
	/**
	 * year book done
	 */
	@Printable(isDetaledOnly = true, name = "quantityPages")
	private Integer quantityPages;
	/**
	 * whether there is stock
	 */
	@Printable(isDetaledOnly = true, name = "stage")
	private StageBook stage;
	@PrintableRef(name = "order")
	private IOrder order;

	public Book() {
		super();
	}

	public Book(String name, String writer, Integer price, Integer quantityPages) {
		super();
		this.id = "";
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.quantityPages = quantityPages;
		this.stage = StageBook.THERE_IS_STOCK;
	}

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Integer getPrice() {
		return price;
	}

	public IOrder getOrder() {
		return order;
	}

	public void setOrder(IOrder order) {
		this.order = order;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantityPages() {
		return quantityPages;
	}

	public void setQuantityPages(Integer quantityPages) {
		this.quantityPages = quantityPages;
	}

	public StageBook getStage() {
		return stage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStage(StageBook stage) {
		this.stage = stage;
	}

}
