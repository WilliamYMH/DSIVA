<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link href="css/ufps.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<title>Agregar Evento</title>
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
                <a href="index.html" >
                <img href="index.html" src="img/horizontal_logo.png" width="240"/> </a>
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

<div class="ufps-container-fluid" >        
       


        <section id="information">
            <h2>Registrar Nuevo Evento</h2>

        <form  class="contact_form" action="eventoController" method="post" style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom:1%;">
        <div id="registro">
            <ul>
                
                <li>
                    <label for="lineaInvestigacion">Nombre del evento*: </label>
                    <input type="text" name="nombreEvento" placeholder="" required />
                </li>
                <li>
                    <label for="lineaInvestigacion">Caracter del evento*: </label>
                    <input type="text" name="caracterEvento" placeholder="" required />
                </li>
               
                <li>
                    <label for="liderLinea">Fecha de realizzacion *: </label>
                     <input type="date" name="Fecha" placeholder="" required />
                </li>
                 <li>
                    <label for="liderLinea">Responzable *: </label>
                     <input type="text" name="Responzable" placeholder="" required />
                </li>
                <li>
                    <label for="liderLinea">Institucion *: </label>
                     <input type="text" name="Institucion" placeholder="" required />
                </li>
                
                <li>
                    <label for="liderLinea">Entidades *: </label>
                     <input type="text" name="Entidades" placeholder="" required>
                </li>
                 <li>
                    <label for="liderLinea">Progreso *: </label>
                     <input type="number" name="pogreso" min="1" max="10" style="border: none;">
                </li>
              <button class="ufps-btn" type="submit" >Registrar Evento</button>
                
            </ul>
        </div>
    </form>


    </section>

    </div>

    <div class="ufps-footer" style="  " >
    <h3>Universidad Francisco de Paula Santander</h3>
    <p>Programa Ingeniería de Sistemas</p>
    <p>Cucuta, Norte de Santander</p>

</div>  

    <!--Algunos componentes requieren el uso de la librería en javascript-->
</body>
</html>