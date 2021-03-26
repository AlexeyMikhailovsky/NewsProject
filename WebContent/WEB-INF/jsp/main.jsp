<%@ page language="java" contentType="text/html; 
charset=utf-8" import="by.htp.ll.bean.User"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<%
	User userX = (User) request.getAttribute("user");
			if (userX == null){
		userX = new User();
			}
			out.println(userX.getName());
	%>
	<br />
	<%
	out.println(request.getParameter("login"));
	%>
	
	<jsp:useBean id="user" class="by.htp.ll.bean.User" scope="request" />
	
	<jsp:getProperty property="name" name="user"/>

</body>
</html>