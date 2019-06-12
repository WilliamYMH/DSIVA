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
import model.LineainvesrigacionDao;
import negocio.Direccionpro;
import negocio.Evento;
import negocio.Grupoie;
import negocio.Lineainvesrigacion;

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
		String tipoPost = request.getParameter("tipoPostEvento");
		
		if(tipoPost.equals("add")){
			String nombreEvento = request.getParameter("nombreEvento");		
			String caracterEvento = request.getParameter("caracterEvento");		
			String responsable = request.getParameter("Responsable");
			
			String progreso = request.getParameter("progreso");
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			//System.out.println(aux.getNombre()+"1");
			String fecha[] = (request.getParameter("fecha").split("-"));
			Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
			EventoDao eDao=new EventoDao();
			Evento evento = new Evento();
			evento.setCaracter(caracterEvento);
			evento.setFecha(datefin);			
			evento.setNombre(nombreEvento);		
			evento.setPorcentaje(Integer.valueOf(progreso));
			evento.setResponsable(responsable);
			evento.setGrupoie(aux);
			aux.addEvento(evento);
			eDao.insert(evento);
			
			request.getSession().setAttribute("grupoIE", aux);
			
			request.getSession().setAttribute("eventoActualizado", 1);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");	
			request.getSession().setAttribute("eventos", aux.getEventos());
			
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");	
			
		}else if(tipoPost.equals("update1")){
			
			int idEvento = Integer.parseInt(request.getParameter("evento_id"));
			EventoDao eventoDao = new EventoDao();
			Evento evento = eventoDao.find(idEvento);
			request.getSession().setAttribute("eventoUpdate", evento);
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			//request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}else if(tipoPost.equals("update2")){
			String nombreEvento = request.getParameter("nombreEvento");		
			String caracterEvento = request.getParameter("caracterEvento");		
			String Responzable = request.getParameter("Responsable");
			
			String progreso = request.getParameter("progreso");
			
			String fecha[] = (request.getParameter("fecha").split("-"));
			Date datefin = new Date(fecha[0]+"/"+fecha[1]+"/"+fecha[2]);
			EventoDao eDao=new EventoDao();
			Evento evento = (Evento)request.getSession().getAttribute("eventoUpdate");
			evento.setCaracter(caracterEvento);
			evento.setFecha(datefin);
			
			evento.setNombre(nombreEvento);
			
			evento.setPorcentaje(Integer.valueOf(progreso));
			evento.setResponsable(Responzable);
			eDao.update(evento);
			
			request.getSession().setAttribute("eventoUpdate", null);
			 
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			 request.getSession().setAttribute("eventoActualizado", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
			
		}else{
			Evento evento = (Evento)request.getSession().getAttribute("eventoUpdate");
			new EventoDao().delete(evento);
			
			Grupoie aux = (Grupoie) request.getSession().getAttribute("grupoIE");
			aux = new GrupoieDao().find(aux.getIdGrupoIE());
			aux.removeEvento(evento);
			
			request.getSession().setAttribute("eventoUpdate", null);
			request.getSession().setAttribute("grupoIE", aux);
			request.getSession().setAttribute("eventos", aux.getEventos());
			request.getSession().setAttribute("pageJS", "plan_accion_director_new.jsp");
			
			 request.getSession().setAttribute("eventoActualizado", 1);
			 //request.getRequestDispatcher("/indx_director.jsp").forward(request, response);
			 response.sendRedirect(request.getContextPath() + "/indx_director.jsp");
		}
		
	}

}
