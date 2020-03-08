package com.javaEE.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaEE.bean.Baby;
import com.javaEE.dao.BabyDao;
@WebServlet("/ViewBabyName")
public class ViewBabyName extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Baby</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewBabyNameByRegion?region=Ile De France' class='btn btn-primary' role='button'>Ile De France</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=grand Est' class='btn btn-primary' role='button'>Iregion=grand Est</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Normandie' class='btn btn-primary' role='button'>Normandie</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Centre Val de loire' class='btn btn-primary' role='button'>Centre Val de loire</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Bourgogne -Comte' class='btn btn-primary' role='button'>Bourgogne -Comte</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Pays de la Loire' class='btn btn-primary' role='button'>Pays de la Loire</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Bretagne' class='btn btn-primary' role='button'>Bretagne</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region=Hauts De France' class='btn btn-primary' role='button'>Hauts De France</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region='Nouvelle Aquitaine' class='btn btn-primary' role='button'>Nouvelle Aquitaine</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region='Occitanie' class='btn btn-primary' role='button'>Occitanie</a> ");
		out.print(" <a href='ViewBabyNameByRegion?region='Provence Alpes' class='btn btn-primary' role='button'>Provence Alpes</a> ");
		
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("adminlogin")==null){
			
		}else{
			out.print(" <a href='AddBabyNameForm' class='btn btn-primary' role='button'>Add Baby Name</a> ");
			out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
		}
		
		request.getRequestDispatcher("atoz.html").include(request, response);
		
		out.println("<h1>View Baby Names</h1>");
		List<Baby> list=BabyDao.getAllRecords();
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Prenom</th><th>Sex</th><th>Region</th><th>Delete</th></tr>");
		for(Baby b:list){
			out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getPrenom()+"</td><td>"+b.getSex()+"</td><td>"+b.getRegion()+"</td>");
			
			if(session==null||session.getAttribute("adminlogin")==null){
				out.println("<td>Delete</td>");
				
			}else{
			out.println("<td><a href='DeleteBabyName?id="+b.getId()+"'>Delete</a></td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
