<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="FFA500">
<h1 style="text-align:center;">Registration</h1>
<hr size=4 color="red"><br><br>
<c:if test="${notsuccess}">
<div style="color:red;"> Registration failed, please try again </div>
</c:if>

<form action="register" method="post"><br>
	 Employee eid: <input type="text" name="eid" ><br>
	 Employee name: <input type="text" name="name"><br>
	Employee age: <input type="text" name="age"><br>
	Employee salary: <input type="text" name="salary"><br>
	Employee designation: <input type="text" name="designation"><br>
	<input type="submit" value="Registar">
</form>

</body>
</html>