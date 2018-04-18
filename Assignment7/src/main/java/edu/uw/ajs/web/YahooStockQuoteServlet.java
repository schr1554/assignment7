/**
 * 
 */
package main.java.edu.uw.ajs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uw.ext.quote.YahooQuote;

public class YahooStockQuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public YahooStockQuoteServlet() {
	}

	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		servletRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		servletRequest(request, response);
	}

	void servletRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stock = request.getParameter("stockType");
		String responseXml = null;
		YahooQuote quote;
		switch (stock) {
		case "expd":
			quote = YahooQuote.getQuote(stock);
			responseXml = quote.getSymbol();
			break;
		case "amzn":
			quote = YahooQuote.getQuote(stock);
			responseXml = quote.getSymbol();
			break;

		default:
			responseXml = "Default";
		}

		response.setContentType("text/plain");
		response.setContentLength(responseXml.length());
		response.getWriter().print(responseXml);
	}

}