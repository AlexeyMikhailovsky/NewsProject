package by.htp.ll.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.ll.bean.News;
import by.htp.ll.controller.command.Command;
import by.htp.ll.service.NewsService;
import by.htp.ll.service.ServiceException;
import by.htp.ll.service.ServiceProvider;

public class GoToMainPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		if(session == null) {
			response.sendRedirect("Controller?command=gotoindexpage&message=nosession");
			return;
		}
		
		Boolean isAuth = (Boolean) session.getAttribute("auth");
		
		if(isAuth == null || !isAuth) {
			response.sendRedirect("Controller?command=gotoindexpage&message=notauth");
			return;
		}

		try {
			List<News> news = newsService.takeAll();
			
			request.setAttribute("news", news);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		}catch (ServiceException e){
			// TODO go to global error page
					e.printStackTrace();
		}
		
		
	}
}
