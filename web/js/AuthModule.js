
import {userModule} from './UserModule.js';

class AuthModule{
  showFormLogin(){
    document.getElementById("contentPage").innerHTML = 
   `<h4 class="w-100 text-center ">Введите логин и пароль</h4>
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
        <button id="btnLogin" type="button" class="btn btn-primary w-50 mt-4">Войти</button>
            <small id="emailHelp" class="form-text text-muted">
               Нет логина? <a id="btnRegistration" href="">Зарегистрируйтесь</a>
            </small>
    </div>`;
    
    document.getElementById("password").addEventListener("keydown",function(e){
      if(e.keyCode === 13){
        e.preventDefault();
        authModule.login();
      }
    });
    document.getElementById("btnLogin").addEventListener("click",function(e){
      e.preventDefault();
      authModule.login();
    });
    document.getElementById("btnRegistration").addEventListener("click",function(e){
      e.preventDefault();
      userModule.addFormNewUser();
    });
  }
  
  login(){
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let credentials = {
      "login": login,
      "password":password
    }
    fetch("loginUserJson",{"method":"POST",
                                "headers":{'Content-Type':'application/json;charset=utf-8'},
                                "body": JSON.stringify(credentials)
                              })
                              .then(response =>{
                                if(response.status >= 200 & response.status < 300){
                                  return Promise.resolve(response)
                                }
                              })
                              .then(response => {
                                return response.json()
                              })
                              .catch((ex)=> console.log("Fetch Exception",ex))
            .then(function(response){
              if(response === null || response === undefined){
                document.getElementById("info").innerHTML = 'Не получены данные';
              }else{
                if(response.data === undefined){
                  document.getElementById("info").innerHTML = response.info;
                }else{
                  document.getElementById("info").innerHTML = 'Привет, '+response.data.login +'!';
                  document.getElementById("contentPage").innerHTML='';
                  sessionStorage.setItem('user',JSON.stringify(response.data));
                  authModule.authMenu();
                }
              }
            }
            );
  }
  authMenu(){
    let user = null;
    if(sessionStorage.getItem('user') !== null){
      user = JSON.parse(sessionStorage.getItem('user'));
    }
    if(user !== null){
      document.getElementById("addResource").style.display = 'block';
      document.getElementById("addUser").style.display = 'block';
      document.getElementById("listResources").style.display = 'block';
      document.getElementById("listUsers").style.display = 'block';
      document.getElementById("systemIn").style.display = 'none';
      document.getElementById("systemOut").style.display = 'block';
    }else{
      document.getElementById("addResource").style.display = 'none';
      document.getElementById("addUser").style.display = 'none';
      document.getElementById("listResources").style.display = 'none';
      document.getElementById("listUsers").style.display = 'none';
      document.getElementById("systemIn").style.display = 'block';
      document.getElementById("systemOut").style.display = 'none';
    }
  }
  logout(){
    fetch("logoutUserJson",{"method":"POST",
                                "headers":{'Content-Type':'application/json;charset=utf-8'},
                                
                              })
                              .then(response =>{
                                if(response.status >= 200 & response.status < 300){
                                  return Promise.resolve(response)
                                }
                              })
                              .then(response => {
                                return response.json()
                              })
                              .catch((ex)=> console.log("Fetch Exception",ex))
            .then(function(response){
              if(response === null || response === undefined){
                document.getElementById("info").innerHTML = 'Не получены данные';
              }else{
                document.getElementById("info").innerHTML = response.info;
                document.getElementById("contentPage").innerHTML='';
                if(sessionStorage.getItem('user')){
                  sessionStorage.removeItem('user');
                }
                authModule.authMenu();
              }
            }
            );
  }
}
let authModule = new AuthModule();
export {authModule};


