<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class Profile</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
	<div></div>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Course reference</th>
					<th>Instructor</th>
					<th>Times</th>
				</tr>
				
			</thead>
			<tbody>

				<tr>
					<td>${currclass.crn}</td>
					<td>${currclass.hcinstructor.firstname}</td>
					<td>${currclass.times}</td>
				</tr>
				<tr>
				<th>Building</th>
				<th>Room number</th>
				</tr>
				<tr>
					<td>Building: ${currclass.hcclassroom.buildingname}</td>
					<td>Room number: ${currclass.hcclassroom.roomnumber }</td>
				</tr>
			</tbody>
		</table>
		<form action="Enroll" method="post">
			<input type="hidden" id="curruserid" name="curruserid"
				value="${user.userid}" /> <input type="hidden" id="classcrn"
				name="classcrn" value="${currclass.crn}" /> <input type="submit"
				id="submit" name="submit" value="enroll" />
		</form>
	</div>
</body>
</html>