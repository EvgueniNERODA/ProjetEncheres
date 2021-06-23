<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon Profil</title>
</head>
<body>

	<div>
		<p>Pseudo : ${utilisateur.pseudo }</p>
		<p>Nom : ${utilisateur.nom }</p>
		<p>Prénom : ${utilisateur.prenom } </p>
		<p>Email : ${utilisateur.email } </p>
		<p>Téléphone : ${utilisateur.telephone }</p>
		<p>Rue : ${utilisateur.rue }</p>
		<p>Code Postal : ${utilisateur.codePostal }</p>
		<p>Ville : ${utilisateur.ville } </p>
		<p>Crédit : ${utilisateur.credit } </p>
	</div>
	<div>
		
	<a href="${pageContext.request.contextPath }/ServletModifProfil"><button>Modifier</button></a>
		
		
		
		
		
		
	</div>
</body>
</html>