<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/controller" var="servletController" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Empresa</title>
</head>

<body>
	
	<c:if test="${!empty user}">
		<p> 
			Bem vindo ao sistema: ${user.nome} - <a href="${pageContext.request.contextPath}/controller?action=usuarioLogout">SAIR</a>
		</p>
	</c:if>

	<form action="${servletController}" method="post">
		<input type="hidden" name="action" value="empresaSave" id="text-save" />
		<input type="hidden" name="id" value="${empresa.id}" id="hidden_id">
		
		<div>
			<label>Nome da Empresa:</label>
			<input type="text" name="nome" value="${empresa.nome}" id="text-nome" />
		</div>

		<br />
		<div>
			<label>Data da Abertura:</label> 
			<input type="text" name="dataabertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"></fmt:formatDate>" id="text-dataabertura" />
		</div>

		<div>
			<input type="submit" value="Salvar" />
		</div>

	</form>
</body>
</html>