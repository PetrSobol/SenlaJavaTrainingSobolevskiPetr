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
	private static final String GET_ID_CUSTOMER = "where  mydb.customer.idCustomer=?";
	private static final String PHONE = "phone";
	private static final String FIRSTNAME_CUSTOMER = "firstnameCustomer";
	private static final String LASTNAME_CUSTOMER = "lastnameCustomer";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final String SELECT_ORDER_BY = " order by  ";
	private static final String UPDATE = "UPDATE `mydb`.`customer` SET `lastnameCustomer`=?, `firstnameCustomer`=?, `phone`=? WHERE `idCustomer`=?";
	private static final String DELETE = "DELETE FROM `mydb`.`customer` WHERE `idCustomer`=?";
	private static final String SELECT_FROM_MYDB_CUSTOMER = "SELECT * from mydb.customer ";
	private static final String INSERT = "INSERT INTO `mydb`.`customer` (`lastnameCustomer`, `firstnameCustomer`, `phone`) VALUES (?, ?, ?)";
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
		List<ICustomer> listcustomer = new ArrayList<ICustomer>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_CUSTOMER + SELECT_ORDER_BY + date);
			} else {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_CUSTOMER);
			}
			set = statement.executeQuery();
			while (set.next()) {
				listcustomer.add(getResultSetId(set));
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

	public ICustomer getIDCustomer(Connection connection, Integer id) {
		ICustomer customer = getID(connection, id);
		return customer;
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

	@Override
	public String getId() {
		return SELECT_FROM_MYDB_CUSTOMER + GET_ID_CUSTOMER;
	}

	@Override
	public ICustomer getResultSetId(ResultSet result) throws SQLException {
		ICustomer cust = new Customer();
		cust.setIdCustomer(result.getInt(ID_CUSTOMER));
		cust.setFirstname(result.getString(LASTNAME_CUSTOMER));
		cust.setLastname(result.getString(FIRSTNAME_CUSTOMER));
		cust.setPhone(result.getInt(PHONE));
		return cust;
	}
}
