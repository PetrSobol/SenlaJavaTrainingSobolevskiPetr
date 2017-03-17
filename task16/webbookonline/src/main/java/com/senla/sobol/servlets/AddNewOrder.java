package com.senla.sobol.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AddNewOrder
 */
public class AddNewOrder extends AbstractServletes {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String ID_BOOK = "idBook";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		JSONObject jsonObject = getJson(request);
		getIOnlineBook().addNewOrder(Integer.valueOf((String) jsonObject.get(ID_CUSTOMER)),
				Integer.valueOf((String) jsonObject.get(ID_BOOK)));
	}

}
