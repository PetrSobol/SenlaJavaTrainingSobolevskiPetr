package interfaces;

import java.util.List;

import model.Book;
import model.Order;

public interface IImportExport {
	public void exportBookCSV(List<Book> book, String rout);

	public void exportOrderCSV(List<Order> order, String rout);

	public List<Book> importBookCSV(String rout);

	public List<Order> importOrderCSV(String rout);

}
