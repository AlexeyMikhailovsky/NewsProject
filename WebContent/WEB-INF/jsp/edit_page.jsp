<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
      <div align="center">			
     	 <font  color="green" >
      
     	 <%
 				out.write(message);     
      		}
     	 %>
      	</font>
      	<div align="center" style="position: absolute; left: 150px; right: 150px;">
		
					<form action="Controller" method="post">
						<input type="hidden" name="command" value="saveeditednews" />
						<c:set var="n" value='${requestScope["oneNews"]}' />
						<input type="hidden" name="id" value="${param['id']}" />
						<textarea name="title" rows="3" cols="100"><c:out value="${n.title}"/></textarea>
  						
						<br />

						<textarea name="brief" rows="6" cols="100"><c:out value="${n.brief}" /></textarea>

						<br />

						<textarea name="content" rows="18" cols="100"><c:out value="${n.content}" /></textarea>
 						
						<br /> 
						
						<input type="submit" value="${save}" />
					</form>
		
					<form action="Controller" method="get">
						<input type="hidden" name="command" value="gotofullnewspage" />
						<input type="hidden" name="id" value="${param['id']}" />
						<input type="submit" value="${cancel}" />
					</form> 
					<br />
	</div>
</body>
</html>