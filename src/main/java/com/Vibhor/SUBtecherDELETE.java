package com.Vibhor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SUBtecherDELETE
 */
public class SUBtecherDELETE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUBtecherDELETE() {
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
		
		String techid = request.getParameter("techid");
		//System.out.println(studid +" "+ studfname +" " +studlname+" "+ studdob +" "+ studadd +" "+ studphone);
		
		PrintWriter out = response.getWriter();
		Statement st;
		try {
			Connection con = DB_CONNECTION.getConn();
			st = con.createStatement();
			//String sql =  "delete * from sub_tech where techid='"+ techid +"' ";  
			
			int result = st.executeUpdate("delete * from sub_tech where techid='"+ techid +"' ");
			out.print(result+"DATA DELETED");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.print("CHECK THE CONNECTION " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

