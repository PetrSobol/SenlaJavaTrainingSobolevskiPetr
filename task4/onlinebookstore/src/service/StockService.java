package service;

import java.util.List;

import database.DataBase;
import model.Book;

public class StockService extends AService {
	private DataBase database = new DataBase();
	private List<Book> listbookstock;
	private List<Book> listbook;

   
	
	public List<Book> getBooksCatalog() {
		getListBookCatalog();
		return this.listbook;
	}
	private List<Book> getListBookCatalog(){
		this.listbook=getListBook(this.listbook, database.getBook());
		return listbook;
	}

	public List<Book> getBooks() {
		return this.listbookstock;
	}

	public List<Book> getListBookStock() {
		this.listbookstock=getListBook(listbookstock, database.getBookStock());
		return listbookstock;
	}

	@Override
	public void writeBook(String[] word) {
		String[] books = database.getBookStock();
		database.addBookStock(anAssociation(books, word));
		}
}
