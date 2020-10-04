
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <c:if test="${loginOn == false || loginOn == null}">
        <a href="showFormLogin">Войти в систему</a><br>
    </c:if>
    <c:if test="${loginOn == true}">
        <a href="logout">Выйти / </a>
        <a href="showFormAddResource">Добавить новый ресурс / </a>
        <a href="listResources">Список ресурсов / </a><br>
    </c:if>
    
   
