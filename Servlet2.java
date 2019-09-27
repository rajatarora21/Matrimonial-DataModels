package edu.aptech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String val1=req.getParameter("t11");
		String val2=req.getParameter("t12");
		HttpSession hs=req.getSession();
		String name=(String)hs.getAttribute("name");
		String dateOfBirth=(String)hs.getAttribute("dateOfBirth");
		String occupation=(String)hs.getAttribute("occupation");
		String religion=(String)hs.getAttribute("religion");
		String city=(String)hs.getAttribute("city");
		String gender=(String)hs.getAttribute("gender");
		pw.print("<meta charset=\"utf-8\">");
		pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		pw.print("<div class='container-fluid'>");
		pw.println("<div class='jumbotron' id='jumbo2' style='background-color:#7D3C98;color:#fff;'><h1>Your Final Details</h1></div>");
		pw.println("<table class='table table-hover'>");
		pw.println("<thead>");
		pw.println("<tr>");
		pw.println("<th>Name</th>");
		pw.println("<th>Age</th>");
		pw.println("<th>Occupation</th>");
		pw.println("<th>Religion</th>");
		pw.println("<th>Status</th>");
		pw.println("<th>City</th>");
		pw.println("<th>Sex</th>");
		pw.println("</tr>");
		pw.println("</thead>");
		pw.println("<tbody>");
		pw.println("<tr>");
		pw.println("<th>"+name+"</th>");
		pw.println("<th>"+dateOfBirth+"</th>");
		pw.println("<th>"+occupation+"</th>");
		pw.println("<th>"+religion+"</th>");
		pw.println("<th>"+city+"</th>");
		pw.println("<th>"+gender+"</th>");
		pw.println("</tr>");
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("<div class='panel panel-primary'>");
		pw.println("<div class='panel-heading'>When are you getting Married</div>");
		pw.println("<div class='panel-body'>"+val1+"</div>");
		pw.println("</div>");
		pw.println("<div class='panel panel-primary'>");
		pw.println("<div class='panel-heading'>Why are you getting married</div>");
		pw.println("<div class='panel-body'>"+val2+"</div>");
		pw.println("</div>");
		pw.println("<form action='url4' method='get'>");
		pw.println("<div class='col-md-4'>");
		pw.println("<div class='form-group'>");
		pw.println("<input type='submit' class='btn btn-info' value='Create Account' >");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</form>");
		pw.println("</div>");
	}


}
