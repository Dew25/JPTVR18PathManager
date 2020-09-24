
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="createResource" method="POST">
    <div class="jumbotron bg-white">
        <h4 class="w-100 text-center ">Создание нового ресурса</h4>
            <div class="form-group w-50 mx-auto">
                <label for="name">Название ресурса</label>
                <input type="text" class="form-control" id="name" name="name" aria-describedby="nameResource" placeholder="Введите имя ресурса">
                <small id="nameResource" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto">    
                <label for="url">URL ресурса</label>
                <input type="text" class="form-control" id="url" name="url" aria-describedby="urlHelp" placeholder="Введите url ресурса">
                <small id="urlHelp" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto">    
                <label for="login">Логин</label>
                <input type="text" class="form-control" id="login" name="login" aria-describedby="loginHelp" placeholder="Логин">
                <small id="emailHelp" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto">    
                <label for="password">Пароль</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="passwordHelp" placeholder="Пароль">
                <small id="emailHelp" class="form-text text-muted"></small>
            </div>
            <div class="form-group w-50 mx-auto text-center">
                <button type="submit" class="btn btn-primary w-50 mt-4">Записать</button>
            </div>
    </div>
</form>
     
  