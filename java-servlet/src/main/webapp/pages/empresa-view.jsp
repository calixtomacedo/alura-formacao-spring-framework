<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.cmdev.javaservlet.model.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Empresa empresa = (Empresa) request.getAttribute("empresa");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empresa Cadastrada</title>
	</head>
	
	<body>
		
		<h2>Empresa Cadastrada</h2>
	
		<ul>
			<li>
				<%= empresa.getNome() %> - <%= empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) %>
			</li>
		</ul>
	</body>
</html>