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
<title>Nouvelle Vente</title>
</head>
<%@include file="./fragments/header.jsp" %>
<body >



<div class="container col-sm-8">
<h1 class="d-flex justify-content-center col-md-12">Nouvelle Vente</h1>

<form action="${pageContext.request.contextPath }/ServletNouvelleVente" method="POST" name="creation_article" class="row g-3">
	<div  class="col-md-12">
				<label for="article" >Article</label>
  				<input type="text" class="form-control shadow-sm" placeholder="Article" name="nom"   id="nom"  required>
  	</div>
	<div class="col-md-12">
	    <label for="description">Description</label>
	    <textarea class="form-control shadow-sm" id="description" rows="3" placeholder="Décrivez votre article..." name="description" maxlength="300"></textarea>
	</div>
	<div >
    <label for="categorie">Catégorie</label>
    <select class="form-control shadow-sm col-md-12" id="categorie" name="categorie" >
    
      <c:forEach var ="liste" items="${listesCategories }">
      		<option  value="${liste.getNoCategorie()}">
      		${liste.getLibelle()}
      		
      		</option>
      </c:forEach>
      
    </select>
	</div>
		<div class="col-md-12">
		    <label for="photo" class="form-label">Photo de l'article</label>
		    <input type="file" class="form-control-file shadow-sm" id="photo" name="photo">
	</div>
	<div  class="col-md-12">
		<label for="prix" class="form-label">Mise à prix</label>
  		<input type="number" class="form-control shadow-sm" placeholder="Mise à prix" name="prixInitial"   id="prix" name="prix" >
  	</div>
	<div  class="col-md-12">
		<label for="dateDebut" class="form-label">Début de l'enchère</label>
  		<input type="date" class="form-control shadow-sm"  name="dateDebut"  id="dateDebut"  >
  	</div>
  		<div  class="col-md-12">
		<label for="date_fin" class="form-label">Fin de l'enchère</label>
  		<input type="date" class="form-control shadow-sm"  id="dateFin" name="dateFin" >
  	</div>
  	
  	
  	<label>Retrait</label>
  	<span id="retrait" class="rounded border border ">
  
  		<div class="col-md-12">	
  				<label class="form-label">Rue</label>
  				<input type="text" class="form-control shadow-sm"   name="rue" placeholder="${rueDefaut }">
  		</div>
  		<div class="col-md-12">	
  				<label class="form-label">Code postal</label>
  				<input type="text" class="form-control shadow-sm"   name="cp" placeholder="${cpDefaut }">
  		</div>
  		<div class="col-md-12">	
  				<label  class="form-label">Ville</label>
  				<input type="text" class="form-control shadow-sm"   name="ville" placeholder="${villeDefaut }">
  		</div>
  		<br>
  	</div>
  	
  	<div class="d-flex justify-content-center">
			<input class="btn btn-outline-primary m-1 p-2" type="submit" value="Enregistrer"> 
			<a href="${pageContext.request.contextPath }/ServletAccueilConnecte" class="btn btn-outline-primary m-1">  Annuler  </a>
	</span>

</form>

</div>
</body>
</html>