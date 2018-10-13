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
    <title>Detalhe de Livro: ${livro.titulo}</title>
</head>
<body>
<a href="/home">Página Inicial</a>
<br>
<h1>Detalhe de Livro: ${livro.titulo}</h1>
<h2>Autor:${livro.autor.nome}</h2>

<br>Sumário: ${livro.sumario}
<br>Preço: ${livro.preco}
<br>Data Estimada: ${livro.getDataEstimadaString()}
<br>

</body>
</html>
