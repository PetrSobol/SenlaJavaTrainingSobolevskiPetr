package com.senla.sobol.dao;

import java.util.List;
import org.hibernate.Session;
import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Writer;

public class WriterDao extends ACommonDAO<Writer> {
	public WriterDao() {
		super(Writer.class);
	}

	public void addNewWriter(Session session, Writer t) {
		addNew(session, t);
	}

	public List<Writer> getReadAllTable(Session session, String date) {
		List<Writer> listwriter = getAll(session, date);
		return listwriter;
	}

	public void deleteWriter(Session session, Writer writer) {
		delete(session, writer);
	}

	public void updateWriter(Session session, Writer t) {
		update(session, t);
	}

	public Writer getIdWriter(Session session, Integer id) {
		Writer writer = getID(session, id);
		return writer;

	}

}
