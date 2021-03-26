package by.htp.ll.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ll.bean.Book;
import by.htp.ll.controller.command.Command;

public class GoToIndexPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> newBooks = new ArrayList<Book>();
		
		newBooks.add(new Book("Java"));
		newBooks.add(new Book("C++"));
		newBooks.add(new Book("C#"));
		
		request.setAttribute("newBooks", newBooks);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_index.jsp");
		requestDispatcher.forward(request, response);
	}

}
