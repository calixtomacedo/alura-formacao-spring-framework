<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Curso Java Servlet: Fundamentos da programação web Java</title>
	</head>
	
	<body>
		
		<h4>Lista com os links para testes</h4>
		
		<c:if test="${!empty user}">
			<p> 
				Bem vindo ao sistema: ${user.nome} - <a href="${pageContext.request.contextPath}/controller?action=usuarioLogout">SAIR</a>
			</p>
		</c:if>
		
		<ul>
			<li style="padding: 0px 0px 20px 0px">Área aberta
				<ul>
					<li><a href="${pageContext.request.contextPath}/welcome">Welcome</a></li>
					<li><a href="${pageContext.request.contextPath}/sayHello">Say Hello</a></li>
				</ul>
			</li>
			
			<li>Área restrita
				<ul>
					<li><a href="${pageContext.request.contextPath}/controller?action=empresaForm">Cadastrar Empresa</a></li>		
					<li><a href="${pageContext.request.contextPath}/controller?action=empresaList">Listar Empresas</a></li>		
				</ul>
			</li>
		</ul>
	
	</body>
</html>