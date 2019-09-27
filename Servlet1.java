package edu.aptech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String name=req.getParameter("name");
			String password=req.getParameter("password");
			String dateOfBirth=req.getParameter("dateOfBirth");
			String occupation=req.getParameter("Occupation");
			String religion=req.getParameter("Religeon");
			String city=req.getParameter("City");
			String gender=req.getParameter("gender");
			
			HttpSession hs=req.getSession();
			hs.setAttribute("name",name);
			hs.setAttribute("dateOfBirth",dateOfBirth);
			hs.setAttribute("occupation",occupation);
			hs.setAttribute("religion",religion);
			hs.setAttribute("city",city);
			hs.setAttribute("gender",gender);
			hs.setAttribute("password",password);
			pw.print("<meta charset=\"utf-8\">");
			pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
			pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
			pw.print("<div class='container-fluid'>");
			pw.println("<div class='jumbotron' id='jumbo2' style='background-color:#34495E;color:#fff;'><h1>Your Details</h1></div>");
			pw.println("<table class='table table-hover'>");
			pw.println("<thead>");
			pw.println("<tr>");
			pw.println("<th>Name</th>");
			pw.println("<th>Age</th>");
			pw.println("<th>Occupation</th>");
			pw.println("<th>Religion</th>");
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
			pw.println("<div class='jumbotron' id='jumbo1' style='background-color:#5499C7;color:#fff;'>Some Extra Questions</div>");
			pw.println("<div id='details'>");
			pw.println("<form action='url2' method='get' >");	
			pw.println("<div class='form-group'>");
			pw.println("<label>Some details you want to share with us.</label>");
			pw.println("<input type='text' class='form-control' name='t11' placeholder='Write the details here'/>");
			pw.println("</div>");
			pw.println("<div class='form-group'>");
			pw.println("<label>Some questions or queries you have regarding our service.</label>");
			pw.println("<input type='text'class='form-control' placeholder='Write your queries here' name='t12'/>");
			pw.println("</div>");
			pw.println("<input type='submit'class='btn btn-primary' value='Submit' />");
			pw.println("</form>");
			pw.println("</div>");
			pw.println("</div>");	
		
	}
}
