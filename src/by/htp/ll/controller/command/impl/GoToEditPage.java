package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.bean.News;
import by.htp.ll.controller.command.Command;
import by.htp.ll.service.NewsService;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;

public class GoToEditPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			String id = request.getParameter("id");
			int idNews = Integer.parseInt(id);
			News singleNews = newsService.takeOne(idNews);
			if (singleNews == null) {
				System.out.println("ERROR! Single News with Id=" + idNews + " was not loaded from DB");
			}
			request.setAttribute("singleNews", singleNews);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_page.jsp");
			requestDispatcher.forward(request, response);
			
		}catch(NumberFormatException e) {
			throw new ServiceException("id news was wrong - not a number", e);
		}
		
	}

}
