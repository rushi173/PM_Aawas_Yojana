<%@ page import="connection.Dbconnection" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

*{
	list-style: none;
	text-decoration: none;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Open Sans', sans-serif;
}

body{
	background: white;
}

.wrapper .sidebar{
	background: rgb(5, 68, 104);
	position: fixed;
	top: 0;
	left: 0;
	width: 225px;
	height: 100%;
	padding: 20px 0;
	transition: all 0.5s ease;
}

.wrapper .sidebar .profile{
	margin-bottom: 30px;
	text-align: center;
}

.wrapper .sidebar .profile img{
	display: block;
	width: 100px;
	height: 100px;
    border-radius: 50%;
	margin: 0 auto;
}

.wrapper .sidebar .profile h3{
	color: #ffffff;
	margin: 10px 0 5px;
}

.wrapper .sidebar .profile p{
	color: rgb(206, 240, 253);
	font-size: 14px;
}

.wrapper .sidebar ul li a{
	display: block;
	padding: 13px 30px;
	border-bottom: 1px solid #10558d;
	color: rgb(241, 237, 237);
	font-size: 16px;
	position: relative;
}

.wrapper .sidebar ul li a .icon{
	color: #dee4ec;
	width: 30px;
	display: inline-block;
}

 

.wrapper .sidebar ul li a:hover,
.wrapper .sidebar ul li a.active{
	color: #0c7db1;

	background:white;
    border-right: 2px solid rgb(5, 68, 104);
}

.wrapper .sidebar ul li a:hover .icon,
.wrapper .sidebar ul li a.active .icon{
	color: #0c7db1;
}

.wrapper .sidebar ul li a:hover:before,
.wrapper .sidebar ul li a.active:before{
	display: block;
}

.wrapper .section{
	width: calc(100% - 225px);
	margin-left: 225px;
	transition: all 0.5s ease;
}

.wrapper .section .top_navbar{
	background: rgb(7, 105, 185);
	height: 50px;
	display: flex;
	align-items: center;
	padding: 0 30px;
 
}

.wrapper .section .top_navbar .hamburger a{
	font-size: 28px;
	color: #f4fbff;
}

.wrapper .section .top_navbar .hamburger a:hover{
	color: #a2ecff;
}

 

body.active .wrapper .sidebar{
	left: -225px;
}

body.active .wrapper .section{
	margin-left: 0;
	width: 100%;
}

    </style>
</head>
<body>
   
    <div class="wrapper">
        <div class="section">
            <div class="top_navbar">
                <div class="hamburger">
                    <a href="#">
                        <i class="fas fa-bars"></i>
                    </a>
                </div>
            </div>
            <div class="container">
            
 
            
         </div>    
        </div>
        <div class="sidebar">
            <div class="profile">
                <img src="rus.jpg" alt="profile_picture">
                <h3>Rushikesh Patil</h3>
                <p>Admin</p>
            </div>
            <ul>
                
                <li>
                    <a href="">
                        <span class="icon"><i class="fas fa-user-shield"></i></span>
                        <span class="item">Add Dealers</span>
                    </a>
                </li>
                 <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-tachometer-alt"></i></span>
                        <span class="item">View Dealers</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <span class="icon"><i class="fas fa-user-friends"></i></span>
                        <span class="item">Add Aawas</span>
                    </a>
                </li>
                 <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-chart-line"></i></span>
                        <span class="item">View Aawas Report</span>
                    </a>
                </li>
               
            </ul>
        </div>
        
    </div>
  <script>
       var hamburger = document.querySelector(".hamburger");
	hamburger.addEventListener("click", function(){
		document.querySelector("body").classList.toggle("active");
	})
	
  </script>
  
 <%
 Connection con = Dbconnection.connect();
 PreparedStatement pstmt=con.prepareStatement("select * from addcomplaints");
 ResultSet rs = pstmt.executeQuery();
 %> 
 <center>
 <TABLE BORDER="3" style="border-collapse: collapse; width: 75%; margin-left: 180px;margin-top: 100px">
  <tr>
    <th style="padding: 8px; background-color: #f2f2f2;">Aawas ID</th>
    <th style="padding: 8px; background-color: #f2f2f2;">Complaints</th>
    
    <th style="padding: 8px; background-color: #f2f2f2;">Delete</th>
  </tr>

  <% while(rs.next()){ %>
  <tr>
    <td style="padding: 8px; border: 1px solid #ddd;"><%= rs.getInt(1) %></td>
    <td style="padding: 8px; border: 1px solid #ddd;"><%= rs.getString(3) %></td>
    
    <td style="padding: 8px; border: 1px solid #ddd;">
      <a class="delete-link" href="DeleteDealer.jsp?id=<%= rs.getInt(1) %>"
        style="padding: 4px 8px; background-color: #e57373; color: #fff; text-decoration: none; border-radius: 4px;">Delete</a>
    </td>
  </tr>
  <% } %>
</TABLE>

</body>

</html>