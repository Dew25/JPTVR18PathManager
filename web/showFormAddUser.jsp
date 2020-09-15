<%-- 
    Document   : showFormAddUser
    Created on : Sep 15, 2020, 12:59:50 PM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Зарегистрировать пользователя</title>
  </head>
  <body>
    <h1>Заполните форму</h1>
      <form action="createUser" method="POST">
        Логин: <input type="text" name="login"><br>
        Пароль: <input type="text" name="password"><br>
        <input type="submit" value="Создать">
    </form>
  </body>
</html>
