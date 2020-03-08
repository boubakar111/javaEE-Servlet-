package com.javaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaEE.bean.Baby;
import com.javaEE.dao.BabyDao;
@WebServlet("/AddBabyName")
public class AddBabyName extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Baby</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewBabyName' class='btn btn-primary' role='button'>View Baby Names</a> ");
		out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
		
		String name=request.getParameter("name");
		String prenom=request.getParameter("prenom");
		String sex=request.getParameter("sex");
		String region=request.getParameter("region");
		
		Baby b=new Baby();
		b.setName(name);
		b.setPrenom(prenom);
		b.setSex(sex);
		b.setRegion(region);
		
		int status=BabyDao.save(b);
		if(status>0){
			
			out.print("<h3>Baby added successfully</h3>");
			request.getRequestDispatcher("addbabynameform.html").include(request, response);
			
		}else{
			out.print("Unable to add baby!");
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		
		out.close();
	}

}
