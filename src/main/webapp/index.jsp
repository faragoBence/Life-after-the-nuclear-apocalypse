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
    <c:url value="/resources/js/rest.js" var="restScriptUrl"/>
    <link rel="stylesheet" type="text/css" href="${styleUrl}">
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${registerScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
    <script src="${logoutScriptUrl}"></script>
    <script src="${restScriptUrl}"></script>
    <link rel="shortcut icon" type="image/x-icon" href="resources/icons/favicon.png"/>
    <title>LANA</title>
</head>

<body>
<div id="login-content" class="content">
    <div class="form-div">
        <form id="login-form" name="login" onsubmit="return false;">
            <div class="input-div">
                <h2 id="h2">Logging in</h2><br>E-mail:<br>
                <input type="email" name="email" class="form-el"><br> Password:<br>
                <input type=password name="password" class="form-el"><br>
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
                <input type=password name="password" class="form-el"><br>Confirm Password:<br>
                <input type="password" name="password-again" class="form-el"><br>Survivor
                Name:<br>
                <input type="text" name="survivor" class="form-el"><br>
                <input type="radio" name="type" value="Bruiser" checked>Bruiser<br>
                <input type="radio" name="type" value="Gunslinger">Gunslinger<br>
                <input type="radio" name="type" value="Soldier" class="hunter-el">Soldier<br>
                <p class="register-paragraph">Already have an account? <a class="register-link"
                                                                          href=javascript:void(0); onclick="toLogin();">Login
                    here</a></p>
                <input id="register-button" type="submit" value="Register" class="btn">
            </div>
        </form>
    </div>
</div>
<div id="profile-content" class="hidden content">
    <h1>Profile</h1>
    <h3>User name: <span id="user-name"></span></h3>
    <p>Location: <span id="location"></span></p>
    <p>Survivor name: <span id="survivor-name"></span></p>
    <p>Survivor type: <span id="survivor-type"></span></p>
    <div class="attr-table-div">
        <table class="attr-table">
            <tr>
                <td>
                    <img src="icons/health.png" altr="Health:" class="attr-icon">
                </td>

                <td>
                    <span id="health"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="icons/action.png" altr="Action Points:" class="attr-icon">
                </td>

                <td>
                    <span id="action-points"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="icons/hunger.png" altr="Hunger Level:" class="attr-icon">
                </td>

                <td>
                    <span id="hunger-level"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="icons/radiation.png" altr="Radiation resistance: " class="attr-icon">
                </td>

                <td>
                    <span id="radiation-resistance"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="icons/agility.png" altr="Agility:" class="attr-icon">
                </td>

                <td>
                    <span id="agility"></span>
                </td>
            </tr>
            <tr>
                <td>
                    <img src="icons/strength.png" altr="Strength:" class="attr-icon">
                </td>

                <td>
                    <span id="strength"></span>
                </td>
            </tr>
        </table>
    </div>


    <button id="rest-button" class="btn" onclick="rest()">Rest!</button>
    <button id="travel-button" class="btn" onclick="travel()">Travel!</button>

</div>
<div id="logout-content" class="hidden content">
    <button id="logout-button" class="btn">Logout</button>
</div>
</body>
</html>
