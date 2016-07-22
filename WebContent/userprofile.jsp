<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div>
<h1> Hello ${student.firstname} ${student.lastname}</h1>
<h2>Major: ${student.major}</h2>

</div>
<div>
<p>Your student id is ${student.studentid}</p>
<p>Your year of entry is ${student.entryyear}</p>
<p>THis is your profile page here you can see stuff</p>
</div>
</body>
</html>