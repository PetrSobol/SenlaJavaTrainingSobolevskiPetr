package model;

public class Book {
	private String name;
	private String writer;
	private Integer price;
	private Integer quantityPages;
	private StringBuilder stringbuilder;

	public Book() {
		super();
	}

	public Book(String name, String writer, Integer price, Integer quantityPages) {
		super();
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.quantityPages = quantityPages;
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

	public String printInfoBook() {
		stringbuilder = new StringBuilder();
		stringbuilder.append(" Name book: ");
		stringbuilder.append(getName());
		stringbuilder.append("  Writer: ");
		stringbuilder.append(getWriter());
		stringbuilder.append("  Price book: ");
		stringbuilder.append(getPrice());
		stringbuilder.append("  Year of publishing: ");
		stringbuilder.append(getQuantityPages());
		return stringbuilder.toString();
	}

}
