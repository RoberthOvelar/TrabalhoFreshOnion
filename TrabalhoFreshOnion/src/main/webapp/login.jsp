<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="<%= request.getContextPath() %>/imagens/icons/onionIcon.png">
        <link rel="stylesheet" href="style.css">
        <title>Fresh Onion - Login</title>
    </head>
    <body class="just-center">
        <main id="login-container">
            <header id="login-header">
                <a href="<%= request.getContextPath() %>/home" class="logo">
                    <img src="<%= request.getContextPath() %>/imagens/icons/logo.png" alt="" class="logo">
                </a>
            </header>
            <form action="login" id="login-form" name="login" method="post">
                <h2>Log In</h2>
                <input type="email" name="email" id="email" placeholder="Email" class="inputTxt">
                <input type="password" name="password" id="senha" placeholder="Senha" class="inputTxt">
                <input type="submit" value="Log In" id="btnLogin">
                <p class="error-message bold">${erroMensagem}</p>
                <a href="">Esqueceu sua senha?</a>
                <a href="">Criar conta</a>
            </form>
        </main>
        <script src="script.js"></script>
    </body>
</html>