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
	private static final String ID_WRITER_GET = " where mydb.writer.idWriter=?";
	private static final String YEAR_OF_BIRTHDAY = "yearOfBirthday";
	private static final String FIRSTNAME_WRITER = "firstnameWriter";
	private static final String LASTNAME_WRITER = "lastnameWriter";
	private static final String ID_WRITER = "idWriter";
	private static final String INSERT = "INSERT INTO `mydb`.`writer` (`lastnameWriter`, `firstnameWriter`, `yearOfBirthday`, `diedYear`) VALUES (?, ?, ?, ?)";
	private static final String SELECT__WRITER_SORT = " order by  ";
	private static final String SELECT_FROM_MYDB_WRITER = "SELECT * from mydb.writer ";
	private static final String DELETE = "DELETE FROM `mydb`.`writer` WHERE `idWriter`=?";
	private static final String UPDATE = "UPDATE `mydb`.`writer` SET `lastnameWriter`=?, `firstnameWriter`=?, `yearOfBirthday`=?, `diedYear`=? WHERE `idWriter`=?";
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
		List<IWriter> listwriter = new ArrayList<IWriter>();
		try {
			if (date != null) {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_WRITER + SELECT__WRITER_SORT + date);
			} else {
				statement = connection.prepareStatement(SELECT_FROM_MYDB_WRITER);
			}

			set = statement.executeQuery();
			while (set.next()) {
				listwriter.add(getResultSetId(set));
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
		return listwriter;
	}

	public void deleteWriter(Connection connection, Integer idwriter) {
		delete(connection, idwriter);

	}

	public void updateWriter(Connection connection, IWriter t) {
		update(connection, t);

	}

	public IWriter getIdWriter(Connection connection, Integer id) {

		IWriter writer = getID(connection, id);
		return writer;

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
	public void prepareStatemantOnInsert(PreparedStatement prepar, IWriter t) throws SQLException {
		prepar.setString(1, t.getLastname());
		prepar.setString(2, t.getFirstname());
		prepar.setString(3, simpledate.format(t.getStartYear()));
		if (t.getDiedYear() != null) {
			prepar.setString(4, simpledate.format(t.getDiedYear()));
		} else {
			prepar.setNull(4, 0);
		}

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

	@Override
	public String getId() {
		return SELECT_FROM_MYDB_WRITER+ID_WRITER_GET;
	}

	@Override
	public IWriter getResultSetId(ResultSet result) throws SQLException {
		IWriter writer = new Writer();
		writer.setIdWriter(result.getInt(ID_WRITER));
		writer.setLastname(result.getString(LASTNAME_WRITER));
		writer.setFirstname(result.getString(FIRSTNAME_WRITER));
		String numersdied = result.getString(DIED_YEAR);
		try {
			writer.setStartYear(simpledate.parse(result.getString(YEAR_OF_BIRTHDAY)));
			if (numersdied != null) {
				writer.setDiedYear(simpledate.parse(numersdied));
			} else {
				writer.setDiedYear(null);

			}
		} catch (ParseException e) {
			log.error(e);
		}
		return writer;
	}

}
