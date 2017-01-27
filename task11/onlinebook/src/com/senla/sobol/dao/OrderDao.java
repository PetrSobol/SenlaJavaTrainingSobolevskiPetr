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
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;
import com.senla.sobol.model.Order;
import com.senla.sobol.model.Writer;

public class OrderDao extends ACommonDAO<IOrder> {
	private static final String SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK_ORDER_BY2 = "select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook  order by ? ";
	private static final String INSERT_INTO_MYDB_ORDER_ID_CUSTOMER_D_BOOK_DATE_ORDER_VALUES = "INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES (?, ?, ?)";
	private static final String DATE_ORDER = "dateOrder";
	private static final String PRICE = "price";
	private static final String QUANTITY_BOOK = "quantityBook";
	private static final String NAME_BOOK = "nameBook";
	private static final String ID_WRITER = "idWriter";
	private static final String ID_BOOK = "idBook";
	private static final String PHONE = "phone";
	private static final String FIRSTNAME_CUSTOMER = "firstnameCustomer";
	private static final String LASTNAME_CUSTOMER = "lastnameCustomer";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final String UPDATE_MYDB_ORDER_SET_ID_CUSTOMER_D_BOOK_DATE_ORDER_WHERE_ID_CUSTOMER_AND_D_BOOK_DATE_ORDER = "UPDATE `mydb`.`order` SET `idCustomer`=?, `dBook`=?, `dateOrder`=? WHERE `idCustomer`=? and`dBook`=?, `dateOrder`=?";
	private static final String DELETE_FROM_MYDB_ORDER_WHERE_ID_CUSTOMER_AND_D_BOOK_AND_DATE_ORDER = "DELETE FROM `mydb`.`order` WHERE `idCustomer`=? and`dBook`=?and `dateOrder`=? ";
	private static final String SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK_AND_MYDB_CUSTOMER_ID_CUSTOMER_AND_MYDB_ORDER_DATE_ORDER = "select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook and mydb.customer.idCustomer=?  and mydb.order.dateOrder=?";
	private static final String SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK = "select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook  ";
	private static Logger log = Logger.getLogger(OrderDao.class.getName());
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public OrderDao() {
		super();
	}

	public void addNewOrder(Connection connection, IOrder t) throws SQLException {
		addNew(connection, t);

	}

	public List<IOrder> getOrderByDateAndId(Connection connection, Integer idcustomer, String dateOrder) {

		PreparedStatement statement = null;
		ResultSet set = null;
		Order order = null;
		List<IOrder> listorder = new ArrayList<IOrder>();
		IBook book = null;
		ICustomer cust = null;
		IWriter writer = null;
		try {
			statement = connection.prepareStatement(
					SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK_AND_MYDB_CUSTOMER_ID_CUSTOMER_AND_MYDB_ORDER_DATE_ORDER);
			statement.setInt(1, idcustomer);
			statement.setString(2, dateOrder);
			set = statement.executeQuery();
			while (set.next()) {
				order = new Order();
				order.setDateOrder(simpledate.parse(set.getString(DATE_ORDER)));
				cust = new Customer();
				cust.setIdCustomer(set.getInt(ID_CUSTOMER));
				cust.setFirstname(set.getString(LASTNAME_CUSTOMER));
				cust.setLastname(set.getString(FIRSTNAME_CUSTOMER));
				cust.setPhone(set.getInt(PHONE));
				order.setCustomer(cust);
				book = new Book();
				book.setIdBook(set.getInt(ID_BOOK));
				writer = new Writer();
				writer.setIdWriter(set.getInt(ID_WRITER));
				book.setWriter(writer);
				book.setNameBook(set.getString(NAME_BOOK));
				book.setQuantityPages(set.getInt(QUANTITY_BOOK));
				book.setPrice(set.getInt(PRICE));
				order.setBook(book);
				listorder.add(order);
			}

		} catch (SQLException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		} finally {
			try {
				statement.close();
				set.close();
			} catch (SQLException e) {
				log.error(e);
			}

		}

		return listorder;

	}

