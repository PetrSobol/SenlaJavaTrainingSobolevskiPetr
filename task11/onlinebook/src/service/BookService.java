package service;

import java.util.List;

import com.senla.sobol.model.IBook;

import dao.BookDao;
import interfaces.IBookDao;
import interfaces.IBookService;

public class BookService implements IBookService {
	private IBookDao bookdao;

	public BookService() {
		super();
	}

	public BookService(BookDao bookdao) {
		super();
		this.bookdao = bookdao;
	}

	public Boolean searchIdWriter(Integer idWriter) {
		List<IBook> listbook = getAll();
		for (IBook book : listbook) {
			if (book.getWriter().getIdWriter().equals(idWriter)) {
				return true;
			}
		}
		return false;

	}

	public IBook findbook(IBook bookfind) {
		List<IBook> listbook = bookdao.getReadAllTable();
		for (IBook book : listbook) {
			if (!bookfind.getNameBook().equals(book.getNameBook())
					|| bookfind.getWriter().getIdWriter().equals(book.getWriter().getIdWriter())) {
				return book;
			}
		}
		return null;
	}

	public IBook getBook(Integer idBook) {
		IBook book = bookdao.getBook(idBook);
		return book;
	}

	@Override
	public void delete(IBook t) {
		bookdao.delete(t);

	}

	@Override
	public void update(IBook t) {
		bookdao.update(t);

	}

	@Override
	public void add(IBook t) {
		bookdao.addNew(t);

	}

	public void setBookdao(IBookDao bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public List<IBook> getAll() {
		List<IBook> listbook = bookdao.getReadAllTable();
		return listbook;
	}

}
