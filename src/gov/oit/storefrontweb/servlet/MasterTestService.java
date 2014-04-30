package gov.oit.storefrontweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.oit.storefrontweb.model.*;

public class MasterTestService extends HttpServlet {

	//private test objects
	
	private Employee _employee1, _employee2;
	private Agency _agency1, _agency2;
    private OitService _service1, _service2, _service3, _service4;
    
	
	static String APP_PRIORITY = "APPPR";
	static String APP_PORTFOLIO = "APPPO";
	static String APP_ARCHITECTURE = "APPAR";
	static String WEB_PLATFORM = "WEBPL";
	static String APP_PLATFORM = "APPPL";
    
	static String SERV_CORE = "CORE";
  	static String SERV_CIM = "CIM";
	static String SERV_DINS = "DINS";
	static String SERV_SFRO = "SFRO";

	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		this.setupOitServices();
		this.setupAppInfo();
		this.setupAgency();
		this.setupEmployees();
		this.setupOitServices();
		
	}
	
	
	private void setupOitServices() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(9999,12,31);
				
		List<String> fakeClassifications = new ArrayList<String>();
		
		fakeClassifications.add("class1");
		fakeClassifications.add("class2");
		fakeClassifications.add("class3");
		fakeClassifications.add("class4");
		fakeClassifications.add("class5");
		fakeClassifications.add("class6");
		fakeClassifications.add("class7");
		fakeClassifications.add("class8");
		
		
		//CORE
		_service1 = new OitService(SERV_CORE);
		_service1.setActive(true);
		_service1.setDateAddedToSP(new java.util.Date());
		_service1.setDescription("Swiss Army Knife of finance.");
		_service1.setFundedThroughDate(cal.getTime());
		_service1.setServiceClassifications(fakeClassifications);
		_service1.setServiceName("Colorado Operations Resource Engine (CORE)");
		
		//CIM
		_service2 = new OitService(SERV_CIM);
		_service2.setActive(true);
		_service2.setDateAddedToSP(new java.util.Date());
		_service2.setDescription("All knowledge in the world.");
		_service2.setFundedThroughDate(cal.getTime());
		_service2.setServiceClassifications(fakeClassifications);
		_service2.setServiceName("Colorado Information Marketplace");
		
		//DINS
		_service3 = new OitService(SERV_DINS);
		_service3.setActive(true);
		_service3.setDateAddedToSP(new java.util.Date());
		_service3.setDescription("We are watching you.");
		_service3.setFundedThroughDate(cal.getTime());
		_service3.setServiceClassifications(fakeClassifications);
		_service3.setServiceName("Data Insights");


		//SFRO
		_service4 = new OitService(SERV_SFRO);
		_service4.setActive(true);
		_service4.setDateAddedToSP(new java.util.Date());
		_service4.setDescription("All roads leave and start here!");
		_service4.setFundedThroughDate(cal.getTime());
		_service4.setServiceClassifications(fakeClassifications);
		_service4.setServiceName("OIT Storefront");
		
		_service1.save();
		_service2.save();
		_service3.save();
		_service4.save();
	}
	
	private void setupEmployees()
	{
		Employee employee1, employee2;

		employee1 = new Employee(997010002);
		employee1.setActive(true);
		//employee1.setAgency(null);
		employee1.setEmail("mail@mail.com");
		employee1.setEmployeeName("Peter Griffin");
		employee1.setPhone1("303.000.1111");
		employee1.setPhone2("720.111.2222 x23");
		employee1.setPositionNum("EGB99999");
		employee1.setUnit("EGB01");
		
		employee1.save();
		
		employee2 = new Employee(997010003);
		employee2.setActive(true);
		//employee2.setAgency(null);
		employee2.setEmail("mail2@mail.com");
		employee2.setEmployeeName("Eddie Spaghetti");
		employee2.setPhone1("303.000.1112");
		employee2.setPhone2("720.111.2223 x25");
		employee2.setPositionNum("EGB99900");
		employee2.setUnit("EGB02");

		employee2.save();
			
	}
	
	private void setupAgency()
	{
		Agency agency1, agency2;
		
		agency1 = new Agency("FAA");
        agency1.setAgencyName("Public Health and Environment");
        agency1.save();
        
		agency2 = new Agency("GFB");
        agency2.setAgencyName("CU Boulder");
        agency2.save();
	}
	
	private void setupAppInfo()
	{
		//Make arrays (collections) for the headings and details.
		//Iterate through and save the objects
		
		
		AppInfoHeading h_priority, h_portfolio, h_arch, h_wplatform, h_aplatform;
		AppInfoDetail detail1, detail2, detail3, detail4, detail5, detail6;
		
		h_priority = new AppInfoHeading(APP_PRIORITY);
		h_priority.setHeadingShortDescription("App Priority");
		h_priority.setHeadingLongDescription("Application Priority");
		h_priority.save();
		
		h_portfolio = new AppInfoHeading(APP_PORTFOLIO);
		h_portfolio.setHeadingShortDescription("App Portfolio");
		h_portfolio.setHeadingLongDescription("Application Portfolio");
		h_portfolio.save();
		
		h_arch = new AppInfoHeading(APP_ARCHITECTURE);
		h_arch.setHeadingShortDescription("App Architecture");
		h_arch.setHeadingLongDescription("Application Architecture");
        h_arch.save();
		
		h_wplatform = new AppInfoHeading(WEB_PLATFORM);
		h_wplatform.setHeadingShortDescription("Web Platform");
		h_wplatform.setHeadingLongDescription("Web Platform");
        h_wplatform.save();
		
		h_aplatform = new AppInfoHeading(APP_PLATFORM);
		h_aplatform.setHeadingShortDescription("App Platform");
		h_aplatform.setHeadingLongDescription("Application Platform");
        h_aplatform.save();		

		String[] vals = { "Low", "Medium", "High", "Urgent" };
		this.SaveAppInfo(APP_PRIORITY, vals);
		
		String[] vals2 = { "None","RCRS","EPS","AFM","SFTY","DOLE","HLTH"};
		this.SaveAppInfo(APP_PORTFOLIO, vals2);
		
		String[] vals3 = { "None","Mainframe","2-Tier","3-Tier","Client-Server","Cloud","Desktop","Distributed","Mobile","Web Service" };
        this.SaveAppInfo(APP_ARCHITECTURE, vals3);

		String[] vals4 = { "None","Spring MVC",".NET MVC","Struts","GAE","SalesForce","Homebrew" };
        this.SaveAppInfo(WEB_PLATFORM, vals4);
        
		String[] vals5 = { "None","People Strategy","IBI","CA","Homebrew" };
        this.SaveAppInfo(APP_PLATFORM, vals5);
				
	}
	
	private void SaveAppInfo(String headingId, String[] vals) {
		
		AppInfoDetail detail;
		
		for (String thisValue : vals) {
			detail = new AppInfoDetail();
			detail.setAppInfoHeadingId(headingId);
			detail.setDetailLongDescription(thisValue);
			detail.setDetailShortDescription(thisValue);			
			detail.save();
		}
		
		
	}
	
}
	
