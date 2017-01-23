package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.model.ICustomer;

import interfaces.ICustomerDao;
import model.Customer;

public class CustomerDao implements ICustomerDao {
	private static Logger log = Logger.getLogger(CustomerDao.class.getName());
	private Connection connection;

	public CustomerDao() {
		super();
	}

	public CustomerDao(Connection connection) {
		this.connection = connection;
	}

	public ICustomer getCustomer(Integer idcustomer) {
		List<ICustomer> listcustomer = getReadAllTable();
		for (ICustomer customer : listcustomer) {
			if (idcustomer.equals(customer.getIdCustomer())) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public void addNew(ICustomer t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES (?, ?, ?)");
			statement.setString(1, t.getFirstname());
			statement.setString(2, t.getLastname());
			statement.setInt(3, t.getPhone());
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

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<ICustomer> getReadAllTable() {
		PreparedStatement statement = null;
		ResultSet set = null;
		Customer cust = null;
		List<ICustomer> listcustomer = new ArrayList<ICustomer>();
		try {
			statement = connection.prepareStatement("SELECT * from mydb.customer ");

			set = statement.executeQuery();
			while (set.next()) {
				cust = new Customer();
				cust.setIdCustomer(set.getInt("idCustomer"));
				cust.setFirstname(set.getString("lastnameCustomer"));
				cust.setLastname(set.getString("firstnameCustomer"));
				cust.setPhone(set.getInt("phone"));
				listcustomer.add(cust);
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

		return listcustomer;
	}

	@Override
	public void delete(ICustomer t) {
		PreparedStatement statement = null;

		try {
			statement = connection
					.prepareStatement("DELETE FROM `mydb`.`customer` WHERE `idCustomer`='" + t.getIdCustomer() + "'");

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
	public void update(ICustomer t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement("UPDATE `mydb`.`customer` SET `lastnameCustomer`='"
					+ t.getLastname() + "', `firstnameCustomer`='" + t.getFirstname() + "', `phone`='" + t.getPhone()
					+ "' WHERE `idCustomer`='" + t.getIdCustomer() + "'");

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
