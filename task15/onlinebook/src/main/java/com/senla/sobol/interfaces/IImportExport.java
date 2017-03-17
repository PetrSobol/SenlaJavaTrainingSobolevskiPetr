package com.senla.sobol.interfaces;

import java.util.List;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Orders;

public interface IImportExport {
	public void exportBookCSV(List<Book> book, String rout);

	public void exportOrderCSV(List<Orders> order, String rout);

	public List<Book> importBookCSV(String rout);

	public List<Orders> importOrderCSV(String rout);

}
