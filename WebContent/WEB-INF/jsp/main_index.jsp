<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List, by.htp.ll.bean.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
		String message = (String)request.getParameter("message");
	
		if(message != null){
		
	%>
	<font color="red">
	<%
		out.write(message);
		}
	%>
		</font>
	<br />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="logination" />
		Enter login:<br />
		<input type="text" name="login" value="" /><br />
		Enter password:<br />
		<input type="password" name="password" value="" /><br />
		
		<input type="submit" value="Отправить" /><br />
	</form>
	
	<br />
	
	<a href="Controller?command=registration">Registration</a>
	
	<%
		List<Book> books = (List<Book>)request.getAttribute("newBooks");
		for(int i=0;i<books.size();i++){
			out.write(books.get(i).getTitle());
		}
	%>
	
</body>
</html>