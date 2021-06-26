<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Mon Profil</title>
</head>
<body>
<%@include file="./fragments/header.jsp" %>
	<div>
		<p>Pseudo : ${utilisateur.pseudo }</p>
		<p>Nom : ${utilisateur.nom }</p>
		<p>Prénom : ${utilisateur.prenom }</p>
		<p>Email : ${utilisateur.email }</p>
		<p>Téléphone : ${utilisateur.telephone }</p>
		<p>Rue : ${utilisateur.rue }</p>
		<p>Code Postal : ${utilisateur.codePostal }</p>
		<p>Ville : ${utilisateur.ville }</p>
		<p>Crédit : ${utilisateur.credit }</p>
	</div>
	<div>

		<a href="${pageContext.request.contextPath }/ServletModifProfil"><button>Modifier</button></a>






	</div>
</body>
</html>