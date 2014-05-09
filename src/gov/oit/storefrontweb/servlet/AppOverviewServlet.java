package gov.oit.storefrontweb.servlet;

import gov.oit.storefrontweb.model.AppInfoDetail;
import gov.oit.storefrontweb.model.DropdownInfo;
import gov.oit.storefrontweb.model.ServiceOverview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppOverviewServlet extends HttpServlet {
	
	static final long serialVersionUID = 9999991; 
	
	//Private Vars
    List<DropdownInfo> _ddFunctionalServiceGroup;
    List<DropdownInfo> _ddAgency;
    List<DropdownInfo> _ddServiceCategory;
    List<DropdownInfo> _ddAppPortfolio;
    List<DropdownInfo> _ddAppPriority;
    List<DropdownInfo> _ddAppArchitecture;
    List<DropdownInfo> _ddWebPlatform;
    List<DropdownInfo> _ddAppPlatform;
    List<DropdownInfo> _ddUserLANClass;
    List<DropdownInfo> _ddSiteGateway;
    List<DropdownInfo> _ddServerPlatform;
    List<DropdownInfo> _ddHypervisor;
    List<DropdownInfo> _ddHostOS;
    List<DropdownInfo> _ddGuestOS;
	
	ServiceOverview _serviceOverview;
    

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
		
		
		String key = req.getParameter("key");
		
		//Is this a new record?
        if (null == key || key.trim() == "") {
           req = this.getNewRequest();    	
        }
		
		//Is this be update, yo?
        else {
          
          //TODO: Populate with existing data from datastore
           _serviceOverview = new ServiceOverview();
           
           req = this.getUpdateRequest(key);
        }
		
		req.getRequestDispatcher("/WEB-INF/runbook.jsp").forward(req, resp);

	}
	
	
	
	//Get new request -- blank fields and default dropdowns
	private HttpServletRequest getNewRequest() {
		
		return null;
		
	}
	
	
	private HttpServletRequest getUpdateRequest(String key) {

		return null;
		
		
		
	}
	
	
	private HttpServletResponse createNewAppOverview() {
		return null;
		
	}
	
	private HttpServletResponse createEditForm() {
		return null;
		
	}
	
	
	
	private void assignDropdownInfo() {
			  
       //Get all app info details as list
		
	  // Break list into subgroups
		
		List<DropdownInfo> baseList = getBaseDropdownInfoList();
		String itemKeySelected = "";
			
		for (DropdownInfo item : baseList) {
			
			switch (item.get_category().toUpperCase()) {

			case "FUNC-SERVICE-GROUP":
				itemKeySelected = _serviceOverview.get_functionalServiceKey();
				_ddFunctionalServiceGroup.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "AGENCY":
				itemKeySelected = _serviceOverview.get_agencyKey();
				_ddAgency.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "SERVICE-CATEGORY":
				itemKeySelected = _serviceOverview.get_catKey();
				_ddServiceCategory.add(this.revisedEntry(item, itemKeySelected));
				break;
			
			case "APP-PORTFOLIO":
				itemKeySelected = _serviceOverview.get_portfolioKey();
				_ddAppPortfolio.add(this.revisedEntry(item, itemKeySelected));
			    break;
			
			case "APP-PRIORITY":
				itemKeySelected = _serviceOverview.get_priorityKey();
				_ddAppPriority.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "APP-ARCHITECTURE":
				itemKeySelected = _serviceOverview.get_appArchKey();
				_ddAppArchitecture.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "WEB-PLATFORM":
				itemKeySelected = _serviceOverview.get_webPlatformKey();
				_ddWebPlatform.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "USER-LAN-CLASS":
				itemKeySelected = _serviceOverview.get_lanClassKey();
				_ddUserLANClass.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "SITE-GATEWAY":
				itemKeySelected = _serviceOverview.get_siteGatewayKey();
				_ddSiteGateway.add(this.revisedEntry(item, itemKeySelected));
				break;
			
			case "SERVER-PLATFORM":
				itemKeySelected = _serviceOverview.get_serverPlatformKey();
				_ddServerPlatform.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			case "HYPERVISOR":
				itemKeySelected = _serviceOverview.get_hypervisorKey();
				_ddHypervisor.add(this.revisedEntry(item, itemKeySelected));
				break;
					
			case "HOST-OS":
				itemKeySelected = _serviceOverview.get_hostOsKey();
				_ddHostOS.add(this.revisedEntry(item, itemKeySelected));
				break;

			case "GUEST-OS":
				itemKeySelected = _serviceOverview.get_guestOsKey();
				_ddGuestOS.add(this.revisedEntry(item, itemKeySelected));
				break;
				
			default:
				//Log error.
				break;			
			}
		}
	}
				
		//Determine whether the selected key for this application overview dropdown item 
		// (if this is an edit) correlates to the dropdownInfo item being fed into this
		// method.
		// If it does, mark "selected" as true.
		private DropdownInfo revisedEntry(DropdownInfo inDropdownInfo, 
				String appKeySelected) {

			DropdownInfo returnDropdown = null;
			String thisKey = inDropdownInfo.get_key();

			Boolean selected = (thisKey == appKeySelected)  ? true : false; 
			
            if (selected) {
			   returnDropdown = new DropdownInfo(inDropdownInfo.get_key(), inDropdownInfo.get_description(), inDropdownInfo.get_category(), selected, inDropdownInfo.get_order());
            }
            
            else {
              returnDropdown = inDropdownInfo;
            }
			
			return returnDropdown;
		}
		
		
	private List<DropdownInfo> getBaseDropdownInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
