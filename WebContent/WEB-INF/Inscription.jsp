<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./inscription.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Mon profil</title>
</head>

<body class="p-3 mb-2 bg-white text-dark">
	<div class="p-3 mb-2 bg-light text-dark">

	<h1 class="d-flex justify-content-center">Mon profil</h1>
	<form action="${pageContext.request.contextPath }/ServletInscription" method="POST" name="inscription">

		
		
		<div class="input-group mb-3">
				
  				<input type="text" class="form-control" placeholder="Pseudo" name="pseudo">
  			
  				<input type="text" class="form-control" placeholder="Nom" name="nom">
		</div>
		<div class="input-group mb-3">
			
  				<input type="text" class="form-control" placeholder="Prénom" name="prenom">
  			
  				<input type="email" class="form-control" placeholder="Email" name="email">
		</div>
		<div class="input-group mb-3">
			
  				<input type="text" class="form-control" placeholder="Teléphone" name="tel">
  			
  				<input type="text" class="form-control" placeholder="Rue" name="rue">
		</div>
		<div class="input-group mb-3">
			
  				<input type="text" class="form-control" placeholder="Code postal" name="cp">
  			
  				<input type="text" class="form-control" placeholder="Ville" name="ville">
		</div>
		<div class="input-group mb-3">
			
  				<input type="password" class="form-control" placeholder="Mot de passe" name="password">
  			
  				<input type="password" class="form-control" placeholder="Confirmation" name="conf">
		</div>

		<div class="d-flex justify-content-center">
			<input class="btn btn-outline-primary" type="submit" value="   Créer   "> 
			<a href="${pageContext.request.contextPath }/ServletAccueil" class="btn btn-outline-primary">Annuler</a>
		</div>
		
	</form>
	
	
</div>
</body>

</html>