package com.javaweb.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
	       // Forward toi trang /WEB-INF/views/homeView.jsp
	       // (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
	       // đặt trong WEB-INF)
	       RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/home.jsp");	  
	       dispatcher.forward(request, response);
	       
	   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       
	   }
	
}
