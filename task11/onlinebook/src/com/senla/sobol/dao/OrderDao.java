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
	private static final String GET_ID_ORDER = "and mydb.order.idOrder=?";
	private static final String ID_ORDER = "idOrder";
	private static final String SELECT_ORDER_SORT = " order by  ";
	private static final String INSERT = "INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES (?, ?, ?)";
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
	private static final String UPDATE = "UPDATE `mydb`.`order` SET `idCustomer`=?, `dBook`=?, `dateOrder`=? WHERE `idOrder`=? ";
	private static final String DELETE = "DELETE FROM `mydb`.`order` WHERE `idOrder`=? ";
	private static final String SELECT_ORDER_BY_IDCUSTOMER = "select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook and mydb.customer.idCustomer=?  and mydb.order.dateOrder=?";
	private static final String SELECT_ORDER_ALL = "select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook  ";
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
		List<IOrder> listorder = new ArrayList<IOrder>();
		try {
			statement = connection.prepareStatement(SELECT_ORDER_BY_IDCUSTOMER);
			statement.setInt(1, idcustomer);
			statement.setString(2, dateOrder);
			set = statement.executeQuery();
			while (set.next()) {
				listorder.add(getResultSetId(set));
			}

		} catch (SQLException e) {
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
		List<IOrder> listorder = new ArrayList<IOrder>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_ORDER_ALL + SELECT_ORDER_SORT + date);

			} else {
				statement = connection.prepareStatement(SELECT_ORDER_ALL);
			}
			set = statement.executeQuery();
			while (set.next()) {

				listorder.add(getResultSetId(set));
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

		return listorder;
	}

	public void deleteOrder(Connection connection, Integer idOrder) {
		delete(connection, idOrder);
	}

	public void updateOrder(Connection connection, IOrder t) {
		update(connection, t);
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
	public void prepareStatemantOnInsert(PreparedStatement prepar, IOrder t) throws SQLException {
		prepar.setInt(1, t.getCustomer().getIdCustomer());
		prepar.setInt(2, t.getBook().getIdBook());
		prepar.setString(3, simpledate.format(t.getDateOrder()));

	}

	@Override
	public void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException {
		prepar.setInt(1, t);

	}

	@Override
	public void prepareStatemantOnUpdate(PreparedStatement prepar, IOrder t) throws SQLException {
		prepar.setInt(1, t.getIdOrder());

	}

	@Override
	public String getId() {
		return SELECT_ORDER_ALL + GET_ID_ORDER;
	}

	public IOrder getOrderById(Connection connection, Integer id) {
		IOrder order = getID(connection, id);
		return order;
	}

	@Override
	public IOrder getResultSetId(ResultSet result) throws SQLException {
		IOrder order = new Order();
		order.setIdOrder(result.getInt(ID_ORDER));
		try {
			order.setDateOrder(simpledate.parse(result.getString(DATE_ORDER)));
			ICustomer cust = new Customer();
			cust.setIdCustomer(result.getInt(ID_CUSTOMER));
			cust.setFirstname(result.getString(LASTNAME_CUSTOMER));
			cust.setLastname(result.getString(FIRSTNAME_CUSTOMER));
			cust.setPhone(result.getInt(PHONE));
			order.setCustomer(cust);
			IBook book = new Book();
			book.setIdBook(result.getInt(ID_BOOK));
			IWriter writer = new Writer();
			writer.setIdWriter(result.getInt(ID_WRITER));
			book.setWriter(writer);
			book.setNameBook(result.getString(NAME_BOOK));
			book.setQuantityPages(result.getInt(QUANTITY_BOOK));
			book.setPrice(result.getInt(PRICE));
			order.setBook(book);
		} catch (ParseException e) {
			log.error(e);
		}

		return order;
	}

}
