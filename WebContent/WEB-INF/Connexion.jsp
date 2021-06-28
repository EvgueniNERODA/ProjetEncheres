<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<title>Connexion</title>
</head>


<body>
<%@include file="./fragments/header.jsp"%>

<div class="container   p-3 mb-2 bg-light text-dark">

<form action="<%=request.getContextPath() %>/ServletConnexion"
		method="POST">
		
  <div class="mb-3">
    <label class="form-label" for="indentifiant">Identifiant:</label>
	<input class="form-control" type="text" id="identifiant" name="identifiant">
      </div>
  <div class="mb-3">
    <label class="form-label" for="motDePasse">Mot de passe:</label>
    <input class="form-control" type="password" id="motDePasse" name="motDePasse" required>
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="SeSouvenirDeMoi" name="SeSouvenirDeMoi">
    <label class="form-check-label" for="SeSouvenirDeMoi">Se souvenir de moi</label>
  </div>
   <div >
  <button type="submit" class="btn btn-primary" value="Connexion">Connexion</button>
  <a href="${pageContext.request.contextPath }/ServletInscription"  class="btn btn-primary">Créer un compte</a>
  </div>
</form>

	

	
	<div>
		<a href="/motDePasseOublie">Mot de passe oublié</a>
	</div>

<c:if test="${!empty listeCodesErreur}">
        <div class="alert alert-danger" role="alert">
            <strong>Erreur!</strong>
            <ul>
                <c:forEach var="code" items="${listeCodesErreur}">
                    <li>${LecteurMessage.getMessageErreur(code)}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

	

	<c:if test="${existeEnBdd == false}">
	

 <div class="alert alert-danger" role="alert">
  Le compte n'existe pas ou le mot de passe est incorrect.
</div>
    	
	</c:if>
	
</div>
</body>
</html>