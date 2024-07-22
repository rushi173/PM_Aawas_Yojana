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
 * Servlet implementation class DealersInfo
 */
public class DealersInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealersInfo() {
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
		
		
		String dname = request.getParameter("name");
		
		String demail = request.getParameter("email");
		
		int dpassword = Integer.parseInt(request.getParameter("password"));
		
		String dshop_name = request.getParameter("shopname");
		
		int dcontact = Integer.parseInt(request.getParameter("phonenumber"));
		
		String dregion = request.getParameter("region");
		
		String dcity = request.getParameter("city");
		
		String dstate = request.getParameter("state");
		
		
		try {
			int id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into dealers values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, id  );
			pstmt.setString(2, dname);
			pstmt.setString(3, demail);
			pstmt.setInt(4,dpassword );
			pstmt.setString(5,dshop_name );
			pstmt.setInt(6, dcontact);
			pstmt.setString(7, dregion);
			pstmt.setString(8, dcity);
			pstmt.setString(9, dstate);
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
			}
			else
			{
				response.sendRedirect("AddDealers.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
