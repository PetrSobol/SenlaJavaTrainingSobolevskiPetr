package com.senla.sobol.servlets;

import java.io.BufferedReader;
import java.io.IOException;

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
 * Servlet implementation class AddBooks
 */
public class AddBooks extends HttpServlet {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String PRICE = "price";
	private static final String QUANTITY_PAGES = "quantityPages";
	private static final String NAME_BOOK = "nameBook";
	private static final String ID_WRITER = "idWriter";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(AddBooks.class.getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		BufferedReader reader = null;
		try {
			StringBuilder stringbuilder = new StringBuilder();
			String string = null;
			while ((string = reader.readLine()) != null) {
				stringbuilder.append(string);
			}
			JSONParser parser = new JSONParser();
			reader = request.getReader();
			JSONObject jsonObject = (JSONObject) parser.parse(stringbuilder.toString());
			((IOnlineBook)DI.load(IOnlineBook.class)).addNewBook(Integer.valueOf((String) jsonObject.get(ID_WRITER)),
					(String) jsonObject.get(NAME_BOOK), Integer.valueOf((String) jsonObject.get(QUANTITY_PAGES)),
					Integer.valueOf((String) jsonObject.get(PRICE)));
		} catch (IOException | ParseException | NumberFormatException | InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			log.error(e1);
		}

	}

}
