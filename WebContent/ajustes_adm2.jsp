<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="page-inner">
    <div class="row">
        <div class="col-md-12">
         <h2>AJUSTES</h2> 
         <br/>   
         <h5><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Modifica los ajustes de tu cuenta</h5>

     </div>
 </div>
 <!-- /. ROW  -->
 <hr />
 <br/>

<div class="panel panel-default">
    <div class="panel-heading">
        <i class="fa fa-address-card-o" aria-hidden="true"></i> Modifica tus datos
    </div>
    <div class="panel-body">
        <div class="form-responsive">
              
                <div class="row">
                <form method="post" action="EditarDatosController">
                    <div class="col-md-6 col-mb-3">
                    
                    <label for="email">Ingresa tu nuevo correo</label>

                    <input type="email" class="form-control" id="email" name="email" placeholder="" value=""> 
                     <br> <center><button onclick="notificacion('guardado', '2000')" type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i></button></center>
                
                  </div>
                   
                
                 
                    <div class="col-md-6 mb-3">
                  
                    <label for="password">Si deseas cambiar tu contraseña, ingresa la nueva </label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" placeholder="" value="">
                    <br><center><button onclick="notificacion('guardado', '2000')" type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> </button> </center>
                      
                    </div>
					</form> 
                </div>                 
                  

            
          </div>
    </div>

</div>
<hr>
<div class="panel panel-default">
    <div class="panel-heading">
        <i class="fa fa-pencil-square-o aria-hidden="true"></i> Agrega nuevos administradores
    </div>
    <div class="panel-body">
        <div class="form-responsive">
              <form method="post" action="RegistroAdministradoresController">

       <div class="row">
                  <div class="col-md-6 mb-3">
                    <label for="nombre">Ingresa el nombre del nuevo administrador</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="" value="">                   
                    <!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->

                  </div>

                  <div class="col-md-6 mb-3">
                    <label for="password">Ingresa el apellido</label>
                    <input type="text" class="form-control" id="contraseña" name="apellido" placeholder="" value="">
                    
                  </div>
                </div>
                <div class="mb-3">
                    <br>
                  <label for="cedula">Ingresa el documento de identidad del nuevo administrador</label>
                    <input type="text" class="form-control" id="documento" name="cedula" placeholder="" value="">
                </div>
       <div class="row">
                  <div class="col-md-6 mb-3">
                    <label for="email">Ingresa el email</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="" value="">                   
                    <!-- <div class="invalid-feedback">
                      El nombre es requerido.
                    </div>  -->

                  </div>
                  <div class="col-md-6 mb-3">
                    <label for="password">Ingresa la contraseña </label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" placeholder="" value="">
                    
                  </div>
                </div>
                 <hr>
              <center>  
                  <button class="btn btn-primary" type="submit">Agregar<c:out value=""/></button>
              </center>
                </form>
              </div>
    </div>
  </div>

    
</div>
<!-- Campo de entrada de hora -->




<hr>

<div class="panel panel-default">
    <div class="panel-heading">
        <i class="fa fa-list-alt" aria-hidden="true"></i> Registro de Administradores (Se muestran todos los administradores)
    </div>
    <div class="panel-body">
        <div class="table-responsive">
         <jsp:useBean id="regInt" class="model.AdministradorDao" scope="request">
                        </jsp:useBean>
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Nombre</th>                     
                        <th>Correo</th>
                                          
                     
                    </tr>
                </thead>
                <tbody>
                 <c:forEach var="item" items="${regInt.list()}"> 
                    <tr class="odd gradeA">
							<td>04/12/2018</td>
                    	 <td><c:out value="${item.nombre}"/></td>
                    	 <td><c:out value="${item.email}"/></td>

                    </tr>
                   </c:forEach>
                   


                </tbody>
            </table>
        </div>

    </div>
</div>


