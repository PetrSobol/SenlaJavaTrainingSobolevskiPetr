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
import com.senla.sobol.model.IWriter;
import com.senla.sobol.model.Writer;

public class WriterDao extends ACommonDAO<IWriter> {
	private static final String DIED_YEAR = "diedYear";
	private static final String YEAR_OF_BIRTHDAY = "yearOfBirthday";
	private static final String FIRSTNAME_WRITER = "firstnameWriter";
	private static final String LASTNAME_WRITER = "lastnameWriter";
	private static final String ID_WRITER = "idWriter";
	private static final String INSERT_INTO_MYDB_WRITER_LASTNAME_WRITER_FIRSTNAME_WRITER_YEAR_OF_BIRTHDAY_DIED_YEAR_VALUES = "INSERT INTO `mydb`.`writer` (`lastnameWriter`, `firstnameWriter`, `yearOfBirthday`, `diedYear`) VALUES (?, ?, ?, ?)";
	private static final String SELECT_FROM_MYDB_WRITER_ORDER_BY = "SELECT * from mydb.writer order by ? ";
	private static final String SELECT_FROM_MYDB_WRITER = "SELECT * from mydb.writer ";
	private static final String DELETE_FROM_MYDB_WRITER_WHERE_ID_WRITER = "DELETE FROM `mydb`.`writer` WHERE `idWriter`=?";
	private static final String UPDATE_MYDB_WRITER_SET_LASTNAME_WRITER_FIRSTNAME_WRITER_YEAR_OF_BIRTHDAY_DIED_YEAR_WHERE_ID_WRITER = "UPDATE `mydb`.`writer` SET `lastnameWriter`=?, `firstnameWriter`=?, `yearOfBirthday`=?, `diedYear`=? WHERE `idWriter`=?";
	private static Logger log = Logger.getLogger(WriterDao.class.getName());
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public WriterDao() {
		super();
	}

	public void addNewWriter(Connection connection, IWriter t) throws SQLException {
		addNew(connection, t);
	}

	@Override
	public List<IWriter> getReadAllTable(Connection connection, String date) {
		PreparedStatement statement = null;
		ResultSet set = null;
		Writer writer = null;
		List<IWriter> listwriter = new ArrayList<IWriter>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_WRITER_ORDER_BY);
				statement.setString(1, date);
			} else {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_WRITER);
			}

			set = statement.executeQuery();
			while (set.next()) {
				writer = new Writer();
				writer.setIdWriter(set.getInt(ID_WRITER));
				writer.setLastname(set.getString(LASTNAME_WRITER));
				writer.setFirstname(set.getString(FIRSTNAME_WRITER));
				writer.setStartYear(simpledate.parse(set.getString(YEAR_OF_BIRTHDAY)));
				writer.setDiedYear(simpledate.parse(set.getString(DIED_YEAR)));
				listwriter.add(writer);
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
		return listwriter;
	}

	public void deleteWriter(Connection connection, Integer idwriter) {
		delete(connection, idwriter);

	}

	public void updateWriter(Connection connection, IWriter t) {
		update(connection, t);

	}

	@Override
	public String getInsertSql() {
		return INSERT_INTO_MYDB_WRITER_LASTNAME_WRITER_FIRSTNAME_WRITER_YEAR_OF_BIRTHDAY_DIED_YEAR_VALUES;
	}

	@Override
	public String getUpdateSql() {
		return UPDATE_MYDB_WRITER_SET_LASTNAME_WRITER_FIRSTNAME_WRITER_YEAR_OF_BIRTHDAY_DIED_YEAR_WHERE_ID_WRITER;
	}

	@Override
	public String getDeletSql() {
		return DELETE_FROM_MYDB_WRITER_WHERE_ID_WRITER;
	}

	@Override
	public void prepareStatemantOnInsert(PreparedStatement prepar, IWriter t) throws SQLException {
		prepar.setString(1, t.getLastname());
		prepar.setString(2, t.getFirstname());
		prepar.setString(3, simpledate.format(t.getStartYear()));
		prepar.setString(4, simpledate.format(t.getDiedYear()));

	}

	@Override
	public void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException {
		prepar.setInt(1, t);

	}

	@Override
	public void prepareStatemantOnUpdate(PreparedStatement prepar, IWriter t) throws SQLException {
		prepar.setString(1, t.getLastname());
		prepar.setString(2, t.getFirstname());
		prepar.setString(3, simpledate.format(t.getStartYear()));
		prepar.setString(4, simpledate.format(t.getDiedYear()));
		prepar.setInt(5, t.getIdWriter());

	}

}
