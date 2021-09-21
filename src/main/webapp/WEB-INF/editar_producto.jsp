<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Producto</title>
</head>
	<body>
		<div>
		
			<h4 class="text-danger">
					<c:out value="${error}"></c:out>
				</h4>
			
		
		
				<form:form action="/producto/modificar" method="post" modelAttribute="producto">
					<input type="hidden" name="_method" value="put" >
					<form:hidden path="id"/>

					<form:label path="nombre">Nombre:</form:label>
					<form:input type="text" path="nombre" /><br>

					<form:label path="precio">Precio:</form:label>
					<form:input type="text" path="precio" /><br>
					
					<form:label path="caracteristica">Caracteristica:</form:label>
					<form:input type="text" path="caracteristica" /><br>

					<form:label path="stock">Stock:</form:label>
					<form:input type="text" path="stock" /><br>


					<input type="submit" value="Modificar">
				</form:form>

		</div>
	</body>
</html>