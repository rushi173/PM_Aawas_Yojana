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
 * Servlet implementation class Material
 */
public class Material extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Material() {
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
		
		int total=0;
		String material = request.getParameter("material");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		
		
		try {
			int id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into materialbill values(?,?,?)");
			
			pstmt.setString(1, material);
			pstmt.setInt(2, quantity);
			pstmt.setInt(3, cost);
			
			int i = pstmt.executeUpdate();
			while(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
				int a= quantity;
				int c= cost;
				int b=a*c;
				total=total+b;
			}
			
			{
				response.sendRedirect("Material.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
