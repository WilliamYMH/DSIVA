<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp"); %>

<div>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#linea" role="tab" aria-controls="lineas"
			aria-selected="true">Lineas de investigacion</a></li>
		<li class="nav-item"><a class="nav-link" id="profile-tab"
			data-toggle="tab" href="#profile" role="tab"
			aria-controls="Participaciones" aria-selected="false">Participación
				en proyectos de grado</a></li>
		<li class="nav-item"><a class="nav-link" id="contact1-tab"
			data-toggle="tab" href="#contact" role="tab"
			aria-controls="Organizacion_de_eventos" aria-selected="false">Organización
				de eventos</a></li>
		<li class="nav-item"><a class="nav-link" id="contact2-tab"
			data-toggle="tab" href="#otrasAct" role="tab"
			aria-controls="Otras_actividades" aria-selected="false">Otras
				actividades</a></li>
		</li>
		<li class="nav-item"><a class="nav-link" id="contact3-tab"
			data-toggle="tab" href="#proyectos" role="tab"
			aria-controls="proyectos" aria-selected="false">Proyectos</a></li>
	</ul>

	<div class="tab-content" id="myTabContent">

		<%
			//INICIO PESTAÑA LINEA DE INVESTIGACION
		%>
		
		<div class="tab-pane fade show active" id="linea" role="tabpanel"
			aria-labelledby="home-tab">
			<br /> <br />
			<c:if test="${lineaActualizada==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="lineaActualizada" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega
					nuevas lineas de investigación
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="lineaController">

							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre de la linea de investigación</label>
									<input type="text" class="form-control" id="nombreLinea"
										name="nombreLinea" required> <!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label for="password">Nombre del lider de la linea</label> <input
										type="text" class="form-control" id="lider" name="lider"
										required>
								</div>
							</div>

							<input type="hidden" name="tipoPostLinea" value="add"/>
							<hr>
								<center>
									<button class="btn btn-primary" type="submit">
										Agregar
										
									</button>
								</center>
						</form>
					</div>
				</div>
			</div>
			
			<%//------------------ %>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus lineas de investigación
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="lineaController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
							
									<label for="linea">Elija la linea de investigación a editar</label> 
									<select class="custom-select"
										name="linea_invest" id="linea_invest">


										<c:forEach items="${lineasDeInvestigacion}" var="item">
											<option value="${item.idLineaInvesrigacion}">${item.lineaInvesrigacion}</option>
										</c:forEach>
									</select>
								
								
								<input type="hidden" name="tipoPostLinea" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras la linea que tengas seleccionada
							
								</div>
								
								</div>
								
								</form>
								
								
								<c:if test="${lineaUpdate!=null}">
								<form action="lineaController" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Ingrese el nuevo nombre de: &nbsp;<c:out value="${lineaUpdate.lineaInvesrigacion}"></c:out></label>
									<input type="text" class="form-control" id="nombreLinea"
										name="nombreLinea" value="${lineaUpdate.lineaInvesrigacion}" required>
								</div>

								<div class="col-md-6 mb-3">
									<label for="password">Ingrese el nombre del nuevo lider</label> 
									<input type="text" class="form-control" id="lider" name="lider" value="${lineaUpdate.liderLinea}"required>
								</div>
							</div>
							<input type="hidden" name="tipoPostLinea" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									<button class="btn btn-primary" type="submit">Actualizar</button>
									</form>
							
							
							
									<form action="lineaController" method="post">
									<input type="hidden" name="tipoPostLinea" value="delete"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras la linea
								</form>
								
								
								</c:if>
								</div>
								
								
					
					</div>
				</div>
			

			</br>
			<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Se muestran
						todas las lineas de investigación del grupo
					</div>
					</br>


					<div class="panel-body">

						<div class="table-responsive">

							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Fecha de creacion</th>
										<th>Nombre</th>
										<th>Lider de la linea</th>


									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${lineasDeInvestigacion}">
										<tr class="odd gradeA">
											<td><c:out
													value="${1900+item.fecha.getYear()}-${item.fecha.getMonth()+1}-${item.fecha.getDay()}" /></td>
											<td><c:out value="${item.lineaInvesrigacion}" /></td>
											<td><c:out value="${item.liderLinea}" /></td>


										</tr>
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>
				</div>
				<hr />
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-info-circle" aria-hidden="true"></i> Para agregar
						proyectos a las lineas de investigacion dirijase a la pestaña de
						proyectos&nbsp; <a href="#contact3-tab"> <i
							class="fa fa-arrow-up" aria-hidden="true"></i>

						</a>

					</div>

				</div>
		</div>


		<%
			// -----FIN DE PESTAÑA LINEAS DE INVESTIGACION -----
		%>

		<%
			// -----INICIO PARTICIPACION EN PROYECTOS -----
		%>

		<div class="tab-pane fade" id="profile" role="tabpanel"
			aria-labelledby="profile-tab">
			
			<br /> <br />
			<c:if test="${direccionProyectosActualizada==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="direccionProyectosActualizada" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega
					participaciones en proyectos de grado
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="direccionProyectosController">

							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del proyecto</label>
									<input type="text" class="form-control" id="nombreLinea"
										name="nombreProyecto" required>
								</div>

								<div class="col-md-6 mb-3">
									<label>Estudiante lider del proyecto</label> <input
										type="text" class="form-control" id="lider" name="nombreEstudiante"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
								<jsp:useBean id="departamentoDao" class="model.DepartamentoDao"
									scope="request">
								</jsp:useBean>
									<label for="nombre">Departamento al que pertenece el proyecto</label>
									<select class="custom-select" name="id_departamento"
											id="departamento">
											<c:forEach items="${departamentoDao.list()}" var="item">
												<option value="${item.idDepartamento}">${item.nombre}</option>
											</c:forEach>
										</select>
								</div>

								<div class="col-md-6 mb-3">
									<label>Progreso del proyecto</label>
									<input type="number" class="form-control" name="progreso" min="1" max="10">
								</div>
							</div>
							<div class="row">
							<div class="col-md-6 mb-3">
							<label>Nivel academico del proyecto</label>
								<select class="custom-select" name="id_nivelAcademico"
											id="departamento">
											<option value="Pregrado">Pregrado</option>
											<option value="Especializacion">Especializacion</option>
											<option value="Maestria">Maestria</option>
											<option value="Doctorado">Doctorado</option>
											</select>
							</div>
							<div class="col-md-6 mb-3">
							<label>Nombre del director de proyecto</label> 
							<input type="text" class="form-control" id="lider" name="nombreDirector" required>
							</div>
							</div>

							<input type="hidden" name="tipoPostDireccionProyectos" value="add"/>
							<hr>
								<center>
									<button class="btn btn-primary" type="submit">
										Agregar
									</button>
								</center>
						</form>
					</div>
				</div>
			</div>
			
			<%//------------------ %>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus participaciones en proyectos de grado
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="direccionProyectosController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
							
									<label for="linea">Elija el proyecto de grado a editar</label> 
									<select class="custom-select"
										name="Id_direccion_proyecto" id="Id_direccion_proyecto">


										<c:forEach items="${direccionProyectos}" var="item">
											<option value="${item.idDireccionPro}">${item.tituloPro}</option>
										</c:forEach>
									</select>
								
								
								<input type="hidden" name="tipoPostDireccionProyectos" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras el proyecto que tengas seleccionado
							
								</div>
								
								</div>
								
								</form>
								
								
								<c:if test="${DireccionProyectoUpdate!=null}">
								<form action="direccionProyectosController" method="post">
								<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del proyecto</label>
									<input type="text" class="form-control" id="nombreLinea"
										name="nombreProyecto" value="${DireccionProyectoUpdate.tituloPro}" required>
								</div>

								<div class="col-md-6 mb-3">
									<label>Estudiante lider del proyecto</label> <input
										type="text" class="form-control" id="lider" name="nombreEstudiante"
										value="${DireccionProyectoUpdate.nombreEstudiante}"required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
								<jsp:useBean id="departamentoDao2" class="model.DepartamentoDao"
									scope="request">
								</jsp:useBean>
									<label for="nombre">Departamento al que pertenece el proyecto</label>
									<select class="custom-select" name="id_departamento"
											id="departamento">
											<c:forEach items="${departamentoDao2.list()}" var="item">
												<option value="${item.idDepartamento}">${item.nombre}</option>
											</c:forEach>
										</select>
								</div>

								<div class="col-md-6 mb-3">
									<label>Progreso del proyecto</label>
									<input value="${DireccionProyectoUpdate.porcentaje}" type="number" class="form-control" name="progreso" min="1" max="10">
								</div>
							</div>
							<div class="row">
							<div class="col-md-6 mb-3">
							<label>Nivel academico del proyecto</label>
								<select class="custom-select" name="id_nivelAcademico"
											id="departamento">
											<option value="Pregrado">Pregrado</option>
											<option value="Especializacion">Especializacion</option>
											<option value="Maestria">Maestria</option>
											<option value="Doctorado">Doctorado</option>
											</select>
							</div>
							<div class="col-md-6 mb-3">
							<label>Nombre del director de proyecto</label> 
							<input value="${DireccionProyectoUpdate.director}"type="text" class="form-control" id="lider" name="nombreDirector" required>
							</div>
							</div>

							<input type="hidden" name="tipoPostDireccionProyectos" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									<button class="btn btn-primary" type="submit">Actualizar</button>
									</form>
							
							
							
									<form action="direccionProyectosController" method="post">
									<input type="hidden" name="tipoPostDireccionProyectos" value="delete"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras la linea
								</form>
								
								
								</c:if>
								</div>
								
								
					
					</div>
				</div>
			

			</br>
			<hr>
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-list-alt" aria-hidden="true"></i> Se muestran
						todos los proyectos de grado a cargo del grupo
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
				<hr />
			</div>

		<%
			// -----FIN PESTAÑA PARTICIPACION EN PROYECTOS -----
		%>

		<%
			// -----INICIO ORGANIZACION DE EVENTOS -----
		%>

		<div class="tab-pane fade" id="contact" role="tabpanel"
			aria-labelledby="contact-tab">
			<br></br>
			<c:if test="${eventoActualizado==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="eventoActualizado" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega
					nuevos eventos
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="eventoController">
<input type="hidden" name="tipoPostEvento" value="add"/>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del evento</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreEvento" required> <!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Caracter del evento</label> <input
										type="text" class="form-control" id="objetivo" name="caracterEvento"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha del evento</label> <input
										type="date" class="form-control" name="fecha" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label >Progreso del evento</label>
									<input
										type="number" class="form-control" name="progreso" min="1"
										max="10" required>
								</div>
							</div>
							<div class="row">
								
								<div class="col-md-6 mb-3">
									<label>Nombre del responsable</label> <input
										type="text" class="form-control" name="Responsable" required>
								</div>
								<div class="col-md-6 mb-3">
								<label>&nbsp;</label>
								<center>
									<button class="btn btn-primary" type="submit">Agregar</button>
								</center>
								</div>
							</div>
							
							
								
						</form>
					</div>
				</div>
			</div>
			<%//------------------ %>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus eventos
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="eventoController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
							
									<label for="linea">Elija el evento a editar</label> 
									<select class="custom-select"
										name="evento_id" id="evento_id">


										
										<c:forEach items="${eventos}" var="item">										
										<option value="${item.idEvento}">${item.nombre}</option>											
										</c:forEach>
									</select>
								
								
								<input type="hidden" name="tipoPostEvento" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras el evento que tengas seleccionado
								
								</div>
								
								</div>
								
								</form>
								
								<c:if test="${eventoUpdate!=null}">
								
								<form action="eventoController" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del evento</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreEvento" value="${eventoUpdate.nombre}" required>
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Caracter del evento</label> <input
										type="text" class="form-control" id="objetivo" name="caracterEvento" value="${eventoUpdate.caracter}"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha del evento</label> <input
										type="date" class="form-control" name="fecha" value="${eventoUpdate.fecha}" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label >Progreso del evento</label>
									<input
										type="number" class="form-control" name="progreso" min="1"
										max="10" value="${eventoUpdate.porcentaje}" required>
								</div>
							</div>
							<div class="row">
								
								<div class="col-md-6 mb-3">
									<label>Nombre del responsable</label> <input
										type="text" class="form-control" name="Responsable" value="${eventoUpdate.responsable}" required>
								</div>

							</div>
							<input type="hidden" name="tipoPostEvento" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									<button class="btn btn-primary" type="submit">Actualizar</button>
									</form>
							
									<form action="eventoController" method="post">
									<input type="hidden" name="tipoPostEvento" value="delete"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras el proyecto
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
						todos los eventos
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
			
			</div>
		

		<%
			// -----FIN ORGANIZACION DE EVENTOS -----
		%>

		<%
			// -----INICIO OTRAS ACTIVIDADES -----
		%>
		<div class="tab-pane fade" id="otrasAct" role="tabpanel"
			aria-labelledby="contact-tab">
			<br></br>
			<c:if test="${actividadActualizada==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="actividadActualizada" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega
					nuevas actividades
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="actividadController">
<input type="hidden" name="tipoPostActividad" value="add"/>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre de la actividad</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombre" required> 
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">responsable de la actividad</label> <input
										type="text" class="form-control" id="objetivo" name="responsable"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha de la actividad</label> <input
										type="date" class="form-control" name="fecha" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label >Progreso de la actividad</label>
									<input
										type="number" class="form-control" name="progreso" min="1"
										max="10" required>
								</div>
							</div>										
								<center>
									<button class="btn btn-primary" type="submit">Agregar</button>
								</center>																								
						</form>
					</div>
				</div>
			</div>
			<%//------------------ %>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus actividades
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="actividadController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
							
									<label for="linea">Elija la actividad a editar</label> 
									<select class="custom-select"
										name="id_Otraactividad" id="id_Otraactividad">


										
										<c:forEach items="${otrasActividades}" var="item">										
										<option value="${item.idOtraActividad}">${item.nombre}</option>											
										</c:forEach>
									</select>
								
								
								<input type="hidden" name="tipoPostActividad" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras la actividad que tengas seleccionada
								
								</div>
								
								</div>
								
								</form>
								
								<c:if test="${otraActividadUpdate!=null}">
								
								<form action="actividadController" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre de la actividad</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombre" value="${otraActividadUpdate.nombre}" required> 
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">responsable de la actividad</label> <input
										type="text" class="form-control" id="objetivo" name="responsable" value="${otraActividadUpdate.responsable}"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha de la actividad</label> <input
										type="date" class="form-control" name="fecha" value="${otraActividadUpdate.fecha}" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label >Progreso de la actividad</label>
									<input
										type="number" class="form-control" name="progreso" min="1"
										max="10" value="${otraActividadUpdate.porcentaje}"required>
								</div>
							</div>	
							<input type="hidden" name="tipoPostActividad" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									<button class="btn btn-primary" type="submit">Actualizar</button>
									</form>
							
									<form action="actividadController" method="post">
									<input type="hidden" name="tipoPostActividad" value="delete"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras el proyecto
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
						todas las actividades
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
		</div>
		<%
			// -----FIN PESTAÑA OTRAS ACTIVIDADES -----
		%>

		<%
			// -----INICIO PESTAÑA PROYECTOS -----
		%>
		<div class="tab-pane fade" id="proyectos" role="tabpanel"
			aria-labelledby="proyecto-tab">
			<br /> <br />
			<c:if test="${proyectoActualizado==1}">
								
									<div class="alert alert-success alert-dismissible fade show"
										role="alert">
										Datos actualizados
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
			<c:set var="proyectoActualizado" scope="session" value="0">
	</c:set>
									
