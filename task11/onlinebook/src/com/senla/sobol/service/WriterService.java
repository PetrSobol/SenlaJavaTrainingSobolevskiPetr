package com.senla.sobol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.WriterDao;
import com.senla.sobol.interfaces.IWriterService;
import com.senla.sobol.model.IWriter;

public class WriterService implements IWriterService {
	private static Logger log = Logger.getLogger(WriterService.class.getName());

	private WriterDao writerdao;
	private Connection connection;

	public WriterService() {
		super();
		try {
			this.writerdao = new WriterDao();
			this.connection = DBConnector.getInstance().getConnection();
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public void delete(Integer  idWriter) {
		writerdao.delete(connection,idWriter);

	}

	public void update(IWriter t) {
		writerdao.update(connection,t);

	}

	
	public void add(IWriter t) {
		writerdao.addNew(connection,t);

	}

	
	public List<IWriter> getAll(String date) {
		List<IWriter> listwriter=null;
		if(date!=null){
			listwriter = writerdao.getReadAllTable(connection,date);
		}else{
			listwriter = writerdao.getReadAllTable(connection,null);
		}
		
		return listwriter;
	}

	public IWriter getWriter(Integer id) {
		IWriter writer = writerdao.getWriter(connection,id);
		return writer;

	}
}
