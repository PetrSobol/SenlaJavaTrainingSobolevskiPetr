package interfaces;

import java.util.List;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IOrder;

public interface IImportExport {
	public void exportBookCSV(List<IBook> book, String rout);

	public void exportOrderCSV(List<IOrder> order, String rout);

	public List<IBook> importBookCSV(String rout);

	public List<IOrder> importOrderCSV(String rout);

}
