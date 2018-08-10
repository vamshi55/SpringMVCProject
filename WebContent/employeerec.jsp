<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="7B6969">
<h4>Employee Record</h4>
<br>
<br>
    <c:out value="Employee Details:"></c:out>
<div>Employee Name	:	${name}</div>
<div>Employee age	:	${age}</div>
<div>Employee salary	:	${salary}</div>
<div>Employee Designation	:	${designation}</div>
</body>

</body>
</html>