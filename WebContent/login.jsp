<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link href="css/login.css" rel="stylesheet">
		<title>Vicerrectoria</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row no-gutter">
			<div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
			<div class="col-md-9 col-lg-6">



				<div class="login d-flex align-items-center">


					<div class="container">

						<div class="row">
							<div class="col align-items-center">
								<center>
									<img id="logo_login" src="img/horizontal_logo.png"
										class="img-fluid" alt="Responsive image"></img>
								</center>
								<br />
								<br />
								<br />
								<br />
							</div>

						</div>
						<div class="row">
							<div class="col-md-9 col-lg-8 mx-auto">
								<form method="post" action="LoginController">
									<div class="form-label-group">
										<input name="email" type="email" id="inputEmail"
											class="form-control" placeholder="Email address" required
											autofocus> <label for="inputEmail">Email
												address</label>
									</div>

									<div class="form-label-group">
										<input name="password" type="password" id="inputPassword"
											class="form-control" placeholder="Password" required>
											<label for="inputPassword">Password</label>
									</div>

									<div class="custom-control custom-checkbox mb-3">
										<input type="checkbox" class="custom-control-input"
											id="customCheck1"> <label
											class="custom-control-label" for="customCheck1">Recordar
												contraseña</label>
									</div>
									<button type="submit"
										class="btn btn-lg btn-danger btn-block btn-login text-uppercase font-weight-bold mb-2">Iniciar
										sesion</button>
								</form>
								<div class="text-center">
									<a class="small" href="#" style="color: #d9534f"
										data-toggle="modal" data-target="#exampleModal">Olvidaste
										la contraseña?</a>
								</div>
								<div class="text-center">
									<a class="small" href="#" style="color: #d9534f"
										data-toggle="modal" data-target="#ModalRegistro">¡
										Registra tu grupo de investigacion !</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Se te enviara
						un correo para restablecer la contraseña.</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">

							<label class="col-form-label">Digita tu correo
								electronico:</label> <input type="email" class="form-control"
								placeholder="Email address" required autofocus>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-danger">Enviar</button>

						</div>
					</form>

				</div>


			</div>
		</div>
	</div>

	<div class="modal fade" id="ModalRegistro" tabindex="-1" role="dialog"
		aria-labelledby="ModalRegistroLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg	" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="ModalRegistroLabel">Registro de
						grupo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<div class="container-fluid">
					
					
						<div class="form-group">
						<form method="post" action="RegistroController">
							<jsp:useBean id="departamentoDao" class="model.DepartamentoDao" scope="request"> 
</jsp:useBean>
							
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Nombre del grupo *: </label>

									</div>
									<div class="col-md-7 .ml-auto">
										<input type="text" class="form-control" placeholder=""
											name="nombreGrupo" required autofocus>
									</div>
								</div></br>
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Departamento *: </label>
									</div>
									<div class="col-md-7 .ml-auto">
										<select class="custom-select" name="departamento"
											id="departamento">


											<c:forEach items="${departamentoDao.list()}" var="item">
												<option value="${item.idDepartamento}">${item.nombre}</option>
											</c:forEach>
										</select>
									</div>

								</div></br>
								
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Nombre del director *: </label>

									</div>
									<div class="col-md-7 .ml-auto">
										<input type="text" class="form-control" placeholder=""
											name="nombre_director" required >
									</div>
								</div></br>
								
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Apellido del director *: </label>

									</div>
									<div class="col-md-7 .ml-auto">
										<input type="text" class="form-control" placeholder=""
											name="apellido_director" required >
									</div>
								</div></br>
								
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Cedula del director *: </label>

									</div>
									<div class="col-md-7 .ml-auto">
										<input type="text" class="form-control" placeholder=""
											name="cedula" required >
									</div>
								</div></br>
								
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Correo electronico *: </label>

									</div>
									<div class="col-md-7 .ml-auto">
										<input name="email_director" type="email" class="form-control"
								placeholder="Email address" required>
									</div>
								</div></br>
								
								<div class="row">
									<div class="col-md-5 ">
										<label class="col-form-label">Contraseña *: </label>
	
									</div>
									<div class="col-md-7 .ml-auto">
										<input name="password" type="password" class="form-control"
								placeholder="" required>
									</div>
								</div>
								
								
						
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-danger">Enviar</button>

						</div>
						</form>
						</div>
				
</div>
				</div>


			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/f_modal.js"></script>


</body>
</html>