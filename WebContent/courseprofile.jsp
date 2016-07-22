<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Profile</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div>
<h1>${currcourse.coursename}</h1>
<h2>${currcourse.coursedescription}</h2>
<table class="table table-bordered table-striped table-hover">
<thead>
				<tr>
					<th>Credits</th>
					<th>Department number</th>
					<th>Subject Code</th>
				</tr>
			</thead>
<tbody>
<tr>
<td>${currcourse.credits}</td>
<td>${currcourse.deptnumber}</td>
<td>${currcourse.subjectcode}</td>
</tr>
</tbody>
</table>
</div>
<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Course reference</th>
					<th>Instructor</th>
					<th>Times</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="classes" items="${classes}">
					<tr>
						<td><c:out value="${classes.crn}" /></td>
						<td><c:out value="${classes.hcinstructor.firstname}"/></td>
						<td><c:out value="${classes.times}" /></td>
						<td><form action="ClassProfile" method="post">
						<input type="hidden" id="classcrn" name="classcrn" value="${classes.crn}" />
						<input type="submit" id="submit" name="submit" value="details"/>
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>