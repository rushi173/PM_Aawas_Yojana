package com.aawas;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connection.Dbconnection;

/**
 * Servlet implementation class SubmitphotoH
 */
@MultipartConfig(maxFileSize=16177215)
public class SubmitphotoH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitphotoH() {
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
		

		InputStream inputStream = null; 
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			inputStream = filePart.getInputStream();
		}
		
		try {
			
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into submitphotoshome values(?,?,?)");
			pstmt.setString(1, aawasid );
			pstmt.setString(2, pass );
			
                 if(inputStream != null){
				
				pstmt.setBinaryStream(3, inputStream,inputStream.available());
				
			}
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
			}
			else
			{
				response.sendRedirect("submitphotoH.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
