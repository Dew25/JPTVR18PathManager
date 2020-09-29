<%-- 
    Document   : showListResources
    Created on : Sep 17, 2020, 1:53:20 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="showResource" method="POST" id="formShowResource">   
    <div class="jumbotron bg-white">
        <h4 class="w-100 text-center ">Список ресурсов</h4>
            <div class="form-group w-50 mx-auto">
                <select class="custom-select" name="idRecource" id="idResource">
                    <option selected="">Open this select menu</option>
                    <c:forEach var="resource" items="${listResources}">
                        <option value="${resource.id}">${resource.name}</option>
                    </c:forEach>
                </select>
            </div>
    </div>
</form>
        