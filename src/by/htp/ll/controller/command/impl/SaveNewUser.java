package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.bean.User;
import by.htp.ll.controller.command.Command;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;
import by.htp.ll.service.UserService;

public class SaveNewUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String nickname = request.getParameter("nickname");

			User userInfo = new User();
			userInfo.setLogin(login);
			userInfo.setPassword(password);
			userInfo.setEmail(email);
			userInfo.setNickname(nickname);

			System.out.println(userInfo.toString());

			ServiceProvider provider = ServiceProvider.getInstance();
			UserService userService = provider.getUserService();

			userService.registration(userInfo);

			response.sendRedirect("Controller?command=gotoindexpage&message=Registration completed successfully");
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=gotoregistration&message=" + e.getMessage());		
		}
	}

}
