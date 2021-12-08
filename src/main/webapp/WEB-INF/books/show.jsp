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
			<h1><c:out value="${ book.title }" /></h1>
			<p>Description: <c:out value="${ book.description }" /></p>
			<p>Language: <c:out value="${ book.language }" /></p>
			<p>Number of pages: <c:out value="${ book.numberOfPages }" /></p>
	</div>
	
</body>
</html>