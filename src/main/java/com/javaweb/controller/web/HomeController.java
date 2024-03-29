package com.javaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.service.ICategoryService;

@WebServlet (urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		request.setAttribute("categories",categoryService.findAll());
	       RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/home.jsp");	  
	       dispatcher.forward(request, response);
	       
	   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       
	   }
	
}
