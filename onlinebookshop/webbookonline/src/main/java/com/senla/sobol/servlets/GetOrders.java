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
import com.senla.sobol.model.Orders;

/**
 * Servlet implementation class GetOrders
 */
public class GetOrders extends HttpServlet {
	private static final String DATE_ORDER = "Date order";
	private static final String FIRSTNAME_ORDERS = "FirstnameOrders";
	private static final String NAME_BOOK = "nameBook";
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(GetOrders.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		PrintWriter out = response.getWriter();

		try {
			for (Orders orders : ((IOnlineBook)OnlineBook.getInstance()).getListOrder()) {
				JSONObject json = new JSONObject();
				json.put(NAME_BOOK, orders.getBook().getNameBook());
				json.put(FIRSTNAME_ORDERS, orders.getCustomer().getFirstname());
				json.put(DATE_ORDER, orders.getDateOrder());
				out.print(json);
				out.print("<br>");

			}
		} catch (  SQLException e) {
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
