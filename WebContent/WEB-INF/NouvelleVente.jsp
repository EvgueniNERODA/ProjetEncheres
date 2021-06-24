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
<body>
<h1>Nouvelle Vente</h1>

<form action="${pageContext.request.contextPath }/ServletAccueilConnecte" method="POST" name="inscription" class="row g-3">
	<div  class="form-group">
				<label for="article" class="form-label">Article</label>
  				<input type="text" class="form-control" placeholder="article" name="pseudo"   id="pseudo" name="article" required>
  	</div>
	<div class="form-group">
	    <label for="description">Description</label>
	    <textarea class="form-control" id="description" rows="3" name="description" maxlength="300"></textarea>
	</div>
	<div class="form-group">
    <label for="categorie">Catégorie</label>
    <select class="form-control" id="categorie">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
	</div>
		<div class="form-group">
		    <label for="photo">Photo de l'article</label>
		    <input type="file" class="form-control-file" id="photo" name="photo">
	</div>
	<div  class="form-group">
		<label for="prix" class="form-label">Mise à prix</label>
  		<input type="number" class="form-control" placeholder="Pseudo" name="pseudo"   id="prix" name="prix" >
  	</div>
	<div  class="form-group">
		<label for="date_debut" class="form-label">Début de l'enchère</label>
  		<input type="date" class="form-control" placeholder="Pseudo" name="pseudo"  id="prix" name="date_debut" >
  	</div>
  		<div  class="form-group">
		<label for="date_fin" class="form-label">Fin de l'enchère</label>
  		<input type="date" class="form-control" placeholder="Pseudo" name="pseudo"  id="prix" name="date_fin" >
  	</div>
  	
  	<div id="retrait">
  		<div class="form-group">	
  				<label for="rue" class="form-label">Rue</label>
  				<input type="text" class="form-control" placeholder="Rue" id= "rue"name="rue" >
  		</div>
  		<div class="form-group">	
  				<label for="code_postal" class="form-label">Code postal</label>
  				<input type="text" class="form-control" placeholder="Rue" id= "code_postal"name="code_postal" >
  		</div>
  		<div class="form-group">	
  				<label for="ville" class="form-label">Ville</label>
  				<input type="text" class="form-control" placeholder="Rue" id= "ville"name="ville" >
  		</div>
  	</div>
  	
  	<div class="d-flex justify-content-center">
			<input class="btn btn-outline-primary m-1 p-2" type="submit" value="Enregistrer"> 
			<a href="${pageContext.request.contextPath }/ServletAccueilConnecte" class="btn btn-outline-primary m-1">  Annuler  </a>
	</div>

</form>


</body>
</html>