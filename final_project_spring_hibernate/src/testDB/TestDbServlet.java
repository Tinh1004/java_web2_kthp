package testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// set up connection variables in Servlet (before in Java file)
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/final_web?useSSL=false";
		String user="root";
		String pass="1004";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			PrintWriter out = response.getWriter();
			out.println("Connect to DB");
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Success");
			myConn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("err: "+e);
			e.printStackTrace();
			throw new ServletException();
		}
		
		
		
		
		
	}

}
