package com.senla.sobol.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class ACommonDAO<T> {
	private static Logger log = Logger.getLogger(ACommonDAO.class.getName());

	public abstract String getInsertSql();

	public abstract String getUpdateSql();

	public abstract String getDeletSql();

	public abstract String getId();

	public abstract void prepareStatemantOnInsert(PreparedStatement prepar, T t) throws SQLException;

	public abstract void prepareStatemantOnDelete(PreparedStatement prepar, Integer t) throws SQLException;

	public abstract void prepareStatemantOnUpdate(PreparedStatement prepar, T t) throws SQLException;

	public abstract T getResultSetId(ResultSet result) throws SQLException;

	public abstract List<T> getReadAllTable(Connection conection, String date);

	public T getID(Connection connection, Integer id) {
		PreparedStatement prepar = null;
		ResultSet result = null;
		T t = null;
		try {
			prepar = connection.prepareStatement(getId());
			prepareStatemantOnDelete(prepar, id);
			result = prepar.executeQuery();
			while (result.next()) {
				t = getResultSetId(result);
				return t;
			}

		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				prepar.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
		return null;
	}

	public void addNew(Connection connection, T t) throws SQLException {
		PreparedStatement prepar = null;
		try {
			prepar = connection.prepareStatement(getInsertSql());
			prepareStatemantOnInsert(prepar, t);
			prepar.executeUpdate();
		} finally {
			try {
				prepar.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}

	};

	public void delete(Connection connection, Integer t) {
		PreparedStatement prepar = null;
		try {
			prepar = connection.prepareStatement(getDeletSql());
			prepareStatemantOnDelete(prepar, t);
			prepar.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				prepar.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}

	};

	public void update(Connection connection, T t) {
		PreparedStatement prepar = null;
		try {
			prepar = connection.prepareStatement(getUpdateSql());
			prepareStatemantOnUpdate(prepar, t);
			prepar.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				prepar.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}

	};

}
