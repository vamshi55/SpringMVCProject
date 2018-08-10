<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="FF0000">
<h4>Get Employee details by  Id</h4>
<br>
<br>
<c:if test="${notsuccess }">
	<div>No Employee found, try with another eid</div>
</c:if>
<br>
<br>

<form action="employeedetailsform" method="post">
	Enter Employee eid:<input type="text" name="eid">
	<input type="submit" value="Submit">
</form>
</body>
</html>