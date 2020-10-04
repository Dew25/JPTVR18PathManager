
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <h1>Изменение ресурса!</h1>
    <form action="updateResource" method="POST">
        <input type="hidden" name="id" value="${resource.id}">
      Имя ресурса: <input type="text" name="name" value="${resource.name}"><br>
      URL ресурса: <input type="text" name="url" value="${resource.url}"><br>
      Логин: <input type="text" name="login" value="${resource.login}"><br>
      Пароль: <input type="text" name="password" value="${resource.password}"><br>
      <input type="submit" value="Изменить">
    </form>
 