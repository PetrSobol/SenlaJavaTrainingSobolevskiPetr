package com.senla.sobol.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.senla.sobol.controller.OnlineBook;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Orders;

/**
 * Servlet implementation class OrderByIdCustomer
 */
public class OrderByIdCustomer extends HttpServlet {
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	private static final String DATE_ORDER = "dateOrder";
	private static final String FIRSTNAME = "firstname";
	private static final String NAME_BOOK = "nameBook";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(OrderByIdCustomer.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		PrintWriter printerwriter = null;
		BufferedReader reader;
		try {
			reader = request.getReader();
			printerwriter = response.getWriter();
			StringBuilder stringbuilder = new StringBuilder();
			String string = null;
			while ((string = reader.readLine()) != null) {
				stringbuilder.append(string);
			}
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(stringbuilder.toString());
			for (Orders orders : ((IOnlineBook) OnlineBook.getInstance())
					.getListOrderByIdCustomer(Integer.valueOf((String) jsonObject.get(ID_CUSTOMER)))) {
				JSONObject jsObject = new JSONObject();
				jsObject.put(NAME_BOOK, orders.getBook().getNameBook());
				jsObject.put(FIRSTNAME, orders.getCustomer().getFirstname());
				jsObject.put(DATE_ORDER, orders.getDateOrder());
				printerwriter.write(jsObject.toJSONString());
				printerwriter.write("<br>");
			}
		} catch (IOException | ParseException | NumberFormatException | SQLException e1) {
			log.error(e1);
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
