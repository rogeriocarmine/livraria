<%--
  Created by IntelliJ IDEA.
  User: rogeriocarmine
  Date: 12/10/2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Autor</title>
</head>
<body>
<h1>Cadastro de Autor</h1>

<form action="/autor/salvar" method="post">

    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="nome">
    <BR><BR>
    <label for="email">E-mail:</label>
    <input id="email" type="text" name="email">
    <BR><BR>
    <button type="submit">Salvar</button>

</form>

</body>
</html>
