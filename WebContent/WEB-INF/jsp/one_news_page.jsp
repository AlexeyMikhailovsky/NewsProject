<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="n" value='${requestScope["oneNews"]}' />
		<font size="16" color="black" align="center"> 
		<c:out value="${n.title}" />
				
		</font>
		<td>
						<form action="Controller" method="get">
      					<input type="hidden" name="command" value="gotomainpage" />
						<button><c:out value="${backToMainPage}" /></button>
						</form>
					</td>
					
					<c:if test="${sessionScope.role eq \"admin\"}">
						<td>
							<form action="Controller" method="get">
      						<input type="hidden" name="command" value="gotoeditpage" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><c:out value="${edit}" />edit</button>
							</form>
						</td>
						<td>
							<form action="Controller" method="get">
      						<input type="hidden" name="command" value="deletenews" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><c:out value="${delete}" />del</button>
							</form>
						</td>
					</c:if>
</body>
</html>