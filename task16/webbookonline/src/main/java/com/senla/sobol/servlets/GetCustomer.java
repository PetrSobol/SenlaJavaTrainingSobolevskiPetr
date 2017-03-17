package com.senla.sobol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

/**
 * Servlet implementation class GetCustomer
 */
public class GetCustomer extends AbstractServletes {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(GetCustomer.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONArray jsonarray = getJSONArrayCustomer(getIOnlineBook().getListCustomer());
			out.write(jsonarray.toJSONString());
			out.flush();
		} catch (IOException e) {
			log.error(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		this.doGet(request, response);

	}

}
