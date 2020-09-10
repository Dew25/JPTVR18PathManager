<%-- 
    Document   : showFormAddResource
    Created on : Sep 10, 2020, 2:51:48 PM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новый ресурс</title>
  </head>
  <body>
    <h1>Создание нового ресурса!</h1>
    <form action="createResource" method="POST">
      Имя ресурса: <input type="text" name="name"><br>
      URL ресурса: <input type="text" name="url"><br>
      Логин: <input type="text" name="login"><br>
      Пароль: <input type="text" name="password"><br>
      <input type="submit" value="Создать">
    </form>
  </body>
</html>
