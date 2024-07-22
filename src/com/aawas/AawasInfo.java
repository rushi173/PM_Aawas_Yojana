package com.aawas;

import java.io.IOException;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import connection.Dbconnection;

/**
 * Servlet implementation class AawasInfo
 */
@MultipartConfig(maxFileSize=16177215)
public class AawasInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AawasInfo() {
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
		
        
		String aname = request.getParameter("name");
		
		String aemail = request.getParameter("email");
		
		int acontact = Integer.parseInt(request.getParameter("phonenumber"));
		
		int apassword = Integer.parseInt(request.getParameter("password"));
		
		String acity = request.getParameter("city");
		
		String alocation = request.getParameter("location");
		
		String aregion = request.getParameter("region");
		
		String astate = request.getParameter("state");
		
		
		
		InputStream inputStream = null; 
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			inputStream = filePart.getInputStream();
		}
		
		try {
			int a_id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into aawas values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, a_id  );
			pstmt.setString(2, aname);
			pstmt.setString(3, aemail);
			pstmt.setInt(4,acontact );
			pstmt.setInt(5,apassword );
			pstmt.setString(6, acity);
			pstmt.setString(7, alocation);
			pstmt.setString(8, aregion);
			pstmt.setString(9, astate);
			
			if(inputStream != null){
				
				pstmt.setBinaryStream(10, inputStream,inputStream.available());
				
			}
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
			}
			else
			{
				response.sendRedirect("AddAawas.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
