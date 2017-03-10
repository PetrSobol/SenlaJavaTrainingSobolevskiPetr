package com.senla.sobol.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;

/**
 * Servlet implementation class ExportOrder
 */
public class ExportOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(ExportOrder.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			((IOnlineBook) DI.load(IOnlineBook.class)).exportOrderCSV();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
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
