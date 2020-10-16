/* 
 * Главный файл приложения на JS (точка входа в приложение)
 */

document.getElementById("addResource").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("addResource");
  addFormNewResource();
}
document.getElementById("addUser").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("addUser");
}
document.getElementById("listResources").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("listResources");
}
document.getElementById("listUsers").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("listUsers");
}
document.getElementById("systemIn").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("systemIn");
}
document.getElementById("systemOut").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("systemOut");
}
function toogleMenuActive(elementId){
  let activeElement = document.getElementById(elementId);
  let passiveElement = document.getElementsByClassName("nav-item");
  for(let i = 0; i < passiveElement.length; i++){
    if(activeElement === passiveElement[i]){
      passiveElement[i].classList.add("active");
    }else{
      if(passiveElement[i].classList.contains("active")){
        passiveElement[i].classList.remove("active");
      }
    }
  }
}
function addFormNewResource(){
  document.getElementById("contentPage").innerHTML=
          `<form action="createResource" method="POST">
                <h3 class="w-100 text-center ">Создание нового ресурса!</h3>
              <div class="form-group w-50 mx-auto">    
                  <label for="name">Название ресурса</label>
                  <input value="" type="text" class="form-control" id="name" name="name" aria-describedby="nameHelp" placeholder="name">
                  <small id="nameHelp" class="form-text text-muted"></small>
              </div>
              <div class="form-group w-50 mx-auto">    
                  <label for="url">Url ресурса</label>
                  <input value="" type="text" class="form-control" id="url" name="url" aria-describedby="urlHelp" placeholder="url">
                  <small id="urlHelp" class="form-text text-muted"></small>
              </div>
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
                  <button id="btnAddResource" type="button" class="btn btn-primary w-50 mt-4">Добавить ресурс</button>
              </div>
              </form>`;
    document.getElementById("btnAddResource").oncklick = function(){
      createResource();
    }
    function createResource(){
      alert("funnction createResource() runing");
    }
}

