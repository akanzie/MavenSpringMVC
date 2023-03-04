package com.javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaweb.constant.SystemConstant;
import com.javaweb.model.NewModel;
import com.javaweb.service.INewService;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward toi trang /WEB-INF/views/homeView.jsp
		// (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
		// đặt trong WEB-INF)
		NewModel model = new NewModel();
		model.setListResult(newService.findAll());
		model.setTotalItem(model.getListResult().size());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/new/list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
