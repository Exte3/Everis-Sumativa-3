<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmar Venta</title>
</head>
<body>
	<div>
		
			<h1>Carrito de Compra</h1>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Caracteristica</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${lista_productos}">
					<tr>
						<td><c:out value="${producto.id}" /></td>
						<td><c:out value="${producto.nombre}" /></td>
						<td><c:out value="${producto.precio}" /></td>
						<td><c:out value="${producto.caracteristica}" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		<form action="/venta/carrito" method="post">	
			<input type="submit" value="Realizar Compra">
		</form>
	</div>
</body>
</html>