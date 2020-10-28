/* 
 * Главный файл приложения на JS (точка входа в приложение)
 */
import {resourceModule} from './ResourceModule.js';
import {userModule} from './UserModule.js';
import {authModule} from './AuthModule.js';

document.getElementById("addResource").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("addResource");
  resourceModule.addFormNewResource();
}
document.getElementById("addUser").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("addUser");
  userModule.addFormNewUser();
}
document.getElementById("listResources").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("listResources");
  resourceModule.showListResources();
}
document.getElementById("listUsers").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("listUsers");
}
document.getElementById("systemIn").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("systemIn");
  authModule.showFormLogin();
}
document.getElementById("systemOut").onclick = function(e){
  e.preventDefault();
  toogleMenuActive("systemOut");
  authModule.logout();
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
 authModule.authMenu();

