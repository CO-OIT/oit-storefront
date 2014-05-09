<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>OIT Application Portfolio Management</title>

<!--  JQuery Imported from Google Repo -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<!--  Call tab function -->
 <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>



<style>
body {font-family: Trebuchet, Arial, sans-serif;
  background: #9CAFC4;
  margin: 0px 0px;}

select { width: 230px; }
option { font-size: 90%; }


ul#tabby li { font-size: 10px; }

div#header { width: 100%; background: White; text-align: left; height: 100px; margin-top: 0px; border: 1px solid White;}

div#header img { float: left; padding-top: 20px; }
div#header h1 { padding-top: 25px; font-weight: normal; text-transform: uppercase; color: #666; letter-spacing: .3em; font-size: 20px; }

div#container {
   display: block;
   background: #DDE4EC;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
   padding: 14px;
   width: 65%;
}

table#tblMain {
    border-collapse: collapse;
    width: 100%;
}


td.sub1, td.sub2 {
background: #aebcbf; /* Old browsers */
background: -moz-linear-gradient(top,  #aebcbf 0%, #6e7774 50%, #0a0e0a 95%, #0a0809 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#aebcbf), color-stop(50%,#6e7774), color-stop(95%,#0a0e0a), color-stop(100%,#0a0809)); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  #aebcbf 0%,#6e7774 50%,#0a0e0a 95%,#0a0809 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  #aebcbf 0%,#6e7774 50%,#0a0e0a 95%,#0a0809 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  #aebcbf 0%,#6e7774 50%,#0a0e0a 95%,#0a0809 100%); /* IE10+ */
background: linear-gradient(to bottom,  #aebcbf 0%,#6e7774 50%,#0a0e0a 95%,#0a0809 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#aebcbf', endColorstr='#0a0809',GradientType=0 ); /* IE6-9 */

color: White;
font-weight: bold;
text-align: left;
padding: 2px 3px;

border-top: 6px solid White;
margin-bottom: 6px;
}

input[type="text"] { width: 190px; }

p.small {font-size: 70%;}

td.sub2 { border-left: 6px solid White; }

td.col1, td.col2 { text-align: left; padding: 2px 3px; }

tr td.col1 { background: #EFEFEF;}
tr td.col2 { background: #E5E5E5; border-left: 6px solid White;}

label { 
            color: #666;
			display: block;
			float: left;
          	width: 200px;
          	font-size: 80%; }

</style>

</head>
<body>



<div id="container">

  <div id="header">
     <img src="img/OIT_Shield.png" />
     <h1 class="pageTitle" style="margin-left: 300px">Application Portfolio Management</h1>
  </div>

 <div id="tabs">
  <ul id="tabby">
    <li><a href="#tabs-1">Service Overview</a></li>
    <li><a href="#tabs-2">Service Workflow</a></li>
    <li><a href="#tabs-3">Tech. Specifications</a></li>
    <li><a href="#tabs-4">Application Architecture</a></li>
    <li><a href="#tabs-5">Data &amp; Information</a></li>
    <li><a href="#tabs-6">Network Topology</a></li>
    <li><a href="#tabs-7">Platforms &amp; Infrastructure</a></li>
    <li><a href="#tabs-8">First Selections</a></li>
  </ul>
  
  <div id="tabs-1">
		<form>

			      <p class="small">
			         This tab should be completed by the ASM or Service Owner/Mgr.
			      </p>
			      
			      <p class="small">
			         Direct questions or comments to the Senior Service Portfolio Mgr (SSPM) or send an email to: oit_enterprisearchitecturegroup@state.co.us
			      </p>
		
			<input type="hidden" name="hiddenId" Id="hiddenId" value='<%= request.getParameter("info.key") %>' />

			<table id="tblMain">
						 
			 <!--  Services -->
			 <tr>
			    <td class="sub1">Service Classifications</td>
			    <td class="sub2">Service Roles</td>			 
			 </tr>
			 
			 <tr>
			     <td class="col1"><label for="txtServiceName">Service or Application Name</label>
			         <input type="text" name="txtServiceName" id="txtServiceName" value='<%= request.getParameter("info.appName") %>'>
			     </td>

			     <td class="col2"><label for="ddFunctionalServiceGroup">Functional Service Group</label>
			         <select id="ddFunctionalServiceGroup" name="ddFunctionalServiceGroup">
    			         <c:forEach items="${ddFunctionalServiceGroup}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>
			         </select>
			     </td>
			 </tr>
			 
			 <tr >
			     <td  class="col1"><label for="ddAgency">Agency</label>
			         <select id="ddAgency" name="ddAgency">
    			         <c:forEach items="${ddAgency}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>
			         </select>
			     </td>

			     <td class="col2"><label for="txtBusinessOwner">Business Owner</label>
			         <input type="text" id="txtBusinessOwner" name="txtBusinessOwner" value='<%= request.getParameter("info.businessOwner") %>' />
			     </td>
			 </tr>
			 
			 <tr >
			     <td  class="col1"><label for="ddServiceCategory">Service Category</label>
			         <select id="ddServiceCategory" name="ddServiceCategory">
    			         <c:forEach items="${ddServiceCategory}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>
			         </select>
			     </td>

			     <td class="col2"></td>
			 </tr>
			 
			 
			 
			 <!--  Application -->
			 <tr>
			    <td class="sub1">Application Classifications</td>
			    <td class="sub2">Application Roles</td>			 		 
			 </tr>
			 
			 <tr >
			     <td  class="col1"><label for="ddAppPortfolio">Application Portfolio</label>
			         <select id="ddAppPortfolio" name="ddAppPortfolio">
    			         <c:forEach items="${ddAppPortfolio}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>
			         </select>
			     </td>

			     <td class="col2"><label for="txtSrPortfolioMgr">Senior Portfolio Manager</label>
			         <input type="text" id="txtSrPortfolioMgr" name="txtSrPortfolioMgr" value='<%= request.getParameter("info.portfolioManager") %>' />
			     </td>
			 </tr>
			 
			 <tr>
			     <td  class="col1"><label for="ddAppPriority">Application Priority</label>
			         <select id="ddAppPriority" name="ddAppPriority">
    			         <c:forEach items="${ddAppPriority}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>

			         </select>
			     </td>

			     <td class="col2"><label for="txtApplicationMgr">Application Manager</label>
			         <input type="text" id="txtApplicationMgr" name="txtApplicationMgr" value='<%= request.getParameter("info.appManager") %>' />
			     </td>
			 </tr>
			 
		    <tr >
			     <td  class="col1"><label for="ddAppArchitecture">Application Architecture</label>
			         <select id="ddAppArchitecture" name="ddAppArchitecture">
    			         <c:forEach items="${ddAppArchitecture}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>
			         </select>
			     </td>

			     <td class="col2"><label for="txtSolutionArchitect">Solution Architect</label>
			         <input type="text" id="txtSolutionArchitect" name="txtSolutionArchitect" />
			     </td>
			 </tr>
			 
		    <tr >
			     <td  class="col1"><label for="ddWebPlatform">Web Platform</label>
			         <select id="ddWebPlatform" name="ddWebPlatform">
			             <c:forEach items="${ddAppPriority}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                              <option value='${item.key}' ${selected} >
                                  ${item.description}
                              </option>
			             </c:forEach>  
			         
			         </select>
			     </td>

			     <td class="col2"><label for="txtLeadEngineer">Lead Engineer</label>
			         <input type="text" id="txtLeadEngineer" name="txtLeadEngineer" />
			     </td>
			 </tr>
			 
		    <tr >
			     <td  class="col1"><label for="ddAppPlatform">Application Platform</label>
			         <select id="ddAppPlatform" name="ddAppPlatform">
    			         <c:forEach items="${ddAppPlatform}" var="item">
                                                 <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                                 <option value='${item.key}' ${selected} >
                                                     ${item.description}
                                                 </option>
			             </c:forEach>			         </select>
			     </td>

			     <td class="col2"><label for="txtT1Support">Tier 1 Support</label>
			         <input type="text" id="txtT1Support" name="txtT1Support" value='<%= request.getParameter("info.t1Support") %>' %> />
			     </td>
			 </tr>
			 
			 
			 <tr >
			     <td  class="col1">&nbsp;</td>
			     <td class="col2"><label for="txtT2Support">Tier 2 Support</label>
			         <input type="text" id="txtT2Support" name="txtT2Support" value='<%= request.getParameter("info.t2Support") %>' />
			     </td>	     
			 </tr>
			 

			 <tr >
			     <td  class="col1">&nbsp;</td>
			     <td class="col2"><label for="txtT3Support">Tier 3 Support</label>
			         <input type="text" id="txtT3Support" name="txtT3Support" value='<%= request.getParameter("info.t3Support") %>' />
			     </td>	     
			 </tr>


			 <!--  Data and Security -->
			 <tr>
			    <td class="sub1">Data and Security-Compliance Classifications</td>
			    <td class="sub2">Data and Security-Compliance Roles</td>			 
			 </tr>

			 
             <tr >
			     <td  class="col1"><label for="txtDataClass">Data Classification(s)</label>
			         <input type="text" id="txtDataClass" name="txtDataClass" value='<%= request.getParameter("info.dataClassification") %>' />
			     </td>

			     <td class="col2"><label for="txtDatabaseDeveloper">Database Developer</label>
			         <input type="text" id="txtDatabaseDeveloper" name="txtDatabaseDeveloper" value='<%= request.getParameter("info.databaseDeveloper") %>' />
			     </td>
			 </tr>


             <tr >
			     <td  class="col1">&nbsp;</td>

			     <td class="col2"><label for="txtDatabaseAdmin">Database Administrator</label>
			         <input type="text" id="txtDatabaseAdmin" name="txtDatabaseAdmin" value='<%= request.getParameter("info.databaseAdministrator") %>' />
			     </td>
			 </tr>


			 <!--  Network and Security -->
			 <tr>
			    <td class="sub1">Network and Security-Compliance Classifications</td>
			    <td class="sub2">Network and Security-Compliance Roles</td>			 			 
			 </tr>

             <tr >
			     <td  class="col1"><label for="ddUserLANClass">User LAN Classification</label>
			         <select id="ddUserLANClass" name="ddLANClass">
			              <c:forEach items="${ddAppPriority}" var="item">
                               <c:set var="selected" value="${item.selected} ='true' ? 'selected'" /> 
                                  <option value='${item.key}' ${selected} >
                                      ${item.description}
                                  </option>
			             </c:forEach>			         
			         </select>
			     </td>

			     <td  class="col2"><label for="txtAgencyLanEngineer">Agency LAN/WAN Engineer</label>
			         <input type="text" id="txtAgencyLanEngineer" name="txtAgencyLanEngineer" value='<%= request.getParameter("agencyLanEngineer") %>' />
			     </td>
			 </tr>

             <tr >
			     <td class="col1"><label for="ddSiteGateway">Remote Site Gateway Device</label>
			         <select id="ddSiteGateway" name="ddSiteGateway">
			              <c:forEach items="${ddRemoteGateway}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                                  <option value='${item.key}' ${selected} >
                                      ${item.description}
                                  </option>
			             </c:forEach>			         
			         </select>
			     </td>

			     <td class="col2"><label for="txtDataCenterLanEngineer">Data Center LAN Engineer</label>
			         <input type="text" id="txtDataCenterLanEngineer" name="txtDataCenterLanEngineer" value='<%= request.getParameter("dcLanEngineer") %>' />
			     </td>
			 </tr>
	
             <tr >
			     <td class="col1"><label for="txtVlanZone">Data Center VLANs/Zone</label>
			         <input type="text" id="txtVlanZone" name="txtVlanZone" value='<%= request.getParameter("dcVlanZone") %>' />
			     </td>

			     <td class="col2"><label for="txtSecOpsEngineer">SecOps (FW, etc.) Engineer</label>
			         <input type="text" id="txtSecOpsEngineer" name="txtSecOpsEngineer" value='<%= request.getParameter("secopsEngineer") %>' />
			     </td>
			 </tr>
	
		
			 <!--  Infrastructure -->
			 <tr>
			    <td class="sub1">Infrastructure Classifications</td>
			    <td class="sub2">Infrastructure Roles</td>			 			 			 
			 </tr>
			 
             <tr >
			     <td class="col1"><label for="ddServerPlatform">Server Platform</label>
			         <select id="ddServerPlatform" name="ddServerPlatform">
			             <c:forEach items="${ddServerPlatform}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                              <option value='${item.key}' ${selected} >
                                  ${item.description}
                              </option>
			             </c:forEach>  
			         </select>
			     </td>

			     <td class="col2"><label for="txtServerHostingManager">Server Hosting Manager</label>
			         <input type="text" id="txtServerHostingManager" name="txtServerHostingManager" value='<%= request.getParameter("serverHostingManager") %>' />
			     </td>
			 </tr>
	
             <tr >
			     <td class="col1"><label for="ddHypervisor">Hypervisor</label>
			         <select id="ddHypervisor" name="ddHypervisor">
			             <c:forEach items="${ddHypervisor}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                              <option value='${item.key}' ${selected} >
                                  ${item.description}
                              </option>
			             </c:forEach>  
			         </select>
			     </td>

			     <td class="col2"><label for="txtServerAdministrator">Server Administrator</label>
			         <input type="text" id="txtServerAdministrator" name="txtServerAdministrator" value='<%= request.getParameter("serverAdmin") %>' />
			     </td>
			 </tr>
	
             <tr >
			     <td class="col1"><label for="ddHostOS">Host OS</label>
			         <select id="ddHostOS" name="ddHostOS">
			             <c:forEach items="${ddHostOS}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                              <option value='${item.key}' ${selected} >
                                  ${item.description}
                              </option>
			             </c:forEach>  
			         </select>
			     </td>

			     <td class="col2"><label for="txtStorageAdministrator">Storage Administrator</label>
			         <input type="text" id="txtStorageAdministrator" name="txtStorageAdministrator" value='<%= request.getParameter("storageAdmin") %>' />
			     </td>
			 </tr>

             <tr >
			     <td class="col1"><label for="ddGuestOS">Guest OS</label>
			         <select id="ddGuestOS" name="ddHostOS">
			            <c:forEach items="${ddGuestOS}" var="item">
                              <c:set var="selected" value="${item.selected}='true' ? 'selected'" /> 
                              <option value='${item.key}' ${selected} >
                                  ${item.description}
                              </option>
			             </c:forEach>  
			         </select>
			     </td>

			     <td class="col2">&nbsp;</td>
			 </tr>

			 
			 </table>
			 
			 <input type="submit" />
		 
		 </form>
    </div>

    <div id="tabs-2">
       <p>Tab 2</p>
    </div>
    
    <div id="tabs-3">
     <p>Tab 3</p>

    </div>

    <div id="tabs-4">
     <p>Tab 4</p>

    </div>
    
    <div id="tabs-5">
     <p>Tab 5</p>

    </div>
    
    <div id="tabs-6">
     <p>Tab 6</p>

    </div>
    
    <div id="tabs-7">
     <p>Tab 7</p>

    </div>
 
    <div id="tabs-8">
     <p>Tab 8</p>

    </div>
    
     
</div>
 
</div> 
 
 
 











</form>



</body>
</html>
