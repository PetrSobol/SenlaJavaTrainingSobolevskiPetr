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
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;

import interfaces.IOrderDao;
import model.Book;
import model.Customer;
import model.Order;
import model.Writer;

public class OrderDao implements IOrderDao {
	private static Logger log = Logger.getLogger(OrderDao.class.getName());
	private Connection connection;
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public OrderDao() {
		super();
	}

	public OrderDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addNew(IOrder t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"INSERT INTO `mydb`.`order` (`idCustomer`, `dBook`, `dateOrder`) VALUES (?, ?, ?)");
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

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String dateOrder) {

		PreparedStatement statement = null;
		ResultSet set = null;
		Order order = null;
		List<IOrder> listorder = new ArrayList<IOrder>();
		IBook book = null;
		ICustomer cust = null;
		IWriter writer = null;
		try {
			statement = connection.prepareStatement(
					"select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook and mydb.customer.idCustomer='"
							+ idcustomer + "'  and mydb.order.dateOrder='" + dateOrder + "'");
			set = statement.executeQuery();
			while (set.next()) {
				order = new Order();
				order.setDateOrder(simpledate.parse(set.getString("dateOrder")));
				cust = new Customer();
				cust.setIdCustomer(set.getInt("idCustomer"));
				cust.setFirstname(set.getString("lastnameCustomer"));
				cust.setLastname(set.getString("firstnameCustomer"));
				cust.setPhone(set.getInt("phone"));

				order.setCustomer(cust);
				book = new Book();
				book.setIdBook(set.getInt("idBook"));
				writer = new Writer();
				writer.setIdWriter(set.getInt("idWriter"));
				book.setWriter(writer);
				book.setNameBook(set.getString("nameBook"));
				book.setQuantityPages(set.getInt("quantityBook"));
				book.setPrice(set.getInt("price"));
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
	public List<IOrder> getReadAllTable() {
		PreparedStatement statement = null;
		ResultSet set = null;
		Order order = null;
		List<IOrder> listorder = new ArrayList<IOrder>();
		IBook book = null;
		ICustomer cust = null;
		IWriter writer = null;
		try {
			statement = connection.prepareStatement(
					"select * from mydb.customer  join mydb.order  join mydb.book  on mydb.customer.idCustomer=mydb.order.idCustomer and  mydb.order.dBook=mydb.book.idBook  ");
			set = statement.executeQuery();
			while (set.next()) {
				order = new Order();
				order.setDateOrder(simpledate.parse(set.getString("dateOrder")));
				cust = new Customer();
				cust.setIdCustomer(set.getInt("idCustomer"));
				cust.setFirstname(set.getString("lastnameCustomer"));
				cust.setLastname(set.getString("firstnameCustomer"));
				cust.setPhone(set.getInt("phone"));

				order.setCustomer(cust);
				book = new Book();
				book.setIdBook(set.getInt("idBook"));
				writer = new Writer();
				writer.setIdWriter(set.getInt("idWriter"));
				book.setWriter(writer);
				book.setNameBook(set.getString("nameBook"));
				book.setQuantityPages(set.getInt("quantityBook"));
				book.setPrice(set.getInt("price"));
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

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void delete(IOrder t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("DELETE FROM `mydb`.`order` WHERE `idCustomer`='"
					+ t.getCustomer().getIdCustomer() + "' and`dBook`='" + t.getBook().getIdBook()
					+ "'and `dateOrder`='" + simpledate.format(t.getDateOrder()) + "' ");

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
	public void update(IOrder t) {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"UPDATE `mydb`.`order` SET `idCustomer`='" + t.getCustomer().getIdCustomer() + "', `dBook`='"
							+ t.getBook().getIdBook() + "', `dateOrder`='" + simpledate.format(t.getDateOrder())
							+ "' WHERE `idCustomer`='" + t.getCustomer().getIdCustomer() + "' and`dBook`='"
							+ t.getBook().getIdBook() + "', `dateOrder`='" + simpledate.format(t.getDateOrder()) + "'");

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

}
