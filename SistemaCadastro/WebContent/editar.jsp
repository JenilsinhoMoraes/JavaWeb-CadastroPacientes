<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de pessoas - Editar</title>
<link rel="icon" href="imagens/icone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar cadastro</h1>
	<form name="frmnovocadastro" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="sus" class="Caixa2"
					value="<%out.print(request.getAttribute("sus"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="tipo" class="Caixa2"
					value="<%out.print(request.getAttribute("tipo"));%>"></td>
			</tr>
			
			<tr>
				<td><input type="date" name="data_nasc" class="Caixa1"
					value="<%out.print(request.getAttribute("data_nasc"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" placeholder="Fone" maxlength = "11" class = "Caixa2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		<a href = "index.html" class = "Botao1">Cancelar</a>
	</form>
	<script src="scripts/validator.js"></script>
</body>
</html>