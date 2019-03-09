<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!--Metaetiqueta para el uso del conjunto de caracteres adecuado-->
    <meta charset="utf-8">
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <!--Metaetiqueta para corregir compatibilidad con navegador Microsft-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Metaetiqueta para la correcta visualización en dispositivos moviles-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
    <title>Vicerrectoria</title>
    <!--Añada primero el estilo de la libreria (ufps.css o ufps.min.css) y luego sus estilos propios-->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="css/ufps.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!--Librerías para compatibilidad con versiones antiguas de Internet Explorer-->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <header>
	
 <div class="ufps-navbar-light" id="menu">
         <div class="ufps-container-fluid">
             <div class="ufps-navbar-brand">
                 <div class="ufps-btn-menu" onclick="toggleMenu('menu')">
                     <div class="ufps-btn-menu-bar"> </div>
                     <div class="ufps-btn-menu-bar"> </div>
                     <div class="ufps-btn-menu-bar"> </div>
                </div>
                <a href="login.jsp" >
                <img href="login.jsp" src="img/horizontal_logo.png" width="240"/> </a>
             </div>
            
             <div class="ufps-navbar-right">
                 <div class="ufps-navbar-corporate">
                     <img src="img/logo_ingsistemas.png" alt="Logo ingeniería de sistemas">
                     <img src="img/logo_ufps_inverted.png" alt="Logo UFPS">
                 </div>
             </div>

         </div>
 </div>
    </header>

<div id="container">

        <br/>
        <br/>
       


        <section id="information">

        <form  class="contact_form"  method="post" action="RegistroController">
        	<jsp:useBean id="departamentoDao" class="model.DepartamentoDao" scope="request"> 
</jsp:useBean>
        <div id="registro">
        
            <ul>
                
                <li>
                    <label for="name_grupo">Nombre del grupo de Investigacion *: </label>
                    <input name="nombreGrupo" type="text" placeholder="" required />
                </li>
               
               
              <li>
    
                    <label for="name_departamento">Departamento *: </label>
                    <select placeholder="departamento" name="departamento" id="departamento">
                   
                    
                     <c:forEach items="${departamentoDao.list()}" var="item">
                        <option value="${item.idDepartamento}">${item.nombre}</option>
                        </c:forEach>
                    </select>
                </li>
              <li>
                    <label for="nombre_director">Nombres del director del grupo *: </label>
                    <input name="nombre_director" type="text" placeholder="" required />
                </li>
                <li>
                    <label for="apellido_director">Apellidos del director del grupo *: </label>
                    <input name="apellido_director" type="text" placeholder="" required />
                </li>
                <li>
                    <label for="cedula">Numero de cedula del director del grupo *: </label>
                    <input name="cedula" type="text" placeholder="" required />
                </li>
                <li>
                    <label for="email_director">email *: </label>
                    <input name="email_director" type="email" placeholder="example@example.com" required />
                </li>

                <li>
                    <label for="password">Contraseña *: </label>
                    <input name="password" type="password" placeholder="***" required />
                </li>
             
               
                

            </ul>
        </div>
      
       <div id="but">
       <center>
       <button id="boton" type="submit" class="btn btn-danger">Solicitar aprobacion</button>
       </center> 
       </div>
       
    </form>


    </section>

    </div>

    <div class="ufps-footer">
    <h3>Universidad Francisco de Paula Santander</h3>
    <p>Programa Ingeniería de Sistemas</p>
    <p>Cucuta, Norte de Santander</p>

</div>  
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!--Algunos componentes requieren el uso de la librería en javascript-->
    <script src="js/ufps.min.js"></script>
</body>
</html>