package com.Vibhor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class subtechUPDATE
 */
public class subtechUPDATE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subtechUPDATE() {
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
		String ssubject = request.getParameter("ssubject");
		String assigntech = request.getParameter("assigntech");
		//System.out.println(studid +" "+ studfname +" " +studlname+" "+ studdob +" "+ studadd +" "+ studphone);
		PrintWriter out = response.getWriter();
		
		try {
			Connection con = DB_CONNECTION.getConn();
			String sql = "update sub_tech set ssubject=?, assigntech=?where techid=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ssubject);
			ps.setString(2, assigntech);
			ps.setString(3, techid);
			
			int row = ps.executeUpdate();
			if(row>0)
			{
				//out.print("UPDATED ");
				response.sendRedirect("studeSUCCESS.html");
			}else
			{
				//out.print("NOT UPDATED");
				response.sendRedirect("studFAIL.html");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.print("CHECK THE CONNECTION " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}