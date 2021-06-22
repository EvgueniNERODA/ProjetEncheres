<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./inscription.css">
    <title>Mon profil</title>
</head>

<body>


    <h1>Mon profil</h1>
    <form action="" method="POST" name="inscription">

        <div class="saisie">
            <div >
                <ul>
                    <li><label for="pseudo">Pseudo :</label><input type="text" id="pseudo"></li>
                    <li><label for="prenom">Prénom :</label><input type="text" id="prenom"></li>
                    <li><label for="tel">Teléphone :</label><input type="tel" id="tel"></li>
                    <li><label for="cp">Code postal :</label><input type="text" id="cp"></li>
                    <li><label for="password">Mot de passe :</label><input type="password" id="password"></li>
                </ul>
            </div>
            <div >
                <ul>
                    <li><label for="nom">Nom :</label><input type="text" id="nom"></li>
                    <li><label for="mail">Email :</label><input type="email" id="mail"></li>
                    <li><label for="rue">Rue :</label><input type="text" id="rue"></li>
                    <li><label for="ville">Ville :</label><input type="text" id="ville"></li>
                    <li><label for="conf">Confirmation :</label><input type="password" id="conf"></li>
                </ul>
            </div>

        </div>

        <input type="submit" value="Créer">
        <a href="$">Annuler</a>
    </form>

</body>

</html>