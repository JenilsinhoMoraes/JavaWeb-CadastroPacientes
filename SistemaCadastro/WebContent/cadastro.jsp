<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.PacienteDAO" %>
<%@ page import = "java.util.ArrayList" %>

<%
	ArrayList<PacienteDAO> lista = (ArrayList<PacienteDAO>) request.getAttribute("listar");

%>
    
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Pessoas</title>
<link rel = "icon" href = "imagens/icone.png">
<link rel = "stylesheet" href = "style.css">
</head>

<body>
<div align="center">
	<img src = "imagens/logo.png">
	<h1>Início</h1>
	<a href ="cadastrar.html" class = "Botao1" >Novo cadastro</a>
	<a href = "report" class = "Botao2">Relatório</a>
	<a href = "index.html" class = "Botao2">Voltar</a>

	<script src = "scripts/confirmar.js"></script>
</div>
</body>
</html>