<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:url value="/controller" var="servletController" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	
	<body style="padding: 20px 0px 0px 60px">
		
		<c:if test="${!empty msgLogin}">
			<p>${msgLogin}</p>
		</c:if>
		
		<p>Acessar a área restrita</p>
		
		<form action="${servletController}" method="post">
			<input type="hidden" name="action" value="usuarioLogin" id="text-login" />
			<div>
				<label>Login:</label>
				<input type="text" name="login" id="text-login" />
			</div>
			
			<br />
			<div>
				<label>Senha:</label>
				<input type="password" name="senha" id="text-senha" />
			</div>
			
			<br />
			<div>
				<input type="submit" value="ENTRAR" />				
			</div>
		
		</form>
	</body>
</html>