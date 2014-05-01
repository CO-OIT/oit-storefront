package gov.oit.storefrontweb.manager;

import gov.oit.storefrontweb.model.Employee;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Test1Servlet extends HttpServlet {
	
	private Employee m_employee1;
	private Employee m_employee2;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		EmployeeManager mgr = new EmployeeManager();
		Setup();
		
		try {
		mgr.addEmployee(m_employee1);
		mgr.addEmployee(m_employee2);
		
		resp.getWriter().println("You rock!");
		}
		
		catch (Exception e) {
			resp.getWriter().println(e.getMessage());
		}
	}
	
	private void Setup()
	{
		m_employee1 = new Employee(997010002);
		m_employee1.setActive(true);
		//m_employee1.setAgency(null);
		m_employee1.setEmail("mail@mail.com");
		m_employee1.setEmployeeName("Peter Griffin");
		m_employee1.setPhone1("303.000.1111");
		m_employee1.setPhone2("720.111.2222 x23");
		m_employee1.setPositionNum("EGB99999");
		m_employee1.setUnit("EGB01");
		
		m_employee2 = new Employee(997010003);
		m_employee2.setActive(true);
		//m_employee2.setAgency(null);
		m_employee2.setEmail("mail2@mail.com");
		m_employee2.setEmployeeName("Eddie Spaghetti");
		m_employee2.setPhone1("303.000.1112");
		m_employee2.setPhone2("720.111.2223 x25");
		m_employee2.setPositionNum("EGB99900");
		m_employee2.setUnit("EGB02");
		
	}

	

}