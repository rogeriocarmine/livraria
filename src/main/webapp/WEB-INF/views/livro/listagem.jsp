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
    <title>Listagem de Livro</title>
</head>
<body>
<h1>Listagem de Livro</h1>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>titulo</th>
        <th>preço</th>
        <th>dataEstimada</th>
        <th>sumario</th>
        <th>autor</th>
    </thead>
    <tbody>
    <c:forEach var="livro" items="${livros}">
        <tr>
            <td>${livro.id}</td>
            <td>${livro.titulo}</td>
            <td>${livro.preco}</td>
            <td>${livro.dataEstimada}</td>
            <td>${livro.sumario}</td>
            <td>${livro.autor}</td>
        </tr>
    </c:forEach>
    </tbody>

    </table>

    <a href="/livro/cadastro">Cadastrar Livro</a>



</body>
</html>
