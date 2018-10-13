<%--
  Created by IntelliJ IDEA.
  User: rogeriocarmine
  Date: 12/10/2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Cadastro de Livro</title>
</head>
<body>
<h1>Cadastro de Alterado</h1>

<c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.livroForm']}"/>

<form action="/livro/salvar" method="post">

    <label for="titulo">titulo:</label>
    <input id="titulo" type="text" name="titulo" value="${form.titulo}">
    <c:forEach items="${bindingResult.getFieldErrors('titulo')}" var="error">
        <span class="text-danger">${error.defaultMessage}</span>
    </c:forEach>
    <BR><BR>
    <label for="preco">preco:</label>
    <input id="preco" type="number" min="0.00" max="10000.00" step="0.01" name="preco" value="${form.preco}">
    <c:forEach items="${bindingResult.getFieldErrors('preco')}" var="error">
        <span class="text-danger">${error.defaultMessage}</span>
    </c:forEach>
    <BR><BR>
    <label for="dataEstimada">dataEstimada:</label>
    <input id="dataEstimada" type="date" name="dataEstimada" value="${form.dataEstimada}">
    <c:forEach items="${bindingResult.getFieldErrors('dataEstimada')}" var="error">
        <span class="text-danger">${error.defaultMessage}</span>
    </c:forEach>
    <BR><BR>
    <label for="sumario">sumario:</label>
    <input id="sumario" type="text" name="sumario" value="${form.sumario}">
    <c:forEach items="${bindingResult.getFieldErrors('sumario')}" var="error">
        <span class="text-danger">${error.defaultMessage}</span>
    </c:forEach>
    <BR><BR>
    <label for="autor">autor:</label>

    <select id="autor" name="autorId">
        <option value="">Selecione um autor</option>
        <c:forEach var="autor" items="${autores}">
            <option value="${autor.id}">${autor.nome}</option>
        </c:forEach>
    </select>
    <c:forEach items="${bindingResult.getFieldErrors('autor')}" var="error">
        <span class="text-danger">${error.defaultMessage}</span>
    </c:forEach>



    <BR><BR>
    <button type="submit">Salvar</button>

</form>

</body>
</html>
