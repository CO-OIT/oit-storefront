package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.manager.EmployeeManager;
import gov.oit.storefrontweb.model.Employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchEidServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	
		EmployeeManager employeeMgr = new EmployeeManager();
		/*Employee emp = employeeMgr.searchByEid(997010002);
		
		resp.getWriter().println(emp.getEmployeeName());*/
		
		List<Employee> list = employeeMgr.searchByName("Peter");
		
		if (list == null || list.isEmpty()) {
			resp.getWriter().println("Search Not Successful");			
		}
		
		else	
		{
			for (Employee e : list) {
				resp.getWriter().println(e.getEid() + " " + e.getEmployeeName());
			}
		
		}
		
/*		if (emp == null) {
			resp.getWriter().println("Search Not Successful");
		}
		
		else {
		resp.getWriter().println("Search Successful");
		}
	} */
	
	}
}
