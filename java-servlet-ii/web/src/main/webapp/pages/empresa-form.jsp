<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:url value="/controller" var="servletController" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de Empresas</title>
	</head>
	
	<body>
		
		<c:if test="${!empty user}">
			<p> 
				Bem vindo ao sistema: ${user.nome} - <a href="${pageContext.request.contextPath}/controller?action=usuarioLogout">SAIR</a>
			</p>
		</c:if>
		
		<form action="${servletController}" method="post">
			<input type="hidden" name="action" value="empresaCreate" id="text-create" />
			<div>
				<label>Nome da Empresa:</label>
				<input type="text" name="nome" id="text-nome" />
			</div>
			
			<br />
			<div>
				<label>Data da Abertura:</label>
				<input type="text" name="dataabertura" id="text-dataabertura" />
			</div>
			
			<br />
			<div>
				<input type="submit" value="Enviar" />				
			</div>
		
		</form>
	</body>
</html>