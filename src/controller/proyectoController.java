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
		HttpSession session = request.getSession(true);
		String nombreProyecto = request.getParameter("nombreProyecto");
		String objetivo = request.getParameter("objetivo");		
		String pogreso = request.getParameter("pogreso");
		String fecha1[] = (request.getParameter("fechaInicio").split("-"));
		String fecha[] = (request.getParameter("fechaFin").split("-"));
		Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
		Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
		Date dateinicio = new Date(fecha1[0]+"/"+fecha1[1]+"/"+fecha1[2]);
		ProyectoDao pDao=new ProyectoDao();
		Proyecto proyecto = new Proyecto();
		proyecto.setDescripcion("");
		proyecto.setFechaFin(datefin);
		proyecto.setFechaInicio(dateinicio);
		proyecto.setObjetivo(objetivo);
		proyecto.setPorcentaje(Integer.parseInt(pogreso));
		proyecto.setResponzable("");
		proyecto.setProyecto(nombreProyecto);
		proyecto.setLineainvesrigacion(aux.getLineainvesrigacions().get(0));
		pDao.insert(proyecto);	
		aux= new GrupoieDao().find(aux.getIdGrupoIE());
		request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
		
		request.getSession().setAttribute("grupoIE", aux);
		response.sendRedirect(request.getContextPath() + "/plan_de_accion_act.jsp");	}

}
