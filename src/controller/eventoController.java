package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DireccionproDao;
import model.EventoDao;
import model.GrupoieDao;
import negocio.Direccionpro;
import negocio.Evento;
import negocio.Grupoie;

/**
 * Servlet implementation class eventoController
 */
@WebServlet("/eventoController")
public class eventoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventoController() {
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
		String nombreEvento = request.getParameter("nombreEvento");		
		String caracterEvento = request.getParameter("caracterEvento");		
		String Responzable = request.getParameter("Responzable");
		String Institucion = request.getParameter("Institucion");
		String Entidades = request.getParameter("Entidades");
		String pogreso = request.getParameter("pogreso");
		Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
		System.out.println(aux.getNombre()+"1");
		String fecha[] = (request.getParameter("Fecha").split("-"));
		Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
		EventoDao eDao=new EventoDao();
		Evento evento = new Evento();
		evento.setCaracter(caracterEvento);
		evento.setFecha(datefin);
		evento.setInstitucion(Institucion);
		evento.setNombre(nombreEvento);
		evento.setParticipantes(Entidades);
		evento.setPorcentaje(Integer.valueOf(pogreso));
		evento.setResponzable(Responzable);
		evento.setGrupoie(aux);
		eDao.insert(evento);
		
		aux=new GrupoieDao().find(aux.getIdGrupoIE());
		request.getSession().setAttribute("eventos", aux.getEventos());
		request.getSession().setAttribute("grupoIE", aux);
		response.sendRedirect(request.getContextPath() + "/plan_de_accion_act.jsp");
	}

}
