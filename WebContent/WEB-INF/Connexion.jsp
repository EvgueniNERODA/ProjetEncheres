<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="./fragments/header.jsp" %>

<body>
	
	<form action="<%=request.getContextPath() %>/ServletConnexion"
		  method="POST">
	
		<div>
			<label for="indentifiant">Identifiant:</label>
    		<input type="text" id="identifiant" name="identifiant">
		</div>
	
		<div>
			<label for="motDePasse">Mot de passe:</label>
    		<input type="password" id="motDePasse" name="motDePasse" required>
		</div>
		
		<div>
			<input type="submit" value ="Connexion">
		</div>
		
		<div>
  			<input type="checkbox" name="SeSouvenirDeMoi">
  			<label for="SeSouvenirDeMoi">Se souvenir de moi</label>
		</div>
		
	</form>
	
	<div>
		<a href="/motDePasseOublie">Mot de passe oublié</a>
	</div>
	
	<div>
		<a href="/Inscription.jsp"><button>Créer un compte</button></a>
	</div>
</body>
</html>