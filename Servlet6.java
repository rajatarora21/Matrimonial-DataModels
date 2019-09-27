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

public class Servlet6 extends HttpServlet {

	Connection con;
	Statement st;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.print("<meta charset=\"utf-8\">");
		pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		pw.println("<div class='jumbotron' style='background-color:#717CCE;color:#fff;'>");
		pw.println("<h1>Your Match</h1>");
		pw.println("</div>");
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
		HttpSession hs=req.getSession();
		String sex=(String)hs.getAttribute("SexUser");
		String religion=req.getParameter("c1");
		if(sex.equalsIgnoreCase("Male"))
		{
			try
			{
				ResultSet rs=st.executeQuery("select * from shaadi where reli="+"'"+religion+"'"+"and sex='Female'");
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
				int count=0;
				while(rs.next())
				{
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
					count=count+1;
				}
				if(count==0)
				{
					pw.println("<h2 style='color:red'>No Match Found</h2>");
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		else
		{
			try
			{
				ResultSet rs=st.executeQuery("select * from shaadi where reli="+"'"+religion+"'"+"and sex=Male");
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
				int count=0;
				while(rs.next())
				{
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
					count=count+1;
				}
				if(count==0)
				{
					pw.println("<h2 style='color:red'>No Match Found</h2>");
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
			
	}
}
