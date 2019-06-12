<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Vicerrectoria</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/sidebar.css">
   

    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

    <!-- Font Awesome JS -->
    <script src="https://use.fontawesome.com/4a0c8877dc.js"></script>
</head>

<body>

<%	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //http 1.1
response.setHeader("Pragma", "no-cache"); //http 1.0
response.setHeader("Expires", "0"); //proxies

%>
<c:if test="${user==null}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>&nbsp;&nbsp;<i class="fa fa-user-circle-o" aria-hidden="true"></i>
                <c:out value="${user.getNombre()}"> </c:out>
               </h3>
                
            </div>

            <ul class="list-unstyled components">
                <li>
                    <a href="#planSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        <i class="fa fa-pencil-square-o"></i>
                        Plan de acción
                    </a>
                    <ul class="collapse list-unstyled" id="planSubmenu">
                      <li>
                     
                        
                            <a href="#" data-seleccion="plan_accion_director_new">Editar</a>
                        </li>
                        <li>
                            <a href="#">Descargar pdf</a>
                        </li>
                       
                    </ul>
                </li>
                <li>
                    <a href="#informeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        <i class="fa fa-file-text"></i>
                       Informe de gestión
                    </a>
                    <ul class="collapse list-unstyled" id="informeSubmenu">
                        <li>
                            <a href="#" data-seleccion="informe_gestion">Ver</a>
                        </li>
                        <li>
                            <a href="#">Descargar pdf</a>
                        </li>
                       
                    </ul>
                    <li class="active">
                        <a href="#" data-seleccion="historial_informes_dir_integr">
                            <i class="fa fa-folder-open"></i>
                            Historial
                        </a>
                    </li>
                </li>
                <li>
                    <a href="#ajustesSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                        <i class="fa fa-cogs"></i>
                       Ajustes
                    </a>
                    <ul class="collapse list-unstyled" id="ajustesSubmenu">
                        <li>
                            <a href="#"  data-seleccion="ajustes_integr">Modificar datos</a>
                        </li>
                      
                       
                    </ul>
                </li>
                <li>            
                <form method="post" action="LogoutController" id="logout">
                
                </form>
                         
                       <a href="#" onclick="document.getElementById('logout').submit();" >
                        <i class="fa fa-power-off"></i>
                       Salir
                    </a>
                    
                </li>
                
            </ul>

            
        </nav>
        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-danger">
                        <i class="fa fa-align-left"></i>
                        <span>UFPS</span>
                    </button>
                    <div class="btn btn-dark d-inline-block d-lg-none ml-auto">
                       
                    </div>

                    <img id="logo_login" src="img/horizontal_logo.png" width="230" height="180"
										class="img-fluid" alt="Responsive image"></img>
                </div>
            </nav>  
<div id="cont">


            
        </div>
        </div>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
	      </script>
        <script type="text/javascript" src="js/f_sidebar.js"></script>   
	  <script type="text/javascript" src="js/funct.js">
    </script>
   
    <script type="text/javascript">
        $(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar, #content').toggleClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
   
</script>
<script>
      $( window ).on( "load", function() {
    	  var pag = "${pageJS}";
         $("#cont").load(pag);    
    });        
  </script>
</body>
</html>