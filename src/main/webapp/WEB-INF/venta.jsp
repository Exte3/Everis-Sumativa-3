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
<title>Panel de Ventas</title>
</head>
<body>
<h1>Registrar Venta</h1>
				<a href="/">Atrás</a>
				<form:form action="/venta/crear" method="post" modelAttribute="venta" class="forms">
					
					<!--<label for="usuarios">Seleccione el Cliente:</label>
					<select name="usuario">
						<c:forEach var="usuario" items="${lista_usuarios}" >
							<option value="<c:out value="${usuario.id}" />"> <c:out value="${usuario.nombre}" /> <c:out value="${usuario.apellido}" /></option>
						</c:forEach>
					</select>
					<br>-->
					
					
					<!--<form:label path="direccion_envio">Dirección Envío:</form:label>
					<form:input type="text" path="direccion_envio" /><br>-->		
					
					<label for="productos">Seleccione Los Productos:</label>
					<br>
					<select name="productos" multiple>
						<c:forEach var="producto" items="${lista_productos}">
							<option value="<c:out value="${producto.id}" />"> <c:out value="${producto.nombre}" /> $<c:out value="${producto.precio}" /></option>
						</c:forEach>
					</select>
					
					<br>
					<input type="submit" value="Generar Venta">
				</form:form>
				<br>
				
				<c:out value="${error}"></c:out>
			
				
				
				<a href="/">Atrás</a>
				<h1>Listado de ventas globales</h1>
				<table>

					<thead>
						<tr>
							<th>#</th>
							<th>Nombre Cliente</th>
							<th>Dirección envío</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="venta" items="${lista_ventas}">

							<tr>
								<td>
									<c:out value="${venta.id}" />
								</td>
								<td>
									<c:out value="${venta.usuario.nombre}  ${venta.usuario.apellido}" />
								</td>
								
								
								<td>
									<c:out value="${venta.direccion_envio}" />
								</td>
								

								<td> 								
									<form action="/venta/eliminar/${venta.id}" method="POST">
										<input type="hidden" name="_method" value="delete" >
										<input type="submit" value="Eliminar">
									</form>	
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<form action="usuario/logout">
					<input type="submit" value="Salir">
				</form>	
</body>
</html>