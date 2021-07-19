<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.PacienteDAO" %>
<%@ page import = "java.util.ArrayList" %>

<%
	ArrayList<PacienteDAO> lista1 = (ArrayList<PacienteDAO>) request.getAttribute("listar2");

%>
    
<!DOCTYPE html>
<html lang = "pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Pessoas</title>
<link rel = "icon" href = "imagens/icone.png">
<link rel = "stylesheet" href = "style.css">
</head>

<body>
<div align="center">
	<img src = "imagens/logo.png">
	<h1>Lista de Cadastros</h1>
	<a href = "index.html" class = "Botao1">Voltar</a>
	<table id = "tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Sus</th>
				<th>Tipo</th>
				<th>Data de Nascimento</th>
				<th>Telefone</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista1.size(); i++){ %>
				<tr>
					<td><%=lista1.get(i).getId()%></td>
					<td><%=lista1.get(i).getNome()%></td>
					<td><%=lista1.get(i).getSus()%></td>
					<td><%=lista1.get(i).getTipo()%></td>
					<td><%=lista1.get(i).getData_nasc()%></td>
					<td><%=lista1.get(i).getFone()%></td>
					
					<td>
					<a href = "select?id=<%=lista1.get(i).getId()%>" class = "Botao1">Editar</a>
					<a href = "javascript: confirmar(<%=lista1.get(i).getId()%>)" class = "Botao2">Excluir</a>
					</td>
										
				</tr>
			
			<%} %>
		
		</tbody>
		
		
		
		
		
	</table>
	<script src = "scripts/confirmar.js"></script>
</div>
</body>
</html>