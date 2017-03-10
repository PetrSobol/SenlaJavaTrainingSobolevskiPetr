package com.senla.sobol.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;

/**
 * Servlet implementation class DeletWriter
 */
public class DeletWriter extends HttpServlet {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String ID_WRITER = "idWriter";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(DeletWriter.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		BufferedReader reader;
		try {
			reader = request.getReader();
			StringBuilder stringbuilder = new StringBuilder();
			String string = null;
			while ((string = reader.readLine()) != null) {
				stringbuilder.append(string);
			}
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(stringbuilder.toString());
			((IOnlineBook) DI.load(IOnlineBook.class))
					.deleteWriter(Integer.valueOf((String) jsonObject.get(ID_WRITER)));
			;
		} catch (IOException | ParseException | NumberFormatException | InstantiationException | IllegalAccessException
				| ClassNotFoundException e1) {
			log.error(e1);
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
