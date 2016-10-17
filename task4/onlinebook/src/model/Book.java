package model;

public class Book {
	private static final String STAGE2 = "  Stage: ";
	private static final String YEAR_OF_PUBLISHING = "  Year of publishing: ";
	private static final String PRICE_BOOK = "  Price book: ";
	private static final String WRITER2 = "  Writer: ";
	private static final String NAME_BOOK = " Name book: ";
	private String name;
	private String writer;
	private Integer price;
	private Integer quantityPages;
	private String stage;
	

	public Book() {
		super();
	}

	public Book(String name, String writer, Integer price, Integer quantityPages) {
		super();
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.quantityPages = quantityPages;
	    this.stage="there is Stock";
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

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String printInfoBook() {
	StringBuilder	stringbuilder = new StringBuilder();
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(getName());
		stringbuilder.append(WRITER2);
		stringbuilder.append(getWriter());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(getPrice());
		stringbuilder.append(YEAR_OF_PUBLISHING);
		stringbuilder.append(getQuantityPages());
		stringbuilder.append(STAGE2);
		stringbuilder.append(getStage());
		return stringbuilder.toString();
	}

}
