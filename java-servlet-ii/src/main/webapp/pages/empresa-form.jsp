<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:url value="/empresa?action=create" var="create" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastro de Empresas</title>
	</head>
	
	<body>
		
		<form action="${create}" method="post">
			<div>
				<label>Nome da Empresa:</label>
				<input type="text" name="nome" id="text-nome" />
			</div>
			
			<br />
			<div>
				<label>Data da Abertura:</label>
				<input type="text" name="dataabertura" id="text-dataabertura" />
			</div>
			
			<div>
				<input type="submit" value="Enviar" />				
			</div>
		
		</form>
	</body>
</html>