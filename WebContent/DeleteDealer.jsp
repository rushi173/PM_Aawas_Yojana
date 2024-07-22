<%@page import="connection.Dbconnection" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PM Aawas Yojana</title>
</head>
<body>
<%
String id = request.getParameter("id");
try{
	
	Connection con =Dbconnection.connect();
	Statement stmt=con.createStatement();
	int i=stmt.executeUpdate("delete from dealers where id="+id);
	if(i>0){
		response.sendRedirect("ViewDealers.jsp");
	}
}catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>