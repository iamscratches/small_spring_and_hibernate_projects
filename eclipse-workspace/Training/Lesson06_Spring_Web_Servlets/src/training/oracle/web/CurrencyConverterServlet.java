package training.oracle.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import training.oracle.business.CurrencyConverter;

/**
 * Servlet implementation class CurrencyConverterServlet
 */
public class CurrencyConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrencyConverterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Gets the IOC container ref which was created and placed in SC Object
		ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		CurrencyConverter ccRef = (CurrencyConverter)appContext.getBean("currencyConverterBean");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>");
		//capturing value from input page
		String enteredDollars = request.getParameter("txtDollarField");
		double doubleValueOfEnteredDollars = Double.parseDouble(enteredDollars);
		
		// Invoking the Business Operations
		String result = ccRef.dollarsToRupees(doubleValueOfEnteredDollars);
		out.println(result);

		out.println("</h3>");
		out.println("</body>");
		out.println("<html>");
				
	}

}
