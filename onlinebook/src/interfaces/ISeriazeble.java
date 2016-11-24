package interfaces;

import java.util.List;

import model.Book;
import model.Order;

public interface ISeriazeble {
	public void saveToDataBases();

	public List<Book> getListBook();

	public List<Order> getListOrder();
}
