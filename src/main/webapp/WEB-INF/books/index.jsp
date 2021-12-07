<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- local JS -->
	<script type="text/javascript" src="js/app.js"></script>
	<!-- Bootstrap JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Starting page</title>
</head>
<body>
	
	<div class="container">
		<h1>All Books</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th># Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
				<tr>
					<td><c:out value="${ book.id }" /></td>
					<td>
						<a href="/books/<c:out value="${ book.id }" />"><c:out value="${ book.title }" /></a>
					</td>
					<td><c:out value="${ book.language }" /></td>
					<td><c:out value="${ book.numberOfPages }" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
</body>
</html>