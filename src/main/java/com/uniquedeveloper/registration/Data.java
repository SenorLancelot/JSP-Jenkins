package com.uniquedeveloper.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Data
 */
@WebServlet("/data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lname = request.getParameter("lastname");
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/register","root","Vamosleo1022"); 
			PreparedStatement pst = con.prepareStatement("select * from users where lname=?");
			
			pst.setString(1, lname);
			ResultSet rs=pst.executeQuery();
			List<String> book=new ArrayList<String>();
			while(rs.next()){
				book.add(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(7));
				session.setAttribute("book",book);
				dispatcher=request.getRequestDispatcher("output.jsp");
			}		
			dispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}