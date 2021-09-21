<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Venta</title>
</head>
	<body>
		<div>
		
			<h4 class="text-danger">
					<c:out value="${error}"></c:out>
				</h4>
			
		
		
				<form:form action="/venta/modificar" method="post" modelAttribute="venta">
					<input type="hidden" name="_method" value="put" >
					<form:hidden path="id"/>

					<form:label path="id_usuario">ID Usuario:</form:label>
					<form:input type="text" path="id_usuario" /><br>
					
					<form:label path="id_producto">ID Producto:</form:label>
					<form:input type="text" path="id_producto" /><br>
					
					<form:label path="direccion_envio">Dirección Envío:</form:label>
					<form:input type="text" path="direccion_envio" /><br>

					<form:label path="cantidad">Cantidad:</form:label>
					<form:input type="text" path="cantidad" /><br>

					<form:label path="total">Total:</form:label>
					<form:input type="text" path="total" /><br>


					<input type="submit" value="Modificar">
				</form:form>

		</div>
	</body>
</html>