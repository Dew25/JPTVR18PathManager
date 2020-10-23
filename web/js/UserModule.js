
class UserModule{
  addFormNewUser(){
    document.getElementById("contentPage").innerHTML=
          `<form action="createResource" method="POST">
                <h3 class="w-100 text-center ">Регистрация пользователя</h3>

              <div class="form-group w-50 mx-auto">    
                  <label for="login">Логин</label>
                  <input value="" type="text" class="form-control" id="login" name="login" aria-describedby="loginHelp" placeholder="Логин">
                  <small id="emailHelp" class="form-text text-muted"></small>
              </div>
              <div class="form-group w-50 mx-auto">    
                  <label for="password">Пароль</label>
                  <input value="" type="text" class="form-control" id="password" name="password" aria-describedby="passwordHelp" placeholder="Пароль">
                  <small id="emailHelp" class="form-text text-muted"></small>
              </div>
              <div class="form-group w-50 mx-auto text-center">
                  <button id="btnAddUser" type="button" class="btn btn-primary w-50 mt-4">Зарегистрировать пользователя</button>
              </div>
              </form>`;
    document.getElementById("btnAddUser").addEventListener("click",function(e){
      e.preventDefault();
      userModule.createUser();
    });
  }
  createUser(){
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let data = {
      "login":login,
      "password":password,
    };
    fetch("createUserJson",{"method":"POST",
                                "headers":{'Content-Type':'application/json;charset=utf-8'},
                                "body": JSON.stringify(data)
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
                document.getElementById("info").innerHTML = 'Пользователь '+response.data.login +' добавлен';
                document.getElementById("contentPage").innerHTML='';
              }
            }
            );
  }
}
let userModule = new UserModule();
export {userModule};


