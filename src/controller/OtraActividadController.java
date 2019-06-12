package controller;

import java.io.IOException; 
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GrupoieDao;
import model.OtraactividadDao;
import negocio.Grupoie;
import negocio.Otraactividad;

/**
 * Servlet implementation class actividadController
 */
@WebServlet("/actividadController")
public class OtraActividadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtraActividadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoPost = request.getParameter("tipoPostActividad");
		if(tipoPost.equals("add")){
			String nombre = request.getParameter("nombre");
			String responsable = request.getParameter("responsable");		
			String progreso = request.getParameter("progreso");		
			String fecha[] = (request.getParameter("fecha").split("-"));
			Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
			Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
			OtraactividadDao oDao = new OtraactividadDao();
			Otraactividad otraActividad = new Otraactividad();
			otraActividad.setNombre(nombre);
			otraActividad.setResponsable(responsable);
			otraActividad.setFecha(datefin);
			otraActividad.setPorcentaje(Integer.valueOf(progreso));
			otraActividad.setGrupoie(aux);
			oDao.insert(otraActividad);
			
			aux= new GrupoieDao().find(aux.getIdGrupoIE());
			aux.addOtraactividad(otraActividad);
			//System.out.println(aux.getLineainvesrigacions().size()+" - TAMANIO LINEAS");
			
			request.getSession().setAttribute("actividadActualizada", 1);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			
				request.getSession().setAttribute("otrasActividades", aux.getOtraactividads());
				request.getSession().setAttribute("grupoIE", aux);
				response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
				response.setDateHeader("Expires", 0);
				response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else if(tipoPost.equals("update1")){

			int idOtraActividad = Integer.parseInt(request.getParameter("id_Otraactividad"));
			OtraactividadDao otraActividadDao = new OtraactividadDao();
			Otraactividad linea = otraActividadDao.find(idOtraActividad);
			request.getSession().setAttribute("otraActividadUpdate", linea);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}else if(tipoPost.equals("update2")){
			String nombre = request.getParameter("nombre");
			String responsable = request.getParameter("responsable");		
			//String producto = request.getParameter("producto");
			String progreso = request.getParameter("progreso");		
			String fecha[] = (request.getParameter("fechaInicio").split("-"));
			Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
			Otraactividad otraActividad = (Otraactividad)request.getSession().getAttribute("otraActividadUpdate");
			otraActividad.setNombre(nombre);
			otraActividad.setResponsable(responsable);
			otraActividad.setFecha(datefin);
			otraActividad.setPorcentaje(Integer.valueOf(progreso));
			
			new OtraactividadDao().update(otraActividad);
			request.getSession().setAttribute("otraActividadUpdate", null);
			 
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			 request.getSession().setAttribute("actividadActualizada", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else{
			Otraactividad otraActividad = (Otraactividad)request.getSession().getAttribute("otraActividadUpdate");
			new OtraactividadDao().delete(otraActividad);
			
			Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
			aux= new GrupoieDao().find(aux.getIdGrupoIE());
			aux.removeOtraactividad(otraActividad);
			request.getSession().setAttribute("otrasActividades", aux.getOtraactividads());
			request.getSession().setAttribute("grupoIE", aux);
			
			
			request.getSession().setAttribute("otraActividadUpdate", null);			
			//request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");			
			 request.getSession().setAttribute("actividadActualizada", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}
		

		
	}

}
