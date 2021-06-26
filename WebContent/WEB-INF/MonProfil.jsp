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
	
	<div class="container col-sm-4">
	
	<ul class="list-group">
		  <li class="list-group-item">Nom : ${utilisateur.nom }</li>
		  <li class="list-group-item">Pseudo : ${utilisateur.pseudo }</li>
		  <li class="list-group-item">Prénom : ${utilisateur.prenom }</li>
		  <li class="list-group-item">Email : ${utilisateur.email }</li>
		  <li class="list-group-item">Téléphone : ${utilisateur.telephone }</li>
		  <li class="list-group-item">Rue : ${utilisateur.rue }</li>
		  <li class="list-group-item">Code Postal : ${utilisateur.codePostal }</li>
		  <li class="list-group-item">Ville : ${utilisateur.ville }</li>
		  <li class="list-group-item">Crédit : ${utilisateur.credit }</li>
	</ul>

<div class="d-flex justify-content-center">
		<a href="${pageContext.request.contextPath }/ServletModifProfil" class="btn btn-primary" value="Modifier">Modifier</a>
</div>





	</div>
</body>
</html>