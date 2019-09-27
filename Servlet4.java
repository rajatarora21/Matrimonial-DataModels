package edu.aptech.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try
		{
			res.setContentType("text/html");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajat");
			PreparedStatement st=con.prepareCall("insert into shaadi values(?,?,?,?,?,?,?,?,?)");
			PrintWriter pw=res.getWriter();
			HttpSession hs=req.getSession();
			String name=(String)hs.getAttribute("name");
			String age=(String)hs.getAttribute("age");
			String occu=(String)hs.getAttribute("occu");
			String reli=(String)hs.getAttribute("reli");
			String city=(String)hs.getAttribute("city");
			String stat=(String)hs.getAttribute("stat");
			String comm=(String)hs.getAttribute("comm");
			String sex=(String)hs.getAttribute("sex");
			String pass=(String)hs.getAttribute("pass");
			st.setString(1,name);
			st.setString(2,age);
			st.setString(3,occu);
			st.setString(4,reli);
			st.setString(5,city);
			st.setString(6,stat);
			st.setString(7,comm);
			st.setString(8,sex);
			st.setString(9,pass);
			int i=st.executeUpdate();
			pw.print("<meta charset=\"utf-8\">");
			pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
			pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
			
			if(i!=0)
			{
				pw.println("<div class='container-fluid' >");
				pw.println("<div class='jumbotron text-center' style='background-color:#2E86C1; color:#fff;'>");
				pw.println("<h1>Congratulations !</h1>");
				pw.println("<h2>Account Successfully Created</h2>");
				pw.println("</div");
				pw.println("</div");
			}
			else
			{
				pw.println("<div class='container-fluid ' >");
				pw.println("<div class='jumbotron text-center' style='background-color:#2E86C1; color:#fff; '>");
				pw.println("<h1>Failed !</h1>");
				pw.println("<h2>Account Not Created</h2>");
				pw.println("</div");
				pw.println("</div>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
