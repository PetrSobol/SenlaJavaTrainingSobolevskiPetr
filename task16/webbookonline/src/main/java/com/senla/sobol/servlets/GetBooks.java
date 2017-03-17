package com.senla.sobol.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

public class GetBooks extends AbstractServletes {
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
			JSONArray jsonarray = getJSONArrayBook(getIOnlineBook().getListBook());
			out.write(jsonarray.toJSONString());
			out.flush();
		} catch (IOException | IllegalArgumentException | SecurityException e) {
			log.error(e);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}

}
