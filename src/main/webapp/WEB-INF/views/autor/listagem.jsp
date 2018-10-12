<%--
  Created by IntelliJ IDEA.
  User: rogeriocarmine
  Date: 12/10/2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Listagem de Autor</title>
</head>
<body>
<h1>Listagem de Autor</h1>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Email</th>
    </thead>
    <tbody>
    <c:forEach var="autor" items="${autores}">
        <tr>
            <td>${autor.id}</td>
            <td>${autor.nome}</td>
            <td>${autor.email}</td>
        </tr>
    </c:forEach>
    </tbody>


    <a href="/autor/cadastro">Cadastrar Autor</a>

</table>

</body>
</html>
