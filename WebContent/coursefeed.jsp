<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Feed</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div>
		<form action="CourseFeed" method="post">
			<input type="submit" name="submit" value="refresh" id="submit"/>
		</form>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Credits</th>
					<th>Department</th>
					<th>      </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="courses" items="${courses}">
					<tr>
						<td><c:out value="${courses.coursename}" /></td>
						<td><c:out value="${courses.credits }"/></td>
						<td><c:out value="${courses.deptnumber}" /></td>
						<td><form action="CourseProfile" method="post">
						<input type="hidden" id="viewcourseid" name="viewcourseid" value="${courses.courseid}" />
						<input type="submit" id="submit" name="submit" value="view profile"/>
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>