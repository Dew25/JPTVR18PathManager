<%-- 
    Document   : showListResources
    Created on : Sep 17, 2020, 1:53:20 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h4 class="w-100 text-center ">Список ресурсов:</h4>
<div class="form-group w-50 mx-auto">
    <table>
        <c:forEach var="resource" items="${listResources}">
            <tr> 
              <td>
                <li>Имя: ${resource.name}</li>
                <li>URL: ${resource.url}</li>
                <li>login: ${resource.login}</li>
                <li>password: ${resource.password}</li>
                <br>------------------------------
              </td>
              <td>
                  <a href="deleteResource?id=${resource.id}">Удалить</a><br>
                  <a href="showEditResource?idResource=${resource.id}">Изменить</a><br>

              </td>
            </tr>
        </c:forEach>
    </table>
</div>
