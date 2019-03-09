<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="css/ufps.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
		<title>Informe de Gestion</title>
</head>
<body>

	<header>

	<div class="ufps-navbar-light" id="menu">
		<div class="ufps-container-fluid">
			<div class="ufps-navbar-brand">
				<div class="ufps-btn-menu" onclick="toggleMenu('menu')">
					<div class="ufps-btn-menu-bar"></div>
					<div class="ufps-btn-menu-bar"></div>
					<div class="ufps-btn-menu-bar"></div>
				</div>
				<a href="index.html"> <img href="index.html"
					src="img/horizontal_logo.png" width="240" />
				</a>
			</div>

			<div class="ufps-navbar-right">
				<div class="ufps-navbar-corporate">
					<img src="img/logo_ingsistemas.png"
						alt="Logo ingeniería de sistemas"> <img
						src="img/logo_ufps_inverted.png" alt="Logo UFPS">
				</div>
			</div>

		</div>
	</div>
	</header>

	<div class="Contenedor">
		<center>
			<h1>Informe de Gestion del Semestre  Actual</h1>
		</center>
		<!-- Inicio Html encargado de la parte da las Lineas de Investigacion con sus respectivos proyectos-->
		<div class="ufps-container-fluid"
			style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom: 1%;">



			<h2>1. Proyectos de Investigacion</h2>

			<!-- Inicio HTML encargado a la linea de investigacion, por cada linea de investigacion se debe repetir este fragmento de codigo-->
			<div class="ufps-accordion">
				<!-- Html encargado para las tablas de los proyectos de respectiva Linea de investigacion-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">

					<!-- Html encargado para las tablas de los proyectos de respectiva Linea de investigacion-->
					<div
						style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">
						<c:forEach items="${proyectos}" var="item2">
							<formname"paraProyectos">

							<h4>Nombre del proyecto: ${item2.proyecto}</h4>
							<table class="ufps-table ufps-text-left">
								<thead>

									<th>Actividades</th>
									<th>Fecha Inicio</th>
									<th>Fecha Terminacion</th>

									<th>Progreso</th>
								</thead>
								<tr>

									<td><input type="text" name=""
										placeholder="Actividades del proyecto"
										value="${item2.proyecto}" style="border: none;"></td>
									<td><input type="date" name=""
										placeholder="Fecha de inicio del proyecto"
										value="${item2.fechaInicio}" style="border: none;"></td>
									<td><input type="date" name=""
										placeholder="Fecha de fin del proyecto"
										value="${item2.fechaFin}" style="border: none;"></td>
									<td><input type="number" value="${item2.porcentaje}"
										name="quantity" min="1" max="10" style="border: none;"></td>
								</tr>

							</table>


							<button class="ufps-btn" type="submit">Guardar</button>

							</form>
						</c:forEach>
					</div>
					<!-- Fin HTML encargado de los Proyectos-->


				</div>
				<!-- Fin de HTML para la Linea de Ivestigacion-->




			</div>
			<!-- Fin HTML encargado de las lineas De investigacion-->





			<!-- Inicio Html encargado de la parte de la participacion en direccion de proyectos-->
			<div class="ufps-container-fluid"
				style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom: 1%;">



				<h2>2. Participacion en Direccion de Trabajo de Grado y/o Tesis</h2>



				<!-- Html encargado de los diferentes trabajos de grado-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">
					<h4>Tipo de trabajo de Grado : Pregrado</h4>
					<formname"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Titulo del Proyecto</th>
							<th>Nombre del Estudiante</th>
							<th>Director</th>
							<th>Programa Academico</th>
							<th>Institucion</th>
							<th>Progreso</th>
						</thead>
						<c:forEach items="${direccionPregrado}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.tituloPro}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name=""
									value="${item.nombreEstudiante}" disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.director}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.programaAca}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.institucion}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="number" name="quantity"
									value="${item.porcentaje}" min="1" max="10"
									style="border: none;"></td>
							</tr>
						</c:forEach>


					</table>
					<button class="ufps-btn" type="submit">Guardar</button>
					</form>
				</div>
				<!-- Fin HTML encargado de los Trabajos De Grado-->


				<!-- Inicio HTML encargado a la participacion en direccion de proyectos, por cada participacion en direccion de proyectos se debe repetir este fragmento de codigo-->


				<!-- Html encargado de los diferentes trabajos de grado-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">
					<h4>Tipo de trabajo de Grado : Especializacion</h4>
					<formname"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Titulo del Proyecto</th>
							<th>Nombre del Estudiante</th>
							<th>Director</th>
							<th>Programa Academico</th>
							<th>Institucion</th>
							<th>Progreso</th>
						</thead><c:forEach items="${direccionEspecializacion}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.tituloPro}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name=""
									value="${item.nombreEstudiante}" disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.director}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.programaAca}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.institucion}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="number" name="quantity"
									value="${item.porcentaje}" min="1" max="10"
									style="border: none;"></td>
							</tr>
						</c:forEach>
					</table>

					<button class="ufps-btn" type="submit">Guardar</button>


					</form>
				</div>
				<!-- Fin HTML encargado de los Trabajos De Grado-->




				<!-- Inicio HTML encargado a la participacion en direccion de proyectos, por cada participacion en direccion de proyectos se debe repetir este fragmento de codigo-->


				<!-- Html encargado de los diferentes trabajos de grado-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">
					<h4>Tipo de trabajo de Grado : Maestria</h4>
					<formname"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Titulo del Proyecto</th>
							<th>Nombre del Estudiante</th>
							<th>Director</th>
							<th>Programa Academico</th>
							<th>Institucion</th>
							<th>Progreso</th>
						</thead><c:forEach items="${direccionMaestria}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.tituloPro}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name=""
									value="${item.nombreEstudiante}" disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.director}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.programaAca}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.institucion}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="number" name="quantity"
									value="${item.porcentaje}" min="1" max="10"
									style="border: none;"></td>
							</tr>
						</c:forEach>
					</table>

					<button class="ufps-btn" type="submit">Guardar</button>

					</form>
				</div>
				<!-- Fin HTML encargado de los Trabajos De Grado-->


				<!-- Inicio HTML encargado a la participacion en direccion de proyectos, por cada participacion en direccion de proyectos se debe repetir este fragmento de codigo-->


				<!-- Html encargado de los diferentes trabajos de grado-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">
					<h4>Tipo de trabajo de Grado : Doctorado</h4>
					<formname"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Titulo del Proyecto</th>
							<th>Nombre del Estudiante</th>
							<th>Director</th>
							<th>Programa Academico</th>
							<th>Institucion</th>
							<th>Progreso</th>
						</thead>
						<c:forEach items="${direccionDoctorado}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.tituloPro}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name=""
									value="${item.nombreEstudiante}" disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.director}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.programaAca}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="text" name="" value="${item.institucion}"
									disabled="disabled"
									style="border: none; background-color: white;"></td>
								<td><input type="number" name="quantity"
									value="${item.porcentaje}" min="1" max="10"
									style="border: none;"></td>
							</tr>
						</c:forEach>
					</table>
					<button class="ufps-btn" type="submit">Guardar</button>
					</form>
				</div>
				<!-- Fin HTML encargado de los Trabajos De Grado-->
			</div>
			<!-- Fin de HTML para la Participacion en Direccion de Trabajos de Grado-->




			<!-- Inicio Html encargado de la parte de Organización de Eventos de Investigación-->
			<div class="ufps-container-fluid"
				style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom: 1%;">



				<h2>3. Organizacion de Eventos de Investigacion /Cientificos</h2>

				<!-- Inicio HTML encargado a la Organización de Eventos de Investigación, por cada participacion en direccion de Evento se debe repetir este fragmento de codigo-->


				<!-- Html encargado de los diferentes Eventos de grado-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">

					<formname"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Nombre de Evento</th>
							<th>Caracter de Evento</th>
							<th>Fecha de Realizacion</th>
							<th>Progreso</th>

						</thead><c:forEach items="${eventos}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.nombre}" placeholder="Proyecto #1"
									style="border: none;"></td>
								<td><input type="text" name="" value="${item.caracter}"
									placeholder="Pepito perez aldaña" style="border: none;"></td>
								<td><input type="date" name="" value="${item.fecha}" style="border: none;"></td>
								<td><input type="number" name="quantity"
									value="${item.porcentaje}" min="1" max="10"
									style="border: none;"></td>
							</tr>
							</c:forEach>
					</table>


					<button class="ufps-btn" type="submit">Guardar</button>

					</form>
				</div>
				<!-- Fin HTML encargado de los Eventos -->


				<!-- Fin de HTML para la Organización de Eventos de Investigación-->
			</div>


			<!-- Fin HTML encargado de laOrganización de Eventos de Investigación-->

			<!-- Inicio Html encargado de la parte de Organización de Eventos de Investigación-->
			<div class="ufps-container-fluid"
				style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom: 1%;">



				<h2>4. Otras Actividades de Investigacion</h2>

				<!-- Inicio HTML encargado a la Otras Actividades de investigacion, por cada Actividad de investigacion se debe repetir este fragmento de codigo-->


				<!-- Html encargado de los diferentes Actividades de Investigación-->
				<div
					style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding: 1%;">

					<form name"paraProyectos">
					<table class="ufps-table ufps-text-left">
						<thead>
							<th>Nombre de Actividad</th>
							<th>Tipo de envento</th>
							<th>Fecha de Realizacion</th>
							<th>Progreso</th>

						</thead><c:forEach items="${otrasActividades}" var="item">
							<tr>
								<td><input type="text" name="" value="${item.nombre}" placeholder="Proyecto #1"
									style="border: none;"></td>
								<td><input type="text" name="" value="${item.responzable}"
									placeholder="Pepito perez aldaña" style="border: none;"></td>
								<td><input type="date" name="" value="${item.fecha}" style="border: none;"></td>
								<td><input type="text" name="" value="{item.otroproductos.get.nombre}"
									placeholder="Solo numeros Loca" style="border: none;"></td>
							</tr>
							</c:forEach>
					</table>

					<button class="ufps-btn" type="submit">Guardar</button>

					</form>
				</div>
				<!-- Fin HTML encargado de los ACtividades -->

			</div>


	





		</div>
		<!-- Fin de HTML para la Actividades de Investigación-->



		<!-- Fin de HTML para la Actividades de Investigación-->




		<div class="ufps-footer">
			<h3>Universidad Francisco de Paula Santander</h3>
			<p>Programa Ingeniería de Sistemas</p>
			<p>Cucuta, Norte de Santander</p>

		</div>

		<!--Algunos componentes requieren el uso de la librería en javascript-->
		<script src="js/ufps.min.js"></script>
</body>
</html>