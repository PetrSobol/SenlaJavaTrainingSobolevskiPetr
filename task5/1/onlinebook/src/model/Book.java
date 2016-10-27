package model;

public class Book {

	private String name;
	private String id;
	private String writer;
	private Integer price;
	private Integer quantityPages;
	private String stage;
	private Order order;
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
		this.stage = "there is Stock";
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
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

	public String getStage() {
		return stage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}
	

}
