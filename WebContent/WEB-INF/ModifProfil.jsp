<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.messages.LecteurMessage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Mon profil</title>
</head>

<body >
<%@include file="./fragments/headerConnecte.jsp" %>
	<div class="container">

		<h1 class="d-flex justify-content-center">Modification du profil</h1>
		<form action="${pageContext.request.contextPath }/ServletModifProfil"
			method="POST" name="modifProfil" class="form">



		<div  class="col-md-6">
				<label  class="form-label">Pseudo</label>
  				<input type="text" class="form-control" placeholder="Pseudo" name="pseudo" pattern="^(?![0-9]*$)[a-zA-Z0-9]+$"  id="exampleInputEmail1" required>
  		</div>
  		<div  class="col-md-6">		
  				<label  class="form-label">Nom</label>
  				<input type="text" class="form-control" placeholder="Nom" name="nom" required>
  				
		</div>
		<div class="col-md-6">
			
				<label  class="form-label">Prénom</label>
  				<input type="text" class="form-control" placeholder="Prénom" name="prenom" required>
  		</div>
  		<div class="col-md-6">	
  				<label  class="form-label">Email</label>
  				<input type="email" class="form-control" placeholder="Email" name="email" pattern="^[\w.-]+@\w+.\w{2,3}$" required>
		</div>
		<div class="col-md-6">	
				
				<label  class="form-label">Teléphone</label>
  				<input type="text" class="form-control" placeholder="Teléphone" name="tel" pattern="[0-9]+">
  		</div>		
  		<div class="col-md-6">	
  				<label  class="form-label">Rue</label>
  				<input type="text" class="form-control" placeholder="Rue" name="rue" required>
  				
		</div>
		<div class="col-md-6">	
			
				<label  class="form-label">Code postal</label>
  				<input type="text" class="form-control" placeholder="Code postal" name="cp" pattern="[0-9]+" required>
  		</div>
  		<div class="col-md-6">	
  				<label  class="form-label">Ville</label>
  				<input type="text" class="form-control" placeholder="Ville" name="ville" required>
		</div>
  		
  		<div class="col-md-6">	
  				<label  class="form-label">Mot de passe actuel</label>
  				<input type="password" class="form-control" placeholder="Actuel" name="actualPassword" required>
		</div>
		
		<div class="col-md-6">	
  				<label  class="form-label">Nouveau mot de passe</label>
  				<input type="password" class="form-control" placeholder="Nouveau" name="newPassword" required>
		</div>
		
  		<div class="col-md-6">	
  				<label  class="form-label">Confirmation mot de passe</label>
  				<input type="password" class="form-control" placeholder="Confirmation" name="confirmPassword" required>
		</div>

<br>
		<div class="d-flex justify-content-center">
			<input class="btn btn-outline-primary" type="submit" value="Enregistrer"> 
		</div>
		</form>
		
		<form action="${pageContext.request.contextPath }/ServletDesinscription"
			method="POST" name="supprimerProfil">
			
			<div class="d-flex justify-content-center">
				<input class="btn btn-outline-primary" type="submit" value="Supprimer mon compte"> 
			</div>
			
			<div class="col-md-6">	
  				<label for="inputEmail4" class="form-label">Etes-vous sûr de vouloir supprimer ?</label>
  				<input type="text" class="form-control" placeholder="Oui pour valider" name="confirmationDelete" required>
			</div>
		</form>
		
	<c:if test="${verifMail == true}">
    	Le le mail existe déjà!!!
	</c:if>
	<c:if test="${verifPseudo == true}">
    	Le pseudo existe déjà!!!
	</c:if>
	<c:if test="${verifPassword == true}">
    	Veuillez saisir des mots de passe identiques.
	</c:if>

	</div>
</body>

</html>