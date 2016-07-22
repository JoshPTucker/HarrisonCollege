<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class feed</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div><div>
		<form action="ClassFeed" method="post">
			<input type="hidden" id="curruserid" name="curruserid"
				value="${user.userid}" />
			<input type="submit" name="submit" value="refresh" id="submit"/>
		</form>
	</div></div>
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
				<c:forEach var="studentclasses" items="${studentclasses}">
					<tr>
						<td><c:out value="${studentclasses.hcclass.crn}" /></td>
						<td><c:out value="${studentclasses.hcclass.hcinstructor.firstname}"/></td>
						<td><c:out value="${studentclasses.hcclass.times}" /></td>
						<td><form action="ClassProfile" method="post">
						<input type="hidden" id="classcrn" name="classcrn" value="${studentclasses.hcclass.crn}" />
						<input type="submit" id="submit" name="submit" value="details"/>
						</form></td>
						<td><form action="DropClass" method="post">
			<input type="hidden" id="curruserid" name="curruserid"
				value="${user.userid}" /> <input type="hidden" id="classcrn"
				name="classcrn" value="${studentclasses.hcclass.crn}" /> <input type="submit"
				id="submit" name="submit" value="drop" />
		</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>