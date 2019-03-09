<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Historial de informes</h2> 
                     <br/>  
                        <h5><i class="fa fa-pencil" aria-hidden="true"></i> Consulta los planes e informes de semestres anteriores</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
               
            <div class="row" >
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-list-alt" aria-hidden="true"></i> 
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                            		<jsp:useBean id="rSemestreAct" class="model.GrupoieDao" scope="request">
                        </jsp:useBean>
                                <table class="table table-striped table-bordered table-hover table text-center" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Año</th>
                                            <th>Semestre</th>
                                            <th><center>Grupo de Investigacion</center></th>
                                            <th><center>Informe de gestion</center></th>
                                            <th><center>Plan de accion</center></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${rSemestreAct.list()}"> 
                                   
                                      <tr class="odd gradeA">
                                        	<td>2018</td>
                                        	<td>II</td>
                                            <td><c:out value="${item.nombre}"/></td>
                                            <td><center><button id="but_reg" class="ufps-btn"> <a href="#" style="color:white; text-decoration: none; ">Informe de gestión</a></button></center></td>
                                            <td><center><button class="ufps-btn ufps-btn-yellow" id="but_reg"> <a  href="#" style="color:white; text-decoration: none; ">Plan de acción</a></button></center></td>
                                       
                                        </tr>
                                    
                                    </c:forEach>
                                                                                                                                                            
                                        </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
            <div class="row">
             <!-- /. PAGE INNER  -->
            </div>

         <!-- /. PAGE WRAPPER  -->
        </div>