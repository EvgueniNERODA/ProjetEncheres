<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.messages.LecteurMessage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Page Encherir</title>
</head>
<body>
<%@include file="./fragments/headerConnecte.jsp" %>
	
	
	
	<div class="container col-md-4 bg-light text-dark">
	
	<ul class="list-group">
		  <li class="list-group-item">Nom : ${listeDeLarticle[0].nomArticle}</li>
		  <li class="list-group-item">Description : ${listeDeLarticle[0].description}</li>
		  <li class="list-group-item">Catégorie : ${listeDeLarticle[0].categorie.libelle }</li>
		  <li class="list-group-item">Meilleure offre : </li>
		  <li class="list-group-item">Mise à prix : ${listeDeLarticle[0].miseAPrix }</li>
		  <li class="list-group-item">Fin de l'enchère: ${listeDeLarticle[0].dateFinEncheres }</li>
		  <li class="list-group-item">Retrait : ${listeDeLarticle[0].retrait.rue } ${listeDeLarticle[0].retrait.code_Postal  } ${listeDeLarticle[0].retrait.ville  }</li>
		  <li class="list-group-item">Vendeur : ${listeDeLarticle[0].utilisateur.pseudo }</li>
	</ul>
	
	<form action="${pageContext.request.contextPath }/ServletPageEncherir" method="post">
		  <div class="card-body">
		  <p class="card-text">Ma proposition : <input type="number" name="montantPropose" min="10" max="5000"></p>
		  <input type="submit" value="Encherir">
		  </div>
	</form>
		  
	</div>

	



	
</body>
</html>