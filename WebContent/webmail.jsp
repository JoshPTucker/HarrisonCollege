<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Email</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div>
<form action="Webmail" method="post">
<fieldset>
<input type="text" id="subject" value ="" name = "subject" placeholder="subject" />
<input type="text" id="to" value=""  name="to" placeholder="to"/>
<input type="text" id="from" value="${user.email }" name = "from" placeholder="${user.email }"/>
<textarea rows="4" cols="65" id ="body" name="body"></textarea>
</fieldset>
<fieldset>
<input type="submit" id="submit" name="submit" value="send"/>
</fieldset>
</form>
</div>
</body>
</html>