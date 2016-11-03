package model;

public class Book {
	// name book
	private String name;
	// id book
	private String id;
	// name writer book
	private String writer;
	// price book
	private Integer price;
	// year book done
	private Integer quantityPages;
	// whether there is stock
	private StageBook stage;
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
