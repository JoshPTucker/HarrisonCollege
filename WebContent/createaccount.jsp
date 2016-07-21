<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create account</title>
</head>
<body>
	<div>
		<form action="CreateAccount" method="post">
			<fieldset align="center">
				<input type="text" name="firstname" value="" id="firstname"
					placeholder="First Name"> <input type="text"
					name="lastname" value="" id="lastname" placeholder="Last Name">
				<input type="text" name="username" value="" id="username"
					placeholder="User Name">
			</fieldset>
			<fieldset align="center">
				<input type="text" name="email" value="" id="email"
					placeholder="Email Address"> <input type="password"
					name="password" value="" id="password" placeholder="Password">
			</fieldset>
			<fieldset align="center">
				<input type="submit" value="submit" id="submit" name="submit">
			</fieldset>
		</form>
	</div>
</body>
</html>