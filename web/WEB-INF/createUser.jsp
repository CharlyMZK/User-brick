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
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <div>
            <form method="POST" action="<c:url value="/inscription" />">
                <fieldset>
                    <legend>Informations de l'utilisateur</legend>
                     
                    <label for="userName">Username : <span class="required">*</span></label>
                    <input type="text" id="userName" name="userName" value="<c:out value="${user.username}"/>" size="30" maxlength="30">
                    <span class="erreur">${form.errors["userName"]}</span>
                    <br/>
                    
                    <label for="userPassword">Password : <span class="required">*</span></label>
                    <input type="text" id="userPassword" name="userPassword" value="<c:out value="${user.password}"/>" size="30" maxlength="30">
                    <span class="erreur">${form.errors["userPassword"]}</span>
                    <br/>
                    
                    <label for="userConfirmation">Confirmation : <span class="required">*</span></label>
                    <input type="text" id="userConfirmation" name="userConfirmation" size="30" maxlength="30">
                    <span class="erreur">${form.errors["userConfirmation"]}</span>
                    <br/>
                    
                    <label for="userEmail">Email : <span class="required">*</span></label>
                    <input type="text" id="userEmail" name="userEmail" value="<c:out value="${user.email}"/>" size="30" maxlength="30">
                    <span class="erreur">${form.errors["userEmail"]}</span>
                    <br/>
                    
                </fieldset>
                <input type="submit" value="valider">
            </form>
        </div>
    </body>
</html>
