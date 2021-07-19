<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.PacienteDAO" %>
<%@ page import = "java.util.ArrayList" %>

<%
	ArrayList<PacienteDAO> lista2 = (ArrayList<PacienteDAO>) request.getAttribute("listar3");

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
	<h1>Lista de Aniversariantes do Dia</h1>
	<a href = "index.html" class = "Botao1">Voltar</a>
	<table id = "tabela1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Sus</th>
				<th>Tipo</th>
				<th>Data de Nascimento</th>
				<th>Telefone</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista2.size(); i++){ %>
				<tr>
					<td><%=lista2.get(i).getId()%></td>
					<td><%=lista2.get(i).getNome()%></td>
					<td><%=lista2.get(i).getSus()%></td>
					<td><%=lista2.get(i).getTipo()%></td>
					<td><%=lista2.get(i).getData_nasc()%></td>
					<td><%=lista2.get(i).getFone()%></td>
																
				</tr>
			
			<%} %>
		
		</tbody>
						
	</table>
</div>
</body>
</html>