<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="fr.eni.messages.LecteurMessage" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Accueil Connecté</title>
</head>



<body>
<%@include file="./fragments/headerConnecte.jsp"%>
<h1 class="d-flex justify-content-center">Liste des enchères</h1>


<div class="container">
<h3>Filtres</h3>
<br>
  <form class="form-inline col-md-5" action="${pageContext.request.contextPath }/ServletAccueilConnecte" method="POST">
    <input class="form-control mr-md-2 shadow-sm" type="search" placeholder="Le nom de l'article contient" aria-label="Search" name="recherche">
    
  
    
    
    <div >
    
    <label for="categorie">Catégorie</label>
    <select class="form-control shadow-sm col-md-4" id="categorie" name="categorie">
    
    
    		<option value="5">Toutes</option>
    		
    		
    		
       <c:forEach var ="liste" items="${listesCategories }">
      		<option  value="${liste.getNoCategorie()}">
      		${liste.getLibelle()}
      		
      		</option>
      </c:forEach>
      
    </select>
    
	</div>
	
	
	<div class="form-check">
	<input class="form-check-input" type="radio" name="flexRadioDefault" id="radio1" onchange="changeThis(this)">
  <label class="form-check-label" for="flexRadioDefault1">
    Default radio1
  </label>
	</div>
	
<div class="form-check">
	<input class="form-check-input" type="radio" name="flexRadioDefault" id="radio2" onchange="changeThis(this)">
  <label class="form-check-label" for="flexRadioDefault1">
    Default radio2
  </label>
	</div>

<div class = "container ">
  <div class="row  form-switch">
  
   
    <fieldset class="col-sm-6 ">
      <label>
        <input id="check1" class="form-check-input" type="checkbox" name="encheres_ouvertes"  disabled onclick="document.getElementById('form').submit();"/>
        <span class="form-check-label" for="flexSwitchCheckChecked">Enchères ouvertes</span>
      </label>
    </fieldset>
    <fieldset class="col-sm-6">
      <label>
        <input  id="check5"  class="form-check-input" type="checkbox" name="mes_ventes_en_cours" disabled/>
        <span>Mes ventes en cours</span>
      </label>
    </fieldset>
     <fieldset class="col-sm-6 ">
      <label>
        <input id="check2"  class="form-check-input" type="checkbox" name="mes_encheres" disabled/>
        <span class="form-check-label" for="flexSwitchCheckChecked">Mes enchères</span>
      </label>
    </fieldset>
    <fieldset class="col-sm-6">
      <label>
        <input  id="check4" class="form-check-input" type="checkbox" name="ventes_non_debutees" disabled/>
        <span>Ventes non débutées</span>
      </label>
    </fieldset>
     <fieldset class="col-sm-6 ">
      <label>
        <input  id="check3"  class="form-check-input" type="checkbox" name="mes_encheres_remportees" disabled/>
        <span class="form-check-label" for="flexSwitchCheckChecked">Mes enchères remportées</span>
      </label>
    </fieldset>
    <fieldset class="col-sm-6">
      <label>
        <input  id="check6"  class="form-check-input" type="checkbox" name="ventes_terminees" disabled/>
        <span>Ventes terminées</span>
      </label>
    </fieldset>
  </div>
</div>
<script>

	function changeThis(sender) {
		if (document.getElementById('radio1').checked) {
		document.getElementById("check1").removeAttribute('disabled');
		document.getElementById("check2").removeAttribute('disabled');
		document.getElementById("check3").removeAttribute('disabled');
		document.getElementById("check4").disabled = true;
		document.getElementById("check5").disabled = true;
		document.getElementById("check6").disabled = true;
		
		
	}else if (document.getElementById('radio2').checked){
		document.getElementById("check4").removeAttribute('disabled');
		document.getElementById("check5").removeAttribute('disabled');
		document.getElementById("check6").removeAttribute('disabled');
		document.getElementById("check1").disabled = true;
		document.getElementById("check2").disabled = true;
		document.getElementById("check3").disabled = true;
	}

	}



		
		
	</script>
	
	<span><button class="btn btn-outline-success my-4 my-sm-4 btn-lg" type="submit">Rechercher</button></span>
	  
  </form>
  

<div class="row row-cols-1 row-cols-md-3 g-4">
 
  	 <c:forEach var ="liste" items="${listesArticles }">
  	  <div class="col">
    <div class="card shadow-sm bg-light">
      
      <div class="card-body">
        <h5 class="card-title">${liste.nomArticle}</h5>
        <p class="card-text">Prix : ${liste.miseAPrix} points</p>
        <p class="card-text">Fin de l'enchère  : 
       	<fmt:parseDate value="${liste.dateFinEncheres}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
		<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="dd.MM.yyyy" />${newParsedDate}
		</p>

		<form action="${pageContext.request.contextPath }/ServletProfilUtilisateur" method="post">
         <p class="card-text">Vendeur  :</p>
			<input type="hidden" name="pseudo" value="${liste.getUtilisateur().getPseudo()}">
         	<input type="submit" value="${liste.getUtilisateur().getPseudo()}">	

        </form>
       
       
      </div>
     </div>
     </div>
     <br>
     </c:forEach>
  

</div>
		
</body>
</html>