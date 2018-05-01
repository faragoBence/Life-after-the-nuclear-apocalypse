<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url value="/resources/css/style.css" var="styleUrl"/>
    <c:url value="/resources/js/index.js" var="indexScriptUrl"/>
    <c:url value="/resources/js/login.js" var="loginScriptUrl"/>
    <c:url value="/resources/js/register.js" var="registerScriptUrl"/>
    <c:url value="/resources/js/profile.js" var="profileScriptUrl"/>
    <c:url value="/resources/js/logout.js" var="logoutScriptUrl"/>
    <link rel="stylesheet" type="text/css" href="${styleUrl}">
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${registerScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
    <script src="${logoutScriptUrl}"></script>
    <link rel="shortcut icon" href="resources/icons/titleIcon.png"/>
    <title>LANA</title>
</head>

<body>
<h1 id="message-field">${message}</h1>
<div id="login-content" class="content">
    <div class="form-div">
        <form id="login-form" name="login" onsubmit="return false;">
            <div class="input-div">
                <h2 id="h2">Logging in</h2><br>E-mail:<br>
                <input type="email" name="email" class="form-el" id="email"><br> Password:<br>
                <input type=password name="password" class="form-el" id="loginPassword"><br>
                <p id="registration-para" class="register-paragraph">If you don't have an account <a
                        class="register-link"
                        href=javascript:void(0); onclick="toRegistration();">register</a>
                    one</p>
                <input id="login-button" type="submit" value="Login" class="btn">
            </div>
        </form>
    </div>
</div>
<div id="register-content" class="hidden content">
    <div class="form-div">
        <form id="register-form" name="register" onsubmit="return false;">
            <div class="input-div">
                <h2>Registration</h2>Name:<br>
                <input type="text" name="name" class="form-el"><br>E-mail:<br>
                <input type="email" name="email" class="form-el"><br>Password:<br>
                <input type=password name="password" class="form-el" id="passwordReg"><br>Confirm Password:<br>
                <input type="password" name="password-again" class="form-el" id="password-againReg"><br>Survivor Name:<br>
                <input type="text" name="survivor" class="form-el"><br>
                <input type="radio" name="type" value="Warrior" checked>Warrior<br>
                <input type="radio" name="type" value="Mage">Mage<br>
                <input type="radio" name="type" value="Hunter" class="hunter-el">Hunter<br>
                <p class="register-paragraph">Already have an account? <a class="register-link"
                                                                          href=javascript:void(0); onclick="toLogin();">Login
                    here</a></p>
                <input id="register-button" type="submit" value="Register" class="btn">
            </div>
        </form>
    </div>
</div>
<div id="logout-content" class="hidden content">
    <button id="logout-button">Logout</button>
</div>
</body>
</html>
