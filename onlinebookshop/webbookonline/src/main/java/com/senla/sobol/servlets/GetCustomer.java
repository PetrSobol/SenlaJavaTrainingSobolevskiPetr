package com.senla.sobol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Customer;

/**
 * Servlet implementation class GetCustomer
 */
public class GetCustomer extends HttpServlet {
	private static final String PHONE = "Phone";
	private static final String LAST_N_AME = "LastNAme";
	private static final String FIRSTNAME = "Firstname";
	private static final String ID_CUSTOMER = "idCustomer";
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
			for (Customer customer : ((IOnlineBook)DI.load(IOnlineBook.class)).getListCustomer()) {
				JSONObject json = new JSONObject();
				json.put(ID_CUSTOMER, customer.getIdCustomer());
				json.put(FIRSTNAME, customer.getFirstname());
				json.put(LAST_N_AME, customer.getLastname());
				json.put(PHONE, customer.getPhone());
				out.write(json.toJSONString());
				out.write("<br>");

			}
			out.flush();
		} catch (IOException |  InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
