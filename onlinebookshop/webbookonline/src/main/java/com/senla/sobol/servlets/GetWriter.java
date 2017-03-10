package com.senla.sobol.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.senla.sobol.controller.OnlineBook;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Writer;

/**
 * Servlet implementation class GetWriter
 */
public class GetWriter extends HttpServlet {
	private static final String DIED_YEAR = "Died year";
	private static final String START_YEAR = "Start year";
	private static final String LAST_N_AME = "LastNAme";
	private static final String FIRSTNAME = "Firstname";
	private static final String ID_WRITER = "idWriter";
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(GetWriter.class.getName());


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		PrintWriter out;
		try {
			out = response.getWriter();
			for (Writer writer : ((IOnlineBook)OnlineBook.getInstance()).getListWriter()) {
				JSONObject json = new JSONObject();
				json.put(ID_WRITER, writer.getIdWriter());
				json.put(FIRSTNAME, writer.getFirstname());
				json.put(LAST_N_AME, writer.getLastname());
				json.put(START_YEAR, writer.getStartYear());
				json.put(DIED_YEAR, writer.getDiedYear());
				out.write(json.toJSONString());
				out.write("<br>");

			}
			out.flush();
		} catch (IOException | SQLException e) {
			log.error(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
