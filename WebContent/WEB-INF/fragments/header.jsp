<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./nav.css">
    <script src="https://kit.fontawesome.com/e845f4b193.js" crossorigin="anonymous"></script>
	
<title>Insert title here</title>

</head>
<body >


<div class="topnav" id="myTopnav">
		<a class="active" href="${pageContext.request.contextPath }/ServletBoutonAccueil"><i class="fa fa-home"></i> LE
				COIN QU'EST BON</a>
        <a href="${pageContext.request.contextPath }/ServletInscription" >S'inscrire</a>
        <a href="${pageContext.request.contextPath }/ServletConnexion">Se connecter</a>
                <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
    </div>

    <script>
      
        function myFunction() {
            var x = document.getElementById("myTopnav");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }

    </script>



</body>
</html>