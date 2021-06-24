<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Connecté</title>
</head>

<%@include file="./fragments/header.jsp"%>

<body>
	<h1>Accueil Connecté</h1>

	<a href="${pageContext.request.contextPath }/ServletDeconnexion">Deconnection</a>
	<a href="${pageContext.request.contextPath }//ServletMonProfil">Mon
		Profil</a>
</body>
</html>