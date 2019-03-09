<?xml version="1.0" encoding="ISO-8859-1" ?>
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
              <form method="post" action="EditarDatosController">
                <div class="row">
                    <div class="col-md-6 col-mb-3">
                    <label for="nombre">Ingresa tu nuevo correo</label>

                    <input type="email" class="form-control" id="email" name="email" placeholder="" value=""> 
                     <br> <center><button onclick="notificacion('guardado', '2000')" type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i></button></center>
                  </div>
                   
                
                 
                    <div class="col-md-6 mb-3">
                
                    <label for="password">Si deseas cambiar tu contraseña, ingresa la nueva </label>
                    <input type="password" class="form-control" id="contraseña" name="contraseña" placeholder="" value=""><br><center><button onclick="notificacion('guardado', '2000')" type="submit" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> </button> </center>
                    </div>

                </div>                 
                  

              </form>
          </div>
    </div>

</div>
<hr>


    
</div>
<!-- Campo de entrada de hora -->









</div>
