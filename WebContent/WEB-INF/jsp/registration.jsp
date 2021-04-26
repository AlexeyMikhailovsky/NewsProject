<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="savenewuser" />
		Enter login:<br />
		<input type="text" name="login" value="" /><br />
		Enter password:<br />
		<input type="password" name="password" value="" /><br />
		Enter email:<br />
		<input type="text" name="email" value="" /><br />
		Enter nickname:<br />
		<input type="text" name="nickname" value="" /><br /> 	
		
		<input type="submit" value="Отправить" /><br />
	</form>
</body>
</html>