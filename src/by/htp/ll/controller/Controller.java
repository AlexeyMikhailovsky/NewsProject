package by.htp.ll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.controller.command.Command;
import by.htp.ll.controller.command.CommandProvider;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
		
		String name;
		Command command; 
		
		name = request.getParameter("command");
		command = provider.takeCommand(name);
		
		command.execute(request,response);
		}catch(Exception e) {
			//response.sendRedirect("Controller?command=go_to_exception_page&message=" + e.getMessage());	
			e.printStackTrace();
		}
	}

}
