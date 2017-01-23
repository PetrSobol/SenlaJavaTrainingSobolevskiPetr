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
import com.senla.sobol.model.IWriter;
import interfaces.IWriterDao;
import model.Writer;

public class WriterDao implements IWriterDao {
	private static Logger log = Logger.getLogger(WriterDao.class.getName());
	private Connection connection;
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	public WriterDao() {
		super();
	}

	public WriterDao(Connection connection) {
		this.connection = connection;
	}

	public IWriter getWriter(Integer id) {
		List<IWriter> listwriter = getReadAllTable();
		for (IWriter writer : listwriter) {
			if (id.equals(writer.getIdWriter())) {
				return writer;
			}
		}
		return null;
	}

	@Override
	public void addNew(IWriter t) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(
					"INSERT INTO `mydb`.`writer` (`lastnameWriter`, `firstnameWriter`, `yearOfBirthday`, `diedYear`) VALUES (?, ?, ?, ?)");
			statement.setString(1, t.getLastname());
			statement.setString(2, t.getFirstname());
			statement.setString(3, simpledate.format(t.getStartYear()));
			statement.setString(4, simpledate.format(t.getDiedYear()));
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
	public List<IWriter> getReadAllTable() {
		PreparedStatement statement = null;
		ResultSet set = null;
		Writer writer = null;
		List<IWriter> listwriter = new ArrayList<IWriter>();
		try {
			statement = connection.prepareStatement("SELECT * from mydb.writer ");
			set = statement.executeQuery();
			while (set.next()) {
				writer = new Writer();
				writer.setIdWriter(set.getInt("idWriter"));
				writer.setLastname(set.getString("lastnameWriter"));
				writer.setFirstname(set.getString("firstnameWriter"));
				writer.setStartYear(simpledate.parse(set.getString("yearOfBirthday")));
				writer.setDiedYear(simpledate.parse(set.getString("diedYear")));
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

	@Override
	public void delete(IWriter t) {
		PreparedStatement statement = null;
		try {
			statement = connection
					.prepareStatement("DELETE FROM `mydb`.`writer` WHERE `idWriter`='" + t.getIdWriter() + "'");
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
	public void update(IWriter t) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("UPDATE `mydb`.`writer` SET `lastnameWriter`='" + t.getLastname()
					+ "', `firstnameWriter`='" + t.getFirstname() + "', `yearOfBirthday`='"
					+ simpledate.format(t.getStartYear()) + "', `diedYear`='" + simpledate.format(t.getDiedYear())
					+ "' WHERE `idWriter`='" + t.getIdWriter() + "'");
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
