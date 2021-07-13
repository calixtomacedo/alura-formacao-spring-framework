<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="br.com.cmdev.javaservlet.model.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<th>Data da Abertura</th>
			<th>Data Cadastro</th>
		</tr>
		<c:forEach var="empresa" items="${empresas}">
			<tr>
				<td><c:out value="${empresa.nome}"></c:out></td>
				<td><fmt:formatDate value="${empresa.dataAbertura}"
						pattern="dd/MM/yyyy"></fmt:formatDate></td>
				<td>${empresa.dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>