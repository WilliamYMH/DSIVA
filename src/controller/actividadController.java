package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GrupoieDao;
import model.OtraactividadDao;
import negocio.Grupoie;
import negocio.Otraactividad;

/**
 * Servlet implementation class actividadController
 */
@WebServlet("/actividadController")
public class actividadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public actividadController() {
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
		String nombre = request.getParameter("nombre");
		String respnzable = request.getParameter("responzable");		
		String producto = request.getParameter("producto");
		String progreso = request.getParameter("progreso");		
		String fecha[] = (request.getParameter("fechaInicio").split("-"));
		Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
		Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
		OtraactividadDao oDao = new OtraactividadDao();
		Otraactividad otraActividad = new Otraactividad();
		otraActividad.setNombre(nombre);
		otraActividad.setResponzable(respnzable);
		otraActividad.setFecha(datefin);
		otraActividad.setPorcentaje(Integer.valueOf(progreso));
		otraActividad.setGrupoie(aux);
		oDao.insert(otraActividad);
		
		aux= new GrupoieDao().find(aux.getIdGrupoIE());
		//System.out.println(aux.getLineainvesrigacions().size()+" - TAMANIO LINEAS");
		
			request.getSession().setAttribute("otrasActividades", aux.getOtraactividads());
			request.getSession().setAttribute("grupoIE", aux);
			response.sendRedirect(request.getContextPath() + "/plan_de_accion_act.jsp");

		
	}

}
