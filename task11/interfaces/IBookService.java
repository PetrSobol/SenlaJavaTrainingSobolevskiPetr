package interfaces;

import com.senla.sobol.model.IBook;

public interface IBookService extends ICommonService<IBook> {
	public IBook findbook(IBook bookfind);

	public IBook getBook(Integer idBook);

	public void setBookdao(IBookDao bookdao);

	public Boolean searchIdWriter(Integer idWriter);
}
