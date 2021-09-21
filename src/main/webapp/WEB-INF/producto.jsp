<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td, form {
		border: 1px solid black;
	}
	
	.forms {
		background-color: #F0FFFF;
		width: 25%;
		padding: 10px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Panel de Productos</title>
</head>
<body>
<h1>AGREGAR PRODUCTOS</h1>
					<a href="/">Atrás</a>
				<form:form action="/producto/crear" method="post" modelAttribute="producto" class="forms">
					<form:label path="nombre">Nombre:</form:label>
					<form:input type="text" path="nombre" /><br>
					
					<form:label path="precio">Precio:</form:label>
					<form:input type="text" path="precio" /><br>

					<form:label path="caracteristica">Caracteristica:</form:label>
					<form:input type="text" path="caracteristica" /><br>

					<form:label path="stock">Stock:</form:label>
					<form:input type="text" path="stock" /><br>


					<input type="submit" value="Crear Producto">
				</form:form>
				<a href="/">Atrás</a>
								<br>
				<c:out value="${error}"></c:out>
				<br>
				<h1>Lista Productos</h1>
				<table>

					<thead>
						<tr>
							<th>#</th>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Caracteristica</th>
							<th>Stock</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producto" items="${lista_productos}">

							<tr>
								<td>
									<c:out value="${producto.id}" />
								</td>
								<td>
									<c:out value="${producto.nombre}" />
								</td>
								<td>
									<c:out value="${producto.precio}" />
								</td>
								<td>
									<c:out value="${producto.caracteristica}" />
								</td>
								<td>
									<c:out value="${producto.stock}" />
								</td>


								<td> <a href="/producto/actualizar/${producto.id}">Editar</a>								
									<form action="/producto/eliminar/${producto.id}" method="POST">
										<input type="hidden" name="_method" value="delete" >
										<input type="submit" value="Eliminar">
									</form>	
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>