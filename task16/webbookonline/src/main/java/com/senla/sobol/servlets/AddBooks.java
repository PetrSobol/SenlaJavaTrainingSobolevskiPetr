package com.senla.sobol.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AddBooks
 */
public class AddBooks extends AbstractServletes {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String PRICE = "price";
	private static final String QUANTITY_PAGES = "quantityPages";
	private static final String NAME_BOOK = "nameBook";
	private static final String ID_WRITER = "idWriter";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		JSONObject jsonObject = getJson(request);
		getIOnlineBook().addNewBook(Integer.valueOf((String) jsonObject.get(ID_WRITER)),
				(String) jsonObject.get(NAME_BOOK), Integer.valueOf((String) jsonObject.get(QUANTITY_PAGES)),
				Integer.valueOf((String) jsonObject.get(PRICE)));

	}

}
