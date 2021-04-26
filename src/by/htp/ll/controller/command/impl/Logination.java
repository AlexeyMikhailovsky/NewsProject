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

		User user = null;
		
		RequestDispatcher requestDispatcher = null;
		try {
			user = userService.authorization(login, password);
			if(user == null ) {
				response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");
				return;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			session.setAttribute("name", user.getNickname());
			session.setAttribute("role", user.getRole());
			response.sendRedirect("Controller?command=gotomainpage");
			
		}catch(ServiceException e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=wrongincatch");
		}
		
	}

}
