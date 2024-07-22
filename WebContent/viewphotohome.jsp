
<%@ page import="connection.Dbconnection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Blob image = null;

	Connection con = null;

	byte[ ] imgData = null ;

	Statement stmt = null;

	ResultSet rs = null;

	try {




		con =Dbconnection.connect();
		String id = request.getParameter("aawasid");
		PreparedStatement pstmt=con.prepareStatement("select photo from submitphotoshome where aawas_id=?");
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

		
		if (rs.next()) {

		image = rs.getBlob(1);


		imgData = image.getBytes(1,(int)image.length());

	} else {

			out.println("Display Blob Example");

			out.println("image not found for given id>");

					
		return;

	}


// display the image

response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);


o.flush();

o.close();

} catch (Exception e) {

out.println("Unable To Display image");



return;

} finally {

try {

rs.close();


stmt.close();

con.close();

} catch (SQLException e) {

e.printStackTrace();


}

}

%>
</body>
</html>