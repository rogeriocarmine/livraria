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
    <title>Página Home da Casa do Código - Simulação</title>
</head>
<body>
<h1>Página Home da Casa do Código - Simulação</h1>

<h2>Lançamento de Livros</h2>

<table border="1" cellpadding="4" cellspacing="0">
    <thead>
    <tr>
        <th>titulo</th>
        <th>preço</th>
        <th>dataEstimada</th>
        <th>sumario</th>
        <th>autor</th>
    </thead>
    <tbody>
    <c:forEach var="recente" items="${livrosRecentes}">
        <tr>
            <td><a href="/livro/${recente.id}/detalhe">${recente.titulo}</a></td>
            <td>${recente.preco}</td>
            <td>${recente.getDataEstimadaString()}</td>
            <td>${recente.sumario}</td>
            <td>${recente.autor.nome}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>

<h2>Todos os Livros</h2>

<table border="1" cellpadding="4" cellspacing="0">
    <thead>
    <tr>
        <th>titulo</th>
        <th>preço</th>
        <th>dataEstimada</th>
        <th>sumario</th>
        <th>autor</th>
    </thead>
    <tbody>
    <c:forEach var="livro" items="${livros}">
        <tr>
            <td><a href="/livro/${livro.id}/detalhe">${livro.titulo}</a></td>
            <td>${livro.preco}</td>
            <td>${livro.getDataEstimadaString()}</td>
            <td>${livro.sumario}</td>
            <td>${livro.autor.nome}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


    <BR>
    <a href="/livro/cadastrar">Cadastrar Livro</a>



</body>
</html>
