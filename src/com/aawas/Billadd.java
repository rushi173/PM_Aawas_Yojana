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
 * Servlet implementation class Billadd
 */
public class Billadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Billadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
Connection con = Dbconnection.connect();
		
		
		String billid = request.getParameter("billid");
		String aawasid = request.getParameter("aawasid");
		String pass = request.getParameter("password");
		
		try {
			int id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into billadd values(?,?,?)");
			
			pstmt.setString(1, billid);
			pstmt.setString(2, aawasid);
			pstmt.setString(3, pass);
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("Material.html");
			}
			else
			{
				response.sendRedirect("BillAdd.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
