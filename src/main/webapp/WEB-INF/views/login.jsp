<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<form action="login" method="post">
<tr>
<td>name </td><td><input type="text" name="name"/></td>
</tr>

<tr>
<td>password</td><td> <input type="text" name="password"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="submit"/></td>
</tr>
<tr>
<td>New User? <a href="${pageContext.request.contextPath}/register">Register</a></td>
</tr>
</form>
</table>
</body>
</html>