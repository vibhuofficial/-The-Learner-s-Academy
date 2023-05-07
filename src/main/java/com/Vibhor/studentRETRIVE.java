package com.Vibhor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studentRETRIVE
 */
public class studentRETRIVE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentRETRIVE() {
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

		studentDAO dao = new studentDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");  
        out.println("<html><body>");
		try {
			List<student> s = dao.getstudent();
			out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>ID</th><th>"
            		  + "FirstName</th><th>"
            		  + "LastName</th><th>"
            		  + "DOB</th><th>"
            		  + "Address</th><th>"
            		  + "Phone no</th><th>"
            		  + "Assigned Class</th></tr>");  
			for(student ss:s)
			{
				out.println("<tr><td>"+ss.getStudid()+
							"</td><td>"+ss.getStudfname()+
							"</td><td>"+ss.getStudlname()+
							"</td><td>"+ ss.getStuddob()+
							"</td><td>"+ ss.getStudadd()+ 
							"</td><td>"+ ss.getStudphone()+
							"</td><td>"+ ss.getStudclass()+"</td></tr>");
			}
			out.println("</table>");  
            out.println("</html></body>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
