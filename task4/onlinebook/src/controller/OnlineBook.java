package controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import dao.BookDao;
import dao.OrderDao;
import model.Book;
import model.Order;
import service.BookService;
import service.OrderService;
import sort.SortBookDate;
import sort.SortBookName;
import sort.SortBookPrice;
import sort.SortBookStock;
import sort.SortDateOrder;
import sort.SortPriceOrder;
import sort.SortStageOrder;

public class OnlineBook {
	private static final String QUANTITY_ORDER = "Number of completed orders in the time interval ";
	private static final String SORT_DATE_TO_DATE = "Sort by alfovitu";
	private static final String SORT_PRICE_DATE = "Shop by Price";
	private static final String COMPANY = "The company earned money -";
	private static final String BOOK_DELETE_SUCCES = "Book delete succes";
	private static final String BOOK_ADD_SUCCES = "Book add succes";
	private DataBases dataBases = new DataBases();
	private Converter converter = new Converter();
	private List<Book> listbook;
	private List<Order> listorder;
	private BookDao bookdao;
	private OrderDao orderdao;
	private BookService bookService;
	private OrderService orderservice;
		
	public OnlineBook() throws ParseException {
		this.listbook = converter.getListBook(listbook, dataBases.readFileDB());
		this.listorder = converter.getListOrder(listorder, dataBases.readFileDB());
		this.bookdao = new BookDao(listbook);
		this.orderdao = new OrderDao(listorder);
		this.bookService = new BookService(this.bookdao);
		this.orderservice = new OrderService(orderdao, listbook);
	}

	public void addOrder(String lastname, String firstname, String namebook) throws ParseException {
		orderservice.createNewOrder(lastname, firstname, namebook);
			}

	public void addNewBook(String name, String writer, Integer price, Integer quantity) {
		bookService.addBook(new Book(name, writer, price, quantity));
		System.out.println(BOOK_ADD_SUCCES);
	}
	public void closeOrder(String lastname,String firstname){
		orderservice.closeOrder(lastname, firstname);
	}

	public void deleteBook(String name) {
		bookService.deleteBook(name);
		System.out.println(BOOK_DELETE_SUCCES);
	}

	public void deleteOrder(String name) {
		orderservice.deleteOrder(name);
		}

	public void sortBookName(){
		Collections.sort(this.listbook,new SortBookName());
	}
	public void sortBookPrice(){
		Collections.sort(this.listbook,new SortBookPrice());
	}
	public void sortBookDate(){
		Collections.sort(this.listbook,new SortBookDate());
	}
	public void sortBookStage(){
		Collections.sort(this.listbook,new SortBookStock());
	}
	public void sortOrderDate(){
		Collections.sort(this.listorder,new SortDateOrder());
	}
	public void sortOrderPrice(){
		Collections.sort(this.listorder,new SortPriceOrder());
	}
	public void sortOrderStage(){
		Collections.sort(this.listorder,new SortStageOrder());
	}
	public void saveToDataBases(){
		dataBases.writeFileDB(converter.getOllArray(listorder, listbook));
	}
	
	public void printOrderDateToDate(String date1,String date2) throws ParseException{
		List<Order> listorder=orderservice.getListOrderClock(date1, date2);
		if(listorder!=null){
			System.out.println(SORT_DATE_TO_DATE);
			Collections.sort(listorder,new SortDateOrder());
			for(Order order:listorder){
				System.out.println(order.printInfoOrderOll());
			}
			
			System.out.println(SORT_PRICE_DATE);
			Collections.sort(listorder,new SortPriceOrder());
			for(Order order:listorder){
				System.out.println(order.printInfoOrderOll());
			}
			
		}
	}
	
	
	public void printOrderPriceToOrder(String date1,String date2) throws ParseException{
		List<Order> listorder=orderservice.getListOrderClock(date1, date2);
		Integer priceOll=0;
		for(Order order:listorder){
			priceOll+=order.getPrice();
		}
		
		System.out.println(COMPANY+ priceOll);
	}

	public void printOrderFinish(String date1,String date2) throws ParseException{
		List<Order> listorder=orderservice.getListOrderClock(date1, date2);
		Integer orderOll=0;
		for(Order order:listorder){
			orderOll++;
		}
		
		System.out.println(QUANTITY_ORDER+ orderOll);
	}
	
	public void printOrderOll() {
		if (listorder != null) {
			for (Order order : listorder) {
				System.out.println(order.printInfoOrderOll());
			}
		}
	}

	public void printBookOll() {
		if (listbook != null) {
			for (Book boks : listbook) {
				System.out.println(boks.printInfoBook());
			}
		}

	}

}