</c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega
					nuevos proyectos
				</div>
				</br>

				<div class="panel-body">
					<div class="form-responsive">
						<form method="post" action="proyectoController">

							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nombre del proyecto</label> <input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreProyecto" required> <!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Objetivo del proyecto</label> <input
										type="text" class="form-control" id="objetivo" name="objetivo"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Fecha de inicio del proyecto</label> <input
										type="date" class="form-control" name="fechaInicio" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">fecha de terminacion del proyecto</label>
									<input type="date" class="form-control" name="fechaFin"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="linea">Linea de investigacion a la que
										pertenece el proyecto</label> <select class="custom-select"
										name="linea_invest" id="linea_invest">


										<c:forEach items="${lineasDeInvestigacion}" var="item">
											<option value="${item.idLineaInvesrigacion}">${item.lineaInvesrigacion}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6 mb-3">
									<label for="liderLinea">Progreso del proyecto</label> <input
										type="number" class="form-control" name="progreso" min="1"
										max="10">
								</div>

							</div>
							<input type="hidden" name="tipoPostProyecto" value="add"/>
							<hr>
								<center>
									<button class="btn btn-primary" type="submit">Agregar</button>
								</center>
						</form>
					</div>
				</div>
			</div>
			<%//------------------ %>
			<hr>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-pencil-square-o aria-hidden="true"></i> Edita tus proyectos de investigación
				</div>
				</br>
 
				<div class="panel-body">
					<div class="form-responsive">
						
						</br>
						<form method="post" action="proyectoController">
							<div class="row">
							
							<div class="col-md-6 mb-3">
							
									<label for="linea">Elija el proyecto de investigación a editar</label> 
									<select class="custom-select"
										name="proyectos_invest" id="proyectos_invest">


										
										<c:forEach items="${lineasDeInvestigacion}" var="item">
										<c:forEach var="item2" items="${item.proyectos}">
										<option value="${item2.idProyecto}">${item2.proyecto}</option>
										</c:forEach>
											
										</c:forEach>
									</select>
								
								
								<input type="hidden" name="tipoPostProyecto" value="update1"/>
								
								<label>&nbsp;</label><br>
								
								</div>
								
								
								<div class="col-md-4-mb-2">
								
							
								<label>&nbsp;</label><br>
								<button class="btn btn-info" type="submit">Editar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Editaras el proyecto que tengas seleccionado
								
								</div>
								
								</div>
								
								</form>
								
								<c:if test="${proyectoUpdate!=null}">
								
								<form action="proyectoController" method="post">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Ingresa el nuevo nombre del proyecto:&nbsp;&nbsp;<c:out value="${proyectoUpdate.proyecto}"></c:out></label> 
									<input
										type="text" class="form-control" id="nombreProyecto"
										name="nombreProyecto" value="${proyectoUpdate.proyecto}"required>
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Objetivo del proyecto</label> <input
										type="text" class="form-control" id="objetivo" name="objetivo" value="${proyectoUpdate.objetivo}"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="nombre">Nueva fecha de inicio del proyecto</label> <input
										type="date" class="form-control" name="fechaInicio" value="${proyectoUpdate.fechaInicio}" required>
										<!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->
								</div>

								<div class="col-md-6 mb-3">
									<label for="objetivo">Nueva fecha de terminacion del proyecto</label>
									<input type="date" class="form-control" name="fechaFin" value="${proyectoUpdate.fechaFin}"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="linea">Linea de investigacion a la que
										pertenece el proyecto</label> <select class="custom-select"
										name="linea_invest" id="linea_invest">
										<option value="${proyectoUpdate.lineainvesrigacion.idLineaInvesrigacion}"><c:out value="${proyectoUpdate.lineainvesrigacion.lineaInvesrigacion}"></c:out></option>

										<c:forEach items="${lineasDeInvestigacion}" var="item">
										<c:if test="${item.idLineaInvesrigacion!=proyectoUpdate.lineainvesrigacion.idLineaInvesrigacion}">
											<option value="${item.idLineaInvesrigacion}">${item.lineaInvesrigacion}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6 mb-3">
									<label for="liderLinea">Progreso del proyecto</label> <input
										type="number" class="form-control" name="progreso" min="1"
										max="10" value="${proyectoUpdate.porcentaje}">
								</div>

							</div>
							<input type="hidden" name="tipoPostProyecto" value="update2"/>
								
								
							<div class="row" style="width: 500px; margin: 0 auto;"">
							
							
									<button class="btn btn-primary" type="submit">Actualizar</button>
									</form>
							
									<form action="proyectoController" method="post">
									<input type="hidden" name="tipoPostProyecto" value="delete"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" type="submit">Eliminar</button>
								&nbsp;<i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;Eliminaras el proyecto
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
		</div>
		<%
			// -----FIN PESTAÑA PROYECTOS -----
		%>


	</div>
</div>