	@Override
	public List<IOrder> getReadAllTable(Connection connection, String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		Order order = null;
		List<IOrder> listorder = new ArrayList<IOrder>();
		IBook book = null;
		ICustomer cust = null;
		IWriter writer = null;
		try {
			if (date != null) {
				statement = connection.prepareStatement(
						SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK_ORDER_BY2);
				statement.setString(1, date);
			} else {
				statement = connection.prepareStatement(
						SELECT_FROM_MYDB_CUSTOMER_JOIN_MYDB_ORDER_JOIN_MYDB_BOOK_ON_MYDB_CUSTOMER_ID_CUSTOMER_MYDB_ORDER_ID_CUSTOMER_AND_MYDB_ORDER_D_BOOK_MYDB_BOOK_ID_BOOK);
			}

			set = statement.executeQuery();
			while (set.next()) {
				order = new Order();
				order.setDateOrder(simpledate.parse(set.getString(DATE_ORDER)));
				cust = new Customer();
				cust.setIdCustomer(set.getInt(ID_CUSTOMER));
				cust.setFirstname(set.getString(LASTNAME_CUSTOMER));
				cust.setLastname(set.getString(FIRSTNAME_CUSTOMER));
				cust.setPhone(set.getInt(PHONE));
				order.setCustomer(cust);
				book = new Book();
				book.setIdBook(set.getInt(ID_BOOK));
				writer = new Writer();
				writer.setIdWriter(set.getInt(ID_WRITER));
				book.setWriter(writer);
				book.setNameBook(set.getString(NAME_BOOK));
				book.setQuantityPages(set.getInt(QUANTITY_BOOK));
				book.setPrice(set.getInt(PRICE));
				order.setBook(book);
				listorder.add(order);
			}

		} catch (SQLException e) {
			log.error(e);
		} catch (ParseException e) {
			log.error(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				log.error(e);
			}

		}

		return listorder;
	}

	public void deleteOrder(Connection connection, IOrder t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(DELETE_FROM_MYDB_ORDER_WHERE_ID_CUSTOMER_AND_D_BOOK_AND_DATE_ORDER);
			statement.setInt(1, t.getCustomer().getIdCustomer());
			statement.setInt(2, t.getBook().getIdBook());
			statement.setString(3, simpledate.format(t.getDateOrder()));
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

	public void updateOrder(Connection connection, IOrder t) {
		update(connection, t);
	}

	@Override
	public String getInsertSql() {
		return INSERT_INTO_MYDB_ORDER_ID_CUSTOMER_D_BOOK_DATE_ORDER_VALUES;
	}

	@Override
	public String getUpdateSql() {
		return UPDATE_MYDB_ORDER_SET_ID_CUSTOMER_D_BOOK_DATE_ORDER_WHERE_ID_CUSTOMER_AND_D_BOOK_DATE_ORDER;
	}

	@Override
	public String getDeletSql() {
		return DELETE_FROM_MYDB_ORDER_WHERE_ID_CUSTOMER_AND_D_BOOK_AND_DATE_ORDER;
	}

	@Override
	public void prepareStatemantOnInsert(PreparedStatement prepar, IOrder t) throws SQLException {
		prepar.setInt(1, t.getCustomer().getIdCustomer());
		prepar.setInt(2, t.getBook().getIdBook());
		prepar.setString(3, simpledate.format(t.getDateOrder()));

	}

	@Override
	public void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException {

		// problemm delete by Integer

		/*
		 * prepar.setInt(1, t.getCustomer().getIdCustomer()); prepar.setInt(2,
		 * t.getBook().getIdBook()); prepar.setString(3,
		 * simpledate.format(t.getDateOrder()));
		 */

	}

	@Override
	public void prepareStatemantOnUpdate(PreparedStatement prepar, IOrder t) throws SQLException {
		prepar.setInt(1, t.getCustomer().getIdCustomer());
		prepar.setInt(2, t.getBook().getIdBook());
		prepar.setString(3, simpledate.format(t.getDateOrder()));

	}

}
