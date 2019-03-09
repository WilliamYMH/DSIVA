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

import antlr.collections.impl.LList;
import model.GrupoieDao;
import model.LineainvesrigacionDao;
import model.OtraactividadDao;
import negocio.Grupoie;
import negocio.Lineainvesrigacion;
import negocio.Otraactividad;

/**
 * Servlet implementation class lineaController
 */
@WebServlet("/lineaController")
public class lineaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lineaController() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String nombreLinea = request.getParameter("nombreLinea");
		String lider = request.getParameter("lider");
		Grupoie aux =  (Grupoie) request.getSession().getAttribute("grupoIE");
		LineainvesrigacionDao lDao= new LineainvesrigacionDao();
		Lineainvesrigacion linea = new Lineainvesrigacion();
		linea.setLiderLinea(lider);
		linea.setLineaInvesrigacion(nombreLinea);
		Date date = new Date("2018/2/1");
			System.out.println(aux.getNombre());
		linea.setFecha(date);
		linea.setGrupoie(aux);
		lDao.insert(linea);
		
		request.getSession().setAttribute("lineasDeInvestigacion", aux.getLineainvesrigacions());
		request.getRequestDispatcher("/plan_de_accion_act.jsp").forward(request, response);
	}

}
