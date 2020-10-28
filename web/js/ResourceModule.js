
class ResourceModule{
  createResource(){
    let name = document.getElementById("name").value;
    let url = document.getElementById("url").value;
    let login = document.getElementById("login").value;
    let password = document.getElementById("password").value;
    let data = {
      "name":name,
      "url":url,
      "login":login,
      "password":password,
    };
    fetch("createResourceJson",{"method":"POST",
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
                                  document.getElementById("info").innerHTML = 'Ресурс '+response.data.name +' добавлен';
                                  resourceModule.showListResources(response.listReaources);
                                }
                              }
                              );     
  }
  addFormNewResource(){
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
    document.getElementById("btnAddResource").addEventListener("click",function(e){
      e.preventDefault();
      resourceModule.createResource();
    });
  }
  showListResources(){
    let user = JSON.parse(sessionStorage.getItem('user'));
    if(user === null){
      document.getElementById("info").innerHTML = 'Войдите в систему';
      authModule.showFormLogin();
      return;
    }
    fetch("getListResourcesJson",{"method":"POST",
                                "headers":{'Content-Type':'application/json;charset=utf-8'},
                                "body": JSON.stringify(user)
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
                                  document.getElementById("info").innerHTML = 'Список ресурсов доставлен';
                                  resourceModule.createSelectResources(response.listResources)
                                }
                              }
                              );    
  }
  createSelectResources(listResources){
    
    let select = document.createElement('select');
    select.setAttribute("id",'resourceId');
    for (let resource in listResources) {
      select.options[select.options.length] = new Option(resource.name, resource.id);
    }
    document.getElementById("contentPage").innerHTML=
    `<h3 class="w-100 text-center ">Список ресурсов:</h3>
    <div id="listResources" class="form-group w-50 mx-auto">
    </div>`;
   document.getElementById('listResources').appendChild(select);
   document.getElementById('resourceId').addEventListener("change", (e)=>{
     e.preventDefault();
     resourceModule.preintResource(listResources[document.getElementById('resourceId').value]);
   });
  }
  printResource(resource){
    console.log(resource);
  }
}
let resourceModule = new ResourceModule();
export {resourceModule};
