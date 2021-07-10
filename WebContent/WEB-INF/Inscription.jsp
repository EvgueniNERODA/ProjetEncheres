
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.messages.LecteurMessage" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./inscription.css">

<title>Mon profil</title>
</head>

<body >
<%@include file="./fragments/header.jsp" %>


 <h1>Inscription</h1>
    <div >
   
    <form action="${pageContext.request.contextPath }/ServletInscription" method="POST" name="inscription"  class="container">
        <div id="formbox">
            <label for="pseudo">Pseudo</label>
            <input type="text" name="pseudo" placeholder="Pseudo" pattern="^(?![0-9]*$)[a-zA-Z0-9]+$">
        </div>
        <div id="formbox">
            <label for="nom">Nom</label>
            <input type="text" name="nom" placeholder="Nom">    
        </div>
        
        <div id="formbox">
            <label for="prenom">Prenom</label>
            <input type="text" name="prenom" placeholder="Prénom">

        </div>
        <div id="formbox">
            <label for="email">email</label>
            <input type="email" name="email" placeholder="john@example.com" pattern="^[\w.-]+@\w+.\w{2,3}$" required>

        </div>
                <div id="formbox">
            <label for="tel">Telephone</label>
            <input type="text" name="tel" placeholder="Teléphone" pattern="[0-9]+">

        </div>
        <div id="formbox">
            <label for="rue">Rue</label>
            <input type="text" name="rue" placeholder="Rue">

        </div>
        <div id="formbox">
            <label for="cp">Code postal</label>
            <input type="text" name="cp" placeholder="Code postal" pattern="[0-9]+" required>
            
        </div>
        <div id="formbox">
            <label for="ville">Ville</label>
            <input type="text" name="ville" placeholder="Ville" >
            
        </div>
        <div id="formbox">
            <label for="password">Mot de passe</label>
            <input type="password" name="password" placeholder="Mot de passe">
            
        </div>
        <div id="formbox">
            <label for="conf">Repeter le mot de passe</label>
            <input type="password" name="conf" placeholder="Répéter le mot de passe">

        </div>
        
        
      
        
        

        <div class="validation">
        <button id="button" type="submit">Enregistrer</button>
        
        <button id="button" type="reset">Annuler</button>
        </div>




    </form>
</div>
	
	
	
		<c:if test="${!empty listeCodesErreur}">
        <div class="alert alert-danger" role="alert">
            <strong>Erreur!</strong>
            
                <c:forEach var="code" items="${listeCodesErreur}">
                ${code}
                    ${LecteurMessage.getMessageErreur(code)}
                </c:forEach>
            
        </div>
    </c:if>
	
	<c:if test="${verifMail == true}">
		<div class="alert alert-danger" role="alert">
		 	 Le le mail existe déjà.
		</div>
    	
	</c:if>
	<c:if test="${verifPseudo == true}">
		<div class="alert alert-danger" role="alert">
			Le pseudo existe déjà!!!
		</div>
	
    	
	</c:if>
	<c:if test="${verifPassword == true}">
		<div class="alert alert-danger" role="alert">
			Veuillez saisir des mots de passe identiques.
		</div>
	
    	
	</c:if>
</div>


</body>
<%@include file="./fragments/footer.jsp" %>
</html>