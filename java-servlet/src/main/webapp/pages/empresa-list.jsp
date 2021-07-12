<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.cmdev.javaservlet.model.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Empresa</title>
	</head>
	<body>
		<table border="1" style="width: 500px">
			<caption>Lista de Empresa</caption>
			<tr>
				<th>Nome</th>
				<th>Data Cadastro</th>
			</tr>
			<%
				List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
				for(Empresa empresa : empresas){
			%>
				<tr>
				<td><%= empresa.getNome()%></td>
				<td><%= empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) %></td>
				</tr>
			<% 
				}
			%>
		</table>
	</body>
</html>