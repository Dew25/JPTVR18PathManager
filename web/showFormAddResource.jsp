
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <h1>Создание нового ресурса!</h1>
    <form action="createResource" method="POST">
      Имя ресурса: <input type="text" name="name"><br>
      URL ресурса: <input type="text" name="url"><br>
      Логин: <input type="text" name="login"><br>
      Пароль: <input type="text" name="password"><br>
      <input type="submit" value="Создать">
    </form>
  