package database;

import com.danco.training.TextFileWorker;

public class DataBase {
	private String wayBook = "G:/SENLA/task4/TextFile/book.txt";
	private String wayCustomer = "G:/SENLA/task4/TextFile/Customer.txt";
	private String wayOrder = "G:/SENLA/task4/TextFile/Order.txt";
	private String wayStock = "G:/SENLA/task4/TextFile/Stock.txt";
	private TextFileWorker textBook = new TextFileWorker(wayBook);
	private TextFileWorker textCustomer = new TextFileWorker(wayCustomer);
	private TextFileWorker textOrder = new TextFileWorker(wayOrder);
	private TextFileWorker textStock = new TextFileWorker(wayStock);

	public String[] getBook() {
		String book[] = textBook.readFromFile();
		return book;
	}

	public void addBookCatalog(String[] books) {
		textBook.writeToFile(books);
	}

	public String[] getBookStock() {
		String book[] = textStock.readFromFile();
		return book;
	}

	public void addBookStock(String[] books) {
		textStock.writeToFile(books);
	}
}
