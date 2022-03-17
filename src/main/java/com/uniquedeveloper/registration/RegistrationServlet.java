package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException{
		String fname = request.getParameter("fname");

		String lname = request.getParameter("lname");

		String dob = request.getParameter("dob");
		String cont = request.getParameter("cont");
		String jrole = request.getParameter("jrole");
		String mon_salary= request.getParameter("mon_salary");
		String yearly_bonus= request.getParameter("yearly_bonus");
		response.sendRedirect("registration.jsp");
		RequestDispatcher dispatcher= null;
		Connection con=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/employee_111915013","root","Vamosleo1022"); 
			PreparedStatement pst = con.prepareStatement("insert into basic_details_111915013(first_name,last_name,dob,cont) values(?,?,?,?) "); 
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, dob);
			pst.setString(4, cont);
			PreparedStatement pst2 = con.prepareStatement("insert into salary_details_111915013(jrole,mon_salary,yearly_bonus) values(?,?,?) "); 
			pst2.setString(1, jrole);
			pst2.setString(2, mon_salary);
			pst2.setString(3, yearly_bonus);
			int rowCount =pst.executeUpdate();
			int rowCount2 =pst2.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount>0&& rowCount2>0) {
				request.setAttribute("status", "Success");
			}
			else {
				request.setAttribute("status", "Failed");

			}
		} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}

}
