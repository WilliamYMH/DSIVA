<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%request.getSession().setAttribute("pageJS", "informe_gestion.jsp"); %>
<div>

<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#informe" role="tab" aria-controls="lineas"
			aria-selected="true">Informe</a></li>
		<li class="nav-item"><a class="nav-link" id="profile-tab"
			data-toggle="tab" href="#producto" role="tab"
			aria-controls="Participaciones" aria-selected="false">Productos</a></li>
</ul>

<div class="tab-content" id="myTabContent">

		<%
			//INICIO PESTAÑA INFORME
		%>
		
		<div class="tab-pane fade show active" id="informe" role="tabpanel"
			aria-labelledby="home-tab">
			<br /> <br />
			
			<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Se muestran
						todos los proyectos del grupo de investigación
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Objetivo</th>
										<th>Fecha de inicio</th>
										<th>Fecha estimada de cierre</th>
										<th>Linea de investigacion</th>
										<th>porcentaje de avance</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${lineasDeInvestigacion}">
										<c:forEach var="item2" items="${item.proyectos}">
											<tr class="odd gradeA">
												<td><c:out value="${item2.proyecto }" /></td>
												<td><c:out value="${item2.objetivo}" /></td>
												<td><c:out value="${1900+item2.fechaInicio.getYear()}-${item2.fechaInicio.getMonth()}-${item2.fechaInicio.getDay()}" /></td>
												<td><c:out value="${item2.fechaFin}" /></td>
												<td><c:out value="${item.lineaInvesrigacion}" /></td>
												<td><c:out value="${item2.porcentaje}" /></td>
											</tr>
										</c:forEach>

									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
			<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Participación en Dirección de Trabajo de Grado y/o Tesis
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre del proyecto</th>
										<th>Estudiante lider</th>
										<th>Director del proyecto</th>
										<th>Nivel Academico</th>
										<th>Progreso</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${direccionProyectos}">
										<tr class="odd gradeA">
											<td><c:out value="${item.tituloPro}" /></td>
											<td><c:out value="${item.nombreEstudiante}" /></td>
											<td><c:out value="${item.director}" /></td>
											<td><c:out value="${item.nivelAcademico.toString()}" /></td>
											<td><c:out value="${item.porcentaje}" /></td>

										</tr>
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
				<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Organización de Eventos de Investigación / Científicos
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre del evento</th>
										<th>Caracter</th>
										<th>Responsable</th>
										<th>Progreso</th>
										<th>Fecha del evento</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${eventos}">										
											<tr class="odd gradeA">
												<td><c:out value="${item.nombre }" /></td>
												<td><c:out value="${item.caracter}" /></td>
												<td><c:out value="${item.responsable}" /></td>
												<td><c:out value="${item.porcentaje}" /></td>
												<td><c:out value="${1900+item.fecha.getYear()}-${item.fecha.getMonth()}-${item.fecha.getDay()}" /></td>
											</tr>										
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
				
				<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Otras Actividades de Investigación 
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre de la actividad</th>
										<th>Responsable</th>
										<th>Progreso</th>
										<th>Fecha de la actividad</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${otrasActividades}">										
											<tr class="odd gradeA">
												<td><c:out value="${item.nombre }"/></td>
												<td><c:out value="${item.responsable}"/></td>
												<td><c:out value="${item.porcentaje}"/></td>												
												<td><c:out value="${1900+item.fecha.getYear()}-${item.fecha.getMonth()}-${item.fecha.getDay()}"/></td>
											</tr>										
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
				
				<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Se muestran
						todos los productos obtenidos por el grupo de investigación
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Descripcion</th>
										<th>Responsable</th>
										<th>Fecha</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${productos}">
										
											<tr class="odd gradeA">
												<td><c:out value="${item.nombre}" /></td>
												<td><c:out value="${item.descripcion}" /></td>
												<td><c:out value="${item.responsable}" /></td>
												<td><c:out value="${1900+item.fecha.getYear()}-${item.fecha}-${item.fecha.getDay()}" /></td>
												
											</tr>
										
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
			
			
		</div>
		
		<%
			//FIN PESTAÑA INFORME
		%>
		
		<%
			//INICIO PESTAÑA PRODUCTO
		%>
		
		<div class="tab-pane fade" id="producto" role="tabpanel"
			aria-labelledby="contact-tab">
			<br /> <br />
			<c:if test="${productoActualizado==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="productoActualizado" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> A continuación describa los productos obtenidos por el grupo de investigación en el semestre actual, según lo establecido en el Acuerdo N° 056 de 2012.
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="productoController">

							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del producto</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreProducto" required>
								</div>

								<div class="col-md-6 mb-1">
									<label for="objetivo">Descripcion</label>
									<input class="form-control" id="descripcion" name="descripcion" ></input>

								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha: </label> <input
										type="date" class="form-control" name="fecha" required>
										
								</div>
							
								<div class="col-md-6 mb-3">
									<label for="linea">Proyecto a la que
										pertenece el producto</label> <select class="custom-select"
										name="id_proyecto" id="linea_invest">
										<option value="0">Ninguno</option>

										<c:forEach items="${proyectos}" var="item">
											<option value="${item.idProyecto}">${item.proyecto}</option>
										</c:forEach>
									</select>
								</div>
								</div>
								<div class="row">
								
								
								<div class="col-md-6 mb-3">
									<label for="linea">Actividad a la que
										pertenece el producto</label> <select class="custom-select"
										name="id_actividad" id="linea_invest">
										<option value="0">Ninguna</option>

										<c:forEach items="${otrasActividades}" var="item">
											<option value="${item.idOtraActividad}">${item.nombre}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6 mb-3">
								<label>&nbsp;</label></br>
									<button class="btn btn-primary" type="submit">Agregar</button>
								
								</div>
							</div>
							<input type="hidden" name="tipoPostProducto" value="add"/>
							
								
						</form>
					</div>
				</div>
			</div>
			<%//------------------ %>
			<hr/>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus productos obtenidos por el grupo de investigación
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="productoController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
								
									<label for="linea">Elija el producto a editar</label> 
									<select class="custom-select"
										name="id_producto" id="productos">										
										<c:forEach items="${productos}" var="item">										
									<option value="${item.idProducto}">${item.nombre}</option>
										</c:forEach>																				
									</select>
								
								
								<input type="hidden" name="tipoPostProducto" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras el producto que tengas seleccionado
								
								</div>
								
								</div>
								
								</form>
								
								<c:if test="${productoUpdate!=null}">
								
								<form action="productoController" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Ingrese el nuevo nombre del producto: <c:out value="${productoUpdate.nombre}"></c:out></label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreProducto" value="${productoUpdate.nombre}" required>
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Descripcion</label>
									<input class="form-control" id="descripcion" name="descripcion" value="${productoUpdate.descripcion}"></name>

								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha: </label> <input value="${productoUpdate.fecha}" type="date" class="form-control" name="fecha" required>
										
								</div>
							
							
								<div class="col-md-6 mb-3">
									<label for="linea">Proyecto a la que
										pertenece el producto</label> <select class="custom-select"
										name="id_proyecto" id="linea_invest">
										<option value="0">Ninguno</option>

										<c:forEach items="${proyectos}" var="item">
											<option value="${item.idProyecto}">${item.proyecto}</option>
										</c:forEach>
									</select>
								</div>
								</div>
								<div class="row">
								
								<div class="col-md-6 mb-3">
									<label for="linea">Actividad a la que
										pertenece el producto</label> <select class="custom-select"
										name="id_actividad" id="linea_invest">
										<option value="0">Ninguna</option>

										<c:forEach items="${otrasActividades}" var="item">
											<option value="${item.idOtraActividad}">${item.nombre}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6 mb-3">
								<label>&nbsp;</label></br>
									<button class="btn btn-primary" type="submit">Actualizar</button>
								</div>
								</div>
								

							<input type="hidden" name="tipoPostProducto" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									
									</form>
							
									<form action="productoController" method="post">
									<input type="hidden" name="tipoPostProducto" value="delete"/>
									<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras el producto que hayas seleccionado
								</form>
								</c:if>
								</div>
								
								
					
					</div>
				</div>
			</br> </br>
			<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Se muestran
						todos los productos obtenidos por el grupo de investigación
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Descripcion</th>
										<th>Responsable</th>
										<th>Fecha</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${productos}">
										
											<tr class="odd gradeA">
												<td><c:out value="${item.nombre}" /></td>
												<td><c:out value="${item.descripcion}" /></td>
												<td><c:out value="${item.responsable}" /></td>
												<td><c:out value="${1900+item.fecha.getYear()}-${item.fecha}-${item.fecha.getDay()}" /></td>
												
											</tr>
										
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
		</div>
		
		<%
			//FIN PESTAÑA PRODUCTO
		%>

</div>
</div>