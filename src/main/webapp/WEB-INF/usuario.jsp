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
<title>Index Usuario</title>
</head>
<body>
<div>
<!--<h1>Panel de Usuarios</h1>
				<a href="/">Atrás</a>
				
				<form:form action="/usuario/crear" method="post" modelAttribute="usuario" class="forms" >
					<h3>Ingresar Nuevo Usuario</h3>
					<form:label path="nombre">Nombre:</form:label>
					<form:input type="text" path="nombre" /><br>

					<form:label path="apellido">Apellido:</form:label>
					<form:input type="text" path="apellido" /><br>

					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email" /><br>


					<input type="submit" value="Crear Usuario">
				</form:form> -->
				<c:out value="${error}"></c:out>
				<br>
				<a href="/">Atrás</a>
				<br>
				<h1>Lista de Usuarios</h1>
				<table>

					<thead>
						<tr>
							<th>#</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Email</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${lista_usuarios}">

							<tr>
								<td>
									<c:out value="${usuario.id}" />
								</td>
								<td>
									<c:out value="${usuario.nombre}" />
								</td>
								<td>
									<c:out value="${usuario.apellido}" />
								</td>
								<td>
									<c:out value="${usuario.email}" />
								</td>


								<td> <a href="/usuario/actualizar/${usuario.id}">Editar</a>								
									<form action="/usuario/eliminar/${usuario.id}" method="POST">
										<input type="hidden" name="_method" value="delete" >
										<input type="submit" value="Eliminar">
									</form>	
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</div>
</body>
</html>