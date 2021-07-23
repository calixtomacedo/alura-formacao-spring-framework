<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.cmdev.javaservletii.web.model.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/controller?action=empresaEdit" var="edit" />
<c:url value="/controller?action=empresaDelete" var="delete" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresa</title>
</head>
<body>
	
		<c:if test="${!empty user}">
			<p> 
				Bem vindo ao sistema: ${user.nome} - <a href="${pageContext.request.contextPath}/controller?action=usuarioLogout">SAIR</a>
			</p>
		</c:if>
	
	<table border="1" style="width: 500px">
		<caption>Lista de Empresa</caption>
		<tr>
			<th>Nome</th>
			<th>Data da Abertura</th>
			<th>Data Cadastro</th>
			<th colspan="2">&nbsp;</th>
		</tr>
		<c:forEach var="empresa" items="${empresas}">
			<tr>
				<td><c:out value="${empresa.nome}"></c:out></td>
				<td><fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
				<td><fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yyyy HH:mm:ss"></fmt:formatDate></td>
				
				<td>
					<a href="${edit}&id=${empresa.id}">editar</a>
				</td>
				
				<td>
					<a href="${delete}&id=${empresa.id}">Apagar</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>