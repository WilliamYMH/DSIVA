<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
  <h1>Solicitudes pendientes</h1>
  <jsp:useBean id="rSoli" class="model.SolicitudDao" scope="request">
                        </jsp:useBean>
            <table class="ufps-table ufps-text-left">
    <thead>
        <th>Nombre del grupo</th>
        <th>Director</th>
        <th>Facultad</th>
        <th>Departamento</th>
        <th>Aprobar</th>
    </thead>
    <tbody>
     <c:forEach var="item" items="${rSoli.list()}"> 
    	<tr>
       <td><c:out value="${item.getDirector().getGrupodirectors().get(getGrupodirectors().size()-1).grupoie.nombre}"/></td>
       <td><c:out value="${item.getDirector().nombre}"/></td>
        <td><c:out value="${item.getDirector().getGrupodirectors().get(getGrupodirectors().size()-1).grupoie.departamento.facultad.nombre}"/></td>
        <td><c:out value="${item.getDirector().getGrupodirectors().get(getGrupodirectors().size()-1).grupoie.departamento.nombre}"/></td>
        <td><input type="checkbox" name="transporte" value="">&nbsp;
           
    </tr>
    </c:forEach>
    </tbody>
    

</table>            
<button class="ufps-btn" onclick="openModal('modal')">Guardar</button>
<div id="modal" class="ufps-modal">
    <div class="ufps-modal-content">
        <div class="ufps-modal-header">
            <span class="ufps-modal-close">×</span>
            <h2>Alerta</h2>
        </div>
        <div class="ufps-modal-body">
            <p>Si sobreescribe estos datos, no podrá recuperar la información anterior.</p>
            <p>¿Está seguro qué desea realizar esta acción?</p>
            <a href="#" class="ufps-btn ufps-btn-green">Guardar</a>  
        </div>
        <div class="ufps-modal-footer">
            <h3>UFPS-Vicerrectoria</h3>
         </div>
     </div>
</div>
        