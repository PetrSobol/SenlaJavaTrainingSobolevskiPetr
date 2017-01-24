package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.model.IBook;

import interfaces.IBookDao;
import model.Book;
import model.Writer;

public class BookDao implements IBookDao {
	private static Logger log = Logger.getLogger(BookDao.class.getName());
	private Connection connection;
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");
	
	public BookDao() {
		super();
	}

	public BookDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addNew(IBook t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES (?, ?, ?, ?)");
			statement.setInt(1, t.getWriter().getIdWriter());
			statement.setString(2, t.getNameBook());
			statement.setInt(3, t.getQuantityPages());
			statement.setInt(4, t.getPrice());
			statement.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				statement.close();

			} catch (SQLException e) {
				log.error(e);
			}

		}

	}

	@Override
	public List<IBook> getReadAllTable() {
		PreparedStatement statement = null;
		ResultSet set = null;
		Book book = null;
		Writer writer = null;
		List<IBook> listbook = new ArrayList<IBook>();
		try {
			statement = connection.prepareStatement(
					"select * from mydb.book  join mydb.writer   on mydb.book.idWriter=mydb.writer.idWriter  ");
			set = statement.executeQuery();
			while (set.next()) {
				book = new Book();
				writer = new Writer();
				book.setIdBook(set.getInt("idBook"));
				writer.setIdWriter(set.getInt("idWriter"));
				writer.setLastname(set.getString("lastnameWriter"));
				writer.setFirstname(set.getString("firstnameWriter"));
				writer.setStartYear( simpledate.parse(set.getString("yearOfBirthday"))  );
				writer.setDiedYear(  simpledate.parse(  set.getString("diedYear")));
				book.setWriter(writer);
				book.setNameBook(set.getString("nameBook"));
				book.setQuantityPages(set.getInt("quantityBook"));
				book.setPrice(set.getInt("price"));
				listbook.add(book);
			}
		} catch (SQLException | ParseException e) {
			log.error(e);
		} finally {
			try {
				statement.close();
				set.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
		return listbook;
	}

	@Override
	public void delete(IBook t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("DELETE FROM `mydb`.`book` WHERE `idBook`='" + t.getIdBook() + "'");
			statement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				statement.close();

			} catch (SQLException e) {
				log.error(e);
			}
		}
	}

	@Override
	public void update(IBook t) {
		PreparedStatement statement = null;

		try {
			statement = connection
					.prepareStatement("UPDATE `mydb`.`book` SET `idWriter`='" + t.getWriter().getIdWriter()
							+ "', `nameBook`='" + t.getNameBook() + "', `quantityBook`='" + t.getQuantityPages()
							+ "', `price`='" + t.getPrice() + "' WHERE `idBook`='" + t.getIdBook() + "'");
			statement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}

	}
	public IBook getBook(Integer idBook) {
		List<IBook> listbook = getReadAllTable();
		for (IBook book : listbook) {
			if (idBook.equals(book.getIdBook())) {
				return book;
			}
		}
		return null;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
