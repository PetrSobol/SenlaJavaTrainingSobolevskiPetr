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
import com.senla.sobol.model.IWriter;
import com.senla.sobol.model.Writer;

public class BookDao extends ACommonDAO<IBook> {
	private static final String GET_ID_BOOK = "where mydb.book.idBook=?";
	private static final String SELECT_GET_ORDER_SORT = " order by ";
	private static final String PRICE = "price";
	private static final String QUANTITY_BOOK = "quantityBook";
	private static final String NAME_BOOK = "nameBook";
	private static final String DIED_YEAR = "diedYear";
	private static final String YEAR_OF_BIRTHDAY = "yearOfBirthday";
	private static final String FIRSTNAME_WRITER = "firstnameWriter";
	private static final String LASTNAME_WRITER = "lastnameWriter";
	private static final String ID_WRITER = "idWriter";
	private static final String ID_BOOK = "idBook";
	private static final String UPDATE = "UPDATE `mydb`.`book` SET `idWriter`=?, `nameBook`=?, `quantityBook`=?, `price`=? WHERE `idBook`=?";
	private static final String DELETE = "DELETE FROM `mydb`.`book` WHERE `idBook`=?";
	private static final String SELECT_GET_ORDER = "select * from mydb.book  join mydb.writer   on mydb.book.idWriter=mydb.writer.idWriter  ";
	private static final String INSERT = "INSERT INTO `mydb`.`book` (`idWriter`, `nameBook`, `quantityBook`, `price`) VALUES (?, ?, ?, ?)";
	private static Logger log = Logger.getLogger(BookDao.class.getName());
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public BookDao() {
		super();
	}

	public void addNewBook(Connection connection, IBook t) throws SQLException {
		addNew(connection, t);
	}

	@Override
	public List<IBook> getReadAllTable(Connection connection, String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		List<IBook> listbook = new ArrayList<IBook>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_GET_ORDER + SELECT_GET_ORDER_SORT + date);
			} else {
				statement = connection.prepareStatement(SELECT_GET_ORDER);
			}

			set = statement.executeQuery();
			while (set.next()) {
				listbook.add(getResultSetId(set));
			}
		} catch (SQLException e) {
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

	public void deleteBook(Connection connection, Integer idbook) {
		delete(connection, idbook);
	}

	public void updateBook(Connection connection, IBook t) throws SQLException {
		update(connection, t);
	}

	public IBook getIdBook(Connection connection,Integer id){
		IBook book=getID(connection, id);
		return book;
	}
	
	
	@Override
	public String getInsertSql() {
		return INSERT;
	}

	@Override
	public String getUpdateSql() {
		return UPDATE;
	}

	@Override
	public String getDeletSql() {
		return DELETE;
	}

	@Override
	public void prepareStatemantOnUpdate(PreparedStatement prepar, IBook t) throws SQLException {
		prepar.setInt(1, t.getWriter().getIdWriter());
		prepar.setString(2, t.getNameBook());
		prepar.setInt(3, t.getQuantityPages());
		prepar.setInt(4, t.getPrice());
		prepar.setInt(5, t.getIdBook());

	}

	@Override
	public void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException {
		prepar.setInt(1, t);

	}

	@Override
	public void prepareStatemantOnInsert(PreparedStatement prepar, IBook t) throws SQLException {
		prepar.setInt(1, t.getWriter().getIdWriter());
		prepar.setString(2, t.getNameBook());
		prepar.setInt(3, t.getQuantityPages());
		prepar.setInt(4, t.getPrice());

	}

	@Override
	public String getId() {
		return SELECT_GET_ORDER + GET_ID_BOOK;
	}

	@Override
	public IBook getResultSetId(ResultSet result) throws SQLException {
		IBook book = new Book();
		IWriter writer = new Writer();
		book.setIdBook(result.getInt(ID_BOOK));
		writer.setIdWriter(result.getInt(ID_WRITER));
		writer.setLastname(result.getString(LASTNAME_WRITER));
		writer.setFirstname(result.getString(FIRSTNAME_WRITER));
		try {
			writer.setStartYear(simpledate.parse(result.getString(YEAR_OF_BIRTHDAY)));
			String numersdied = result.getString(DIED_YEAR);
			writer.setStartYear(simpledate.parse(result.getString(YEAR_OF_BIRTHDAY)));
			if (numersdied != null) {
				writer.setDiedYear(simpledate.parse(numersdied));
			} else {
				writer.setDiedYear(null);
			}
			book.setWriter(writer);
			book.setNameBook(result.getString(NAME_BOOK));
			book.setQuantityPages(result.getInt(QUANTITY_BOOK));
			book.setPrice(result.getInt(PRICE));
			return book;
		} catch (ParseException e) {
			log.error(e);
		}

		return null;
	}

}
