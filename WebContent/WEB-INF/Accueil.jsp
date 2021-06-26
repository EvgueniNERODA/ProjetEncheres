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
<title>Accueil</title>
</head>
<body>
<%@include file="./fragments/header.jsp" %>
	<h1 class="d-flex justify-content-center">Liste des enchères</h1>


<div class="container">
<h3>Filtres</h3>
  <form class="form-inline col-sm-3">
    <input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search">
  
    
    
    <div >
    
    <label for="categorie">Catégorie</label>
    <select class="form-control shadow-sm col-md-12" id="categorie" >
    
      <c:forEach var ="liste" items="${listesCategories }">
      		<option name="categorie" value="${liste.noCategorie }">
      		${liste.libelle }
      		
      		</option>
      </c:forEach>
      
    </select>
	</div>
	  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
  </form>
  

<div class="row row-cols-1 row-cols-md-2 g-4">
  <div class="col">
    <div class="card">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Article...</h5>
        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="..." class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">Article...</h5>
        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
      </div>
    </div>
  </div>
  
</div>



	



	<c:if test="${existeEnBdd == false}">
    	Le compte a bien été supprimé
	</c:if>

</body>
</html>