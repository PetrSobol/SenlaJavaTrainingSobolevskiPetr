package com.senla.sobol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.ICustomer;

public class CustomerDao extends ACommonDAO<ICustomer> {
	private static final String PHONE = "phone";
	private static final String FIRSTNAME_CUSTOMER = "firstnameCustomer";
	private static final String LASTNAME_CUSTOMER = "lastnameCustomer";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final String SELECT_FROM_MYDB_CUSTOMER_ORDER_BY = "SELECT * from mydb.customer  order by ? ";
	private static final String UPDATE_MYDB_CUSTOMER_SET_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_WHERE_ID_CUSTOMER = "UPDATE `mydb`.`customer` SET `lastnameCustomer`=?, `firstnameCustomer`=?, `phone`=? WHERE `idCustomer`=?";
	private static final String DELETE_FROM_MYDB_CUSTOMER_WHERE_ID_CUSTOMER = "DELETE FROM `mydb`.`customer` WHERE `idCustomer`=?";
	private static final String SELECT_FROM_MYDB_CUSTOMER = "SELECT * from mydb.customer ";
	private static final String INSERT_INTO_MYDB_CUSTOMER_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_VALUES = "INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES (?, ?, ?)";
	private static Logger log = Logger.getLogger(CustomerDao.class.getName());

	public CustomerDao() {
		super();
	}

	public ICustomer getCustomer(Connection connection, Integer idcustomer) {
		List<ICustomer> listcustomer = getReadAllTable(connection,null);
		for (ICustomer customer : listcustomer) {
			if (idcustomer.equals(customer.getIdCustomer())) {
				return customer;
			}
		}
		return null;
	}

	public void addNew(Connection connection, ICustomer t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					INSERT_INTO_MYDB_CUSTOMER_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_VALUES);
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

	@Override
	public List<ICustomer> getReadAllTable(Connection connection,String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		Customer cust = null;
		List<ICustomer> listcustomer = new ArrayList<ICustomer>();
		try {
			if(date!=null){
				statement = connection.prepareStatement(SELECT_FROM_MYDB_CUSTOMER_ORDER_BY);
				statement.setString(1, date);
			}else{
				statement = connection.prepareStatement(SELECT_FROM_MYDB_CUSTOMER);
			}
			set = statement.executeQuery();
			while (set.next()) {
				cust = new Customer();
				cust.setIdCustomer(set.getInt(ID_CUSTOMER));
				cust.setFirstname(set.getString(LASTNAME_CUSTOMER));
				cust.setLastname(set.getString(FIRSTNAME_CUSTOMER));
				cust.setPhone(set.getInt(PHONE));
				listcustomer.add(cust);
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

		return listcustomer;
	}

	public void delete(Connection connection, Integer idcustomer) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(DELETE_FROM_MYDB_CUSTOMER_WHERE_ID_CUSTOMER);
			statement.setInt(1, idcustomer);

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

	public void update(Connection connection, ICustomer t) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					UPDATE_MYDB_CUSTOMER_SET_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_WHERE_ID_CUSTOMER);
			statement.setString(1, t.getLastname());
			statement.setString(2, t.getFirstname());
			statement.setInt(3, t.getPhone());
			statement.setInt(4, t.getIdCustomer());
			update(statement);

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
