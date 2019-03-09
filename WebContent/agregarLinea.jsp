<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/ufps.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<title>Agregar Linea</title>
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
            <h2>Registrar Nueva Linea</h2>

        <form  class="contact_form" action="lineaController" method="post"  style="box-shadow: 0px 0px 5px 1px black; margin: 1%; padding-bottom:1%;">
        <div id="registro">
            <ul>
            
               <% 
               
               session = request.getSession(true);
       		request.getSession().setAttribute("sesion1", "hola");
               
               %>
	
                <li>
                    <label for="lineaInvestigacion">Nombre de la Linea de Investigacion *: </label>
                    <input type="text" name="nombreLinea" placeholder="" required />
                </li>
               
                <li>
                    <label for="liderLinea">Lider de la linea de Investigacion *: </label>
                     <input type="text" name="lider" placeholder="" required />
                </li>
              <button class="ufps-btn" type="submit" >Registrar Linea</button>
                
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