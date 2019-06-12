package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GrupoieDao;
import model.LineainvesrigacionDao;
import model.OtraactividadDao;
import model.ProyectoDao;
import negocio.Grupoie;
import negocio.Lineainvesrigacion;
import negocio.Otraactividad;
import negocio.Proyecto;

/**
 * Servlet implementation class proyectoController
 */
@WebServlet("/proyectoController")
public class proyectoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public proyectoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoPost = request.getParameter("tipoPostProyecto");

		if (tipoPost.equals("add")) {
			HttpSession session = request.getSession(true);
			String nombreProyecto = request.getParameter("nombreProyecto");
			String objetivo = request.getParameter("objetivo");
			String pogreso = request.getParameter("progreso");
			String fecha1[] = (request.getParameter("fechaInicio").split("-"));
			String fecha[] = (request.getParameter("fechaFin").split("-"));
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			Date datefin = new Date(fecha[0] + "/" + fecha[1] + "/" + fecha[2]);
			Date dateinicio = new Date(fecha1[0] + "/" + fecha1[1] + "/" + fecha1[2]);
			ProyectoDao pDao = new ProyectoDao();
			Proyecto proyecto = new Proyecto();
			proyecto.setDescripcion("");
			proyecto.setFechaFin(datefin);
			proyecto.setFechaInicio(dateinicio);
			proyecto.setObjetivo(objetivo);
			proyecto.setPorcentaje(Integer.parseInt(pogreso));
			
			proyecto.setProyecto(nombreProyecto);

			LineainvesrigacionDao lineaDao = new LineainvesrigacionDao();
			Lineainvesrigacion linea = lineaDao.find(Integer.parseInt(request.getParameter("linea_invest")));
			linea.addProyecto(proyecto);
			proyecto.setResponsable(linea.getLiderLinea());
			// lineaDao.update(linea);

			// proyecto.setLineainvesrigacion(linea);
			pDao.insert(proyecto);
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());

			request.getSession().setAttribute("grupoIE", aux);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else if(tipoPost.equals("update1")){
			Proyecto proyecto = new ProyectoDao().find(Integer.parseInt(request.getParameter("proyectos_invest")));
			request.getSession().setAttribute("proyectoUpdate", proyecto);
			
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");		 
			response.setDateHeader("Expires", 0);
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else if(tipoPost.equals("update2")){
			String nombreProyecto = request.getParameter("nombreProyecto");
			String objetivo = request.getParameter("objetivo");
			String pogreso = request.getParameter("progreso");
			String fecha1[] = (request.getParameter("fechaInicio").split("-"));
			String fecha[] = (request.getParameter("fechaFin").split("-"));
			
			
			Date datefin = new Date(fecha[0] + "/" + fecha[1] + "/" + fecha[2]);
			Date dateinicio = new Date(fecha1[0] + "/" + fecha1[1] + "/" + fecha1[2]);
			
			Proyecto proyecto = (Proyecto)request.getSession().getAttribute("proyectoUpdate");
			ProyectoDao proyectoDao = new ProyectoDao();
			proyecto.setProyecto(nombreProyecto);
			proyecto.setFechaInicio(dateinicio);
			proyecto.setFechaFin(datefin);
			proyecto.setObjetivo(objetivo);
			proyecto.setPorcentaje(Integer.parseInt(pogreso));
			proyecto.setLineainvesrigacion(new LineainvesrigacionDao().find(Integer.parseInt(request.getParameter("linea_invest"))));
			//Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			
			proyectoDao.update(proyecto);
			request.getSession().setAttribute("proyectoUpdate", null);

			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			
			request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
			 request.getSession().setAttribute("proyectoActualizado", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}else{
			Proyecto proyecto = (Proyecto)request.getSession().getAttribute("proyectoUpdate");
			ProyectoDao proyectoDao = new ProyectoDao();
			proyectoDao.delete(proyecto);
			
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			
			request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
			
			 request.getSession().setAttribute("proyectoActualizado", 1);
			 request.getSession().setAttribute("proyectoUpdate", null);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}
	}
}
