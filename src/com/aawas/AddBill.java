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
 * Servlet implementation class AddBill
 */
public class AddBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBill() {
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
		
        String aawas_id = request.getParameter("aawasid");
        String aawas_contact = request.getParameter("aawascontact");
        String item1 = request.getParameter("item1");
        int quantity1 = Integer.parseInt(request.getParameter("quantity1"));
        int cost1 = Integer.parseInt(request.getParameter("cost1"));
		String item2 = request.getParameter("item2");
		int quantity2 = Integer.parseInt(request.getParameter("quantity2"));
        int cost2 = Integer.parseInt(request.getParameter("cost2"));
        String item3 = request.getParameter("item3");
		int quantity3 = Integer.parseInt(request.getParameter("quantity3"));
        int cost3 = Integer.parseInt(request.getParameter("cost3"));
        String item4 = request.getParameter("item4");
		int quantity4 = Integer.parseInt(request.getParameter("quantity4"));
		System.out.println(quantity4);
        int cost4 = Integer.parseInt(request.getParameter("cost4"));
        
       
		int total=((cost1*quantity1)+(cost2*quantity2)+(cost3*quantity3)+(cost4*quantity4));
		
		try {
			int bill_id = 0;
			
			PreparedStatement pstmt;
			pstmt = con.prepareStatement("insert into add_bill values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, bill_id  );
			pstmt.setString(2, aawas_id  );
			pstmt.setString(3, aawas_contact );
			pstmt.setString(4, item1);
			pstmt.setInt(5, quantity1 );
			pstmt.setInt(6,cost1);
			pstmt.setString(7, item2);
			pstmt.setInt(8, quantity2 );
			pstmt.setInt(9,cost2);
			pstmt.setString(10, item3);
			pstmt.setInt(11, quantity3 );
			pstmt.setInt(12,cost3);
			pstmt.setString(13, item4);
			pstmt.setInt(14, quantity4 );
			pstmt.setInt(15,cost4);
			pstmt.setInt(16, total);
			
			
		
			
			int i = pstmt.executeUpdate();
			if(i > 0)
			{
				
				response.sendRedirect("ThankYou.html");
			}
			else
			{
				response.sendRedirect("AddBill.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
