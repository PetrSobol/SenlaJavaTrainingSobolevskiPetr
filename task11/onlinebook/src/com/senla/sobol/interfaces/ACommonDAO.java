package com.senla.sobol.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class ACommonDAO<T> {
	public void addNew(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.executeUpdate();
	};

	public abstract List<T> getReadAllTable(Connection conection,String date);

	public void delete(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.executeUpdate();
	};

	public void update(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.executeUpdate();
	};

}
