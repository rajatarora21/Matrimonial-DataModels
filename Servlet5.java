package edu.aptech.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet5 extends HttpServlet {

	Statement st; 
	Connection con;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("l1");
		String pass=req.getParameter("l2");
		pw.print("<meta charset=\"utf-8\">");
		pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajat");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			ResultSet rs=st.executeQuery("select * from shaadi where name="+"'"+name+"'"+"and pass=" +"'"+pass+"'");
			if(rs.next()) 
			{
				if((rs.getString(1).equals(name))&&(rs.getString(9).equals(pass)))
				{
					
						pw.println("<div class='jumbotron text-center' style='background-color:#21E5D0;color:#fff;'><h1> Welcome "+name+"</h1>");
						pw.println("<h2>Your Details</h2>");
						pw.println("</div>");
						pw.println("<table class='table table-hover'>");
						pw.println("<thead>");
						pw.println("<tr>");
						pw.println("<th>Name</th>");
						pw.println("<th>Age</th>");
						pw.println("<th>Occupation</th>");
						pw.println("<th>Religion</th>");
						pw.println("<th>City</th>");
						pw.println("<th>Status</th>");
						pw.println("<th>Sex</th>");
						pw.println("</tr>");
						pw.println("</thead>");
						pw.println("<tbody>");
						pw.println("<tr>");
						pw.println("<th>"+rs.getString(1)+"</th>");
						pw.println("<th>"+rs.getString(2)+"</th>");
						pw.println("<th>"+rs.getString(3)+"</th>");
						pw.println("<th>"+rs.getString(4)+"</th>");
						pw.println("<th>"+rs.getString(5)+"</th>");
						pw.println("<th>"+rs.getString(6)+"</th>");
						pw.println("<th>"+rs.getString(8)+"</th>");
						pw.println("</tr>");
						pw.println("</tbody>");
						pw.println("</table>");
						pw.println("<div class='jumbotron text-center' style='background-color:#BA82DF;color:#fff;'>");
						pw.println("<h2>Find Your Match</h2>");
						pw.println("</div>");
						pw.println("<form method='get' action='url6'>");
						pw.println("<div class='form-group'>");
						pw.println("<label>Religion</label>");
						pw.println("<input type='text' placeholder='Enter Religion' class='form-control' name='c1'>");
						pw.println("</div>");
						pw.println("<input type='submit' value='Find Your Match' class='btn btn-info'>");
						pw.println("</form>");
						HttpSession hs=req.getSession();
						hs.setAttribute("SexUser",rs.getString(8));
						
						
	
				}
				else
				{
					pw.println("<div class='jumbotron' style='background-color=#E52A21;color=#fff;'><h1>Oops! Wrong details</h1></div>");
				}
			}
			else
			{
				pw.println("<div class='jumbotron' style='background-color:#E52A21;color:#fff;'><h1>Oops! Wrong details</h1></div>");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
