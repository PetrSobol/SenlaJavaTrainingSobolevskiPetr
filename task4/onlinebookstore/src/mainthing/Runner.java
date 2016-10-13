package mainthing;

import controller.BookController;
import controller.StockController;
import model.Book;

public class Runner {

	public static void main(String[] args) {
		// creat Books
		/*Book book1 = new Book("Harry Potter", "Rolling", 21, 434);
		Book book2 = new Book("Xobbit", "Tolkin", 25, 122);
		Book book3 = new Book("The lord of the rings", "Tolkin", 215, 834);
		Book book4 = new Book("Cien años de soledad", "Gabriel José de la Concordia", 821, 834);
		Book book6 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 212, 34);
		Book book7 = new Book("The Grapes of Wrath", "John Steinbeck", 121, 34);
		Book book8 = new Book("Lolita", "Vladimir Nabokov", 251, 34);
		Book book9 = new Book("To The Lighthouse", "Virginia Woolf", 621, 134);
		Book book10 = new Book("The Catcher in the Rye", "J. D. Salinger", 221, 334);
		Book book11 = new Book("Anvisible Man", "Ralph Ellison", 821, 534);
		Book book12 = new Book("Catch-22", "Joseph Heller", 211, 314);*/
		// creat Controller
		BookController bookcontroller = new BookController();
		StockController stock = new StockController();
		// a list of all books
		System.out.println("List oll books");
		bookcontroller.printListBookOll();
		// add books on stock

		System.out.println("После добавления");
		bookcontroller.printListBookOll();
		// bookcontroller.writeNewBook(book);
		System.out.println("Сортровка по алфовиту");
		bookcontroller.sortBookAlfovity();
		System.out.println("Сортировка по цене");
		bookcontroller.sortBookByPrice();
		System.out.println("Сортировка по году выпуска");
		bookcontroller.sortYearBookPublishing();
		System.out.println("Book on stock ");
		stock.printListBookOll();
		stock.writeNewBook("Xobbit");

	}

}
