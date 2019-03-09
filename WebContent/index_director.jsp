<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!--Metaetiqueta para el uso del conjunto de caracteres adecuado-->
    <meta charset="utf-8">
    <!--Metaetiqueta para corregir compatibilidad con navegador Microsft-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--Metaetiqueta para la correcta visualización en dispositivos moviles-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
    <title>Vicerrectoria</title>
    <!--Añada primero el estilo de la libreria (ufps.css o ufps.min.css) y luego sus estilos propios-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="css/ufps.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
       <!-- Latest compiled and minified CSS -->

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
      <div id="section"> 
        <div class="slider">
            <ul>
                <li>
                    <img src="http://cr00.epimg.net/emisora/imagenes/2018/06/25/cucuta/1529923470_053591_1529924536_noticia_normal.jpg" alt="">
                </li>
                <li>
                    <img src="http://1.bp.blogspot.com/-9nHgz-lEXtI/VUfkuHCkGAI/AAAAAAAAAAw/vgoIAkpoPr0/s1600/ufps.jpg" alt="">
                </li>
                <li>
                    <img src="https://divisist2.ufps.edu.co/assets/img/bg/19.jpg" alt="">
                </li>
                <li>
                    <img src="http://1.bp.blogspot.com/-ciYDAmxa0Ko/Ur0LIFNOyCI/AAAAAAAADAY/SmU1Kfp4S8M/s1600/DSC_0021+(2).JPG" alt="">
                </li>
            </ul>
        </div>
        </div>


            <aside  id="aside" class="main">

                <div class="login-form">
                    <h1>Director</h1>
                    <div class="head">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Emblem-person-red.svg/120px-Emblem-person-red.svg.png" alt=""/>
                    </div>
                    <div class="ufps-accordion">
                        <button class="ufps-btn-accordion">Planes e Informes</button>
                        <div class="ufps-accordion-panel">
                           <button onclick="window.location.href='plan_de_accion_act.jsp'" class="ufps-btn2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plan de Accion Actual</button>
<button onclick="window.location.href='informe_de_gestion_act.jsp'" class="ufps-btn2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Informe de Gestion Actual</button>                            <button data-seleccion="historial_informes_dir_integr" class="ufps-btn2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Historial</button>
                        </div>
                        
                        <button class="ufps-btn2" data-seleccion="ajustes_dir">Ajustes</button>
                       <button onclick="window.location.href='login.jsp'" class="ufps-btn2" >Salir</button>

                    </div> 
                </div>
            </aside>
</div>  
        

        <div class="ufps-footer">
            <h3>Universidad Francisco de Paula Santander</h3>
            <p>Programa Ingeniería de Sistemas</p>
            <p>Cucuta, Norte de Santander</p>

        </div> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
    
               <script src="js/ufps.min.js"></script>  

       
<script src="https://use.fontawesome.com/4a0c8877dc.js"></script>
              
        <script type="text/javascript" src="js/funct.js"></script>

</body>
</html>