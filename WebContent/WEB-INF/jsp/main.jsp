<%@ page language="java" contentType="text/html; 
charset=utf-8" pageEncoding="utf-8" import="java.util.List, by.htp.ll.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">
	!!! Welcome, <c:out value="${sessionScope.name}" />!!!
</h1>

<br/>


<a href="Controller?command=logout">logout</a>
<div align="center">

		<table border="2">
			<c:forEach var="n" items="${requestScope.news}">
				<tr>
					<td><font size="16" color="black" align="center"> 
					<c:out value="${n.title}" />
							<div style="font-size: 40%">
								<c:out value="${n.brief}" />
								<br />
								<div align="right">
									<a
										href="Controller?command=gotofullnewspage&id=<c:out value="${n.id}"/>">
										<c:out value="${fullNews}" />
										ddd
									</a>

								</div>
							</div>
					</font></td>
				</tr>
			</c:forEach>
		</table>
	</div>


		
</body>
</html>