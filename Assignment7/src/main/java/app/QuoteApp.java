/**
 * 
 */
package main.java.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author AJS
 *
 */
public class QuoteApp {

	private static void exec(final String stockType, final String format) {
		HttpURLConnection conn = null;
		String baseUrl = "http://localhost:8080/StockQuote/YahooStockQuoteServlet";
		try {

			String urlStr = String.format("%s?stockType=%s&format=%s", baseUrl, stockType, format);
			System.out.println(urlStr);
			URL url = new URL(urlStr);

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			System.out.printf("Content-Type: %s%n", conn.getContentType());

			InputStream in = conn.getInputStream();
			Reader rdr = new InputStreamReader(in);
			char buf[] = new char[1024];
			int len = 0;
			while ((len = rdr.read(buf)) != -1) {
				System.out.print(new String(buf, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		System.out.println("JSON:");
		exec("EXPD", "json");
		System.out.println();

		System.out.println();
		System.out.println("plain:");
		exec("EXPD", "plain");

		System.out.println();
		System.out.println("HTML:");
		exec("EXPD", "html");

		System.out.println();
		System.out.println("XML:");
		exec("EXPD", "xml");

		System.out.println();
		System.out.println();

		System.out.println("JSON:");
		exec("AMZN", "json");
		System.out.println();

		System.out.println();
		System.out.println("plain:");
		exec("AMZN", "plain");

		System.out.println();
		System.out.println("HTML:");
		exec("AMZN", "html");

		System.out.println();
		System.out.println("XML:");
		exec("AMZN", "xml");

		System.out.println();
		System.out.println();

	}

}
