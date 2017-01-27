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

	public void addNewCustomer(Connection connection, ICustomer t) throws SQLException {
		addNew(connection, t);

	}

	@Override
	public List<ICustomer> getReadAllTable(Connection connection, String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		Customer cust = null;
		List<ICustomer> listcustomer = new ArrayList<ICustomer>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_CUSTOMER_ORDER_BY);
				statement.setString(1, date);
			} else {
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

	public void deleteCustomer(Connection connection, Integer idcustomer) {

		delete(connection, idcustomer);
	}

	public void updateCustomer(Connection connection, ICustomer t) {
		update(connection, t);
	}

	@Override
	public String getInsertSql() {
		return INSERT_INTO_MYDB_CUSTOMER_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_VALUES;
	}

	@Override
	public String getUpdateSql() {
		return UPDATE_MYDB_CUSTOMER_SET_LASTNAME_CUSTOMER_FIRSTNAME_CUSTOMER_PHONE_WHERE_ID_CUSTOMER;
	}

	@Override
	public String getDeletSql() {
		return DELETE_FROM_MYDB_CUSTOMER_WHERE_ID_CUSTOMER;
	}

	@Override
	public void prepareStatemantOnInsert(PreparedStatement prepar, ICustomer t) throws SQLException {
		prepar.setString(1, t.getFirstname());
		prepar.setString(2, t.getLastname());
		prepar.setInt(3, t.getPhone());

	}

	@Override
	public void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException {
		prepar.setInt(1, t);

	}

	@Override
	public void prepareStatemantOnUpdate(PreparedStatement prepar, ICustomer t) throws SQLException {
		prepar.setString(1, t.getLastname());
		prepar.setString(2, t.getFirstname());
		prepar.setInt(3, t.getPhone());
		prepar.setInt(4, t.getIdCustomer());

	}
}
