
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="createUser" method="POST">
    <div class="jumbotron bg-white">
        <h4 class="w-100 text-center ">Заполните форму регистрации нового пользователя</h4>
            <div class="form-group w-50 mx-auto">    
                <label for="login">Логин</label>
                <input type="text" class="form-control" id="login" name="login" aria-describedby="loginHelp" placeholder="Логин">
                <small id="loginHelp" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto">    
                <label for="password">Пароль</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp" placeholder="Пароль">
                <small id="passwordHelp" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto text-center">
                <button type="submit" class="btn btn-primary w-50 mt-4">Зарегистрировать</button>
            </div>
    </div>

 