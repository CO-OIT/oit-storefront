<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Application Info Category</title>
</head>
<body>
  
  <p><c:out value="${message}"></c:out></p>

<form action="/updateAppInfoCategory" method="POST" >

  <label for="txtKey">Key</label>
  <input type="text" name="txtKey" id="txtKey" value='<%= request.getParameter("key") %>' />

  <label for="txtKey">Short Description</label>
  <input type="text" name="txtShortDescription" id="txtShortDescription" value='<%= request.getParameter("shortDescription")   %>' />

  <label for="txtLongDescription">Long Description</label>
  <input type="text" name="txtLongDescription" id="txtLongDescription" value='<%= request.getParameter("longDescription")  %>' />

  <label for="cbActive">Active</label>
  <input type="checkbox" name="cbActive" id="cbActive" />
  
  <input type="submit" id="submitMain" />

</form>

</body>
</html>