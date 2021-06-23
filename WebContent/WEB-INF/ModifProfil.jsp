<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon Profil</title>
</head>
<body>

	<div>
		<p>Pseudo : </p>
		<p>Nom : </p>
		<p>Prénom : </p>
		<p>Email : </p>
		<p>Téléphone : </p>
		<p>Rue : </p>
		<p>Code Postal : </p>
		<p>Ville : </p>
	</div>
	<div>
		<p>${utilisateur.pseudo }</p>
		<p>${utilisateur.nom }</p>
		<p>${utilisateur.prenom }</p>
		<p>${utilisateur.email }</p>
		<p>${utilisateur.telephone }</p>
		<p>${utilisateur.rue }</p>
		<p>${utilisateur.codePostal }</p>
		<p>${utilisateur.ville }</p>
	</div>
</body>
</html>