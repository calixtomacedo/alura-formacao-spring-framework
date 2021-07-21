<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.cmdev.javaservlet.model.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%
EmpresaAction empresa = (EmpresaAction) request.getAttribute("empresa");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empresa Cadastrada</title>
	</head>
	
	<body>
		
		<c:if test="${!empty empresa}">
			<h2>Empresa Cadastrada</h2>
			<ul>
				<li>
				<!-- Scriptlet
					<%= empresa.getNome() %> - <%= empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) %>
				 -->
				
				<!--  Expression Language -->
				 ${empresa.getNome()} - <fmt:formatDate value="${empresa.getDataAbertura()}" pattern="dd/MM/yyyy" /> - ${empresa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))}
				</li>
			</ul>
		</c:if> 
		<c:if test="${empty empresa}">
			<h2>Nenhuma empresa cadastrada!</h2>
		</c:if> 
		
	</body>
</html>