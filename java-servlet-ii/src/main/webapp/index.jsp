<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Curso Java Servlet: Fundamentos da programação web Java</title>
	</head>
	
	<body>
		
		<h4>Lista com os links para testes</h4>
		
		<ul>
			<li><a href="${pageContext.request.contextPath}/welcome">Welcome</a></li>
			
			<li><a href="${pageContext.request.contextPath}/empresa?nome=Nova Empresa">doPost: Deve dar erro</a></li>		
			
			<li><a href="${pageContext.request.contextPath}/pages/empresa-form.jsp">doPost: Chama o formulário</a></li>		
	
			<li><a href="${pageContext.request.contextPath}/list">Listar Empresas</a></li>		
			
			<li><a href="${pageContext.request.contextPath}/sayHello">Say Hello</a></li>		
			
		</ul>
		
	</body>
</html>