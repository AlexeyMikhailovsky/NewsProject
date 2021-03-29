package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ll.bean.User;
import by.htp.ll.controller.command.Command;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;
import by.htp.ll.service.UserService;

public class Logination implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UserLoginationInfo...
		
		String login;
		String password;
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		//error-redirect norm-forward
		User user = null;
		RequestDispatcher requestDispatcher = null;
		try {
			user = userService.authorization(login, password);
			if(user == null ) {
				request.setAttribute("message", "wrong2");
				requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_index.jsp");
			}else {
				HttpSession session = request.getSession(true);
				session.setAttribute("auth", true);
				response.sendRedirect("Controller?command=gotomainpage");
			}
		}catch(ServiceException e) {
			request.setAttribute("message", "wrong");
			requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_index.jsp");
		}
		
		//requestDispatcher.forward(request, response);
	}

}
