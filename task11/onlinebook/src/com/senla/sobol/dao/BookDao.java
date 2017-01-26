package com.senla.sobol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.Writer;

public class BookDao extends ACommonDAO<IBook> {
	private static final String SELECT_FROM_MYDB_BOOK_JOIN_MYDB_WRITER_ON_MYDB_BOOK_ID_WRITER_MYDB_WRITER_ID_WRITER_ORDER_BY = "select * from mydb.book  join mydb.writer   on mydb.book.idWriter=mydb.writer.idWriter order by ?";
	private static final String PRICE = "price";
	private static final String QUANTITY_BOOK = "quantityBook";
	private static final String NAME_BOOK = "nameBook";
	private static final String DIED_YEAR = "diedYear";
	private static final String YEAR_OF_BIRTHDAY = "yearOfBirthday";
	private static final String FIRSTNAME_WRITER = "firstnameWriter";
	private static final String LASTNAME_WRITER = "lastnameWriter";
	private static final String ID_WRITER = "idWriter";
	private static final String ID_BOOK = "idBook";
	private static final String UPDATE_MYDB_BOOK_SET_ID_WRITER_NAME_BOOK_QUANTITY_BOOK_PRICE_WHERE_ID_BOOK = "UPDATE `mydb`.`book` SET `idWriter`=?, `nameBook`=?, `quantityBook`=?, `price`=? WHERE `idBook`=?";
	private static final String DELETE_FROM_MYDB_BOOK_WHERE_ID_BOOK = "DELETE FROM `mydb`.`book` WHERE `idBook`=?";
	private static final String SELECT_FROM_MYDB_BOOK_JOIN_MYDB_WRITER_ON_MYDB_BOOK_ID_WRITER_MYDB_WRITER_ID_WRITER = "select * from mydb.book  join mydb.writer   on mydb.book.idWriter=mydb.writer.idWriter  ";
	private static final String INSERT_INTO_MYDB_BOOK_ID_WRITER_NAME_BOOK_QUANTITY_BOOK_PRICE_VALUES = "INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES (?, ?, ?, ?)";
	private static Logger log = Logger.getLogger(BookDao.class.getName());
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public BookDao() {
		super();
	}

	public void addNew(Connection connection, IBook t) {
		PreparedStatement statement = null;

		try {
			statement = connection
					.prepareStatement(INSERT_INTO_MYDB_BOOK_ID_WRITER_NAME_BOOK_QUANTITY_BOOK_PRICE_VALUES);
			statement.setInt(1, t.getWriter().getIdWriter());
			statement.setString(2, t.getNameBook());
			statement.setInt(3, t.getQuantityPages());
			statement.setInt(4, t.getPrice());
			addNew(statement);

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
	public List<IBook> getReadAllTable(Connection connection, String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		Book book = null;
		Writer writer = null;
		List<IBook> listbook = new ArrayList<IBook>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(
						SELECT_FROM_MYDB_BOOK_JOIN_MYDB_WRITER_ON_MYDB_BOOK_ID_WRITER_MYDB_WRITER_ID_WRITER_ORDER_BY);
				statement.setString(1, date);
				} else {
				statement = connection.prepareStatement(
						SELECT_FROM_MYDB_BOOK_JOIN_MYDB_WRITER_ON_MYDB_BOOK_ID_WRITER_MYDB_WRITER_ID_WRITER);
			}

			set = statement.executeQuery();
			while (set.next()) {
				book = new Book();
				writer = new Writer();
				book.setIdBook(set.getInt(ID_BOOK));
				writer.setIdWriter(set.getInt(ID_WRITER));
				writer.setLastname(set.getString(LASTNAME_WRITER));
				writer.setFirstname(set.getString(FIRSTNAME_WRITER));
				writer.setStartYear(simpledate.parse(set.getString(YEAR_OF_BIRTHDAY)));
				writer.setDiedYear(simpledate.parse(set.getString(DIED_YEAR)));
				book.setWriter(writer);
				book.setNameBook(set.getString(NAME_BOOK));
				book.setQuantityPages(set.getInt(QUANTITY_BOOK));
				book.setPrice(set.getInt(PRICE));
				listbook.add(book);
			}
		} catch (SQLException | ParseException e) {
			log.error(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
		return listbook;
	}

	public void delete(Connection connection, Integer idbook) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(DELETE_FROM_MYDB_BOOK_WHERE_ID_BOOK);
			delete(statement);
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

	public void update(Connection connection, IBook t) throws SQLException {
		PreparedStatement statement = null;
		statement = connection
				.prepareStatement(UPDATE_MYDB_BOOK_SET_ID_WRITER_NAME_BOOK_QUANTITY_BOOK_PRICE_WHERE_ID_BOOK);
		statement.setInt(1, t.getWriter().getIdWriter());
		statement.setString(2, t.getNameBook());
		statement.setInt(3, t.getQuantityPages());
		statement.setInt(4, t.getPrice());
		statement.setInt(5, t.getIdBook());
		update(statement);
		statement.close();
	}

	public IBook getBook(Connection connection, Integer idBook) {
		List<IBook> listbook = getReadAllTable(connection, null);
		for (IBook book : listbook) {
			if (idBook.equals(book.getIdBook())) {
				return book;
			}
		}
		return null;
	}

}