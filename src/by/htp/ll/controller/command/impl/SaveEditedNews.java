package by.htp.ll.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.controller.command.Command;
import by.htp.ll.service.NewsService;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;

public class SaveEditedNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			String id = request.getParameter("id");
			int idNews = Integer.parseInt(id);
			String title = request.getParameter("title");
			String brief = request.getParameter("brief");
			String content = request.getParameter("content");
			
			newsService.updateNews(idNews, title, brief, content); 
			
			response.sendRedirect("Controller?command=gotofullnewspage&message=newshasbeensaved&id=" + idNews);

		}catch(NumberFormatException e) {
			throw new ServiceException("isss", e);
		}
		
	}

}
