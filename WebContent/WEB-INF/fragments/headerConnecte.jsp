<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	
<title>HeaderConnecte</title>

</head>
<body >

<nav class="navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
  
	
	<a class="btn text-white" href="${pageContext.request.contextPath }/ServletBoutonAccueil"><button class="btn"><i class="fa fa-home"></i></button>LE
				COIN QU'EST BON</a>
	

	  	<div class="form-inline">
		    <ul class="nav justify-content-end mr-auto mt-2 mt-lg-0">
		  <li class="nav-item">
		    <a href="${pageContext.request.contextPath }/ServletDeconnexion" class="nav-link active text-white" >Deconnection</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-white" href="${pageContext.request.contextPath }/ServletMonProfil">Mon Profil</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link text-white" href="${pageContext.request.contextPath }/ServletNouvelleVente">Vendre un article</a>
		  </li>
			</ul>
	  	</div>
		
</nav>







	




</body>
</html>