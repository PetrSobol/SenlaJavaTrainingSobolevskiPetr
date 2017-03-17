package com.senla.sobol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Book;

public class GetBooks extends HttpServlet {
	private static final String PRICE = "price";
	private static final String NAME_BOOK = "nameBook";
	private static final String ID_BOOK = "idBook";
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=utf-8";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(GetBooks.class.getName());
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType(APPLICATION_JSON_CHARSET_UTF_8);
		PrintWriter out;
		try {
			out = response.getWriter();
			for (Book book : ((IOnlineBook)DI.load(IOnlineBook.class)).getListBook()) {
				JSONObject json = new JSONObject();
				json.put(ID_BOOK, book.getIdBook());
				json.put(NAME_BOOK, book.getNameBook());
				json.put(PRICE, book.getPrice());
				out.write(json.toJSONString());
				out.write("<br>");

			}
			out.flush();
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e);
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		this.doGet(request, response);

	}

}
