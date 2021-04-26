package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.controller.command.Command;
import by.htp.ll.service.NewsService;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;

public class DeleteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try{
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			newsService.deleteNews(id);
			
 			response.sendRedirect("Controller?command=gotomainpage&message=News was deleted");
			
		}catch(NumberFormatException e) {
			throw new ServiceException("id news was wrong - not a number", e);
		}
	}

}
