<%-- 
    Document   : showListResources
    Created on : Sep 17, 2020, 1:53:20 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <h1>Список ресурсов</h1>
    <table>
        <c:forEach var="resource" items="${listResources}">
            <tr> 
              <td>
                <li>Имя: ${resource.name}</li>
                <li>URL: ${resource.url}</li>
                <li>login: ${resource.login}</li>
                <li>password: ${resource.password}</li>
                <li>------------------------------</li>
              </td>
              <td>
                <a href="deleteResource?id=${resource.id}">Удалить</a>
              </td>
            </tr>
        </c:forEach>
    </table>
