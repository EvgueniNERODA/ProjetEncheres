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
<title>Nouvelle Vente</title>
</head>
<body class="p-3 mb-2 bg-light text-dark">

<h1>Nouvelle Vente</h1>

<form action="${pageContext.request.contextPath }/ServletAccueilConnecte" method="POST" name="creation_article" class="row g-3">
	<div  class="form-group">
				<label for="article" class="form-label">Article</label>
  				<input type="text" class="form-control shadow-sm" placeholder="Article" name="nom"   id="nom"  required>
  	</div>
	<div class="form-group">
	    <label for="description">Description</label>
	    <textarea class="form-control shadow-sm" id="description" rows="3" placeholder="Décrivez votre article..." name="description" maxlength="300"></textarea>
	</div>
	<div class="form-group">
    <label for="categorie">Catégorie</label>
    <select class="form-control" id="categorie" >
    
      <c:forEach var ="liste" items="${listesCategories }">
      		<option name="categorie">
      		${liste.libelle }
      		
      		</option>
      </c:forEach>
      
    </select>
	</div>
		<div class="form-group">
		    <label for="photo">Photo de l'article</label>
		    <input type="file" class="form-control-file shadow-sm" id="photo" name="photo">
	</div>
	<div  class="form-group">
		<label for="prix" class="form-label">Mise à prix</label>
  		<input type="number" class="form-control shadow-sm" placeholder="Mise à prix" name="prixInitial"   id="prix" name="prix" >
  	</div>
	<div  class="form-group">
		<label for="dateDebut" class="form-label">Début de l'enchère</label>
  		<input type="date" class="form-control shadow-sm"  name="dateDebut"  id="dateDebut"  >
  	</div>
  		<div  class="form-group">
		<label for="date_fin" class="form-label">Fin de l'enchère</label>
  		<input type="date" class="form-control shadow-sm"  id="dateFin" name="dateFin" >
  	</div>
  	
  	<div id="retrait">
  		<div class="form-group">	
  				<label for="rue" class="form-label">Rue</label>
  				<input type="text" class="form-control shadow-sm" placeholder="Rue" id= "rue"name="rue" value="${rueDefaut }">
  		</div>
  		<div class="form-group">	
  				<label for="code_postal" class="form-label">Code postal</label>
  				<input type="text" class="form-control shadow-sm" placeholder="Code postal" id= "code_postal"name="cp" value="${cpDefaut }">
  		</div>
  		<div class="form-group">	
  				<label for="ville" class="form-label">Ville</label>
  				<input type="text" class="form-control shadow-sm" placeholder="Ville" id= "ville" name="ville" value="${villeDefaut }">
  		</div>
  	</div>
  	
  	<div class="d-flex justify-content-center">
			<input class="btn btn-outline-primary m-1 p-2" type="submit" value="Enregistrer"> 
			<a href="${pageContext.request.contextPath }/ServletAccueilConnecte" class="btn btn-outline-primary m-1">  Annuler  </a>
	</div>

</form>


</body>
</html>