<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>List All Employees</title>
<link rel="stylesheet" type="text/css" href="main.css" media="screen" />
</head>
<body>

<h1 class="standard">All Employees</h1>

  <table class="CSSTableGenerator">
     <tr>
       <td>EID</td>
       <td>Name</td>
       <td>Email</td>
       <td>Phone 1</td>
       <td>Phone 2</td>
       <td>Position Number</td>
       <td>Unit</td>
     </tr>
     
     <c:forEach items="${employee}" var="employee">
     <tr>
       <td>${employee.eid}</td>
       <td>${employee.employeeName}</td>
       <td>${employee.email}</td>
       <td>${employee.phone1}</td>
       <td>${employee.phone2}</td>
       <td>${employee.positionNum}</td>
       <td>${employee.unit}</td>
     </tr>        
    </c:forEach>
     
     
  
  
  </table>
  



</body>
</html>