<%-- 
    Document   : showFormLogin
    Created on : Sep 15, 2020, 1:21:34 PM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Вход в систему</title>
  </head>
  <body>
    <h1>Введите логин и пароль</h1>
    <form action="login" method="POST">
        Логин: <input type="text" name="login"><br>
        Пароль: <input type="text" name="password"><br>
        <input type="submit" value="Войти">
        <br>Нет логина? <a href="showFormAddUser">Регистристрация</a>
    </form>
  </body>
</html>
