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

public class GoToFullNewsPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		try {
			String id = request.getParameter("id");
			int idNews = Integer.parseInt(id);
			News oneNews = newsService.takeOne(idNews);
			if (oneNews == null) {
				System.out.println("News Id=" + idNews + " cannot be loaded. Error Somewhere...");
			}
			request.setAttribute("oneNews", oneNews);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/one_news_page.jsp");
			requestDispatcher.forward(request, response);
			
		}catch(NumberFormatException e) {
			throw new ServiceException("gggg", e);
		}
		
	}

}
