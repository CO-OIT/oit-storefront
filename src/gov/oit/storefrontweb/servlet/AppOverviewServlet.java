package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.model.AppInfoDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppOverviewServlet extends HttpServlet {
	
	static final long serialVersionUID = 9999991; 

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		PrintWriter toClient = resp.getWriter();
		String frmActionString = (String)req.getParameter("yucko");
		
	       //Open the file for writing the survey results.


    // Respond to client with a thank you
		toClient.println("<html>");
		toClient.println("<title>Thank you!</title>");
        toClient.println("Thank you for participating");
        toClient.println("you picked " + frmActionString);
        toClient.println("</html>");
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Create an instance of AppInfoDetail
		AppInfoDetail detail = new AppInfoDetail();
		
		//Call the list of application architecture types for dropdown
		//List<AppInfoDetail> appar  = detail.listForHeadingType("APPAR");
		
		//Return the list to the view
		//req.setAttribute("appar", appar);
	    req.getRequestDispatcher("RunBook.jsp").forward(req, resp);
	}
	
	
	
	
	
}
