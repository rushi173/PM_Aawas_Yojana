package com.aawas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Dbconnection;

/**
 * Servlet implementation class AddComplaints
 */
public class AddComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaints() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
Connection con = Dbconnection.connect();
		
		
		
		String aawasid = request.getParameter("aawasid");
		String pass = request.getParameter("pass");
		String complaints = request.getParameter("complaints");
		
		try {
			int id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into addcomplaints values(?,?,?)");
			
			
			pstmt.setString(1, aawasid);
			pstmt.setString(2, pass);
			pstmt.setString(3, complaints);
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
			}
			else
			{
				response.sendRedirect("addcomplaints.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
