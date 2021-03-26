package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.bean.RegistrationInfo;
import by.htp.ll.controller.command.Command;

public class SaveNewUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("name");
		//request.getParameter("surname");
		
		RegistrationInfo regInfo = new RegistrationInfo();
		//regInfo - show in console
		
		System.out.println("class SaveNewUser implements Command");
	
		request.setAttribute("message", "Registration OK");
		
		response.sendRedirect("Controller?command=gotoindexpage&message=Registration ok");
		//dododo
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		//requestDispatcher.forward(request, response);
	}

}
