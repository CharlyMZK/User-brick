<%-- 
    Document   : creerUser
    Created on : 11 sept. 2016, 17:32:52
    Author     : MZK
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon profil</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <div>
            <form method="POST" action="<c:url value="/creationUser" />">
                <fieldset>
                    <legend>Informations de l'utilisateur</legend>
                    <label for="userName">Username :</label><label><c:out value="${user.username}"/></label>
                    <br/>
                    <label for="userEmail">Email :</label><label><c:out value="${user.email}"/></label>
                </fieldset>
                <input type="submit" value="valider">
            </form>
        </div>
    </body>
</html>
