package com.aawas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import connection.Dbconnection;

/**
 * Servlet implementation class Dealerlogin
 */
public class Dealerlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dealerlogin() {
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
		
		
		try
		{
			Connection con =Dbconnection .connect();
			String email =request.getParameter("email");
			String password =request.getParameter("password");
			PreparedStatement psh = (PreparedStatement) con.prepareStatement("select * from dealers where email=? and password=?");
			psh.setString(1,email);
			psh.setString(2, password);
			ResultSet rs1 = psh.executeQuery();
			if(rs1.next())
			{
				
				System.out.println("Login Successful....");
				response.sendRedirect("TP.html");
				
				
			}
			else
			{
				System.err.println("Invalid login credentials..!!");
				response.sendRedirect("dealers.html");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	

}
