package com.senla.sobol.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AddNewWriter
 */
public class AddNewWriter extends AbstractServletes {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String DIEDDATE = "dieddate";
	private static final String STARTDATE = "startdate";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		JSONObject jsonObject = getJson(request);
		getIOnlineBook().addNewWriter((String) jsonObject.get(FIRSTNAME), (String) jsonObject.get(LASTNAME),
				(String) jsonObject.get(STARTDATE), (String) jsonObject.get(DIEDDATE));
	}

}
